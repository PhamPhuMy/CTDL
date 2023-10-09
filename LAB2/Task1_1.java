package LAB2;

public class Task1_1 {
	public static long tinhGiaithua(int n) {
        long giai_thua = 1;
        if (n == 0 || n == 1) {
            return giai_thua;
        } else {
            for (int i = 2; i <= n; i++) {
                giai_thua *= i;
            }
            return giai_thua;
        }
    }

	// S(n)=1-2+3-4+�+ ((-1)^(n+1) ).n , n>0
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		}
		return (int) (Math.pow((-1), (n + 1))) * n + getSn1(n - 1);
	}
	// S(n)=1+1.2+1.2.3+�+1.2.3�n, n>0

	public static int getSn2(int n) {
		if (n == 1) {
			return 1;
		}
		return n * getSn2(n - 1) + getSn2(n - 1);
	}

	// S(n)=1^2+2^2+3^2+....+n^2 , n>0
	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		}
		return (int) (Math.pow(n, 2)) + getSn3(n - 1);
	}
	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+�+1/(2.4.6.2n), n>=0

	public static double getSn4(int n) {
		if (n == 0) {
			return 1;
		}
		return 1 / (tinhGiaithua(n)*Math.pow(2, n)) + getSn4(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(getSn1(5));
		System.out.println(getSn2(3));
		System.out.println(getSn3(4));
		System.out.println(getSn4(2));
	}

}
