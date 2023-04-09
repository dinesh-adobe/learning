package dinesh.learning.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.auth.core.AuthenticationSupport;
import org.apache.sling.auth.core.spi.AuthenticationInfo;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = {Servlet.class})
@SlingServletPaths(value = "/bin/authenicate/user")
public class AuthenicateUserProcess extends SlingSafeMethodsServlet {

    @Reference
    private AuthenticationSupport authenticationSupport;

    @Reference
    private AuthenticationInfo authenticationInfo;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
/*
        if (authenticationSupport.isAuthenticated(request)) {
            // User is authenticated, do something
            response.getWriter().println("User is authenticated");
        } else {
            // User is not authenticated, authenticate them
            if (authenticateUser(request)) {
                // Authentication successful, do something
                response.getWriter().println("User authenticated successfully");
            } else {
                // Authentication failed, do something
                response.getWriter().println("User authentication failed");
            }
        }
    }


    private boolean authenticateUser(SlingHttpServletRequest request) {
        // Get the username and password from the request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Create an AuthenticationInfo object with the user's credentials
        AuthenticationInfo authInfo = new AuthenticationInfo("form", username, password.toCharArray());

        // Authenticate the user
        return authenticationSupport.authenticate(request, response, authInfo);
    }*/
    }
}
