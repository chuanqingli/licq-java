package licq.util;

public interface JsonUtil{
    public String toJson(Object bean);
    public <T> T toBean(String json,Class<T> cls);
}
