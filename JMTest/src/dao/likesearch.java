package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Util.DBUtil;

import Mes.TCorpId;

public class likesearch {
	//根据CORP_NAME模糊查询
		/*
		 * 根据输入的值模糊匹配公司名
		 */
		public ArrayList<TCorpId> selectByCompanyName(String search) {
			ArrayList<TCorpId> companys=new ArrayList<>();
			StringBuffer sql=new StringBuffer();
			PreparedStatement pst=null;
			ResultSet rs=null;
			sql.append(" select DISTINCT CORP_NAME,ORG,ID,SEQ_ID from T_CORP ");
			sql.append(" where CORP_NAME like ? ");
			Connection conn =DBUtil.getConnection();
			try {
				pst=conn.prepareStatement(sql.toString());
				pst.setString(1, "%"+search+"%");
				rs=pst.executeQuery();
				while(rs.next()) {
					String companyname=rs.getString("CORP_NAME");
					System.out.println(companyname);
					TCorpId company=new TCorpId();
					company.setCORP_NAME(companyname);
					company.setORG(rs.getString("ORG"));
					company.setID(rs.getString("ID"));
					company.setSEQ_ID(rs.getString("SEQ_ID"));
					companys.add(company);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally {
				DBUtil.close(rs);
			}
			return companys;
		}

}
