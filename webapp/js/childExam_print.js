function addZero(val){
	if(val < 10){
		return '0' + val;
	}
	return val;
}
var fileNo = '';
function getBasicInfo(){
	fileNo = $('#fileNo span').html();
	FileNumSearch.getItem(fileNo,function(data){
//		console.log(data);
		$('.name').html(data[0][1]);
		$('.sex').html(data[0][2]);
	});
}

function dealData(data,beforeSkull01,beforeSkull02){
	var $printCss = '<style>.printTable{width:17cm;border: 1px solid #000;} '+
		'.printTable td{'+
		'border-top: 1px solid #000;height:25px;line-height:25px;font-size:13px;}'+
		'.printHeaderSpan{color:#10A2D7;}' +
		'.printTable tbody td table td{border:0px;padding-right:20px;}</style>';
	if(data != null){
		Ext.Msg.show({
			title:'提示',
			msg: '请用16K的打印纸进行打印！',
			buttons: Ext.Msg.OK,
			animEl: 'elId',
			icon: Ext.MessageBox.INFO,
			width :300,
			fn : function(e){
				if(e == 'ok'){
					var visitDate = '';
//					console.log(data);
					for(var prop in data){
						var propVal = data[prop];
						if(propVal instanceof Date){
							var d = propVal.getFullYear() + '-' + addZero(propVal.getMonth() + 1) + '-' + addZero(propVal.getDate());
							if(prop == 'visitDate'){
								visitDate = d;
							}else{
								$('.' + prop).html(d); 
							}
						}else if(prop == 'onlinePhoto'){
							if(propVal == null || propVal == ''){
								$('.' + prop).hide();
							}else{
								var imgurl = window.location.protocol + '//' + window.location.hostname + ':' + window.location.port + '/' + propVal;
								$('.' + prop).attr('src',imgurl)
							}
						}else if(prop == 'visitDoctor'){
							$('.' + prop).html(propVal);
						}else{
							if(propVal == '' && prop == 'highRiskRemark')
								propVal = '无';
							else if((propVal == null || propVal == '') && $('.' + prop + 'formatnum').length > 0)
								propVal = '0';
							var $title = $('.' + prop).attr('title');
							if($title != undefined && $title != 'undefined' && $title != null && $title != ''){
								var $prev = $('.' + prop).prev('span');
								var preval = $prev.html();
//								console.log(prop + '---' + $title + '---' + preval + '---' + propVal);
//								console.log(prop + ':' + (preval == $title));
								if(propVal != null && propVal != '' && (preval.indexOf($title) > 0)){
									$('.' + prop).html(',' + propVal);
								}
							}else{
								if(propVal == null || propVal == '')
									propVal = '未测';
								$('.' + prop).html(propVal);
							}
						}
					}
					var $html = $printCss + '<body>' + $('.printContainer').html() + '</body>';
					printObj.childExamPrintProtect($html,'儿童体检',visitDate,fileNo);	
				}
			}
		});
	}
}

(function(){
	initPrintPage = {
		init : init	
	}
	
	function init(){
		var json = UrlParse.parse();
		if(json.id != undefined){			
			var id = unescape(json.id);
			var send = {"id" : id};
			$('.childBabyVisit').click(function(){
				getBasicInfo();
				BabyVisitService.getPrintInfo(send,function(data){
					dealData(data,'exam09','exam10');
				});
			});
			
			$('.childvisit1').click(function(){
				getBasicInfo();
				ChildrenMediExamService.get(send,function(data){
					dealData(data,'exam03','exam04');
				});
			});
			
			$('.childvisit36').click(function(){
				getBasicInfo();
				ChildrenMediExam36Service.get(send,function(data){
					console.log(data);
					dealData(data,'beforeSkull01','beforeSkull02');
				});
			});
		}
	}
})();