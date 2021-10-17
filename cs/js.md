# js DOM BOM

- js通过访问BOM(DOM在各自浏览器上的实现)来访问、控制、修改客户端(浏览器)
- DOM(文档对象模型)是用于HTML和XML文档的API(应用程序编程接口),DOM就是接口对象，比如JDOM(java dom),XML DOM  
- BOM:浏览器对象， 是 各个浏览器厂商根据 DOM在各自浏览器上的实现。window是BOM而非js对象
  >*DOM描述了处理网页内容的方法和接口，BOM描述了与浏览器进行交互的方法和接口。*
- DOM举例，HTML DOM,
  1. 定义文档结构--节点对象树,  
  ![对象树](../picture/html_dom.jpg)

## js引用和书写

- js是‘单线程’语言，执行模式有两种：同步，异步。js默认模式是同步模式，按流水线执行:A,B,C。  
异步：流水线旁加了一个（任务队列），某些模块到任务队列，或者会把任务队列的某些模块插队到流水线。

- Js的三种引入方式
   1. 外部引入(外链式):`<script type="text/javascript" src="路径/文件名.js"></script>`
   2. 内部js：`<script type="text/javascript">js代码</script>`
   3. 行内引入：`<input type="button" οnclick="alert('行内引入')" value="button" name="button">`(on+事件类型=“js代码”)