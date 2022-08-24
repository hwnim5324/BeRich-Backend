package berich.controller;

import berich.service.StockService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class StockController {

    StockService stockservice = new StockService();

    @GetMapping("/stocks")
    public JSONArray getStockDataByPeriod(@RequestParam String isnm, String startDate, String endDate){
        String iscd = stockservice.readByName(isnm);
        return stockservice.getPricesByPeriod(iscd, startDate, endDate);
    }

    @GetMapping("/indexes")
    public JSONObject getIndexDataByCode(){
        JSONObject obj = new JSONObject();
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        String today = date.format(cal.getTime());

        obj.put("KOSPI", stockservice.getIndexes("0001", today, today));
        obj.put("KOSDAQ", stockservice.getIndexes("1001", today, today));
        return obj;
    }
}
