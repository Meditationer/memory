# css

## HTML引入JS、CSS的各种方法-tag标签
- CSS的引入方式共有三种[行内样式>内部样式>外部样式(后两者是就近原则)]
  > 层叠性：内嵌>内部>外部>浏览器自身的,样式串联   继承性：样式可以应用于后代（border,padding,margin等不可传）
  1. 行内样式(内联样式表)-`<p style="color:red;border:1px solid black;">我是p标签</p>`不提倡
  2. 内部样式表(style可以放在任何位置) <style type="text/css"> font-family: "sans serif";color:red; </style>。一般在头
  3. 外部样式表
    1. 链接式：`<link type="text/css" rel="styleSheet"  href="CSS文件路径" />`
    2. 导入式:`<style type="text/css">  @import url("css文件路径"); </style>` 不提倡

### 选择器和声明-class='cu-btn bg-green shadow'，class引入
  1. 类选择器： .className{font-style: normal(正常);font-size：12px;}
  2. ID选择器： #idName{ … } 
  3. 子选择器： div>p {color:red;} div中的p标签变红 只能儿子
  4. 后代选择器 .first p{ … } class类中的所有子孙所有的p 【也是包含选择器】
  5. 标签选择器 tagName{ … } 两个可以一起 a,p{}这就是多重选择器
  6. 通用选择器 *{color:red;} 【少用】
  7. 伪类选择器
    1. 静态伪类(只用于超链接)，a:link{color: red;}超链接在未被访问前  a:visited{color: green;}设置超链接在其链接地址已被访问过时的样式（只能设置：字体边框、outline颜色）s
    2. 动态伪类(用于任何元素)
      1. 设置超链接在其鼠标悬停时的样式。a:hover{cursor:pointer;color:red;}
      2. 拥有焦点input:focus{color:red;}
      3. 超链接在被用户激活(鼠标点击与释放之间发生的事件)的样式。a:active{cursor:pointer;color:red;}
    3. UI元素伪类:可用状态input:enabled{color: red}　 选中状态input:checked{color: red}

### 盒模型  

- margin:外边框，padding:内边框，border:边框
- 没有声明宽度的，所以默认宽度为100%，padding 和 border 会向内推动，而不是向外扩展。声明宽度后，那么 padding 就会向外延展。
- overflow--position:absolute--float:left会产生包裹性：盒会收缩以致包裹紧贴内容。(tatic或相对定位relative盒会填满父元素的宽度，fiexd是根据浏览器定位)  
![盒](../picture/box.png)![盒](../picture/float_pos.png) 
1. overflow属性规定当内容溢出元素框时发生的事情
   1. visible(默认)超出，scroll出现滚动条，hidden内容修剪(多的不显示)，auto如果被修剪，会出现滚动条
2. position属性定位(float，position:absolute，position:fixed元素会脱离文档流),盒有三种基本的定位机制：普通流、浮动和绝对定位。

   - static定位(普通流定位)默认定位:正常的流中，【left无效果,margin会缩小内容宽度，margin，padding会撑大父宽高】
     - 标准流中：块级元素自动延展，竖直方向依次排列。
     - 一个元素脱离文档流，其他的元素在定位的时候会当做没看见它，两者位置重叠都是可以的。（所以两个absolute会相互重叠）

   - relative(相对定位)：子元素会撑大父元素。根据之前的位置相对定位，保留之前形状和所占空间。【left能是负数（会遮盖）-相对于其原本的位置，保留之前的位置，会覆盖内容.宽度是直至html】

   - absolute(绝对定位)：
     - 子元素宽度不会影响父元素的宽，宽度就是内容宽度(父级也是绝对定位,内容宽度是字符内容宽度)
     - 从文档流完全删除，原本所占空间会关闭，根据已定位的父元素定位【可通过margin,left定位】
     - z-index:2;堆叠顺序，数值大的显示在前
      
   - fixed绝对定位：元素框的表现类似于将position 设置为absolute【根据浏览器，所以有滚动条的时候是不会随着内容滚动而滚动，与absolute相反】

   - sticky粘性定位：该定位基于用户滚动的位置，没超出就跟随内容，超出就固定【top:0;这样向上滚动超出了就固定在顶部，向下就随内容滚动】
  
3. float浮动定位
- 只对元素自己起作用
- float:left 和 clear:left元素会左边无浮动自动到下一行，并且靠左(浮动元素和跟随在另一个浮动后面，一行放不下会换行)
- 清除浮动：clear : none | left | right | both(允许有，左无，右无，不允许有)会覆盖流布局的。
- 清除浮动：overflow:hidden;或overflow:auto;可以清除浮动, IE6 中要为父元素设置容器宽高或设置 zoom:1  
  ![图片](../picture/float.png)   

   
