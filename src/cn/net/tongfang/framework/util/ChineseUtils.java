package cn.net.tongfang.framework.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


public class ChineseUtils {
	/**
	 * 获得汉字的声母
	 * @param chinese
	 * @return
	 */
	public static String getFirstLetterFromChinese(String chinese) {
		String firstLetter = "";
		char[] chars = chinese.toCharArray();
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();//利用pinyin4j的开源方法，格式化输出
		format.setCaseType(HanyuPinyinCaseType.UPPERCASE);//大写输出
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//无标注输出
		for(int i = 0; i < chars.length;i++){
			if(chars[i] > 128){
				try {
					firstLetter += PinyinHelper.toHanyuPinyinStringArray(chars[i],format)[0].charAt(0);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			}else{
				firstLetter += chars[i];
			}
		}
		return firstLetter;
	}

	/**
	 * 汉字转拼音
	 * @param chinese
	 * @return
	 */
	public static String convertChineseToPinyin(String chinese) {
		String pinyin = "";
		char[] chars = chinese.toCharArray();
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();//利用pinyin4j的开源方法，格式化输出
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);//小写输出
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//无标注输出
		for(int i = 0; i < chars.length;i++){
			if(chars[i] > 128){
				try {
					pinyin += PinyinHelper.toHanyuPinyinStringArray(chars[i],format)[0];
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			}else{
				pinyin += chars[i];
			}
		}
		return pinyin;
	}
}
