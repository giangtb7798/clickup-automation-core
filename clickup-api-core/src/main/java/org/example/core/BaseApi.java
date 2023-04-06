package org.example.core;

import com.google.gson.Gson;
import org.example.httprequest.HttpRequests;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class BaseApi extends HttpRequests {
    public String getJsonAsString() throws IOException {
        return getResponse().getBody().asString();
    }

    public BaseApi validateResponse(int statusCode) throws IOException {
        this.getResponse().then().log().ifValidationFails().statusCode(statusCode);
        return this;
    }
    public <T> Object saveResponseObject(Class<T> c) throws IOException {
        return parseJsonToModel(getJsonAsString(), c);
    }
    public <T> List <T>saveResponseListObject(Class<T[]> c) throws IOException {
        List<T> temp;
        temp = parseJsonToModelList(getJsonAsString(), c);
        return temp;
    }
    public <T> Object parseJsonToModel(String json, Class<T> c) throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(json, c);
    }
    public <T> List <T>parseJsonToModelList(String json, Class<T[]> c) throws IOException {
        Gson gson = new Gson();
        List list = Arrays.asList(c);
        return Arrays.asList(gson.fromJson(json, (Type) list));
    }
}
