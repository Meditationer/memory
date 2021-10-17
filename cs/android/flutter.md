# flutter（ios和android跨平台）
是现代的响应式框架、一个2D渲染引擎、现成的widget和开发工具。

## 注意
- 事件流是“向上”传递的，而状态流是“向下”传递的 

## widget（UI元素Element的配置数据）
- 每个Widget都是用户界面一部分的不可变声明。统一对象模型。
	- 可以是一个结构元素（如按钮或菜单），文本样式元素，一个布局方面（填充）
	- 每个widget嵌入其中，并继承父项的属性。
	- widget分Stateless widgets[不可变]和stateful widgets[可变]
		- stateful widgets由 statefulWidget类 和 state类组成[状态类，可变]
- 抽象类中属性
	- Key(widget树的替换)
		- 两个widget的runtimeType与key相同新替换旧，调用Element.update更新(否则移除和插入)
		- 使用GlobalKey作为widget的key时，允许element在树上移动(状态不会丢失)
	- createElement 给定的widget可以被包含在树中零次或多次。[隐式调用]
	- canUpdate 如果两个widget没有key，则认为它们是匹配的，即使children 完全不相同。
- StatefulWidget对应的state类的生命周期
	- 回调函数
		- initState：widget第一次插入到树中调用，一次性操作，初始化等
		- didChangeDependencies：对象依赖发生变化
		- build()用于构建widget子树
		- reassemble开发者热加载的时候，release是不会的
	- 在widget树中获取state对象
		- context对象有一个findAncestorStateOfType()方法
		- 通过GlobalKey
## 布局
- widget树(控件)，element树(展示)，RenderObject 树（组件布局渲染）
- 一般的ui是onMeasure,onLayout,onDraw。而widget并不会全部渲染，分为
	- 组合类statelessWidget和statefulWidget(封装了绘制的原子组件),比如Container组件
	- 代理类inheritedWidget
	- 绘制类renderObjectWidget，通过createRenderObject()生成RenderObject对象。
		- flutter渲染流程和原生分为build(),layout(),paint()。
		- build()由组合类和代理类，另外两个是绘制类完成
	
- 布局规则：上下约束，下上大小信息，上决定下位置。比如父没有规定大小，那么他就和子一样大小但是不超过他的父约束
	- 两种约束：center[父](child:Container[子](父的约束))，constraints: BoxConstraints(父规定的约束，只对子控件有效)
	- 单个子元素布局Container、Padding等18种
	- 多个子元素Row、Column等11种
	- 布局组件
		- ConstrainedBox仅对其父接受的约束向下约束，constraints不起作用
		- UnconstrainedBox这个是没有约束。如果子无线大小就无法渲染会报错BoxConstraints forces an infinite width
	- RenderDecoratedBox。因为没有child了所以走enforce方法。接受到是紧约束，也就是固定约束【没啥用，太硬核看不懂】
		
- 屏幕加载setState（）-····->当前State的build()-······->页面绘制-····->屏幕刷新。
```
BoxConstraints.expand({double width,double height,}):
	minWidth = width ?? double.infinity,
	maxWidth = width ?? double.infinity,
	minHeight = height ?? double.infinity,
	maxHeight = height ?? double.infinity;
```
- 约束
	- Center约束和屏幕一样大
	- Row不约束子，溢出
	- UnconstrainedBox不约束，报错
	- FittedBox
	- Scaffold 
	
## 路由(导航管理)：通过路由栈管理，入栈就是打开。
- Route：(android:Activity,ios:ViewController)继承PageRoute抽象类的MaterialPageRoute来实现切换风格一致的路由
	- 效果：Android打开底到顶，关闭是顶到低。ios打开右到左，关闭左到右
	- 参数
		- builder  回调函数，构建路由页面的具体内容，返回值是widget
		- settings 路由的配置信息，如路由名称、是否初始路由（首页）。
		- maintainState 默认true，新入栈的时候保存旧的路由
		- fullscreenDialog 默认false
	- 自定义路由，继承PageRoute，重写
- Navigator：导航器（widget）
	- Future push入栈，返回Future对象接收关闭新路由时返回数据
		- push直接路由方式
		- Navigator.push(context,MaterialPageRoute(builder: (context) {return 路由class(text:参数)},))
		- pushNamed命名路由方式
		- pushNamed(context,routeName,{Object arguments})
	- bool pop出栈（context，[result]）result为页面关闭返回数据
	- 第一参为context静态方法对应的两种navigator实列
		- Navigator.of(context).push(Route route)等于上面
		- Navigator.of(context).pushNamed(RouteName,arguments: "hi")等于上面
- 命名路由
	- 注册路由表 Map<String, WidgetBuilder> routes;
	- materialApp下,routes属性。
	```
	{"new_page":(context) => NewRoute(),这个应该是无必需传递参数的路由
	 "tip2": (context){return TipRoute(text: ModalRoute.of(context).settings.arguments);}
	 "/":(context) => MyHomePage(title: 'Flutter Demo Home Page'), //注册首页路由
	}
	```
- 获取参数：
	- 在路由页通过RouteSetting对象获取路由参数：var args=ModalRoute.of(context).settings.arguments;
- 路由钩子（打开路由页前判断状态）
	- materialApp的onGenerateRoute属性：
		- (RouteSettings settings){return MaterialPageRoute(builder：(context){})}
		
## 组件(flutter + material[android]/Cupertino[ios])
- text文本
- row，column 具有弹性空间的widget在水平或者垂直上布局
- stack 线性布局，允许重叠
- Container 容器，矩形视觉元素
- Material 组件
	- 程序以MaterialApp 组件开始
	- Theme配置应用主题
	- Scaffold
	- AppBar
	- FlatButton
- Cupertino 组件
- 状态管理

## 包和资源,异常管理(包和插件)
- android通过gradle管理依赖，ios用Cocoapods管理。pubspec.yaml配置
	- name 应用或包名称
	- description 描述、简介
	- version	版本
	- dependencies	依赖，本地是pkg：path[相对路径]，pkg:git:url是[git网上路径]
	- dev_dependencies 开发环境依赖的工具包
	- flutter flutter配置选项。
- 资源管理
	- assets也是在pubspec.yaml文件中，在flutter那里管理
- 异常管理
	- flutter框架对很多关键方法进行了异常捕获
	- 比如布局发生越界或不合规范，flutter就会弹出错误界面
	- 自定义异常捕获
	```
	void main() {
		FlutterError.onError = (FlutterErrorDetails details) {
			reportError(details);
		};}
	```
- dart，Future的异常(同步和异步)
	- 同步异常：try/catch捕获
	- 异步异常（throw或者runZoned方法的类zone(相当于沙箱)）
- 包和插件
	- 包共享模块化代码。pubspec.yaml和lib文件夹是必须的
		- Dart包：对flutter有依赖性。
			- 使用$ flutter create--template=package hello 对于纯dart包，可在lib目录下添加功能
		- 插件包：专用的Dart包(项目iOS代码Objective-C,Android代码Java)
			- $ flutter create --org com.example --template=plugin hello
			- lib 插件包的Dart API.
			- android 插件包API的Android实现.
			- ios 插件包API的ios实现.
			- example 依赖于该插件的Flutter应用程序
		- 添加android studio时，先用java 构建一次  
		例如，从IntelliJ运行示例应用程序或在终端执行cd hello/example; flutter build apk
## 布局
- 先将布局拆分成基本元素。首先确定行列，确定大的元素	
	





