(function($){
	$.extend($.fn.validatebox.defaults.rules,{
		number : {  
			validator : function(value,param){
				return /^\d+$/.test(value);
			},
			message : '请输入数字'
		},
		
		zero : {
			validator: function(value,param){ 
				if(value<=0){
					return false;
				}else{
					return true;
				} 
	        },   
	        message: '请输入大于零的价格' 
		},
		integer : {
			validator: function(value,param){   
	            return /^([+-]?)(\d+)$/.test(value);
	        },   
	        message: '请输入整数' 
		},
		chinese : {
			validator : function(value,param){
				return /[\u4E00-\u9FA5\uF900-\uFA2D]+$/.test(value);
			},
			message : '请输入中文'
		},
		custom : {
			validator:function(value,param){
				return eval("/"+param[0]+"/").test(value);
			},
			message: "{1}"
		},
		compareNumber : {
			validator:function(value,param){
				var k = $(param[0]).val();
				return parseFloat(value)>parseFloat(k);
			},
			message: "{1}"
		},
		compareFloat : {
			validator:function(value,param){
				var k = $(param[0]).val();
				return parseFloat(value)<parseFloat(k);
			},
			message: "{1}"
		},
		yearLimit : {
			validator:function(value,param){
				return (parseFloat(value)>0 && parseFloat(value)<=5);
			},
			message: "请输入不能超过使用年限的正数"
		},
		compareMoneyLess : {
			validator:function(value,param){
				var k = $(param[0]).val();
				return parseFloat(value)<=parseFloat(k);
			},
			message: "{1}"
		},
		money : {
			validator:function(value,param){
				return /^\d+(\.\d{1,4})?$/.test(value);
			},
			message: "请输入正确的金额(小数位数不能超过4位)"
		},
		price_money : {
			validator:function(value,param){
				return /^\d+(\.\d{1,2})?$/.test(value);
			},
			message: "请输入正确的价格"
		},
		emission_quota : {
			validator:function(value,param){
				
				return /[^\d+(\.\d{1,4})?$|/)]/.test(value);
			},
			message: "请输入正确的金额(小数位数不能超过4位)"
		},
		floatnum : {
			validator:function(value,param){
				return /^\d+(\.\d{1,4})?$/.test(value);
			},
			message: "请输入正确的数字(小数位数不能超过4位)"
		},
		count : {
			validator:function(value,param){
				return /^\d+(\.\d+)?$/.test(value);
			},
			message: "{0}"
		},
		QQ: {
	        validator: function (value, param) {
	            return /^[1-9]\d{4,10}$/.test(value);
	        },
	        message: '请输入正确的QQ号码'
	    },
	    mobile: {
	        validator: function (value, param) {
	            //return /^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/.test(value);
	            return /^0*(13|15|18)\d{9}$/.test(value);
	        },
	        message: '请输入正确的手机号码'
	    },
	    loginName: {
	        validator: function (value, param) {
	            return /^[\u0391-\uFFE5\w]+$/.test(value);
	        },
	        message: '用户名只允许汉字、英文字母、数字及下划线'
	    },
	    safepass: {
	        validator: function (value, param) {
	            return /^[0-9A-Za-z]{6,50}$/.test(value);
	        },
	        message: '密码由字母和数字组成，至少6位，不超过50位'
	    }, 
	    lengthlimit: {//做文本框限制
	        validator: function (value, param) {
	        	if(value.length>50){
	        		return false;
	        	}else{
	        		return true;
	        	}
	        },
	        message: '{0}'
	    }, 
	    length_limits: {//做文本框限制
	        validator: function (value, param) {
	            if(value.length>200){
	        		return false;
	        	}else{
	        		return true;
	        	}
	        },
	        message: '{0}'
	    }, 
	    user_name: {//做注册用户名唯一性
	        validator: function (value, param) {
	        	var old_user_name = $(param[0]).val();;	        	
	           var user_name = value.replace(/(^\s*)/g, ""); 
	           var flag = true;
	           if(old_user_name!=user_name){
	           		 $.ajax({ 
						url: "enterpriseBaseAction!checkUserName.do?user_name="+user_name, 
						type: "POST",
						async:false,
						success: function(data){
			   				 if(data=="1"){
			   				 	flag =false;
			   				 }else{
			   				 	flag = true;
			   				 }
						}
					});
	           }
				return flag;
	        },
	        message: '注册用户名已存在'
	    },
	     define_num: {//做确认书编号唯一性
	        validator: function (value, param) {
	        	var old_user_name = $(param[0]).val();;	        	
	           var user_name = value.replace(/(^\s*)/g, ""); 
	           var flag = true;
	           if(old_user_name!=user_name){
	           		 $.ajax({ 
						url: "applyCostAction!checkDefineNum.do?user_name="+user_name, 
						type: "POST",
						async:false,
						success: function(data){
			   				 if(data=="1"){
			   				 	flag =false;
			   				 }else{
			   				 	flag = true;
			   				 }
						}
					});
	           }
				return flag;
	        },
	        message: '确认书编号已存在'
	    },
	     initial_quota: {//看因子是否已经有有偿使用费
	        validator: function (value, param) {
	        	var index = param[0];
	        	var eb_id = param[1];
	        	var old_quota = $('#old_quota'+index).val();
	           var resource_id = $('#resource_id'+index).val();
	          // var year = $(param[2]).val();
	           var flag = true;
	           if(old_quota!=value){
		            $.ajax({ 
						url: "initAllocationAction!isApplyResourceRecord.do?eb_id="+eb_id+"&resource_id="+resource_id, 
						type: "POST",
						async:false,
						success: function(data){
			   				 if(data=="1"){
			   				 	flag =false;
			   				 }else{
			   				 	flag = true;
			   				 }
						}
					});
	           }
	         
				return flag;
	        }, //此因子已产生交易或有偿使用费，不能修改
	        message: '此因子已产生交易，不能修改'
	    },
	    
	     enterprise_name: {//是否已存在此企业名称
	        validator: function (value, param) {
	           var flag = true;
	           $.ajax({ 
				url: "enterpriseBaseAction!isExistEnterpriseName.do?enterprise_name="+value, 
				type: "POST",
				async:false,
				success: function(data){
	   				 if(data=="1"){
	   				 	flag =false;
	   				 }else{
	   				 	flag = true;
	   				 }
				}
			  });
				return flag;
	        },
	        message: '企业名称已存在'
	    },
	      enterprise_name_edit: {//是否已存在此企业名称
	        validator: function (value, param) {
	      //  alert(param[0]);
	           var flag = true;
	           $.ajax({ 
				url: "enterpriseBaseAction!isExistEnterpriseName.do?enterprise_name="+value+"&eb_id="+param[0], 
				type: "POST",
				async:false,
				success: function(data){
	   				 if(data=="1"){
	   				 	flag =false;
	   				 }else{
	   				 	flag = true;
	   				 }
				}
			  });
				return flag;
	        },
	        message: '企业名称已存在'
	    },
	    postcode: {
	        validator: function (value, param) {
	            return /^[1-9]\d{5}$/.test(value);
	        },
	        message: '请输入正确的的邮政编码'
	    },
	    date: {
	        validator: function (value, param) {
	            return /^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$/.test(value);
	        },
	        message: '请输入正确的的日期'
	    },
	    telephone: {
	        validator: function (value, param) {
	           // return /(^(\d{3,4}-)?\d{7,8})$/.test(value);
	           return /^(\d{3,4}-)?\d{7,8}(-\d{3,4})?$/.test(value);
	        },
	        message: '请输入正确的电话号码'
	    },
	    faxno: {
	        validator: function (value, param) {
	           // return /(^(\d{3,4}-)?\d{7,8})$/.test(value);
	           return /^(\d{3,4}-)?\d{7,8}(-\d{3,4})?$/.test(value);
	        },
	        message: '请输入正确的传真号码'
	    },
	    bankno: {
	        validator: function (value, param) {
	           return /^[0-9]{16,19}$/.test(value.replace(/\s/g, ""));
	        },
	        message: '请输入正确的银行账号'
	    },
	    idno: {
	        validator: function (value, param) {
	            return /^(\d{14}|\d{17})(\d|[xX])$/.test(value);
	        },
	        message: '请输入正确的身份证号码'
	    },	    
	    equalTo: {
	        validator: function (value, param) {
	            return value == $(param[0]).val();
	        },
	        message: "{1}"
	    },
	     length: {
	        validator: function (value, param) {
	            return (value.length >= param[0] && value.length <= param[1]);
	        },
	        message: "长度必须在{0}至{1}之间"
	    },
		numberAndTrue : {  
			validator : function(value,param){
				var boo = true;
				var name = param[0];
				var pt = $(":input[name='"+name+"']").val();
				var b = /^\d+(\.\d+)?$/.test(value);
				if(b){
					if(parseFloat(value) > parseFloat(pt)||pt == ''){
						boo = false;
					}
				}
				if(!b){
					boo = false;
				}
				
				return boo;
			},
			message : "{1}"
		},
		 eppeDeclareValidator: {  
			validator : function(value,param){
				var boo = false;
				//var name0 = param[0];
				
				var realname = param[0];
				//alert(realname);
				var name1 = realname.substr(realname.lastIndexOf(".")+1,realname.length);
				//alert(name1);
				var name2 = realname.substr(0,realname.lastIndexOf("."));
				//alert(name2);
				var value1 = "";
				var value2 = "";
				var value3 = "";
				
				if(name1 == 'beget_amount'){
					param[1] = "去除量与排放量必须填写！";
				}else if(name1 == 'remove_amount'){
					param[1] = "产生量与排放量必须填写！";
				}else if(name1 == 'emission_amount'){
					param[1] = "产生量与去除量必须填写！";
				}
				//alert("input[name='"+name2+"beget_amount']");
				value1 = $("input[name='"+name2+".beget_amount']").val();
				value2 = $("input[name='"+name2+".remove_amount']").val();
				value3 = $("input[name='"+name2+".emission_amount']").val();
				//alert(value1+" : "+value2+" : "+value3);
				if(value1!=""&&value2!=""&&value3!=""){
					boo = true;
				}
				return boo;
			},
			message : "{1}"
		}
	})
})(jQuery)