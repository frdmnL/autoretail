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
        String addinfo = "INSERT INTO goodsinfo(name,price,num)values('"+name+"','"+price+"','"+num+"')";
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
        try {
            Connection connection = Database.getConnection();
            //执行SQL对象Statement，执行SQL的对象
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(ginfo);
            //System.out.println("现还有以下商品供您选择：");
            while(resultSet.next()){
                System.out.print(resultSet.getInt("Sno")+"、"+resultSet.getString("name")+"\t价格："+resultSet.getDouble("price")+"\t剩余："+resultSet.getInt("num")+"\n");
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


    public void updateinfoall(int Sno,float price,int num)
    {
        String md1 = "update goodsinfo set price=";
        String upnum = ",num=";
        String wherez = " where Sno=";
        String sqlmd1;
        int index = 1;
        try {
            Connection connection = Database.getConnection();
            //执行SQL对象Statement，执行SQL的对象
            Statement statement = connection.createStatement();

            sqlmd1 = md1 + price + upnum + num + wherez + Sno;//根据输入修改数据
            statement.executeUpdate(sqlmd1);

            statement.close();
            statement.close();
            connection.close();

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void updateinfonum(int Sno,int num)
    {

        String md2 = "update goodsinfo set num=";
        String wherez = " where Sno=";
        String sqlmd2;
        int index = 1;
        try {
            Connection connection = Database.getConnection();
            //执行SQL对象Statement，执行SQL的对象
            Statement statement = connection.createStatement();

            sqlmd2 = md2 + num + wherez + Sno;//根据输入修改数据
            statement.executeUpdate(sqlmd2);


            statement.close();
            statement.close();
            connection.close();

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    //将数据库数据同步到本地堆栈
    public int trandata(int choose)
    {
        String str = "SELECT num FROM goodsinfo where Sno=";
        String tdata;
        int number;
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = null;
        try {
            connection = Database.getConnection();
            //执行SQL对象Statement，执行SQL的对象
            statement = connection.createStatement();
            //拼接查询语句
            tdata = str+choose;
            resultSet = statement.executeQuery(tdata);
            if(resultSet.next()) {
                number = resultSet.getInt("num");
                //System.out.println("------"+number+"------");
            }else{
                number=0;
            }

            return number;
        //异常处理
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return 0;
        //释放资源
        }
        finally {
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            // 关闭 statement
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // 关闭 connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
