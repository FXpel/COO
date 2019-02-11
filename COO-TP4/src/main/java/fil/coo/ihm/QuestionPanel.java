package fil.coo.ihm;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import fil.coo.answer.Answer;
import fil.coo.Question;
import fil.coo.ihm.AnswerPanel;

public class QuestionPanel extends JPanel {
    protected JLabel text;
    protected AnswerPanel inputAnswerPanel;
    protected Question question;

    public QuestionPanel(Question question) {
        this.question = question;
        this.text = new JLabel("  " + question.getQuestion() + " : ");
        this.setLayout(new GridLayout(1, 2));
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.text.setAlignmentY(0.5f);
        this.add(this.text);
        inputAnswerPanel = this.createInputAnswerPanel();
        inputAnswerPanel.getPanel().setAlignmentY(0.5f);
        this.add(inputAnswerPanel.getPanel());
    }

    private AnswerPanel createInputAnswerPanel() {
        return this.question.getAnswer().createMyAnswerPanel();
    }

    public void setAnswer() {
        this.question.setUserAnswer(this.inputAnswerPanel.getAnswerText());
    }
    
    public int checkAnswer(){
    	if(this.question.isCorrectAnswer(this.inputAnswerPanel.getAnswerText())){
    		return this.question.getPoints();
    	}
    	return 0;
    }
}

