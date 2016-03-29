package imap;

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.search.SearchTerm;
import java.util.ArrayList;
import java.util.Properties;

public class Imap {

	private final static Logger Log = Logger.getLogger(Imap.class);

	protected Store openConnection(String email, String password, String host) {
		Store store = null;
		try {
			Properties properties = new Properties();
			Session session = Session.getInstance(properties);
			store = session.getStore("imaps");
			store.connect(host, email, password);
		} catch (Exception e) {
			Log.error(e);
		}
		return store;
	}

	protected Folder openFolder(Store store, String folderName) {
		Folder folder = null;
		try {
			folder = store.getFolder(folderName);
			folder.open(Folder.READ_WRITE);
		} catch (Exception e) {
			Log.error(e);
		}
		return folder;
	}

	protected void close(Folder folder) {
		try {
			folder.close(true);
		} catch (Exception e) {
			Log.error(e);
		}
	}

	protected void close(Store store) {
		try {
			store.close();
		} catch (Exception e) {
			Log.error(e);
		}
	}

	protected ArrayList<Message> searchMessagesIn(SearchTerm term, Folder folder) {
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			for (Message message : folder.search(term))
				messages.add(message);
		} catch (Exception e) {
			Log.error(e);
		}
		return messages;
	}

	protected ArrayList<Message> searchMessagesIn(Folder folder) {
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			for (Message message : folder.getMessages())
				messages.add(message);
		} catch (Exception e) {
			Log.error(e);
		}
		return messages;
	}

	protected void delete(Message message) {
		try {
			message.setFlag(Flags.Flag.DELETED, true);
		} catch (Exception e) {
			Log.error(e);
		}
	}
}
