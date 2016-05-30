package apiTests.ApiLesson;

import apiTests.httpbinApi.responseClasses.GetResponse;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Dima on 20.05.2016.
 */
public class MassiveMethods  {

    public String json = "{ users: [{ name: 123}, {name2: 233]}";

    ObjectMapper mapper = new ObjectMapper();

  @Test
    public void test() throws IOException, URISyntaxException {
       // String respBody = getResponseBody(resp);
       // System.out.println(mapper.readValue(json, MassivDataResponse.class));
      //MassivDataResponse s =  mapper.readValue(json, MassivDataResponse.class);


    }



}
