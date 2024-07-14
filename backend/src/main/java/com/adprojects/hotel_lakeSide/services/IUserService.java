package com.adprojects.hotel_lakeSide.services;

import com.adprojects.hotel_lakeSide.models.User;

import java.util.List;

/**
 * @author Ameya Deshmukh
 */

public interface IUserService {
    User registerUser(User user);
    List<User> getUsers();
    void deleteUser(String email);
    User getUser(String email);
}