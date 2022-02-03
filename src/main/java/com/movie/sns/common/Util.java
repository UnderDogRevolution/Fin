package com.movie.sns.common;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class Util {

	// Sweetalert 세팅용 메소드
	public static void swalSetMessage(String title, String text, String icon, RedirectAttributes ra) {
		ra.addFlashAttribute("title", title);
		ra.addFlashAttribute("text", text);
		ra.addFlashAttribute("icon", icon);
	}

	// 크로스 사이트 스크립트 방지 처리 메소드
	public static String XSS(String param) {
		String result = param;
		if (param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
		}

		return result;
	}

	// 파일명 변경 메소드
	public static String fileRename(String originFileName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = sdf.format(new java.util.Date(System.currentTimeMillis()));

		int ranNum = (int) (Math.random() * 100000); // 5자리 랜덤 숫자 생성

		String str = "_" + String.format("%05d", ranNum);

		String ext = originFileName.substring(originFileName.lastIndexOf("."));

		return date + str + ext;
	}

	// 개행 문자 변경 메소드
	public static String changeNewLine(String content) {
		return content.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
	}

	// 개행 문자 변경 메소드2
	public static String changeNewLine2(String content) {
		return content.replaceAll("<br>", "\r\n");
	}	
	
	public static Object convertMapToObject(Map<String,Object> map,Object obj){
	    String keyAttribute = null;
	    String setMethodString = "set";
	    String methodString = null;
	    Iterator itr = map.keySet().iterator();
	
	    while(itr.hasNext()){
	        keyAttribute = (String) itr.next();
	        methodString = setMethodString+keyAttribute.substring(0,1).toUpperCase()+keyAttribute.substring(1);
	        Method[] methods = obj.getClass().getDeclaredMethods();
	        for(int i=0;i<methods.length;i++){
	            if(methodString.equals(methods[i].getName())){
	                try{
	                    methods[i].invoke(obj, map.get(keyAttribute));
	                }catch(Exception e){
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	    return obj;
	}


	public static String br(String param) {
		String result = param;
		if (param != null) {
			result = result.replaceAll("&lt;br&gt;", "<br>");
		}

		return result;
	}
	
}





