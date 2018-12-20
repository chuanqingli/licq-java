package licq.util;

import java.util.Collection;

public interface CollectionUtil{
    <A extends Collection<T>,T> A create(A resp,T[] args);
    <A extends Collection> A create(A resp,A args);
    <A extends Collection<T>,T> A create(A resp,T cc,Object[] args);
    <A extends Collection<T>,T> A create(A resp,T cc,Collection args);
}
