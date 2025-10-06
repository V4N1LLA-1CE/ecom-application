package com.app.ecom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService {

  private Long counter = 1L;
  private List<User> userList = new ArrayList<>();

  public List<User> fetchAllUsers() {
    return userList;
  }

  public void createUser(User user) {
    user.setId(counter++);
    userList.add(user);
  }

  public User fetchUser(Long id) {
    for (User user : userList) {
      if (user.getId().equals(id)) {
        return user;
      }
    }

    return null;
  }
}
