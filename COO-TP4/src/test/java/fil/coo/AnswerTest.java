package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.answer.Answer;

public abstract class AnswerTest {

	public abstract Answer<?> CreateAnswer();

	@Test
	public void testIsAccepted() {
		Answer<?> reponse = this.CreateAnswer();
		assertTrue(reponse.isAccepted(reponse.getCorrectAnswer().toString()));
	}
	@Test
	public void testIsCorrect() {
		Answer<?> answer =this.CreateAnswer();
		assertTrue(answer.isCorrect(answer.getCorrectAnswer().toString()));
	}


}
