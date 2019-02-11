package fil.coo.ihm;

import java.util.ArrayList;
import java.util.Collection;
import fil.coo.answer.BooleanAnswer;
import fil.coo.ihm.GroupAnswerPanel;

public class BooleanAnswerPanel extends GroupAnswerPanel<Boolean> {
    public BooleanAnswerPanel(BooleanAnswer question) {
        super(question);
    }

    @Override
    protected void initTheValues() {
    	Collection<Boolean>	 oui = new ArrayList<Boolean>();
    	oui.add(true);
    	oui.add(false);
    	this.theAnswers = oui;
    }
    

}

