package com.library.libraryService.modules;

public class Author {
	
	private int authorId;
	private String authorLastName;
	private String authorFirstName;

	public int getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	public String getAuthorLastName() {
		return authorLastName;
	}
	
	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}
	
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorLastName=" + authorLastName + ", authorFirstName="
				+ authorFirstName + "]";
	}
}
