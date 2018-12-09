package licq.util;

import java.util.*;
import licq.impl.util.*;
import java.math.*;

import net.sf.json.JSONNull;
import java.sql.Timestamp;
import java.sql.Time;

public class Test{



    public static void main(String[] args){
        // Timestamp ttt = Timestamp.valueOf("2008-12-31 15:20:30.9999");
        // Timestamp ttt = new Timestamp.valueOf("2008-12-31 15:20:30.9999");


        // CollectionUtil util = CollectionUtilImpl.getInstance();

        // // Collection ccc = util.create(new LinkedHashSet<Long>(),0l,new Object[]{23,14,56,73,98,23,87,null,null});
        // Collection ccc = util.create(new ArrayList<Long>(),0l,new Object[]{23,14,56,73,98,23,87,null,null});

        // JSONNull pp = JSONNull.getInstance();


        // Object[] ooo = new Object[]{new String(),new StringBuffer(),new StringBuilder(),pp,new Integer("123"),new Long("459")};
        // for(Object oo : ooo){
        //     if(oo instanceof CharSequence){
        //         System.out.println(oo.getClass() + "==>CharSequence" + oo + ":");
        //         continue;
        //     }
        //     if(oo instanceof Number){
        //         System.out.println(oo.getClass() + "==>Number" + oo + ":");
        //         continue;
        //     }
        //     System.out.println(oo.getClass());
        // }
        // System.out.println(pp);
        // System.out.println("+++++++++++++++");
        DataUtil du = DataUtilImpl.getInstance();
        Object tt = du.toData("Sun Dec 09 15:54:47 CST 2018",new Date(0l),true);
        // Object[] ooo = new Object[]{
        //     // du.toData("2018-12-3 15:20:30.99",new Date(0l),true)
        //     du.toData("2018-12-3 15:20:30.99",new Time(0l),true)
        //     ,du.toData("2018-12-3 15:20:30.99",new Timestamp(0l),true)

        //            };

        // for(Object tt : ooo)
            System.out.println(tt.getClass() + "==>" + tt);


        // // Number tt = new BigInteger("999");
        // String tt = "";
        // // BigDecimal tt = new BigDecimal("999");
        // // Long tt = new Long("999");
        // java.util.Date tt = new java.util.Date();
        // Object pp = du.toData(3600*1000,tt,true);
        // Object pp = du.toData("2015-5-5",tt,true);
        // Object pp = du.toData("2018-56-987",tt,true);
        // System.out.println("pp==>" + pp);

        // du.f(tt);


        // int[] ttt = new int[]{9,8,3,1,5,6,4,7};
        // System.out.println("你好，测试"
        //                     + set);
    }
}
