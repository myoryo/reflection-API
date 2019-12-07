package pushkarskaya.t;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public final class Information<T> {

    public Information(){}

    /**
     * Метод getPrivateFields(T cl)
     * Возвращает поля с модификатором private и protected
     */
    public Field[] getPrivateFields(T cl) {
        Field[] fields=cl.getClass().getDeclaredFields();
        ArrayList<Field> list= new ArrayList<>();
        for(Field fl: fields){
            int modifiers=(int) fl.getModifiers();
            if(Modifier.isPrivate(modifiers)){
                list.add(fl);
            }
        }
        return arrayListToField(list);
    }

    /**
     * Метод getPublicFields(T cl)
     * Возвращает поля с модификатором доступа public
     */
    public Field[] getPublicFields(T cl){
        return cl.getClass().getFields();
    }

    /**
     * Метод getAllFields(T cl)
     * Возвращает все поля
     */
    public Field[] getAllFields(T cl) {
        return cl.getClass().getDeclaredFields();

    }
    /**
     * Метод getNotEmptyFields(T cl)
     * Возвращает не пустые поля
     */
    public Field[] getNotEmptyFields(T cl) throws IllegalAccessException {
        Field[] fields=cl.getClass().getDeclaredFields();
        ArrayList<Field> list= new ArrayList<>();
        for(Field fl: fields){
            fl.setAccessible(true);
            if(fl.get(cl)!=null){
                list.add(fl);
            }
        }
        return arrayListToField(list);

    }

    /**
     * Метод getMethods(T cl)
     * Возвращает все методы
     */
    public Method[] getMethods(T cl){
        return cl.getClass().getDeclaredMethods();
    }

    /**
     * Метод arrayListToField(ArrayList<Field> list)
     */
    private Field[] arrayListToField(ArrayList<Field> list){
        Field[] priv = new Field[list.size()];
        for(int i=0;i<priv.length;i++){
            priv[i]=list.get(i);
        }
        return priv;
    }
}
