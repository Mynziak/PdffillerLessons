package apiTests.ApiLesson;

import apiTests.ApiLesson.responseClasses.UserRegResponse;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Dima on 26.04.2016.
 */
public class TestApi {
    String email = "asdas@dsdfg.fdf";


    @Test
    public void testRegisterApi () throws IOException, URISyntaxException {
        ApiUser apiUser = new ApiUser();
      UserRegResponse userRegResponse =  apiUser.registration(email, "1");
        System.out.println(userRegResponse);
    }
}
