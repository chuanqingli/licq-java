package licq.util;
import java.util.Date;

public interface DateUtil{
    //字符转日期
    Date toDate(CharSequence oo,boolean isthrow);
    //数字转日期
    Date toDate(Number oo,boolean isthrow);
    //yyyy-MM-dd HH:mm:ss.SSS
    String format(Date oo,String panel);
    Date add(Date src,int field,int amount);
}
