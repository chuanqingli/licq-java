package licq.util;

import java.util.*;
import licq.impl.util.*;

public class Test{
    public static void main(String[] args){
        CollectionUtil util = new CollectionUtilImpl();

        Collection ccc = util.create(new LinkedHashSet<Long>(),0l,new Integer[]{23,14,56,73,98,23,87});

        System.out.println(ccc);
        // int[] ttt = new int[]{9,8,3,1,5,6,4,7};
        // System.out.println("你好，测试"
        //                     + set);
    }
}
