package console;


import java.util.Scanner;

import services.CalculService;

public class AppLauncher {
	public static void main(String[] args) {
		try  {
			Scanner scanner = new Scanner(System.in);
			new App(scanner, new CalculService()).demarrer();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}