package main.com.neo.fox.logic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;

public class Handler {
	private static Folder folderFrom = new Folder();
	private static Folder folderTo = new Folder();

	public static Data process(Directories directories) {
		File from = new File(directories.from);
		File to = new File(directories.to);
		readFolder(from, folderFrom);
		readFolder(to, folderTo);
		return new Data(folderFrom, folderTo);
	}

	private static void readFolder(File file, Folder folder) {
		folder.setName(file.getAbsolutePath());
		File[] list = file.listFiles();
		if (list != null) {
			folder.setFiles(new ArrayList<String>(list.length));
			folder.setFolders(new ArrayList<Folder>(32));
			for (File one : list) {
				if (one.isDirectory()) {
					Folder innerFolder = new Folder();
					folder.getFolders().add(innerFolder);
					readFolder(one, innerFolder);
				} else {
					folder.getFiles().add(one.getName());
				}
			}
		}
	}

	public static void doAction(Data data, int action) {
		switch (action) {
		case 1: copy(data.getSource(), data.getDestination());
		case 2: // TODO
		case 3: // TODO
		}
	}

	public static void copy(Folder from, Folder to) {
		copyFiles(from, to);
		List<Folder> foldersFrom = from.getFolders();
		List<Folder> foldersTo = to.getFolders();
		if (foldersFrom != null) {
			if (foldersTo == null) {
				foldersTo = (new ArrayList<>(foldersFrom.size()));
			}
			for (Folder folderFrom : foldersFrom) {
				boolean forCreation = true;
				for (Folder folderTo : foldersTo) {
					boolean equals = getSimpleName(folderFrom.getName()).equals(getSimpleName(folderTo.getName()));
					if (equals) {
						forCreation = false;
						copy(folderFrom, folderTo);
						break;
					}
				}
				if (forCreation) {
					String folderName = getSimpleName(folderFrom.getName());
					Path pathTo = Path.of(to.getName() + "/" + folderName);
					try {
						Files.createDirectory(pathTo);
						Folder newFolderTo = new Folder();
						newFolderTo.setName(pathTo.toString());
						copy(folderFrom, newFolderTo);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private static String getSimpleName(String string) {
		int i = string.lastIndexOf("\\");
		return string.substring(i);
	}

	private static void copyFiles(Folder from, Folder to) {
		if (from.getFiles() != null) {
			List<String> namesFrom = from.getFiles();
			List<String> namesTo = to.getFiles();
			if (namesTo != null) {
				namesFrom.removeAll(namesTo);
			}
			for (String fileName : namesFrom) {
				Path pathFrom = Path.of(from.getName() + "/" + fileName);
				Path pathTo = Path.of(to.getName() + "/" + fileName);
				try {
					Files.copy(pathFrom, pathTo);
					BasicFileAttributes sourceAttributes = Files.readAttributes(pathFrom, BasicFileAttributes.class);
					FileTime creationTime = sourceAttributes.creationTime();
					FileTime lastAccessTime = sourceAttributes.lastAccessTime();
					FileTime lastModifiedTime = sourceAttributes.lastModifiedTime();
					Files.setAttribute(pathTo, "creationTime", creationTime);
					Files.setAttribute(pathTo, "lastAccessTime", lastAccessTime);
					Files.setAttribute(pathTo, "lastModifiedTime", lastModifiedTime);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
