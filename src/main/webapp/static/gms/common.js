Date.prototype.format = function(fmt) {
    var o = {
        "M+": this.getMonth() + 1,
        // 月份
        "d+": this.getDate(),
        // 日
        "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12,
        // 小时
        "H+": this.getHours(),
        // 小时
        "m+": this.getMinutes(),
        // 分
        "s+": this.getSeconds(),
        // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3),
        // 季度
        "S": this.getMilliseconds()
        // 毫秒
    };
    var week = {
        "0": "\u65e5",
        "1": "\u4e00",
        "2": "\u4e8c",
        "3": "\u4e09",
        "4": "\u56db",
        "5": "\u4e94",
        "6": "\u516d"
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    if (/(E+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "\u661f\u671f": "\u5468") : "") + week[this.getDay() + ""]);
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}

function longToDate(longDate) {
    if (longDate == null || longDate == "" || longDate == "undefined") {
        return "";
    }
    var date = new Date(longDate);
    return date.format("yyyy-MM-dd HH:mm:ss");
}

function isNullOrEmpty(val){
	
	return val==null||val=="undefined"|| $.trim(val)=="";
	
}



function longToCNDate(longDate) {
    var date = new Date(longDate);
    return date.format("yyyy/MM/dd");
}
function isArrayEmpty(array) {
    if (array == null || array == "undefined" || array.length == 0) {
        return true;
    }
    return false;
}

function long2date(longDate) {
    if (longDate == null || longDate == "" || longDate == "undefined") {
        return "";
    }
    var date = new Date(longDate);
    return date.format("yyyy-MM-dd HH:mm:ss");
}
function date2Long(dateStr) {
    if (dateStr == null || dateStr == "" || dateStr == "undefined") {
        return null;
    }
    var str = dateStr.replace(/-/g, "/");
    var date = new Date(str);
    return date.getTime();
}

function dateFormatter(value, row, index) {
    return longToDate(value);
}
function yesnoFormatter(value, row, index) {
    return value ? "是": "否";
}

function statusFormatter(value, row, index) {
    return value ? "激活": "锁定";
}

(function($) {
    $.fn.serializeJson = function() {
        var serializeObj = {};
        $(this.serializeArray()).each(function() {
            if (this.value != null && this.value != "") {
                serializeObj[this.name] = this.value;
            }
        });
        return serializeObj;
    };
})(jQuery);

(function($) {
	
    $.fn.serializeQueryJson = function() {
        var serializeObj = {};
        $(this.serializeArray()).each(function() {
        	var value = this.value; 
            if (value != null && value != "") {
            	if(this.name.indexOf("Time")>0){
            		value = date2Long(value);
            	}
                serializeObj[this.name] = value;
            }
        });
        return serializeObj;
    };
})(jQuery);

$.extend($.fn.textbox.defaults,{height:26});
$.extend($.fn.combobox.defaults,{height:26});
$.extend($.fn.datebox.defaults,{height:26});
$.extend($.fn.datetimebox.defaults,{height:26});
// 扩展easyui表单的验证
$.extend($.fn.validatebox.defaults.rules, {
    // 验证汉子
    CHS: {
        validator: function(value) {
            return /^[\u0391-\uFFE5]+$/.test(value);
        },
        message: '只能输入汉字'
    },
    // 移动手机号码验证
    mobile: { // value值为文本框中的值
        validator: function(value) {
            var reg = /^1[3|4|5|8|9]\d{9}$/;
            return reg.test(value);
        },
        message: '输入手机号码格式不准确.'
    },
    int: { // value值为文本框中的值
        validator: function(value) {
            var reg = /^\d{0,10}$/;
            return reg.test(value);
        },
        message: '请输入一个大于0的数字.'
    },
    bitint: { // value值为文本框中的值
        validator: function(value) {
            var reg = /^\d[1-9]\d{0,20}$/;
            return reg.test(value);
        },
        message: '请输入一个大于0的数字.'
    },
    // 国内邮编验证
    zipcode: {
        validator: function(value) {
            var reg = /^[1-9]\d{5}$/;
            return reg.test(value);
        },
        message: '邮编必须是非0开始的6位数字.'
    },
    // 用户账号验证(只能包括 _ 数字 字母)
    account: { // param的值为[]中值
        validator: function(value, param) {
            if (value.length < param[0] || value.length > param[1]) {
                $.fn.validatebox.defaults.rules.account.message = '用户名长度必须在' + param[0] + '至' + param[1] + '范围';
                return false;
            } else {
                if (!/^[\w]+$/.test(value)) {
                    $.fn.validatebox.defaults.rules.account.message = '用户名只能数字、字母、下划线组成.';
                    return false;
                } else {
                    return true;
                }
            }
        },
        message: ''
    }
});

