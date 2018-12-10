package licq.impl.util;

import licq.util.*;
import java.util.*;

public final class CollectionUtilImpl implements CollectionUtil{

    private static CollectionUtil __instance = new CollectionUtilImpl();

    private CollectionUtilImpl(){}

    public static CollectionUtil getInstance(){
        return __instance;
    }

    private <T> T toData(Object oo,T cc){
        return toData(oo,cc,false);
    }
    //空或异常时，返回默认值;bthrow异常时是否抛出
    private <T> T toData(Object oo,T cc,boolean isthrow){
        return DataUtilImpl.getInstance().toData(oo,cc,isthrow);
    }

    public <T> Collection<T> create(Collection<T> resp,T[] args){
        if(resp==null||args==null)return resp;
        resp.addAll(Arrays.asList(args));
        return resp;
    }

    public <T> Collection<T> create(Collection<T> resp,Collection<T> args){
        if(resp==null||args==null)return resp;
        resp.addAll(args);
        return resp;
    }

    public <T> Collection<T> create(Collection<T> resp,T cc,Object[] args){
        if(resp==null||args==null)return resp;
        Collection ccc = Arrays.asList(args);
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
