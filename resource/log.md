1.修改数据库goodsinfo表的结构，增加主键，即商品编号

2.修改显示函数，从数据库读取数据

3.修改添加函数，添加商品编号

4.修改修改函数，编号格式



2023.11.15

更新交互界面逻辑，限定商品最多10类，输入11退出购物

新函数trandata ，同步数据库数据到本地

修复数据库数据同步函数trandata中的异常与捕获问题



2023.11.18

本项目采用git管理，项目地址

https://github.com/frdmnL/autoretail.git



2023.11.22

尝试新增socket通信功能，编写socket测试例程通过

在SocketClient中添加了sendinfo函数

实现在购买商品时，当商品数量低于某个值通过socket通信发送补货信息



2023.11.26

添加函数注释

在管理模式中新增管理员账户登录功能

弃用goods类，商品信息由数据库管理
