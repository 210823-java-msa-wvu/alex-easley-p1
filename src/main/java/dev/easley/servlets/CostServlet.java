package dev.easley.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.easley.models.Requests;
import dev.easley.services.RequestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CostServlet extends HttpServlet {

    ObjectMapper om = new ObjectMapper();
    RequestService requestService = new RequestService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Requests r = om.readValue(request.getReader(), Requests.class);
        System.out.println(r);
        requestService.updateCosts(r);

    }
}
