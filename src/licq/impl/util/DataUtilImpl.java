package licq.impl.util;

import licq.util.*;
import java.util.*;
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
    //空或异常时，返回默认值;bthrow异常时是否抛出
    public <T> T toData(Object oo,T cc,boolean isthrow){
        if(cc==null)return null;
        if(oo==null)return cc;

        if(cc instanceof String){
            return (T)oo.toString();
        }

        if(cc instanceof Number){
            String ss = oo.toString();

            int nindex = ss.indexOf(".");
            if(nindex>0){
                if(((cc instanceof Integer)==true)||((cc instanceof Long)==true)){
                    ss = ss.substring(0,nindex);
                }
            }

            try{
                Constructor c1=cc.getClass().getDeclaredConstructor(new Class[]{String.class});
                return (T)c1.newInstance(new Object[]{ss});
            }catch(Exception err){
                if(isthrow)throw new RuntimeException("数据转换时发生异常",err);
                return cc;
            }
        }

        if(JSONNull.getInstance().equals(oo))return cc;
        return (T)oo;
    }
}
