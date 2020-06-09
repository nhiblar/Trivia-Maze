import java.sql.*;
import java.util.Scanner;

public class Database {

	public static void main(String[] args) 
	{
		Connection database = EstablishDatabase();
		CreateTables(database);
		//AddMultipleChoiceQuestion(database);
		//AddTrueFalseQuestion(database);
		//AddShortAnswerQuestion(database);
		//UpdateMultipleChoiceQuestion(database);
		//UpdateTrueFalseQuestion(database);
		//UpdateShortAnswerQuestion(database);
		//DeleteMultipleChoiceQuestion(database);
		//DeleteTrueFalseQuestion(database);
		//DeleteShortAnswerQuestion(database);
		//PrintAllMultipleChoiceQuestions(database);
		//PrintAllTrueFalseQuestions(database);
		//PrintAllShortAnswerQuestions(database);
		//PrintAllQuestions(database);
		ResetUsedVariable(database);
		//PrintQuestionVariables(GetMultipleChoiceQuestion(database));
		//PrintQuestionVariables(GetMultipleChoiceQuestion(database));
		//PrintQuestionVariables(GetTrueFalseQuestion(database));
		//PrintQuestionVariables(GetShortAnswerQuestion(database));
		
		try {
			database.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	private static Connection EstablishDatabase(String filename) 
	{
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
	
	private static Connection EstablishDatabase() 
	{
		return EstablishDatabase("trivia.db");
	}
	
	private static void CreateShortAnswerTable(Connection con) 
	{
		String sqlstatement = "CREATE TABLE IF NOT EXISTS ShortAnswer (\n"
							+ "id integer PRIMARY KEY,\n"
							+ "question TEXT NOT NULL,\n"
							+ "answer TEXT NOT NULL,\n"
							+ "used integer NOT NULL\n"
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
				+ "fourthanswer TEXT NOT NULL,\n"
				+ "correctanswer TEXT NOT NULL,\n"
				+ "used integer NOT NULL\n"
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
				+ "answer TEXT NOT NULL,\n"
				+ "used integer NOT NULL\n"
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
	
	public static void AddMultipleChoiceQuestion(Connection con) 
	{
		Scanner kb = new Scanner(System.in);
		String question, first, second, third, fourth, correct;
		System.out.println("Please enter the multiple choice question.\n");
		question = kb.nextLine();
		System.out.println("Please enter the four answer options, pressing enter inbetween each option.\n");
		first = kb.nextLine();
		second = kb.nextLine();
		third = kb.nextLine();
		fourth = kb.nextLine();
		System.out.println("Please enter the correct answer.\n");
		correct = kb.nextLine();
		String sql = "INSERT INTO MultipleChoice(question,firstanswer,secondanswer,thirdanswer,fourthanswer,correctanswer,used) VALUES(?,?,?,?,?,?,?)";
		try 
		{
			PreparedStatement statment = con.prepareStatement(sql);
			statment.setString(1, question);
			statment.setString(2, first);
			statment.setString(3, second);
			statment.setString(4, third);
			statment.setString(5, fourth);
			statment.setString(6, correct);
			statment.setInt(7, 0);
			statment.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}finally
		{
			kb.close();
		}
	}
	
	public static void AddTrueFalseQuestion(Connection con) 
	{
		Scanner kb = new Scanner(System.in);
		String question, answer;
		System.out.println("Please enter the true-false question.\n");
		question = kb.nextLine();
		System.out.println("Please enter the answer.\n");
		answer = kb.nextLine();
		String sql = "INSERT INTO TrueFalse(question,answer,used) VALUES(?,?,?)";
		try 
		{
			PreparedStatement statment = con.prepareStatement(sql);
			statment.setString(1, question);
			statment.setString(2, answer);
			statment.setInt(3, 0);
			statment.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}finally
		{
			kb.close();
		}
	}
	
	public static void AddShortAnswerQuestion(Connection con) 
	{
		Scanner kb = new Scanner(System.in);
		String question, answer;
		System.out.println("Please enter the short answer question.\n");
		question = kb.nextLine();
		System.out.println("Please enter the answer.\n");
		answer = kb.nextLine();
		String sql = "INSERT INTO ShortAnswer(question,answer,used) VALUES(?,?,?)";
		try 
		{
			PreparedStatement statment = con.prepareStatement(sql);
			statment.setString(1, question);
			statment.setString(2, answer);
			statment.setInt(3, 0);
			statment.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}finally
		{
			kb.close();
		}
	}
	
	public static void UpdateMultipleChoiceQuestion(Connection con) 
	{
		Scanner kb = new Scanner(System.in);
		String id, question, first, second, third, fourth, correct;
		System.out.println("Please enter the question id number.\n");
		id = kb.nextLine();
		System.out.println("Please enter the updated multiple choice question.\n");
		question = kb.nextLine();
		System.out.println("Please enter the four updated answer options, pressing enter in-between each option.\n");
		first = kb.nextLine();
		second = kb.nextLine();
		third = kb.nextLine();
		fourth = kb.nextLine();
		System.out.println("Please enter the updated correct answer.\n");
		correct = kb.nextLine();
		String sql = "UPDATE MultipleChoice SET question = ? , firstanswer = ? , secondanswer = ? , thirdanswer = ? , "
				+ "fourthanswer = ? , correctanswer = ? WHERE id = ?";
		try 
		{
			PreparedStatement statment = con.prepareStatement(sql);
			statment.setString(1, question);
			statment.setString(2, first);
			statment.setString(3, second);
			statment.setString(4, third);
			statment.setString(5, fourth);
			statment.setString(6, correct);
			statment.setInt(7, Integer.parseInt(id));
			statment.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}finally
		{
			kb.close();
		}
	}
	
	public static void UpdateTrueFalseQuestion(Connection con) 
	{
		Scanner kb = new Scanner(System.in);
		String id, question, answer;
		System.out.println("Please enter the question id number.\n");
		id = kb.nextLine();
		System.out.println("Please enter the updated true-false question.\n");
		question = kb.nextLine();
		System.out.println("Please enter the updated answer.\n");
		answer = kb.nextLine();
		String sql = "UPDATE TrueFalse SET question = ? , answer = ? WHERE id = ?";
		try 
		{
			PreparedStatement statment = con.prepareStatement(sql);
			statment.setString(1, question);
			statment.setString(2, answer);
			statment.setInt(3, Integer.parseInt(id));
			statment.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}finally
		{
			kb.close();
		}
	}
	
	public static void UpdateShortAnswerQuestion(Connection con) 
	{
		Scanner kb = new Scanner(System.in);
		String id, question, answer;
		System.out.println("Please enter the question id number.\n");
		id = kb.nextLine();
		System.out.println("Please enter the updated short answer question.\n");
		question = kb.nextLine();
		System.out.println("Please enter the updated answer.\n");
		answer = kb.nextLine();
		String sql = "UPDATE ShortAnswer SET question = ? , answer = ? WHERE id = ?";
		try 
		{
			PreparedStatement statment = con.prepareStatement(sql);
			statment.setString(1, question);
			statment.setString(2, answer);
			statment.setInt(3, Integer.parseInt(id));
			statment.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}finally
		{
			kb.close();
		}
	}
	
	public static void DeleteMultipleChoiceQuestion(Connection con) 
	{
		Scanner kb = new Scanner(System.in);
		String id;
		System.out.println("Please enter the id number for the multiple choice question to be deleted.\n");
		id = kb.nextLine();
		String sql = "DELETE FROM MultipleChoice WHERE id = ?";
		try 
		{
			PreparedStatement statment = con.prepareStatement(sql);
			statment.setInt(1, Integer.parseInt(id));
			statment.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}finally
		{
			kb.close();
		}
	}
	
	public static void DeleteTrueFalseQuestion(Connection con) 
	{
		Scanner kb = new Scanner(System.in);
		String id;
		System.out.println("Please enter the id number for the true-false question to be deleted.\n");
		id = kb.nextLine();
		String sql = "DELETE FROM TrueFalse WHERE id = ?";
		try 
		{
			PreparedStatement statment = con.prepareStatement(sql);
			statment.setInt(1, Integer.parseInt(id));
			statment.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}finally
		{
			kb.close();
		}
	}
	
	public static void DeleteShortAnswerQuestion(Connection con) 
	{
		Scanner kb = new Scanner(System.in);
		String id;
		System.out.println("Please enter the id number for the short answer question to be deleted.\n");
		id = kb.nextLine();
		String sql = "DELETE FROM ShortAnswer WHERE id = ?";
		try 
		{
			PreparedStatement statment = con.prepareStatement(sql);
			statment.setInt(1, Integer.parseInt(id));
			statment.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}finally
		{
			kb.close();
		}
	}
	
	public static void PrintAllMultipleChoiceQuestions(Connection con)
	{
		String sql = "SELECT id, question, firstanswer, secondanswer, thirdanswer, fourthanswer, correctanswer, used FROM MultipleChoice";
		try 
		{
			Statement statment = con.createStatement();
			ResultSet result = statment.executeQuery(sql);
				while(result.next())
				{
					System.out.println("MultipleChoice: " + result.getInt("id") + " - " + result.getString("question") + " - " 
					+ result.getString("firstanswer") + " - " + result.getString("secondanswer") + " - " 
					+ result.getString("thirdanswer") + " - " + result.getString("fourthanswer") + " - " 
					+ result.getString("correctanswer") + " - " + result.getInt("used") + "\n");
				}
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}
	}
	
	public static void PrintAllTrueFalseQuestions(Connection con)
	{
		String sql = "SELECT id, question, answer, used FROM TrueFalse";
		try 
		{
			Statement statment = con.createStatement();
			ResultSet result = statment.executeQuery(sql);
				while(result.next())
				{
					System.out.println("True-false: " + result.getInt("id") + " - " + result.getString("question") + " - " 
					+ result.getString("answer") + "\n");
				}
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}
	}
	
	public static void PrintAllShortAnswerQuestions(Connection con)
	{
		String sql = "SELECT id, question, answer, used FROM ShortAnswer";
		try 
		{
			Statement statment = con.createStatement();
			ResultSet result = statment.executeQuery(sql);
				while(result.next())
				{
					System.out.println("Short Answer: " + result.getInt("id") + " - " + result.getString("question") + " - " 
					+ result.getString("answer") + "\n");
				}
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}
	}
	
	public static void PrintAllQuestions(Connection con) {
		PrintAllMultipleChoiceQuestions(con);
		PrintAllTrueFalseQuestions(con);
		PrintAllShortAnswerQuestions(con);
	}
	
	public static Question GetMultipleChoiceQuestion(Connection con) 
	{
		String sql = "SELECT id, question, firstanswer, secondanswer, thirdanswer, fourthanswer, correctanswer, used FROM MultipleChoice order by RANDOM() LIMIT 1";
		Question question = null;
		try 
		{
			Statement statment = con.createStatement();
			ResultSet result = statment.executeQuery(sql);
			while(result.getInt("used") == 1) {
				GetShortAnswerQuestion(con);
			}
			question = new Question("multiple", result.getString("question"), result.getString("firstanswer"), result.getString("secondanswer"), result.getString("thirdanswer"), result.getString("fourthanswer"), result.getString("correctanswer"));
			int id = result.getInt("id");
			sql = "UPDATE MultipleChoice SET used = ? WHERE id = ?";
			PreparedStatement sqlstatment = con.prepareStatement(sql);
			sqlstatment.setInt(1, 1);
			sqlstatment.setInt(2, id);
			sqlstatment.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}
		return question;
	}
	
	public static Question GetTrueFalseQuestion(Connection con) 
	{
		String sql = "SELECT id, question, answer, used FROM TrueFalse order by RANDOM() LIMIT 1";
		Question question = null;
		try 
		{
			Statement statment = con.createStatement();
			ResultSet result = statment.executeQuery(sql);
			while(result.getInt("used") == 1) {
				GetTrueFalseQuestion(con);
			}
			question = new Question("trueFalse", result.getString("question"), "null", "null", "null", "null", result.getString("answer"));
			int id = result.getInt("id");
			sql = "UPDATE TrueFalse SET used = ? WHERE id = ?";
			PreparedStatement sqlstatment = con.prepareStatement(sql);
			sqlstatment.setInt(1, 1);
			sqlstatment.setInt(2, id);
			sqlstatment.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}
		return question;
	}
	
	public static Question GetShortAnswerQuestion(Connection con) 
	{
		String sql = "SELECT id, question, answer, used FROM ShortAnswer order by RANDOM() LIMIT 1";
		Question question = null;
		try 
		{
			Statement statment = con.createStatement();
			ResultSet result = statment.executeQuery(sql);
			while(result.getInt("used") == 1) {
				GetShortAnswerQuestion(con);
			}
			question = new Question("short", result.getString("question"), "null", "null", "null", "null", result.getString("answer"));
			int id = result.getInt("id");
			sql = "UPDATE ShortAnswer SET used = ? WHERE id = ?";
			PreparedStatement sqlstatment = con.prepareStatement(sql);
			sqlstatment.setInt(1, 1);
			sqlstatment.setInt(2, id);
			sqlstatment.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}
		return question;
	}
	
	public static void PrintQuestionVariables(Question question)
	{
		System.out.println(question.GetType() + "-" + question.GetQuestion() + "-" + question.GetFirst() + "-" + question.GetSecond() + "-" + question.GetThird() + "-" + question.GetFourth() + "-" + question.GetCorrect() + "\n");
	}
	
	public static void ResetUsedVariable(Connection con) 
	{
		String sql, sqlcomm;
		sql = "SELECT id, used FROM MultipleChoice";
		sqlcomm = "UPDATE MultipleChoice SET used = ? WHERE id = ?";
		Reset(con, sql, sqlcomm);
		sql = "SELECT id, used FROM TrueFalse";
		sqlcomm = "UPDATE TrueFalse SET used = ? WHERE id = ?";
		Reset(con, sql, sqlcomm);
		sql = "SELECT id, used FROM ShortAnswer";
		sqlcomm = "UPDATE ShortAnswer SET used = ? WHERE id = ?";
		Reset(con, sql, sqlcomm);
	}
	
	private static void Reset(Connection con, String sql, String sqlcomm)
	{
		try 
		{
			Statement statment = con.createStatement();
			PreparedStatement sqlstatment;
			ResultSet result = statment.executeQuery(sql);
				while(result.next())
				{
					sqlstatment = con.prepareStatement(sqlcomm);
					sqlstatment.setInt(1, 0);
					sqlstatment.setInt(2, result.getInt("id"));
					sqlstatment.executeUpdate();
				}
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}
	}
}
