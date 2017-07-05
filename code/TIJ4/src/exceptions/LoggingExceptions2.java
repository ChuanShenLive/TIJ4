//: exceptions/LoggingExceptions2.java
// Logging caught exceptions.
package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingExceptions2 {
	
	private static Logger logger = Logger.getLogger("LoggingExceptions2");
	
	static void logException(Exception e) {
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
	
	public static void main(String[] args) {
		try {
			throw new NullPointerException();
		} catch (NullPointerException e) {
			logException(e);
		}
	}
}/* Output:
七月 05, 2017 9:53:59 上午 exceptions.LoggingExceptions2 logException
严重: java.lang.NullPointerException
	at exceptions.LoggingExceptions2.main(LoggingExceptions2.java:21)
*///:~