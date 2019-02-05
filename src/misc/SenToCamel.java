/*package misc;

import java.util.ArrayList;
import java.util.Scanner;

public class SenToCamel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		String s = sc.nextLine();
		while(!s.equals("\"")) {
			list.add(s);
			s = sc.nextLine();
		}
		
		for(int i = 0; i < list.size(); i++) {
			String st = list.get(i);
			if(st.length() > 0)
				System.out.println(sen2cam(st));
		}
	}
	private static String sen2cam(String s) {
		s = s.trim();
		StringBuffer sb = new StringBuffer();
		boolean nextCaps = false;
		int j = 0;
		while(!Character.isLetter(s.charAt(j)) && j < s.length())
			j++;
		char c = s.charAt(j);
		sb.append(Character.toLowerCase(c));
		for(int i = j + 1; i < s.length(); i++) {
			c = s.charAt(i);
			if(c == ' ')
				nextCaps = true;
			else {
				if(nextCaps && isValidChar(c)) {
					sb.append(Character.toUpperCase(c));
					nextCaps = false;
				}
				else if(isValidChar(c))
					sb.append(Character.toLowerCase(c));
			}
		
		}
		return new String(sb);
	}
	private static boolean isValidChar(char c) {
		return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
	}
}
*/