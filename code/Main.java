import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * The program implements the Caesar cipher. Only English lowercase letters and spaces are
 * accepted as input. At the beginning of work, a secret key is entered, the key can only be a
 * positive number not a multiple of 26. Then there is a choice of encryption and decryption.
 */

public class Main {

	public static void main(String[] args) {

		System.out.println("|____labwork_001_Caesar_cipher____|");
		System.out.println("|Input symmetric key S            |");
		Scanner scanner = new Scanner (System.in);
		int exit = 0, s = 0;
		try {
			int ch=0;
			while (ch==0) {
				System.out.printf("|>> ");
				s = scanner.nextInt();
				scanner.nextLine();
				if (s >= 1) {
					if (s % 26 != 0) {
						ch = 1;
					}
					else {
						System.out.println("|The S cannot be a multiple of 26 |");
					}
				}
				else {
					System.out.println("|Input positive number            |");
				}
			}
		}
		catch (InputMismatchException x) {
			System.out.println("|You can input only integer       |");
			exit = 1;
		}
		finally {
			System.out.println();
		}
		while (exit==0) {
			System.out.println("|Choose:                          |");
			System.out.println("|1)Encryption                     |");
			System.out.println("|2)Decoding                       |");
			System.out.println("|0)Exit                           |");
			System.out.printf("|>> ");
			String ch = scanner.nextLine();
			switch (ch) {
			case ("1"):
			{
				System.out.println("|Input a line to encrypt          |");
				System.out.printf("|>> ");
				String line = scanner.nextLine();
				System.out.println("|Encrypted line:                  |");
				System.out.println("|" + encryption(line, s));
				System.out.println();
			}
			break;
			case ("2"):
			{
				System.out.println("|Input a line to decod           |");
				System.out.printf("|>> ");
				String line = scanner.nextLine();
				System.out.println("|Decoding line:                  |");
				System.out.println("|" + decoding(line, s));
				System.out.println();
			}
			break;
			case ("0"):
			{
				exit = 1;
				System.out.println();
			}
			break;
			default: {
				System.out.println("|Invalid_character________________|");
				System.out.println();
			}
			}
			
		}
		
		scanner.close();
		System.out.println("|________________Made_by_MarconiNN|");
	}
	
	static String encryption (String line, int s) {
		String result = "";
		int c = 0;
		int y = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i)!=' ') {
				c =  (line.charAt(i) + s);
				y = (c - 97) % 26 + 97;
				result += (char) y;
			}
			else result += ' ';
			}
		return result;
	}
	
	static String decoding (String line, int s) {
		String result = "";
		int c = 0;
		int y = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i)!=' ') {
				c =  (line.charAt(i) - s);
				y = (c - 122) % 26 + 122;
				result += (char) y;
			}
			else result += ' ';
			}
		return result;
	}

}
