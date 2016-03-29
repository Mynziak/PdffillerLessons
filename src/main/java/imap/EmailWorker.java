package imap;

import javax.mail.Message;
import java.io.File;
import java.util.List;

public class EmailWorker {
	
	public void deleteAllMessages(String email, String password){
		 ImapClient client = new ImapClient(email, password);
		 client.connect();
		 client.deleteAllMessages(); //Delete all Messages on Email
		 client.closeStore();
	}
	
	public File findMessageBySubject(String email, String password, String subject){
		ImapClient client = new ImapClient(email, password);
		 client.connect();
		  List<Message> messages = client.findMessages(With.subject(subject));
		  MessageContent content;
		  File mail = null;
		  for(Message msg : messages){
		   content = new MessageContent(client.getContent(msg));
		   return mail = content.save("C:\\testResources\\emails");
		  }
		  return mail;
	}
	
	public File findMessageByFromEmail(String email, String password, String fromEmail){
		ImapClient client = new ImapClient(email, password);
		 client.connect();
		  List<Message> messages = client.findMessages(With.from(fromEmail));
		  MessageContent content;
		  File mail = null;
		  for(Message msg : messages){
		   content = new MessageContent(client.getContent(msg));
		   return mail = content.save("C:\\testResources\\emails");
		  }
		  return mail;
	}
	
	public String getMessageUrl(String email, String password, String subject){
		File mail = findMessageBySubject(email, password, subject);
		String mailUrl = "file:///"+mail.getAbsolutePath().replaceAll( "\n", "/");
		return mailUrl;
	}
	
	

}
