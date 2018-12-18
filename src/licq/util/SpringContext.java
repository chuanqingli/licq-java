package licq.util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// import org.springframework.core.io.*;
public class SpringContext{
    private static final ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:config/spring.xml");
    // private static final Resource __resource = new ClassPathResource("config/mybatis.cfg.xml");

    public static <T> T getBean(Class<T> s){
        return appContext.getBean(s);
    }

    public static <T> T getBean(String name,Class<T> s){
        return appContext.getBean(name,s);
    }


    public static Object getBean(String name,Object... args){
        return appContext.getBean(name,args);
    }

    // private static Resource getResource(){
    //     return __resource;
    // }
}
