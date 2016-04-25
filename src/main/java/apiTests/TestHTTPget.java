package apiTests;


import org.apache.commons.logging.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;

import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Created by Dima on 19.04.2016.
 */
public class TestHTTPget {

    public static String domen = "https://pdffiller.com";

    @Test
    public void testApi () throws IOException {
         HttpResponse resp = Request.Get("https://kismia.com").execute().returnResponse();
        System.out.println(EntityUtils.toString(resp.getEntity()));
        EntityUtils.toString(resp.getEntity());




    }


}
