package berich.controller;

import berich.DTO.AssetsDTO;
import berich.service.AssetsService;
import berich.service.StockService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class AssetsController {

    private final AssetsService assetsService;
    private final StockService stockService = new StockService();

    @Autowired
    public AssetsController(AssetsService assetsService) {
        this.assetsService = assetsService;
    }

    @PostMapping("assets")
    public ResponseEntity<AssetsDTO> CreateAssets(@RequestBody int userCode){
        AssetsDTO assets = new AssetsDTO();
        assets.setUserCode(userCode);
        return ResponseEntity.ok().body(assetsService.save(assets));
    }

    @PatchMapping("assets")
    public ResponseEntity<AssetsDTO> UpdateAssets(@RequestBody AssetsDTO assets){

//        AssetsDTO as = assets;
        System.out.println(assets.getUserCode());
        System.out.println(assets.getDeposit());
        System.out.println("111111111111111111111111111111111111111111111111111111111");
        JSONArray arr = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("stock","삼성전자");
        obj.put("holds",8);
        obj.put("price",88000);
        obj.put("nowPrice",68000);
        arr.add(0,obj);
        System.out.println(arr.toString());
//        assets.setStocks();
        return ResponseEntity.ok().body(assetsService.save(assets));
    }

    @GetMapping("assets")
    public ResponseEntity<JSONObject> GetAssets(@RequestParam int userCode){
        JSONParser parser = new JSONParser();
        JSONArray stocks = new JSONArray();
        JSONArray newStocks = new JSONArray();

        JSONObject result = assetsService.getAssets(userCode);
        try{
            stocks = (JSONArray) parser.parse(result.get("stocks").toString());
            for(int i=0; i<stocks.size(); i++){
                JSONObject obj = (JSONObject) parser.parse(stocks.get(i).toString());

                String iscd = stockService.readByName(obj.get("stock").toString());
                obj.remove("nowPrice");
                obj.put("nowPrice", stockService.getTodayPrice(iscd).toString());

                newStocks.add(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        result.remove("stocks");
        result.put("stocks", newStocks);

//        result로 데이터베이스 업데이트해야함.

        return ResponseEntity.ok().body(result);
    }
}
