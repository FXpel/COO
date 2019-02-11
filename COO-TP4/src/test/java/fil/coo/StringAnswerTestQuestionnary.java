package fil.coo;

import fil.coo.answer.StringAnswer;
import junit.framework.TestCase;

public class StringAnswerTestQuestionnary extends QuestionnaryTest {
	public StringAnswer CreateAnswer(){
		return new StringAnswer ("text") ;
}
}
