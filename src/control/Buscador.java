package control;

import java.io.File;
import java.util.StringTokenizer;

public class Buscador {
	ParaUI instancia;
	StringBuilder encontrados;

	public Buscador(ParaUI instancia) {
		super();
		this.instancia = instancia;
	}

	/**
	 * Busca entre el contenido de una ruta especificada por archivos con extension mp3
	 * @param arbol File con la ruta a buscar
	 * @return String con las rutas encontradas o null si no encuentra ninguno
	 */
	public static String buscarMp3(File arbol) {
		StringBuilder encontrados = new StringBuilder();
		String extension = "mp3";
		int previousHash = encontrados.hashCode();
		busquedaRecursiva(arbol, encontrados, extension);
		if (previousHash == encontrados.hashCode()) {
			return null;
		} else {
			return encontrados.toString();
		}
	}
	
	private static void busquedaRecursiva(File arbol, StringBuilder encontrados, String extension) {
		if (arbol.exists() && arbol.list() != null) {
			File[] listFiles = arbol.listFiles();
			for (File file : listFiles) {
				if (file.isDirectory()) {
					if (file.canExecute()) {
						busquedaRecursiva(arbol, encontrados, extension);
					}
				} else {
					StringTokenizer path = new StringTokenizer(file.toString(), "//.");
					int countTokens = path.countTokens();
					for (int i = 0; i < countTokens-1; i++) {
						path.nextToken();
					}
					if (path.nextToken().toString().equals(extension)){
						encontrados.append(" ");
						encontrados.append(file.toString());
					}
					
				}

			}
		}
	}
}
