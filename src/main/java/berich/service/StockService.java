package berich.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
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

    @Override
    public void finalize() throws Exception{
        System.out.println("소멸자 실행됨");
//        추후 토큰 폐기 코드 작성.
    }

    private String getTokenByKIS(){
        String KIS = "https://openapi.koreainvestment.com:9443/oauth2/tokenP";

        try{
            URL url = new URL(KIS);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            JSONObject requestBody = new JSONObject();

            requestBody.put("grant_type", "client_credentials");
            requestBody.put("appkey", SECRET.getAPPKEY());
            requestBody.put("appsecret", SECRET.getAPPSECRET());

            con.setRequestMethod("POST");
            con.setDoOutput(true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
            bw.write(requestBody.toString());
            bw.flush();
            bw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String response = br.readLine();

            JSONParser parser = new JSONParser();
            JSONObject obj = new JSONObject();

            obj = (JSONObject) parser.parse(response.toString());
            System.out.println("Get Token Success.");
            return "Bearer " + obj.get("access_token").toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Faild to get Token");
        return "Can't Find";
    }

    public String makeRightCode(String iscd){
        while(iscd.length()<6){
            iscd = '0' + iscd;
        }
        return iscd;
    }

    public String readByName(String isnm){
        String CSV_PATH = "C:/Users/hwnim/Desktop/BeRich_Backend/berich/build/resources/main/assets/StockList.csv";
        File csv = new File(CSV_PATH);
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(csv));
            String line = "";

            while((line=br.readLine()) != null){
                List<String> stringList;
                String stringArray[] = line.split(",");
                stringList = Arrays.asList(stringArray);
                if(stringList.get(2).equals(isnm)){
                    return makeRightCode(stringList.get(0));
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return "Can't Find";
    }

    public JSONObject getStockPrice(String iscd, String dateStart, String dateEnd){
        String KIS = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-daily-itemchartprice";
        JSONObject obj = new JSONObject();

        KIS = KIS + "?FID_COND_MRKT_DIV_CODE=J&FID_INPUT_ISCD=" + iscd
                + "&FID_INPUT_DATE_1=" + dateStart
                + "&FID_INPUT_DATE_2=" + dateEnd
                + "&FID_PERIOD_DIV_CODE=D&FID_ORG_ADJ_PRC=1";

        try{
            URL url = new URL(KIS);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("content-type", "application/json; charset=utf-8");
            con.setRequestProperty("Authorization", this.TOKEN);
            con.setRequestProperty("appkey", SECRET.getAPPKEY());
            con.setRequestProperty("appsecret", SECRET.getAPPSECRET());
            con.setRequestProperty("tr_id", "FHKST03010100");
            con.setRequestProperty("custtype", "P");

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String response = br.readLine();

            JSONParser parser = new JSONParser();
            obj = (JSONObject) parser.parse(response.toString());
            System.out.println("Get Data Success.");
            return obj;

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Faild to get Data");
        return obj;
    }





}
