package dev.easley.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.easley.models.Employees;
import dev.easley.repos.UserRepo;
import dev.easley.services.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();
    ObjectMapper om = new ObjectMapper();
    UserRepo userRepo = new UserRepo();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
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
        resp.getWriter().write(om.writeValueAsString(userService.getByUsername(usernameCookie)));
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");


        try {
            Employees e = userRepo.getByUsername(username);
            String userType = e.getEmployeeType();

            String password = request.getParameter("password");
            boolean signInResponse = userService.login(username, password);
            if (signInResponse) {
                Cookie user = new Cookie("username", username);
                user.setMaxAge(60 * 60);
                response.addCookie(user);
                if (userType != null) {
                    Cookie utypecookie = new Cookie("userType", userType);
                    response.addCookie(utypecookie);
                    utypecookie.setMaxAge(60 * 60);

                switch (userType) {
                    case "employee": {
                        response.sendRedirect("/Project_1/employeepage.html");
                        break;
                    }
                    case "departmenthead": {
                        response.sendRedirect("/Project_1/departmentheadpage.html");
                        break;
                    }
                    case "benco": {
                        response.sendRedirect("/Project_1/bencopage.html");
                        break;
                    }
                    case "supervisor": {
                        response.sendRedirect("/Project_1/directsupervisorpage.html");
                        break;
                    }
                }
                }

            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Credentials");
            }
        }
            catch (NullPointerException n) {
                    n.printStackTrace();
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Credentials");
        }
    }
}
