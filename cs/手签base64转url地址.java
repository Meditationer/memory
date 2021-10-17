//图片在后端的存储方式分为两种:图片以独立文件的形式存储在服务器中（拿路径）；图片转换成二进制流存储到数据库的 Image 类型字段中
//对于第二种 blob 的 API 生成临时 URL 赋值给 src 属性来显示。

//【image/png;base64格式，data协定名称，image/png 数据类型，逗号后是image/png文件base64编码后的数据。】
_that.signImage = res.tempFilePath//输出的image/png;base64格式
let result = _that.dataURLtoBlob(_that.signImage) //blob二进制长对象的意思,Blob通常是图片或者声音文件
var urll = URL.createObjectURL(result); //返回当前文件的一个内存URL
that.pushToService(urll)
// url上传阿里云
pushToService(res) {
	uploadImage(res, 'txscl_check/',
		result => {
			let path = result + '?x-oss-process=style/big'
			_that.ImgPath = [path]
			_that.goBackFuzhu(_that.ImgPath)
		},
	)
},
		
		
//base64格式 to blob
dataURLtoBlob(dataurl) {
	var arr = dataurl.split(','),
		mime = arr[0].match(/:(.*?);/)[1],
		bstr = atob(arr[1]),
		n = bstr.length,
		u8arr = new Uint8Array(n);
		while (n--) {
			u8arr[n] = bstr.charCodeAt(n);
		}
		return new Blob([u8arr], {
			type: mime
		});
},

// 原理： 利用canvas.toDataURL的API转化成base64    
urlToBase64(url) {
    return new Promise ((resolve,reject) => {
        let image = new Image();
        image.onload = function() {
        let canvas = document.createElement('canvas');
        canvas.width = this.naturalWidth;
        canvas.height = this.naturalHeight;
        // 将图片插入画布并开始绘制
        canvas.getContext('2d').drawImage(image, 0, 0);
        // result
        let result = canvas.toDataURL('image/png')
        resolve(result);
        };
        // CORS 策略，会存在跨域问题https://stackoverflow.com/questions/20424279/canvas-todataurl-securityerror
         image.setAttribute("crossOrigin",'Anonymous');
         image.src = url;
         // 图片加载失败的错误处理
         image.onerror = () => {
         reject(new Error('图片流异常'));
        };
    }
