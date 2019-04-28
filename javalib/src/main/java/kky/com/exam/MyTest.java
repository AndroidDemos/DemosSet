package kky.com.exam;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/4/16 17:29
 * @change time
 * @class describe
 */
public class MyTest {

    public static void main(String[] args) {
        String s = "180416155742.917841";
        s = s.substring(0, s.indexOf("."));
        String hh = s.substring(6, 8);
        String mm = s.substring(8, 10);
        String ss = s.substring(10, s.length());
        System.out.print(hh + ":" + mm + ":" + ss);
    }
}
