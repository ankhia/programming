

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Uva11362 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int casitos = 0; casitos < casos; casitos++) {
			int cant = Integer.parseInt(in.readLine());
			String num[] = new String[cant];
			for (int j = 0; j < num.length; j++)
				num[j]=in.readLine();
			
			Arrays.sort(num, new Comparator<String>() {
				public int compare(String o1, String o2) {
					String n1 = o1.toString();
					String n2 = o2.toString();
					int tam = ((n1.length()<n2.length())?n1.length():n2.length());
					for (int i = 0; i < tam; i++) {
						if(n1.charAt(i)!=n2.charAt(i)) return (n1.charAt(i)-n2.charAt(i));
					}
					return n1.compareTo(n2);
				}
			});
			
//			System.out.println(Arrays.toString(num));
			
//			boolean prefijo = false;
//			for (int i = 0; i < num.length - 1 && !prefijo; i++) {
//				String a = num[i].toString();
//				String b = num[i+1].toString();
//				if( b.startsWith(a) || a.startsWith(b))
//					prefijo = true;
//			}
			
			
			boolean consistente = true;
			for (int i = 0; i < num.length - 1 && consistente; i++) {
				String a = num[i].toString();
				String b = num[i+1].toString();
//				int tama = ((a.length()<b.length())?a.length():b.length());
				boolean prefijo = true;
				for (int j = 0; j < a.length() && prefijo; j++) {
					if(a.charAt(j)!=b.charAt(j))
						prefijo = false;
				}
				if(prefijo)
					consistente = false;
				
			}
			
			if(consistente)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.print(new String(sb));
	}

}
