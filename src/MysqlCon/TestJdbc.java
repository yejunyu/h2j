package MysqlCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author yejunyu
 * @date 2017/12/31.
 */
public class TestJdbc {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动连接成功!");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/h2j?characterEncoding=UTF-8",
                    "root", "123456");
            System.out.println(c);
            s = c.createStatement();
            System.out.println(s);
            String sql = "insert into hero values(null,'ti',500.05,34)";
            s.execute(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != s){
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != c){
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
