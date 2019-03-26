package Mes;

public class guquanInfo {
	String CORP_NAME;//公司
	String STOCK_NAME;//股权人
	String STOCK_CAPI_TYPE;//股权种类
	String STOCK_CAPI_RMB;//股权金额（人名币）
	String STOCK_CAPI;//金额
	String STOCK_TYPE;
	String STOCK_RATE_RMB;
	public String getSTOCK_RATE_RMB() {
		return STOCK_RATE_RMB;
	}
	public void setSTOCK_RATE_RMB(String sTOCK_RATE_RMB) {
		STOCK_RATE_RMB = sTOCK_RATE_RMB;
	}
	public String getSTOCK_CAPI() {
		return STOCK_CAPI;
	}
	public String getSTOCK_TYPE() {
		return STOCK_TYPE;
	}
	public void setSTOCK_TYPE(String sTOCK_TYPE) {
		STOCK_TYPE = sTOCK_TYPE;
	}
	public void setSTOCK_CAPI(String sTOCK_CAPI) {
		STOCK_CAPI = sTOCK_CAPI;
	}
	public String getSTOCK_CAPI_RMB() {
		return STOCK_CAPI_RMB;
	}
	public void setSTOCK_CAPI_RMB(String sTOCK_CAPI_RMB) {
		STOCK_CAPI_RMB = sTOCK_CAPI_RMB;
	}
	public String getSTOCK_NAME() {
		return STOCK_NAME;
	}
	public String getCORP_NAME() {
		return CORP_NAME;
	}
	public void setCORP_NAME(String cORP_NAME) {
		CORP_NAME = cORP_NAME;
	}
	public void setSTOCK_NAME(String sTOCK_NAME) {
		STOCK_NAME = sTOCK_NAME;
	}
	public String getSTOCK_CAPI_TYPE() {
		return STOCK_CAPI_TYPE;
	}
	public void setSTOCK_CAPI_TYPE(String sTOCK_CAPI_TYPE) {
		STOCK_CAPI_TYPE = sTOCK_CAPI_TYPE;
	}
	public String getSTOCK_PERCENT() {
		return STOCK_PERCENT;
	}
	public void setSTOCK_PERCENT(String sTOCK_PERCENT) {
		STOCK_PERCENT = sTOCK_PERCENT;
	}
	String STOCK_PERCENT;//股金占比
}
