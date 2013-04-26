

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=399
 * @veredict Wrong Answer (Java)  Accepted (C++) 
 * @problemId 458
 * @problemName The Decoder
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 21/12/2011
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva458 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while((linea=bf.readLine())!=null){
			for(int i = 0 ; i < linea.length(); ++i){
				char a = linea.charAt(i);
				int asci = (int) a;
				if( asci == 10 )
					System.out.println();
				else
					System.out.print((char)(asci-7));
			}
			System.out.println();
		}
	}
}

/**
 * Codigo de C++ Aceptado 
 */

//#include <iostream>
//using namespace std;
//
//int main() {
//	string linea;
//	while(getline(cin,linea)){
//		for(int i=0; i<linea.size();i++){
//			if((int) linea[i] == 10)
//				cout << endl;
//			cout << (char)(linea[i]-7);
//		}
//		cout<<endl;
//	}
//	return 0;
//}
