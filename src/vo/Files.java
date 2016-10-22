package vo;

import java.io.File;

public class Files {
	private String save_fileno;
	private String save_file;
	private String save_filename;
	private String memberno;
	private String filetype;
	private String groupno;

	public Files() {
		// TODO Auto-generated constructor stub
	}

	public String getSave_fileno() {
		return save_fileno;
	}

	public void setSave_fileno(String save_fileno) {
		this.save_fileno = save_fileno;
	}

	public String getSave_file() {
		return save_file;
	}

	public void setSave_file(String save_file) {
		this.save_file = save_file;
	}

	public String getSave_filename() {
		return save_filename;
	}

	public void setSave_filename(String save_filename) {
		this.save_filename = save_filename;
	}

	public String getMemberno() {
		return memberno;
	}

	public void setMemberno(String memberno) {
		this.memberno = memberno;
	}


	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getGroupno() {
		return groupno;
	}

	public void setGroupno(String groupno) {
		this.groupno = groupno;
	}

	@Override
	public String toString() {
		return "Files [save_fileno=" + save_fileno + ", save_file=" + save_file + ", save_filename=" + save_filename
				+ ", memberno=" + memberno + ", filetype=" + filetype + "]";
	}	
	
}
