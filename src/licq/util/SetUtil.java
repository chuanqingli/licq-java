package licq.util;

import java.util.Set;
import java.util.List;

public interface SetUtil{
    <T> Set<T> create();
    <T> Set<T> create(List<T> args);
    <T> Set<T> create(T[] args);
    <T> Set<T> create(T cc,Object[] args);
    <T> Set<T> create(T cc,List args);
}
