/*
package apiTests.vacancyTest;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

import java.io.IOException;

*/
/**
 * Created by Dima on 04.07.2016.
 *//*

public class ApiClass {

    public static String host = "www.api.pdffiller.com";
    public static String scheme = "https";

    public static String token ="nCi1Ymp5imCl3tbIGgx6E4ohV8IYAfgVlfC1pbFU";  // rename
    public static String device = "web";


    public URIBuilder uriBuilder =  new URIBuilder().setScheme(scheme).setHost(host).setParameter("device", device).setParameter("appKey", appKey);

    public String getResponseBody(HttpResponse resp) throws ParseException, IOException {
        String respBody = EntityUtils.toString(resp.getEntity());
        int statusCode = resp.getStatusLine().getStatusCode();
        System.out.println("RESPONSE: "+respBody);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK, "Status code: " + statusCode);
        return respBody;
    }
}


*/
