package control;

import java.io.File;
import java.util.StringTokenizer;

public class Buscador {
	StringBuilder encontrados;

	/**
	 * Busca entre el contenido de una ruta especificada por archivos con
	 * extension mp3
	 * 
	 * @param arbol
	 *            File con la ruta a buscar
	 * @return String con las rutas encontradas o Vacio si no encuentra ninguno
	 */
	public String buscarMp3(File arbol) {
		StringBuilder encontrados = new StringBuilder();
		String extension = "mp3";

		busquedaRecursiva(arbol, encontrados, extension);
		return encontrados.toString();

	}

	private static void busquedaRecursiva(File arbol, StringBuilder encontrados, String extension) {
		if (arbol.exists() && arbol.list() != null) {
			File[] listFiles = arbol.listFiles();
			for (File file : listFiles) {
				if (file.isDirectory()) {
					if (file.canExecute()) {
						busquedaRecursiva(file, encontrados, extension);
					}
				} else {
					StringTokenizer path = new StringTokenizer(file.toString(), "//.");
					int countTokens = path.countTokens();
					for (int i = 0; i < countTokens - 1; i++) {
						path.nextToken();
					}
					if (path.nextToken().toString().equals(extension)) {
						encontrados.append(file.getAbsolutePath().toString()+"\n");
					}

				}

			}
		}
	}
}
