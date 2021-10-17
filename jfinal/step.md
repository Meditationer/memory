# 环境

- 环境工具：idea2017.3.5+sdk(jdk1.8.0)+maven3.5.2+mysql5.5
- 框架jfinal+bootstrap

## jfinal项目

- maven(父子工程)+idea&emsp;[jfinal配置](http://www.jfinal.com/share/36?p=1#reply_start)
- 父工程的pom.xml中关于jfinal依赖修改为

```java
  <dependency>
    <groupId>com.jfinal</groupId>
    <artifactId>jfinal</artifactId>
    <version>${jfinal.version}</version>
    <scope>compile</scope>
 </dependency>
 ```

## 项目执行

- 从java目录中的`<font color="red">web容器初始化</font>.开始加载项目加载JFinal的过滤器,并执行其init方法,  
初始化用户在configClass中配置的相关信息,plugins其实是一个List, Routes其实是map.
  1. startPlugins方法拿出用户配置的插件信息，通过DbKit便拥有了我们自己的配置的dataSource
  2. getInterceptorArray配置拦截器
  3. controller(action),及其要执行的方法,拦截器作为map的value以及配置的actionKey(路由)作为map的key加入到Actionmapping中的mapping中(这就是为什么可根据URL执行响应了)
  4. 6.执行过滤器的doFilter方法，该方法也会在每一次请求的过程中都会拦截我们请求的URI，找到对应的action并从action中拿出具体的controller。

## Service 和 Sql（curd）
- Service在java目录中 ，Sql文件在resources目录下
1. Db + Record模式：无需映射，Record相当于一个通用的Model
   1. 预置
      > DbBus.save("tableName", record);【record列名和值： record.set("column",value);】  
       Db.update("uL", u); u = Db.findById("uL",25).set("C", "V");查询id值为25并更新字段

   2. sql语句中用？的[Db(all.sql:包含A.sql的路径), A(A.sql)，B(语句名)]
      > Db.find(Db.getSql("A.B"),ID,Year);
      > SELECT * from tableName where  ID=? and Year = ?

   3. sql 语句用para的[kv 参数Kv cond = Kv.by("ID",V);也是存]
      > Db.find(Db.getSqlPara("A.B",kv));  
      #sql("B")  
        	select  * from Basfujupeifa where IsDel=0  
       	  #if(ID)  
           	 and ID <=#para(ID)  
       	  #end  
	    #end  

### web容器初始化

- 启动一个WEB项目的时候，WEB容器会去读取它的配置文件web.xml，读取`<context-param>`和`<listener>`结点  
 加载顺序context-param -> listener -> filter -> servlet
  1. 创建一个ServletContext（servlet上下文），这个 web项目的所有部分都将共享这个上下文
  2. 建立ServletContext.容器`<context-param>`name作为键，value作为值，转化为键值对，存入ServletContext。　　
  3. 容器将`<context-param>`转换为键值对，并交给 servletContext。 因为listener, filter 等初始化时会用到这些信息
  4. 容器创建`<listener>`中的类实例，创建监听器（加载顺序不是编写的顺序）
  5. 加载filter和servlet
- 举例：你可能想在项目启动之前就打开数据库，那么这里就可以在`<context-param>`中设置数据库的连接方式（驱动、url、user、password），在监听类中初始化数据库的连接。  
Servlet是在第一次发起请求的时候被实例化的
- web.xml标签详解:`<web-app></web-app>`跟标签

### .iml文件

idea 对module 配置信息,就是工程配置文件。是当前projec的一些配置信息

#### web请求流程

1. DNS解析过程。
    （1）用户在浏览器键入域名，回车。
    （2）浏览器检查浏览器缓存中有无此域名对应IP，有则结束。
    （3）浏览器检查操作系统缓存（hosts文件）中有无此域名对应IP，有则结束。
    （4）将域名发到本地DNS，查看有没有在其缓存中，有则返回IP给用户，结束。
    （5）向根域名服务器请求，根域名服务器返回主域名服务器（.com，.cn等）地址。
    （6）向主域名服务器请求，返回注册域名服务器地址。
    （7）经过多级解析后返回IP给本地DNS。
    （8）本地DNS缓存之，并返回给用户。

2. 建立TCP连接（三次握手）。
3. Web浏览器向Web服务器发送请求命令。
4. Web浏览器发送请求头信息。
5. Web服务器应答。
6. Web服务器发送应答头信息。
7. Web服务器向浏览器发送数据。
8. Web服务器关闭TCP连接。
