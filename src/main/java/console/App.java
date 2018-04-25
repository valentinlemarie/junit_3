package console;


import java.util.Scanner;

import org.slf4j.LoggerFactory;

import services.CalculService;

public class App {
	private Scanner scanner;
	private CalculService calculatrice;
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger("monLogger");
	
	public App(Scanner scanner, CalculService calculatrice) { 
		this.scanner = scanner;
		this.calculatrice = calculatrice;
	}

	protected void afficherTitre() {
		LOGGER.info("\n**** Application Calculatrice ****");
	}

	
	
	public void demarrer() {
		afficherTitre();
		
		while(this.scanner.hasNext()){
			System.out.println("Veuillez entrer un calcul");
			String expression = this.scanner.nextLine();
			if(expression.endsWith("fin")){
				evaluer(expression);
				System.out.println("Aurevoir :-(");
			}else{
				this.calculatrice.additionner(expression);
			}
			
		}
	}

	protected void evaluer(String expression) {
		String var = expression ;
		if(expression.endsWith("fin")){
			var = expression.replaceFirst("fin", "");
		}
		System.out.println(var+"="+this.calculatrice.additionner(expression));
		
	}
}

