package licq.impl.util;

import licq.util.*;
import java.util.*;

public class CollectionUtilImpl implements CollectionUtil{

    private final static DataUtil __datautil = DataUtilImpl.getInstance();

    private static CollectionUtil __instance = new CollectionUtilImpl();

    private CollectionUtilImpl(){}

    public static CollectionUtil getInstance(){
        return __instance;
    }

    protected final <T> T toData(Object oo,T cc){
        return toData(oo,cc,false);
    }
    //空或异常时，返回默认值;bthrow异常时是否抛出
    protected final <T> T toData(Object oo,T cc,boolean isthrow){
        return __datautil.toData(oo,cc,isthrow);
    }

    public <T> Collection<T> create(Collection<T> resp,T[] list){
        if(resp==null||list==null)return resp;
        resp.addAll(Arrays.asList(list));
        return resp;
    }

    public <T> Collection<T> create(Collection<T> resp,T cc,Object[] list){
        if(resp==null||list==null)return resp;
        Collection ccc = Arrays.asList(list);
        return create(resp,cc,ccc);
    }

    public <T> Collection<T> create(Collection<T> resp,T cc,Collection args){
        if(resp==null||args==null)return resp;
        for(Object oo : args){
            resp.add(toData(oo,cc));
        }
        return resp;
    }
}
