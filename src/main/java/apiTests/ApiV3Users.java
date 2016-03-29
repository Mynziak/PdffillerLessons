package apiTests;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by DimaM on 11/24/2015.
 */
public class ApiV3Users extends ApiV3 {


    public String token;
    public String userId;

    public String authUser(String email, String password) throws URISyntaxException, IOException {

        URI uri = uriBuilder.setPath("/api_v3/users/login")
                .setParameter("email", email)
                .setParameter("password", password)
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = EntityUtils.toString(resp.getEntity());
        System.out.println("RESPONSE: " + respBody);
        JSONObject obj = new JSONObject(respBody);
        token = obj.getString("token");
        userId = obj.getString("userId");
        // String pdfEmail = obj.getString("pdfEmail");
        return respBody;
    }

    public String currentTime(String userId) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setPath("/api_v3/users/currentTime")
                .setParameter("userId", userId)
                .setParameter("token", token)
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = EntityUtils.toString(resp.getEntity());
        System.out.println("RESPONSE: " + respBody);

        return respBody;

    }

    public String UpdatePass(String newPass) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setPath("/api_v3/users/updatePass")
                .setParameter("userId", userId)
                .setParameter("token", token)
                .setParameter("newPass", newPass)
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = EntityUtils.toString(resp.getEntity());
        System.out.println("RESPONSE: " + respBody);

        return respBody;
    }

    public String forgotPassword(String email) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setPath("/api_v3/users/forgotPassword")
                .setParameter("userId", userId)
                .setParameter("token", token)
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = EntityUtils.toString(resp.getEntity());
        System.out.println("RESPONSE: " + respBody);
        return respBody;
    }


    public String registration(String email, String password) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setPath("/api_v3/users/add")
                .setParameter("email", email)
                .setParameter("password", password)
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = EntityUtils.toString(resp.getEntity());
        System.out.println("RESPONSE: " + respBody);
        return respBody;
    }

    public String registrationLaravel(String email, String password) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setPath("/api_v3/users/laravelAdd")
                .setParameter("email", email)
                .setParameter("password", password)
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = EntityUtils.toString(resp.getEntity());
        System.out.println("RESPONSE: " + respBody);
        return respBody;
    }


    public String updateSubscribe(int isSubscribe) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setPath("/api_v3/users/updateSubscribe")
                .setParameter("userId", userId)
                .setParameter("token", token)
                .setParameter("isSubscribe", isSubscribe + "")
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = EntityUtils.toString(resp.getEntity());
        System.out.println("RESPONSE: " + respBody);
        return respBody;
    }

    public String newEmail(String newEmail) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setPath("/api_v3/users/newEmail/")
                .setParameter("userId", userId)
                .setParameter("token", token)
                .setParameter("new_email", newEmail)

                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = EntityUtils.toString(resp.getEntity());
        System.out.println("RESPONSE: " + respBody);
        return respBody;
    }

    public String getUserInfo() throws URISyntaxException, IOException {
        URI uri = uriBuilder.setPath("/api_v3/users/info")
                .setParameter("userId", userId)
                .setParameter("token", token)
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = EntityUtils.toString(resp.getEntity());
        System.out.println("RESPONSE: " + respBody);
        return respBody;
    }

 // Check Type of input params
    public String imageAdd(String sid, String name, String scale, String available, String width, String height, String signature ) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setPath("/api_v3/users/imageAdd")
                .setParameter("userId", userId)
                .setParameter("token", token)
                .setParameter("sid", sid )
                .setParameter("name", name)
                .setParameter("scale", scale)
                .setParameter("available", available)
                .setParameter("width", width)
                .setParameter("height", height)
                .setParameter("signature", signature)
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = EntityUtils.toString(resp.getEntity());
        System.out.println("RESPONSE: " + respBody);
        return respBody;
    }


    // Check Type of input params
    public String setDeviceToken (String deviceToken ) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setPath("/api_v3/users/imageAdd")
                .setParameter("userId", userId)
                .setParameter("token", token)
                .setParameter("deviceToken", deviceToken)
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = EntityUtils.toString(resp.getEntity());
        System.out.println("RESPONSE: " + respBody);
        return respBody;
    }



    //+++++++++++++++++++++++++++++++++++++++++++++++++Projects ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


    /**
     * Values:
     * @param nameSort может принимать 2 значения [filename|create_date]
     * @param typeSort может принимать 2 значения [asc|desc*]
     * @return array
     * */

    public String myBox (String nameSort, String typeSort ) throws URISyntaxException, IOException {


           URI uri = uriBuilder.setPath("/api_v3/users/mybox")
                .setParameter("userId", userId)
                .setParameter("token", token)
                .setParameter("nameSort", nameSort)
                .setParameter("typeSort", typeSort)
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = EntityUtils.toString(resp.getEntity());
        System.out.println("RESPONSE: " + respBody);
        return respBody;
    }
}
