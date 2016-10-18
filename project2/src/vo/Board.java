package vo;

public class Board {
	
	private String boardno;
	private String save_fileno;
	private String title;
	private String content;
	private String memberno;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(String boardno, String save_fileno, String title, String content, String memberno) {
		super();
		this.boardno = boardno;
		this.save_fileno = save_fileno;
		this.title = title;
		this.content = content;
		this.memberno = memberno;
	}

	public String getBoardno() {
		return boardno;
	}

	public void setBoardno(String boardno) {
		this.boardno = boardno;
	}

	public String getSave_fileno() {
		return save_fileno;
	}

	public void setSave_fileno(String save_fileno) {
		this.save_fileno = save_fileno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMemberno() {
		return memberno;
	}

	public void setMemberno(String memberno) {
		this.memberno = memberno;
	}

	@Override
	public String toString() {
		return "Board [boardno=" + boardno + ", save_fileno=" + save_fileno + ", title=" + title + ", content="
				+ content + ", memberno=" + memberno + "]";
	}
	
}