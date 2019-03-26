package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Mes.qiyeInfo;
import Util.DBUtil;
public class qiye {
	public List<qiyeInfo> listNeed(String search){
		List<qiyeInfo> needBeans = new ArrayList<qiyeInfo>();
		String sql = "select * from T_CORP A "
				+ "join T_CORP_PERTAINS Q on A.ORG=Q.ORG AND A.ID=Q.ID and A.SEQ_ID=Q.SEQ_ID "
				+ "where A.CORP_NAME="+"\'"+search+"\'";
		//System.out.println(sql);
		Connection conn =DBUtil.getConnection();
		Statement state =null;
		ResultSet rs = null;
		qiyeInfo needBean =null;
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				needBean = new qiyeInfo();
				needBean.setPERSON_TYPE(rs.getString("PERSON_TYPE"));
				needBean.setPERSON_NAME(rs.getString("PERSON_NAME"));
				needBean.setCORP_NAME(rs.getString("CORP_NAME"));
				needBean.setOPER_MAN_NAME(rs.getString("OPER_MAN_NAME"));
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
