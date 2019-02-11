package fil.coo.answer;

import fil.coo.ihm.AnswerPanel;
import fil.coo.ihm.StringAnswerPanel;

public class StringAnswer extends Answer<String> {
	
	public StringAnswer(String s){
		this.trueanswer = s;
	}
	public String getType() {
		return "La réponse est une chaine de caractère";
	}
	@Override
	public boolean isAccepted(String ans) {
		return ans.getClass().equals(String.class);
	}
	@Override
	public boolean isCorrect(String ans) {
	return this.trueanswer.toUpperCase().equals(ans.toUpperCase());
	}
	
	@Override
    public AnswerPanel createMyAnswerPanel() {
        return new StringAnswerPanel(this);
    }

	
}
