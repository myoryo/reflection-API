package pushkarskaya.t;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class LockerTest {

    @Test
    void unlockAll() throws IllegalAccessException {
        MyClass clas= new MyClass();
        clas.setNumber(5);
        Locker<MyClass> lo = new Locker<>();
        Field[] fields = lo.unlockAll(clas);
        String a="343";
        for(Field f:fields){
            if(f.getType()==a.getClass()){
                f.set(clas,"Jane");
            }
            System.out.println(f);

        }
        assertEquals("Jane",clas.getName());
    }

    @Test
    void lockAll() throws IllegalAccessException {
        MyClass clas= new MyClass();
        clas.setNumber(5);
        Locker<MyClass> lo = new Locker<>();
        Field[] fields = lo.unlockAll(clas);
        String a="343";
        for(Field f:fields){
            if(f.getType()==a.getClass()){
                fields=lo.lockAll(clas);
                try {
                    f.set(clas, "Jane");
                }catch(Exception e){
                    assertEquals("default",clas.getName());
                }
            }
            System.out.println(f);

        }
        assertEquals("Jane",clas.getName());

    }
}