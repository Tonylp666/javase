package jvm.classload;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;



public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            new MyClassLoader().findClass("jvm.Hello").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String helloBase64 = "cGFja2FnZSBqdm07CgpwdWJsaWMgY2xhc3MgSGVsbG97CgoJc3RhdGljewoJCVN5c3RlbS5vdXQucHJpbnRsbigiSGVsbG8gSnZtIENMYXNzTG9hZGVyLi4uLiIpOwoJfQoKfQ==";

//        byte[] bytes = decode(helloBase64);
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(new URI("D:\\work\\tonylp\\javase\\res\\Hello.class")));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return defineClass(name,bytes,0, bytes.length);
    }

    public byte[] decode(String base64){
        return Base64.getDecoder().decode(base64);
    }
}
