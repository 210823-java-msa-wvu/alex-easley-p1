package dev.easley.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.easley.models.Approvals;
import dev.easley.models.Requests;
import dev.easley.services.RequestService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExtraServlet extends HttpServlet {

    ObjectMapper om = new ObjectMapper();
    RequestService requestService = new RequestService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("in extra servlet");
        Cookie[] cookies = request.getCookies();
        String userTypeCookie = "";
        String usernameCookie = "";
        for (Cookie cookie : cookies) {

            if (cookie.getName().equals("userType")) {
                userTypeCookie = cookie.getValue();
            }
            if (cookie.getName().equals("username")) {
                usernameCookie = cookie.getValue();
            }

        }
        if (userTypeCookie.equals("benco"))  {

            Requests r = om.readValue(request.getReader(), Requests.class);
            System.out.println(r);
            requestService.deleteRequest(r);


            //requestService.getCostandAvail(r, );
        }
        else {
            System.out.println("in extra do post");
            Requests r = om.readValue(request.getReader(), Requests.class);
            System.out.println("here");
            requestService.updateGrade(r);
        }
    }
}
