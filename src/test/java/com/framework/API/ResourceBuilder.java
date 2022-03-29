package com.framework.API;


import java.io.IOException;

import com.framework.ConfigReader.PropertyFileReader;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResourceBuilder {
    public static RequestSpecification req;
    public RequestSpecification requestSpecification() throws IOException {
        PropertyFileReader reader = new PropertyFileReader();  
        String baseURI = null;
        if(req==null) {		
            
            req=new RequestSpecBuilder()
                    .setBaseUri(baseURI)
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;	
    }
    public String getJsonPath(Response response,String key) {
        String resp=response.asString();
        JsonPath   js = new JsonPath(resp);
        return js.get(key).toString();
    }
    
}
