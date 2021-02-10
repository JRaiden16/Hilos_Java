package hilospackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Scanner;

public class hilo3 extends Thread {

	// private String word;
	// private JTextArea textArea;
	// public String str;
	private int count = 0;
	String fileName = "palabras.txt";

//	public Contable (String word, JTextArea textArea) {
//		this.word = word;
//		this.textArea = textArea;
//	}
	public void run() {
		// Scanner scanner1 = new Scanner("palabras.txt");
		try {
			BufferedReader ent = new BufferedReader(new FileReader(fileName));
			count = 0;
			while (ent.readLine() != null) {
				// str = scanner1.nextLine();
				count++;
			}
			System.out.println("El archivo contiene: " + count + " palabras.\n");
			
			if (hilosprincipal.bandera == false) {
				ent.close();
			}
//			SwingUtilities.invokeLater(new Runnable() {
//				@Override
//				public void run() {
//					textArea.append(word + " aparece: " + count + " tiempo\n");
//					//System.out.println(SwingUtilities.isEventDispatchThread());
//				}
//			});
		} catch (IOException e) {
			System.out.println("Problema al contar palabras");
			e.printStackTrace();
		}
	}
}
