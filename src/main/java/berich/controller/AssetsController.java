package berich.controller;

import berich.DTO.AssetsDTO;
import berich.service.AssetsService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class AssetsController {

    private final AssetsService assetsService;

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
//        assetsService.getStocks(userCode)
        return ResponseEntity.ok().body(assetsService.getAssets(userCode));
    }
}
