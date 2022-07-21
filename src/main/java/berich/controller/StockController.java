package berich.controller;

import berich.service.StockService;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class StockController {

    StockService stockservice = new StockService();

    @GetMapping("/stocks")
    public JSONObject getStockData(@RequestParam String isnm){
        String iscd = stockservice.readByName(isnm);
        System.out.println(iscd);
        LocalDate date = LocalDate.now();
        String today = date.toString().replace("-","");
        System.gc();

        return stockservice.getStockPrice(iscd, today, today);
    }

}
