
import java.util.Scanner;

public class PigLatinTest {
	public static void main(String[] args) {
		pigLatin();
	}
	
	public static void pigLatin(){
		Scanner sc = new Scanner(System.in);
		final String vowels = "aeiou";
		System.out.println("Enter your word.");
		String word = sc.nextLine();
		while (true) {
			word.toLowerCase();
			String beforVowel="";
			int cut = 0;
			/*
			 * while word has chars AND char at cut index is not vowel
			 * then concat char to beforVowel, and increment cut 
			 * ie, pulls all consonants before 1st vowel
			 */
			while (cut < word.length() && !vowels.contains("" + word.charAt(cut))) {
				beforVowel += word.charAt(cut);
				
				cut++;
			}
			// if true, then 1st char is vowel, so concat "w" to end
			if (cut == 0) {
				cut = 1;
				word += word.charAt(0) + "w";
			}
			// prints rest of word, starting with 1st vowel +
			// all preceeding consonants + "ay"
			System.out.println(word.substring(cut) + beforVowel + "ay");

			while (true) { // start another word?
				System.out.println("Would you like to translate another word? (Y/N)");
				word = sc.nextLine();
				if (word.equalsIgnoreCase("N")) {
					System.out.println("Goodbye");
					sc.close();
					System.exit(0);
				} else if (!word.equalsIgnoreCase("Y")) {
					System.out.println("Unacceptable response !");
				} else {
					System.out.println("Enter your word.");
					word = sc.nextLine();
					break;  // breaks another word (inner while)
				}
			} // end another word?
		}
	}
}
