/**
 * 
 * @author Dante Sanchez, Chris Gunn,  Hammaad Illyas
 * This class handles the HTTP calls to the Twitter endpoint, which are
 * initiated by the TwitterServlet.java class. First, the user's consumer
 * and access token keys are initialized. Then, there are 8 different
 * methods which handle the 8 different HTTP requests. Each method returns
 * the JSON response back to the TwitterServlet class.
 * 
 * 
 */

package mypackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.net.URLEncoder;

public class TwitterRestController {
	static String consumerKeyStr = "consumer key (hidden since our repo is public)";
	static String consumerSecretStr = "consumer secret key (hidden since our repo is public)";
	static String accessTokenStr = "access token (hidden since our repo is public)";
	static String accessTokenSecretStr = "access token secret (hidden since our repo is public)";
	static OAuthConsumer oAuthConsumer;

	public static void setOauth(){
		oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKeyStr,consumerSecretStr);
		oAuthConsumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);		
	}

	public static String searchUsers(String query){
		setOauth();
		try{
			HttpGet httpGet = new HttpGet("https://api.twitter.com/1.1/users/search.json?q=" + URLEncoder.encode(query, "UTF-8"));
			oAuthConsumer.sign(httpGet);

			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse httpResponse = httpClient.execute(httpGet);

			String response = httpResponse.getStatusLine().getStatusCode() + ":"+
				httpResponse.getStatusLine().getReasonPhrase() + 
				IOUtils.toString(httpResponse.getEntity().getContent());

			return response;
		} catch (Exception e){
			System.out.println("ERROR: " + e.getMessage());
			return "ERROR";
		}
	}

	public static String favoritesList(){
		setOauth();
		try{
			HttpGet httpGet = new HttpGet("https://api.twitter.com/1.1/favorites/list.json");
			oAuthConsumer.sign(httpGet);

			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse httpResponse = httpClient.execute(httpGet);			

			String response = httpResponse.getStatusLine().getStatusCode() + ":"+
				httpResponse.getStatusLine().getReasonPhrase() + 
				IOUtils.toString(httpResponse.getEntity().getContent());
			return response;
		} catch (Exception e){
			System.out.println("ERROR: " + e.getMessage());
			return "ERROR";
		}		
	}

	public static String friendships(){
		setOauth();
		try{
			HttpGet httpGet = new HttpGet("https://api.twitter.com/1.1/friends/ids.json");
			oAuthConsumer.sign(httpGet);

			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse httpResponse = httpClient.execute(httpGet);			

			String response = httpResponse.getStatusLine().getStatusCode() + ":"+
				httpResponse.getStatusLine().getReasonPhrase() + 
				IOUtils.toString(httpResponse.getEntity().getContent());
			return response;
		} catch (Exception e){
			System.out.println("ERROR: " + e.getMessage());
			return "ERROR";
		}		
	}	

	public static String suggestions(){
		setOauth();
		try{
			HttpGet httpGet = new HttpGet("https://api.twitter.com/1.1/users/suggestions.json");
			oAuthConsumer.sign(httpGet);

			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse httpResponse = httpClient.execute(httpGet);			

			String response = httpResponse.getStatusLine().getStatusCode() + ":"+
				httpResponse.getStatusLine().getReasonPhrase() + 
				IOUtils.toString(httpResponse.getEntity().getContent());
			return response;
		} catch (Exception e){
			System.out.println("ERROR: " + e.getMessage());
			return "ERROR";
		}		
	}	

	public static String help(){
		setOauth();
		try{
			HttpGet httpGet = new HttpGet("https://api.twitter.com/1.1/help/configuration.json");
			oAuthConsumer.sign(httpGet);

			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse httpResponse = httpClient.execute(httpGet);			

			String response = httpResponse.getStatusLine().getStatusCode() + ":"+
				httpResponse.getStatusLine().getReasonPhrase() + 
				IOUtils.toString(httpResponse.getEntity().getContent());
			return response;
		} catch (Exception e){
			System.out.println("ERROR: " + e.getMessage());
			return "ERROR";
		}		
	}

	public static String timeline(){
		setOauth();
		try{
			HttpGet httpGet = new HttpGet("https://api.twitter.com/1.1/statuses/user_timeline.json");
			oAuthConsumer.sign(httpGet);

			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse httpResponse = httpClient.execute(httpGet);			

			String response = httpResponse.getStatusLine().getStatusCode() + ":"+
				httpResponse.getStatusLine().getReasonPhrase() + 
				IOUtils.toString(httpResponse.getEntity().getContent());
			return response;
		} catch (Exception e){
			System.out.println("ERROR: " + e.getMessage());
			return "ERROR";
		}		
	}

	public static String trendsAvailable(){
		setOauth();
		try{
			HttpGet httpGet = new HttpGet("https://api.twitter.com/1.1/trends/available.json");
			oAuthConsumer.sign(httpGet);

			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse httpResponse = httpClient.execute(httpGet);			

			String response = httpResponse.getStatusLine().getStatusCode() + ":"+
				httpResponse.getStatusLine().getReasonPhrase() + 
				IOUtils.toString(httpResponse.getEntity().getContent());
			return response;
		} catch (Exception e){
			System.out.println("ERROR: " + e.getMessage());
			return "ERROR";
		}		
	}

	public static String searchTweets(String query){
		setOauth();
		try{
			HttpGet httpGet = new HttpGet("https://api.twitter.com/1.1/search/tweets.json?q=" + URLEncoder.encode(query, "UTF-8"));
			oAuthConsumer.sign(httpGet);

			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse httpResponse = httpClient.execute(httpGet);
			

			String response = httpResponse.getStatusLine().getStatusCode() + ":"+
				httpResponse.getStatusLine().getReasonPhrase() + 
				IOUtils.toString(httpResponse.getEntity().getContent());

			return response;
		} catch (Exception e){
			System.out.println("ERROR: " + e.getMessage());
			return "ERROR";
		}
	}

}