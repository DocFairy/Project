package vo;

import java.io.File;

public class Files {
	private String save_fileno;
	private String save_file;
	private String save_filename;
	private String memberno;
	private String isaccountfile;

	public Files() {
		// TODO Auto-generated constructor stub
	}

	public Files(String save_fileno, String save_file, String save_filename, String memberno, String isaccountfile) {
		super();
		this.save_fileno = save_fileno;
		this.save_file = save_file;
		this.save_filename = save_filename;
		this.memberno = memberno;
		this.isaccountfile = isaccountfile;
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

	public String getIsaccountfile() {
		return isaccountfile;
	}

	public void setIsaccountfile(String isaccountfile) {
		this.isaccountfile = isaccountfile;
	}

	@Override
	public String toString() {
		return "Files [save_fileno=" + save_fileno + ", save_file=" + save_file + ", save_filename=" + save_filename
				+ ", memberno=" + memberno + ", isaccountfile=" + isaccountfile + "]";
	}

	
}
