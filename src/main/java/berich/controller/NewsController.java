package berich.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class NewsController {

    @GetMapping("/news")
    public JSONArray getFinanceNews(){
        JSONArray result = new JSONArray();
        try{
            Document doc = Jsoup.connect("https://finance.naver.com/news/mainnews.naver").get();
            Elements el = doc.select("ul.newsList");

            for(Element e: el.select("dl")){
                JSONObject obj = new JSONObject();
                obj.put("link", e.select("dd.articleSubject").select("a").attr("href"));
                obj.put("title", e.select("dd.articleSubject").select("a").text());
                obj.put("text", e.select("dd.articleSummary").text());
                obj.put("source", e.select("dd.articleSummary").select("span.press").text());
                obj.put("date", e.select("dd.articleSummary").select("span.wdate").text());
                result.add(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
