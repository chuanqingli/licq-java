package licq.impl.util;

import licq.util.*;
import java.util.*;

public class CollectionUtilImpl implements CollectionUtil{

    private final static DataUtil __datautil = DataUtilImpl.getInstance();

    protected Class __cls = null;

    public CollectionUtilImpl(){}

    public CollectionUtilImpl(Class cls){
        __cls = cls;
    }

    public <T> Collection<T> create(){
        try{
            return (Collection<T>)__cls.newInstance();
        }catch(Exception err){
            throw new RuntimeException("数据转换时发生异常",err);
        }
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




    // public final <T> Collection<T> create(T... list){
    //     Collection<T> resp = create();
    //     if(resp==null||list==null)return resp;
    //     resp.addAll(Arrays.asList(list));
    //     return resp;
    // }

    // public final <T> Collection<T> create(T cc,Object... args){
    //     Collection tmp = create();
    //     tmp.addAll(Arrays.asList(args));
    //     return create(cc,tmp);
    // }

    // public final <T> Collection<T> create(T cc,Collection args){
    //     Collection<T> resp = create();
    //     if(resp==null||args==null)return resp;
    //     for(Object oo : args){
    //         resp.add(toData(oo,cc));
    //     }
    //     return resp;
    // }
}
