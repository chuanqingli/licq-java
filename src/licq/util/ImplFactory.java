package licq.util;
import licq.impl.util.*;
import java.util.*;
public class ImplFactory{
    private static Object[] __objs = new Object[]{new DateUtilImpl(),new DataUtilImpl(),new CollectionUtilImpl()};
    // private static Map<Class<K>,V extends K> __map = new HashMap<Class<K>,V extends K>();
    private static Map<Class,Object> __map = new HashMap<Class,Object>();
    static{
        for(int i=0;i<__objs.length;i++){
            Class c = __objs[i].getClass();
            Class<?> interfaces[] = c.getInterfaces();
            if(interfaces==null||interfaces.length<=0)continue;
            __map.put(interfaces[0],__objs[i]);
        }

        // __map.put(DataUtil.class,new DataUtilImpl());
        // __map.put(DateUtil.class,new DateUtilImpl());
        // __map.put(CollectionUtil.class,new CollectionUtilImpl());
    }

    @SuppressWarnings(value="unchecked")
    public static <T> T getBean(Class<T> cls){
        return (T)__map.get(cls);
    }


}
