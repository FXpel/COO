package fil.coo.ihm;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fil.coo.Question;
import fil.coo.Questionnary;

public class QuestionnaryGui
{
  private JFrame f;
  private Questionnary questionnary;
  private List<QuestionPanel> listquestion;
  private int maxscore;
  /**
   * create a questionnary Panel
 * @param q
 */
public QuestionnaryGui(Questionnary q) {
	  this.questionnary = q;
	  this.listquestion = new ArrayList<QuestionPanel>();
  }
  
/**
 * create a frame
 */
  public void createFrame() throws Exception
  {
	maxscore = 0;
    f = new JFrame();
    JPanel pp = new JPanel();
    pp.setLayout(new GridLayout(5, 1));
    JScrollPane p = new JScrollPane(pp);
    f.setLayout(new BorderLayout(2, 1));
    f.getContentPane().add(p, "Center");
    
    f.setSize(500, 500);
    f.addWindowListener(new FermeWindowEvent());
    for (Question question : this.questionnary.getQuestion()) {
    	QuestionPanel qp = new QuestionPanel(question);
    	pp.add(qp);
    	this.listquestion.add(qp);
    	maxscore += question.getPoints();
    }
    
    JButton finished = new JButton("j'ai fini");
    finished.addActionListener(new FinishedActionListener(this));
    f.add(finished, "South");
    
    f.setVisible(true);
  }
  
  /**
   * check all the answer
   * return the score max
   */
  public String checkAllAnswers(){
	  int score = 0;
	  for(QuestionPanel q: this.listquestion){
		  
		  score += q.checkAnswer();
		  
	  }
	  return score+" / "+maxscore;
	  
  }
  
  private class FinishedActionListener implements ActionListener {
	  final QuestionnaryGui questionnaryGuiMain;
    private FinishedActionListener(QuestionnaryGui q) {
    	this.questionnaryGuiMain = q;
    	
    	
    }
    
    public void actionPerformed(ActionEvent e) {
      JOptionPane.showMessageDialog(f, this.questionnaryGuiMain.checkAllAnswers(), "Finished !", 1);
    }
  }
  
  private class FermeWindowEvent extends WindowAdapter {
	  
    private FermeWindowEvent() {}
    
    public void windowClosing(WindowEvent e) { System.exit(0); }
  }
  

}
