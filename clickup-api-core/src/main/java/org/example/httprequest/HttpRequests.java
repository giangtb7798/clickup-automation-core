package org.example.httprequest;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.Map;

public class HttpRequests extends HttpRequestClientFactory{

    public Response sendGet(String url, String pathParamName, String pathParamValue) throws IOException {
        RequestSpecification httpRequest = (new HttpRequestBuilder(pathParamName, pathParamValue)).create();
        Response res = httpRequest.when().get(url);
        this.setResponse(res);
        return res;
    }
    public static void setAuthorization(String token) throws IOException {
        reqSpec().header("Authorization", token);
    }
    public Response sendPost(String url, String body) throws IOException {
        Response res = reqSpec().header("Content-type", "application/json").body(body).post(url);
        this.setResponse(res);
        return res;
    }
    public Response sendPost(String url, Object body) throws IOException {
        Response res = reqSpec().header("Content-type", "application/json").body(body).post(url);
        this.setResponse(res);
        return res;
    }
    public Response sendPost(String url, Object body, Map<String, Object> pathParam) throws IOException {
        Response res = reqSpec().header("Content-type", "application/json").pathParams(pathParam).body(body).when().post(url);
        this.setResponse(res);
        return res;
    }
    public Response sendPost(String url, Object body, String pathParamName, String pathParamValue) throws IOException {
        RequestSpecification httpRequest = (new HttpRequestBuilder(pathParamName, pathParamValue, body)).create();
        Response res = httpRequest.header("Content-type", "application/json").when().post(url);
        this.setResponse(res);
        return res;
    }
    public Response sendPut(String url, Object body, String pathParamName, String pathParamValue) throws IOException {
        RequestSpecification httpRequest = (new HttpRequestBuilder(pathParamName, pathParamValue, body)).create();
        Response res = httpRequest.header("Content-type", "application/json").when().put(url);
        this.setResponse(res);
        return res;
    }
    public Response sendDelete(String url, Object body, String pathParamName, String pathParamValue) throws IOException {
        RequestSpecification httpRequest = (new HttpRequestBuilder(pathParamName, pathParamValue)).create();
        Response res = httpRequest.when().delete();
        this.setResponse(res);
        return res;
    }
    public Response sendDelete(String url, String pathParamName, String pathParamValue) throws IOException {
        RequestSpecification httpRequest = (new HttpRequestBuilder(pathParamName, pathParamValue)).create();
        Response res = httpRequest.when().delete(url);
        this.setResponse(res);
        return res;
    }
    private class HttpRequestBuilder {
        private String pathParamName;
        private String pathParamValue;
        private Object body;

        private RequestSpecification requestSpecification;

        public HttpRequestBuilder(String pathParamName, String pathParamValue) {
            this.pathParamName = pathParamName;
            this.pathParamValue = pathParamValue;
            this.body = null;
            this.requestSpecification = RestAssured.given().spec(HttpRequestClientFactory.reqSpec());
        }
        public HttpRequestBuilder(String pathParamName, String pathParamValue, Object body) {
            this.pathParamName = pathParamName;
            this.pathParamValue = pathParamValue;
            this.body = body;
            this.requestSpecification = RestAssured.given().spec(HttpRequestClientFactory.reqSpec());
        }

        public RequestSpecification create(){
            if(pathParamValue != null){
                this.requestSpecification.pathParams(this.pathParamName, this.pathParamValue);
            }
            if (body != null) {
                this.requestSpecification.body(this.body);
            }

            return this.requestSpecification;
        }
    }


}
