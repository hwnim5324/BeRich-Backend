package berich.controller;

import berich.DTO.UserDTO;
import berich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signup")
    public ResponseEntity<UserDTO> SignupApi(@RequestBody UserDTO user){
        System.out.println(user);
        return ResponseEntity.ok()
                .body(userService.create(user));
    }
}
