package modelo;

public class Recorder {
	String folder = "results\\";

	//TODO test
	public void save(String list, String path) {
		String fileName = getFileName(path);
	}

	// Already tested and validated
	private String getFileName(String path) {
		return path.substring(path.indexOf(":") + 1).replace(" ", "_").replace("\\", " ").trim().replace(" ", ".");
	}

}
