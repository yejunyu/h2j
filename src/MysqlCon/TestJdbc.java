package MysqlCon;

/**
 * @author yejunyu
 * @date 2017/12/31.
 */
public class TestJdbc {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动连接成功!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
