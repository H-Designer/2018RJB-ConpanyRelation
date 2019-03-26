package Mes;

public class touziInfo {
	String CORP_NAME;//公司
	String OPER_MAN_IDENT_NO;//负责人编号
	String OPER_MAN_NAME;//负责人
	String REG_CAPI;//注册资金
	String DIST_NAME;//分支机构（外资）
	String STOCK_CAPI_TYPE;//股权种类
	public String getOPER_MAN_IDENT_NO() {
		return OPER_MAN_IDENT_NO;
	}
	public void setOPER_MAN_IDENT_NO(String oPER_MAN_IDENT_NO) {
		OPER_MAN_IDENT_NO = oPER_MAN_IDENT_NO;
	}
	public String getOPER_MAN_NAME() {
		return OPER_MAN_NAME;
	}
	public void setOPER_MAN_NAME(String oPER_MAN_NAME) {
		OPER_MAN_NAME = oPER_MAN_NAME;
	}
	public String getREG_CAPI() {
		return REG_CAPI;
	}
	public void setREG_CAPI(String rEG_CAPI) {
		REG_CAPI = rEG_CAPI;
	}
	String STOCK_CAPI_RMB;//股权金额（人名币）
	String STOCK_CAPI;//金额
	String STOCK_PERCENT;//股金占比
	public String getCORP_NAME() {
		return CORP_NAME;
	}
	public void setCORP_NAME(String cORP_NAME) {
		CORP_NAME = cORP_NAME;
	}
	
	public String getSTOCK_CAPI_TYPE() {
		return STOCK_CAPI_TYPE;
	}
	public void setSTOCK_CAPI_TYPE(String sTOCK_CAPI_TYPE) {
		STOCK_CAPI_TYPE = sTOCK_CAPI_TYPE;
	}
	public String getSTOCK_CAPI_RMB() {
		return STOCK_CAPI_RMB;
	}
	public void setSTOCK_CAPI_RMB(String sTOCK_CAPI_RMB) {
		STOCK_CAPI_RMB = sTOCK_CAPI_RMB;
	}
	public String getSTOCK_CAPI() {
		return STOCK_CAPI;
	}
	public void setSTOCK_CAPI(String sTOCK_CAPI) {
		STOCK_CAPI = sTOCK_CAPI;
	}
	public String getSTOCK_PERCENT() {
		return STOCK_PERCENT;
	}
	public void setSTOCK_PERCENT(String sTOCK_PERCENT) {
		STOCK_PERCENT = sTOCK_PERCENT;
	}
	public String getDIST_NAME() {
		return DIST_NAME;
	}
	public void setDIST_NAME(String dIST_NAME) {
		DIST_NAME = dIST_NAME;
	}
}
