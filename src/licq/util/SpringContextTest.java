package licq.util;
import licq.impl.util.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.jar.*;


import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;




public class SpringContextTest{

    @Test
    public void dotest(){
        DataUtil util = ImplFactory.getBean(DataUtil.class);
        System.out.println(util.getClass().getName());


    }

    @Test
    public void dotest1(){
        DataUtil util = SpringContext.getBean(DataUtilImpl.class);
        System.out.println(util.getClass().getName());


    }
}
