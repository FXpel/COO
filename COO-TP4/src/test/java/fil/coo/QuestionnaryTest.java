package fil.coo;

import java.awt.List;

import junit.framework.TestCase;
import fil.coo.Questionnary;
import fil.coo.answer.Answer;
import fil.coo.answer.BooleanAnswer;
import fil.coo.answer.IntegerAnswer;
import fil.coo.answer.StringAnswer;
import fil.coo.Question;
public abstract class QuestionnaryTest extends AnswerTest{

	public void testQuestionnary() {

	}

	public void testAddQuestion() {
		Questionnary q = new Questionnary();
		
		Answer<?> reponse = this.CreateAnswer();
		Question<?> question = new Question(reponse.getCorrectAnswer().toString(),reponse,1);
		q.addQuestion(question);
	}

	public abstract Answer<?> CreateAnswer();


}
