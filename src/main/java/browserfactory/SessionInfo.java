package browserfactory;

import java.util.ArrayList;
import java.util.List;

public class SessionInfo {
	
	public static List<String> processIdsBefore = new ArrayList<String>();
	public static List<String> processIdsAfter = new ArrayList<String>();
	
	public static int processID;

	public static String way;
	public static String browser;
	public static String url;
	public static int realErrorCounter = 0;
	public static String currentLocator;
	public static String ScreenExpected = "C:/testScreensoots/expected/"+currentLocator+".png";
	public static String ScreenActual = "C:/testScreensoots/actual/"+currentLocator+".png";
	public static String UserID = "clear";
	public static String facebookAccStatus = "ok";
	


}
