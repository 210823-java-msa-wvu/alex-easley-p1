package dev.easley.services;

import dev.easley.models.Employees;
import dev.easley.repos.UserRepo;

public class UserService {

    UserRepo userRepo = new UserRepo();

    public Employees getByUsername(String username) {
        return userRepo.getByUsername(username);
    }

    public boolean login(String username, String password) {

        Employees e = userRepo.getByUsername(username);


        if (e != null) {

            if (username.equals(e.getUsername()) && password.equals(e.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
