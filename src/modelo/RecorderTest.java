package modelo;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Ignore;
import org.junit.Test;

public class RecorderTest {

	@Ignore
	public void testSaveTxt() {
		File file1 = new File("text\\C.txt");
		StringBuilder content1 = new StringBuilder();
		FileReader fr1 = null;
		BufferedReader br1 = null;
		try {
			fr1 = new FileReader(file1);
			br1 = new BufferedReader(fr1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Util.getContent();
	}

	@Ignore
	public void testGetFileName() {
		// TEST VALIDATED!!

		Recorder instancia = new Recorder();
		String path = "C:\\Usuario\\musica\\rock y heavy\\los90";
		// assertEquals("C.Usuario.musica.rock_y_heavy.los90",
		// instancia.getFileName(path));

		String path2 = "C:\\";
		// assertEquals("C", instancia.getFileName(path2));
	}

}
