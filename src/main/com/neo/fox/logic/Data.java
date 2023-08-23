package main.com.neo.fox.logic;

public class Data {
	private final Folder source;
	private final Folder destination;
	
	public Data(Folder source, Folder destination) {
		this.source = source;
		this.destination = destination;
	}

	public Folder getSource() {
		return source;
	}
	
	public Folder getDestination() {
		return destination;
	}
	
	
	

}
