/**
 * 
 * @author Chris Gunn, Dante Sanchez, Vijay Dhanota
 * This class handles GET and POST requests from the JSP pages and
 * calls TwitterRestController class to connect to the Twitter Endpoint.
 * Then these method render the corresponding JSP page and displays results
 * to the user.
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

import mypackage.TwitterRestController;

public class TwitterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/rest_calls.jsp").forward(req, resp);     
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action-type");

        if(action.equals("search-tweets")){
            req.setAttribute("response", TwitterRestController.searchTweets(req.getParameter("query")));
        } else if (action.equals("trends-available")){
            req.setAttribute("response", TwitterRestController.trendsAvailable());
        }else if (action.equals("search-users")){
            req.setAttribute("response", TwitterRestController.searchUsers(req.getParameter("query")));
        } else if(action.equals("favorites-list")) {
            req.setAttribute("response", TwitterRestController.favoritesList());
        } else if(action.equals("help")){
            req.setAttribute("response", TwitterRestController.help());
        } else if(action.equals("friendships")){
            req.setAttribute("response", TwitterRestController.friendships());
        } else if(action.equals("suggestions")){
            req.setAttribute("response", TwitterRestController.suggestions());
        } else if(action.equals("timeline")){
            req.setAttribute("response", TwitterRestController.timeline());
        }else{
            req.setAttribute("response", "Error.");
        }

        req.getRequestDispatcher("/WEB-INF/response.jsp").forward(req, resp);           
    }
}