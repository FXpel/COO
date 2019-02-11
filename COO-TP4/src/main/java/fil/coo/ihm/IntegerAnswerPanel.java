package fil.coo.ihm;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import fil.coo.answer.IntegerAnswer;
import fil.coo.ihm.AnswerPanel;

public class IntegerAnswerPanel extends AnswerPanel {
    private JSpinner spinner;

    public IntegerAnswerPanel(IntegerAnswer answer) {
        super(answer);
    }

    @Override
    public JPanel getPanel() {
        JPanel result = new JPanel();
        this.spinner = new JSpinner();
        this.spinner.setPreferredSize(new Dimension(100, 50));
        this.spinner.setAlignmentY(0.5f);
        result.add(this.spinner);
        return result;
    }

    @Override
    public String getAnswerText() {
        return this.spinner.getValue().toString();
    }
}

