package cn.net.tongfang.framework.util;

import java.util.HashMap;

public class EncryptionUtils {
	private static final HashMap<String, String> ENCODE_HASHMAP = new HashMap<String, String>();
	private static final HashMap<String, String> DECODE_HASHMAP = new HashMap<String, String>();
	private static final int STEP = 2;
	private static char[] charArray = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','t'};
	static {
		// 数字
		ENCODE_HASHMAP.put("0", "$");
		ENCODE_HASHMAP.put("1", "&");
		ENCODE_HASHMAP.put("2", "@");
		ENCODE_HASHMAP.put("3", "*");
		ENCODE_HASHMAP.put("4", "!");
		ENCODE_HASHMAP.put("5", ".");
		ENCODE_HASHMAP.put("6", ":");
		ENCODE_HASHMAP.put("7", "=");
		ENCODE_HASHMAP.put("8", ">");
		ENCODE_HASHMAP.put("9", "}");
		// 小写字母
		ENCODE_HASHMAP.put("a", "€");
		ENCODE_HASHMAP.put("b", "‚");
		ENCODE_HASHMAP.put("c", "ƒ");
		ENCODE_HASHMAP.put("d", "ˆ");
		ENCODE_HASHMAP.put("e", "‰");
		ENCODE_HASHMAP.put("f", "Š");
		ENCODE_HASHMAP.put("g", "‹");
		ENCODE_HASHMAP.put("h", "Œ");
		ENCODE_HASHMAP.put("i", "Ž");
		ENCODE_HASHMAP.put("j", "‘");
		ENCODE_HASHMAP.put("k", "’");
		ENCODE_HASHMAP.put("l", "•");
		ENCODE_HASHMAP.put("m", "–");
		ENCODE_HASHMAP.put("n", "à");
		ENCODE_HASHMAP.put("o", "á");
		ENCODE_HASHMAP.put("p", "â");
		ENCODE_HASHMAP.put("q", "ã");
		ENCODE_HASHMAP.put("r", "ä");
		ENCODE_HASHMAP.put("s", "æ");
		ENCODE_HASHMAP.put("t", "ç");
		ENCODE_HASHMAP.put("u", "ç");
		ENCODE_HASHMAP.put("v", "è");
		ENCODE_HASHMAP.put("w", "é");
		ENCODE_HASHMAP.put("x", "ê");
		ENCODE_HASHMAP.put("y", "ë");
		ENCODE_HASHMAP.put("z", "ì");
		// 大写字母
		ENCODE_HASHMAP.put("A", "ß");
		ENCODE_HASHMAP.put("B", "Þ");
		ENCODE_HASHMAP.put("C", "Ý");
		ENCODE_HASHMAP.put("D", "Ü");
		ENCODE_HASHMAP.put("E", "Û");
		ENCODE_HASHMAP.put("F", "Ü");
		ENCODE_HASHMAP.put("G", "Û");
		ENCODE_HASHMAP.put("H", "Ú");
		ENCODE_HASHMAP.put("I", "Ù");
		ENCODE_HASHMAP.put("J", "Ø");
		ENCODE_HASHMAP.put("K", "Ö");
		ENCODE_HASHMAP.put("L", "Õ");
		ENCODE_HASHMAP.put("M", "Ô");
		ENCODE_HASHMAP.put("N", "Ó");
		ENCODE_HASHMAP.put("O", "Ò");
		ENCODE_HASHMAP.put("P", "Ñ");
		ENCODE_HASHMAP.put("Q", "Ð");
		ENCODE_HASHMAP.put("R", "Ï");
		ENCODE_HASHMAP.put("S", "Ê");
		ENCODE_HASHMAP.put("T", "É");
		ENCODE_HASHMAP.put("U", "Ç");
		ENCODE_HASHMAP.put("V", "Æ");
		ENCODE_HASHMAP.put("W", "Ä");
		ENCODE_HASHMAP.put("X", "Ã");
		ENCODE_HASHMAP.put("Y", "£");
		ENCODE_HASHMAP.put("Z", "Á");
	}
	static {
		// 数字
		DECODE_HASHMAP.put("$", "0");
		DECODE_HASHMAP.put("&", "1");
		DECODE_HASHMAP.put("@", "2");
		DECODE_HASHMAP.put("*", "3");
		DECODE_HASHMAP.put("!", "4");
		DECODE_HASHMAP.put(".", "5");
		DECODE_HASHMAP.put(":", "6");
		DECODE_HASHMAP.put("=", "7");
		DECODE_HASHMAP.put(">", "8");
		DECODE_HASHMAP.put("}", "9");
		// 小写字母
		DECODE_HASHMAP.put("€", "a");
		DECODE_HASHMAP.put("‚", "b");
		DECODE_HASHMAP.put("ƒ", "c");
		DECODE_HASHMAP.put("ˆ", "d");
		DECODE_HASHMAP.put("‰", "e");
		DECODE_HASHMAP.put("Š", "f");
		DECODE_HASHMAP.put("‹", "g");
		DECODE_HASHMAP.put("Œ", "h");
		DECODE_HASHMAP.put("Ž", "i");
		DECODE_HASHMAP.put("‘", "j");
		DECODE_HASHMAP.put("’", "k");
		DECODE_HASHMAP.put("•", "l");
		DECODE_HASHMAP.put("–", "m");
		DECODE_HASHMAP.put("à", "n");
		DECODE_HASHMAP.put("á", "o");
		DECODE_HASHMAP.put("â", "p");
		DECODE_HASHMAP.put("ã", "q");
		DECODE_HASHMAP.put("ä", "r");
		DECODE_HASHMAP.put("æ", "s");
		DECODE_HASHMAP.put("ç", "t");
		DECODE_HASHMAP.put("ç", "u");
		DECODE_HASHMAP.put("è", "v");
		DECODE_HASHMAP.put("é", "w");
		DECODE_HASHMAP.put("ê", "x");
		DECODE_HASHMAP.put("ë", "y");
		DECODE_HASHMAP.put("ì", "z");
		// 大写字母
		DECODE_HASHMAP.put("ß", "A");
		DECODE_HASHMAP.put("Þ", "B");
		DECODE_HASHMAP.put("Ý", "C");
		DECODE_HASHMAP.put("Ü", "D");
		DECODE_HASHMAP.put("Û", "E");
		DECODE_HASHMAP.put("Ü", "F");
		DECODE_HASHMAP.put("Û", "G");
		DECODE_HASHMAP.put("Ú", "H");
		DECODE_HASHMAP.put("Ù", "I");
		DECODE_HASHMAP.put("Ø", "J");
		DECODE_HASHMAP.put("Ö", "K");
		DECODE_HASHMAP.put("Õ", "L");
		DECODE_HASHMAP.put("Ô", "M");
		DECODE_HASHMAP.put("Ó", "N");
		DECODE_HASHMAP.put("Ò", "O");
		DECODE_HASHMAP.put("Ñ", "P");
		DECODE_HASHMAP.put("Ð", "Q");
		DECODE_HASHMAP.put("Ï", "R");
		DECODE_HASHMAP.put("Ê", "S");
		DECODE_HASHMAP.put("É", "T");
		DECODE_HASHMAP.put("Ç", "U");
		DECODE_HASHMAP.put("Æ", "V");
		DECODE_HASHMAP.put("Ä", "W");
		DECODE_HASHMAP.put("Ã", "X");
		DECODE_HASHMAP.put("£", "Y");
		DECODE_HASHMAP.put("Á", "Z");
	}

