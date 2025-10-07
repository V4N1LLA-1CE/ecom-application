package com.app.ecom;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

  public Optional<User> fetchUser(Long id) {
    return userList.stream()
        .filter(user -> user.getId().equals(id))
        .findFirst();
  }
}
