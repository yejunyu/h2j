package MysqlCon;

import java.sql.*;

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
            // 原生 sql 语句
            String sql = "insert into hero values(null,'ti',500.05,34)";
            s.execute(sql);
            // 查询
            sql = "SELECT * FROM hero";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString(2);
                double HP = rs.getDouble("HP");
                double damage = rs.getDouble("damage");
                System.out.printf("%d\t%s\t%f\t%f%n", id, name, HP, damage);
            }
            // 带占位符的原生 sql 语句
            sql = "INSERT INTO hero VALUES (NULL,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,"gg");
            ps.setDouble(2,500);
            ps.setDouble(3,35);
            ps.execute();
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
