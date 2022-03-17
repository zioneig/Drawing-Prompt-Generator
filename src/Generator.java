import java.util.*;
import java.io.*;

public class Generator {

	public static void main(String[] args) {

		File nFile = new File("Nouns.txt"); 
		File aFile = new File("Adjectives.txt");

		BufferedReader nBr = null;
		BufferedReader aBr = null;

		try {
			nBr = new BufferedReader(new FileReader(nFile));
			aBr = new BufferedReader(new FileReader(aFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

		//grab words from files
		ArrayList<String> Nouns = new ArrayList<String>();
		ArrayList<String> Adjectives = new ArrayList<String>();
		String st; 
		try {
			while ((st = nBr.readLine()) != null) 
				Nouns.add(st);

			while ((st = aBr.readLine()) != null)
				Adjectives.add(st);
		} catch (IOException e) {
			e.printStackTrace();
		} 

		Scanner kb = new Scanner(System.in);
		String cont = "";

		//generate prompts
		do {
			System.out.println("Would you like to generate a prompt? (Y/N): ");
			cont = kb.nextLine();
			
			int adNum = (int) (Math.random() * Adjectives.size());
			int nNum1 = (int) (Math.random() * Nouns.size());
			int nNum2 = (int) (Math.random() * Nouns.size());
			
			
			System.out.println(Nouns.get(nNum1) + " " 
			+ Adjectives.get(adNum)
			+ " " + Nouns.get(nNum2));
			
		}while(cont.equalsIgnoreCase("Y"));

	}

}
