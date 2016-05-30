package apiTests.ApiLesson.apiHttpbin;



import apiTests.httpbinApi.responseClasses.GetResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by ANS on 13/05/16.
 */
public class TestRequests {

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testGetRequest() throws IOException, URISyntaxException {
        //SimpleRequests simpleRequests = new SimpleRequests();
        //GetResponse resp = simpleRequests.get();

        GetResponse getResponse = new GetResponse();

        getResponse.origin = "origin String alalalaala 923";
        getResponse.url = "https://gsdg.dg";


        String json = mapper.writeValueAsString(getResponse);
        System.out.println(json);

        //System.out.println(resp);

    }
}
