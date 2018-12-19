package licq.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassUtil{

public static List<Class> getAllClassbyInterface(Class c) {

List<Class> returnList = new ArrayList<Class>();

if (c.isInterface()) { // 如果是接口。。。。
String packageName = c.getPackage().getName();
System.out.println("当前接口在的包"+packageName);

try {
List<Class> allClass = getClasses(packageName);
                for(int i=0;i<allClass.size();i++){
                if(!c.equals(allClass.get(i))){
                returnList.add(allClass.get(i));
                }
                }

}
catch (IOException e) {

e.printStackTrace();
}
catch (ClassNotFoundException e) {

e.printStackTrace();
}
}

return returnList;
}

/**
* 从一个包中查到所有的类
*
* @param packageName
* @return
* @throws IOException
* @throws ClassNotFoundException
*/
private static List<Class> getClasses(String packageName) throws IOException, ClassNotFoundException {

List<Class> classes = new ArrayList<Class>();

ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
System.out.println("************"+packageName.indexOf("."));
//	String aa = "com/corejava/model.abstractmodel.inter";

String path = packageName.replace(".","/");
Enumeration<URL> resources = classLoader.getResources(path);

List<File> dirs = new ArrayList<File>();
while (resources.hasMoreElements()) {
URL resource = resources.nextElement();
dirs.add(new File(resource.getFile()));
}
for (File dir : dirs) {
classes.addAll(findClass(dir, packageName));
}
return classes;
}

/**
* @param directory
*            文件路径
* @param packageName
*            包名
* @return 查找这个包下面的所有的class文件
* @throws ClassNotFoundException
*/
private static List<Class> findClass(File directory, String packageName) throws ClassNotFoundException {
List<Class> classes = new ArrayList<Class>();
if (!directory.exists()) {
return classes;
}
File[] files = directory.listFiles();
for (File file : files) {
if (file.isDirectory()) {
assert !file.getName().contains(".");
classes.addAll(findClass(file, packageName + "." + file.getName()));
} else if (file.getName().endsWith(".class")) {
classes.add(Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6)));
}
}
return classes;
}






public static void main(String[] args) {


List <Class> list = getAllClassbyInterface(DataUtil.class);

System.out.println("------"+list.size());

for(int i=0;i<list.size();i++){
System.out.println(list.get(i));
}





    }



}
