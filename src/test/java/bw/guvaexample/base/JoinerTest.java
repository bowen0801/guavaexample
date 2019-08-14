package bw.guvaexample.base;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * description
 * Joiner 测试类
 * @version v1.0.0
 * @since 2019年08月13日
 */
public class JoinerTest {

    @Test
    public void test(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add(null);
        list.add("c");
        Joiner joiner = Joiner.on(";").skipNulls();
        String join = joiner.join(list);
        System.out.println(join);
    }
    /**
     * List 过滤空值 skipNulls
     */
    @Test
    public void test0(){
        List<String> names = Lists.newArrayList("John", null, "Jane", "Adam", "Tom");
        String join = Joiner.on(",").skipNulls().join(names);
        System.out.println(join);
    }

    @Test
    public void test2(){
        Joiner joiner = Joiner.on(";");
        Assert.assertEquals("a;b;c", joiner.join(new String[]{"a","b","c"}));
    }
    /**
     * 如果被连接String里面要过滤null，可以这样：
     */
    @Test
    public void test3(){
        Joiner joiner = Joiner.on(";").skipNulls();
        Assert.assertEquals("a;c", joiner.join(new String[]{"a",null,"c"}));
    }

    @Test
    public void test4(){
        Joiner joiner = Joiner.on(";").useForNull("!");
        Assert.assertEquals("a;!;c", joiner.join(new String[]{"a",null,"c"}));
    }
    /**
     * Joiner还提供了appendTo函数，对传入的StringBuilder作处理：
     */
    @Test
    public void test5(){
        Joiner joiner = Joiner.on(";");
        StringBuilder ab = new StringBuilder("start: ");
        Assert.assertEquals("start: a;b;c", joiner.appendTo(ab, new String[]{"a","b","c"}).toString());
    }
    /**
     * 除此之外，相关的MapJoiner类也利用Joiner提供了Map的join功能：
     * 键值对之间用&分割，键与值之间用=分割
     */
    @Test
    public void test6(){
        String host="www.baidu.com?";
        Map<String,String> param= Maps.newHashMap();
        param.put("name","minmin");
        param.put("id","0");
        String queryString= Joiner.on("&").withKeyValueSeparator("=").join(param);
        System.out.println(queryString);
        Assert.assertEquals("www.baidu.com?name=minmin&id=0", host+queryString);
    }
    /**
     * List转String null替换成其他值
     */
    @Test
    public void test7(){
        List<String> names = Lists.newArrayList("John", null, "Jane", "Adam", "Tom");
        String join = Joiner.on(",").useForNull("nameless").join(names);
        System.out.println(join);//John,nameless,Jane,Adam,Tom
    }











}
