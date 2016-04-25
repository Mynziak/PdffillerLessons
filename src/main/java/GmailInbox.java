

import org.testng.annotations.Test;

import javax.mail.*;
import java.util.Properties;

/**
 * Created by DimaM on 8/9/2015.
 */
public class GmailInbox {
    // public static void main(String args[]) {

    @Test
        public void parseEmail() {
            Properties props = new Properties();
            props.setProperty("mail.store.protocol", "imaps");
            try {
                Session session = Session.getInstance(props, null);
                Store store = session.getStore();
                store.connect("imap.gmail.com", "dmitry.m@pdffiller.com", "Dm@!161186");
                Folder inbox = store.getFolder("INBOX");
                inbox.open(Folder.READ_ONLY);
                Message msg = inbox.getMessage(inbox.getMessageCount());
                Address[] in = msg.getFrom();
                for (Address address : in) {
                    System.out.println("FROM:" + address.toString());
                }
                Multipart mp = (Multipart) msg.getContent();
                BodyPart bp = mp.getBodyPart(0);
                System.out.println("SENT DATE:" + msg.getSentDate());
                System.out.println("SUBJECT:" + msg.getSubject());
                System.out.println("CONTENT:" + bp.getContent());
            } catch (Exception mex) {
                mex.printStackTrace();
            }
    }
}
//}
