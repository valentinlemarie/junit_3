package console;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.LoggerFactory;

import exception.CalculException;

import static org.assertj.core.api.Assertions.assertThat;

import services.CalculService;

public class AppTest {

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger("monLogger");
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	private App app;
	private CalculService calculService;

	@Before
	public void setUp() throws Exception { 
		Scanner sc = new Scanner(System.in); 
		this.calculService = mock(CalculService.class);
		this.app = new App(sc, calculService);
	}

	
	@Test
	public void testEvaluer() throws Exception {

		LOG.info("Etant donné, un service CalculService qui retourne 35 à l'évaluation de l'expression 1+34");
		String expression = "1+34";
	
		when(calculService.additionner(expression)).thenReturn(35); 
	
		LOG.info("Lorsque la méthode evaluer est invoquée"); 
		this.app.evaluer(expression);
	
		LOG.info("Alors le service est invoqué avec l'expression {}", expression);
		verify(calculService).additionner(expression); 
	
		LOG.info("Alors dans la console, s'affiche 1+34=35"); 
		assertThat(systemOutRule.getLog()).contains("1+34=35");
		
	
	}

	@Test (expected = CalculException.class)
	public void testExptionEvaluer(){
		LOG.info("Etant donné, un service CalculService qui retourne un trow à l'évaluation de l'expression 34-1");
		String expression = "34-1";
	
		when(calculService.additionner(expression)).thenThrow(new CalculException(expression)); 
	
		LOG.info("Lorsque la méthode evaluer est invoquée"); 
		this.app.evaluer(expression);
	
		LOG.info("Alors le service est invoqué avec l'expression {}", expression);
		verify(calculService).additionner(expression); 
	}
	@Test
	public void testAfficherTitre() throws Exception { this.app.afficherTitre();
		String logConsole = systemOutRule.getLog();
		assertThat(logConsole).contains("**** Application Calculatrice ****");
	}
}
