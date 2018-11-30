package licq.util;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.sf.json.*;
import org.codehaus.jackson.map.ObjectMapper;
import java.lang.reflect.*;

public class DataUtil{
    private static final Logger logger = LoggerFactory.getLogger(DataUtil.class);

    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> T toData(Object oo,T cc){
        return toData(oo,cc,false);
    }
    //空或异常时，返回默认值;bthrow异常时是否抛出
    public static <T> T toData(Object oo,T cc,boolean isthrow){
        if(cc==null)return null;
        if(oo==null)return cc;

        if(cc instanceof String){
            return (T)oo.toString();
        }

        if(cc instanceof Number){
            String ss = oo.toString();

            int nindex = ss.indexOf(".");
            if(nindex>0){
                if(((cc instanceof Integer)==true)||((cc instanceof Long)==true)){
                    ss = ss.substring(0,nindex);
                }
            }

            try{
                Constructor c1=cc.getClass().getDeclaredConstructor(new Class[]{String.class});
                return (T)c1.newInstance(new Object[]{ss});
            }catch(Exception err){
                if(isthrow)throw new RuntimeException("数据转换时发生异常",err);
                return cc;
            }
        }

        if(JSONNull.getInstance().equals(oo))return cc;
        return (T)oo;
    }

    public static String toJson(Object obj){
        try{
            return JSONObject.fromObject(obj).toString();
            // return mapper.writeValueAsString(obj);
        }catch(Exception err){
            logger.info(err.toString());
            return toData(obj,"");
        }

        // if(obj==null)return null;


        // com.alibaba.fastjson.JSONObject obj2 = com.alibaba.fastjson.JSONObject.parseObject(obj);

        // // JSONObject obj2 =JSONObject.fromObject(obj);
        // if(obj2==null)return null;
        // return obj2.toString();
    }

    //不定长参数转List
    public static <T> List<T> args2List(T... list){
        List<T> resp = new ArrayList<T>();
        if(list==null||list.length<=0)return resp;
        for(int i=0;i<list.length;i++){
            resp.add(list[i]);
        }
        return resp;
    }

    //不定长参数转字符串
    public static String args2Str(Object... list){
        if(list==null||list.length<=0)return "";
        StringBuilder sBuf = new StringBuilder(1024);
        for(int i=0;i<list.length;i++){
            if(list[i]==null)continue;
            sBuf.append(list[i]);
        }
        return sBuf.toString();
    }

    public static String args2Sql(Object... list){
        if(list==null||list.length<=0)return "''";
        StringBuilder sBuf = new StringBuilder(1024);
        for(int i=0;i<list.length;i++){
            if(list[i]==null)continue;
            sBuf.append(list[i]);
        }

        return args2Str("'",sBuf.toString().replace("'","''"),"'");
    }


    // public static <A,B> List<B> createList(List<A> list,B bb){
    //     if(list==null)return null;
    //     List<B> resp = new ArrayList<B>();
    //     for(A aa : list){
    //         B bbb = toData(aa,bb,null);
    //         resp.add(bbb);
    //     }
    //     return resp;
    // }


    public static <T> Set<List<T>> list2Set_2(List<Map<String,Object>> list,List<String> names,T cc){
        Set<List<T>> set = new LinkedHashSet<List<T>>();
        if(list==null||list.size()<=0)return set;
        for(Map<String,Object> map : list){
            List<T> tmplist = new ArrayList<T>();
            for(int i=0,nlen=names.size();i<nlen;i++){
                T sortid = toData(map.get(names.get(i)),cc);
                tmplist.add(sortid);
            }
            set.add(tmplist);
        }
        return set;
    }

    public static Set<List<Object>> list2Set_2(List<Map<String,Object>> list,List<String> names){
        Set<List<Object>> set = new LinkedHashSet<List<Object>>();
        if(list==null||list.size()<=0)return set;
        for(Map<String,Object> map : list){
            List<Object> tmplist = new ArrayList<Object>();
            for(int i=0,nlen=names.size();i<nlen;i++){
                tmplist.add(map.get(names.get(i)));
            }
            set.add(tmplist);
        }
        return set;
    }


