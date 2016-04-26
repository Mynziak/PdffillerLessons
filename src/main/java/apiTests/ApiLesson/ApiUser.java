package apiTests.ApiLesson;

import apiTests.ApiLesson.responseClasses.UserRegResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Dima on 26.04.2016.
 */
public class ApiUser extends MainApiClass {

    ObjectMapper objectMapper = new ObjectMapper();

    public UserRegResponse registration(String email, String password) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setPath("/api_v3/users/add")
                .setParameter("email", email)
                .setParameter("password", password)
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = getResponseBody(resp);


        UserRegResponse userRegResponse = objectMapper.readValue(respBody, UserRegResponse.class);



        return userRegResponse;
    }



}
