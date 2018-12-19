package licq.util;
import licq.impl.util.*;
import java.util.*;
public class ImplFactory{
    private static Map<Class,Object> __map = getInterfacesMap();

    private static Map<Class,Object> getInterfacesMap(){
        PackageUtil util = new PackageUtilImpl();
        // Map<Class,Class> map = util.getInterfacesMap(PackageUtil.class.getPackage().getName(),PackageUtilImpl.class.getPackage().getName());
        Map<Class,Class> map = util.getInterfacesMap("licq.util","licq.impl.util");
        Map<Class,Object> resp = new HashMap<Class,Object>();
        for(Map.Entry<Class,Class> entry : map.entrySet()){
            Class key = entry.getKey();
            Class value = entry.getValue();

            if(value==PackageUtilImpl.class){
                resp.put(key,util);
                continue;
            }

            Object obj = null;
            try{
                obj = value.newInstance();
            }catch(Exception err){
                throw new RuntimeException(err);
            }
            resp.put(key,obj);
        }
        return resp;
    }

    @SuppressWarnings(value="unchecked")
    public static <T> T getBean(Class<T> cls){
        return (T)__map.get(cls);
    }


}
