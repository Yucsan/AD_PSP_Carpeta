package ejercicio7_hilos_sincronizar_HILOS;

import ejercicio01_conceptos_hilos.Hilo;

/*
 Crear un programa que jecute dos hilos uno a continuacion del otro
 Ambos hilos muestran un mensaje 25 veces en panatalla. "Ejecutando hilo nº"
 ¿que ocurre?
 Hay que comprobar que no estań sincronizados. (ejecuta los hilos como quiere. No llega a terminar
 la ejecución del hilo1 y viceversa).
 * */

public class SincronizandoHilos {

	public static void main(String[] args) {
		Hilo25 hilo0=new Hilo25();
		hilo0.setName("HILO0");
		hilo0.start();
		
		//Hay sincronización de hilos: primero se ejecuta y termina
		//el primero y despues comienza y termina el segundo
		
		try {
			hilo0.join();//espera a que el hilo sea interrumpido
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		Hilo25 hilo1=new Hilo25();
		hilo1.setName("HILO1");
		hilo1.start();
		
		
		
		
		
		
		/*
		try {
			hilo1.join();//espera a que el hilo sea interrumpido
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		*/
	}

}
