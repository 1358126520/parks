package park;


public class Stop extends CCC{
	int i=0;
	public int stops(String errorCode) {
		//出错时，关闭刷新
		switch(Integer.parseInt(errorCode)) {
			case 40001:sysLog.info("缺少权限验证参数");i++;break;
			case 40002:sysLog.info("Sign校验失败");i++;break;
			case 40003:sysLog.info("接口权限验证失败");i++;break;
			case 40004:sysLog.info("IP验证失败");i++;break;
			case 40005:sysLog.info("超过日调用上限");i++;break;
			case 40006:sysLog.info("超出频率限制");i++;break;
			case 40007:sysLog.info("账号已过期");i++;break;
			case 40008:sysLog.info("无此用户");i++;break;
			case 41001:sysLog.info("缺少URL参数");i++;break;
			case 41002:sysLog.info("缺少参数");i++;break;
			case 41003:sysLog.info("参数错误");i++;break;
			case 41004:sysLog.info("数据异常");i++;break;
			case 41005:sysLog.info("数据类型异常");i++;break;
			case -1:sysLog.info("其他错误");i++;break;
		}
		return i;
	}
	
	
	
	
	
}
