package licq.impl.util;

import licq.util.*;
import java.util.*;
import java.math.*;
import java.lang.reflect.*;

public class TestUtilImpl implements DataUtil{// implements TestUtil
    public <T> T toData(Object oo,T cc){
        return toData(oo,cc,false);
    }

    @SuppressWarnings(value="unchecked")
    private <K,T> T toData(Class cccls,K val,Class valcls,T cc,boolean isthrow){


        try{
            Constructor c1=cccls.getDeclaredConstructor(new Class[]{valcls});
            return (T)c1.newInstance(new Object[]{val});
        }catch(Exception err){
            if(isthrow)throw new RuntimeException("数据转换时发生异常",err);
            return cc;
        }
    }

    @SuppressWarnings(value="unchecked")
    public <T> T toData(Object oo,T cc,boolean isthrow){
        if(oo==null||cc==null)return cc;

        Class cccls = cc.getClass();

        //oo能否转为cc对应的类,oo是不是cc对应类的一个实例
        if(cccls.isInstance(oo)){
            return (T)oo;
        }

        if(cc instanceof CharSequence){
            return toData(cccls,oo.toString(),String.class,cc,isthrow);
        }

        if(cc instanceof Number){
            String ss = oo.toString();

            if(cc instanceof Number){
                int nindex = ss.indexOf(".");
                if(nindex>0){
                    if(((cc instanceof Integer)==true)||((cc instanceof Long)==true)||((cc instanceof BigInteger)==true)){
                        ss = ss.substring(0,nindex);
                    }
                }
            }
            return toData(cccls,ss,String.class,cc,isthrow);
        }

        if(cc instanceof Date){
            String ss = oo.toString();
            if(ss.indexOf("-")>0||ss.indexOf(":")>0){
                try{
                    Date ttt = java.sql.Timestamp.valueOf(ss);
                    return toData(cccls,ttt.getTime(),long.class,cc,isthrow);
                }catch(Exception err){
                    if(isthrow)throw new RuntimeException("数据转换时发生异常",err);
                    return cc;
                }
            }else{
                long ltime = toData(oo,0l,isthrow);
                return toData(cccls,ltime,long.class,cc,isthrow);
            }
        }

        // if(JSONNull.getInstance().equals(oo))return cc;
        return (T)oo;
    }
    // private static TestUtilImpl<T> __instance = new TestUtilImpl<T>();

    // public Class<T> __cls = Collection<T>.class;

    // private TestUtilImpl(){}

    // public static TestUtilImpl getInstance(){
    //     return __instance;
    // }

}
