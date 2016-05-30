package apiTests.httpbinApi;

import apiTests.httpbinApi.responseClasses.CookiesResponse;
import apiTests.httpbinApi.responseClasses.GetResponse;
import apiTests.httpbinApi.responseClasses.PostResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dima on 13.05.2016.
 */
public class TestREquests {

    ObjectMapper mapper = new ObjectMapper();
    List <NameValuePair> nvps = new ArrayList <NameValuePair>();

    @Test
    public void testGetREquest() throws IOException, URISyntaxException {
        SimpleRequests simpleRequests = new SimpleRequests();
        GetResponse resp = simpleRequests.get();
        System.out.println("+++++++" + resp.headers);
    }

    @Test
    public void testCookies() throws IOException, URISyntaxException {
        SimpleRequests simpleRequests = new SimpleRequests();
        CookiesResponse resp = simpleRequests.cookies();
        System.out.println("+++++++" + resp.ga);
    }

    @Test
    public void testSetCookies() throws IOException, URISyntaxException {
        //put to list more cookies
        nvps.add(new BasicNameValuePair("nikita", "telega"));
        nvps.add(new BasicNameValuePair("IDToken2", "password"));

        SimpleRequests simpleRequests = new SimpleRequests();
        CookiesResponse resp = simpleRequests.setCookies( nvps );
        System.out.println("+++++++" + resp.ga);
    }

    @Test
    public void testDeleteCookies() throws IOException, URISyntaxException {
        //put to list more cookies
        nvps.add(new BasicNameValuePair("Nikita", "telega"));
        nvps.add(new BasicNameValuePair("IDToken2", "password"));

        SimpleRequests simpleRequests = new SimpleRequests();
        CookiesResponse resp = simpleRequests.deleteCookies(nvps);
        System.out.println("+++++++" + resp.ga);
    }

    @Test
    public void testRenderHTML() throws IOException, URISyntaxException {
        SimpleRequests simpleRequests = new SimpleRequests();
        String resp = simpleRequests.renderHTML();
    }

    @Test
    public void testPost() throws IOException, URISyntaxException {
        //put to list more cookies
        nvps.add(new BasicNameValuePair("custname", "Dima"));
        nvps.add(new BasicNameValuePair("custtel", "0664208173"));

        SimpleRequests simpleRequests = new SimpleRequests();
        PostResponse resp = simpleRequests.post(nvps);
        System.out.println("+++++++" + resp.files);
    }
}
