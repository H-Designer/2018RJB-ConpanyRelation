package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Mes.touziInfo;
import Mes.yisiInfo;
import Util.DBUtil;
public class yisi {
	public List<yisiInfo> listNeed(String search){
		List<yisiInfo> needBeans = new ArrayList<yisiInfo>();
		String sql = "select * from T_M_CORP_CORP_PERTAINS M5 "
				+ "join T_CORP A on A.ORG=M5.ORG AND A.ID=M5.ID AND A.SEQ_ID=M5.SEQ_ID  "
				+ "join T_CORP_PERTAINS P on P.ORG=M5.SUB_ORG AND P.ID=M5.SUB_ID AND P.SEQ_ID=M5.SUB_SEQ_ID "
				+ "where A.CORP_NAME="+"\'"+search+"\'";
		//System.out.println(sql);
		Connection conn =DBUtil.getConnection();
		Statement state =null;
		ResultSet rs = null;
		yisiInfo needBean =null;
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				needBean = new yisiInfo();
				needBean.setCORP_NAME(rs.getString("CORP_NAME"));
				needBean.setOPER_MAN_NAME(rs.getString("OPER_MAN_NAME"));
				needBean.setPERSON_NAME(rs.getString("PERSON_NAME"));
				needBeans.add(needBean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, state, conn);
		}
		return needBeans;
	}
}
