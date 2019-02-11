package fil.coo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fil.coo.util.Input;

/**
 * @author pelage
 *Questionnary Class
 */
public class Questionnary {
	private List <Question> allQuestion;
	int score;
	/**
	 * Create a questionnary
	 */
	public Questionnary (){
		this.allQuestion = new ArrayList<Question>();
		this.score=0;
	}
	
	/**
	 * add a quesiton in the list of question
	 * @param q a question
	 */
	public void addQuestion(Question q){
		this.allQuestion.add(q);
	}
	/**
	 * return the list of all the question	
	 */
	public List<Question> getQuestion(){
		return this.allQuestion;
	}
	
	/**
	 * display the questionnary and ask to the user
	 */
	public void askAll(){
        for (Question question : this.allQuestion) {
            System.out.println("-----------------------------------------");
            System.out.println(question.getQuestion());
            boolean valid = false;
            String answer = null;
            while (!valid) {
                try {
                    System.out.println("Quelle est votre reponse (" + question.getAnswerType() + ") ? ");
                    answer = Input.readLine();
                    valid = question.accept(answer);
                }
                catch (IOException e) {
                    answer = "";
                    valid = false;
                }
            }
            question.setUserAnswer(answer);
            if (question.isCorrectAnswer(question.getUserAnswer())) {
                System.out.println("correct, (" + question.getPoints() + " point(s))");
                this.score += question.getPoints();
                continue;
            }
            System.out.println("incorrect, la bonne reponse etait " + question.getGoodAnswer());
        }
        System.out.println("Vous avez obtenu " + this.score + " point(s)");
	}
}
