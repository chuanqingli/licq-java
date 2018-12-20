package licq.util;

import java.util.Map;

public interface MapUtil{
    <A extends Map<K,V>,K,V> A create(A resp,K[] args0,V[] args1);
    <A extends Map> A create(A resp,A args);
    <A extends Map<K,V>,K,V> A create(A resp,K kk,V vv,Object[] args0,Object[] args1);
    <A extends Map<K,V>,K,V> A create(A resp,K kk,V vv,Map args);
}
