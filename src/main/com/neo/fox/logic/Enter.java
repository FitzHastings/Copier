package main.com.neo.fox.logic;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Enter {
	private static final Directories DIRRECTORIES = new Directories();

	public static Data enterDirectories() {
		Scanner scanner = new Scanner(System.in);
		DIRRECTORIES.from = specifyFolder(scanner, "Укажите папку из которой нужно совершить копирование:");
		DIRRECTORIES.to = specifyFolder(scanner, "Укажите папку в которую нужно совершить копирование:");
		DIRRECTORIES.from = DIRRECTORIES.from.replace("D:\\Projects\\Eclipse\\Copier\\", "");
		return Handler.process(DIRRECTORIES);
	}

	private static String specifyFolder(Scanner scanner, String message) {
		String input;
		do {
			System.out.print(message);
			input = scanner.nextLine().trim();
		} while (input.isBlank() 
				|| !Files.isDirectory(Path.of(input)) 
				|| input.equals(DIRRECTORIES.from));
		return input;
	}

	public static int chooseAction() {
		Scanner scanner = new Scanner(System.in);
		int input;
		do {
			System.out.print("Выберите желаемое действие: Копировать (1) | Удалить (2) | Синхронизировать (3)\n");
			input = scanner.nextInt();
		} while (!(input < 4 && input > 0));
		return input;
	}

}
