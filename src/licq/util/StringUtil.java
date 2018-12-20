package licq.util;
import java.util.Collection;
public interface StringUtil{
    <A extends Appendable> A create(A buf,Object[] objs);
    <A extends Appendable> A create(A buf,Collection objs);
    // StringBuilder create(StringBuilder buf,Object[] objs);
    // StringBuffer create(StringBuffer buf,Object[] objs);
}
