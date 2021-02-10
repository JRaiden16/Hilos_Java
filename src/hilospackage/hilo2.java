package hilospackage;

//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
//import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class hilo2 extends Thread // implements Runnable
{
	String linea;
	String fileName = "palabras.txt";
	boolean banderaWr = false;
	int lineNum = 0;

	public void run() {
		// Scanner sc = new Scanner(fileName);

		try {
			// FileWriter out = new ;
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			try {
				if (lineNum == 0 && (in.readLine()) == null) {
					// linea = in.readLine();
					lineNum++;

					out.write(hilo1.palabra + "\n");
					// out.println(hilo1.palabra);
					System.out.println("La palabra se ha escrito en el archivo.");
				} else {
					while ((linea = in.readLine()) != null) {
						banderaWr = false;
						// linea = in.readLine();
						lineNum++;
						if (linea.equals(hilo1.palabra)) {
							banderaWr = true;
							System.out.println("La palabra ya se encuentra en el archivo. En la linea: " + lineNum);
							break;
						}

					}
					if (banderaWr != true) {
						out.write(hilo1.palabra + "\n");
						// out.println(hilo1.palabra);
						System.out.println("La palabra se ha escrito en el archivo.");
					}

				}

			} catch (IOException e) {
				System.out.println("Error al escribir en el archivo");
				e.printStackTrace();
			} finally {
//				if (hilosprincipal.bandera == false) {
					out.close();
					in.close();
	//			}
			}
		} catch (IOException e) {
			System.out.println("Error al leer archivo");
			e.printStackTrace();
		} finally {
//		if(hilosprincipal.bandera == false) {
//    		sc.close();
//		}
		}
	}
}
