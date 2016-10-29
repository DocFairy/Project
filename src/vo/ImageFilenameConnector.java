package vo;

public class ImageFilenameConnector {
	String save_fileno;
	String imageFilename;
	String save_filename;
	String imageFilenameWithoutType;
	public ImageFilenameConnector() {
		// TODO Auto-generated constructor stub
	}
	

	public ImageFilenameConnector(String save_fileno, String imageFilename, String save_filename,
			String imageFilenameWithoutType) {
		super();
		this.save_fileno = save_fileno;
		this.imageFilename = imageFilename;
		this.save_filename = save_filename;
		this.imageFilenameWithoutType = imageFilenameWithoutType;
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

	public String getImageFilenameWithoutType() {
		return imageFilenameWithoutType;
	}

	public void setImageFilenameWithoutType(String imageFilenameWithoutType) {
		this.imageFilenameWithoutType = imageFilenameWithoutType;
	}


	public String getSave_fileno() {
		return save_fileno;
	}


	public void setSave_fileno(String save_fileno) {
		this.save_fileno = save_fileno;
	}
	
}
