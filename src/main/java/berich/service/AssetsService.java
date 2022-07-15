package berich.service;

import berich.DTO.AssetsDTO;
import berich.repository.JPAAssetsRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssetsService {
    private JPAAssetsRepository jpaassetsrepository;

    @Autowired
    public AssetsService(JPAAssetsRepository jpaassetsrepository) {
        this.jpaassetsrepository = jpaassetsrepository;
    }

    public AssetsDTO save(AssetsDTO assets){
        return jpaassetsrepository.save(assets);
    }
//
//    public AssetsDTO getAssets(int userCode){
//        AssetsDTO assets = readById(userCode).get();
//        String fromDB = assets.getStocks();
//        JSONParser parser = new JSONParser();
//
//        try{
//            JSONArray stocks = (JSONArray) parser.parse(fromDB);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return assets;
//    }

    public JSONObject getAssets(int userCode){
        AssetsDTO assets = readById(userCode).get();
        String fromDB = assets.getStocks();
        JSONParser parser = new JSONParser();
        JSONArray stocks = new JSONArray();

        try{
            stocks = (JSONArray) parser.parse(fromDB);
        }catch (Exception e){
            e.printStackTrace();
        }

        JSONObject result = new JSONObject();
        result.put("deposit", assets.getDeposit());
        result.put("stocks", stocks);

        return result;
    }

    public Optional<AssetsDTO> readById(int userCode){
        return jpaassetsrepository.findById(userCode);
    }

}
