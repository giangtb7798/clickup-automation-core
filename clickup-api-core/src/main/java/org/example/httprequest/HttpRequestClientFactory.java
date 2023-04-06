package org.example.httprequest;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class HttpRequestClientFactory {

    public static ThreadLocal<RequestSpecification> requestSpec = new ThreadLocal<>();
    public static ThreadLocal<Response> response = new ThreadLocal<>();
    public Response getResponse() throws IOException {
        return response.get();
    }
    public void setResponse(Response res) throws IOException {
        response.set(res);
    }

    public static void initReq(){
        setRequestSpecification(RestAssured.given());
    }
    public static void setAllUrl(String baseUri){
        reqSpec().baseUri(baseUri);
    }
    public static void setRequestSpecification(RequestSpecification requestSpecification) {
        requestSpec.set(requestSpecification.filter(new AllureRestAssured()));
    }
    public static RequestSpecification reqSpec(){
        return requestSpec.get();
    }
}
