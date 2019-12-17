package com.library.libraryService.modules;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about a book author")
public class Author {

	@ApiModelProperty(notes = "The primary key, unique id")
	private int authorId;
	@ApiModelProperty(notes = "The last name of the author")
	private String authorLastName;
	@ApiModelProperty(notes = "The first name of the author")
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
