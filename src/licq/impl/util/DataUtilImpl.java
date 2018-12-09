package licq.impl.util;

import licq.util.*;
import java.util.*;
import java.math.*;
import java.lang.reflect.*;
import net.sf.json.JSONNull;
public final class DataUtilImpl implements DataUtil{

    private final static DataUtil __instance = new DataUtilImpl();

    private DataUtilImpl(){}
    public static DataUtil getInstance(){
        return __instance;
    }

    public <T> T toData(Object oo,T cc){
        return toData(oo,cc,false);
    }

    public <T extends CharSequence , Number> void f(T t){
        System.out.println(t.getClass().getName());
    }

    private <T> T toData(Class cccls,String ss,T cc,boolean isthrow){
        try{
            Constructor c1=cccls.getDeclaredConstructor(new Class[]{String.class});
            return (T)c1.newInstance(new Object[]{ss});
        }catch(Exception err){
            if(isthrow)throw new RuntimeException("数据转换时发生异常",err);
            return cc;
        }
    }

    //空或异常时，返回默认值;bthrow异常时是否抛出
    public <T> T toData(Object oo,T cc,boolean isthrow){
        if(oo==null||cc==null)return cc;

        Class cccls = cc.getClass();

        //oo能否转为cc对应的类,oo是不是cc对应类的一个实例
        if(cccls.isInstance(oo)){
            return (T)oo;
        }

        if(cc instanceof CharSequence){
            return toData(cccls,oo.toString(),cc,isthrow);
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
            return toData(cccls,ss,cc,isthrow);
        }

        if(cc instanceof Date){
            String ss = oo.toString();
            if(ss.indexOf("-")>0||ss.indexOf(":")>0){
                java.sql.Timestamp ttt = java.sql.Timestamp.valueOf(ss);
                return (T)ttt;
            }

            if(oo instanceof Number){
                long ltime = toData(oo,0l,isthrow);
                java.sql.Timestamp ttt = new java.sql.Timestamp(ltime);
                return (T)ttt;
            }
            return cc;
        }

        if(JSONNull.getInstance().equals(oo))return cc;
        return (T)oo;
    }

    // public <T> T[] toDatas(Object[] oo,T cc){
    //     if(oo==null)return null;
    //     List<T>
    //     T[] resp = new T[oo.length];
    //     for(int i=0;i<resp.length;i++){
    //         resp[i] = toData(oo[i],cc);
    //     }
    //     return resp;
    // }
}
