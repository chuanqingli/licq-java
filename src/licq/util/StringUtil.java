package licq.util;
import java.util.Collection;
import java.util.List;
public interface StringUtil{
    <A extends Appendable> A create(A buf,Object o1,Object o2,Object[] objs);
    <A extends Appendable> A create(A buf,Object o1,Object o2,Collection objs);
    List<String> split(String sss,List<Integer> len);
}
