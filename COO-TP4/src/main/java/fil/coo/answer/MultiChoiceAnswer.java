package fil.coo.answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import fil.coo.ihm.AnswerPanel;
import fil.coo.ihm.MultiChoiceAnswerPanel;
/**
 * Multichoice Class
 */
public class MultiChoiceAnswer extends StringAnswer{
	private List<String> listofchoice;

	/**
	 * @param txt
	 */
	public MultiChoiceAnswer(String txt) {
		super(null);
	    String[] tab = txt.split("\\|");
	    this.trueanswer = tab[0];
        this.listofchoice = Arrays.asList(tab);
        Collections.shuffle(this.listofchoice);
    }

    @Override
    public String getType() {
    	StringBuffer choices = new StringBuffer("");
        for (String s : this.listofchoice) {
        	choices.append(s);
        	if(!s.equals(this.listofchoice.get(this.listofchoice.size()-1))){
        		choices.append(",");
        	}
        }
        return choices.toString();
    }


    @Override
    public boolean isAccepted(String s) {
        return this.listofchoice.contains(s);
    }

    public List<String> getThePropositions() {
        return this.listofchoice;
    }
    
    @Override
    public AnswerPanel createMyAnswerPanel() {
        return new MultiChoiceAnswerPanel(this);
    }

}
