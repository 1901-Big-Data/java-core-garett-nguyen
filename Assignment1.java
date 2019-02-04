import java.lang.StringBuilder;
import java.util.LinkedList;

public class Assignment1 {
	public static void main(String[] args) {
		
		System.out.println("1. String reverse test. ");
		System.out.println("Mandown");
		String s = "";
		System.out.println(stringReverse(s));
		
		System.out.println("2. Acronym test. ");
		String see = "b        A Dog Jumped Over the M O N eevery day ";
		System.out.println(see);
		System.out.println(acronym(see));
		
		System.out.print("3. Triangle test");
		System.out.println("sides 8, 8, 8 is a " + triangleTest(8,7,6));
		System.out.println("4. Compute Scrabble score for a word");
		System.out.println("Score for darkened " +scrabbleScore("darkened"));
		//Skipping 5 and 6 and 7
		
		System.out.println("skipping 5");
		System.out.println("6. occurence of words in phrase");
		String panogram = "the quick brown fox jumped over the lazy dog";
		
		System.out.println("8. Pig latin? dammit"); 
		
		stringParse("  The  duck  may     swim     on the lake ");
		
		pigLatin("the duck may swim on the lake");
		
		System.out.println("9. Armstrong numbers");
		
		System.out.println(armstrong(514));
		
		System.out.println("10. Caeser Cipher");
		
		System.out.println(caeserCipher("dacus(mo^^^^ena", 1));
	
		isbn("5655782642");
		
		System.out.println(pangram("the quick brown fox jumps over the lazy dog"));
		
		tentothenine();
		
		System.out.println(luhnvalidate("79927398713"));
		
		atbashencode("a bcdef g");
		
		occurrenceCheck("the duck may swim on the lake but my daddy owns the duck and the lake");
		
		System.out.println(wordProblem("91 divided 2, what is the number?"));
		
		int[] examparr = {1, 4, 8, 14, 44, 50, 53, 60, 67, 70};
		System.out.println(binarySearch(examparr, 0, examparr.length-1, 14));
	
		System.out.println("nth Prime test");
		System.out.println(nthPrime(5));
		System.out.println(nthPrime(6));
		System.out.println(nthPrime(7));
		System.out.println(nthPrime(8));
		
		System.out.println("factor multiple test");
		System.out.println(factorMultiple(36));
		
		System.out.println("Phone number thing");
		
		System.out.println(phoneNumbers(12345678));
		System.out.println(phoneNumbers(1234567));
		
		System.out.println("Prime Factors");
		primeFactors(36);
	}
	
	/*Without using the StringBuilder or StringBuffer class, write a method that reverses a String.
	*Convert a phrase to its acronym.
	*Determine if a triangle is equilateral, isosceles, or scalene.
	/Given a word, compute the scrabble score for that word.
	*Clean up user-entered phone numbers so that they can be sent SMS messages.
	*Given a phrase, count the occurrences of each word in that phrase.
	*Implement a binary search algorithm.
	*Implement a program that translates from English to Pig Latin.
	*An Armstrong number is a number that is the sum of its own digits each raised to the power of the number of digits.
	*Compute the prime factors of a given natural number.
	*Create an implementation of the rotational cipher, also sometimes called the Caesar cipher.
	*Given a number n, determine what the nth prime is.
	*Create an implementation of the atbash cipher, an ancient encryption system created in the Middle East. Encode a value with the cipher
	*Create an implementation of the atbash cipher, an ancient encryption system created in the Middle East. Decode a value with the cipher
	*Write a method that validates a number to be proper ISBN-10.
	*Determine if a sentence is a pangram.
	*Calculate the moment when someone has lived for 10^9 seconds.
	*Given a number, find the sum of all the unique multiples of particular numbers up to but not including that number.
	*Given a number determine whether or not it is valid per the Luhn formula.
	*Parse and evaluate simple math word problems returning the answer as an integer.
	*/
	
