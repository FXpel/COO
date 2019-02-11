package fil.coo;
import fil.coo.answer.Answer;


/**
 * @author pelage & Karti
 * 
 * @param <T>
 */
public class Question<T> {
	protected String question;
	protected int points;
	protected Answer<T> answer;
	protected String userAnswer;
	
	
	/**
	 * Create a question
	 * @param q a question
	 * @param ans an answer
	 * @param number of point
	 */
	public Question(String q, Answer<T> ans,int points){
		this.question = q;
		this.answer = ans;
		this.points = points;
	}
	
	
	/**
	 * return the correct answer of the question
	 * @return the good answer
	 */
	public T getGoodAnswer(){
		return this.answer.getCorrectAnswer();
	}
	public Answer<?> getAnswer() {
        return this.answer;
    }
	/**
	 * the description of the question
	 * @return description of the question
	 */
	public String getAnswerType(){
		return this.answer.getType();
	}
	/**
	 * verify if the type of answer is  acceptable by the question
	 * @param a user answer
	 * @return a boolean if the type of answer is good or not
	 */
	public boolean accept(String ans){
		return answer.isAccepted(ans);
	}
	/**
	 * verify if the Answer is correct 
	 * @param a user answer
	 * @return a boolean if the answer is true or false
	 */
	public boolean isCorrectAnswer(String ans){
		return answer.isCorrect(ans);
	}
	/**
	 * the number of points that give a question
	 * @return the number of pointof a question
	 */
	public int getPoints(){
		return this.points;
	}
	/**
	 * the answer of the user
	 * @return the user answer
	 */
    public String getUserAnswer() {
        return this.userAnswer;
    }
    /**
	 * set the answer of the user
	 * 
	 */
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
    
    /**
     * The question
     * return the question
     */
    public String getQuestion() {
    	return this.question;
    }

}
