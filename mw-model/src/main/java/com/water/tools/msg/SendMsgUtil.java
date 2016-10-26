/**
  * 文件说明
  * @Description:扩展说明
  * @Copyright: 2015 dreamtech.com.cn Inc. All right reserved
  * @Version: V6.0
  */
package com.water.tools.msg;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**  
 * @Author: feizi
 * @Date: 2015年4月17日 上午9:24:48 
 * @ModifyUser: feizi
 * @ModifyDate: 2015年4月17日 上午9:24:48 
 * @Version:V6.0
 */
public class SendMsgUtil {
	
	/**
	 * 发送短信消息
	  * 方法说明
	  * @Discription:扩展说明
	  * @param phones
	  * @param content
	  * @return
	  * @return String
	  * @Author: feizi
	  * @Date: 2015年4月17日 下午7:18:08
	  * @ModifyUser：feizi
	  * @ModifyDate: 2015年4月17日 下午7:18:08
	 */
	@SuppressWarnings("deprecation")
	public static String sendMsg(String phones,String content){
		//短信接口URL提交地址
		String url = "http://service.winic.org:8009/sys_port/gateway/index.asp";//短信网接口地址
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("id", "zhangxiaoxu");
		params.put("pwd", "1321135715");
		params.put("to", "18124016607");
//		params.put("extno", "扩展编号");
		
		//手机号码，多个号码使用英文逗号进行分割
//		params.put("Phones", phones);
		//将短信内容进行URLEncoder编码
		params.put("content", URLEncoder.encode(content));
		
		return HttpRequestUtil.getRequest(url, params);
	}
	
	/**
	 * 随机生成6位随机验证码
	  * 方法说明
	  * @Discription:扩展说明
	  * @return
	  * @return String
	  * @Author: feizi
	  * @Date: 2015年4月17日 下午7:19:02
	  * @ModifyUser：feizi
	  * @ModifyDate: 2015年4月17日 下午7:19:02
	 */
	public static String createRandomVcode(){
		//验证码
		String vcode = "";
		for (int i = 0; i < 6; i++) {
			vcode = vcode + (int)(Math.random() * 9);
		}
		return vcode;
	}
	
	/**
	 * 测试
	  * 方法说明
	  * @Discription:扩展说明
	  * @param args
	  * @return void
	  * @Author: feizi
	  * @Date: 2015年4月17日 下午7:26:36
	  * @ModifyUser：feizi
	  * @ModifyDate: 2015年4月17日 下午7:26:36
	 */
	public static void main(String[] args) {
//		System.out.println(SendMsgUtil.createRandomVcode());
//		System.out.println("&ecb=12".substring(1));
		System.out.println(sendMsg("15017916946", "尊敬的用户，您的验证码为" + SendMsgUtil.createRandomVcode() + "，有效期为60秒，如有疑虑请详询400-069-2886（客服电话）【XXX中心】"));
	}
}
