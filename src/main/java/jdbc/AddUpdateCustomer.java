package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import domain.ConvertDate;
import domain.Customer;



public class AddUpdateCustomer {
	private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
 
    public AddUpdateCustomer() {
        
    }
    
    //delete sql
    public int deleteRecord(int id) throws SQLException {
        try {
            // get Connection from datasource
            connection = DBCP2DataSourceUtils.getConnection();

            // insert sql using prepared statement
            preparedStatement = connection.prepareStatement("delete from tab_customer where id=?");
            // set parameter
            preparedStatement.setInt(1, id); //set id
            int result	=	preparedStatement.executeUpdate();
            return result;
        }
        finally {
            close();
        }
    }
    //Insert SQL
    public int writeData(String firstName,String lastName,String gender,String email,String phone,String address,Date dob) throws Exception {
        try {
        	ConvertDate conDate	=	new ConvertDate();
            connection = DBCP2DataSourceUtils.getConnection();
            // insert sql using prepared statement
            preparedStatement = connection.prepareStatement("insert into tab_customer(firstName,lastName,gender,email,phone,address,dob) "
            		+ "values (?,?,?,?,?,?,?)");
            // set parameter
            preparedStatement.setString(1, firstName); 
            preparedStatement.setString(2, lastName); 
            preparedStatement.setString(3, gender); 
            preparedStatement.setString(4, email); 
            preparedStatement.setString(5, phone);  
            preparedStatement.setString(6, address);
            preparedStatement.setDate(7, conDate.convertUtilDateToSqlDate(dob));
            int result	=	preparedStatement.executeUpdate();
            System.out.println("Insert record successfully -" + firstName+" "+lastName);
            return result;
        }
        finally {
            close();
        }
    }
    
    /***
     * update record table
     * @param id
     * @param message
     * @throws Exception
     */
    public int upateData(int id, String firstName,String lastName,String gender,String email,String phone,String address,Date dob) throws Exception {
        try {
        	ConvertDate conDate	=	new ConvertDate();
            // connection
            connection = DBCP2DataSourceUtils.getConnection();
            String sql = "update tab_customer set firstName=?,lastName=?,gender=?,email=?,phone=?,address=?,dob=?"
            		+ " where id=?";
            preparedStatement = connection.prepareStatement(sql);
            // set param message
            preparedStatement.setString(1, firstName); 
            preparedStatement.setString(2, lastName); 
            preparedStatement.setString(3, gender); 
            preparedStatement.setString(4, email); 
            preparedStatement.setString(5, phone);  
            preparedStatement.setString(6, address);
            preparedStatement.setDate(7, conDate.convertUtilDateToSqlDate(dob));
            // set param id
            preparedStatement.setInt(8, id);
            int result = preparedStatement.executeUpdate();
            System.out.println("update record : " + result);
            return result;
        }
        finally {
            close();
        }
    }
    
    // SQL Select
    public Customer readDataById(Integer id) throws Exception {
        if (id == null) {
            return null;
        }
        Customer result = null;
        try {
            // get Connection from datasource
            connection = DBCP2DataSourceUtils.getConnection();
            // execute select statement
            preparedStatement = connection.prepareStatement("select * from tab_customer where id=?");
            preparedStatement.setInt(1, id);
            
            resultSet = preparedStatement.executeQuery();
            
            // get result
            if (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName	=	resultSet.getString("lastName");
                String gender	=	resultSet.getString("gender");
                String email	=	resultSet.getString("email");
                String phone	=	resultSet.getString("phone");
                String address	=	resultSet.getString("address");
                Date dob	=	resultSet.getDate("dob");
                
                //System.out.println("id:" + id + ", message:" + message);
                //add TestDomain to List
                result = new Customer(id, firstName,lastName,gender,email,phone,address,dob);
            }
            //DBCP2DataSourceUtils.printDataSourceState();
        } 
        finally {
            close();
        }
        return result;
    }
    
    // SQL Select
    
    public List<Customer> readData(int offset,int limit) throws Exception {
        final List<Customer> list = new ArrayList<Customer>();        
        try {
            // get Connection from datasource
            connection = DBCP2DataSourceUtils.getConnection();
            // create statement
            //statement = connection.createStatement();
            preparedStatement	=	connection.prepareStatement("select * from tab_customer limit ?,?");
            preparedStatement.setInt(1, offset);
            preparedStatement.setInt(2, limit);
            
            // execute select statement
            //resultSet = statement.executeQuery("select * from tab_customer");
            resultSet	=	preparedStatement.executeQuery();

            // get result
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName	=	resultSet.getString("lastName");
                String gender	=	resultSet.getString("gender");
                String email	=	resultSet.getString("email");
                String phone	=	resultSet.getString("phone");
                String address	=	resultSet.getString("address");
                Date dob	=	resultSet.getDate("dob");
                //System.out.println("id:" + id + ", message:" + message);
                //add TestDomain to List
                list.add(new Customer(id, firstName,lastName,gender,email,phone,address,dob));
            }            
            //DBCP2DataSourceUtils.printDataSourceState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            close();
        }
        return list;
    }
    

    public HashMap<String,Object> readDataLimit(int offset,int limit) throws Exception {
    	HashMap<String, Object> map	=	new HashMap<>();
        List<Customer> list = new ArrayList<Customer>();        
        try {
            // get Connection from datasource
            connection = DBCP2DataSourceUtils.getConnection();
            // create statement
            //statement = connection.createStatement();
            preparedStatement	=	connection.prepareStatement("select SQL_CALC_FOUND_ROWS * from tab_customer limit ?,?");
            preparedStatement.setInt(1, offset);
            preparedStatement.setInt(2, limit);
            
            // execute select statement
            //resultSet = statement.executeQuery("select * from tab_customer");
            resultSet	=	preparedStatement.executeQuery();

            // get result
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName	=	resultSet.getString("lastName");
                String gender	=	resultSet.getString("gender");
                String email	=	resultSet.getString("email");
                String phone	=	resultSet.getString("phone");
                String address	=	resultSet.getString("address");
                Date dob	=	resultSet.getDate("dob");                
                //System.out.println("id:" + id + ", message:" + message);
                //add TestDomain to List
                list.add(new Customer(id, firstName,lastName,gender,email,phone,address,dob));
            }
            preparedStatement=	connection.prepareStatement("SELECT FOUND_ROWS() as total");
            resultSet	=	preparedStatement.executeQuery();
            int totalRow	=	0;
            while(resultSet.next()){
            	totalRow	=	resultSet.getInt("total");
            }
            //DBCP2DataSourceUtils.printDataSourceState();
           map.put("custs", list);
           map.put("total", totalRow);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            close();
        }
        return map;
    }
 
    private void close(){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
