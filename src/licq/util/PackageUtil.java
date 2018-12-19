package licq.util;

import java.util.*;
public interface PackageUtil{
    public List<Class> getClasses(Class cls,boolean subPath);
    public List<Class> getClasses(String packageName,boolean subPath);
    public Map<Class,Class> getInterfacesMap(String keyPackage,String valPackage);
    public Map<Class,Class> getInterfacesMap(Map<String,String> pakmap);
}
