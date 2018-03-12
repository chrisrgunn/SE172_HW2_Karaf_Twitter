/**
 * 
 * @author Hammaad Ilyas, Daanish Husain
 * This test class aims to test the Twitter Servlet, which is responsible for
 * handling the GET and POST requests of the JSP pages, which calls the 
 * TwitterRestController class to handle the requests.
 * 
 * 
 */

package mypackage;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;
import java.io.*;

// import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


import org.apache.commons.io.FileUtils;

import mypackage.TwitterServlet;

public class TwitterServletTest {
	private TwitterServlet servlet;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private RequestDispatcher reqDispatcher;

	@Before
	public void setUp(){
		servlet = new TwitterServlet();
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		reqDispatcher = mock(RequestDispatcher.class);		
	}

	@Test
	public void testServletGet() throws Exception{
        when(request.getRequestDispatcher("/WEB-INF/rest_calls.jsp")).thenReturn(reqDispatcher);
        servlet.doGet(request, response);

        // verify that getRequestDispatcher was actually called by the servlet
        verify(request).getRequestDispatcher("/WEB-INF/rest_calls.jsp");
	}

    @Test
    public void testServletPost() throws Exception {   
        when(request.getParameter("action-type")).thenReturn("search-tweets");
        when(request.getParameter("query")).thenReturn("hello");
        when(request.getRequestDispatcher("/WEB-INF/response.jsp")).thenReturn(reqDispatcher);

        servlet.doPost(request, response);

        // verify that the following were actually called by the servlet
        verify(request).getRequestDispatcher("/WEB-INF/response.jsp");
        verify(request).getParameter("query");
        verify(request).getParameter("action-type");
    }
}