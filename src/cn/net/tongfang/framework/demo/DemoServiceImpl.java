package cn.net.tongfang.framework.demo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.net.tongfang.framework.util.service.vo.PagingParam;
import cn.net.tongfang.framework.util.service.vo.PagingResult;

public class DemoServiceImpl implements DemoService {

	private static final Log log = LogFactory.getLog(DemoServiceImpl.class);
	
	@Override
	public PagingResult<DemoControl> findControls(DemoControl control, PagingParam pp) {
		int size = 20;
		Timestamp date = control.getDate();
		
		List<DemoControl> list = new ArrayList<DemoControl>();
		List<DemoControl> l = DemoControl.get();
		if ( date != null ) {
			for (DemoControl d : l) {
				if ( d.getDate() != null && d.getDate().after(date) ) {
					list.add( d );
				}
			}
		} else {
			list = l;
		}
		log.debug("return: " + list);
		
		return new PagingResult<DemoControl>(size, list);
	}

	@Override
	public DemoControl editControl(DemoControl control) {
		DemoControl.save(control);
		return control;
	}

	@Override
	public void removeControls(String controls) {
		
	}

}
