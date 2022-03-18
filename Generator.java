/* Author Zion Eig-Tassiello
 * Last Modified: 3/18/2022
 */

import java.util.*;
import java.io.*;

public class Generator {

	public static void main(String[] args) {

		File nFile = new File("C:\\Users\\Zion\\Desktop\\Personal Workspace (Java)\\Drawing Prompt Generator\\Nouns.txt"); 
		File aFile = new File("C:\\Users\\Zion\\Desktop\\Personal Workspace (Java)\\Drawing Prompt Generator\\Adjectives.txt");
		File vFile = new File("C:\\Users\\Zion\\Desktop\\Personal Workspace (Java)\\Drawing Prompt Generator\\Verbs.txt");

		BufferedReader nBr = null;
		BufferedReader aBr = null;
		BufferedReader vBr = null;

		try {
			nBr = new BufferedReader(new FileReader(nFile));
			aBr = new BufferedReader(new FileReader(aFile));
			vBr = new BufferedReader(new FileReader(vFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

		//grab words from files
		ArrayList<String> nouns = new ArrayList<String>();
		ArrayList<String> adjectives = new ArrayList<String>();
		ArrayList<String> verbs = new ArrayList<String>();
		String st; 
		try {
			while ((st = nBr.readLine()) != null) 
				nouns.add(st);

			while ((st = aBr.readLine()) != null)
				adjectives.add(st);
			
			while((st = vBr.readLine()) != null){
				verbs.add(st);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 

		Scanner kb = new Scanner(System.in);
		String cont = "";

		//generate prompts
		do {
			System.out.println("Would you like to generate a prompt? (Y/N): ");
			cont = kb.nextLine();
			
			int adjIndex = (int) (Math.random() * adjectives.size());
			int nounIndex1 = (int) (Math.random() * nouns.size());
			int nounIndex2 = (int) (Math.random() * nouns.size());
			int verbIndex = (int) (Math.random() * verbs.size());
			
			System.out.println("The " + adjectives.get(adjIndex) + " " + nouns.get(nounIndex1) + " " 
			+ verbs.get(verbIndex));

			
		}while(cont.equalsIgnoreCase("Y"));

	}

}
