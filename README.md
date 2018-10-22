# MyBlog
项目主要是用Spring + SpringMVC + MyBatis框架部分功能使用了Redis做缓存，并使用RabbitMQ做同步<br>
前段使用的是Html+css+js+bootstrap后台使用的是EasyUI<br>
以下是部分功能展示
===
首页板块
---
![xxx](https://github.com/zytKing/MyBlog/blob/master/images/show1.png)
分类博客板块
---
![xxx](https://github.com/zytKing/MyBlog/blob/master/images/show3.png)
留言板块
---
![xxx](https://github.com/zytKing/MyBlog/blob/master/images/show2.png)
登陆板块
---
登陆成功会在cookie和redis服务里面存一个Token他代表用户的唯一标志
![xxx](https://github.com/zytKing/MyBlog/blob/master/images/show4.png)
后台版块（easyUI实现）
---
这里有一个拦截器，拦截器会去cookie和redis服务里去找Token找不到就返回登陆页面
![xxx](https://github.com/zytKing/MyBlog/blob/master/images/show5.png)
写博客页面，用的kindeditor富文本编辑器
---
![xxx](https://github.com/zytKing/MyBlog/blob/master/images/show6.png)
博客列表页面
---
![xxx](https://github.com/zytKing/MyBlog/blob/master/images/show7.png)
