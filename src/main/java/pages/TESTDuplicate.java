package pages;

public class TESTDuplicate {

	public static void main(String[] args) {
		

		String a = "aarti is name";
	String word[]  = 	a.split("\\s");
		String rev=" ";
		for(int i=0; i<word.length; i++) {
			String word1 = word[i];
			String revword =" ";
			for(int j =word1.length()-1; j>=0; j--) {
				
				revword = revword + word1.charAt(j);
				
				System.out.println();
				
			}
			rev = rev+revword + " ";
			
			
		}
		System.out.println(rev);
	       
	}

}
