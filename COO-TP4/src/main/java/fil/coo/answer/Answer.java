package fil.coo.answer;

import fil.coo.ihm.AnswerPanel;

/**
 * @author pelage
 *
 * @param <T>
 */
public abstract class Answer<T> {

	protected T trueanswer;
	
	
	/**
	 * @return the correct answer
	 */
	public T getCorrectAnswer(){
		return this.trueanswer;
	}
	
	/**
	 * @return the type of the answer
	 */
	public abstract String getType();
	/**
	 * @param ans
	 * @return if the answer have the good type
	 */
	public abstract boolean isAccepted(String ans);
	
	/**
	 * @param ans
	 * @return if the answer is the correct answer
	 */
	public abstract boolean isCorrect(String ans);
	public abstract AnswerPanel createMyAnswerPanel();

	
}
