package control;

import java.io.File;
import java.util.StringTokenizer;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class Buscador {
	StringBuilder encontrados;

	/**
	 * Busca entre el contenido de una ruta especificada por archivos con
	 * extension mp3 y los añade a un documento
	 * 
	 * @param arbol
	 *            File con la ruta a buscar
	 * @param document
	 *            Documento al que añadir las incurrencias obtenidas mediante la
	 *            busqueda
	 */
	public void buscarMp3(File arbol, Document document) {
		StringBuilder encontrados = new StringBuilder();
		busquedaRecursiva(arbol, encontrados, "mp3", document);
	}

	private static void busquedaRecursiva(File arbol, StringBuilder encontrados, String extension, Document document) {
		if (arbol.exists() && arbol.list() != null) {
			File[] listFiles = arbol.listFiles();
			for (File file : listFiles) {
				if (file.isDirectory()) {
					if (file.canExecute()) {
						busquedaRecursiva(file, encontrados, extension, document);
					}
				} else {
					StringTokenizer path = new StringTokenizer(file.toString(), "//.");
					int countTokens = path.countTokens();
					for (int i = 0; i < countTokens - 1; i++) {
						path.nextToken();
					}
					if (path.nextToken().toString().equals(extension)) {
						try {
							document.insertString(document.getLength(), file.getAbsolutePath().toString() + "\n", null);
						} catch (BadLocationException exc) {
							exc.printStackTrace();
						}
					}

				}

			}
		}
	}
}
