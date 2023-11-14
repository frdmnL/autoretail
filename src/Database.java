import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class Database {
    public static Connection getConnection() throws SQLException,ClassNotFoundException{
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //用户信息和url
        String url = "jdbc:mysql://localhost:3306/goods?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username="root";
        String password="147258369";
        //返回连接
        return DriverManager.getConnection(url, username, password);
    }
    //向数据库中添加商品信息
    public void adddata(String name,float price,int num)
    {
        String addinfo = "INSERT INTO goodsinfo values('"+name+"','"+price+"','"+num+"')";
        //连接成功，数据库对象 Connection
        try {
            Connection connection = Database.getConnection();
        //执行SQL对象Statement，执行SQL的对象
            Statement statement = connection.createStatement();

            statement.executeUpdate(addinfo);

            statement.close();
            statement.close();
            connection.close();

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //打印数据库内的商品信息
    public void printinfo()
    {
        String ginfo = "SELECT *FROM goodsinfo;";
        int index = 1;
        try {
            Connection connection = Database.getConnection();
            //执行SQL对象Statement，执行SQL的对象
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(ginfo);
            //System.out.println("现还有以下商品供您选择：");
            while(resultSet.next()){
                System.out.print(index+"、"+resultSet.getString("name")+"\t价格："+resultSet.getDouble("price")+"\t剩余："+resultSet.getInt("num")+"\n");
                index++;
            }
            //System.out.println("5、退出购物");
            resultSet.close();
            statement.close();
            statement.close();
            connection.close();

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void updateinfo()
    {
        String ginfo = "SELECT *FROM goodsinfo;";
        int index = 1;
        try {
            Connection connection = Database.getConnection();
            //执行SQL对象Statement，执行SQL的对象
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(ginfo);
            //System.out.println("现还有以下商品供您选择：");
            while(resultSet.next()){
                System.out.print(index+"、"+resultSet.getString("name")+"\t价格："+resultSet.getDouble("price")+"\t剩余："+resultSet.getInt("num")+"\n");
                index++;
            }
            //System.out.println("5、退出购物");
            resultSet.close();
            statement.close();
            statement.close();
            connection.close();

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
