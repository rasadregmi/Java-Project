import java.util.*;
import java.sql.*;  
  
public class MemD {  
  
    public Connection getConnection() throws Exception{  
        Connection con=null;  
        Class.forName ("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", ""); 
        return con;  
    }  
    
    public int save(Mem m) throws Exception{  
    	int status=0;  
	    Connection con=getConnection();  
	    PreparedStatement ps=con.prepareStatement("insert into member(name,password,email,country) values (?,?,?,?)");   
	    ps.setString(1,m.getName());  
	    ps.setString(2,m.getPassword()); 
	    ps.setString(3,m.getEmail());  
	    ps.setString(4,m.getCountry());
	    status=ps.executeUpdate();  
	    con.close();  
	    return status;  
    }  
    
    public int update(Mem m) throws Exception{  
        int status=0;  
		Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("update member set name=?,password=?,email=?,country=? where id=?");  
        ps.setString(1,m.getName());  
        ps.setString(2,m.getPassword());  
        ps.setString(3,m.getEmail());  
        ps.setString(4,m.getCountry());  
        ps.setInt(5,m.getId());  
        status=ps.executeUpdate();  
        con.close();            
        return status;  
    }  
    
    public int delete(int id) throws Exception{  
        int status=0;  
		Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from member where id=?");  
        ps.setInt(1,id);  
        status=ps.executeUpdate();  
        con.close(); 
        return status;  
    }  
    
    public Mem getMemberById(int id)throws Exception{  
        Mem m=new Mem();  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from member where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        if(rs.next()){  
            m.setId(rs.getInt(1));  
            m.setName(rs.getString(2));  
            m.setPassword(rs.getString(3));  
            m.setEmail(rs.getString(4));  
            m.setCountry(rs.getString(5));  
        }  
        con.close();  
        return m;  
    }  
    
    public List<Mem> getAllMembers() throws Exception{  
        List<Mem> list=new ArrayList<Mem>();  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from member");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            Mem m=new Mem();  
            m.setId(rs.getInt(1));  
            m.setName(rs.getString(2));  
            m.setPassword(rs.getString(3));  
            m.setEmail(rs.getString(4));  
            m.setCountry(rs.getString(5));
            System.out.println("Rasad Error");
            list.add(m);  
        }  
        con.close();  
        return list;  
    }  
}  