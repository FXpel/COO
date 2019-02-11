package fil.coo.ihm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import fil.coo.answer.Answer;
import fil.coo.ihm.AnswerPanel;

public abstract class GroupAnswerPanel<T> extends AnswerPanel {
    protected Collection<T> theAnswers;
    private ButtonGroup group;
    private String answerText;

    public GroupAnswerPanel(Answer<?> answer) {
        super(answer);
        this.initTheValues();
    }

    protected abstract void initTheValues();

    @Override
    public JPanel getPanel() {
        JPanel result = new JPanel();
        result.setLayout(new GridLayout(2, 1));
        this.group = new ButtonGroup();
        for (T t : this.theAnswers) {
            JRadioButton button = new JRadioButton(t.toString());
            button.addActionListener(new ButtonListener());
            this.group.add(button);
            result.add(button);
        }
        return result;
    }

    @Override
    public String getAnswerText() {
        return this.answerText;
    }

    static void access$0(GroupAnswerPanel<?> groupAnswerPanel, String string) {
        groupAnswerPanel.answerText = string;
    }

    class ButtonListener
    implements ActionListener {
        ButtonListener() {
        }

      
        public void actionPerformed(ActionEvent e) {
            GroupAnswerPanel.access$0(GroupAnswerPanel.this, e.getActionCommand());
        }
    }

}

