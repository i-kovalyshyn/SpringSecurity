package edu.cursor.spring_security.controler;

import edu.cursor.spring_security.model.User;
import edu.cursor.spring_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseBody
    @GetMapping("/user")
    public List<User> findAllUser() {
        return userService.findAllUsers();
    }

    @ResponseBody
    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @ResponseBody
    @DeleteMapping("/user/{username}")
    public void deleteUser(@PathVariable("username") String username) {
        userService.deleteByUserName(username);
    }

    @ResponseBody
    @PatchMapping("/user")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @ResponseBody
    @GetMapping("/user/id/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @ResponseBody
    @GetMapping("/user/{username}")
    public  Optional<User> findByUsername(@PathVariable("username") String username){
        return  userService.findByUsername(username);
    }

    @ResponseBody
    @GetMapping("/user/exists/{username}")
    public boolean existsByUsername(@PathVariable("username") String username) {

        return userService.existsByUsername(username);
    }
}
