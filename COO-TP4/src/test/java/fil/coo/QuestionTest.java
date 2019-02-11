package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.answer.Answer;
import fil.coo.answer.BooleanAnswer;
import fil.coo.answer.IntegerAnswer;
import fil.coo.answer.StringAnswer;
import junit.framework.TestCase;

public abstract class QuestionTest extends AnswerTest{

	@Test
	public void testaccept() {
		Answer<?> reponse = this.CreateAnswer();
		Question<?> question = new Question(reponse.getCorrectAnswer().toString(),reponse,1);
		assertTrue(question.accept(reponse.getCorrectAnswer().toString()));
		

	}
	
	@Test
	public void testIsCorrect() {
		Answer<?> reponse = this.CreateAnswer();
		Question<?> question = new Question(reponse.getCorrectAnswer().toString(),reponse,1);
		assertTrue(question.isCorrectAnswer(reponse.getCorrectAnswer().toString()));
	}

	public abstract Answer<?> CreateAnswer();


}
