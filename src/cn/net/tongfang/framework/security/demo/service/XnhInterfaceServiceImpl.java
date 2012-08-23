package cn.net.tongfang.framework.security.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.net.tongfang.framework.security.demo.service.vo.DwrListVO;
import cn.net.tongfang.framework.security.demo.service.vo.XnhAccountVO;
import cn.net.tongfang.framework.security.vo.RecipeVO;
import cn.net.tongfang.framework.util.service.vo.PagingResult;
import dlllib.DllUtil;

public class XnhInterfaceServiceImpl implements XnhInterfaceService {

	Logger log = Logger.getLogger(XnhInterfaceServiceImpl.class);
	
	

	@Override
	public DwrListVO findSick(RecipeVO recipeVO) throws Exception {
		log.debug("call findUsers()");
		String cardno = recipeVO.getCardNo();
		List<Object> list = new ArrayList();
		try {
			// 初始化
			int init = DllUtil.INIT("");
			if (init == -1) {
				return new DwrListVO(""+init,"初始化失败!");
			} else {
				// 签到
				Map retmap = DllUtil.businessParam(new HashMap());
				int returncode = (Integer) retmap.get("returncode");
				if (returncode == 0) {
					// 查询卡号下人员信息
					Map paramMap = new HashMap();
					String circleNum = ((String) retmap.get("returnparams")).split("\\|")[0];
					paramMap.put("type", "2150");
					paramMap.put("circleNum", circleNum);
					paramMap.put("otherParam", cardno + "|");
					Map resultMap = DllUtil.businessParam(paramMap);
					int ret = (Integer) resultMap.get("returncode");
					if (ret == 0) {
						String message = ((String) resultMap.get("returnparams"));
						String[] persons = message.split("\\$");
						for (String person : persons) {
							String[] personinfo = person.split("\\|");
							Map personMap = new HashMap();
							personMap.put("name", personinfo[1]);
							personMap.put("sex", personinfo[2]);
							personMap.put("idcard", personinfo[3]);
							personMap.put("type", personinfo[4]);
							personMap.put("connect", personinfo[7]);
							// 查询卡号下人员信息
							Map detailparamMap = new HashMap();
							detailparamMap.put("type", "1400");
							detailparamMap.put("circleNum", circleNum);
							detailparamMap.put("otherParam", new String((personinfo[0] + "|").getBytes(),"gbk"));
							Map detailresultMap = DllUtil.businessParam(detailparamMap);
							int detailret = (Integer) detailresultMap.get("returncode");
							if (detailret == 0) {
								String detailmessage = ((String) detailresultMap.get("returnparams"));
								String[] detailpersoninfo = detailmessage.split("\\|");
								personMap.put("personno", detailpersoninfo[0]);
								personMap.put("personmdno", detailpersoninfo[1]);
								personMap.put("familycardno", detailpersoninfo[2]);
								personMap.put("birthday", detailpersoninfo[7]);// 首次参合时间
								personMap.put("firstdate", detailpersoninfo[8]);// 首次参合时间
								personMap.put("mdcardno", detailpersoninfo[9]);// 合作医疗证号
								personMap.put("relation", detailpersoninfo[10]);// 与户主关系
								personMap.put("mdlevel", detailpersoninfo[15]);// 医疗待遇类别
								personMap.put("money1", detailpersoninfo[21]);// 家庭账户余额
								personMap.put("count", detailpersoninfo[22]);
								personMap.put("money2", detailpersoninfo[23]);//
								personMap.put("money3", detailpersoninfo[24]);
								personMap.put("money4", detailpersoninfo[25]);
								personMap.put("money5", detailpersoninfo[26]);
								personMap.put("money6", detailpersoninfo[27]);
								personMap.put("money7", detailpersoninfo[28]);
								personMap.put("money8", detailpersoninfo[29]);
								personMap.put("money9", detailpersoninfo[30]);
								list.add(personMap);
							} else {
								String errormsg = (String) detailresultMap.get("errorMsg");
								return new DwrListVO(""+detailret,errormsg);
							}
						}
					} else {
						String errormsg = (String) resultMap.get("errorMsg");
						System.out.println("=====errormsg======" + errormsg);
						return new DwrListVO(ret+"",errormsg);
					}
					// throw new Exception(businessSerialno);
				} else {
					String errormsg = (String) retmap.get("errorMsg");
					System.out.println("=====errormsg======" + errormsg);
					return new DwrListVO(""+returncode,errormsg);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new DwrListVO(new PagingResult<Object>(list.size(), list));
	}
	/**
	 * 登记
	 */
	@Override
	public DwrListVO regBill(RecipeVO recipeVO) throws Exception {
		log.debug("call findUsers()");
		String initparam = recipeVO.getCardNo();
		List<Object> list = new ArrayList();
		try {
			// 初始化
			int init = DllUtil.INIT("");
			if (init == -1) {
				return new DwrListVO(init+"","初始化失败!");
			} else {
				// 签到
				Map retmap = DllUtil.businessParam(new HashMap());
				int returncode = (Integer) retmap.get("returncode");
				if (returncode == 0) {
					// 查询卡号下人员信息
					Map paramMap = new HashMap();
					String circleNum = ((String) retmap.get("returnparams")).split("\\|")[0];
					paramMap.put("type", "2210");
					paramMap.put("circleNum", circleNum);
					paramMap.put("otherParam", initparam);
					Map resultMap = DllUtil.businessParam(paramMap);
					int ret = (Integer) resultMap.get("returncode");
					if (ret == 0) {
						String message = ((String) resultMap.get("returnparams"));
						return new DwrListVO(""+ret,message.replaceAll("|", ""));
					} else {
						String errormsg = (String) resultMap.get("errorMsg");
						return new DwrListVO(""+ret,errormsg);
					}
					// throw new Exception(businessSerialno);
				} else {
					String errormsg = (String) retmap.get("errorMsg");
					return new DwrListVO(""+returncode,errormsg);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new DwrListVO(new PagingResult<Object>(list.size(), list));
	}
	
	/**
	 * 登记
	 */
	@Override
	public DwrListVO comBussines(String inputparam,String type) throws Exception {
		log.debug("call findUsers()");
		List<Object> list = new ArrayList();
		try {
			// 初始化
			int init = DllUtil.INIT("");
			if (init == -1) {
				return new DwrListVO(init+"","初始化失败!");
			} else {
				// 签到
				Map retmap = DllUtil.businessParam(new HashMap());
				int returncode = (Integer) retmap.get("returncode");
				if (returncode == 0) {
					// 查询卡号下人员信息
					Map paramMap = new HashMap();
					String circleNum = ((String) retmap.get("returnparams")).split("\\|")[0];
					paramMap.put("type", type);
					paramMap.put("circleNum", circleNum);
					paramMap.put("otherParam", inputparam);
					Map resultMap = DllUtil.businessParam(paramMap);
					int ret = (Integer) resultMap.get("returncode");
					if (ret == 0) {
						String message = ((String) resultMap.get("returnparams"));
						HashMap returnparam = new HashMap();
						String[] params = message.split("\\|");
						for (int i= 0 ; i<params.length;i++){
							returnparam.put("value_"+i, params[i]);
						}
						return new DwrListVO(""+ret, message,returnparam);
					} else {
						return new DwrListVO(""+ret,(String) resultMap.get("errorMsg"));
					}
				} else {
					return new DwrListVO(""+returncode,(String) retmap.get("errorMsg"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new DwrListVO("-1","系统异常:"+e.getMessage());
		}
	}
	/**
	 * 预处理
	 */
	@Override
	public DwrListVO uploadBill(RecipeVO recipeVO,String type) throws Exception {
		log.debug("call findUsers()");
		String initparam = recipeVO.getCardNo();
		List<Object> list = new ArrayList();
		try {
			// 初始化
			int init = DllUtil.INIT("");
			if (init == -1) {
				return new DwrListVO(init+"","初始化失败!");
			} else {
				// 签到
				Map retmap = DllUtil.businessParam(new HashMap());
				for (Object ttt : retmap.keySet()) {
				}
				int returncode = (Integer) retmap.get("returncode");
				if (returncode == 0) {
					// 查询卡号下人员信息
					Map paramMap = new HashMap();
					String circleNum = ((String) retmap.get("returnparams")).split("\\|")[0];
					paramMap.put("type", type);
					paramMap.put("circleNum", circleNum);
					paramMap.put("otherParam",initparam);
					Map resultMap = DllUtil.businessParam(paramMap);
					int ret = (Integer) resultMap.get("returncode");
					if (ret == 0) {
						String message = ((String) resultMap.get("returnparams"));
						DwrListVO retvo = new DwrListVO(""+ret,message.replaceAll("\\|", ""));
						retvo.setReturnParam(message);
						return retvo;
					} else {
						String errormsg = (String) resultMap.get("errorMsg");
						System.out.println("=====errormsg======" + errormsg);
						return new DwrListVO(""+ret,errormsg);
					}
					// throw new Exception(businessSerialno);
				} else {
					String errormsg = (String) retmap.get("errorMsg");
					System.out.println("=====errormsg======" + errormsg);
					return new DwrListVO(""+returncode,errormsg);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new DwrListVO(new PagingResult<Object>(list.size(), list));
	}
	/**
	 * 预处理
	 */
	@Override
	public DwrListVO prePayBill(RecipeVO recipeVO,String type) throws Exception {
		log.debug("call findUsers()");
		String initparam = recipeVO.getCardNo();
		List<Object> list = new ArrayList();
		try {
			// 初始化
			int init = DllUtil.INIT("");
			if (init == -1) {
				return new DwrListVO(init+"","初始化失败!");
			} else {
				// 签到
				Map retmap = DllUtil.businessParam(new HashMap());
				for (Object ttt : retmap.keySet()) {
				}
				int returncode = (Integer) retmap.get("returncode");
				if (returncode == 0) {
					// 查询卡号下人员信息
					Map paramMap = new HashMap();
					String circleNum = ((String) retmap.get("returnparams")).split("\\|")[0];
					paramMap.put("type", type);
					paramMap.put("circleNum", circleNum);
					paramMap.put("otherParam",initparam);
					Map resultMap = DllUtil.businessParam(paramMap);
					int ret = (Integer) resultMap.get("returncode");
					if (ret == 0) {
						String message = ((String) resultMap.get("returnparams"));
						System.out.println("====返回结果======="+message);
						DwrListVO retvo = new DwrListVO(""+ret,message.replaceAll("\\|", ""));
						retvo.setReturnParam(message);
						return  retvo;
					} else {
						String errormsg = (String) resultMap.get("errorMsg");
						System.out.println("=====errormsg======" + errormsg);
						return new DwrListVO(""+ret,errormsg);
					}
					// throw new Exception(businessSerialno);
				} else {
					String errormsg = (String) retmap.get("errorMsg");
					System.out.println("=====errormsg======" + errormsg);
					return new DwrListVO(""+returncode,errormsg);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new DwrListVO(new PagingResult<Object>(list.size(), list));
	}

	public static void main(String[] args) throws Exception {
		String inputparam = "11510770801|11|20110105000000|11|11|20110105000000|9|11|11|101||||||111||1||";
		XnhInterfaceServiceImpl p = new XnhInterfaceServiceImpl();
		System.out.println("----------------登记----------");
		DwrListVO s = p.comBussines(inputparam,"2210");
		System.out.println("======传入参数====="+inputparam);
		System.out.println("======返回结果====="+s.getReturncode()+","+s.getReturnParam()+","+s.getMsg());
		inputparam  = "11510770801|"+s.getReturnParamMap().get("value_0")+"|530000000058|0.9％氯化钠|5863|0.9％氯化钠|20110105000000|1|11|4|1|4||||||||||瓶|急症室|0|1|1|5863|2";
		System.out.println("----------------上传----------");
		DwrListVO s1 = p.comBussines(inputparam,"2310");
		System.out.println("======传入参数====="+inputparam);
		System.out.println("======返回结果====="+s1.getReturncode()+","+s1.getReturnParam()+","+s1.getMsg());
		System.out.println("----------------预结算----------");
		inputparam  = "11510770801|"+s.getReturnParamMap().get("value_0")+"|11|20110105000000|0|系统管理员|";
		DwrListVO s2 = p.comBussines(inputparam,"2420");
		System.out.println("======传入参数====="+inputparam);
		System.out.println("======返回结果====="+s2.getReturncode()+","+s2.getReturnParam()+","+s2.getMsg());
		System.out.println("----------------结算----------");
		//4.0|0.0|0.0|4.0|4.0|0.0|0.0|2.2|1.8|0.0|0.0|0.0|2.2|0.0|0.0|1.8|0|0.45|
		DwrListVO s3 = p.comBussines(inputparam,"2410");
		//4.0|0.0|0.0|4.0|4.0|0.0|0.0|2.2|1.8|0.0|0.0|0.0|2.2|0.0|0.0|1.8|YY1000000000012977|0.45|
		System.out.println("======传入参数====="+inputparam);
		System.out.println("======返回结果====="+s3.getReturncode()+","+s3.getReturnParam()+","+s3.getMsg());
	}


}
