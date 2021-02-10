package hilospackage;

//import java.io.IOException;
import java.util.Scanner;

public class hilo1 extends Thread// implements Runnable
{
	public static String palabra;

	public void run() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Introduzca la palabra a ser agregada: ");
			palabra = sc.next();

		} catch (Exception e) {
			System.out.println("Error al leer palabra");
			e.printStackTrace();
		} finally {
			if (hilosprincipal.bandera == false) {
				sc.close();
			}
		}
	}
}
