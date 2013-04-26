
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=24&problem=979&mosmsg=Submission+received+with+ID+9584705
 * @veredict Accepted 
 * @problemId 100038
 * @problemName  Jolly Jumpers
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 22/11/2011
 **/

public class Uva10038 {
        private static boolean[] vector ;
        private static int casos;
        public static void main(String ... args) throws IOException{
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                String linea;
                vector = new boolean[3001];
                while((linea=bf.readLine())!=null){
                        Arrays.fill(vector, false);
                        StringTokenizer st = new StringTokenizer(linea);
                        casos = Integer.parseInt(st.nextToken());
                        int[] v = new int[casos];
                        for(int i=0; i<casos;++i){
                                v[i] = Integer.parseInt(st.nextToken());
                        }
                        System.out.println(jolly(v)?"Jolly":"Not jolly");
                }
        }
        public static boolean jolly(int[] v){
                boolean jolly = true;
                if(v.length==1)
                        return jolly;
                else{
                        int contador = 0;
                        for( int i = 0; i < v.length; ++i ){
                                if((i+1)< v.length){
                                        int diferencia = Math.abs(v[i]-(v[i+1]));
                                        if( diferencia > (casos-1) )
                                                return false;
                                        if( diferencia <= (casos-1) && !vector[diferencia]){
                                                vector[diferencia] = true;
                                                contador++;
                                        }
                                }
                        }
                        if(contador == (casos-1))
                                return true;
                        return false;
                }
        }
}