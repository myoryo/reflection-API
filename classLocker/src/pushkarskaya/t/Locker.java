package pushkarskaya.t;

import java.lang.reflect.Field;

public class Locker<T> {

    Field[] unlockAll(T el){
        Field[] fields=el.getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++)
            fields[i].setAccessible(true);
        return fields;
    }
    Field[] lockAll(T el){
        Field[] fields=el.getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++)
            fields[i].setAccessible(false);
        return fields;
    }
}
