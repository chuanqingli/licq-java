package licq.impl.util;

import licq.util.*;
import java.util.*;

public final class CollectionUtilImpl implements CollectionUtil{
    private <T> T toData(Object oo,T cc){
        return toData(oo,cc,false);
    }
    //空或异常时，返回默认值;bthrow异常时是否抛出
    private <T> T toData(Object oo,T cc,boolean isthrow){
        return ImplFactory.getBean(DataUtil.class).toData(oo,cc,isthrow);
    }

    public <A extends Collection<T>,T> A create(A resp,T[] args){
        if(resp==null||args==null)return resp;
        resp.addAll(Arrays.asList(args));
        return resp;
    }

    @SuppressWarnings(value="unchecked")
    public <A extends Collection> A create(A resp,A args){
        if(resp==null||args==null)return resp;
        resp.addAll(args);
        return resp;
    }

    public <A extends Collection<T>,T> A create(A resp,T cc,Object[] args){
        if(resp==null||args==null)return resp;
        Collection ccc = Arrays.asList(args);
        return create(resp,cc,ccc);
    }

    public <A extends Collection<T>,T> A create(A resp,T cc,Collection args){
        if(resp==null||args==null)return resp;
        for(Object oo : args){
            resp.add(toData(oo,cc));
        }
        return resp;
    }
}
