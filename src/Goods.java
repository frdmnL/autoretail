//此类已弃用2023.11.26
class goods
{
    String goodsname;   //商品名称
    float price;       //商品价格
    int number;         //商品剩余数量
    //默认初始化商品函数
    public goods()
    {
    }
    //初始化商品函数
    public goods(String goodsname, float price, int number)
    {
        this.goodsname = goodsname;
        this.price = price;
        this.number = number;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}