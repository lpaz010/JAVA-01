import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author
 */
public class HelloClassLoader extends ClassLoader {

    public void hello() {
        System.out.println("HelloClassLoader, classLoader!");
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = new HelloClassLoader().findClass("Hello.xlass");
        Method method = clazz.getDeclaredMethod("hello");
        method.invoke(clazz.newInstance());
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] newByte = new byte[0];
        try {
            InputStream ins = HelloClassLoader.class.getClassLoader().getResourceAsStream(name);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len = 0;
            while ((len = ins.read()) != -1) {
                bos.write(len);
            }
            newByte = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int j = 0; j < newByte.length; j++) {
            newByte[j] = (byte) (255 - newByte[j]);
        }

        return defineClass("Hello", newByte, 0, newByte.length);
    }

}