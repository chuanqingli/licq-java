package licq.impl.util;

import licq.util.*;
import java.io.*;
import java.util.*;

public final class StringUtilImpl{// implements StringUtil
    public <A extends Appendable> A create(A buf,Object o1,Object o2,Object[] objs){
        return create(buf,o1,o2,Arrays.asList(objs));
    }
    public <A extends Appendable> A create(A buf,Object o1,Object o2,Collection objs){
        try{
            return create00(buf,o1,o2,objs);
        }catch(IOException err){
            throw new RuntimeException("数据转化时异常",err);
        }
    }

    private String toString(Object obj){
        if(obj==null)return "";
        return String.valueOf(obj);
    }

    private <A extends Appendable> A create00(A buf,Object o1,Object o2,Collection objs)throws IOException{
        if(objs==null||objs.size()<=0)return buf;
        String s1 = toString(o1);
        String s2 = toString(o2);
        for(Object obj : objs){
            String ss = toString(obj);
            buf.append(s1);
            buf.append(ss);
            buf.append(s2);
        }
        return buf;
    }
}
