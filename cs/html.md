# html超文本标记语言

## 关于结构

- href 表示超文百本引用，在 link和a 等元素上使用。src 表示来源地址，img、script、iframe
- Px 像素Pixel；相对长度单位,em相对长度单位
- 元素转换
  1. 块级标签转换为行内标签：display:inline;
  2. 行内标签转换为块级标签：display:block;
  3. 转换为行内块标签：display：inline-block;

```html
    <!DOCTYPE>//指定版本
    <html>
       <head>
            //keywords(内容中就是关键字)，decription描述百度搜索结果显示，用来帮助你的主页被各大搜索引擎登录，
            //设编码格式等,charset是浏览器来查看网页是什么字符集。name=refresh刷新和重定向
            <!--提供页面元信息如编码，缓存，关键字，渲染模式-->
            <meta name="decription" charset="utf-8">//描述内容:
            <meta name="keywords" content="css,java,ui">//擎定义关键词，
             <!--定义标题，如浏览器工具栏，收藏夹，搜索引擎结果标题-->
            <title> </title>
            <link rel="stylesheet" type="text/css" href="../theme.css" charset=""/>
            //站点图标--->网页上标题边上的图标
            <link rel="shortcut icon" href="URL" type="image/x-icon">
            <style></style>//上面是外部样式。这个是内部
            <script> </script>//预先动态的加载一些js放这
       </head>
          <body>
          //块级-->内联(<p>,<h*1~6>,<dt>只能含内联)
          //只能同级并列<div><h2></h2><span></span></div>块级和内联并列错误
                <a></a>//超链接
                <img src="url" alt="失败提示" title="鼠标悬浮提示">//嵌入图片
                //为用户输入创建 HTML 表单
                <form>
                //label为input 元素定义标注,input搜集用户信息
                    <label>
                    <caption></caption>//表格标题
                         <input>
                         <select></select>//可放在表单里收集用户输
                    </label>
                </form>
          </body>
       <script>
            //一般放后面，脚本是中断线程，脚本执行结束后才继续。
       </script>
    </html>
```

***

### 块级元素

- 会自动换行，可控制行高以及外边距和内边距。宽度缺省是容器的100%(就是默认填满)
- dir-目录列表(是黑点，ol是123)，form交互表单，p段落，table表格，address定义文档或文章的作者信息，center居中对齐块
- 放script中的块级元素，`<noscript>`标签被浏览器禁用或不支持的时候会显出该标签中的内容
- `<font color="red">tr是html表格里的行，td就是行里的单元格。th 表头单元不是块级是单元格【td是多目标块状元素】</font>
- `<caption>定义表格标题，<dd>定义列表中定义条目，<div>定义文档中的分区或节，<form>创建 HTML 表单，<h1>-<h6>,<table>标签定义 HTML 表格`

```html
     ul里的列表可以是行业可以是列,看css怎么写,  
     ul li 本就是块状
     行：li{ display:inline} 列：li {float:left;display:block;}
     <ul>//无序列表<ol>有序列表<dl>自定义列表     class, title, style等  
          <li>      dl中<dt>//支持所有的HTML 全局属性,但是不可以定义宽高由上面，可以定字体宽高
          </li>          </dt>//padding-left有效竖直方向无效
     </ul></ol></dl>
```

### 行内元素(内联)

- 和其他元素都在一行，宽高就是内容的高度，默认排列方式为从左到右（margin和padding的上下左右均对其有效）
- a超链接(用href)，`<font color="red">行内块元素(img图片,input输入框,有宽高属性值)</font>select - 项目选择， small - 小字体文本，textarea - 多行文本输入框，span - 常用内联容器，定义文本内区块,<em>定义为强调的内容,<label>标签为
- abbr - 缩写`<abbr title="People's Republic of China">C</abbr> was`显示C was，鼠标放PRC上会显示People's Republic of China。对搜索引擎友好能被搜索，文本能被搜索
- `<font color="#FF0000">www.divcss5.com 颜色</font>`写文字

### 可变元素（行内块状元素）

- 可变元素为根据上下文语境决定该元素为块元素或者内联元素。

```html
     (button,input，textarea,select), img等
    applet - java applet.    button - 按钮
    del - 删除文本           iframe - inline frame
    ins - 插入的文本         map - 图片区块 (map)
    object - object 对象
    script - 客户端脚本
    /*行内块元素input*/
     input{
    width: 200px;      /*宽高均有效*/
    height: 30px;
}
```

### 互相转换

(1)display:inline;转换为行内元素
(2)display:block;转换为块状元素
(3)display:inline-block;转换为行内块状元素
(4)display:flex;弹性布局

- `<iframe src="http://www.divcss5.com/" width="400" height="200" scrolling="yes" />`内嵌网页框架
