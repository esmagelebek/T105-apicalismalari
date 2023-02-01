package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {
       /*
    http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir
    PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

	        Request Body
           {
           "status":"success",
           "data":{
           "name":“Ahmet",
           "salary":"1230",
           "age":"44",
           "id":40
           }
           }

           Response Body
           "status":"success",
           "data":{
           "status":"success",
           "data":{
           "name":“Ahmet",
           "salary":"1230",
           "age":"44",
           "id":40}
           },
           "message":"Successfully!Record has been updated."}

       */
    @Test
    public void put01(){

        //1-url hazirla
        String url="http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject data=new JSONObject();
        data.put("name","Ahmet");
        data.put("salary","1230");
        data.put("age","44");
        data.put("id",40);
        JSONObject reqBody=new JSONObject();
        reqBody.put( "status","success");
        reqBody.put( "data",data);
        JSONObject expData=new JSONObject();
        expData.put("status","success");
        expData.put("data",reqBody);
        expData.put( "message","Successfully!Record has been updated.");

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);
        response.prettyPrint();


        JsonPath resJPath=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(resJPath.get("status"),expData.get("status"));
        softAssert.assertEquals(resJPath.get("message"),expData.get("message"));
        softAssert.assertEquals(resJPath.get("data.data.name"),expData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(resJPath.get("data.data.id"),expData.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(resJPath.get("data.data.salary"),expData.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(resJPath.get("data.data.age"),expData.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(resJPath.get("data.status"),expData.get("status"));
        softAssert.assertAll();



    }
}
