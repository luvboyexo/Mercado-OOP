package other;

import java.util.Scanner;

import controle.SistemaAlterado;

public class Programa {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// Scanner scn = new Scanner(System.in);
		SistemaAlterado sistema = SistemaAlterado.getInstance();
		SistemaAlterado.limparTerminal();
		sistema.iniciar();
	}

}