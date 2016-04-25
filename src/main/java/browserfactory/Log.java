package browserfactory;


public class Log {
	/**
	 * Простой лог
	 * @param logMessage
	 */
	public void log(String logMessage) {
		 System.out.println(logMessage);
	 }


	public void error(String logMessage){
		 System.err.println(logMessage);
	}

}
