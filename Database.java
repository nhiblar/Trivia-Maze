import java.sql.*;

public class Database {

	public static void main(String[] args) {
		Connection database = EstablishDatabase();
		CreateTables(database);
		
		try {
			database.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	private static Connection EstablishDatabase(String filename) {
		Connection con = null;
		String file = "jdbc:sqlite:" + filename;
		try 
		{
			con = DriverManager.getConnection(file);
			System.out.println("Connected to database file: " + filename + "\n");
		}catch(SQLException e) 
		{
			System.out.println(e.toString());
			try {
				con = DriverManager.getConnection((file));
				if(con != null) 
				{
					DatabaseMetaData data = con.getMetaData();
					System.out.println("The database has been created under filename: " + filename + "\n");
				}
			}catch(SQLException f) {
				System.out.println(f.toString());
			}
		}
		
		return con;
	}
	
	private static Connection EstablishDatabase() {
		return EstablishDatabase("trivia.db");
	}
	
	private static void CreateShortAnswerTable(Connection con) 
	{
		String sqlstatement = "CREATE TABLE IF NOT EXISTS ShortAnswer (\n"
							+ "id integer PRIMARY KEY,\n"
							+ "question TEXT NOT NULL,\n"
							+ "answer TEXT NOT NULL\n"
							+ ");";
		try 
		{
			Statement command = con.createStatement();
			command.execute(sqlstatement);
			System.out.println("Short answer table created.\n");
		}catch(SQLException e) 
		{
			System.out.println(e.toString());
		}
	}
	
	private static void CreateMultipleChoiceTable(Connection con) 
	{
		String sqlstatement = "CREATE TABLE IF NOT EXISTS MultipleChoice (\n"
				+ "id integer PRIMARY KEY,\n"
				+ "question TEXT NOT NULL,\n"
				+ "firstanswer TEXT NOT NULL,\n"
				+ "secondanswer TEXT NOT NULL,\n"
				+ "thirdanswer TEXT NOT NULL,\n"
				+ "fourthanswer TEXT NOT NULL\n"
				+ ");";
		try 
		{
			Statement command = con.createStatement();
			command.execute(sqlstatement);
			System.out.println("Multiple choice table created.\n");
		}catch(SQLException e) 
		{
			System.out.println(e.toString());
		}
	}
	
	private static void CreateTrueFalseTable(Connection con) 
	{
		String sqlstatement = "CREATE TABLE IF NOT EXISTS TrueFalse (\n"
				+ "id integer PRIMARY KEY,\n"
				+ "question TEXT NOT NULL,\n"
				+ "answer TEXT NOT NULL\n"
				+ ");";
		try 
		{
			Statement command = con.createStatement();
			command.execute(sqlstatement);
			System.out.println("True false table created.\n");
		}catch(SQLException e) 
		{
			System.out.println(e.toString());
		}
	}
	
	private static void CreateTables(Connection con) 
	{
		CreateShortAnswerTable(con);
		CreateMultipleChoiceTable(con);
		CreateTrueFalseTable(con);
	}
}
