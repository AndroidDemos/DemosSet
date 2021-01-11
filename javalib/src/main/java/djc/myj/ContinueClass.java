package djc.myj;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/5/24 17:01
 * @change time
 * @class describe
 */
public class ContinueClass {
    public static void main(String[] args) {
        StringBuffer searchstr = new StringBuffer("hello how are you. ");
        int length = searchstr.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (searchstr.charAt(i) != 'h')
                continue;
            count++;
            searchstr.setCharAt(i, 'h');
        }
        System.out.println("found " + count
                + "  h ");
        System.out.println(searchstr);
    }
}
