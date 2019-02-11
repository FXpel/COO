package fil.coo.answer;

import fil.coo.ihm.AnswerPanel;
import fil.coo.ihm.IntegerAnswerPanel;

public class IntegerAnswer extends Answer<Integer> {
	public IntegerAnswer(String i){
		 this.trueanswer = Integer.parseInt(i);
	}
	public IntegerAnswer(int i){
		this.trueanswer = i;
	}
	
	public String getType() {
		return "La réponse est un entier";
	}
	@Override
	public boolean isAccepted(String ans) {
		try {
			Integer.parseInt(ans);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	@Override
	public boolean isCorrect(String ans) {
		return Integer.parseInt(ans) == this.trueanswer;
	}
	
	@Override
    public AnswerPanel createMyAnswerPanel() {
        return new IntegerAnswerPanel(this);
    }

}
