package licq.impl.util;

import licq.util.*;
import java.util.*;

public final class SetUtilImpl implements SetUtil{

    private final static SetUtil __instance = new SetUtilImpl();
    private final static DataUtil __datautil = DataUtilImpl.getInstance();

    private SetUtilImpl(){}
    public static SetUtil getInstance(){
        return __instance;
    }

    private <T> T toData(Object oo,T cc){
        return toData(oo,cc,false);
    }
    //空或异常时，返回默认值;bthrow异常时是否抛出
    private <T> T toData(Object oo,T cc,boolean isthrow){
        return __datautil.toData(oo,cc,isthrow);
    }

    public <T> Set<T> create(){
        return new LinkedHashSet<T>();
    }

    public <T> Set<T> create(T[] list){
        Set<T> resp = create();
        if(resp==null||list==null)return resp;
        resp.addAll(list);


        for(int i=0;i<list.length;i++){
            T obj = toData(list[i],cc);
            resp.add(obj);
        }
    }

    public <T> Set<T> create(List<T> list){
        Set<T> resp = create();
        if(resp==null||list==null)return resp;
        for(int i=0;i<list.size();i++){
            resp.add(list.get(i));
        }
    }


    public <T> Set<T> create(T cc,Object[] args){
        return null;
    }

    public <T> Set<T> create(T cc,List args){
        return null;
    }
}
