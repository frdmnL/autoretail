import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class shopping
{
    Database database = new Database();
    SocketClient client = new SocketClient();
    int password = 111222;
    String user1 = "admin";
    //创建商品
    //以下数据已弃用
        goods beer = new goods("啤酒",3,30);
        goods juice = new goods("汇源橙汁",3,20);
        goods water = new goods("农夫山泉",2,30);
        goods coffee = new goods("雀巢咖啡",5,20);


    //显示函数
    public void show()
    {
        System.out.println("现还有以下商品供您选择：");
        database.printinfo();
        System.out.println("11、退出购物");
    }

    /***
     * Description: 购买函数
     * @param choose 商品编号
     * @param num 购买数量
     */

    public void shop(int choose,int num)
    {
        int dnumber=0;
        //从数据库读取当前商品的剩余数量
        dnumber = database.trandata(choose);

        //修改商品数量
        dnumber = dnumber-num;
        if(dnumber <= 5)
        {
            //货物数量低于5个，通过socket发送补货信息
            client.sendinfo(choose,dnumber);
        }
        //写回数据库
        database.updateinfonum(choose,dnumber);
        //打印购买成功提示语
        success();

    }
    //如果购买成功打印函数内容
    public void success()
    {
        System.out.println("请选择你的支付方式");
        System.out.println("1、扫码支付\t2、投币支付");//系统提示语
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
        if(select == 1)
        {
            System.out.println("请扫屏幕下方的二维码进行支付");
            System.out.println("购买成功！");
        }else if(select==2){
            System.out.println("请投入硬币");
        }
        else
        {
            System.out.println("欢迎您下次光临！");
        }
    }

    /***
     * Description: 修改商品数量以及价格
     */
    public void upGoods()
    {
        int input;
        boolean continueInput = true;
        Scanner scanner = new Scanner(System.in);

        while (continueInput) {
            System.out.print("请输入商品编号（输入0退出）:");
            input = scanner.nextInt();

            if(input==0){
                continueInput = false;
            }else {
                //获取价格输入
                System.out.print("请输入商品价格：");
                float price = scanner.nextFloat();
                scanner.nextLine();
                System.out.print("请输入商品数量：");
                int num = scanner.nextInt();
                scanner.nextLine();
                //将新的商品信息写回数据库
                database.updateinfoall(input,price,num);
            }
        }
    }
    //添加商品函数
    public void addGoods()
    {
        String str;
        boolean continueInput = true;
        Scanner scanner = new Scanner(System.in);

        while (continueInput) {
            System.out.print("请输入商品名（输入exit退出）:");
            str = scanner.nextLine();

            if(str.equalsIgnoreCase("exit")){
                continueInput = false;
            }else {
                //获取价格输入
                System.out.print("请输入商品价格：");
                float price = scanner.nextFloat();
                scanner.nextLine();
                System.out.print("请输入商品数量：");
                int num = scanner.nextInt();
                scanner.nextLine();
                database.adddata(str,price,num);
            }
        }
    }

    //管理模式,对用户名和密码进行验证
    public void entry()
    {
        int enpassword=0,mod=0;
        String enusr;

        System.out.println("请输入用户名：");
        Scanner en = new Scanner(System.in);
        enusr = en.nextLine();
        //匹配用户名
        if(enusr.equals(user1))
        {
            System.out.println("请输入密码：");
            enpassword = en.nextInt();
            //匹配密码
            if(enpassword == password) {
                System.out.println("请选择模式:\n1.新增商品\t2.修改商品信息");
                mod = en.nextInt();
                if(mod == 1){
                    addGoods();
                }else if(mod == 2){
                    upGoods();
                }
            }
        }
    }
}