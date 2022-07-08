package berich.controller;

import berich.DTO.AssetsDTO;
import berich.DTO.StockDTO;
import berich.DTO.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@RestController
public class BeRichController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("stocks")
    public StockDTO StockApi(@RequestParam("name") String name){
        StockDTO stock = new StockDTO();
        stock.setSTCK_CLPR(123);
        stock.setSTCK_HGPR(123);
        stock.setSTCK_LWPR(123);
        stock.setSTCK_OPRC(123);
        return stock;
    }

    @PostMapping("login")
    public int LoginApi(@RequestBody UserDTO user){
        int statecode = 0;

        // codes to do

        return statecode;
    }

    @GetMapping("assets")
    public AssetsDTO AssetsApi(@RequestParam("userCode") String userCode){
        AssetsDTO assets = new AssetsDTO();

        //codes to do

        return assets;
    }

    @PatchMapping("assets")
    public AssetsDTO AssetsApi(@RequestBody AssetsDTO updated_Assets){
        AssetsDTO assets = new AssetsDTO();

        //codes to do

        return assets;
    }
}
