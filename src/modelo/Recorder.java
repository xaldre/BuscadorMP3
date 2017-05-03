package modelo;

public class Recorder {
	String folder = "results\\";

	public void save(String list, String path) {
		String fileName = getFileName(path);
	}

	//TODO make private after test
	public String getFileName(String path) {
		return path.substring(path.indexOf(":")+1).replace("\\", "");
	}	

}
