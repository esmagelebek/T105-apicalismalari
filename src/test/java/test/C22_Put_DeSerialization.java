package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.internal.path.json.mapping.JsonPathGsonObjectDeserializer;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseUrl {
        /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */
      @Test
    public void put01(){

          //1-url ve body hazirla

          specJsonPlace.pathParams("pp1","posts","pp2",70);
          TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
            HashMap<String,Object> reqBody=testDataJsonPlaceHolder.requestBodyOlusturMap();
          System.out.println("reqBody Map:"+reqBody);

          //2-Expected data hazirla

          HashMap<String,Object> expDataMap=testDataJsonPlaceHolder.requestBodyOlusturMap();

          //3-Response'i kaydet

          Response response=given().
                            spec(specJsonPlace).
                            contentType(ContentType.JSON).
                            body(reqBody).
                            put("/{pp1}/{pp2}");
          response.prettyPrint();

          //4-Assertion
          // Not : Bizim hazirlamis oldugumuz Expected Data Map formatinda.
          // Bize response'dan donen Response Body ise Json formatinda
          // Ikisini Assert methodlari icerisinde kiyaslayabilmemiz icin oncelikle
          // response'i map formatina parse etmemiz gerekiyor.

          HashMap<String,Object> respMap=response.as(HashMap.class);
          assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());

          assertEquals(expDataMap.get("title"),respMap.get("title"));
          assertEquals(expDataMap.get("body"),respMap.get("body"));
          assertEquals(expDataMap.get("userId"),respMap.get("userId"));
          assertEquals(expDataMap.get("id"),respMap.get("id"));









      }

}
