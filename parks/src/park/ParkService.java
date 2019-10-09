package park;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ParkService {
	//各个系统及第三方用户的id
	public static final String APP_ID = "scenic030-0030";
	
	public static final String KEY = "7F28606AEB40B45DBAC0D384194434C2";
	
	public static final String SCENIC_ID = "12181e91-5c31-11e9-a2d8-000c297b3bf7";
	
	public String string =null;

	/**
	 * 请求接口
	 * 
	 * @param requestUrl
	 * @param json
	 * @return
	 */
	private static String httpRequest(String requestUrl, JSONObject json) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.addHeader("Content-Type", "application/json");
		try {
			HttpEntity entity = new StringEntity(json.toString(), "utf-8");
			httpPost.setEntity(entity);
			CloseableHttpResponse response = httpclient.execute(httpPost);
			int i = response.getStatusLine().getStatusCode();
			HttpEntity httpentity = response.getEntity();
			InputStream inputStream = httpentity.getContent();
			ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = -1;
			while ((len = inputStream.read(buffer)) != -1) {
				outSteam.write(buffer, 0, len);
			}
			outSteam.close();
			inputStream.close();
			String result = new String(outSteam.toByteArray(), "utf-8");
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void service() {
		ParkDao pd = new ParkDao();
		// 生成随机码，保证签名不可预测
		String nonce_str = ParkEntity.generateNonceStr();
		// url参数，按照ASCII 码从小到大排序（字典序）
		String urlParams = "appId=" + APP_ID + "&nonce_str=" + nonce_str;
		// 生成签名
		String sign = ParkEntity.MD5(urlParams + "&key=" + KEY);
		// 请求url
		String requestUrl = "http://47.110.254.165:8888/ms_scemanage/api/saveJointActualParkList?" + urlParams + "&sign=" + sign;							
		// 虚拟请求参数
		JSONObject json = new JSONObject();
		// 统计区id，根据实际值修改
		json.put("parkId", "2d8c8136-ad21-11e9-b90d-00163f00dc26");
		json.put("actualRemainParkNum", pd.totals());
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(json);

		JSONObject params = new JSONObject();
		params.put("list", jsonArray);
		// 请求接口
		string = httpRequest(requestUrl, params);
//		System.out.println("查看输出结果:" + string);
	}
}
