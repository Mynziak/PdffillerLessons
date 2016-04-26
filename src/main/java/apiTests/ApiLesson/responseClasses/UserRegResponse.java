package apiTests.ApiLesson.responseClasses;

/**
 * Created by Dima on 26.04.2016.
 */
public class UserRegResponse {

    public int userId;
    public String token;
    public boolean isPaid;
    public String pdfEmail;

    @Override
    public String toString() {
        return "UserRegResponse [userId=" + userId + ", token=" + token +
                ", isPaid=" + isPaid +  ", pdfEmail=" + pdfEmail + "]";
    }
}
