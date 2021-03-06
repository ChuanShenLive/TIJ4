//: generics/DynamicProxyMixin.java
package generics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import sc.chuanshen.util.Tuple;
import sc.chuanshen.util.TwoTuple;

class MixinProxy implements InvocationHandler {
	Map<String, Object> delegatesByMethod;
	
	@SuppressWarnings("unchecked")
	public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
		delegatesByMethod = new HashMap<String, Object>();
		for(TwoTuple<Object, Class<?>> pair : pairs) {
			for(Method method : pair.second.getMethods()) {
				String methodName = method.getName();
				// The first interface in the map
				// implements the method.
				if (!delegatesByMethod.containsKey(methodName)) {
					delegatesByMethod.put(methodName, pair.first);
				}
			}
		}
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();
		Object delegate = delegatesByMethod.get(methodName);
		return method.invoke(delegate, args);
	}
	
	@SuppressWarnings("unchecked")
	public static Object newInstance( TwoTuple<Object, Class<?>>... pairs) {
		Class<?>[] interfaces = new Class[pairs.length];
		for(int i = 0; i < pairs.length; i++) {
			interfaces[i] = (Class<?>)pairs[i].second;
		}
		ClassLoader cl = pairs[0].first.getClass().getClassLoader();
		return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
	}
}

public class DynamicProxyMixin {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Object mixin = MixinProxy.newInstance(
				Tuple.tuple(new BasicImp(), Basic.class),
				Tuple.tuple(new TimeStampedImp(), TimeStamped.class),
				Tuple.tuple(new SerialNumberedImp(), SerialNumbered.class));
		Basic b = (Basic)mixin;
		TimeStamped t = (TimeStamped)mixin;
		SerialNumbered s = (SerialNumbered)mixin;
		b.set("Hello");
		System.out.println(b.get());
		System.out.println(t.getStamp());
		System.out.println(s.getSerialNumber());
	}
} /* Output:
Hello
1514298646712
1
*///:~
