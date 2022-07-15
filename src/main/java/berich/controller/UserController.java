package berich.controller;

import berich.DTO.UserDTO;
import berich.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> SignUp(@RequestBody UserDTO user){
        //assets 생성.
        return ResponseEntity.ok().body(userService.create(user));
    }

    @PostMapping("/login")
    public ResponseEntity<JSONObject> LogIn(@RequestBody UserDTO user){
        int result = userService.login(user.getUserId(),user.getPassword());
        JSONObject response = new JSONObject();

        response.put("result", result);
        if(result == 0) {
            int userCode = userService.readByUserId(user.getUserId()).get().getUsercode();
            response.put("userCode", userCode);
        }

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/users")
    public ResponseEntity<UserDTO> GetUser(@RequestParam int userCode){
        return ResponseEntity.ok().body(userService.readById(userCode).get());
    }

    @PatchMapping("/users")
    public ResponseEntity<UserDTO> UpdateUser(@RequestBody UserDTO user){
        return ResponseEntity.ok().body(userService.update(user.getUsercode(), user.getPassword()));
    }

//    @PatchMapping("/users")
//    public ResponseEntity<UserDTO> UpdateUserLike(@RequestBody UserDTO user){
//        return ResponseEntity.ok().body();
//    }

}
