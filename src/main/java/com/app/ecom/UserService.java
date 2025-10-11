package com.app.ecom;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * UserService
 */
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public List<User> fetchAllUsers() {
    return userRepository.findAll();
  }

  public void createUser(User user) {
    userRepository.save(user);
  }

  public Optional<User> fetchUser(Long id) {
    return userRepository.findById(id);
  }

  public boolean updateUser(Long id, User updatedUserDetails) {
    // get current user then update with new values
    return userRepository.findById(id)
        .map(user -> {
          user.setFirstName(updatedUserDetails.getFirstName());
          user.setLastName(updatedUserDetails.getLastName());
          userRepository.save(user);
          return true;
        })
        .orElse(false);
  }
}
