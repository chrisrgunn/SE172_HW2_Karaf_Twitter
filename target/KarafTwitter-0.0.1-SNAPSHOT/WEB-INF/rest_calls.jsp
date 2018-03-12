<!-- Author: Vijay Dhanota, Daanish Husain
    This class shows buttons and input fields
    for the user to make 8 different HTTP calls for Twitter.
    Each button makes a POST request to the TwitterServlet.java class -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New</title>
    </head>
    <body>
        <h1>Twitter API's</h1>
        <br>

        <h2>Timelines</h2>
        <form name='input' action='/KarafTwitter/twitter-apis' method='post'>
            <b>status/timeline</b>&nbsp;<input type='hidden' name="action-type" value='timeline'/>&nbsp;
            <input type='submit' value='GET'/>
        </form>        
        <br><br>

        <h2>Friends &amp; Followers</h2>        
        <form name='input' action='/KarafTwitter/twitter-apis' method='post'>
            <b>friendships</b><input type='hidden' name="action-type" value='friendships'/>            
            <input type='submit' value='GET'/>
        </form> 
        <br><br>

        <h2>Trends</h2>        
        <form name='input' action='/KarafTwitter/twitter-apis' method='post'>
            <b>trends/available</b><input type='hidden' name="action-type" value='trends-available'/>
            <input type='submit' value='GET'/>
        </form> 
        <br><br>

        <h2>Tweet Search</h2>
        <p><b>search/tweets</b></p>
        <form name='input' action='/KarafTwitter/twitter-apis' method='post'>
        	Search Text: <input type='text' name='query'/>
        	<input type='hidden' name="action-type" value='search-tweets'/>&nbsp;
            <input type='submit' value='GET'/>
        </form>        
        <br><br>

        <h2>Favorites</h2>
        
        <form name='input' action='/KarafTwitter/twitter-apis' method='post'>
            <b>favorites/list</b>&nbsp;<input type='hidden' name="action-type" value='favorites-list'/>
            <input type='submit' value='GET'/>
        </form>        
        <br><br>

        <h2>Users</h2>
        <p><b>users/search</b></p>
        <form name='input' action='/KarafTwitter/twitter-apis' method='post'>
            Search Text: <input type='text' name='query'/>
            <input type='hidden' name="action-type" value='search-users'/>&nbsp;
            <input type='submit' value='GET'/>
        </form>        
        <br><br>

        <h2>Suggested Users</h2>        
        <form name='input' action='/KarafTwitter/twitter-apis' method='post'>
            <input type='hidden' name="action-type" value='suggestions'/>&nbsp;
            <b>users/suggestions</b>&nbsp;<input type='submit' value='GET'/>
        </form>        
        <br><br>        

        <h2>Help</h2>        
        <form name='input' action='/KarafTwitter/twitter-apis' method='post'>
            <b>help/configuration</b><input type='hidden' name="action-type" value='help'/>&nbsp;
            <input type='submit' value='GET'/>
        </form>        
        <br><br>        
    </body>
</html>