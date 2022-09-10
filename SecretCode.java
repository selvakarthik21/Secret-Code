import java.util.Scanner;
import java.util.Stack;

/**
 * 
 */

/**
 * @author karthikeyan
 *
 */
public class SecretCode {

	/**
	 * @param args
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int re;
		int r, i, xr, xi, br, bi, bb, b, a;

		try (Scanner scanner = new Scanner(System.in)) {
			re = scanner.nextInt();
			StringBuffer buf = new StringBuffer();
			while (re-- > 0) {
				xr = scanner.nextInt();
				xi = scanner.nextInt();
				br = scanner.nextInt();
				bi = scanner.nextInt();

				bb = (br * br) + (bi * bi);
				b = (int) (Math.sqrt((double) bb) - 1e-6);
				Stack<Integer> ans = new Stack<>();
				
				do {
					for (a = 0; a <= b; a++) {
						r = (xr - a) * br - xi * (-bi);
						i = (xr - a) * (-bi) + xi * br;
						if (r % bb == 0 && i % bb == 0) {
							xr = r / bb;
							xi = i / bb;
							ans.push(a);
							break;
						}
					}
					if (a > b || ans.size() > 100) {
						break;
					}
				} while (xr != 0 || xi != 0);
				if (xr != 0 || xi != 0) {
					buf.append("The code cannot be decrypted.\n");
				} else {
					while (!ans.empty()) {
						buf.append(ans.peek());
						ans.pop();
						buf.append(ans.empty() ? '\n' : ',');
					}
				}
				
			}
			System.out.println();
			System.out.println(buf.toString());
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
