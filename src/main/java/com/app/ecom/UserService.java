package com.app.ecom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService {

  private List<User> userList = new ArrayList<>();

  public List<User> fetchAllUsers() {
    return userList;
  }

  public void createUser(User user) {
    userList.add(user);
  }
}