	public static String stringReverse(String s) {
		char[] sreverse = new char[s.length()]; 
		int j = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			sreverse[j] = s.charAt(i);
			System.out.println(sreverse[j]);
			j++;
		}
		String sid = new String(sreverse); 
		return sid;
	}
	
	public static String acronym(String s) {

		StringBuilder acronym = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if ((i > 0 && s.charAt(i) != ' ' && s.charAt(i-1) == ' ') || (i == 0 && s.charAt(0) != ' ' )) {
				acronym.append(s.charAt(i));
			}
		}
		return acronym.toString();	
	}
	
	public static String triangleTest(int a, int b, int c) {
		
		if (a == b && b == c && c == a) {
			return "equilateral";
		}
		else if (a == b || b == c || c == a) {
			return "isosceles";
		}
		else {
			return "scalene";
		}
	}
	public static char[] alphabet() {
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		return alphabet;
	}
	public static int scrabbleScore(String s) {
		char[] alphabet = alphabet();
		int[] scoreboard = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
		int score = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j=0; j<26; j++) {
				if (s.charAt(i) == alphabet[j]) {
					score += scoreboard[j];
				}
			}
		}
		return score;
	}
	
	public static void occurrenceChecker(String s) {
		
		
		
	}
	
	public static LinkedList<String> stringParse(String s) {
		StringBuilder words = new StringBuilder();
		LinkedList<String> parsed = new LinkedList<String>();
		
		for (int i = 0; i < s.length(); i++) {	
			//if iterator encounters a regular character in the string
			if (s.charAt(i) != ' ' && s.charAt(i) != ',' &&s.charAt(i) != '.' && s.charAt(i) != '?' && s.charAt(i) != '!') {
				words.append(s.charAt(i));
			}
			//if iterator reaches the end of the string
			if (i == s.length() - 1) {
				parsed.add(words.toString());
				words.delete(0, words.capacity()-1);		
			}
			//if iterator encounters a space delimiter
			else if (s.charAt(i) == ' ' && words.length() > 0) {
				parsed.add(words.toString());
				words.delete(0, words.length());	
			}
		}
		return parsed;
	}
	
	public static void pigLatin(String s) {
		LinkedList<String> engwords = new LinkedList();
		engwords = stringParse(s);
		StringBuilder platinphrase = new StringBuilder();
		int c = engwords.size();
		for (int i = 0; i < c; i++) {
			StringBuilder word = new StringBuilder(engwords.remove());
			char first = word.charAt(0);
			word.deleteCharAt(0);
			word.append(first);
			word.append("ay");
			System.out.print(word);
			if (i+1 != c) {
				System.out.print(" ");
			}
		}
		
	}
	
	//returns the armstrong number of a given integer, c
	public static int armstrong(int c) {
		Integer number = new Integer(c);
		String parsednum = number.toString(); 
		int digittotal = 0;
		
		//adds values of digits together
		for (int i = 0; i < parsednum.length(); i++) {
			Integer digit = new Integer(""+ parsednum.charAt(i));
			digittotal += digit;
		}
		
		//exponentiates digit total by number of digits 
		int d2 = digittotal;
		for (int j = 0; j < parsednum.length(); j++) {
			digittotal = digittotal * d2;
		}
		
		return digittotal;
	}
	
	//returns caeser enciphered string with the jump value, integer c
	public static String caeserCipher(String s, int c) {
		char[] alphabet = alphabet();
		
		StringBuilder cipher = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			boolean isAlphabet = false;
			for (int z = 0; z< 26; z++) {
				if (alphabet[z] == s.charAt(i)) {
					cipher.append(alphabet[(26+z-c)%26]);
					isAlphabet = true; 
				}
			}
			if (!isAlphabet) {
				cipher.append(s.charAt(i));
			}
		}
		
		
		return cipher.toString();
	}
	
	public static boolean isbn(String zed) {
		if (zed.length() == 10) {
			boolean isIsbnValid = false; 
			int checkdigit = 0; 
			
			int placecheck = 10; 
			for (int i = 0; i < 10; i++) {
				Integer digit = new Integer(zed.charAt(i)+"");
				checkdigit += digit * placecheck;
				placecheck -= 1;
			}
			checkdigit = checkdigit % 11;
			if (checkdigit % 11 == 0) {
				return true;
			}
			else {
				return false;
			}			
		}
		else {
			return false;
		}
	}
	
	public static boolean pangram(String s) {
		
		char[] alphabet = alphabet();
		LinkedList<Character> alphacheck = new LinkedList<Character>();
		for (int i = 0; i < 26; i++) {
			alphacheck.add(alphabet[i]);
		}
		for (int z = 0; z < s.length(); z++) {
			if (alphacheck.contains(s.charAt(z))) {
				alphacheck.remove(alphacheck.indexOf(s.charAt(z)));
			}
			if (alphacheck.size() == 0) {
				return true;
			}
		}
		
		
		return false; 
	}
	
	public static void tentothenine() {
		int largenumber = 1000000000;
		
		int secmin = 60;
		int sechr = 60 * secmin;
		int secday = 24 * sechr;
		int secyr = secday * 365;
		
		int sec = 0;
		int min = 0;
		int hour = 0;
		int day = 0;
		int year = 0;
		
		year = (largenumber-(largenumber%secyr))/secyr;
		int divisor = largenumber%secyr;
		
		day = (divisor-(divisor%secday))/secday;
		divisor = divisor%secday;
		
		hour = (divisor-(divisor%sechr))/sechr;
		divisor = divisor%sechr;
		
		min = (divisor-(divisor%secmin))/secmin;
		divisor = divisor%secmin;
		
		sec = divisor%60;
		
		System.out.println("If you lived 10^9 seconds, you would have lived "
				+ year + " years, " + day + " days, " + hour + " hours " 
				+ min + " min and " + sec + " seconds.");
	}
	
	
	public static boolean luhnvalidate(String s) {

		Integer[] digits = new Integer[s.length()];
		for (int i = 0; i < s.length(); i++) {
			digits[i] = Integer.parseInt(s.substring(i, i + 1));
		}
		for (int i = digits.length - 2; i >= 0; i = i - 2) {
			int j = digits[i];
			j = j * 2;
			if (j > 9) {
				j = j % 10 + 1;
			}
			digits[i] = j;
		}
		
		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			sum += digits[i];
		}
		
		if (sum % 10 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void atbashencode(String s) {
		char[] alphabet = alphabet();
		char[] reversealph = new char[alphabet.length];
		
		//initialize atbash lookup table
		for (int i = 0; i < alphabet.length; i++) {
			reversealph[i] = alphabet[alphabet.length-i-1];
		}
		
		StringBuilder encode = new StringBuilder();
		for (int c = 0; c < s.length(); c++) {
			boolean isAlphabet = false;
			for (int z = 0; z < alphabet.length; z++) {
				if (s.charAt(c) == alphabet[z]) {
					encode.append(reversealph[z]);
					isAlphabet = true; 
				}
			}
			if (!isAlphabet) {
				encode.append(s.charAt(c));
			}
		}
		
		System.out.println(encode.toString());
	}
	

	public static void atbashdecode(String s) {
		char[] alphabet = alphabet();
		char[] reversealph = new char[alphabet.length];
		
		//initialize atbash lookup table
		for (int i = 0; i < alphabet.length; i++) {
			reversealph[i] = alphabet[alphabet.length-i-1];
		}
		
		StringBuilder encode = new StringBuilder();
		for (int c = 0; c < s.length(); c++) {
			boolean isAlphabet = false;
			for (int z = 0; z < alphabet.length; z++) {
				if (s.charAt(c) == alphabet[z]) {
					encode.append(reversealph[z]);
					isAlphabet = true; 
				}
			}
			if (!isAlphabet) {
				encode.append(s.charAt(c));
			}
		}
		
		System.out.println(encode.toString());
	}
	
	public static void occurrenceCheck(String s) {
		LinkedList<String> stringlist = new LinkedList<String>();
		stringlist = stringParse(s);
		
		System.out.println("Occurence of words");
		
		int size = stringlist.size();
		for (int i = 0; i < size; i++) {
			int count = 0;
			String temp = stringlist.element();
			while (stringlist.size() > 0 && stringlist.contains(temp)) {
				stringlist.remove(stringlist.indexOf(temp));
				count++;
				i++;
			}
			i--;
			System.out.println(temp + ": " + count);
		}		
	}
	public static boolean isNumber(String s) {
		boolean isnum = true;
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				isnum = false;
			}
		}
		return isnum;
	}
	
	
	public static int wordProblem(String s) {
		LinkedList<String> words = new LinkedList<String>();
		words = stringParse(s);
		
		
		if (words.contains("plus") || words.contains("added") || words.contains("add")) {
			int firstop = 0;
			int secop = 0;
			boolean hasfirstop = false;
			boolean hassecop = false;
			
			int i = 0;
			int phrasesize = words.size();
			while (i < phrasesize && (!hasfirstop || !hassecop)) {
				if (isNumber(words.peek()) && !hasfirstop) {
					Integer op = new Integer(words.remove());
					firstop = op;
					hasfirstop = true;
				}
				else if (isNumber(words.peek()) && hasfirstop) {
					Integer op2 = new Integer(words.remove());
					secop = op2;
					hassecop = true;
				}
				else {
					if (words.size() > 0) {
						words.remove();
					}
				}
				i++;
			}
			return firstop + secop;
		}
		else if (words.contains("subtract") || words.contains("subtracted") || words.contains("minus")) {
			int firstop = 0;
			int secop = 0;
			boolean hasfirstop = false;
			boolean hassecop = false;
			
			int i = 0;
			int phrasesize = words.size();
			while (i < phrasesize && (!hasfirstop || !hassecop)) {
				if (isNumber(words.peek()) && !hasfirstop) {
					Integer op = new Integer(words.remove());
					firstop = op;
					hasfirstop = true;
				}
				else if (isNumber(words.peek()) && hasfirstop) {
					Integer op2 = new Integer(words.remove());
					secop = op2;
					hassecop = true;
				}
				else {
					if (words.size() > 0) {
						words.remove();
					}
				}
				i++;
			}
			return firstop - secop;
		}
		else if (words.contains("multiply") || words.contains("times") || words.contains("multiplied")) {
			int firstop = 0;
			int secop = 0;
			boolean hasfirstop = false;
			boolean hassecop = false;
			
			int i = 0;
			int phrasesize = words.size();
			while (i < phrasesize && (!hasfirstop || !hassecop)) {
				if (isNumber(words.peek()) && !hasfirstop) {
					Integer op = new Integer(words.remove());
					firstop = op;
					hasfirstop = true;
				}
				else if (isNumber(words.peek()) && hasfirstop) {
					Integer op2 = new Integer(words.remove());
					secop = op2;
					hassecop = true;
				}
				else {
					if (words.size() > 0) {
						words.remove();
					}
				}
				i++;
			}
			return firstop * secop;
		}
		else if (words.contains("divide") || words.contains("divided")) {
			int firstop = 0;
			int secop = 0;
			boolean hasfirstop = false;
			boolean hassecop = false;
			
			int i = 0;
			int phrasesize = words.size();
			while (i < phrasesize && (!hasfirstop || !hassecop)) {
				if (isNumber(words.peek()) && !hasfirstop) {
					Integer op = new Integer(words.remove());
					firstop = op;
					hasfirstop = true;
				}
				else if (isNumber(words.peek()) && hasfirstop) {
					Integer op2 = new Integer(words.remove());
					secop = op2;
					hassecop = true;
				}
				else {
					if (words.size() > 0) {
						words.remove();
					}
				}
				i++;
			}
			if (secop != 0) {
				return firstop / secop;
			}
		}
		return 0;
	}
	
	//binary search using recursion
	public static int binarySearch(int arr[], int l, int r, int x) { 
		if (r >= l) { 
			int mid = l+(r-l)/2; 
            if (arr[mid] == x) {
            	return mid;
            }
            if (arr[mid] > x) {
            	  return binarySearch(arr, l, mid-1, x);
            } 
            return binarySearch(arr, mid + 1, r, x); 
        } 
        System.out.println("element not found. returning -1");
        return -1; 
    } 
  
	
	public static int nthPrime(int n) {
		    int prime = 1;
		    int count = 0;
		    int i = 0;
		 
		    while (count < n) {
		    	prime += 1;
		    	for (i = 2; i <= prime; i++) {
		    		if (prime % i == 0) {
		    			break;
		    		}
		    	}
		    	if ( i == prime) {
		    		count = count+1;
		    	}
		   }
		   return prime;
	}
	
	public static int factorMultiple(int n) {
	    
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 2; i < n; i++) {
	    	  while (n % i == 0) {
	        	  if (!list.contains(i)) {
		    		  list.add(i);
	        	  }
	    		  n = n / i;
	    	  }
	      }
	      
	      int total = 0;
	      int size = list.size();
	      for (int z = 0; z < size; z++) {
	    	  total += list.remove();
	      }
	      return total; 
	}
	
	public static String phoneNumbers(int i) {
		String str = Integer.toString(i);
		if (str.length() == 8) {
			StringBuilder phone = new StringBuilder(str);
			phone.insert(1, "-", 0, 1);
			phone.insert(5, "-", 0, 1);
			return phone.toString();
		}
		else if (str.length() == 7) {
			StringBuilder phone = new StringBuilder(str);
			phone.insert(3, "-", 0, 1);
			return phone.toString();
		}
		else {
			System.out.println("not a valid phone number");
			return str; 
		}
	}
	
	
	public static void primeFactors(int n) {
		
		LinkedList<Integer> factors = new LinkedList<Integer>();
		System.out.print("The prime factors of " + n + " are: ");
		for (int i = 1; i < n; i++) {
			if (n%i == 0 && i != 1) {
				factors.add(i);
			}
		}
		
		for (int g = 0; g < factors.size(); g++) {
			System.out.println(factors.get(g) + " !");
		}
		
		
		for (int z = factors.size() - 1; z >= 0; z--) {
			for (int v = 0; v < factors.size() - 2; v++) {
				if (factors.get(z-1)% factors.get(v) == 0) {
					factors.remove(z);
				}
			}
		}
		
		
	}
}



















