package jo.edu.htu.math.test;

import jo.edu.htu.math.ImmutablePoint;
import jo.edu.htu.math.ImmutablePoint3D;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ImmutablePoint point = new ImmutablePoint(20, 10);
        Class type = point.getClass();

        System.out.println(type.getName());
        System.out.println(type.getSimpleName());

        Method[] methods = type.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ":" + method.getParameterCount());
        }

        // reflection API
        Class type2 = ImmutablePoint3D.class;
        Constructor constructor = type2.getConstructor(Integer.TYPE, Integer.TYPE, Integer.TYPE);
        Object p3d = constructor.newInstance(10, 3, 5);
        Method method = type2.getMethod("getX");
        System.out.println(method.invoke(p3d));
        System.out.println("============================");
        ImmutablePoint3D point2 = new ImmutablePoint3D(10,3,5);
        System.out.println(point2.getX());

    }
}
