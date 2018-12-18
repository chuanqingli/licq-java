package licq.util;
import licq.impl.util.*;
import java.util.*;


import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;




public class SpringContextTest{

  @Test
    public void toDateTest0(){

Class<?> interfaces[] = CollectionUtilImpl.class.getInterfaces();

System.out.println("==>" + interfaces.length + ":" + Arrays.asList(interfaces)  + "::");
      CollectionUtil util = ImplFactory.getBean(CollectionUtil.class);


      Collection<Integer> set = util.create(new LinkedHashSet<Integer>(),0,new Object[]{123,"123","345",345.6,895.6});
      System.out.println("==>" + set + "::");


      // DataUtil util = SpringContext.getBean(DataUtil.class);

      // int nnn = util.toData("234.6",0);
      // System.out.println("==>" + nnn + "::");
      // DataUtil util2 = SpringContext.getBean(DataUtil.class);
      // System.out.println("==>" + (util==util2) + "::");
    }

}
