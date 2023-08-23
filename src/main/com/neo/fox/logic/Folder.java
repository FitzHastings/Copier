package main.com.neo.fox.logic;

import java.util.List;

public class Folder {
	private String name;
	private List<String> files;
	private List<Folder> folders;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getFiles() {
		return files;
	}
	
	public void setFiles(List<String> files) {
		this.files = files;
	}
	
	public List<Folder> getFolders() {
		return folders;
	}
	
	public void setFolders(List<Folder> folders) {
		this.folders = folders;
	}

	@Override
	public String toString() {
		return "Folder [name=" + name + ", files=" + files + ", folders=" + folders + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
