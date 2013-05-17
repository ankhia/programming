import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class InsertCemexSqlele {

	public static String TABLA = "producto";
	public static String[] campos = { "id", "codigo_cemex","nombre","sku","unidad_id","linea_id","marca_id" };
	
	public static TreeMap<String, Integer> marca ;
	
	public static TreeMap<String, Integer> linea ;
	
	public static void main(String[] args) throws Throwable {
		System.out.println("----------------------------------------------------");
		System.out.println(" BEGIN  ");
		BufferedReader in = new BufferedReader(new FileReader("cpilla.csv"));
		linea = new TreeMap<String, Integer>();
		for (String line; (line=in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(line,",");
			String key = st.nextToken();
			int value =  Integer.parseInt(st.nextToken());
			if(!linea.containsKey(key)){
				linea.put(key, value);
			}
		}
		in = new BufferedReader(new FileReader("productos.csv"));
		PrintWriter pw = new PrintWriter("insert.sql");
		StringBuilder sbProducto = new StringBuilder();
		StringBuilder sbMarca = new StringBuilder();
		marca = new TreeMap<String, Integer>();
		int superContador = 1;
		for (String line; (line = in.readLine())!=null; ) {
			
			String[] tokens = line.split("ç");
			String[] valores = new String[campos.length];
			valores[0] = null;
			valores[1] = tokens[0];
			valores[2] = tokens[1];
			valores[3] = "1";
			valores[4] = "1";
			
			valores[5] = linea.get(tokens[2])!=null?linea.get(tokens[2])+"":"1";
			int idMarca = -1;
			String nMarca = tokens[tokens.length-3];
			if(marca.containsKey(nMarca)) {
				idMarca = marca.get(nMarca);
			}
			else {
				marca.put(nMarca, superContador);
				sbMarca.append(insertarRegistros("marca", new String[]{"id","nombre"}, new String[]{marca.get(nMarca)+"", nMarca})+";\n");
				idMarca = marca.get(tokens[tokens.length-3]);
				superContador++;
			}
			valores[6] = idMarca+"";
			sbProducto.append(insertarRegistros(TABLA, campos, valores)+";\n");
		}
		
		pw.println(new String(sbMarca));
		pw.println(new String(sbProducto));
		pw.flush();
		pw.close();
		
		System.out.println(" END :) ");
		System.out.println("----------------------------------------------------");
	}
	
	public static String insertarRegistros( String nombreTabla, String[] camposTabla, String[] valoresTabla ) throws Exception 
	{
		String query = "INSERT INTO " + nombreTabla;
		if( camposTabla != null)
		{
			query += " (";
			for( int i = 0; i < camposTabla.length; ++i ){
				query += camposTabla[i];
				if( i < camposTabla.length-1 )
					query+=",";
			}
			query+=")";
		}
		query += " VALUES (";
		for( int i = 0; i < valoresTabla.length; ++i ){
			if(valoresTabla[i] == null||valoresTabla[i].equals("null"))
				query += "NULL";
			else
				query += "'"+valoresTabla[i]+"'";
			if(i<valoresTabla.length-1)
				query+=",";
		}
		query += ");";
		return query;
	}

}
