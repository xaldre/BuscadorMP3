package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Recorder {
	private static final int MAX_INTENTOS = 4;
	String folder = "results\\";

	// TODO test
	public void saveTxt(String list, String path) {
		String extension = ".txt";
		save(list, path, extension);
	}

	private void save(String list, String path, String extension) {
		File file = new File(getFileName(path) + extension);
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		if (verifyExists(file)) {
			try {
				fileWriter = new FileWriter(file);
				bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(list);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Cerramos fileWriter
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Cerramos bufferedWritter
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private boolean verifyExists(File file) {
		if (!file.exists()) {
			boolean created = false;
			int intentos = 0;
			do {
				if (intentos > 0) {
					try {
						System.out.println("ERROR: creacción erronea. Esperando 5 segundos para nuevo intento.");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					created = file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (!created && intentos < MAX_INTENTOS);
			return created;
		} else {
			return true;
		}
	}

	// Already tested and validated
	private String getFileName(String path) {
		return path.replace(":", "").replace(" ", "_").replace("\\", " ").trim().replace(" ", ".");
	}

}
