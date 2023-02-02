package test;

import baseUrl.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataHerokuapp;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_Post_TestDataKullanimi extends HerokuappBaseUrl {
      /*
      https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye
      sahip bir POST request gonderdigimizde donen response’un
      id haric asagidaki gibi oldugunu test edin



      	Request body     {
       "firstname" : "Ahmet",
      	"lastname" : “Bulut",
       "totalprice" : 500,
       "depositpaid" : false,
       "bookingdates" : {
        "checkin" : "2021-06-01",
        "checkout" : "2021-06-10"
      	    },
     "additionalneeds" : "wi-fi"
         }




         	Response Body{
        "bookingid":24,
        "booking":{
        "firstname":"Ahmet",
        "lastname":"Bulut",
        "totalprice":500,
        "depositpaid":false,
        "bookingdates":{
        "checkin":"2021-06-01",
        "checkout":"2021-06-10"
             },
        "additionalneeds":"wi-fi"
             }
             }
             */

    @Test
    public void post01(){
        //1-url ve body hazirla
        specHerokuapp.pathParam("pp1","booking");

        TestDataHerokuapp testDataHerokuapp=new TestDataHerokuapp();
        JSONObject requestBody=testDataHerokuapp.requestBodyJSON();


        //2-expected data hazirla

        JSONObject expData=testDataHerokuapp.expectedBodyJSON();
        //3-Response'i kaydet
        Response response=given().
                spec(specHerokuapp).
                contentType(ContentType.JSON).
                when().
                body(requestBody.toString()).post("/{pp1}");
        response.prettyPrint();

        //4-Assertion
        /*

        JsonPath resJsonPath=response.jsonPath();

        assertEquals(requestBody.getJSONObject("booking").get("firstname"),resJsonPath.get("booking.firstname"));
        assertEquals(requestBody.getJSONObject("booking").get("lastname"),resJsonPath.get("booking.lastname"));
        assertEquals(requestBody.getJSONObject("booking").get("additionalneeds"),resJsonPath.get("booking.additionalneeds"));
        assertEquals(requestBody.getJSONObject("booking").get("totalprice"),resJsonPath.get("booking.totalprice"));
        assertEquals(requestBody.getJSONObject("booking").get("depositpaid"),resJsonPath.get("booking.depositpaid"));
        assertEquals(requestBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJsonPath.get("booking.bookingdates.checkin"));
        assertEquals(requestBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJsonPath.get("booking.bookingdates.checkout"));

*/

        JsonPath resJSONP=response.jsonPath();
      // assertEquals(expData.get("bookingid"),resJP.get("bookingid"));

      assertEquals(expData.getJSONObject("booking").get("additionalneeds"),resJSONP.get("booking.additionalneeds"));
       assertEquals(expData.getJSONObject("booking").get("firstname"),resJSONP.get("booking.firstname"));
        assertEquals(expData.getJSONObject("booking").get("lastname"),resJSONP.get("booking.lastname"));
       assertEquals(expData.getJSONObject("booking").get("totalprice"),resJSONP.get("booking.totalprice"));
        assertEquals(expData.getJSONObject("booking").get("depositpaid"),resJSONP.get("booking.depositpaid"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJSONP.get("booking.bookingdates.checkin"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJSONP.get("booking.bookingdates.checkout"));





    }
}
