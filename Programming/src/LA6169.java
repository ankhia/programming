import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class LA6169 {

	static int [] courses;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line = in.readLine())!= null; ) {
			if(line.equals("0 0 0 0 0 0 0")) break;
			courses = new int[7];
			StringTokenizer st = new StringTokenizer(line);
			for (int i = 0; i < courses.length; i++) {
				courses[i] = Integer.parseInt(st.nextToken());
			}
			sb.append(solve()+"\n");
		}
		System.out.print(new String(sb));
	}
	
	static int solve(){
		int c=0;
		double _012 = 20d;
		double _34 = 25d;
		double _56 = 30d;
		double d = _012;
		for (int i = 0; i < courses.length-1; i++) {
			if( i == 3 )
				d = _34;
			else if( i >= 5 )
				d = _56;
			double quitar = d - (courses[i]%d == 0 ? d : courses[i]%d) ;
			c+= Math.ceil( (courses[i]/d) == 0 ? ( (courses[i]==0 ) ? 0 : 1 ) : courses[i]/d );
			courses[i+1]-= (int) Math.min(courses[i+1], quitar);
		}
		c+=Math.ceil(courses[courses.length-1]/d);
		return c;
	}
}
