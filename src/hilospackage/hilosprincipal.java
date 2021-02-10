package hilospackage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class hilosprincipal {
	public static boolean bandera = true;
	public static String stloop;
	public static String fileName = "palabras.txt";

//	class Variables{
//		 public volatile String palabra;
//	}
//	final Variables variable = new Variables();
//
//	private void tareaHilos() {

	// }
	public static void main(String[] args) throws InterruptedException {

//		try {
//			hilosprincipal tareaHilos = new hilosprincipal();
//			tareaHilos.tareaHilos();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Scanner respuesta = new Scanner(System.in);

		hilo1 h1 = new hilo1();
		hilo2 h2 = new hilo2();
		hilo3 h3 = new hilo3();

		h1.setPriority(10);
		h2.setPriority(5);
		h3.setPriority(1);
		// h1.start();
		try {

			File archivotxt = new File(fileName);
			if (archivotxt.createNewFile()) {
				System.out.println("Archivo creado: " + archivotxt.getName());
			} else {
				System.out.println("El archivo ya existe");
			}
		} catch (IOException e) {
			System.out.println("Error al tratar de crear el archivo");
			e.printStackTrace();
		} finally {

			h1.getState();
			if (!h1.isAlive()) {
				h1.start();
			}
			// Thread.State estado1 =
			while (h1.isAlive()) {
				Thread.sleep(1000);
			}
			h1.getState();
			h2.getState();
			if (!h1.isAlive() && !h2.isAlive()) {
				h2.start();
				// Thread.State estado2 =
				while (h2.isAlive()) {
					Thread.sleep(1000);
				}
				h2.getState();
			}
			h3.getState();
			if (!h1.isAlive() && !h2.isAlive() && !h3.isAlive()) {
				h3.start();
				// Thread.State estado2 =
				while (h3.isAlive()) {
					Thread.sleep(1000);
				}
				h3.getState();
			}

			if (!h1.isAlive() && !h2.isAlive() && !h3.isAlive()) {
				h1.interrupt();
				h2.interrupt();
				h3.interrupt();

				h1.getState();
				h2.getState();
				h3.getState();

				System.out.println("\nDesea agregar más palabras? S/N ");
				stloop = respuesta.nextLine();

				try {
					if (!(stloop.equals("S") || stloop.equals("s"))) {
						bandera = false;
						System.out.println("Finalizando programa");
					}
				} catch (Exception e) {
					System.out.println("Error al leer respuesta ");
					e.printStackTrace();
				}
			}

			while (bandera == true) {
				h1.getState();
				if (!h1.isAlive()) {
					h1.run();
				}
				// Thread.State estado1 =
				while (h1.isAlive()) {
					Thread.sleep(1000);
				}
				h1.getState();
				h2.getState();
				if (!h1.isAlive() && !h2.isAlive()) {
					h2.run();
					// Thread.State estado2 =
					while (h2.isAlive()) {
						Thread.sleep(1000);
					}
					h2.getState();
				}
				h3.getState();
				if (!h1.isAlive() && !h2.isAlive() && !h3.isAlive()) {
					h3.run();
					// Thread.State estado2 =
					while (h3.isAlive()) {
						Thread.sleep(1000);
					}
					h3.getState();
				}

				if (!h1.isAlive() && !h2.isAlive() && !h3.isAlive()) {
					h1.interrupt();
					h2.interrupt();
					h3.interrupt();

					h1.getState();
					h2.getState();
					h3.getState();

					// Thread.sleep(1500);
					// String st = new String(respuesta.nextLine());
					// respuesta.nextLine();
					System.out.println("Desea agregar más palabras? S/N ");
					// Thread.sleep(1500);
					stloop = respuesta.nextLine();
					// stloop = "N";

					try {
						if (!(stloop.equals("S") || stloop.equals("s"))) {
							bandera = false;
							System.out.println("Finalizando programa");
						}
					} catch (Exception e) {
						System.out.println("Error al leer respuesta ");
						e.printStackTrace();
					}
				}
			}
		}
		respuesta.close();
		// sc.close();
	}
}