	/**
	 * 加密
	 * 
	 * @param str
	 * @return
	 */
	public static final String encry(String str) {
		String result = "";
		String tmpStr = "";
		char[] charData = str.toCharArray();
		for(int i = 0;i < charData.length;i++){
			tmpStr = String.copyValueOf(charData, i, 1);
			if (!tmpStr.equals("%") && tmpStr != "%") {
				if (ENCODE_HASHMAP.get(tmpStr) == null) {
					tmpStr = encryChinese(tmpStr);
				} else {
					tmpStr = ENCODE_HASHMAP.get(tmpStr);
				}
			}
			result = result + tmpStr;
		}
		return result;
	}

	/**
	 * 解密
	 * 
	 * @param str
	 * @return
	 */
	public static final String decipher(String str) {
		String result = "";
		String tmpStr = "";
		char[] charData = str.toCharArray();
		for(int i = 0;i < charData.length;i++){
			tmpStr = String.copyValueOf(charData, i, 1);
			if (!tmpStr.equals("%") && tmpStr != "%") {
				if (DECODE_HASHMAP.get(tmpStr) == null) {
					tmpStr = decipherChinese(tmpStr);
				} else {
					tmpStr = DECODE_HASHMAP.get(tmpStr);
				}
			}
			result = result + tmpStr;
		}
		return result;
	}
	
	/**
	 * 其它字符加密
	 * @param str
	 * @return
	 */
	public static final String encryChinese(String str){
		int len = 0;
		char[] chars = str.toCharArray();
		for(int i = 0;i<chars.length;i++){
			if(i >= charArray.length){
				len = 0;
			}else{
				len = i + STEP;
			}
			chars[i] = (char)(chars[i] ^ charArray[len]);
		}
		String result = new String(chars);
		return result;
	}
	
	/**
	 * 其它字符加密
	 * @param str
	 * @return
	 */
	public static final String decipherChinese(String str){
		int len = 0;
		char[] chars = str.toCharArray();
		for(int i = 0;i<chars.length;i++){
			if(i >= charArray.length){
				len = 0;
			}else{
				len = i + STEP;
			}
			chars[i] = (char)(chars[i] ^ charArray[len]);
		}
		String result = new String(chars);
		return result;
	}
	
	/**
	 * 测试
	 * @param args
	 */
	/*
	public static void main(String[] args){
		String str1 = encry("admin");
		System.out.println(str1);
		String str2 = decipher(str1);
		System.out.println(str2);
		
		String str3 = encry("2001901991");
		System.out.println(str3);
		String str4 = decipher(str3);
		System.out.println(str4);
		
		String str5 = encry("我们_?%");
		System.out.println(str5);
		String str6 = decipher(str5);
		System.out.println(str6);
	}*/
}
