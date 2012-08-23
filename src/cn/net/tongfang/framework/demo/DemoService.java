package cn.net.tongfang.framework.demo;

import cn.net.tongfang.framework.util.service.vo.PagingParam;
import cn.net.tongfang.framework.util.service.vo.PagingResult;

public interface DemoService {

	PagingResult<DemoControl> findControls(DemoControl control, PagingParam pp);

	DemoControl editControl(DemoControl control);

	void removeControls(String controls);
}
