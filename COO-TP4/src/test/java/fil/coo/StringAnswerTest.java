package fil.coo;

import fil.coo.answer.StringAnswer;
import junit.framework.TestCase;

public class StringAnswerTest extends AnswerTest {
	public StringAnswer CreateAnswer(){
		return new StringAnswer ("text") ;
}
}