### Flex弹性布局（响应式布局的一种）
1. 块元素display: flex; 行内元素使用flex布局（display: inline-flex;）。设置为flex布局后，子元素的float、clear和vertical-align属性将失效。
  - 如果是Webkit内核的浏览器，必须加上-webkit前缀。.box{  display: -webkit-flex; display: flex;}
  - flex: flex-grow flex-shrink flex-basis/auto/none/initial/inherit的简写
	- flex-grow:放大比例,规定项目将相对于其他灵活的项目进行扩展的量。
	- flex-shrink:规定项目将相对于其他灵活的项目进行收缩的量。
	- flex-basis项目的长度。合法值："auto(根据内容自适应)"、"inherit（继承父）" 或跟 "%"、"px"长度单位的数字（初始长度）。

3. flex容器属性
  - 1flex-direction[排列方向，决定的是主轴]：row(默认横123)，row-reverse（321），column（列，从上而下123），column-reverse（列，从上而下321）
  - 2flex-wrap[换行]：nowrap(默认)：不换行。wrap：换行,第一行在上方。wrap-reverse：换行,第一行在下方。
  - flex-flow[1,2组合简写]：flex-direction和flex-wrap属性之和--row nowrap（默认） | row wrapper | column no-wrapper | column wrapper按这种顺序依次组合
  - justify-content[主轴对齐]：主轴上的对齐方式。flex-start(左) | flex-end(右) | center(中) | space-between(分布两端) | space-around(除去左右两边，剩下均等分)
	- 以上相对于排列方式row。如果主轴是column[flex-center就是距离上下顶部距离相等，靠左排列（全部靠左，只是上下距离的改变）。]。取决于当前所定义的轴的方向。
  - align-items[纵轴对齐(交叉轴)]：
    - stretch(元素拉伸适应容器,适应)|center(居中)|flex-start(轴开头)|flex-end(轴尾)|(baseline项目的第一行文字的基线对齐)|inherit(继承父)  
	- align-content[多轴对齐，单轴不起作用]：flex-start | flex-end | center | space-between | space-around | stretch

4. 项目属性
  - order：属性定义项目的排列顺序。数值越小，排列越靠前，默认为0。
  - flex-grow(放大比例)/shrink(缩小比例)：放大比例，默认为0，即如果存在剩余空间，也不放大。缩小比例，默认为1，即如果空间不足，该项目将缩小。
 ![盒](../picture/flex.png)  
### css代码规范 和 一些用法

- 建议使用border:none;而非border:0（css属性的值为0,则不要带上单位。除非真的是需要。）; 尽量按字母排序易读
- auto：auto属性，元素的宽度会随着父元素变化而变化（要有宽度不然可能不起作用)。宽度 = margin + border + padding + content,float是content
- css背景：背景颜色--background-color 。背景图像--background-image 。定位--background-position 。滚动background-attachment(默认滚动，fixed不移动)
  >背景属性简写： background:green url('images/fix.gif') no-repeat fixed 12px 24px;
- css文本：
  - 字体设置：font-style(字体样式：normal正常，italic斜体，oblique倾斜)，font-size(字体大小），font-family(设置文本字体)
  - 文本对齐方式：text-align属性有四个值：left，center，right，justify(两端对齐)；属性默认值为auto。
  - 文本修饰：text-decoration：（overline，设置文本上划线，line-through 设置文本中间划线。underline; 设置文本下划线）
  - 文本缩进：text-indent:2em（2em两个文字）负数，第一行则向左缩进。
  - 文本间距：line-height：22px;
  - 字间距：letter-spacing 属性设置字符间距（汉字无效），而 word-spacing 属性设置单词间距（text-align：justify冲突）
  - 文本转换：text-transform（capitalize大小开头，uppercase 仅大写字母，lowercase仅小写字母。）

- CSS链接：a:link{} 正常，a:visited{} 已访问过的链接，a:hover{} 当鼠标滑动到链接上时，a:active{} 链接被点击的那一刻。

- CSS列表标记：
  - 无序列表：list-style-type:（none无标记。disc实心圆。circle空心圆。square实心方块。）
  - 图像作列表标记：list-style-image：url()
  - 列表属性简写：list-style：list-style-type，list-style-position，list-style-image;

- 居中：
  - 外边距实现盒子居中-块级元素，指定了宽度，外边距设为auto
  - 文字盒子居中：文字水平居中是 text-align: center盒子水平居中 左右margin 改为 auto

- border : border-width || border-style || border-color。solid线(单实线)、dashed(虚线)、dotted(点线)、double(双实线)
- 超出隐藏（overflow:hidden）、省略号（text-overflow:ellipsis），强制在同一行显示（white-space: nowrap）、