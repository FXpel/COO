package fil.coo.answer;

import fil.coo.ihm.AnswerPanel;
import fil.coo.ihm.BooleanAnswerPanel;

/**
 * @author pelage
 * @param <T>
 * 
 *
 */
public  class BooleanAnswer extends Answer<Boolean>{
	/**
	 * @param s 
	 * 
	 */
	
	public BooleanAnswer(String s){
		if (s.equals("oui")){
			this.trueanswer = true;
		}
		else{
			this.trueanswer = false;
		}
	}
	
	public String getType() {
		return "La réponse est soit oui soit non";
	}
	@Override
	public boolean isAccepted(String ans) {
		return ans.equals("oui")||ans.equals("non")||Boolean.parseBoolean(ans) == true||Boolean.parseBoolean(ans) == false;
	}
	
	@Override
	public boolean isCorrect(String ans) {
		if(ans.equals("oui") || Boolean.parseBoolean(ans) == true){
			return this.trueanswer == true;
		}
		else {
			return this.trueanswer == false;
			}
		}

	@Override
    public AnswerPanel createMyAnswerPanel() {
        return new BooleanAnswerPanel(this);
    }

    public String toString() {
    	if(this.trueanswer ==true) {
    		return "oui";
    	}
    	else {
    		return "non";
    	}
    }
	
	


	
	
}
