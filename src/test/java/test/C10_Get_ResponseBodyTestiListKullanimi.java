package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestiListKullanimi {
    /*
            http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
            donen Response'in
            status code'unun 200,
            ve content type'inin Aplication.JSON,
            ve response body'sindeki
                employees sayisinin 24
                ve employee'lerden birinin "Ashton Cox"
                ve girilen yaslar icinde 61,40 ve 30 degerlerinin oldugunu
            test edin.
     */
    @Test
    public void get01(){
        //1-url hazirla
        String url="http://dummy.restapiexample.com/api/v1/employees";
        //2-expecteddata hazirla
        //3-responsei kaaydet
        Response response=given().when().get(url);
        response.prettyPrint();
        //4-Assertion
        response.
                then().
                assertThat().statusCode(200).
                contentType("application/json").
                body("data.id", hasSize(24),
                        "data.employee_name",hasItem("Ashton Cox"),
                        "data.employee_age",hasItems(61,40,30));
        /*
          {
            "id": 1,
            "employee_name": "Tiger Nixon",
            "employee_salary": 320800,
            "employee_age": 61,
            "profile_image": ""
        }
         */
        //nkjsnjfsh

    }
}
