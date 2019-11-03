# ChatBot_Project
A chatbot that can connect to a chat server, giving server members commands to get information from external APIs.
Currently the chatbot is set to connect to http://webchat.freenode.net/, using the channel #ngs170000BotTesting, however
this can be configured in the SpotifyApi.java file.

ChatBot command list:

	"!help" : outputs a list of the available commands to chat
	"!time" : outputs the current time and date to chat
	"!weather <zip code>, <country code>" : outputs the current temperature, as while as the high and
		low temperatures for the given zip code, using the openweathermap.org API
		- country codes are two letter abbreviations defined by ISO 3166-1, part of the ISO 3166 standard
		- The United States, for example, is abbreviated to "us"
	"!latestRelease <artist name>" : outputs the latest musical release from a given artist on Spotify,
		making use of Spotify's API
	"!exit" : disconnects the chatbot from the server
		- this is only intended for developer use, making it easier to shut the bot down for updates
		  and should be disabled in the case of an official release

Chatbot commands in use:

![alt text](https://github.com/NoahSims/ChatBot_Project/blob/master/src/Images/ChatbotWeatherExample.PNG "!weather command example")

![alt text](https://github.com/NoahSims/ChatBot_Project/blob/master/src/Images/ChatbotSpotifyExample.PNG "!latestRelease command example")
