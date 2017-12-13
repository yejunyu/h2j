package numberAndString;

/**
 * 把浮点数 3.14 转换为 字符串 "3.14"
 再把字符串 “3.14” 转换为 浮点数 3.14

 如果字符串是 3.1a4，转换为浮点数会得到什么？
 */

/**
 * @author yejunyu
 * @date 2017/12/12
 */
public class StringTransform {
    public static void main(String[] args) {
        float pi = 3.14F;
        String piStr = String.valueOf(pi);
        System.out.println(piStr);
        String pi1 = "3.14";
        float pi2 = Float.valueOf(pi1);
        System.out.println(pi2);
        // 或报错 java.lang.NumberFormatException: For input string: "3.1a4"
    }
}
