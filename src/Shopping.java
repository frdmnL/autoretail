import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class shopping
{
    Database database = new Database();
    int password = 111222;
    //创建商品
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
    //购买函数shou
    public void shop(int choose,int num)
    {
        int dnumber=0;
        //从数据库读取当前商品的剩余数量
        dnumber = database.trandata(choose);

        //修改商品数量
        dnumber = dnumber-num;
        //写回数据库
        database.updateinfonum(choose,dnumber);
        //写回数据库


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
                database.updateinfoall(input,price,num);
//                switch (input)
//                {
//                    case "啤酒":
//                        //System.out.println("---");
//                        beer.setNumber(num);
//                        beer.setPrice(price);
//                        break;
//                    case "汇源果汁":
//                        juice.setNumber(num);
//                        juice.setPrice(price);
//                        break;
//                    case "农夫山泉":
//                        water.setNumber(num);
//                        water.setPrice(price);
//                        break;
//                    case "雀巢咖啡":
//                        coffee.setNumber(num);
//                        coffee.setPrice(price);
//                        break;
//                }
            }
        }
    }

    public void entry()
    {
        int enpassword=0;
        System.out.println("请输入密码：");
        Scanner enpw = new Scanner(System.in);
        enpassword = enpw.nextInt();

        if(enpassword == password)
            upGoods();

    }


}