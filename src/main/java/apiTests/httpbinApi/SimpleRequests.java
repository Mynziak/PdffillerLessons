package apiTests.httpbinApi;

import apiTests.httpbinApi.responseClasses.CookiesResponse;
import apiTests.httpbinApi.responseClasses.GetResponse;
import apiTests.httpbinApi.responseClasses.PostResponse;
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
import java.util.List;

/**
 * Created by Dima on 13.05.2016.
 */
public class SimpleRequests {

    ObjectMapper mapper = new ObjectMapper();

    public static String host = "httpbin.org";
    public static String scheme = "http";

    //   public URIBuilder uriBuilder =  new URIBuilder().setScheme(scheme).setHost(host).setParameter("device", device).setParameter("appKey", appKey);

    public URIBuilder getUriBuilder() {
        return new URIBuilder().setScheme(scheme).setHost(host);
    }

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

    public CookiesResponse cookies() throws IOException, URISyntaxException {
        URI uri = getUriBuilder().setPath("/cookies").build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = getResponseBody(resp);
        return mapper.readValue(respBody, CookiesResponse.class);
    }

    public CookiesResponse setCookies(List nameValuesList) throws IOException, URISyntaxException {
        URI uri = getUriBuilder().setPath("/cookies/set")
                .setParameters(nameValuesList)
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = getResponseBody(resp);
        return mapper.readValue(respBody, CookiesResponse.class);
    }

    public CookiesResponse deleteCookies(List nameValuesList) throws IOException, URISyntaxException {
        URI uri = getUriBuilder().setPath("/cookies/delete")
                .setParameters(nameValuesList)
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = getResponseBody(resp);
        return mapper.readValue(respBody, CookiesResponse.class);
    }

    public String renderHTML () throws IOException, URISyntaxException {
        URI uri = getUriBuilder().setPath("/html").build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        return getResponseBody(resp);
    }

    public PostResponse post(List nameValuesList) throws IOException, URISyntaxException {
        URI uri = getUriBuilder().setPath("/forms/post")
                .setParameters(nameValuesList)
                .build();
        System.out.println(uri);
        HttpResponse resp = Request.Get(uri).execute().returnResponse();
        String respBody = getResponseBody(resp);
        return mapper.readValue(respBody, PostResponse.class);
    }
}
