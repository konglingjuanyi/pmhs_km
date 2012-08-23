package cn.net.tongfang.framework.security.demo.service;

import java.util.List;
import java.util.Map;

import cn.net.tongfang.framework.security.vo.BasicInformation;

public interface MetaService {
	Map<Integer, List<BasicInformation>> get(List<Integer> code);
	
	boolean isInputPerson(String id,String tableName);
}
