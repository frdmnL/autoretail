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
//        System.out.println("1、"+beer.goodsname+"\t价格："+beer.price+"\t剩余："+beer.number);
//        System.out.println("2、"+juice.goodsname+"\t价格："+juice.price+"\t剩余："+juice.number);
//        System.out.println("3、"+water.goodsname+"\t价格："+water.price+"\t剩余："+water.number);
//        System.out.println("4、"+coffee.goodsname+"\t价格："+coffee.price+"\t剩余："+coffee.number);
        System.out.println("5、退出购物");
    }
    //购买函数shou
    public void shop(int choose,int num)
    {
        switch (choose)
        {
            case 1://如果选择的是商品“1”
                if(beer.number == 0)//如果当前的库存为0
                {
                    System.out.println("商品已售完，等待补货！");//提示用户商品已售完
                }
                else if(num>beer.number)//如果用户需要购买的数量大于库存的数量
                {
                    System.out.println("您需要购买的商品库存不足，请重新选择！");//提示用户当前商品库存不足
                }
                else
                {
                    beer.number = beer.number - num;//更改库存数量=购买前的库存数量-用户购买的数量
                    success();//提示用户购买成功
                }
                break;
            case 2://如果选择的是商品“2”
                if(juice.number == 0)//如果当前的库存为0
                {
                    System.out.println("商品已售完，等待补货！");//提示用户商品已售完
                }
                else if (num>juice.number)//如果用户需要购买的数量大于库存的数量
                {
                    System.out.println("您需要购买的商品库存不足，请重新选择！");//提示用户当前商品库存不足
                }
                else
                {
                    juice.number = juice.number - num;//更改库存数量=购买前的库存数量-用户购买的数量
                    success();//提示用户购买成功
                }
                break;
            case 3://如果选择的是商品“3”
                if(water.number == 0)//如果当前的库存为0
                {
                    System.out.println("商品已售完，等待补货！");//提示用户商品已售完
                }
                else if (num>water.number)//如果用户需要购买的数量大于库存的数量
                {
                    System.out.println("您需要购买的商品库存不足，请重新选择！");//提示用户当前商品库存不足
                }
                else
                {
                    water.number = water.number - num;//更改库存数量=购买前的库存数量-用户购买的数量
                    success();//提示用户购买成功
                }
                break;
            case 4://如果选择的是商品“4”
                if(coffee.number == 0)//如果当前的库存为0
                {
                    System.out.println("商品已售完，等待补货！");//提示用户商品已售完
                }
                else if (num>coffee.number)//如果用户需要购买的数量大于库存的数量
                {
                    System.out.println("您需要购买的商品库存不足，请重新选择！");//提示用户当前商品库存不足
                }
                else
                {
                    coffee.number = coffee.number - num;//更改库存数量=购买前的库存数量-用户购买的数量
                    success();//提示用户购买成功
                }
                break;
            case 5://如果输入的是“5”
                System.out.println("欢迎您下次光临！");//提示语
                //controlObj.entry();
                break;
            default://其他
                System.out.println("没有此商品，请重新选择");//提示语
                break;
        }
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

    public void addGoods()
    {
        String input;
        boolean continueInput = true;
        Scanner scanner = new Scanner(System.in);

        while (continueInput) {
            System.out.print("请输入商品名称（输入exit退出）:");
            input = scanner.nextLine();

            if(input.equalsIgnoreCase("exit")){
                continueInput = false;
            }else {
                //获取价格输入
                System.out.print("请输入商品价格：");
                double price = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("请输入商品数量：");
                int num = scanner.nextInt();
                scanner.nextLine();
                switch (input)
                {
                    case "啤酒":
                        //System.out.println("---");
                        beer.setNumber(num);
                        beer.setPrice(price);
                        break;
                    case "汇源果汁":
                        juice.setNumber(num);
                        juice.setPrice(price);
                        break;
                    case "农夫山泉":
                        water.setNumber(num);
                        water.setPrice(price);
                        break;
                    case "雀巢咖啡":
                        coffee.setNumber(num);
                        coffee.setPrice(price);
                        break;
                }
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
            addGoods();

    }


}