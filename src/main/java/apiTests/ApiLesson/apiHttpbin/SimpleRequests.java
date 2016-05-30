package apiTests.ApiLesson.apiHttpbin;

import apiTests.httpbinApi.responseClasses.GetResponse;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by ANS on 13/05/16.
 */
public class SimpleRequests {

    ObjectMapper mapper = new ObjectMapper();



    public static String host = "httpbin.org";
    public static String scheme = "http"; // указать схему


    public URIBuilder getUriBuilder(){
        return new URIBuilder().setScheme(scheme).setHost(host);
    }
    // uriBuilder собирает из всех параметров один запрос

    public String getResponseBody(HttpResponse resp) throws ParseException, IOException {
        String respBody = EntityUtils.toString(resp.getEntity());
        int statusCode = resp.getStatusLine().getStatusCode();
        System.out.println("RESPONSE: " + respBody);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK, "Status code: " + statusCode);
        return respBody;
    }

    public GetResponse get() throws IOException, URISyntaxException {
        URI uri = getUriBuilder().setPath("/get").build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = getResponseBody(resp);
        return mapper.readValue(respBody, GetResponse.class);
    }











}
