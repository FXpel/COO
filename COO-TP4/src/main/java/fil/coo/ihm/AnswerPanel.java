package fil.coo.ihm;

import javax.swing.JPanel;
import fil.coo.answer.Answer;

public abstract class AnswerPanel {
    protected Answer<?> answer;

    public AnswerPanel(Answer<?> answer) {
        this.answer = answer;
    }

    public abstract JPanel getPanel();

    public abstract String getAnswerText();
}

