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

  public boolean updateUser(Long id, User updatedUserDetails) {
    // get current user then update with new values
    return userList.stream()
        .filter(user -> user.getId().equals(id))
        .findFirst()
        .map(user -> {
          user.setFirstName(updatedUserDetails.getFirstName());
          user.setLastName(updatedUserDetails.getLastName());
          return true;
        })
        .orElse(false);
  }
}
