package console;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.joran.conditional.ThenAction;
import services.CalculService;

public class FinTest {

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger("monLogger");

	private App app;
	private CalculService calculService;

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Before
	public void setUp() throws Exception { 
		Scanner sc = new Scanner(System.in);
		this.calculService = mock(CalculService.class);
		this.app = new App(sc, calculService);
	}
	
	@Test
	public void etape1() {

		String expression = "1+34 fin";
		
		when(calculService.additionner(expression)).thenReturn(35); 
		 
		systemInMock.provideLines(expression);
		this.app.demarrer();
		verify(this.calculService).additionner(expression);
		assertTrue(expression.endsWith("fin"));
		String logConsole = systemOutRule.getLog();
		assertThat(logConsole).contains("Aurevoir :-(");	
	}
	
	@Test
	public void etape2() {
		this.app = new App(new Scanner(System.in), calculService);
		String expression = "1+2 fin";
		when(calculService.additionner(expression)).thenReturn(3); 
		systemInMock.provideLines(expression);
		this.app.demarrer();
		verify(calculService).additionner(expression); 
		String logConsole = systemOutRule.getLog();
		assertThat(logConsole).contains("Application Calculatrice ****\r\n"
				+ "Veuillez saisir une expression :\r\n"
				+ "1+2=3\r\n"
				+ "Veuillez saisir une expression :\r\n"
				+"Aurevoir :-(\r\n");		

	}

}
