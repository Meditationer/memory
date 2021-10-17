verifyMoney() {
	let _this = this;
	return new Promise(function(resolve, reject) {
		_this.okhttp.http({
		url: _this.$webapi + '/basfujupeifa/verifyMoney', //接口地址
			data: {
				age: _this.Age, //年龄
				HelpNum: _this.HelpNum, //补助的钱
				FaPiaoMoney: _this.FaPiaoMoney, //发票的钱
				year: _this.helpdate.substr(0, 4),
				idcard: _this.idcard,
				FuJuName: _this.FuJuName, //基本型号辅具名称, 比如假肢
				jjqkindex: _this.jjqkindex, //0,1,2 ['低保家庭', '低收入家庭', '一般家庭'],
				helpitem: _this.helpitem, //辅具名称  比如大腿，小腿
				partindex: _this.partindex, //单双 上下肢
			},
			success: (res) => {
				resolve(res.data);
			},
			fail: (err) => {
				reject(err);
					}
			});
	});
},