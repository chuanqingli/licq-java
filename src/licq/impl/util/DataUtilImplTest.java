package licq.impl.util;

import licq.util.*;
import org.junit.*;
import java.util.*;
import java.sql.Timestamp;
public final class DataUtilImplTest{

    public void toDataTest(){
        Class[] ttt0 = new Class[]{int.class,long.class,float.class,double.class,boolean.class};
        Class[] ttt1 = new Class[]{Integer.class,Long.class,Float.class,Double.class,Boolean.class};

        for(Class tt : ttt0)Assert.assertTrue(tt.isPrimitive());
        for(Class tt : ttt1)Assert.assertFalse(tt.isPrimitive());


    }


    @Test
    public void stringtest(){
        // List<Integer> len = Arrays.asList(new Integer[]{4,2,2,2,2,2,3});
        List<Integer> len = ImplFactory.getBean(CollectionUtil.class).create(new ArrayList<Integer>(),new Integer[]{4,2,2,2,2,2,3});
        String sss = "20181221180709789你好，黎明";
        System.out.println(ImplFactory.getBean(StringUtil.class).split(sss,len));
    }
    public void toDataTest00(){
        DataUtil dutil = ImplFactory.getBean(DataUtil.class);
        // System.out.println(dutil.getClass());
        // StringBuilder buf = new StringBuilder(1024);
        // buf = dutil.toData(8975.45,buf,true);
        // buf.insert(0,"你好啊==>");
        // // String buf = dutil.toData(8975.45,"",true);
        // System.out.println(buf);

        Timestamp curtime = Timestamp.valueOf("1000-01-01 00:00:00");// Timestamp.valueOf("2016-05-08 10:20:1");// new Timestamp(new Date().getTime());
        // System.out.println("curtime==>" + curtime);

        Date dd = dutil.toData("2017-",curtime,true);
        System.out.println(dd);
        String rex = ".*[^0-9]+.*";
        Assert.assertTrue("2017d".matches(rex));
        Assert.assertTrue("dddd".matches(rex));
        Assert.assertFalse("2789".matches(rex));
        Assert.assertTrue("27.89".matches(rex));
    }

}
