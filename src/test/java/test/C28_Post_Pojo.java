package test;

import baseUrl.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.POJOJsonPlaceHolder;
import pojos.PojoHerokuappBooking;
import pojos.PojoHerokuappBookingDates;
import pojos.PojoHerokuappExpectedBody;

import static io.restassured.RestAssured.given;

public class C28_Post_Pojo extends HerokuappBaseUrl {
         /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
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
                        Response Body = Expected Data
                        {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */

    @Test
    public void post01(){

        //1-url ve body hazirla

     specHerokuapp.pathParam("pp1","booking");

        PojoHerokuappBookingDates bookingDates=new PojoHerokuappBookingDates("2021-06-01","2021-06-10");
        PojoHerokuappBooking  reqBody=new PojoHerokuappBooking("Ahmet","Bulut",500,false,"wi-fi",bookingDates);
        System.out.println("reqBody = " + reqBody);



        //2-expected body hazirla

        PojoHerokuappExpectedBody expBody=new PojoHerokuappExpectedBody(24,reqBody);
        System.out.println("expBody = " + expBody);


        //3-Response'i kaydet

        Response response=given().
                          spec(specHerokuapp).
                          contentType(ContentType.JSON).
                          when().
                          body(reqBody).
                          post("/{pp1}");


        //4-Assertion

        PojoHerokuappExpectedBody respPojo=response.as(PojoHerokuappExpectedBody.class);

        Assert.assertEquals(expBody.getBooking().getFirstname(),respPojo.getBooking().getFirstname());
        Assert.assertEquals(expBody.getBooking().getLastname(),respPojo.getBooking().getLastname());
        Assert.assertEquals(expBody.getBooking().getAdditionalneeds(),respPojo.getBooking().getAdditionalneeds());
        Assert.assertEquals(expBody.getBooking().getTotalprice(),respPojo.getBooking().getTotalprice());
        Assert.assertEquals(expBody.getBooking().isDepositpaid(),respPojo.getBooking().isDepositpaid());

        Assert.assertEquals(expBody.getBooking().getBookingdates().getCheckin(),respPojo.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(expBody.getBooking().getBookingdates().getCheckout(),respPojo.getBooking().getBookingdates().getCheckout());




    }

}
