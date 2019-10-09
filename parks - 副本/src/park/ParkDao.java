package park;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParkDao{
	
	public int totals() {
		Map<String,String> map=new HashMap<String,String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//创建连接URL
			String url = "jdbc:mysql://192.168.2.230:5831/ktpark?useUnicode=true&serverTimezone=UTC&characterEncoding=UTF-8";
//			String url = "jdbc:mysql://localhost:3306/www?useUnicode=true&serverTimezone=UTC&characterEncoding=UTF-8";															
			//建立连接
			Connection con = DriverManager.getConnection(url, "root", "123456");
//			Connection con = DriverManager.getConnection(url, "root", "123");
			//创建语句
			Statement stmt = con.createStatement();
			// 执行查询，返回结果集
			String sss="SELECT count(*) FROM t_carcome where date_format(comeTime,'%y-%m-%d') >=date_format(now(),'%y-%m-%d')";
			ResultSet rs = stmt.executeQuery(sss);
//			System.out.println(sss);
			if(rs.next()) {
				map.put("actualRemainParkNum",rs.getInt(1)+"");
//				System.out.println(rs.getInt(1));
			}
//			System.out.println(map);
			stmt.close();
			con.close();
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		return 1500-Integer.parseInt(map.get("actualRemainParkNum"));
	}
}
