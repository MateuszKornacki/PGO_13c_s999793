package g13c.cw3.zd2;

import java.util.Objects;

public class Base {

    protected void checkArgIsBlank(String arg){
        if(arg == null || "".equals(arg.replaceAll("\\s",""))) throw new IllegalArgumentException("Wartość jest wymagana");
    }

    protected void checkArgIsNull(Object arg){
        if(Objects.isNull(arg)) throw new IllegalArgumentException("Wartość jest wymagana");
    }
}
