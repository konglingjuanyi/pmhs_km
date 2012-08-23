Ext.ns('app')

app.summaryOrg = new Ext.tf.SummaryStatisticDetailPanel({
	queryUrl : summaryService.querySummaryStatistics,
	statisticType : '100',
	idsArray : {
		startDate : 'startDate01',
		endDate : 'endDate01',
		healthfile : 'healthfile01',
		children : 'children01',
		maternal : 'maternal01',
		chronicDisease : 'chronicDisease01',
		grid : 'orgGrid',
		isQryWipeOut : 'orgIsQryWipeOut'
	}
});

_tab = ModuleMgr.register(app.summaryOrg);