package Database;
import java.sql.*;
import java.util.Scanner;

public class Database {

	private static Connection database;
	
	public Database() {
		Database.database = EstablishDatabase();
		CreateTables();
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
	
	public static void CloseDatabase() {
		try {
			database.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection EstablishDatabase() 
	{
		return EstablishDatabase("trivia.db");
	}
	
	private static void CreateShortAnswerTable() 
	{
		String sqlstatement = "CREATE TABLE IF NOT EXISTS ShortAnswer (\n"
							+ "id integer PRIMARY KEY,\n"
							+ "question TEXT NOT NULL,\n"
							+ "answer TEXT NOT NULL,\n"
							+ "used integer NOT NULL\n"
							+ ");";
		try 
		{
			Statement command = database.createStatement();
			command.execute(sqlstatement);
			System.out.println("Short answer table created.\n");
		}catch(SQLException e) 
		{
			System.out.println(e.toString());
		}
	}
	
	private static void CreateMultipleChoiceTable() 
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
			Statement command = database.createStatement();
			command.execute(sqlstatement);
			System.out.println("Multiple choice table created.\n");
		}catch(SQLException e) 
		{
			System.out.println(e.toString());
		}
	}
	
	private static void CreateTrueFalseTable() 
	{
		String sqlstatement = "CREATE TABLE IF NOT EXISTS TrueFalse (\n"
				+ "id integer PRIMARY KEY,\n"
				+ "question TEXT NOT NULL,\n"
				+ "answer TEXT NOT NULL,\n"
				+ "used integer NOT NULL\n"
				+ ");";
		try 
		{
			Statement command = database.createStatement();
			command.execute(sqlstatement);
			System.out.println("True false table created.\n");
		}catch(SQLException e) 
		{
			System.out.println(e.toString());
		}
	}
	
	private static void CreateTables() 
	{
		CreateShortAnswerTable();
		CreateMultipleChoiceTable();
		CreateTrueFalseTable();
	}
	
	public static void AddMultipleChoiceQuestion() 
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
			PreparedStatement statment = database.prepareStatement(sql);
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
	
	public static void AddTrueFalseQuestion() 
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
			PreparedStatement statment = database.prepareStatement(sql);
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
	
	public static void AddShortAnswerQuestion() 
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
			PreparedStatement statment = database.prepareStatement(sql);
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
	
	public static void UpdateMultipleChoiceQuestion() 
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
			PreparedStatement statment = database.prepareStatement(sql);
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
	
	public static void UpdateTrueFalseQuestion() 
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
			PreparedStatement statment = database.prepareStatement(sql);
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
	
	public static void UpdateShortAnswerQuestion() 
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
			PreparedStatement statment = database.prepareStatement(sql);
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
	
	public static void DeleteMultipleChoiceQuestion() 
	{
		Scanner kb = new Scanner(System.in);
		String id;
		System.out.println("Please enter the id number for the multiple choice question to be deleted.\n");
		id = kb.nextLine();
		String sql = "DELETE FROM MultipleChoice WHERE id = ?";
		try 
		{
			PreparedStatement statment = database.prepareStatement(sql);
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
	
	public static void DeleteTrueFalseQuestion() 
	{
		Scanner kb = new Scanner(System.in);
		String id;
		System.out.println("Please enter the id number for the true-false question to be deleted.\n");
		id = kb.nextLine();
		String sql = "DELETE FROM TrueFalse WHERE id = ?";
		try 
		{
			PreparedStatement statment = database.prepareStatement(sql);
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
	
	public static void DeleteShortAnswerQuestion() 
	{
		Scanner kb = new Scanner(System.in);
		String id;
		System.out.println("Please enter the id number for the short answer question to be deleted.\n");
		id = kb.nextLine();
		String sql = "DELETE FROM ShortAnswer WHERE id = ?";
		try 
		{
			PreparedStatement statment = database.prepareStatement(sql);
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
	
	public static void PrintAllMultipleChoiceQuestions()
	{
		String sql = "SELECT id, question, firstanswer, secondanswer, thirdanswer, fourthanswer, correctanswer, used FROM MultipleChoice";
		try 
		{
			Statement statment = database.createStatement();
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
	
	public static void PrintAllTrueFalseQuestions()
	{
		String sql = "SELECT id, question, answer, used FROM TrueFalse";
		try 
		{
			Statement statment = database.createStatement();
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
	
	public static void PrintAllShortAnswerQuestions()
	{
		String sql = "SELECT id, question, answer, used FROM ShortAnswer";
		try 
		{
			Statement statment = database.createStatement();
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
	
	public static void PrintAllQuestions() {
		PrintAllMultipleChoiceQuestions();
		PrintAllTrueFalseQuestions();
		PrintAllShortAnswerQuestions();
	}
	
	public static Question GetMultipleChoiceQuestion()
	{
		String sql = "SELECT id, question, firstanswer, secondanswer, thirdanswer, fourthanswer, correctanswer, used FROM MultipleChoice WHERE used = 0 order by RANDOM() LIMIT 1";
		Question question = null;
		try 
		{
			PreparedStatement sqlstatment = database.prepareStatement("SELECT count(id) from MultipleChoice WHERE used = 0");
			ResultSet result = sqlstatment.executeQuery();
			int count = result.getInt(1);
			if(count == 0) return null;
			Statement statment = database.createStatement();
			result = statment.executeQuery(sql);
			question = new Question("multiple", result.getString("question"), result.getString("firstanswer"), result.getString("secondanswer"), result.getString("thirdanswer"), result.getString("fourthanswer"), result.getString("correctanswer"));
			int id = result.getInt("id");
			sql = "UPDATE MultipleChoice SET used = ? WHERE id = ?";
			sqlstatment = database.prepareStatement(sql);
			sqlstatment.setInt(1, 1);
			sqlstatment.setInt(2, id);
			sqlstatment.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}
		return question;
	}
	
	public static Question GetTrueFalseQuestion()
	{
		String sql = "SELECT id, question, answer, used FROM TrueFalse order by RANDOM() LIMIT 1";
		Question question = null;
		try 
		{
			PreparedStatement sqlstatment = database.prepareStatement("SELECT count(id) from TrueFalse WHERE used = 0");
			ResultSet result = sqlstatment.executeQuery();
			int count = result.getInt(1);
			if(count == 0) return null;
			Statement statment = database.createStatement();
			result = statment.executeQuery(sql);
			question = new Question("trueFalse", result.getString("question"), "null", "null", "null", "null", result.getString("answer"));
			int id = result.getInt("id");
			sql = "UPDATE TrueFalse SET used = ? WHERE id = ?";
			sqlstatment = database.prepareStatement(sql);
			sqlstatment.setInt(1, 1);
			sqlstatment.setInt(2, id);
			sqlstatment.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e.toString());
		}
		return question;
	}
	
	public static Question GetShortAnswerQuestion() 
	{
		String sql = "SELECT id, question, answer, used FROM ShortAnswer order by RANDOM() LIMIT 1";
		Question question = null;
		try 
		{
			PreparedStatement sqlstatment = database.prepareStatement("SELECT count(id) from ShortAnswer WHERE used = 0");
			ResultSet result = sqlstatment.executeQuery();
			int count = result.getInt(1);
			if(count == 0) return null;
			Statement statment = database.createStatement();
			result = statment.executeQuery(sql);
			question = new Question("short", result.getString("question"), "null", "null", "null", "null", result.getString("answer"));
			int id = result.getInt("id");
			sql = "UPDATE ShortAnswer SET used = ? WHERE id = ?";
			sqlstatment = database.prepareStatement(sql);
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
		if(question != null)
		{
		System.out.println(question.GetType() + "-" + question.GetQuestion() + "-" + question.GetFirst() + "-" + question.GetSecond() + "-" + question.GetThird() + "-" + question.GetFourth() + "-" + question.GetCorrect() + "\n");
		}
	}
	
	public static void ResetUsedVariable() 
	{
		String sql, sqlcomm;
		sql = "SELECT id, used FROM MultipleChoice";
		sqlcomm = "UPDATE MultipleChoice SET used = ? WHERE id = ?";
		Reset(sql, sqlcomm);
		sql = "SELECT id, used FROM TrueFalse";
		sqlcomm = "UPDATE TrueFalse SET used = ? WHERE id = ?";
		Reset(sql, sqlcomm);
		sql = "SELECT id, used FROM ShortAnswer";
		sqlcomm = "UPDATE ShortAnswer SET used = ? WHERE id = ?";
		Reset(sql, sqlcomm);
	}
	
	private static void Reset(String sql, String sqlcomm)
	{
		try 
		{
			Statement statment = database.createStatement();
			PreparedStatement sqlstatment;
			ResultSet result = statment.executeQuery(sql);
				while(result.next())
				{
					sqlstatment = database.prepareStatement(sqlcomm);
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
