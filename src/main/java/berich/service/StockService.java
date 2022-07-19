package berich.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockService {
    private static Secret SECRET = new Secret();
    private String TOKEN = "";

    public StockService() {
        this.TOKEN = getTokenByKIS();
    }

    private String getTokenByKIS(){
        String KIS = "https://openapi.koreainvestment.com:9443/oauth2/tokenP";

        try{
            URL url = new URL(KIS);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("grant_type", "client_credentials");
            con.setRequestProperty("appkey", SECRET.getAPPKEY());
            con.setRequestProperty("appsecret", SECRET.getAPPSECRET());

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String response = br.readLine();

            JSONParser parser = new JSONParser();
            JSONObject obj = new JSONObject();

            obj = (JSONObject) parser.parse(response.toString());
            System.out.println("Get Token Success.");
            return obj.get("access_token").toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Faild to get Token");
        return "Can't Find";
    }

    public String readByName(String isnm){
        String CSV_PATH = "../../../resources/assets/StockList.csv";
        BufferedReader br = null;
        try{
            br = Files.newBufferedReader(Paths.get(CSV_PATH));
            String line = "";

            while((line=br.readLine()) != null){
                List<String> stringList;
                String stringArray[] = line.split(",");
                stringList = Arrays.asList(stringArray);

                if(stringList.get(2).equals(isnm)){
                    return stringList.get(0);
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return "Can't Find";
    }

    public String getStockPrice(int iscd){

        return "";
    }




}
