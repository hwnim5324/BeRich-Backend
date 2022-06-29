package berich.controller;

import berich.DTO.StockDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BeRichController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("stocks")
    @ResponseBody
    public StockDTO StockApi(@RequestParam("name") String name){
        StockDTO stock = new StockDTO();
        stock.setSTCK_CLPR(123);
        stock.setSTCK_HGPR(123);
        stock.setSTCK_LWPR(123);
        stock.setSTCK_OPRC(123);
        return stock;
    }
}
