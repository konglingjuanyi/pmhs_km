jQuery.cookie = function(name, value, options) {
    if (typeof value != 'undefined') { // name and value given, set cookie
        options = options || {};
        if (value === null) {
            value = '';
            options.expires = -1;
        }
        var expires = '';
        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
            var date;
            if (typeof options.expires == 'number') {
                date = new Date();
                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
            } else {
                date = options.expires;
            }
            expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
        }
        // CAUTION: Needed to parenthesize options.path and options.domain
        // in the following expressions, otherwise they evaluate to undefined
        // in the packed version for some reason...
        var path = options.path ? '; path=' + (options.path) : '';
        var domain = options.domain ? '; domain=' + (options.domain) : '';
        var secure = options.secure ? '; secure' : '';
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else { // only name given, get cookie
        var cookieValue = null;
        if (document.cookie && document.cookie != '') {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++) {
                var cookie = jQuery.trim(cookies[i]);
                // Does this cookie string begin with the name we want?
                if (cookie.substring(0, name.length + 1) == (name + '=')) {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
};
(function(){
    var med = ns('med');
    var validators = {};

    med.validator = function(name, func){
        if (arguments.length == 1){
            return validators[name];
        } else  {
            validators[name] = func;
        }
    }

    function VYearMonth(){
        function validateVal(v){
            var errRes = { valid : false, msg: "不是合理的年月数据格式" };
            if (typeof v == 'undefined' || v == '' || v.length != 6){
                return errRes;
            } else {
                var year = v.substring(0,4);
                var month = v.substring(4,6);
                var iY  = parseInt(year, 10);
                var iM  = parseInt(month, 10);
                if (isNaN(iY) || isNaN(iM)) {
                        return errRes;
                } else {
                    if (iY < 1000 || iY > 9999 || iM < 1 || iM > 12) {
                        return errRes;
                    }
                }
            } 
            return {valid: true, msg :""};
        }
        return {
            validateVal : validateVal,
            format : function(v){
                return v;
            }
        }

    }


    function VDate(){
         var arrayLookup = { '01' : 31,'03' : 31, 
                        '04' : 30,'05' : 31,
                        '06' : 30,'07' : 31,
                        '08' : 31,'09' : 30,
                        '10' : 31,'11' : 30,'12' : 31} ;
        function validateDate(y,m,d){

            var errMsg = [];
            var intDay = parseInt(d,10); 
            var intYear = parseInt(y, 10);

            if (intYear > 9999 || intYear < 1900) {
                errMsg.push("年份不合理");
            }

            //check if month value and day value agree
            if(arrayLookup[m] != null) {
              if(intDay <= arrayLookup[m] && intDay != 0){
                return errMsg; //found in lookup table, good date
              }else { 
                errMsg.push("日期非法");
                //return errMsg;
              }
            }            
            var intMonth = parseInt(m,10);
            if (intMonth == 2) { 
               if (intDay > 0 && intDay < 29) {
                 //  return true;
               }
               else if (intDay == 29) {
                 if ((intYear % 4 == 0) && (intYear % 100 != 0) || 
                     (intYear % 400 == 0)) {
                      // year div by 4 and ((not div by 100) or div by 400) ->ok
                   //  return true;
                 }    else {
                    errMsg.push("日期不复合闰年规则");
                 }
               } else {
                   errMsg.push("日期非法");
               }
            }  else {
                errMsg.push("月份非法");
            }
 
            
            return errMsg;
        }

        function validateVal(v) {
            var msg = "非法日期类型，参考格式： 20100112";
            var valid = (v.match(VDate.re) != null);
            if (valid) {
                var year = v.substring(0,4);
                var month = v.substring(4,6);
                var day = v.substring(6,8);

                var eMsg = validateDate(year, month, day);
                if (eMsg.length > 0 ) {
                    valid = false;
                    msg = eMsg.join("\n");
                }
                console.error("date validation " + valid);
            } 
            return { valid : valid, msg : msg};
        }

        function padding(str, len, c){
            var res = str + "";
            while (res.length < len){
                res = c + "" + res;
            }
            return res;
        }

        return {
            validateVal : validateVal,
            format : function(v){
                if (v && typeof v == "object" || typeof v == "function") {
                    var month = v.getMonth() + 1
                    var day = v.getDate()
                    var year = v.getFullYear()
                    return year + "" + padding(month, 2 , '0') + padding(day, 2, '0');
                } else {
                    return v;
                }

            }
        }
    }

    VDate.re = /^\d{8}$/;

    function VInt(){
        function validateVal(v) {
            var valid = (v.match(VInt.re) != null);
            var msg = valid ? "" : "请输入整数类型";
            return { valid : valid, msg : msg};
        }

        return {
            validateVal : validateVal,
            preferCharValidate : true,
            format : function(v){
                return v;
            }
        }
    }

    VInt.re = /^\d+$/;

    function VNum(){
        function validateChar(v, c) {
            var valid = (v.match(VNum.charRe) != null);
            if (valid ){
                var idx = v.indexOf(".");
                if (idx == (v.length -1)  &&
                 (v.substring(0, v.length - 2)).indexOf(".") != -1)
                        valid = false;
            }
            var msg = valid ? "" : "请输入数字类型";
            return { valid : valid, msg : msg};
        }
        function validateVal(v) {
            var valid = (v.match(VNum.re) != null);
            var msg = valid ? "" : "请输入数字类型";
            return { valid : valid, msg : msg};
        }

        return {
            validateChar : validateChar,
            validateVal : validateVal,
            preferCharValidate : true,
            format : function(v){
                return v;
            }
        }
    }

    //VNum.re = /(^-?\d\d*\.\d*$)|(^-?\d\d*$)|(^-?\.\d\d*$)/;
    VNum.re = /(^-?\d\d*\.\d\d*$)|(^-?\d\d*$)|(^-?\.\d\d*$)/;
    VNum.charRe = /^(-)?(\d*)(\.?)(\d*)$/;

    function VRange(){
        function validateVal(v,min,max) {
            var valid = v >= min && v <= max;
            var msg = valid ? "" : "请输入" + min + "至" + max + "范围的值";
            return { valid : valid, msg : msg};
        }

        return {
            validateVal : validateVal,
            preferCharValidate : true,
            format : function(v){
                return v;
            }
        }
    }
    
    
    med.validator("date", VDate());
    med.validator("int", VInt());
    med.validator("num", VNum());
    med.validator("yearMonth", VYearMonth());

    med.validator("range", VRange());
 })()
