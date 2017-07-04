//: exceptions/LoggingExceptions.java
// An exception that reports through a Logger.
package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException extends Exception {
	private static Logger logger = Logger.getLogger("LogginException");
	public LoggingException() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

public class LoggingExceptions {
	public static void main(String[] args) {
		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("Caught " + e);
		}
		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("Caught " + e);
		}
	}
} /* Output:
七月 04, 2017 10:49:22 下午 exceptions.LoggingException <init>
严重: exceptions.LoggingException
	at exceptions.LoggingExceptions.main(LoggingExceptions.java:21)
Caught exceptions.LoggingException
七月 04, 2017 10:49:22 下午 exceptions.LoggingException <init>
严重: exceptions.LoggingException
	at exceptions.LoggingExceptions.main(LoggingExceptions.java:26)
Caught exceptions.LoggingException
*///:~
