package berich.controller;

import berich.DTO.AssetsDTO;
import berich.DTO.OrderlistDTO;
import berich.DTO.UserDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@RestController
public class BeRichController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

}
