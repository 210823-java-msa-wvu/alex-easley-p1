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
import java.io.PrintWriter;

public class RequestServlet extends HttpServlet {

    ObjectMapper om = new ObjectMapper();
    static RequestService requestService = new RequestService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("In Request Servlet");
        String path = (String) request.getAttribute("path");
        String userTypeCookie = "";
        String username = "";

        if (path == null || path.equals("")) {
            if ("POST".equals(request.getMethod())) {

                Cookie[] cookies = request.getCookies();


                for (Cookie c : cookies) {
                    if (c.getName().equals("userType")) {
                        userTypeCookie = c.getValue();
                    }
                    if (c.getName().equals("username")) {
                        username = c.getValue();
                    }
                }
                        Requests r = om.readValue(request.getReader(), Requests.class);
                        requestService.createRequest(r, username);



                    }

                }
            }



    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Requests r = om.readValue(request.getReader(), Requests.class);
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
        if (userTypeCookie.equals("employee")) {
            System.out.println(usernameCookie);
            Integer rID = requestService.getByRequestUsername(usernameCookie);

            response.getWriter().write(om.writeValueAsString(requestService.getByRequestId(rID)));

        } else {
            response.setStatus(200);
            response.getWriter().write(om.writeValueAsString(requestService.getAllRequests()));
        }
    }
}
//    public static void main(String[] args) {
//
//        String username = "Bob";
//
//        System.out.println(requestService.getByRequestUsername(username));
//    }
//}
//if(dateDifference < 14)
//        urgent = true;
//        else if(dateDifference > 31) { //solves the problem of having a few days difference between months
//        dateDifference = dateDifference - 70;
//        if(dateDifference <= 14)
//        urgent = true;
//        }
