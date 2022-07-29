package berich.controller;

import berich.service.StockService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class StockController {

    StockService stockservice = new StockService();

    @GetMapping("/stocks")
    public JSONArray getStockDataByPeriod(@RequestParam String isnm, String startDate, String endDate){
        String iscd = stockservice.readByName(isnm);
        return stockservice.getPricesByPeriod(iscd, startDate, endDate);
    }
}
