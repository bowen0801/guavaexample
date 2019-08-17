package bw.guvaexample.base;
import com.google.common.base.Splitter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
/**
 * Splitter测试类
 *
 * @version v1.0.0
 * @since 2019年08月14日
 */
public class SplitterTest {
    /**
     * String 转List
     */
    @Test
    public void test1(){
        String input = "apple-bnana-orange";
        List<String> result = Splitter.on("-").trimResults().splitToList(input);
        System.out.println(result);
        //Assert.assertTrue(result.contains("apple","bnana","orange"));
    }
    /**
     * String 转Map
     */
    @Test
    public void test2(){
        String  input = "Tom=first,Adam=second";
        Map<String, String> result = Splitter.on(",").withKeyValueSeparator("=").split(input);
        Assert.assertEquals("first",result.get("Tom"));
        Assert.assertEquals("second",result.get("Adam"));
    }
    /**
     * 支持使用多个分隔符来分割字符
     */
    @Test
    public void test3(){
        String input = "apple.banana,,orange,,.";
        List<String> result = Splitter.onPattern("[.|,]")
                .omitEmptyStrings()
                .splitToList(input);
        System.out.println(result);//[apple, banana, orange]
        //Assert.assertThat(result, contains("apple", "banana", "orange"));
    }
    /**
     * 每隔多少个字符进行分隔
     */
    @Test
    public void test4(){
        String input = "Hello world";
        List<String> result = Splitter.fixedLength(3).splitToList(input);
        System.out.println(result);//[Hel, lo , wor, ld]
        //assertThat(result, contains("Hel", "lo ", "wor", "ld"));
    }
    /**
     * 还可以让splitter在分割多少个字符后停止分隔，比如
     */
    @Test
    public void test5(){
        String input = "a,b,c,d,e";
        List<String> result = Splitter.on(",")
                .limit(4)
                .splitToList(input);

        Assert.assertEquals(4, result.size());
        System.out.println(result);//[a, b, c, d,e]
        //assertThat(result, contains("a", "b", "c", "d,e"));
    }











}
