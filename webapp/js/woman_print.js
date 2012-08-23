function addZero(val){
	if(val < 10){
		return '0' + val;
	}
	return val;
}

function getBasicInfo(){
	var fileNo = $('#fileNo span').html();
	FileNumSearch.getItem(fileNo,function(data){
		$('.name').html(data[0][1]);
		$('.age').html(data[0][4] + '岁');
	});
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
			var $printCss = '<style>.printTable{width:17cm;border-bottom : 1px solid #000;'+
					'border-right : 1px solid #000;}  .printTable tbody td{border-left: 1px solid #000;'+
					'border-top: 1px solid #000;height:25px;line-height:25px;} .headerPrint{width:2.5cm;' +
					'padding-left:5px;}'+
					'.contentPrint{width:3cm;padding-left:3px;}</style>';
			$('.firstVisitPrint').click(function(){
				getBasicInfo();
				FirstVistBeforeBornService.getPrintInfo(send,function(data){
					Ext.Msg.show({
						title:'提示',
						msg: '请用16K的打印纸进行打印！',
						buttons: Ext.Msg.OK,
						animEl: 'elId',
						icon: Ext.MessageBox.INFO,
						width :300,
						fn : function(e){
							if(e == 'ok'){
								for(var prop in data){
									var propVal = data[prop];
									if(propVal instanceof Date){
										$('.' + prop).html(propVal.getFullYear() + '-' + addZero(propVal.getMonth() + 1) + '-' + addZero(propVal.getDate())); 
									}else{
										if(propVal == '' && prop == 'highRiskRemark')
											propVal = '无';
										$('.' + prop).html(propVal);
									}
								}
								var $html = $printCss + '<body>' + $('.printContainer').html() + '</body>';
								printObj.womanExamPrintProtect($html,'第1次产前随访服务记录表');	
							}
						}
					});
				});
			});
			
			$('.visitBeforeBornPrint').click(function(){
				getBasicInfo();
				VisitBeforeBornService.getPrintInfo(send,function(data){
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
									for(var prop in data){
										var propVal = data[prop];
										if(propVal instanceof Date){
											$('.' + prop).html(propVal.getFullYear() + '-' + addZero(propVal.getMonth() + 1) + '-' + addZero(propVal.getDate())); 
										}else{
											if(propVal == '' && prop == 'highRiskRemark')
												propVal = '无';
											$('.' + prop).html(propVal);
										}
									}
									var $html = $printCss + '<body>' + $('.printContainer').html() + '</body>';
									printObj.womanExamPrintProtect($html,'第2至5次产前随访服务记录表');	
								}
							}
						});
					}else{
						Ext.Msg.show({
							title:'提示',
							msg: '您打印的体检记录已经超过5次的报销范围，不能再进行打印！',
							buttons: Ext.Msg.OK,
							animEl: 'elId',
							icon: Ext.MessageBox.ERROR,
							width :350
						});
					}
				});
			});
			
			$('.visitAfterBorn').click(function(){
				getBasicInfo();
				var btnVal = $(this).val();
				var title = '';
				if(btnVal== 0){
					title = '产后访视记录表';
				}else if(btnVal == 1){
					title = '产后42天访视记录表';
				}
				VisitAfterBornService.get(send,function(data){
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
									for(var prop in data){
										var propVal = data[prop];
//										console.log(prop + '---' + propVal);
										if(propVal instanceof Date){
											$('.' + prop).html(propVal.getFullYear() + '-' + addZero(propVal.getMonth() + 1) + '-' + addZero(propVal.getDate())); 
										}else{
											if(propVal == '' && prop == 'highRiskRemark')
												propVal = '无';
											$('.' + prop).html(propVal);
										}
									}
									var $html = $printCss + '<body>' + $('.printContainer').html() + '</body>';
									printObj.womanExamPrintProtect($html,title);	
								}
							}
						});
					}
				});
			});
		}
	}
})();