
public class FunctionsHandler {

	public static String selectFunction(int n, String input1, String input2, String input3, String input4) {

		String result = "";

		String[] array = { input1, input2, input3, input4 };

		int m = 1;
		if (n == 1 || n == 5)
			m = 2;
		if (n == 6)
			m = 4;

		for (int i = 0; i < m && result.isEmpty(); i++)
			result = control(array[i]);

		if (result.isEmpty())
			switch (n) {

			case 0:
				result = function1(input1);
				break;
			case 1:
				result = function2(input1, input2);
				break;
			case 2:
				result = function3(input1);
				break;
			case 3:
				result = function4(input1);
				;
				break;
			case 4:
				result = function5(input1);
				break;
			case 5:
				result = function6(input1, input2);
				break;
			case 6:
				result = function7(input1, input2, input3, input4);
				break;
			case 7:
				result = function8(input1);
				break;
			}

		return result;
	}

	public static String control(String input) {

		char a;
		String result = "";

		if (input.isEmpty())
			result = "Please insert a number.";
		else {

			a = input.charAt(0);

			if (input.length() != 1 && input.charAt(0) == '-' || Character.isDigit(a))
				for (int i = 1; i < input.length(); i++) {
					a = input.charAt(i);
					if (!Character.isDigit(a))
						result = "Only number are allowed.";
				}
			else
				result = "Only number are allowed.";
		}

		if (result.isEmpty()) {
			int ctrl = 0;

			char[] array = { 2, 1, 4, 7, 4, 8, 3, 6, 4, 7 };

			if (input.length() > 10 && input.charAt(0) == '-' || input.length() > 9 && input.charAt(0) != '-') {
				ctrl++;
			}

			if (input.length() == 10 && input.charAt(0) == '-') {
				for (int i = 0; i < input.length(); i++) {
					if (input.charAt(i) > array[i])
						ctrl++;
				}
			}
			if (input.length() == 9 && input.charAt(0) != '-') {
				for (int i = 0; i < input.length(); i++) {
					if (input.charAt(i) < array[i])
						ctrl++;
				}
			}

			if (ctrl != 0)
				result = "The number has too many digits.";
		}

		return result;
	}

	public static String function1(String input) {

		int n = Integer.parseInt(input);
		String result = " ";

		if (n <= 1)
			result = "The number is out of the domain.";

		else {
			result = "Prime numbers from 2 to " + n + " are: ";

			boolean[] array = new boolean[n + 1];

			for (int i = 0; i <= n; i++)
				array[i] = true;

			for (int i = 2; i <= Math.sqrt(n); i++)
				if (array[i])
					for (int j = i * i; j <= n; j += i)
						array[j] = false;

			for (int i = 2; i < n + 1; i++)
				if (array[i])
					result += i + "; ";
		}

		return result;

	}

	public static String function2(String input1, String input2) {

		int n = Integer.parseInt(input1);
		int m = Integer.parseInt(input2);

		String result = " ";

		if (n <= 0 || m <= 0)
			result = "The number is out of the domain.";

		else
			result = "The  greatest common divisor of " + input1 + " and " + input2 + " is: " + gcd(m, n)+".";

		return result;

	}

	public static String function3(String input) {

		int n = Integer.parseInt(input);

		String result = " ";

		if (n <= 0)
			result = "The number is out of the domain.";

		else {

			int count = 0;

			boolean[] array = new boolean[n + 1];

			for (int i = 0; i <= n; i++)
				array[i] = true;

			for (int i = 2; i <= Math.sqrt(n); i++)
				if (array[i])
					for (int j = i * i; j <= n; j += i)
						array[j] = false;

			for (int i = 2; i < n + 1; i++)
				if (array[i])
					count++;
			result = "Number of primes from 2 to " + n + " are: " + count+".";

		}

		return result;

	}

	public static String function4(String input) {

		int n = Integer.parseInt(input);
		int count = 1;
		String result = " ";

		if (n <= 0)
			result = "The number is out of the domain.";

		else {
			for (int i = 2; i < n; i++)
				if (gcd(n, i) == 1)
					count++;

			result = "The Euler’s totient  of " + n + " is " + count+".";

		}

		return result;

	}

	public static String function5(String input) {

		int n = Integer.parseInt(input);

		String result = " ";

		if (n <= 1)
			result = "The number is out of the domain.";

		else {
			result = "The number " + n + " is factorized in: ";

			for (int i = 2; i <= n; i++)
				if (n % i == 0)
					while (n % i == 0) {
						n /= i;
						result += i + "; ";
					}
		}

		return result;

	}

	public static String function6(String input1, String input2) {

		int x = Integer.parseInt(input1);
		int n = Integer.parseInt(input2);
		int sigma = 0;

		String result = " ";

		if (n <= 1 || x < 0)
			result = "The number is out of the domain.";

		else {

			for (int i = 1; i <= n; i++)
				if (n % i == 0)
					sigma += Math.pow(i, x);

			if (sigma == 2147483647)
				result = "The result of the sigma function of " + n + " and " + x + " is more than 2147483647.";

			else
				result = "The result of the sigma function of " + n + " and " + x + " is: " + sigma+".";

		}

		return result;

	}

	public static String function7(String input1, String input2, String input3, String input4) {

		int a = Integer.parseInt(input1);
		int b = Integer.parseInt(input2);
		int m = Integer.parseInt(input3);
		int n = Integer.parseInt(input4);
		int x = 0;

		String result = " ";

		if (n < 1 || m == 0)

			result = "The number is out of the domain.";

		else {

			result = n + " random numbers are: ";

			for (int i = 0; i < n; i++) {
				x = (a * x + b) % m;
				result += x + "; ";
			}
		}
		return result;

	}

	public static String function8(String input) {

		int n = Integer.parseInt(input);
		String result = " ";

		if (n < 1)

			result = "The number is out of the domain.";

		else {
			if (n < 100)
				result = "The partitions of " + n + " are: " + partition(n, n)+".";

			else {

				int part = (int) ((1 / (4 * n * Math.sqrt(3))) * Math.exp(Math.PI * Math.sqrt(2 * n / 3.0)));
				if (part == 2147483647)
					result = "The partitions of " + n + " are more than 2147483647.";
				else
					result = "The partitions of " + n + " are: " + part+".";

			}
		}

		return result;
	}

	public static int partition(int n, int m) {
		if (n == m)
			return 1 + partition(n, m - 1);
		if (m == 0 || n < 0)
			return 0;
		if (n == 0 || m == 1)
			return 1;

		return partition(n, m - 1) + partition(n - m, m);

	}

	public static int gcd(int m, int n) {

		int temp;

		while (m != 0) {
			temp = m;
			m = n % m;
			n = temp;
		}

		return n;

	}

}
