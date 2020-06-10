//package Database;
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class DatabaseTest {
//	
//	@BeforeEach
//	void setUp() throws Exception 
//	{
//		new Database();
//		Database.ResetUsedVariable();
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//		Database.CloseDatabase();
//	}
//
//	@Test
//	void test() {
//		Question question = Database.GetMultipleChoiceQuestion();
//		assertNotEquals(question, null);
//	}
//
//}
