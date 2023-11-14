import java.sql.*;

public class Sql {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/goods?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username="root";
        String password="147258369";
//        3.连接成功，数据库对象 Connection
        Connection connection = DriverManager.getConnection(url,username,password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = connection.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM goodsinfo;";
        String sql1 = "INSERT INTO goodsinfo values('蜜雪冰城','4','20')";
        //ResultSet resultSet = statement.executeQuery(sql);
        //statement.executeUpdate(sql1);
//        while(resultSet.next()){
//            System.out.print(resultSet.getString("name")+" ");
//            System.out.print(resultSet.getDouble("price")+" ");
//            System.out.println(resultSet.getInt("num")+" ");
//
//        }
//        6.释放连接
        //resultSet.close();
        statement.close();
        statement.close();
        connection.close();
    }
}

