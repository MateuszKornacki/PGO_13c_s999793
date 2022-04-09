package g13c.cw2.zd5.library;

import java.util.Objects;

public class ArgumentValidator {

    public static void checkArgIsBlank(String arg){

        if(arg == null || "".equals(arg.replaceAll("\\s",""))) throw new IllegalArgumentException("Wartość jest wymagana");
    }

    public static void checkArgIsNull(Object arg){

        if(Objects.isNull(arg)) throw new IllegalArgumentException("Wartość jest wymagana");
    }
}
