import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Acm5739 {

	static Set<String> names ;
	static String[] tmpName ;
	static int max;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int tc = 1;
		for (String line; (line = in.readLine())!=null; tc++) {
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken( ));
			int m = Integer.parseInt(st.nextToken( ));
			if( n==0 && m == 0 )break;
			sb.append("Case "+tc+"\n");
			max = m;
			names = new TreeSet<String>( );
			for (int i = 0; i < n; i++) {
				String name = in.readLine();
				name = name.trim();
				tmpName = name.split(" ");
				sb.append( solve( )+"\n" );
			}
		}
		System.out.print(new String(sb));
	}

	public static String solve(  ){
		String nName = "";
		nName+=Character.toLowerCase(tmpName[0].charAt(0));
		String lastName = tmpName[tmpName.length-1];
		for (int i = 0; i < lastName.length( ); i++) {
			char act = lastName.charAt(i);
			if(Character.isLetter(act))
				nName+=Character.toLowerCase(act);
		}
		if( nName.length() > max )
			nName = nName.substring(0, max);

		if( !names.contains( nName ) ){
			names.add( nName );
			return nName;
		}else{
			String copyName = nName;
			boolean exista = true;
			int num = 1;
			String numTam = "1";
			while ( exista && num < 10) {
				if( nName.length() == max )
					nName = copyName.substring(0, max-numTam.length());
				else
					nName = copyName;
				nName += (num+"");
				num++;
				numTam = num+"";
				exista = names.contains(nName);
			}
			while ( exista ) {
				if( nName.length() == max )
					nName = copyName.substring(0, max-numTam.length());
				else
					nName = copyName;
				nName += (num+"");
				num++;
				numTam = num+"";
				exista = names.contains(nName);
			}
			names.add( nName );
			return nName;
		}
	}			
}
