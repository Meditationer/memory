# 一些基础知识

1. jar包和war包的区别：war是一个web模块，其中需要包括WEB-INF，是可以直接运行的WEB模块；jar一般只是包括一些class文件，在声明了Main_class之后是可以用java命令运行的。
2. war是Sun提出的一种Web应用程序格式，也是许多文件的一个压缩包.JAR文件格式以流行的ZIP文件格式为基础。

3 jar包是编译后的class包。带core是核心类比如_核心`slf4j-core.jar`而`slf4j-api.jar`则有其他扩展代码。

```java
spring-core-4.1.2.RELEASE-javadoc.jar API
spring-core-4.1.2.RELEASE-sources.jar 源码
spring-core-4.1.2.RELEASE.jar 运行jar包
```

## IDEA操作

- 参数.no弹出的东西可以选择not null 判断

### `<label style="color:red">快捷键操作</label>

- 查找：shift+shift就是查找文件，ctrl+alt+h查看调用层次，ctrl t查看被实现被调用
	- ctrl f是文件里查找，ctrl+r替换
- 代码格式化：ctrl alt L 
- 代码折叠：ctrl -[shift是全局]，+是相反
- 代码生成：根据光标位置alt insert生成代码，包类等
= 代码对比：alt+shift+c对比最近修改过的代码
- 代码补全：ctrl+shift+space
- 代码重构/重命名：shift+f6
- 去掉空白：Ctrl + Shift + J 
- 注释：ctrl /，ctrl shift /[注释一段],//region //endregion就是加注释折叠
- 其他
	- Inject language：alt+enter快捷键弹出inject language视图，并选中Inject language or reference。  
	可以写json什么的，自动补齐双引号
 
### 修改文本颜色

file -> setting ->找到Editor ->color scheme -> general 点击上面的，看着模板慢慢改

### 添加文件夹

- **基础操作** file -->project structure --> modules -->选择文件夹 --> 右击New Folder...创建文件夹后 -->选择上方的 Mark as -->点击Apply </br> &emsp;&emsp;如果弹出报错提示那就是因为父工程中有错误的文件目录.先选中父工程，然后看右边Add Content Root中是否除了Excluded Folders还有其他红色的文件目录，如果有删除就行了
- **添加java文件夹** 在要创建的目录下（目录右击）--> new directory(输入名字) --> 右击mark directory as 相应的（这里sources root）
- **添加web文件夹** idea => file -> project Structure --> Modules --> 绿色加号 --> Web -->更改Web Resource Directory下面的默认路径，指定webapp路径 `<label style="color:red">确定</label>

### 添加依赖

- ***maven*** 打开 pom.xml 文件，快捷键 alt + Insert选择 dependency 输入要添加的jar包名或者检索
- 普通 web --> WEN-INF ->右键 --> New -->Directory -->取名lib 复制相应的jar包 [这只是结构上的] --> `<label style="color:red">添加web文件夹步骤前3步或者右上方图标</label> -->libraries-->绿色加号 -->java -->选择modules下的lib -->jar directory(可能是javaweb) -->ok
-***验证添加web文件夹操作前4步-选择dependencies可看到lib文件夹且有5条竖线标志***

### IDEA创建父子maven工程

- create project --> maven(不需要模板)，选择project SDK -->GroupId（一般填反转后公司域名）和ArtifactId（项目名）还有Version，这三个属性目的是标识你的项目的唯一性 --> 项目路径最后面前最好再加一个\文件夹名（分类）--> ok `<label style="color:red">因为是父工程最好删除src创建子项目</label> -->父工程右击 new module -->选择模板 -->artifactid(输入项目名) next -->要注意路径因为是子工程

### 优化
- 找到IDEA的安装目录，如：C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.1，在bin文件夹里有 idea64.exe.vmoptions 的文件，修改如下参数：
-Xms128m，16 G 内存的机器可尝试设置为 -Xms1024m
-Xmx750m，16 G 内存的机器可尝试设置为 -Xmx1024m
-XX:MaxPermSize=350m，16G 内存的机器可尝试设置为 -XX:MaxPermSize=500m
-XX:ReservedCodeCacheSize=225m，16G 内存的机器可尝试设置为 -XX:ReservedCodeCacheSize=500m

### 项目改名是iml
