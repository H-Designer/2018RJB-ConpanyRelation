package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Mes.touziInfo;
import Util.DBUtil;
public class touzi {
	public List<touziInfo> listNeed(String search){
		List<touziInfo> needBeans = new ArrayList<touziInfo>();
		String sql = "select * from T_M_CORP_CORP_DIST M4 "
				+ "join T_CORP A on M4.ORG=A.ORG AND M4.ID=A.ID and M4.SEQ_ID=A.SEQ_ID "
				+ "join T_CORP_DIST D on D.ORG=M4.SUB_ORG and D.ID=M4.SUB_ID AND D.SEQ_ID=M4.SUB_SEQ_ID "
				+ "where A.CORP_NAME="+"\'"+search+"\'";
		//System.out.println(sql);
		Connection conn =DBUtil.getConnection();
		Statement state =null;
		ResultSet rs = null;
		touziInfo needBean =null;
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				needBean = new touziInfo();
				needBean.setCORP_NAME(rs.getString("CORP_NAME"));
				needBean.setOPER_MAN_NAME(rs.getString("OPER_MAN_NAME"));
				needBean.setREG_CAPI(rs.getString("REG_CAPI"));
				needBean.setDIST_NAME(rs.getString("DIST_NAME"));
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