    public static <T> Map<List<T>,Map<String,Object>> list2Map_2(List<Map<String,Object>> list,List<String> names,T cc){
        Map<List<T>,Map<String,Object>> resp = new HashMap<List<T>,Map<String,Object>>();
        if(list==null||list.size()<=0)return resp;
        for(Map<String,Object> map : list){
            List<T> tmplist = new ArrayList<T>();
            for(int i=0,nlen=names.size();i<nlen;i++){
                T sortid = toData(map.get(names.get(i)),cc);
                tmplist.add(sortid);
            }
            resp.put(tmplist,map);
        }
        return resp;
    }

    public static Map<List<Object>,Map<String,Object>> list2Map_2(List<Map<String,Object>> list,List<String> names){
        Map<List<Object>,Map<String,Object>> resp = new HashMap<List<Object>,Map<String,Object>>();
        if(list==null||list.size()<=0)return resp;
        for(Map<String,Object> map : list){
            List<Object> tmplist = new ArrayList<Object>();
            for(int i=0,nlen=names.size();i<nlen;i++){
                tmplist.add(map.get(names.get(i)));
            }
            resp.put(tmplist,map);
        }
        return resp;
    }

    //从list中，取键名为name的记录组成Set
    public static <T> Set<T> list2Set(List<Map<String,Object>> list,String name,T cc){
        Set<T> set = new LinkedHashSet<T>();
        if(list==null||list.size()<=0)return set;
        for(Map<String,Object> map : list){
            T sortid = toData(map.get(name),cc);//CommonUtil.GetReqLong(map.get("sortid"));
            set.add(sortid);
        }
        return set;
    }


    public static <T> Set<T> list2Set(List<T> list){
        if(list==null||list.size()<=0)return new LinkedHashSet<T>();
        return new LinkedHashSet<T>(list);
    }

    public static <T> Set<T> args2Set(T... list){
        if(list==null||list.length<=0)return new LinkedHashSet<T>();
        List<T> list1 = Arrays.asList(list);
        return list2Set(list1);
    }

    //并集+;差集-;交集*
    public static <T> Set<T> setOpSet(String flag,Set<T> t0,Set<T> t1){
        if(t0==null)t0=new HashSet<T>();
        if(t1==null)t1=new HashSet<T>();
        final Set<String> flagset = args2Set("+","-","*");
        if(!flagset.contains(flag))return t0;
        Set<T> resp = new HashSet<T>(t0);
        if("+".equals(flag)){
            resp.addAll(t1);
        }else if("-".equals(flag)){
            resp.removeAll(t1);
        }else if("*".equals(flag)){
            resp.retainAll(t1);
        }
        return resp;
    }

    public static <T> Set<T> str2Set(String s,String regex,T cc){
        Set<T> set = new LinkedHashSet<T>();
        if(s==null||s.length()<=0)return set;
        String[] ss = s.split(regex);
        for(String sss : ss){
            T sortid = toData(sss,cc);//CommonUtil.GetReqLong(map.get("sortid"));
            set.add(sortid);
        }
        return set;
    }

    public static <A,B> Map<A,B> list2Map(List<A> name,List<B> obj,Map<A,B> resp){
        if(resp==null)resp = new HashMap<A,B>();
        if(name==null)return resp;
        if(obj==null||obj.size()<name.size())return resp;

        for(int i=0;i<name.size();i++){
            resp.put(name.get(i),obj.get(i));
        }
        return resp;
    }

    public static <A,B> Map<A,B> list2Map(List<A> name,List<B> obj){
        return list2Map(name,obj,null);
    }

    public static <A,B> Map<A,B> arr2Map(A[] name,B[] obj){
        return arr2Map(name,obj,null);
    }

