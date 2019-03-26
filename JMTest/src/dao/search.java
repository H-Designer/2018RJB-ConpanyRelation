package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Mes.information;
import Util.DBUtil;
public class search {
	public List<information> listNeed(String search){
		List<information> needBeans = new ArrayList<information>();
		
		String sql = "select * from t_corp where CORP_NAME= "+"\'"+search+"\'";
		//System.out.println(sql);
		Connection conn =DBUtil.getConnection();
		Statement state =null;
		ResultSet rs = null;
		information needBean =null;
		try{
			state=conn.createStatement();
			rs=state.executeQuery(sql);
			while(rs.next()){
				needBean = new information();
				needBean.setREG_NO(rs.getString("REG_NO"));
				needBean.setADDR(rs.getString("ADDR"));
				needBean.setBELONG_ORG(rs.getString("BELONG_ORG"));
				needBean.setCORP_NAME(rs.getString("CORP_NAME"));
				needBean.setECON_KIND(rs.getString("ECON_KIND"));
				needBean.setFARE_SCOPE(rs.getString("FARE_SCOPE"));
				needBean.setOPER_MAN_NAME(rs.getString("OPER_MAN_NAME"));
				needBean.setREG_CAPI(rs.getString("REG_CAPI"));
				needBean.setSTART_DATE(rs.getString("START_DATE"));
				needBean.setPRAC_PERSON_NUM(rs.getString("PRAC_PERSON_NUM"));
				needBean.setEMAIL(rs.getString("EMAIL"));
				needBean.setWEB_URL(rs.getString("WEB_URL"));
				needBean.setTEL(rs.getString("TEL"));
				needBean.setUNI_SCID(rs.getString("UNI_SCID"));
				needBean.setFORMER_NAME(rs.getString("FORMER_NAME"));
				needBean.setENGLISH_NAME(rs.getString("ENGLISH_NAME"));
				needBean.setTAXPAY_NUM(rs.getString("TAXPAY_NUM"));
				needBean.setORG_INST_CODE(rs.getString("ORG_INST_CODE"));
				needBean.setFARE_TERM_START(rs.getString("FARE_TERM_START"));
				needBean.setFARE_TERM_END(rs.getString("FARE_TERM_END"));
				needBean.setCHECK_DATE(rs.getString("CHECK_DATE"));
				needBean.setADMIT_MAIN(rs.getString("ADMIT_MAIN"));
				needBean.setOPER_MAN_IDENT_NO(rs.getString("OPER_MAN_IDENT_NO"));
				needBean.setCORP_STATUS(rs.getString("CORP_STATUS"));
				needBean.setSTAFF_SIZE(rs.getString("STAFF_SIZE"));
				needBean.setPRAC_PERSON_NUM(rs.getString("PRAC_PERSON_NUM"));
				needBean.setBELONG_TRADE(rs.getString("BELONG_TRADE"));
			
				
				
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
