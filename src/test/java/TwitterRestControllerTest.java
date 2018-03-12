/**
 * 
 * @author Daanish Husain, Hammaad Ilyas
 * This test class aims to test all of the 8 HTTP Twitter calls from the TwitterRestController class
 * There is one test method (sometimes multiple test cases) for each of the 8 
 * HTTP calls.
 * 
 */

package mypackage;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import mypackage.TwitterServlet;

public class TwitterRestControllerTest {
	
	@Test	
	public void testSearchUsersSuccess() {
		String response = TwitterRestController.searchUsers("hello");
		assertEquals("200",response.substring(0,3));
	}

	@Test 
	public void testSearchUsersFailure(){
		// empty string should return an error
		String response = TwitterRestController.searchUsers("");
		assertEquals("400",response.substring(0,3));
	}

	@Test
	public void testFavoritesList(){
		String response = TwitterRestController.favoritesList();
		assertEquals("200",response.substring(0,3));
	}

	@Test
	public void testFriendships(){
		String response = TwitterRestController.friendships();
		assertEquals("200",response.substring(0,3));		
	}

	@Test
	public void testSuggestions(){
		String response = TwitterRestController.suggestions();
		assertEquals("200",response.substring(0,3));
	}

	@Test
	public void testHelp(){
		String response = TwitterRestController.help();
		assertEquals("200",response.substring(0,3));
	}

	@Test
	public void testTimeline(){
		String response = TwitterRestController.timeline();
		assertEquals("200",response.substring(0,3));
	}

	@Test
	public void testTrendsAvailable(){
		String response = TwitterRestController.trendsAvailable();
		assertEquals("200",response.substring(0,3));
	}

	@Test
	public void testSearchTweetsSuccess(){
		String response = TwitterRestController.searchTweets("hello");
		assertEquals("200",response.substring(0,3));
	}		

	@Test
	public void testSearchTweetsFailure(){
		// empty string should return an error
		String response = TwitterRestController.searchTweets("");
		assertEquals("400",response.substring(0,3));
	}	

}