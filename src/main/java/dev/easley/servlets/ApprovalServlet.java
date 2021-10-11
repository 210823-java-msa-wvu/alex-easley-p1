package dev.easley.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.easley.models.Approvals;
import dev.easley.models.Requests;
import dev.easley.services.ApprovalService;
import dev.easley.services.RequestService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApprovalServlet extends HttpServlet {

    ApprovalService approvalService = new ApprovalService();
    ObjectMapper om = new ObjectMapper();
    RequestService requestService = new RequestService();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("In approvals servlet");
        Approvals a = om.readValue(request.getReader(), Approvals.class);

        Cookie[] cookies=request.getCookies();
        String userTypeCookie = "";
        for (Cookie cookie : cookies) {

            if (cookie.getName().equals("userType")) {
                userTypeCookie = cookie.getValue();
                System.out.println(userTypeCookie);
            }
        }
            switch (userTypeCookie) {
                case "benco": {

                    approvalService.bcUpdate(a);
                    break;
                }
                case "supervisor": {
                    approvalService.dsUpdate(a);
                    break;
                }
                case "departmenthead": {

                    approvalService.dhUpdate(a);
                    break;
                }

            }
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Cookie[] cookies=request.getCookies();
        String userTypeCookie = "";
        String usernameCookie = "";
        Integer id = 0;

        for (Cookie cookie : cookies) {

            if (cookie.getName().equals("userType")) {
                userTypeCookie = cookie.getValue();
            }
            if (cookie.getName().equals("username")) {
                usernameCookie = cookie.getValue();
            }

            id = requestService.getByRequestUsername(usernameCookie);
        }
        System.out.println(userTypeCookie);
        if (userTypeCookie.equals("employee")) {
            System.out.println("here");
            response.setStatus(200);
            response.getWriter().write(om.writeValueAsString(approvalService.allApprovalsById(id)));
        }
        else {
            System.out.println("there");
            response.setStatus(200);
            response.getWriter().write(om.writeValueAsString(approvalService.allApprovals()));
        }

    }
}

