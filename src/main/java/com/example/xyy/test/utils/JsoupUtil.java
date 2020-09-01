package com.example.xyy.test.utils;

import java.util.Map;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/**
 * 使用jsoup发送请求
 * 
 * @author Administrator
 *
 */
public class JsoupUtil {

	
	
	/**
	 * 功能： 发送post请求，参数是json格式
	 * 
	 * @param serverIP          服务端的ip
	 * @param serverPort        服务端的端口
	 * @param jsonStr           要发送的json数据
	 * @param requestActionName 请求的动作名
	 * @param cookies           cookies
	 * @return 服务端相应结果
	 * @throws Exception 异常谁调用，谁处理
	 */
	public static String sendPost(String serverIP, String serverPort, String jsonStr, String requestActionName,
			Map<String, String> cookies) throws Exception {
		
		String url = serverIP + ":" + serverPort + "/" + requestActionName.trim(); 
//		String url = serverIP + ":" + serverPort + "/accountManagement/" + requestActionName.trim()
//				+ ".action";
		Document doc = Jsoup.connect(url)
				.header("Content-Type", "application/json; charset=UTF-8")
				.requestBody(jsonStr)
				.maxBodySize(100)
				.timeout(1000 * 10)
				.ignoreContentType(true)
				.maxBodySize(0)
				.cookies(cookies)	//携带cookie访问
				.post();

//	        System.out.println(doc);

		return doc.select("body").text();
	}

	/**
	 * 功能： 发送post请求，参数是json格式,不需要cookie的
	 * 
	 * @param serverIP          服务端的ip
	 * @param serverPort        服务端的端口
	 * @param jsonStr           要发送的json数据
	 * @param requestActionName 请求的动作名
	 * @return 服务端相应结果
	 * @throws Exception 异常谁调用，谁处理
	 */
	public static String sendPost(String serverIP, String serverPort, String jsonStr, String requestActionName)throws Exception {
//		String url = "http://192.168.0.213:8086/accountManagement/manageCode.action";   
		String url = "http://"+serverIP + ":" + serverPort+"/fullServiceMange"+requestActionName.trim(); // accountLogin
//		String url = serverIP + ":" + serverPort + "/accountManagement/" + requestActionName.trim() + ".action";		
		Document doc = Jsoup.connect(url)
				.header("Content-Type", "application/json; charset=UTF-8")
				.requestBody(jsonStr)
				.maxBodySize(100)
				.timeout(1000 * 10)
				.ignoreContentType(true)
				.maxBodySize(0)
				.post();


		return doc.select("body").text();
	}



	
	
	public static void main(String[] args)  {
		String param = "{\"seDate\":\"2019-10-01~2019-10-10\"}";
		System.out.println(param);
		String sendPost;
		try {
			sendPost = sendPost("192.168.0.49", "8082", null, "/selectLog");
			System.out.println(sendPost);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	 public static<T> Object JSONToObj(String jsonStr,Class<T> obj) {
		    T t = null;
		    try {
		      ObjectMapper objectMapper = new ObjectMapper();
		      t = objectMapper.readValue(jsonStr,
		          obj);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return t;
		  }
	
	
}
