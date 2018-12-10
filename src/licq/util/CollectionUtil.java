package licq.util;

import java.util.Collection;

public interface CollectionUtil{
    <T> Collection<T> create(Collection<T> coll,T[] args);
    <T> Collection<T> create(Collection<T> coll,Collection<T> args);
    <T> Collection<T> create(Collection<T> coll,T cc,Object[] args);
    <T> Collection<T> create(Collection<T> coll,T cc,Collection args);

    // <T> Collection<T> create();
    // <T> Collection<T> create(T... args);
    // <T> Collection<T> create(T cc,Object... args);
    // <T> Collection<T> create(T cc,Collection args);
}
