package ejercicio_03_TCP_unMensaje;

import java.util.Scanner;

public class enunciado {

	/*
	 Chat entre 2 maquinas
	 
	 * */
	
	public static void main(String[] args) {
		String mensajeIns = "";
		Scanner tecTxt = new Scanner(System.in);
		
		do {
			mensajeIns = tecTxt.nextLine();
			
		}while( !mensajeIns.equals("0") );
		
		System.out.println("salgo del bucle");
		
	}

}
