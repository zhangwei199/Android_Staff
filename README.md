# 员工管理系统APP

>本项目是一个能与web服务器端连接操作MySQL数据库来管理员工信息的安卓软件。

>本项目具有Android客户端、web服务端和MySQL数据库。

>注意：如要使用Android客户端所有功能，须先开启web服务端！

>主要功能有： 
>>客户端通过http来访问服务器端的Servlet来实现用户登录注册操作、<br>
对员工信息进行增删改查操作 和管理员操作（重置密码、销毁用户账号）；<br>
利用Handler多线程同时进行判断用户登录是否成功、登录成功后跳转页面两个操作；<br> 
从web服务器获取数据转化为Json数据，用Json解析, <br> 
将解析的Json数据用SimpleAdapter适配器适配列表并显示。

> 想了解更多详情请观看本项目其他文档.

## 运行效果图：
![image](https://github.com/zhangwei199/Android_Staff/raw/master/项目效果图/1.png)
![image](https://github.com/zhangwei199/Android_Staff/raw/master/项目效果图/2.png)
![image](https://github.com/zhangwei199/Android_Staff/raw/master/项目效果图/3.png)
![image](https://github.com/zhangwei199/Android_Staff/raw/master/项目效果图/4.png)
![image](https://github.com/zhangwei199/Android_Staff/raw/master/项目效果图/5.png)
![image](https://github.com/zhangwei199/Android_Staff/raw/master/项目效果图/6.png)
