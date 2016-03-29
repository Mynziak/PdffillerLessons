package apiTests;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by DimaM on 11/24/2015.
 */
public class ApiTest {

    ApiV3Users apiV3Users = new ApiV3Users();
    String email = "dmitry.mqwre@pdffiller.com";
    String password = "111";
   // String arrayExaple = "[{\"clone_state\":\"0\",\"created\":\"10:57 am\",\"date\":\"2015-11-03 10:57:58\",\"filename\":\"fw9  2014 - Form W-9 (Rev. December 2014)\",\"fileType\":\"pdf\",\"folder_id\":-20,\"form_id\":6962253,\"system_id\":20210595,\"user_id\":10989184,\"status\":{\"code\":3,\"text\":\"\"}},{\"clone_state\":\"0\",\"created\":\"10:58 am\",\"date\":\"2015-11-03 10:58:05\",\"filename\":\"Guidebook_for_PDFfiller_on_Mobile\",\"fileType\":\"pdf\",\"folder_id\":-20,\"form_id\":15774449,\"system_id\":20210596,\"user_id\":10989184,\"status\":{\"code\":2,\"text\":\"\"}},{\"clone_state\":\"0\",\"created\":\"10:58 am\",\"date\":\"2015-11-03 10:58:05\",\"filename\":\"Welcome_to_PDFfiller\",\"fileType\":\"pdf\",\"folder_id\":-20,\"form_id\":100109021,\"system_id\":20210597,\"user_id\":10989184,\"status\":{\"code\":2,\"text\":\"\"}}]";



 //   @Test
    public void testAuth() throws IOException, URISyntaxException {
        apiV3Users.authUser(email, password);

    }

    // @Test (dependsOnMethods = "testAuth")
    public void testCurrentTime() throws IOException, URISyntaxException {
        apiV3Users.currentTime(apiV3Users.userId);
    }

   //@Test (dependsOnMethods = "testAuth")
    public void testUpdatePass() throws IOException, URISyntaxException {
        apiV3Users.UpdatePass("1"); // Clarify is it correct : when user enters different password (not equals to current) - system says that password was entered incorrectly
    }

    //@Test (dependsOnMethods = "testAuth")
    public void testForgotPassword() throws IOException, URISyntaxException {
        apiV3Users.forgotPassword(email);
    }

    // @Test
    public void testRegistration() throws IOException, URISyntaxException {
        apiV3Users.registration("dmitry.m+daq1@pdffiller.com", "1"); // possible run script several times (user is not created every time)
    }

   // @Test
    public void testRegistrationLaravel() throws IOException, URISyntaxException {

        apiV3Users.registration("sddsd@fdfghj3.jh", "1");
    }
      //  @Test
        public void testUpdateSubscribe ()throws IOException, URISyntaxException {
            apiV3Users.updateSubscribe(0);        // don't work
        }

  // @Test (dependsOnMethods = "testAuth")
    public void testChangeEmail ()throws IOException, URISyntaxException {
        apiV3Users.newEmail("dmitry.m@pdffiller.com");               // don't work
    }
   //@Test
    public void testInfo ()throws IOException, URISyntaxException {
        apiV3Users.getUserInfo() ;
    }



   // ++++++++++++++++++++++++++++++++++ Projects++++++++++++++++++++++++++++++++++++++++


   // @Test (dependsOnMethods = "testAuth")
    public void testMyBox ()throws IOException, URISyntaxException {
        apiV3Users.myBox("create_date", "desc") ;
    }



    String response = "{\"isCorporate\":false,\"isPaid\":false,\"userId\":\"18101666\",\"token\":\"pewT9OtJE0bxwSKrHreybT2Ih\",\"pdfEmail\":\"U+18101666@pdffiller.com\",\"phone\":\"+380664208173\"}";

    //@Test
    public  void test ()
    {
        JSONObject jsonObject = new JSONObject(response);
        String  token = jsonObject.getString("token");
        System.out.println(token);
        String userId = jsonObject.getString("userId");
        System.out.println(userId);
    }

    String arrayExaple = "[{\"clone_state\":\"0\",\"created\":\"10:57 am\",\"date\":\"2015-11-03 10:57:58\",\"filename\":\"fw9  2014 - Form W-9 (Rev. December 2014)\",\"fileType\":\"pdf\",\"folder_id\":-20,\"form_id\":6962253,\"system_id\":20210595,\"user_id\":10989184,\"status\":{\"code\":3,\"text\":\"\"}},{\"clone_state\":\"0\",\"created\":\"10:58 am\",\"date\":\"2015-11-03 10:58:05\",\"filename\":\"Guidebook_for_PDFfiller_on_Mobile\",\"fileType\":\"pdf\",\"folder_id\":-20,\"form_id\":15774449,\"system_id\":20210596,\"user_id\":10989184,\"status\":{\"code\":2,\"text\":\"\"}},{\"clone_state\":\"0\",\"created\":\"10:58 am\",\"date\":\"2015-11-03 10:58:05\",\"filename\":\"Welcome_to_PDFfiller\",\"fileType\":\"pdf\",\"folder_id\":-20,\"form_id\":100109021,\"system_id\":20210597,\"user_id\":10989184,\"status\":{\"code\":2,\"text\":\"\"}}]";

    public ObjectMapper mapper = new ObjectMapper();
  @Test
    public  void testArrayJson () throws IOException {

        System.out.println(arrayExaple);
        //java util
        List <ProjectClass>  projectList= new LinkedList<ProjectClass>(Arrays.asList(mapper.readValue(arrayExaple, ProjectClass.class)));

        System.out.println(projectList.get(0).filename);
      System.out.println(projectList.get(0).status.code);

    }


}


















