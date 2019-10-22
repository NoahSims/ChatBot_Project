/* Author:     Noah Sims
 * Program:    Semester Project 1 - Spotify API
 * Date:	   10/12/2019
 * Comments:
 * 		The SpotifyApi class provides the getLatestRelease method, which when given the name of a musician
 * 		on Spotify, makes an API request to Spotify and returns the latest musical release from the given
 * 		artist with a link to said work's spotify page
 * 
 * 		getLatestRelease returns a String[] of length 1 containing an error message if the initial search for
 * 			the given artist fails to return any results
 * 		else, returns a String[] with - the artist name given by the search result at [0] 
 * 									  - the name of the latest work of music at [1] 
 * 									  - the date it was released at [2] 
 * 									  - the link to the latest work on Spotify at [3]
 */

import java.net.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import com.google.gson.*;

public class SpotifyApi 
{
	private static final Pattern pat = Pattern.compile(".*\"access_token\"\\s*:\\s*\"([^\"]+)\".*");
	private static final String clientId = "b5d47a2fe66e444c90caac4b5343666f";
	private static final String clientSecret = "9b2d11d9c8ac4165a9dcd4a8ce985a3b";
	private static final String spotifyTokenUrl = "https://accounts.spotify.com/api/token";
	private static final String spotifySearchUrl = "https://api.spotify.com/v1/search?q=";
	private static final String searchTypeArtist = "&type=artist";
	private static final String spotifyArtistUrl = "https://api.spotify.com/v1/artists/";
	private static final String artistAlbumEndpoint = "/albums?offset=0&limit=50&include_groups=album,single&country=us";
	private static final String auth = clientId + ":" + clientSecret;
	private static final String authentication = Base64.getEncoder().encodeToString(auth.getBytes());
	
	// given the name of a musician, returns that musician's latest work available on Spotify from the Spotify API
	public static String[] getLatestRelease(String artistName) 
			throws ParseException
	{
		String[] results;
		// get the access token necessary to access the Spotify API 
		String bearerToken = getBearerToken();
		
		// use the access token to search for the given artist using Spotify's "search" endpoint
		String searchResult = getJsonFile(bearerToken, createSearchUrl(artistName));
		
//		System.out.println(searchResult); // debugging
		
		// parse the JSON response to get the Spotify artist ID
		JsonParser parser = new JsonParser();
		
		// if numResults == 0, Spotify returned 0 results when searching for the given artist name
		// and a String[] of length one is returned with an error code
		int numResults = parser.parse(searchResult).getAsJsonObject().get("artists").getAsJsonObject().get("total").getAsInt();
		if(numResults == 0)
		{
			results = new String[1];
			results[0] = "No results found for \"" + artistName + '\"';
			return results;
		}
		
		// else get the artist ID
		JsonArray artistItems = parser.parse(searchResult).getAsJsonObject().get("artists").getAsJsonObject().get("items").getAsJsonArray();
		String artistId = artistItems.get(0).getAsJsonObject().get("id").getAsString();
		
		// get a list of albums from the Spotify "artists/{id}/albums" endpoint, using the artist ID
		String artistAlbumsUrl = spotifyArtistUrl + artistId + artistAlbumEndpoint;
		String albumsResult = getJsonFile(bearerToken, artistAlbumsUrl);
//		System.out.println(albumsResult.substring(0, 1000)); // debugging
		JsonArray artistAlbums = parser.parse(albumsResult).getAsJsonObject().get("items").getAsJsonArray();
		
		// check the dates of each album to find the most recent release
		SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
		Date latestReleaseDate = sdfo.parse(artistAlbums.get(0).getAsJsonObject().get("release_date").getAsString());
		int latestReleaseIndex = 0;
		for(int i = 1; i < artistAlbums.size(); i++)
		{
			try
			{
				Date indexReleaseDate = sdfo.parse(artistAlbums.get(i).getAsJsonObject().get("release_date").getAsString());
				if(latestReleaseDate.compareTo(indexReleaseDate) < 0)
				{
					latestReleaseDate = indexReleaseDate;
					latestReleaseIndex = i;
				}
			}catch(Exception e) {
				// some older albums from certain artists may not have a full release date in Spotify's database
				// and may, for instance, only have a year, causing an error. This try is necessary to catch this issue.
				// Newer releases shouldn't have this issue however, so any case where this error may be applicable may
				// be ignored as it won't be the latest release
			} // end try
		} // end for loop
		
		// return the results
		results = new String[4];
		results[0] = artistItems.get(0).getAsJsonObject().get("name").getAsString();
		results[1] = artistAlbums.get(latestReleaseIndex).getAsJsonObject().get("name").getAsString();
		results[2] = sdfo.format(latestReleaseDate);
		results[3] = artistAlbums.get(latestReleaseIndex).getAsJsonObject().get("external_urls").getAsJsonObject().get("spotify").getAsString();
		
		return results;
	} // end getLatestRelease
	
	// uses a set of client credentials to return an access token necessary to access the Spotify API
	private static String getBearerToken()
	{
		String content = "grant_type=client_credentials";
		BufferedReader reader = null;
		HttpURLConnection connection = null;
		String returnValue = "";
		
		try
		{
			// open the API connection and send the client credentials
			URL url = new URL(spotifyTokenUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Basic " + authentication);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Accept", "application/json");
			
			// get the response
			PrintStream os = new PrintStream(connection.getOutputStream());
			os.print(content);
			os.close();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = null;
			StringWriter out = new StringWriter(connection.getContentLength() > 0 ? connection.getContentLength() : 2048);
			while((line = reader.readLine()) != null)
			{
				out.append(line);
			}
			String response = out.toString();
			Matcher matcher = pat.matcher(response);
			if (matcher.matches() && matcher.groupCount() > 0)
			{
				returnValue = matcher.group(1);
			}
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if(reader != null)
			{
				try
				{
					reader.close();
				} catch(IOException e) {
				}
				connection.disconnect();
			} // end if
		} // end try - finally
		return returnValue;
	} // end getBearerToken
	
	// given the necessary access token and the desired API endpoint, returns the JSON file response as a String
	private static String getJsonFile(String bearerToken, String spotifyApiUrl)
	{
		BufferedReader reader = null;
		String response = null;
		try
		{
			// open the connection
			URL url = new URL(spotifyApiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", "Bearer " + bearerToken);
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			
			// get the response
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = null;
			StringWriter out = new StringWriter(connection.getContentLength() > 0 ? connection.getContentLength() : 2048);
			while((line = reader.readLine()) != null)
			{
				out.append(line);
			}
			response = out.toString();
//			System.out.println(response); // debugging
		}catch(Exception e) {
			
		} // end try
		return response;
	} // end getJsonFile
	
	// given the name of an artist, creates a formatted Spotify search query endpoint
	private static String createSearchUrl(String artistName)
	{
		String resultUrl;
		String artistQuery = artistName;
		// replace spaces in artistName with '+'
		for(int i = 0; i < artistQuery.length(); i++)
		{
			if(artistQuery.charAt(i) == ' ')
			{
				artistQuery = artistQuery.substring(0, i) + '+' + artistQuery.substring(i + 1);
			}
		}
		resultUrl = spotifySearchUrl + artistQuery + searchTypeArtist;
		return resultUrl;
	} // end createSearchUrl
} // end SpotifyApi
