/* Author:     Noah Sims
 * Program:    Semester Project 1 - Weather API
 * Date:	   10/12/2019
 * Comments:
 * 		The WeatherApi class provides the getWeatherInfo method, which when given a zip code and country code,
 * 		makes an API request to the openweathermap.org API and returns weather information for the given location
 * 
 * 		getWeatherInfo returns null if the given location could not be found by the API
 * 		else, it returns a double[] with - the current temperature at [0] 
 * 										 - the low temperature at [1]
 * 										 - the high temperature at [2] 
 */

import java.net.*;
import java.io.*;
import com.google.gson.*;

public class WeatherApi 
{
	// given a zip code and country code, returns current weather information from the openweathermap API
	public static double[] getWeatherInfo(String countryCode, int zipCode)
	{
		double[] results = new double[3];
		// create the API endpoint url 
		String openWeatherApiZip = "http://api.openweathermap.org/data/2.5/weather?zip=";
		String openWeatherApiKey = "&APPID=91b887a6182bf715f30f6211243c5e23";
		String openWeatherApiUrl = openWeatherApiZip + zipCode + "," + countryCode + openWeatherApiKey;
		
		// get the JSON file
		String result = "";
		try 
		{
			// connect to the API endpoint
			URL url = new URL(openWeatherApiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			// get the response
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while((inputLine = reader.readLine()) != null)
			{
				content.append(inputLine);
			}
			
			reader.close();
			connection.disconnect();
			
			result = content.toString();
			
			// if the given zip code and country code could not be found by the API, return null
		} catch(IOException e) {
//			e.printStackTrace(); // debugging
			return null;
		} // end try
		
		// parse the JSON response
		JsonParser parser = new JsonParser();
		JsonObject mainObj = parser.parse(result).getAsJsonObject().get("main").getAsJsonObject();
		
		JsonElement tempEl = mainObj.get("temp");
		double temp = tempEl.getAsDouble();
		results[0] = kelvinToFar(temp);
		
		JsonElement minTempEl = mainObj.get("temp_min");
		double minTemp = minTempEl.getAsDouble();
		results[1] = kelvinToFar(minTemp);
		
		JsonElement maxTempEl = mainObj.get("temp_max");
		double maxTemp = maxTempEl.getAsDouble();
		results[2] = kelvinToFar(maxTemp);
		
		return results;
	} // end getWeatherInfo
	
	// converts a temperature in kelvin to degrees fahrenheit
	public static double kelvinToFar(double kTemp)
	{
		return (kTemp - 273.15) * (9.0 / 5.0) + 32;
	}
} // end WeatherApi
