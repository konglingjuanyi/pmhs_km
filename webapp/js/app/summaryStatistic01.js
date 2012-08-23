Ext.ns('app')


app.summary01 = new Ext.tf.SummaryStatisticPanel({
	queryUrl : summaryService.querySummaryStatistics,
	readerConfig : [ {
		name : 'orgName'
	}, {
		name : 'userName'
	}, {
		name : 'groupDate'
	}, {
		name : 'vhealthCount'
	}, {
		name : 'chealthCount'
	}, {
		name : 'babyHealthCount'
	}, {
		name : 'babyVisitCount'
	}, {
		name : 'children01count'
	}, {
		name : 'children02count'
	}, {
		name : 'children36count'
	}, {
		name : 'babyAllVisitCount'
	}, {
		name : 'maternalCount'
	}, {
		name : 'firstVistBeforeBornCount'
	}, {
		name : 'visitBeforeBornCount'
	}, {
		name : 'prenatalVisitCount'
	}, {
		name : 'visitAfterBornCount'
	}, {
		name : 'visitAfterBorn42count'
	}, {
		name : 'hypertensionHealthCount'
	}, {
		name : 'hypertensionVisitCount'
	}, {
		name : 'diabetesHealthCount'
	}, {
		name : 'diabetesVisitCount'
	}, {
		name : 'furiousHealthCount'
	}, {
		name : 'furiousVisitCount'
	}],
	gridCmConfig : [ {
		"header" : "组织机构",
		"dataIndex" : "orgName",
		"id" : "orgName",
		locked : true,

	}, {
		"header" : "操作员",
		"dataIndex" : "userName",
		"id" : "userName"
	}, {
		"header" : "日期",
		"dataIndex" : "groupDate",
		"id" : "groupDate"
	}, {
		"header" : "农业人口档案数",
		"dataIndex" : "vhealthCount",
		"id" : "vhealthCount"
	}, {
		"header" : "城镇人口档案数",
		"dataIndex" : "chealthCount",
		"id" : "chealthCount"
	}, {
		"header" : "儿童档案数",
		"dataIndex" : "babyHealthCount",
		"id" : "babyHealthCount",
		"hidden" : true 
	}, {
		"header" : "新生儿家庭访视",
		"dataIndex" : "babyVisitCount",
		"id" : "babyVisitCount"
	}, {
		"header" : "1岁以内儿童体检",
		"dataIndex" : "children01count",
		"id" : "children01count"
	}, {
		"header" : "1~2岁儿童体检",
		"dataIndex" : "children02count",
		"id" : "children02count"
	}, {
		"header" : "3~6岁儿童体检",
		"dataIndex" : "children36count",
		"id" : "children36count"
	}, {
		"header" : "儿童体检总和",
		"dataIndex" : "babyAllVisitCount",
		"id" : "babyAllVisitCount"
	}, {
		"header" : "孕产妇档案数",
		"dataIndex" : "maternalCount",
		"id" : "maternalCount",
		"hidden" : true
	}, {
		"header" : "第1次产前随访",
		"dataIndex" : "firstVistBeforeBornCount",
		"id" : "firstVistBeforeBornCount"
	}, {
		"header" : "第2~5次产前随访",
		"dataIndex" : "visitBeforeBornCount",
		"id" : "visitBeforeBornCount"
	}, {
		"header" : "产前随访总和",
		"dataIndex" : "prenatalVisitCount",
		"id" : "prenatalVisitCount"
	}, {
		"header" : "产后访视",
		"dataIndex" : "visitAfterBornCount",
		"id" : "visitAfterBornCount"
	}, {
		"header" : "产后42天体检",
		"dataIndex" : "visitAfterBorn42count",
		"id" : "visitAfterBorn42count"
	}, {
		"header" : "高血压档案数",
		"dataIndex" : "hypertensionHealthCount",
		"id" : "hypertensionHealthCount",
		"hidden" : true
	}, {
		"header" : "高血压随访",
		"dataIndex" : "hypertensionVisitCount",
		"id" : "hypertensionVisitCount"
	}, {
		"header" : "糖尿病档案数",
		"dataIndex" : "diabetesHealthCount",
		"id" : "diabetesHealthCount",
		"hidden" : true
	}, {
		"header" : "糖尿病随访",
		"dataIndex" : "diabetesVisitCount",
		"id" : "diabetesVisitCount"
	}, {
		"header" : "重性精神病档案数",
		"dataIndex" : "furiousHealthCount",
		"id" : "furiousHealthCount",
		"hidden" : true
	}, {
		"header" : "重性精神病随访",
		"dataIndex" : "furiousVisitCount",
		"id" : "furiousVisitCount"
	}]
});

_tab = ModuleMgr.register(app.summary01);