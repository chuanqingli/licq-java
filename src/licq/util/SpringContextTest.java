package licq.util;
import licq.impl.util.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.Timestamp;
import java.util.jar.*;


import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;




public class SpringContextTest{

    // @Test
    public void dotest(){
        DataUtil util = ImplFactory.getBean(DataUtil.class);
        System.out.println(util.getClass().getName());


    }

    // @Test
    public void dotest1(){
        DataUtil util = SpringContext.getBean(DataUtilImpl.class);
        System.out.println(util.getClass().getName());


    }

    private String toString(Object obj){
        if(obj==null)return "";
        return String.valueOf(obj);
    }


    public <A extends Appendable> A create(A buf,Object o1,Object o2,Collection objs)throws IOException{
        if(objs==null||objs.size()<=0)return buf;
        String s1 = toString(o1);
        String s2 = toString(o2);
        for(Object obj : objs){
            String ss = toString(obj);
            buf.append(s1);
            buf.append(ss);
            buf.append(s2);
        }
        return buf;
    }

    @Test
    public void stringtest()throws IOException{
        StringBuilder ss = new StringBuilder(1024);

        CollectionUtil cutil = ImplFactory.getBean(CollectionUtil.class);
        Set list = cutil.create(new LinkedHashSet<String>(),"",new Object[]{1,2,3,4,5,6,"99",88.5,"黎明"});

        ss = create(ss,"\"","\"",list);
        System.out.println(":" + ss + ":");
    }

    public void maptest(){
        MapUtil mutil = ImplFactory.getBean(MapUtil.class);
        CollectionUtil cutil = ImplFactory.getBean(CollectionUtil.class);
        Map map = mutil.create(new HashMap<String,String>(),"","",new Object[]{1,2,3,4,5,6,"99",88.5,"黎明"},new Object[]{11,22,33,44,55,66,"海南",77,88,99});
        Collection list = cutil.create(new LinkedHashSet<String>(),"",new Object[]{1,2,3,4,5,6,"99",88.5,"黎明"});
        List<Map> maplist = new ArrayList<Map>();
        for(int i=0;i<5;i++)maplist.add(map);
        System.out.println(map);
        System.out.println(list);
        System.out.println(maplist);

        JsonUtil jutil = ImplFactory.getBean(JsonUtil.class);
        Map map2 = jutil.toBean(jutil.toJson(map),Map.class);
        List list2 = jutil.toBean(jutil.toJson(list),List.class);
        List list3 = jutil.toBean(jutil.toJson(maplist),List.class);

        long ctime = new Date().getTime();
        Date date = jutil.toBean("" + ctime,Timestamp.class);
        long  lnumber = jutil.toBean("" + date,long.class);

        System.out.println(map2);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(date);
        System.out.println(lnumber);
    }

}
