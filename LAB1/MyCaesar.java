package LAB1;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	public char encryptChar(char c) {
		int x = 0;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i]) {
				x = i;
			}
		}
		return ALPHABET[(x + n) % 26];
	}

	public String encrypt(String input) {
		StringBuilder sb = new StringBuilder();
		for (char c : input.toCharArray()) {
			sb.append(encryptChar(c));
		}
		return sb.toString();
	}

	public char decryptChar(char c) {
		int x = 0;
		char result;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i]) {
				x = i;
			}
		}
		if (x > n) {
			result = ALPHABET[(x - n) % 26];
		} else {
			result = ALPHABET[((26 + x) - n) % 26];
		}
		return result;
	}

	public String decrypt(String input) {
		char[] arr = input.toCharArray();
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ') {
				result += ' ';
			} else {
				result += decryptChar(arr[i]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String input = "BBB CCC";
		String input2 = "ABCDED";
		MyCaesar a = new MyCaesar(5);
		System.out.println(a.encrypt(input));
		System.out.println(a.decrypt(a.encrypt(input)));
		System.out.println(a.encrypt(input2));
		System.out.println(a.decrypt(a.encrypt(input2)));
	}
}
