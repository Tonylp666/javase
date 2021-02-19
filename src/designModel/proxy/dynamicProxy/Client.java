package designModel.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//liping https://blog.51cto.com/haolloyin/333257

interface AbstractSubject{
    public void request();
}

class RealSubject implements AbstractSubject{

    @Override
    public void request() {
        System.out.println("RealSubject's request().........................");
    }
}

class DynamicProxy implements InvocationHandler {
    Object object = null;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.object, args);
        return result;
    }
}

public class Client{
    public static void main(String[] args) {
        AbstractSubject realSubject = new RealSubject();

        ClassLoader loader = realSubject.getClass().getClassLoader();

        Class<?>[] interfaces = realSubject.getClass().getInterfaces();

        InvocationHandler handler = new DynamicProxy(realSubject);

        AbstractSubject proxy = (AbstractSubject) Proxy.newProxyInstance(
                loader, interfaces, handler);

//        proxy.request();
        realSubject.request();
        //打印出该代理实例的名称
        System.out.println(proxy.getClass().getName());
    }
}
