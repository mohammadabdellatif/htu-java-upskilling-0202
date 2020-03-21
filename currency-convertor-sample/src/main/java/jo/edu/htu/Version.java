package jo.edu.htu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
public @interface Version {

    int major();

    int minor();

    int build() default 0;
}
