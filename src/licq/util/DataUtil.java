package licq.util;

public interface DataUtil{
    <T> T toData(Object oo,T cc);
    <T> T toData(Object oo,T cc,boolean isthrow);
    // <T extends CharSequence , Number> void f(T t);
    // <T super Number&CharSequence,B super Number&CharSequence> T toData00(B oo,T cc,boolean isthrow);
    // <T> T[] toDatas(Object[] oo,T cc);
}
