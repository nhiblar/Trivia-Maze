/*This file is a JUnit test file designed to test the methods of the Database.java file.
 * WARNING - Running this test file will reset the database to a pre-game state. Do so knowing that any currently running, or saved games could be affected.
 * Additionally some test functions have been disabled due to the potential to effect the integrity of the trivia.db database file.
 * Please only re-enable these functions if you intend to use them (and the functions they test) properly, so as to not harm the database.
 */

package Database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DatabaseJUnitTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		new Database();
		Database.ResetUsedVariable();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		Database.ResetUsedVariable();
		Database.CloseDatabase();
	}

	/*
	@Test
	void testAddMultipleChoiceQuestion() {
		assertTrue(Database.AddMultipleChoiceQuestion());
	}
	*/
	
	/*
	@Test
	void testAddtrueFalseQuestion() {
		assertTrue(Database.AddtrueFalseQuestion());
	}
	*/
	
	/*
	@Test
	void testAddShortAnswerQuestion() {
		assertTrue(Database.AddShortAnswerQuestion());
	}
	*/
	
	/*
	@Test
	void testUpdateMultipleChoiceQuestion() {
		assertTrue(Database.UpdateMultipleChoiceQuestion());
	}
	*/
	
	/*
	@Test
	void testUpdateTrueFalseQuestion() {
		assertTrue(Database.UpdateTrueFalseQuestion());
	}
	*/
	
	/*
	@Test
	void testUpdateShortAnswerQuestion() {
		assertTrue(Database.UpdateShortAnswerQuestion());
	}
	*/
	
	/*
	@Test
	void testDeleteMultipleChoiceQuestion() {
		assertTrue(Database.DeleteMultipleChoiceQuestion());
	}
	*/
	
	/*
	@Test
	void testDeleteTrueFalseQuestion() {
		assertTrue(Database.DeleteTrueFalseQuestion());
	}
	*/
	
	/*
	@Test
	void testDeleteShortAnswerQuestion() {
		assertTrue(Database.DeleteShortAnswerQuestion());
	}
	*/
	
	@Test
	void testPrintAllMultipleChoiceQuestions() {
		assertTrue(Database.PrintAllMultipleChoiceQuestions());
	}
	
	@Test
	void testPrintAllTrueFalseQuestions() {
		assertTrue(Database.PrintAllTrueFalseQuestions());
	}
	
	@Test
	void testPrintAllShortAnswerQuestions() {
		assertTrue(Database.PrintAllShortAnswerQuestions());
	}
	
	@Test
	void testPrintAllQuestions() {
		assertTrue(Database.PrintAllQuestions());
	}
	
	@Test
	void testGetMultipleChoiceQuestion() {
		Question question = Database.GetMultipleChoiceQuestion();
		assertNotEquals(question, null);
	}

	@Test
	void testGetTrueFalseQuestion() {
		Question question = Database.GetTrueFalseQuestion();
		assertNotEquals(question, null);
	}
	
	@Test
	void testGetShortAnswerQuestion() {
		Question question = Database.GetShortAnswerQuestion();
		assertNotEquals(question, null);
	}
	
	@Test
	void testGetQuestion() {
		Question question = Database.GetQuestion();
		assertNotEquals(question, null);
	}
	
	@Test
	void testResetUsedVariable() {
		assertTrue(Database.ResetUsedVariable());
	}
}
