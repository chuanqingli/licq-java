package licq.util;

public interface DataUtil{
    <T> T toData(Object oo,T cc);
    <T> T toData(Object oo,T cc,boolean isthrow);
}
