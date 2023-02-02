package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_DeSerialization extends JsonPlaceHolderBaseUrl {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e
    sahip bir PUT request yolladigimizda donen response’in response
     body’sinin asagida verilen ile ayni oldugunu test ediniz



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

          //2-Expected data hazirla

          HashMap<String,Object> expDataMap=testDataJsonPlaceHolder.requestBodyOlusturMap();

          //3-Response'i kaydet

          Response response=given().
                  spec(specJsonPlace).
                  contentType(ContentType.JSON).
                  body(reqBody).
                  put("/{pp1}/{pp2}");


          //4-Assertion

          HashMap<String,Object> respMap=response.as(HashMap.class);
          assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());

          assertEquals(expDataMap.get("title"),respMap.get("title"));
          assertEquals(expDataMap.get("body"),respMap.get("body"));
          assertEquals(expDataMap.get("userId"),respMap.get("userId"));
          assertEquals(expDataMap.get("id"),respMap.get("id"));








      }


}
