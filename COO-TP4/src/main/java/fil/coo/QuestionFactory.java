package fil.coo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import fil.coo.answer.AnswerFactory;

/*
 * QuestionFactory class
 */
public class QuestionFactory {
	public QuestionFactory() {
		
	}
	/**
	 * Create a Question from a file
	 * return a question create by a builder
	 */
	public Question createQuestion ( String text , String answer , String points ) throws Exception {
			try {
				int nbPoints = Integer.parseInt ( points );
				return new Question(text,AnswerFactory.FACTORY.buildAnswer(answer),nbPoints );
			}
			catch(NumberFormatException e) {
				throw new IOException("bad format");
			}
	}
	
	/**
	 * Create a questionnary form a file
	 * return a questionnary from a file
	 */
	public Questionnary createQuestionnary ( String fileName) throws Exception {
			Questionnary Questionnary = new Questionnary ( );
			File source = new File ( fileName );
			BufferedReader in = null ;
			try {
				in = new BufferedReader(new FileReader(source));
				String text ;
				// read block of 3 line s : text , answer and number of points
				while (( text = in.readLine())!= null ) {
					String answer = in.readLine();
					String nbPoints = in.readLine();
					if(answer == null || nbPoints == null ){
						throw new IOException("bad format");
					}
					Questionnary.addQuestion(this.createQuestion(text,answer,nbPoints ) );
				}
			} 
			catch (FileNotFoundException e) {
				throw new IOException(e );
			}
			finally {
				in.close ( );
			}
			return Questionnary ;
		}
}