    public static <A,B> Map<A,B> arr2Map(A[] name,B[] obj,Map<A,B> resp){
        if(resp==null)resp = new HashMap<A,B>();
        if(name==null)return resp;
        if(obj==null||obj.length<name.length)return resp;
        List<A> aaa = Arrays.asList(name);
        List<B> bbb = Arrays.asList(obj);
        return list2Map(aaa,bbb,resp);
    }

    public static Map<String,String> arr2Map(String[] name,Object[] obj,Map<String,String> resp){
        if(resp==null)resp = new HashMap<String,String>();
        if(name==null)return resp;
        if(obj==null||obj.length<name.length)return resp;
        for(int i=0;i<name.length;i++){
            resp.put(name[i],(obj[i]==null)?null:obj[i].toString());
        }
        return resp;
    }

    public static <A,B> Map<A,B> json2Map(String json,A aa,B bb){
        if(json==null||json.length()<=0)return new HashMap<A,B>();
        JSONObject jsonobj = null;
        try{
            jsonobj = JSONObject.fromObject(json);
        }catch(Exception err){}
        return json2Map(jsonobj,aa,bb);
    }

    public static <A,B> Map<A,B> json2Map(JSONObject json,A aa,B bb){
        Map<A,B> resp = new HashMap<A,B>();
        if(json==null||json.size()<=0)return resp;
        for(Object key : json.keySet()){//不能用Iterator iter = json.keys();，报错
            A aaa = toData(key,aa);
            B bbb = toData(json.get(key),bb);
            resp.put(aaa,bbb);
        }
        return resp;
    }

    public static <A,B> Map<A,B> json2Map(Map json,A aa,B bb){
        Map<A,B> resp = new HashMap<A,B>();
        if(json==null)return resp;
        for(Object key : json.keySet()){//不能用Iterator iter = json.keys();，报错
            A aaa = toData(key,aa);
            B bbb = toData(json.get(key),bb);
            resp.put(aaa,bbb);
        }
        return resp;
    }

    public static <A,B> Map<A,B> req2Map(javax.servlet.ServletRequest request){
        if(request==null)return new HashMap<A,B>();
        return request.getParameterMap();
    }

    //并集+;差集-;交集*
    public static <A,B> Map<A,B> mapOpSet(String flag,Map<A,B> t0,Set<A> t1){
        if(t0==null)t0=new HashMap<A,B>();
        if(t1==null)t1=new HashSet<A>();

        final Set<String> flagset = args2Set("-","*");
        if(!flagset.contains(flag))return t0;
        Map<A,B> resp = new HashMap<A,B>(t0);
        if("-".equals(flag)){
            resp.keySet().removeAll(t1);
        }else if("*".equals(flag)){
            // Set<A> t2 = new HashSet<A>(resp.keySet());
            // t2.removeAll(t1);
            // resp.keySet().removeAll(t2);
            resp.keySet().retainAll(t1);
        }
        return resp;
    }

    public static <K,A,B> Map<K,Map<A,B>> list2Map(List<Map<A,B>> list,A fieldname,K keyval){
        Map<K,Map<A,B>> resp = new HashMap<K,Map<A,B>>();
        if(list==null||list.size()<=0)return resp;
        if(fieldname==null||keyval==null)return resp;
        for(Map<A,B> map : list){
            K key = toData(map.get(fieldname),keyval);
            resp.put(key,map);
        }
        return resp;
    }

    public static <K,A,B> Map<K,List<Map<A,B>>> list2Map_3(List<Map<A,B>> list,A fieldname,K keyval){
        Map<K,List<Map<A,B>>> resp = new HashMap<K,List<Map<A,B>>>();
        if(list==null||list.size()<=0)return resp;
        if(fieldname==null||keyval==null)return resp;
        for(Map<A,B> map : list){
            K key = toData(map.get(fieldname),keyval);
            List<Map<A,B>> list2 = resp.get(key);
            if(list2==null){
                list2 = new ArrayList<Map<A,B>>();
                resp.put(key,list2);
            }
            list2.add(map);
        }
        return resp;
    }

