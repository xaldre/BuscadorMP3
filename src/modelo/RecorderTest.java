package modelo;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class RecorderTest {

	@Ignore
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFileName() {
		Recorder instancia = new Recorder();
		String path = "C:\\Usuario\\musica";
		assertEquals("Usuariomusica", instancia.getFileName(path));
		
	}

}
