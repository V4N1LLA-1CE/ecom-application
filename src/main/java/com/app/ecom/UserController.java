package com.app.ecom;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * UserController
 */
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/api/users")
  public List<User> getAllUsers() {
    return userService.fetchAllUsers();
  }

  @PostMapping("/api/users")
  public void createUser(@RequestBody User user) {
    userService.createUser(user);
  }
}