    public static void map2Map(Map<String,Object> inmap,Map<String,Object> outmap,String... args){
        if(inmap==null||inmap.size()<=0)return;
        if(args==null||args.length<=0)return;
        if(outmap==null)outmap=new HashMap<String,Object>();

        for(String ss : args){
            if(!inmap.containsKey(ss))continue;
            outmap.put(ss,inmap.get(ss));
        }
    }

    // public static String checkEmptyMapKey(Map<String,Object> inmap,String... args){
    //     if(inmap==null||inmap.size()<=0)return null;
    //     for(String ss : args){
    //         if(!inmap.containsKey(ss)) return ss;
    //     }
    // }

    public static void main00(String[] args){
        Map resp0 = arr2Map(new Integer[]{12,13,15,78},new String[]{"22","33","55","你好，测试"});
        Map resp1 = arr2Map(new String[]{"12","13","15","78"},new String[]{"22","33","55","你好，测试"});

        Map<Integer,String> resp = new HashMap<Integer,String>();
        resp.putAll(resp0);
        logger.debug(toJson(resp));
        logger.debug("resp==>" + resp.get(78));
        Map<Long,String> resp2 = json2Map(toJson(resp),0l,"");
        logger.debug(toJson(resp2));
        logger.debug("resp2==>" + resp2.get(78l));
    }

    public static void main01(String[] args){

        Map<String,Object> resp0 = arr2Map(new String[]{"100","99","12","13","15","78"},new Object[]{100,99,22,33,55,"你好，测试"},new LinkedHashMap<String,Object>());
        Map<String,String> resp1 = json2Map(resp0,"","");
        Map<String,String> resp2 = new LinkedHashMap<String,String>();
        resp2.putAll(resp1);
        logger.debug(toJson(resp0));
        logger.debug(toJson(resp1));
        logger.debug(toJson(resp2));

        // Map<String,String> resp1 = createMap("-",resp0,createSet("12","13"));
        // Map<String,String> resp2 = createMap("*",resp0,createSet("12","13"));
        // // Map<Integer,String> resp = createMap(resp0,0,"");

        // // // Map resp0 = createMap(new Integer[]{12,13,15,78},new Integer[]{22,33,55,78});
        // // // Map<Integer,Integer> resp = new HashMap<Integer,Integer>();
        // // // resp.putAll(resp0);
        // logger.debug(toJson(resp1));
        // logger.debug(toJson(resp2));
        // logger.debug("resp==>" + resp.get(78));
        // Map<Long,Long> resp2 = createMap(toJson(resp),0l,0l);
        // logger.debug(toJson(resp2));
        // logger.debug("resp2==>" + resp2.get(78l));
    }

    private static class tttt{
        public int aa = 0;
        public long bb = 2l;
        public float cc = 3f;
        public String dd = "测试";
    }


    public static void main(String[] args){
        logger.info("bbbb==>" + toJson(null));
        logger.info("cccc==>" + toJson(""));
        logger.info("dddd==>" + toJson(new HashMap()));
        logger.info("eeee==>" + toJson(new tttt()));
        logger.info("hhhh==>" + toJson(new Long("55342")));
        logger.debug(null + "aaaa");
        // String sjson = "{\"fname\":\"MoMaxTime\",\"gwtype\":1008,\"rstime\":\"2016-09-26 11:13:49.870\"}";
        // Map<String,Object> map = toMap(sjson);
        // logger.debug("" + CommonUtil.GetReqNo(map.get("gwtype")));
        // logger.debug("" + Integer.MIN_VALUE);
        // Object tt = null;
        // Object aa = toData("13.5",tt,null);
        // Object bb = toData(13.5,tt,null);
        // logger.debug("aa=>" + aa);
        // logger.debug("bb=>" + bb);
        // logger.debug("tt=>" + CommonUtil.GetReqNo("16.87"));
    }
}
