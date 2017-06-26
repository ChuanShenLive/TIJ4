//: innerclasses/GreenhouseControllers.java
// This produces a specific application of the 
// control system, all in a single class. Inner
// classes allow you to encapsulate different 
// functionality for each type of event.
package innerclasses;

import innerclasses.controller.Controller;
import innerclasses.controller.Event;

public class GreenhouseControllers extends Controller {
	private boolean light = false;
	
	public class LightOn extends Event {
		public LightOn(long delayTime) {
			super(delayTime);
		}
		
		public void action() {
			// Put hardware control code here to
			// physically turn on the light.
			light = true;
		}
		
		public String toString() {
			return "Light is on";
		}
	}
	public class LightOff extends Event {
		public LightOff(long delayTime) {
			super(delayTime);
		}
		
		public void action() {
			// Put hardware control code here to
			// physically turn off the light.
			light = false;
		}
		
		public String toString() {
			return "Light is off";
		}
	}
}
