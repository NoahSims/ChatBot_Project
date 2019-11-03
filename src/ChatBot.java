/* Author:     Noah Sims
 * Program:    Semester Project 1 - ChatBot with RESTful API
 * Date:	   10/12/2019
 * Comments:
 * 		This program creates an irc chatbot that makes use of RESTful API to allow users of an irc server
 * 		to request current weather data from the openweathermap.org's API and music data from spotify's API
 * 
 * 		ChatBot command list:
 * 		"!help" : outputs a list of the available commands to chat
 * 		"!time" : outputs the current time and date to chat
 * 		"!weather <zip code>, <country code>" : outputs the current temperature, as while as the high and
 * 			low temperatures for the given zip code, using the openweathermap.org API
 * 			- country codes are two letter abbreviations defined by ISO 3166-1, part of the ISO 3166 standard
 * 			- The United States, for example, is abbreviated to "us"
 * 		"!latestRelease <artist name>" : outputs the latest musical release from a given artist on Spotify,
 * 			making use of Spotify's API
 * 		"!exit" : disconnects the chatbot from the server
 * 			- this is only intended for developer use, making it easier to shut the bot down for updates
 * 			  and should be disabled in the case of an official release
 */
import org.jibble.pircbot.*;

public class ChatBot extends PircBot 
{
	public static void main(String[] args)
	{
		// server information
		String server = "irc.freenode.net";
		String botNick = "ngs170000_Bot";
		String channel = "#ngs170000BotTesting";
		
		// create the chatbot
		ChatBot chatBot = new ChatBot(botNick);
		chatBot.setVerbose(true);
		
		// connect chatbot to the server
		try
		{
			chatBot.connect(server);
		}
		catch (Exception e)
		{
			System.out.print("Can't connect: " + e);
			return;
		}
		chatBot.joinChannel(channel);
	}
	
	public ChatBot()
	{
		setName("MyChatBot");
	}
	
	public ChatBot(String botName)
	{
		setName(botName);
	}
	
	// onMessage defines what commands the chatbot responds to and how it responds
	public void onMessage(String channel, String sender, String login, String hostname, String message)
	{
		// !help : display a list of available commands
		if(message.contains("!help"))
		{
			sendMessage(channel, sender + ": bot commands: ");
			sendMessage(channel, "\"!help\" : displays this list");
			sendMessage(channel, "\"!time\" : displays the current time");
			sendMessage(channel, "\"!weather <zipcode>, <country code>\" : displays the current tempurature for the given zipcode");
			sendMessage(channel, "\"!latestRelease <artist name>\" : displays the latest release a musical artist has released on spotify and links to the spotify page");
		} // end !help
		
		// !time : displays the current time and date
		if(message.contains("!time"))
		{
			String time = new java.util.Date().toString();
			sendMessage(channel, sender + ": " + time);
		} // end !time
		
		// !weather <zip code>, <country code> : displays the current temperature
		if(message.contains("!weather")) 
		{
			String countryCode;
			int zipCode;
			// get the zip code and country code from the chat message
			try
			{
				// get zip code
				int zipStartPos = message.indexOf("!weather") + "!weather ".length();
				int zipEndPos = message.indexOf(',', zipStartPos);
				String zipString = message.substring(zipStartPos, zipEndPos);
				zipCode = Integer.valueOf(zipString);
				
				//get country code
				countryCode = message.substring(zipEndPos + 2, zipEndPos + 4);
				
				// the only way there would be an exception here is if the user didn't use the command with proper formatting
			} catch(Exception e){
				sendMessage(channel, sender + ": Invalid format, weather command is \"!weather <zip code>, <country code>\"");
				return;
			} // end try
			
			// get the weather data for the given location form the openweathermap API
			double[] weatherInfo = WeatherApi.getWeatherInfo(countryCode, zipCode);
			// getWeatherInfo returns null if the given location could not be found
			if(weatherInfo == null)
			{
				sendMessage(channel, sender + ": weather info for " + zipCode + " could not be found");
				return;
			}
			// else, getWetherInfo returns current temperature in weatherInfo[0], low temperature in [1], and high temperature in [2]
			
			// display the results from the API
			sendMessage(channel, sender + ": The current tempurature for " + zipCode + " is " + Math.round(weatherInfo[0]) 
				+ " F, with a low of " + Math.round(weatherInfo[1]) + " F and a high of " + Math.round(weatherInfo[2]) + " F");
		} // end !weather
		
		// !latestRelease <artist name> : displays the latest spotify release from a given artist and links to the spotify page
		if(message.contains("!latestRelease"))
		{
			// get the artist name from the user's message
			String artistName = "";
			try
			{
				artistName = message.substring(message.indexOf("!latestRelease") + "!latestRelease ".length()).trim();
				// throws an exception if the user calls !latestRelease without an artist name after it
			}catch(Exception e) {
				sendMessage(channel, sender + ": Invalid format, latestRelease format is \"!latestRelease <artist name>\"");
				return;
			} // end try
			
			// get the latest release from the API
			try
			{
				String[] latestRelease = SpotifyApi.getLatestRelease(artistName);
				// getLatestRelease returns a String[] of length 1 containing an error message if an error occurs
				if(latestRelease.length == 1)
				{
					sendMessage(channel, sender + ": " + latestRelease[0]);
					return;
				}
				
				// if the user did not type the exact artist name, spotify returns the latest release for the closest match from the search results
				if(!latestRelease[0].equalsIgnoreCase(artistName))
				{
					sendMessage(channel, sender + ": Search results returned: " + latestRelease[0]);
				}
				
				// display the results from the API
				// getLatestRelease returns a String[] with the artist's name at [0], the title of the release at [1], 
				// the date of the release at [2], and the link to the spotify page of the release at [3]
				sendMessage(channel, sender + ": The latest release from " + latestRelease[0] + " is " + latestRelease[1] + ", released on " + latestRelease[2]);
				sendMessage(channel, latestRelease[1] + " by " + latestRelease[0] + ": " + latestRelease[3]);
			}catch(Exception e) {
				// there shouldn't be any exceptions that come from this section, but getLatestRelease throws
				// a parse exception due to java.text.simpleDateFormat, so this is necessary for the method to function
			} // end try
		} // end !latestRelease
		
		// disconnects the bot from the server and terminates the program
		if(message.equalsIgnoreCase("!exit"))
		{
			this.disconnect();
			System.exit(0);
		} // end !exit
	} // end onMessage
}// end ChatBot
