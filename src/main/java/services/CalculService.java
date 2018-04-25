package services;

import java.util.ArrayList;
import java.util.Iterator;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import exception.CalculException;

public class CalculService {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger("monLogger");
	
	public int additionner(String expression) {

		//TODO Ajouter un log en niveau DEBUG affichant "	Evaluation de l'expression <expression>".
		LOGGER.debug("Evaluation de l'expression",expression);
		//TODO par exemple "Evaluation de l'expression 1+4"

		int lg = expression.length();
		int cpt = 0;
		int resultat = 0 ;

		String[] data = expression.split("\\+");
	
		for (String string : data) {
			try{
				if(string.endsWith("fin")){
					string.replaceFirst("fin", "");
				}
				resultat+=Integer.parseInt(string);
			}catch (Exception e) {
				throw new CalculException(expression);// TODO: handle exception
			}
		}
		return resultat;

	}
}