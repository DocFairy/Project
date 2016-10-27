package vo;

public class ImageFilenameConnector {
	String imageFilename;
	String save_filename;
	public ImageFilenameConnector() {
		// TODO Auto-generated constructor stub
	}
	
	public ImageFilenameConnector(String imageFilename, String save_filename) {
		super();
		this.imageFilename = imageFilename;
		this.save_filename = save_filename;
	}

	public String getImageFilename() {
		return imageFilename;
	}
	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}
	public String getSave_filename() {
		return save_filename;
	}
	public void setSave_filename(String save_filename) {
		this.save_filename = save_filename;
	}
	
}
