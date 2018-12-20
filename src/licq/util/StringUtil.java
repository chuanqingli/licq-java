package licq.util;
import java.util.List;
public interface StringUtil{
    <A extends Appendable> A create(A buf,Object[] objs);
    <A extends Appendable> A create(A buf,List objs);
    // StringBuilder create(StringBuilder buf,Object[] objs);
    // StringBuffer create(StringBuffer buf,Object[] objs);
}
