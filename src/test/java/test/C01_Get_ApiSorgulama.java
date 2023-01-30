package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C01_Get_ApiSorgulama {
       /*
        https://restful-booker.herokuapp.com/booking/9856 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
         */

      @Test
    public void get01(){

          //1-gonderecegimiz request icin gerekli olan url i ve ihtiyacimiz varsa body hazirlanir
          String url="https://restful-booker.herokuapp.com/booking/4846";

          //2-eger soruda bize verilmisse expected data hazirlanir
          //3-bize donen response i actual data olarak kaydederiz

          Response response=given().when().get(url);
          response.prettyPrint();
          System.out.println("Status code:"+response.getStatusCode());
          System.out.println("Content type:"+response.getContentType());
          System.out.println("Server Header'inin degeri:"+response.getHeader("Server"));
          System.out.println("Status Line'in degeri:"+response.getStatusLine());
          System.out.println("Response suresi:"+response.getTime());



          //4-expected data ile actual datanin karsilastirilmasi yani- Assertion




      }
}
