package numberAndString;

/**
 * @author yejunyu
 * @data 2017/12/14
 */
public class str4 {
    public static void test1(){
        Long start = System.currentTimeMillis();
        String a = "";
        for (int i = 0; i < 10000; i++) {
            a += Str.randomStr1(10);
        }
        System.out.println(System.currentTimeMillis()-start);
        start = System.currentTimeMillis();
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            b.append(Str.randomStr1(10));
        }
        System.out.println(System.currentTimeMillis()-start);
    }
    public static void main(String[] args) {
        /**
         * String与StringBuffer的性能区别?
         生成10位长度的随机字符串
         然后,先使用String的+,连接10000个随机字符串,计算消耗的时间
         然后,再使用StringBuffer连接10000个随机字符串,计算消耗的时间
         */
        test1();
    }
}
