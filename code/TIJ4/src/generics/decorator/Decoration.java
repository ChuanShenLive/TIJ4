//: generics/decorator/Decoration.java
package generics.decorator;

import java.util.Date;

class Basic {
	private String value;
	public void set(String val) {
		value = val;
	}
	public String get() {
		return value;
	}
}

class Decorator extends Basic {
	protected Basic basic;
	
	public Decorator(Basic basic) {
		this.basic = basic;
	}
	
	@Override
	public void set(String val) {
		basic.set(val);
	}
	
	@Override
	public String get() {
		return basic.get();
	}
}

class TimeStamped extends Decorator {
	private final long timeStamp;
	public TimeStamped(Basic basic) {
		super(basic);
		timeStamp = new Date().getTime();
	}
	
	public long getStamp() {
		return timeStamp;
	}
}

class SerialNumbered extends Decorator {
	private static long counter = 1;
	private final long serialNumber = counter++;
	public SerialNumbered(Basic basic) {
		super(basic);
	}
	public long getSerialNumber() {
		return 
	}
}
public class Decoration {

}