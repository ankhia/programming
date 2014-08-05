

import java.util.Arrays;

public class RobotHerbDiv2 {

	static int Y = 0;
	static int X = 1;
	static int X_ = 3;
	static int Y_ = 2;
	static int dirX[ ] = new int[]{1,0};
	static int dirMX[ ] = new int[]{-1,0};
	static int dirY[ ] = new int[]{0,1};
	static int dirMY[ ] = new int[]{0,-1};
	
	public static void main(String[] args) {
		System.out.println(new RobotHerbDiv2().getdist(5, new int[]{1,1,2}));
	}
	
	public static long getdist(int T, int[] a){
		long[ ] ini = new long[] { 0 , 0 };
		int direccion = Y;
		int t=0,tmp=T;
		while( T-- > 0 ){
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < ini.length; j++) {
					
					if( direccion == Y )
						ini[j] += dirY[j]*a[i];
					else if( direccion == X)
						ini[j] += dirX[j]*a[i];
					else if( direccion == Y_)
						ini[j] += dirMY[j]*a[i];
					else
						ini[j] += dirMX[j]*a[i];
				}
				direccion = (direccion + a[i]) % 4;
			}
			t++;
			if(direccion==Y) break;
		}
		System.out.println(t+" "+Arrays.toString(ini));
		ini[0]*=(tmp/t);
		ini[1]*=(tmp/t);
		for(int h=0;h<tmp%t;h++)
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < ini.length; j++) {
					
					if( direccion == Y )
						ini[j] += dirY[j]*a[i];
					else if( direccion == X)
						ini[j] += dirX[j]*a[i];
					else if( direccion == Y_)
						ini[j] += dirMY[j]*a[i];
					else
						ini[j] += dirMX[j]*a[i];
				}
				direccion = (direccion + a[i]) % 4;
			}
		return Math.abs(ini[0]) + Math.abs(ini[1]);
	}
}


//MI ANTERIOR SOLUCION!!			
//for (int j = 0; j < a[i]; j++) {
//	for (int j2 = 0; j2 < ini.length; j2++) {
//		if( direccion == Y ){
//			ini[ j2 ]+= dirY[j2];
//		}
//		else if( direccion == X ){
//			ini[ j2 ]+= dirX[j2];
//		}else if( direccion == Y_){
//			ini[ j2 ]+= dirMY[j2];
//		}else{
//			ini[ j2 ]+= dirMX[j2];
//		}
//	}
//}
//
//for (int j = 0; j < a[i]; j++) {
//	if( direccion == Y )
//		direccion = X;
//	else if(direccion == X)
//		direccion = Y_;
//	else if(direccion == Y_)
//		direccion = X_;
//	else 
//		direccion = Y;
//}
//}