package fil.coo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import fil.coo.ihm.QuestionnaryGui;
import fil.coo.util.Input;

/**
 * Hello world!
 *
 */
public class main 
{
    public static void main( String[] args ) throws Exception
    {
        QuestionFactory q = new QuestionFactory();
        String fileName = "questions.txt";
        if (args.length == 1) {
            fileName = args[0];
        }
        try {
            Questionnary questionnaire = q.createQuestionnary(fileName);
            //b is here to block the repetition of the while
	            boolean b = false;
	            String answer = null;
	            while(!b){
		            System.out.println("write :");
		            System.out.println("-terminal if you want to answer in a terminal");
		            System.out.println("-interface if you want to answer in an interface");
		            answer = Input.readLine();
		            if(answer.equals("terminal")) {
		            	questionnaire.askAll();
		            	b = true;
		            }
		            if(answer.equals("interface")) {
		            	new QuestionnaryGui(questionnaire).createFrame();
		            	b=true;
		            }
	            }
	        }
	        catch (IOException e) {
	            System.out.println(String.valueOf(fileName) + " : bad file");
	            System.exit(0);
	        }
	    }
}


