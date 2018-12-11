package licq.impl.util;

import licq.util.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

public final class DateUtilImplTest{
  @Test
    public void toDateTest0(){
      Assert.assertEquals(Timestamp.valueOf("2018-1-3 23:45:7.999999"), DateUtilImpl.getInstance().toDate("2018,1,3,23,45,07,999999",false));
      Assert.assertEquals(Timestamp.valueOf("2018-1-3 23:45:7.999999"), DateUtilImpl.getInstance().toDate("2018   ,1 ,,,  ,3,23,45,07,999999",false));

    }

@Test
  public void testAssertNotNull() {
    org.junit.Assert.assertNotNull("should not be null", new Object());
  }

}
