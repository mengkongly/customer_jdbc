package domain;

public class ConvertDate {
	public java.util.Date convertSqlDateToUtilDate(java.sql.Date sqlDate){
    	java.sql.Date date = new java.sql.Date(sqlDate.getTime());
    	java.util.Date utilDate = new java.util.Date(date.getTime());
    	return utilDate;
    }
    
    public java.sql.Date convertUtilDateToSqlDate(java.util.Date utilDate){
    	java.util.Date date = new java.util.Date(utilDate.getTime());
    	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    	return sqlDate;
    }
}
