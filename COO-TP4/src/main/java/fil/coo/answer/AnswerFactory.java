package fil.coo.answer;
import java.lang.reflect.Constructor;

public class AnswerFactory {
	public static final AnswerFactory FACTORY = new AnswerFactory();
	public AnswerFactory(){
		
	}
	
	public Answer<?> buildAnswer(String s) throws Exception{
		s = s.substring(1, s.length());
		String[] array = s.split("\\)");
		String type = array[0];
		String answer = array[1];
		Class<?> c = (Class<?>) Class.forName("fil.coo.answer."+type);
		Constructor<?> constructor = c.getConstructor(String.class);
		Answer<?> ans = (Answer<?>) constructor.newInstance(answer);
		return ans;
		
	}
}
