package apiTests;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by DimaM on 12/2/2015.
 */
public class TestAPIGetData {


    @Test
    public void getDataFromPdffiller () throws IOException {



        Request.Get("https://pdffiller.com").execute().returnResponse();
        HttpResponse resp = Request.Get("https://pdffiller.com").execute().returnResponse();
        String respBody = EntityUtils.toString(resp.getEntity());
        System.out.println(respBody);

    }
}
