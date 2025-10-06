package com.app.ecom;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.fetchAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @PostMapping("/api/users")
  public ResponseEntity<Void> createUser(@RequestBody User user) {
    userService.createUser(user);
    return new ResponseEntity<>(null, HttpStatus.CREATED);
  }

  @GetMapping("/api/users/{id}")
  public ResponseEntity<User> getUser(@PathVariable Long id) {
    User user = userService.fetchUser(id);
    if (user == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(user);
  }
}
