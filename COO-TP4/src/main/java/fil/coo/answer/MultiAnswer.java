package fil.coo.answer;

import java.util.Arrays;
import java.util.List;
import fil.coo.ihm.AnswerPanel;
import fil.coo.ihm.StringAnswerPanel;
/**
 * Multichoice Class
 */
public class MultiAnswer extends Answer<List<String>> {
	 
	 public MultiAnswer(List<String> answerList) {
	        this.trueanswer = answerList;
	 }
	 
	 public MultiAnswer(String answerText) {
	      String[] tab = answerText.split(";");
	      this.trueanswer = Arrays.asList(tab);
	    }
	@Override
	public String getType() {
		return "String choix multiple";
	}

	@Override
	public boolean isAccepted(String ans) {
		return ans.getClass().equals(String.class);
	}

	@Override
	public boolean isCorrect(String ans) {
		return (this.trueanswer).contains(ans);
	}
	
	 @Override
	    public AnswerPanel createMyAnswerPanel() {
	        return new StringAnswerPanel(this);
	    }

}
