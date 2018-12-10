package licq.util;

import java.util.Collection;

public interface TestUtil{
    <T> Collection<T> create(Object[] args);
    // <T> Collection<T> create(Collection args);

    // <T> Collection<T> create();
    // <T> Collection<T> create(T... args);
    // <T> Collection<T> create(T cc,Object... args);
    // <T> Collection<T> create(T cc,Collection args);
}
