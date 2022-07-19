package berich.service;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockService {

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

    public String transferWithKIS(int iscd){
        String URL = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-daily-itemchartprice";



        return "";
    }


}
