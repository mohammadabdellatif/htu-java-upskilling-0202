package jo.edu.htu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Topics {

    String[] value();

    Version version() default @Version(minor = 1, major = 1);
}
