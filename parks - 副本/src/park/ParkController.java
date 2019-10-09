package park;

import java.util.*;

import com.alibaba.fastjson.JSONObject;

public class ParkController extends CCC{

	

	public static void main(String[] args) {
		Timer timer = new Timer();
		ParkService ps = new ParkService();
		Stop s = new Stop();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				//�������ݴ���
				ps.service();
				//����5�κ󣬹ر�ˢ��
				JSONObject jo =JSONObject.parseObject(ps.string);
				String errorCode=jo.getString("errorCode");
				int i=s.stops(errorCode);
//				System.out.println(i);
				if(i>=5) {
					timer.cancel();
				}						

			}
		}, 0, 300000);
	}

}
