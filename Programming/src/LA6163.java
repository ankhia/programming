import java.io.BufferedReader;
import java.io.InputStreamReader;


public class LA6163 {

	static int a ;
	static int b ;
	static int c ;
	static int d ; 
	static char op[] = {'+','-','/','*'};
	static int[]nu ;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line ; (line = in.readLine())!=null;) {
			int n = Integer.parseInt(line);
			if(n == 0)break;
			for (int tc = 0; tc < n; tc++) {
				nu = new int[4];
				line = in.readLine();
				a = Integer.parseInt(line.charAt(0)+"");
				b = Integer.parseInt(line.charAt(1)+"");
				c = Integer.parseInt(line.charAt(2)+"");
				d = Integer.parseInt(line.charAt(3)+"");
				
				for (int i = 0; i < op.length; i++) {
					for (int j = 0; j < op.length; j++) {
						for (int j2 = 0; j2 < op.length; j2++) {
							
						}
					}
				}
			}
		}
	}

}







//
//static boolean mm( char op1, char op2, char op3 ){
//	
//	if( op1 == '+' ){
//		if( op2 == '*' ){
//			if( op3 == '/' ){
//				// a + b * c / d 
//				if( (a+(b*c)/d) == 10 ) return true;
//				else if ( a+b*(c/d) == 10) return true;
//				else if ( (a+b)*c/d == 10) return true;
//				else if ( a+(b*c/d) == 10) return true;
//				else if ( (a+b*c)/d == 10) return true;
//				else return (a+b)*(c/d)==10;
//			}else if( op3 == '-' ){
//				// a + b * c - d 
//				if( (a+(b*c)-d) == 10 ) return true;
//				else if ( a+b*(c-d) == 10) return true;
//				else if ( (a+b)*c-d == 10) return true;
//				else if ( a+(b*c-d) == 10) return true;
//				else if ( (a+b*c)-d == 10) return true;
//				else return (a+b)*(c-d)==10;
//			}else if( op3 == '*' ){
//				// a + b * c * d 
//				if( (a+(b*c)*d) == 10 ) return true;
//				else if ( a+b*(c*d) == 10) return true;
//				else if ( (a+b)*c*d == 10) return true;
//				else if ( a+(b*c*d) == 10) return true;
//				else if ( (a+b*c)*d == 10) return true;
//				else return (a+b)*(c*d)==10;
//			}else if( op3 == '+' ){
//				// a + b * c + d 
//				if( (a+(b*c)+d) == 10 ) return true;
//				else if ( a+b*(c+d) == 10) return true;
//				else if ( (a+b)*c+d == 10) return true;
//				else if ( a+(b*c+d) == 10) return true;
//				else if ( (a+b*c)+d == 10) return true;
//				else return (a+b)*(c+d)==10;
//			}
//		}else if( op2 == '/' ){
//			if( op3 == '/' ){
//				// a + b / c / d 
//				if( (a+(b/c)/d) == 10 ) return true;
//				else if ( a+b/(c/d) == 10) return true;
//				else if ( (a+b)/c/d == 10) return true;
//				else if ( a+(b/c/d) == 10) return true;
//				else if ( (a+b/c)/d == 10) return true;
//				else return (a+b)/(c/d)==10;
//			}else if( op3 == '-' ){
//				// a + b / c - d 
//				if( (a+(b/c)-d) == 10 ) return true;
//				else if ( a+b/(c-d) == 10) return true;
//				else if ( (a+b)/c-d == 10) return true;
//				else if ( a+(b/c-d) == 10) return true;
//				else if ( (a+b/c)-d == 10) return true;
//				else return (a+b)/(c-d)==10;
//			}else if( op3 == '*' ){
//				// a + b / c * d 
//				if( (a+(b/c)*d) == 10 ) return true;
//				else if ( a+b/(c*d) == 10) return true;
//				else if ( (a+b)/c*d == 10) return true;
//				else if ( a+(b/c*d) == 10) return true;
//				else if ( (a+b/c)*d == 10) return true;
//				else return (a+b)/(c*d)==10;
//			}else if( op3 == '+' ){
//				// a + b / c + d 
//				if( (a+(b/c)+d) == 10 ) return true;
//				else if ( a+b/(c+d) == 10) return true;
//				else if ( (a+b)/c+d == 10) return true;
//				else if ( a+(b/c+d) == 10) return true;
//				else if ( (a+b/c)+d == 10) return true;
//				else return (a+b)/(c+d)==10;
//			}
//		}else if( op2 == '-' ){
//			if( op3 == '/' ){
//				// a + b - c / d 
//				if( (a+(b-c)/d) == 10 ) return true;
//				else if ( a+b-(c/d) == 10) return true;
//				else if ( (a+b)-c/d == 10) return true;
//				else if ( a+(b-c/d) == 10) return true;
//				else if ( (a+b-c)/d == 10) return true;
//				else return (a+b)-(c/d)==10;
//			}else if( op3 == '-' ){
//				// a + b - c - d 
//				if( (a+(b-c)-d) == 10 ) return true;
//				else if ( a+b-(c-d) == 10) return true;
//				else if ( (a+b)-c-d == 10) return true;
//				else if ( a+(b-c-d) == 10) return true;
//				else if ( (a+b-c)-d == 10) return true;
//				else return (a+b)-(c-d)==10;
//			}else if( op3 == '*' ){
//				// a + b - c * d 
//				if( (a+(b-c)*d) == 10 ) return true;
//				else if ( a+b-(c*d) == 10) return true;
//				else if ( (a+b)-c*d == 10) return true;
//				else if ( a+(b-c*d) == 10) return true;
//				else if ( (a+b-c)*d == 10) return true;
//				else return (a+b)-(c*d)==10;
//			}else if( op3 == '+' ){
//				// a + b - c + d 
//				if( (a+(b-c)+d) == 10 ) return true;
//				else if ( a+b-(c+d) == 10) return true;
//				else if ( (a+b)-c+d == 10) return true;
//				else if ( a+(b-c+d) == 10) return true;
//				else if ( (a+b-c)+d == 10) return true;
//				else return (a+b)-(c+d)==10;
//			}
//		}else if( op2 == '+' ){
//			if( op3 == '/' ){
//				// a + b + c / d 
//				if( (a+(b+c)/d) == 10 ) return true;
//				else if ( a+b+(c/d) == 10) return true;
//				else if ( (a+b)+c/d == 10) return true;
//				else if ( a+(b+c/d) == 10) return true;
//				else if ( (a+b+c)/d == 10) return true;
//				else return (a+b)+(c/d)==10;
//			}else if( op3 == '-' ){
//				// a + b + c - d 
//				if( (a+(b+c)-d) == 10 ) return true;
//				else if ( a+b+(c-d) == 10) return true;
//				else if ( (a+b)+c-d == 10) return true;
//				else if ( a+(b+c-d) == 10) return true;
//				else if ( (a+b+c)-d == 10) return true;
//				else return (a+b)+(c-d)==10;
//			}else if( op3 == '*' ){
//				// a + b + c * d 
//				if( (a+(b-c)*d) == 10 ) return true;
//				else if ( a+b+(c*d) == 10) return true;
//				else if ( (a+b)+c*d == 10) return true;
//				else if ( a+(b+c*d) == 10) return true;
//				else if ( (a+b+c)*d == 10) return true;
//				else return (a+b)+(c*d)==10;
//			}else if( op3 == '+' ){
//				// a + b + c + d 
//				if( (a+(b-c)+d) == 10 ) return true;
//				else if ( a+b+(c+d) == 10) return true;
//				else if ( (a+b)+c+d == 10) return true;
//				else if ( a+(b+c+d) == 10) return true;
//				else if ( (a+b+c)+d == 10) return true;
//				else return (a+b)+(c+d)==10;
//			}
//		}
//	}else if( op1 == '*' ){
//		if( op2 == '*' ){
//			if( op3 == '/' ){
//				// a * b * c / d 
//				if( (a*(b*c)/d) == 10 ) return true;
//				else if ( a*b*(c/d) == 10) return true;
//				else if ( (a*b)*c/d == 10) return true;
//				else if ( a*(b*c/d) == 10) return true;
//				else if ( (a*b*c)/d == 10) return true;
//				else return (a*b)*(c/d)==10;
//			}else if( op3 == '-' ){
//				// a + b * c - d 
//				if( (a*(b*c)-d) == 10 ) return true;
//				else if ( a*b*(c-d) == 10) return true;
//				else if ( (a*b)*c-d == 10) return true;
//				else if ( a*(b*c-d) == 10) return true;
//				else if ( (a*b*c)-d == 10) return true;
//				else return (a*b)*(c-d)==10;
//			}else if( op3 == '*' ){
//				// a + b * c * d 
//				if( (a*(b*c)*d) == 10 ) return true;
//				else if ( a*b*(c*d) == 10) return true;
//				else if ( (a*b)*c*d == 10) return true;
//				else if ( a*(b*c*d) == 10) return true;
//				else if ( (a*b*c)*d == 10) return true;
//				else return (a*b)*(c*d)==10;
//			}else if( op3 == '+' ){
//				// a + b * c + d 
//				if( (a+(b*c)+d) == 10 ) return true;
//				else if ( a*b*(c+d) == 10) return true;
//				else if ( (a*b)*c+d == 10) return true;
//				else if ( a*(b*c+d) == 10) return true;
//				else if ( (a*b*c)+d == 10) return true;
//				else return (a*b)*(c+d)==10;
//			}
//		}else if( op2 == '/' ){
//			if( op3 == '/' ){
//				// a + b / c / d 
//				if( (a*(b/c)/d) == 10 ) return true;
//				else if ( a*b/(c/d) == 10) return true;
//				else if ( (a*b)/c/d == 10) return true;
//				else if ( a*(b/c/d) == 10) return true;
//				else if ( (a*b/c)/d == 10) return true;
//				else return (a*b)/(c/d)==10;
//			}else if( op3 == '-' ){
//				// a * b / c - d 
//				if( (a*(b/c)-d) == 10 ) return true;
//				else if ( a*b/(c-d) == 10) return true;
//				else if ( (a*b)/c-d == 10) return true;
//				else if ( a*(b/c-d) == 10) return true;
//				else if ( (a*b/c)-d == 10) return true;
//				else return (a*b)/(c-d)==10;
//			}else if( op3 == '*' ){
//				// a + b / c * d 
//				if( (a*(b/c)*d) == 10 ) return true;
//				else if ( a*b/(c*d) == 10) return true;
//				else if ( (a*b)/c*d == 10) return true;
//				else if ( a*(b/c*d) == 10) return true;
//				else if ( (a*b/c)*d == 10) return true;
//				else return (a*b)/(c*d)==10;
//			}else if( op3 == '+' ){
//				// a + b / c + d 
//				if( (a*(b/c)+d) == 10 ) return true;
//				else if ( a*b/(c+d) == 10) return true;
//				else if ( (a*b)/c+d == 10) return true;
//				else if ( a*(b/c+d) == 10) return true;
//				else if ( (a*b/c)+d == 10) return true;
//				else return (a*b)/(c+d)==10;
//			}
//		}else if( op2 == '-' ){
//			if( op3 == '/' ){
//				// a * b - c / d 
//				if( (a*(b-c)/d) == 10 ) return true;
//				else if ( a*b-(c/d) == 10) return true;
//				else if ( (a*b)-c/d == 10) return true;
//				else if ( a*(b-c/d) == 10) return true;
//				else if ( (a*b-c)/d == 10) return true;
//				else return (a*b)-(c/d)==10;
//			}else if( op3 == '-' ){
//				// a * b - c - d 
//				if( (a*(b-c)-d) == 10 ) return true;
//				else if ( a*b-(c-d) == 10) return true;
//				else if ( (a*b)-c-d == 10) return true;
//				else if ( a*(b-c-d) == 10) return true;
//				else if ( (a*b-c)-d == 10) return true;
//				else return (a*b)-(c-d)==10;
//			}else if( op3 == '*' ){
//				// a * b - c * d 
//				if( (a*(b-c)*d) == 10 ) return true;
//				else if ( a*b-(c*d) == 10) return true;
//				else if ( (a*b)-c*d == 10) return true;
//				else if ( a*(b-c*d) == 10) return true;
//				else if ( (a*b-c)*d == 10) return true;
//				else return (a*b)-(c*d)==10;
//			}else if( op3 == '+' ){
//				// a * b - c + d 
//				if( (a*(b-c)+d) == 10 ) return true;
//				else if ( a*b-(c+d) == 10) return true;
//				else if ( (a*b)-c+d == 10) return true;
//				else if ( a*(b-c+d) == 10) return true;
//				else if ( (a*b-c)+d == 10) return true;
//				else return (a*b)-(c+d)==10;
//			}
//		}else if( op2 == '+' ){
//			if( op3 == '/' ){
//				// a + b + c / d 
//				if( (a*(b+c)/d) == 10 ) return true;
//				else if ( a*b+(c/d) == 10) return true;
//				else if ( (a*b)+c/d == 10) return true;
//				else if ( a*(b+c/d) == 10) return true;
//				else if ( (a*b+c)/d == 10) return true;
//				else return (a*b)+(c/d)==10;
//			}else if( op3 == '-' ){
//				// a * b + c - d 
//				if( (a*(b+c)-d) == 10 ) return true;
//				else if ( a*b+(c-d) == 10) return true;
//				else if ( (a*b)+c-d == 10) return true;
//				else if ( a*(b+c-d) == 10) return true;
//				else if ( (a*b+c)-d == 10) return true;
//				else return (a*b)+(c-d)==10;
//			}else if( op3 == '*' ){
//				// a + b + c * d 
//				if( (a*(b-c)*d) == 10 ) return true;
//				else if ( a*b+(c*d) == 10) return true;
//				else if ( (a*b)+c*d == 10) return true;
//				else if ( a*(b+c*d) == 10) return true;
//				else if ( (a*b+c)*d == 10) return true;
//				else return (a*b)+(c*d)==10;
//			}else if( op3 == '+' ){
//				// a + b + c + d 
//				if( (a*(b-c)+d) == 10 ) return true;
//				else if ( a*b+(c+d) == 10) return true;
//				else if ( (a*b)+c+d == 10) return true;
//				else if ( a*(b+c+d) == 10) return true;
//				else if ( (a*b+c)+d == 10) return true;
//				else return (a*b)+(c+d)==10;
//			}
//		}
//		
//	}else if( op1 == '/' ){
//		if( op2 == '*' ){
//			if( op3 == '/' ){
//				// a * b * c / d 
//				if( (a/(b*c)/d) == 10 ) return true;
//				else if ( a/b*(c/d) == 10) return true;
//				else if ( (a/b)*c/d == 10) return true;
//				else if ( a/(b*c/d) == 10) return true;
//				else if ( (a/b*c)/d == 10) return true;
//				else return (a/b)*(c/d)==10;
//			}else if( op3 == '-' ){
//				// a + b * c - d 
//				if( (a/(b*c)-d) == 10 ) return true;
//				else if ( a/b*(c-d) == 10) return true;
//				else if ( (a/b)*c-d == 10) return true;
//				else if ( a/(b*c-d) == 10) return true;
//				else if ( (a/b*c)-d == 10) return true;
//				else return (a/b)*(c-d)==10;
//			}else if( op3 == '*' ){
//				// a + b * c * d 
//				if( (a/(b*c)*d) == 10 ) return true;
//				else if ( a/b*(c*d) == 10) return true;
//				else if ( (a/b)*c*d == 10) return true;
//				else if ( a/(b*c*d) == 10) return true;
//				else if ( (a/b*c)*d == 10) return true;
//				else return (a/b)*(c*d)==10;
//			}else if( op3 == '+' ){
//				// a + b * c + d 
//				if( (a/(b*c)+d) == 10 ) return true;
//				else if ( a/b*(c+d) == 10) return true;
//				else if ( (a/b)*c+d == 10) return true;
//				else if ( a/(b*c+d) == 10) return true;
//				else if ( (a/b*c)+d == 10) return true;
//				else return (a/b)*(c+d)==10;
//			}
//		}else if( op2 == '/' ){
//			if( op3 == '/' ){
//				// a + b / c / d 
//				if( (a/(b/c)/d) == 10 ) return true;
//				else if ( a/b/(c/d) == 10) return true;
//				else if ( (a/b)/c/d == 10) return true;
//				else if ( a/(b/c/d) == 10) return true;
//				else if ( (a*b/c)/d == 10) return true;
//				else return (a/b)/(c/d)==10;
//			}else if( op3 == '-' ){
//				// a/ b / c - d 
//				if( (a/(b/c)-d) == 10 ) return true;
//				else if ( a/b/(c-d) == 10) return true;
//				else if ( (a/b)/c-d == 10) return true;
//				else if ( a/(b/c-d) == 10) return true;
//				else if ( (a/b/c)-d == 10) return true;
//				else return (a/b)/(c-d)==10;
//			}else if( op3 == '*' ){
//				// a + b / c * d 
//				if( (a/(b/c)*d) == 10 ) return true;
//				else if ( a/b/(c*d) == 10) return true;
//				else if ( (a/b)/c*d == 10) return true;
//				else if ( a/(b/c*d) == 10) return true;
//				else if ( (a/b/c)*d == 10) return true;
//				else return (a/b)/(c*d)==10;
//			}else if( op3 == '+' ){
//				// a / b / c + d 
//				if( (a/(b/c)+d) == 10 ) return true;
//				else if ( a/b/(c+d) == 10) return true;
//				else if ( (a/b)/c+d == 10) return true;
//				else if ( a/(b/c+d) == 10) return true;
//				else if ( (a/b/c)+d == 10) return true;
//				else return (a/b)/(c+d)==10;
//			}
//		}else if( op2 == '-' ){
//			if( op3 == '/' ){
//				// a / b - c / d 
//				if( (a/(b-c)/d) == 10 ) return true;
//				else if ( a/b-(c/d) == 10) return true;
//				else if ( (a/b)-c/d == 10) return true;
//				else if ( a/(b-c/d) == 10) return true;
//				else if ( (a/b-c)/d == 10) return true;
//				else return (a/b)-(c/d)==10;
//			}else if( op3 == '-' ){
//				// a * b - c - d 
//				if( (a/(b-c)-d) == 10 ) return true;
//				else if ( a/b-(c-d) == 10) return true;
//				else if ( (a/b)-c-d == 10) return true;
//				else if ( a/(b-c-d) == 10) return true;
//				else if ( (a/b-c)-d == 10) return true;
//				else return (a/b)-(c-d)==10;
//			}else if( op3 == '*' ){
//				// a * b - c * d 
//				if( (a/(b-c)*d) == 10 ) return true;
//				else if ( a/b-(c*d) == 10) return true;
//				else if ( (a/b)-c*d == 10) return true;
//				else if ( a/(b-c*d) == 10) return true;
//				else if ( (a/b-c)*d == 10) return true;
//				else return (a/b)-(c*d)==10;
//			}else if( op3 == '+' ){
//				// a * b - c + d 
//				if( (a/(b-c)+d) == 10 ) return true;
//				else if ( a/b-(c+d) == 10) return true;
//				else if ( (a/b)-c+d == 10) return true;
//				else if ( a/(b-c+d) == 10) return true;
//				else if ( (a/b-c)+d == 10) return true;
//				else return (a/b)-(c+d)==10;
//			}
//		}else if( op2 == '+' ){
//			if( op3 == '/' ){
//				// a + b + c / d 
//				if( (a/(b+c)/d) == 10 ) return true;
//				else if ( a/b+(c/d) == 10) return true;
//				else if ( (a/b)+c/d == 10) return true;
//				else if ( a/(b+c/d) == 10) return true;
//				else if ( (a/b+c)/d == 10) return true;
//				else return (a/b)+(c/d)==10;
//			}else if( op3 == '-' ){
//				// a * b + c - d 
//				if( (a/(b+c)-d) == 10 ) return true;
//				else if ( a/b+(c-d) == 10) return true;
//				else if ( (a/b)+c-d == 10) return true;
//				else if ( a/(b+c-d) == 10) return true;
//				else if ( (a/b+c)-d == 10) return true;
//				else return (a/b)+(c-d)==10;
//			}else if( op3 == '*' ){
//				// a + b + c * d 
//				if( (a/(b-c)*d) == 10 ) return true;
//				else if ( a/b+(c*d) == 10) return true;
//				else if ( (a/b)+c*d == 10) return true;
//				else if ( a/(b+c*d) == 10) return true;
//				else if ( (a/b+c)*d == 10) return true;
//				else return (a/b)+(c*d)==10;
//			}else if( op3 == '+' ){
//				// a + b + c + d 
//				if( (a/(b-c)+d) == 10 ) return true;
//				else if ( a/b+(c+d) == 10) return true;
//				else if ( (a/b)+c+d == 10) return true;
//				else if ( a/(b+c+d) == 10) return true;
//				else if ( (a/b+c)+d == 10) return true;
//				else return (a/b)+(c+d)==10;
//			}
//		}
//	}else if( op1 == '-' ){
//		if( op2 == '*' ){
//			if( op3 == '/' ){
//				// a * b * c / d 
//				if( (a-(b*c)/d) == 10 ) return true;
//				else if ( a-b*(c/d) == 10) return true;
//				else if ( (a-b)*c/d == 10) return true;
//				else if ( a-(b*c/d) == 10) return true;
//				else if ( (a-b*c)/d == 10) return true;
//				else return (a-b)*(c/d)==10;
//			}else if( op3 == '-' ){
//				// a + b * c - d 
//				if( (a-(b*c)-d) == 10 ) return true;
//				else if ( a-b*(c-d) == 10) return true;
//				else if ( (a-b)*c-d == 10) return true;
//				else if ( a-(b*c-d) == 10) return true;
//				else if ( (a-b*c)-d == 10) return true;
//				else return (a-b)*(c-d)==10;
//			}else if( op3 == '*' ){
//				// a + b * c * d 
//				if( (a-(b*c)*d) == 10 ) return true;
//				else if ( a-b*(c*d) == 10) return true;
//				else if ( (a-b)*c*d == 10) return true;
//				else if ( a-(b*c*d) == 10) return true;
//				else if ( (a-b*c)*d == 10) return true;
//				else return (a-b)*(c*d)==10;
//			}else if( op3 == '+' ){
//				// a + b * c + d 
//				if( (a-(b*c)+d) == 10 ) return true;
//				else if ( a-b*(c+d) == 10) return true;
//				else if ( (a-b)*c+d == 10) return true;
//				else if ( a-(b*c+d) == 10) return true;
//				else if ( (a-b*c)+d == 10) return true;
//				else return (a-b)*(c+d)==10;
//			}
//		}else if( op2 == '/' ){
//			if( op3 == '/' ){
//				// a + b / c / d 
//				if( (a-(b/c)/d) == 10 ) return true;
//				else if ( a-b/(c/d) == 10) return true;
//				else if ( (a-b)/c/d == 10) return true;
//				else if ( a-(b/c/d) == 10) return true;
//				else if ( (a-b/c)/d == 10) return true;
//				else return (a-b)/(c/d)==10;
//			}else if( op3 == '-' ){
//				// a * b / c - d 
//				if( (a-(b/c)-d) == 10 ) return true;
//				else if ( a-b/(c-d) == 10) return true;
//				else if ( (a-b)/c-d == 10) return true;
//				else if ( a-(b/c-d) == 10) return true;
//				else if ( (a-b/c)-d == 10) return true;
//				else return (a-b)/(c-d)==10;
//			}else if( op3 == '*' ){
//				// a + b / c * d 
//				if( (a-(b/c)*d) == 10 ) return true;
//				else if ( a-b/(c*d) == 10) return true;
//				else if ( (a-b)/c*d == 10) return true;
//				else if ( a-(b/c*d) == 10) return true;
//				else if ( (a-b/c)*d == 10) return true;
//				else return (a-b)/(c*d)==10;
//			}else if( op3 == '+' ){
//				// a + b / c + d 
//				if( (a-(b/c)+d) == 10 ) return true;
//				else if ( a-b/(c+d) == 10) return true;
//				else if ( (a-b)/c+d == 10) return true;
//				else if ( a-(b/c+d) == 10) return true;
//				else if ( (a-b/c)+d == 10) return true;
//				else return (a-b)/(c+d)==10;
//			}
//		}else if( op2 == '-' ){
//			if( op3 == '/' ){
//				// a * b - c / d 
//				if( (a-(b-c)/d) == 10 ) return true;
//				else if ( a-b-(c/d) == 10) return true;
//				else if ( (a-b)-c/d == 10) return true;
//				else if ( a-(b-c/d) == 10) return true;
//				else if ( (a-b-c)/d == 10) return true;
//				else return (a-b)-(c/d)==10;
//			}else if( op3 == '-' ){
//				// a * b - c - d 
//				if( (a-(b-c)-d) == 10 ) return true;
//				else if ( a-b-(c-d) == 10) return true;
//				else if ( (a-b)-c-d == 10) return true;
//				else if ( a-(b-c-d) == 10) return true;
//				else if ( (a-b-c)-d == 10) return true;
//				else return (a*b)-(c-d)==10;
//			}else if( op3 == '*' ){
//				// a * b - c * d 
//				if( (a-(b-c)*d) == 10 ) return true;
//				else if ( a-b-(c*d) == 10) return true;
//				else if ( (a-b)-c*d == 10) return true;
//				else if ( a-(b-c*d) == 10) return true;
//				else if ( (a-b-c)*d == 10) return true;
//				else return (a-b)-(c*d)==10;
//			}else if( op3 == '+' ){
//				// a * b - c + d 
//				if( (a-(b-c)+d) == 10 ) return true;
//				else if ( a-b-(c+d) == 10) return true;
//				else if ( (a-b)-c+d == 10) return true;
//				else if ( a-(b-c+d) == 10) return true;
//				else if ( (a-b-c)+d == 10) return true;
//				else return (a-b)-(c+d)==10;
//			}
//		}else if( op2 == '+' ){
//			if( op3 == '/' ){
//				// a + b + c / d 
//				if( (a-(b+c)/d) == 10 ) return true;
//				else if ( a-b+(c/d) == 10) return true;
//				else if ( (a-b)+c/d == 10) return true;
//				else if ( a-(b+c/d) == 10) return true;
//				else if ( (a-b+c)/d == 10) return true;
//				else return (a-b)+(c/d)==10;
//			}else if( op3 == '-' ){
//				// a * b + c - d 
//				if( (a-(b+c)-d) == 10 ) return true;
//				else if ( a-b+(c-d) == 10) return true;
//				else if ( (a-b)+c-d == 10) return true;
//				else if ( a-(b+c-d) == 10) return true;
//				else if ( (a-b+c)-d == 10) return true;
//				else return (a-b)+(c-d)==10;
//			}else if( op3 == '*' ){
//				// a + b + c * d 
//				if( (a-(b-c)*d) == 10 ) return true;
//				else if ( a-b+(c*d) == 10) return true;
//				else if ( (a-b)+c*d == 10) return true;
//				else if ( a-(b+c*d) == 10) return true;
//				else if ( (a-b+c)*d == 10) return true;
//				else return (a-b)+(c*d)==10;
//			}else if( op3 == '+' ){
//				// a + b + c + d 
//				if( (a-(b-c)+d) == 10 ) return true;
//				else if ( a-b+(c+d) == 10) return true;
//				else if ( (a-b)+c+d == 10) return true;
//				else if ( a-(b+c+d) == 10) return true;
//				else if ( (a-b+c)+d == 10) return true;
//				else return (a-b)+(c+d)==10;
//			}
//		}
//	}
//	return false;
//}