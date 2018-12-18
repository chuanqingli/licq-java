package licq.impl.util;

import licq.util.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
public final class DateUtilImpl implements DateUtil{
    //空或异常时，返回默认值;bthrow异常时是否抛出
    private <T> T toData(Object oo,T cc,boolean isthrow){
        return ImplFactory.getBean(DataUtil.class).toData(oo,cc,isthrow);
    }

    private String createString(Object... args){
        if(args==null||args.length<=0)return "";
        StringBuilder buf = new StringBuilder(1024);
        for(Object obj : args){
            buf.append(obj);
        }
        return buf.toString();
    }

    private Timestamp getMinDate(){
        return Timestamp.valueOf("1000-1-1 0:0:0");
    }

    //字符转日期
    public Date toDate(CharSequence oo,boolean isthrow){
        if(oo==null)return null;

        String ssss = oo.toString().trim().replaceAll("[^0-9]+",",");
        String[] ss = ssss.split(",");
        int[] dd = new int[]{0,0,0,0,0,0,0};
        int[] min = new int[]{1000,1,1,0,0,0,0};
        int[] max = new int[]{9999,12,31,59,59,59,999999999};

        int nlen=(ss.length>min.length)?min.length:ss.length;
        for(int i=0;i<nlen;i++){
            dd[i]=toData(ss[i],0,isthrow);
            if(dd[i]<min[i]||dd[i]>max[i]){
                if(isthrow)throw new RuntimeException("时间转换异常:" + i + "," + dd[i]);
                return getMinDate();
            }
        }

        try{
            return java.sql.Timestamp.valueOf(createString(dd[0],"-",dd[1],"-",dd[2]," ",dd[3],":",dd[4],":",dd[5],".",dd[6]));
        }catch(Exception err){
            if(isthrow)throw new RuntimeException("时间转换异常",err);
            return getMinDate();
        }
    }
    //数字转日期
    public Date toDate(Number oo,boolean isthrow){
        long ltime = toData(oo,0l,isthrow);
        try{
            return new Timestamp(ltime);
        }catch(Exception err){
            if(isthrow)throw new RuntimeException("时间转换异常",err);
            return getMinDate();
        }
    }
    //yyyy-MM-dd HH:mm:ss.SSS
    public String format(Date oo,String panel){
        SimpleDateFormat dateformatter = new SimpleDateFormat(panel);
        return dateformatter.format(oo);
    }
    public Date add(Date src,int field,int amount){
        Calendar cc = Calendar.getInstance();
        cc.setTime(src);
        cc.add(field,amount);
        return cc.getTime();
    }
}
