package fil.coo.ihm;

import fil.coo.answer.MultiChoiceAnswer;
import fil.coo.ihm.GroupAnswerPanel;

public class MultiChoiceAnswerPanel extends GroupAnswerPanel<String> {
    public MultiChoiceAnswerPanel(MultiChoiceAnswer answer) {
        super(answer);
    }

    @Override
    protected void initTheValues() {
        this.theAnswers = ((MultiChoiceAnswer)this.answer).getThePropositions();
    }
}

