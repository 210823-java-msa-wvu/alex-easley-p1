package dev.easley.services;

import dev.easley.models.Employees;
import dev.easley.models.Requests;
import dev.easley.repos.RequestRepo;
import dev.easley.repos.UserRepo;
import dev.easley.servlets.RequestServlet;

import java.util.List;

public class RequestService {

    RequestRepo requestRepo = new RequestRepo();
    UserRepo userRepo = new UserRepo();

    public void updateCosts(Requests requests) {
        requestRepo.updateCost(requests);
    }

    public void createRequest(Requests request, String username) {

        Employees e = userRepo.getByUsername(username);
        if (request != null) {
            System.out.println("Creating Request...");
            requestRepo.add(request, e);
        }
    }

//    public void getCostandAvail(Integer Id, Integer id) {
//        requestRepo.getCostAndAvail(requests,id);
//    }

    public void deleteRequest(Requests request) {
        requestRepo.deleteRequest(request);
    }

    public List<Requests> getAllRequests() {

        return requestRepo.getAll();
    }

    public List<Requests> getByRequestId(Integer id) {

        return requestRepo.getAllById(id);
    }

    public Integer getByRequestUsername(String username) {
        return requestRepo.getAllByUsername(username);
    }

    public void updateGrade(Requests requests) {
        requestRepo.updateGrade(requests);
        System.out.println("in update grade");
    }
}
