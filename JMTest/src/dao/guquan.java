package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Mes.guquanInfo;
import Util.DBUtil;
public class guquan {
	public List<guquanInfo> listNeed(String search){
		List<guquanInfo> needBeans = new ArrayList<guquanInfo>();
		String sql = "select * from T_M_CORP_CORP_STOCK M1 "
				+ "join T_CORP A on A.ORG=M1.ORG and A.ID=M1.ID and A.SEQ_ID=M1.SEQ_ID "
				+ "join T_CORP_STOCK S on S.ORG=M1.SUB_ORG and S.ID=M1.SUB_ID and S.SEQ_ID=M1.SUB_SEQ_ID "
				+ "where A.CORP_NAME="+"\'"+search+"\'";
		
		//System.out.println(sql);
		Connection conn =DBUtil.getConnection();
		Statement state =null;
		ResultSet rs = null;
		guquanInfo needBean =null;
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				needBean = new guquanInfo();
				needBean.setCORP_NAME(rs.getString("CORP_NAME"));
				needBean.setSTOCK_NAME(rs.getString("STOCK_NAME"));
				needBean.setSTOCK_CAPI_TYPE(rs.getString("STOCK_CAPI_TYPE"));
				needBean.setSTOCK_PERCENT(rs.getString("STOCK_PERCENT"));
				needBean.setSTOCK_CAPI_RMB(rs.getString("STOCK_CAPI_RMB"));
				needBean.setSTOCK_CAPI(rs.getString("STOCK_CAPI"));
				needBean.setSTOCK_TYPE(rs.getString("STOCK_TYPE"));
				needBean.setSTOCK_RATE_RMB(rs.getString("STOCK_RATE_RMB"));
				
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
