//: generics/MultipleInterfaceVariants.java
// {CompileTimeError} (Won't compile)
package generics;

// 一个类不能实现同一个泛型接口的两种变体。
interface Payable<T> {}

class Employeess implements Payable<Employeess> {
	// Employee e = new Employee();
}

// The interface Payable cannot be implemented more than once with different arguments: Payable<Employeess> and Payable<Hourlyss>
// class Hourlyss extends Employeess implements Payable<Hourlyss> {} ///:~

public class MultipleInterfaceVariants {
}
///:~
