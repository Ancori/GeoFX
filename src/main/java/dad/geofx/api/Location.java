package dad.geofx.api;

import java.util.ArrayList;

public class Location {
	private ArrayList<Languages> languages;
	private String calling_code;

	public ArrayList<Languages> getLanguages() {
		return languages;
	}

	public void setLanguages(ArrayList<Languages> languages) {
		this.languages = languages;
	}

	public String getCalling_code() {
		return calling_code;
	}

	public void setCalling_code(String calling_code) {
		this.calling_code = calling_code;
	}
}
