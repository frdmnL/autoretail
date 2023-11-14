import java.util.Scanner;
//用户类
public class User
{
    public static void main(String[] args)//主函数
    {
        Scanner sc = new Scanner(System.in);
        shopping shopping = new shopping();//创建对象
        Database database = new Database();

        while(true) {
            System.out.println("选择模式：1、购物\t2、管理");//系统提示语
            int select = sc.nextInt();//保存客户输入的数字
            if (select == 1)//如果客户输入的是“1”也就是需要进行购物
            {
                System.out.println("欢迎使用XX大学饮料自动贩卖机");//系统提示语
                shopping.show();//打印商品列表
                System.out.println("请选择相应编号！");//提示用于选择商品
                int choose = sc.nextInt();//保存客户输入的商品编号
                //边界限定
                while (choose > 5 || choose <= 0) {
                    System.out.println("没有此商品，请重新选择！");//提示用户输入的编码没有对应的商品
                    choose = sc.nextInt();//再次保存客户输入的编号
                }
                if (choose == 5)//如果是“5”退出购物
                {
                    System.out.println("欢迎您下次光临！");
                    return;
                }
                System.out.println("请输入购买数量！");//提示用户输入需要购买的数量
                int num = sc.nextInt();//保存用户需要购买的数量
                while (true) {
                    shopping.shop(choose, num);//调用购买函数
                    //database.adddata("黑咖啡",10,40);
                    System.out.println();
                    shopping.show();//显示购买后的商品列表
                    System.out.println("如继续购物，请再次选择相应编号！");
                    choose = sc.nextInt();//保存用户输入的商品编号
                    //边界限定
                    while (choose > 5 || choose <= 0) {
                        System.out.println("没有此商品，请重新选择！");
                        choose = sc.nextInt();
                    }
                    if (choose == 5) {
                        System.out.println("欢迎您下次光临！");
                        break;
                    }
                    System.out.println("请输入购买数量");//提示语
                    num = sc.nextInt();//保存客户购买数量
                }
            }
            else//选择“2”管理模式
            {
                shopping.entry();

            }
        }
    }


}