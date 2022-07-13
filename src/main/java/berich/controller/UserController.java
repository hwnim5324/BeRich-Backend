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
        return ResponseEntity.ok().body(userService.create(user));
    }

    @PostMapping("login")
    public ResponseEntity<Integer> LoginApi(@RequestBody UserDTO user){
        return ResponseEntity.ok().body(userService.login(user.getId(),user.getPassword()));
    }

    @GetMapping("")
    public ResponseEntity<String> GetLikeApi(@RequestParam int userCode){
        return ResponseEntity.ok().body(userService.readById(userCode).get().getLike());
    }
}
