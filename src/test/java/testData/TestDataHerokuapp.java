package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataHerokuapp {

    public JSONObject inner(){


        JSONObject innerBody = new JSONObject();


        innerBody.put("checkin", "2021-06-01");
        innerBody.put("checkout", "2021-06-10");

        return innerBody;
    }

    public JSONObject requestBodyJSON (){
        JSONObject reqBody = new JSONObject();


        reqBody.put("firstname" , "Ahmet");
        reqBody.put("lastname" , "Bulut");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates" ,inner());
        reqBody.put("additionalneeds" , "wi-fi");

        return reqBody;
    }
    public JSONObject expectedBodyJSON(){
        JSONObject expectedBody=new JSONObject();

        expectedBody.put("bookingid",24);
        expectedBody.put("booking",requestBodyJSON());
        return expectedBody;
    }

    public HashMap bookingDatesOlusturMap(){
        HashMap<String,Object> bookingdates=new HashMap<>();
        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout","2021-06-10");


        return bookingdates;
    }

    public HashMap bookingOlusturMap(){
        HashMap<String,Object> booking=new HashMap<>();
        /*
         "firstname" : "Ali",
        "lastname" : "Bak",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
         */
        booking.put( "firstname" , "Ali");
        booking.put("lastname" ,"Bak");
        booking.put("totalprice" , 500.0);
        booking.put( "depositpaid" , false);
        booking.put("additionalneeds" ,"wi-fi");
        booking.put( "bookingdates",bookingDatesOlusturMap());


        return booking;
    }
    public HashMap expBodyOlusturMap(){
        HashMap<String,Object> expBodyMap=new HashMap<>();
        expBodyMap.put( "bookingid",24.0);
        expBodyMap.put("booking" , bookingOlusturMap());


        return expBodyMap;
    }


}
