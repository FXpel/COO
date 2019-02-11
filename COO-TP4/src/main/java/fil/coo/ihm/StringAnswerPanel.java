package fil.coo.ihm;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;
import fil.coo.answer.Answer;
import fil.coo.ihm.AnswerPanel;

public class StringAnswerPanel extends AnswerPanel {
    private JTextField answer;

    public StringAnswerPanel(Answer<?> answer) {
        super(answer);
    }

    @Override
    public JPanel getPanel() {
        JPanel result = new JPanel();
        this.answer = new JTextField("");
        this.answer.setPreferredSize(new Dimension(200, 50));
        this.answer.setAlignmentY(0.5f);
        result.add(this.answer);
        return result;
    }

    @Override
    public String getAnswerText() {
        return this.answer.getText();
    }
}

