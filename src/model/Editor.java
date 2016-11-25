package model;

import java.io.Serializable;
import java.util.Date;

public class Editor implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String content;
	private Date date;
	private String header;

	// private String imageLink;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
	//
	// public String getImageLink() {
	// return imageLink;
	// }
	//
	// public void setImageLink(String imageLink) {
	// this.imageLink = imageLink;
	// }

}
