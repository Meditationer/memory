# JS 将字符串转换成日期类型(Date)，与当前时间比较(数据库为datetime)

- Date("month dd,yyyy hh:mm:ss")就是new Date("February 3,2009 10:52:03")); 
- new Date("yyyy/MM/dd");其中 再利用正则表达式转换字符串日期了

```html
		/g  意思是全局匹配  Date.parse()返回的是毫秒数
 let start = new Date(Date.parse(startTime.replace(/-/g,"/")));//字符串为yyyy-MM-dd hh:mm:ss yyyy-MM-dd也行
 let end = new Date(Date.parse(endTime.replace(/-/g,"/")));
 let now = new Date();
    if(start<new Date() && new Date()<end)
	{}
```

## 字符串格式转换

```js
 var str = "yyyy-MM-dd HH:mm:ss";
 str = str.split(" ")[0]; // yyyy-MM-dd 格式固定的字符串
```

## 时间比较大小

CompareDate(d1, d2) {

return ((new Date(d1.replace(/-/g, "\/"))) > (new Date(d2.replace(/-/g, "\/"))));

}