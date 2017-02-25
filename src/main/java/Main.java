import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;



public class Main {
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:8080/testdb","root","root");
		PreparedStatement statement = con.prepareStatement("select * from name");
		ResultSet result = statement.executeQuery();
		while (result.next())
		{
			System.out.println(result.getString(1)+""+result.getString(2));
			
		}
	}

}
