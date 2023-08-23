package main;

import java.util.Scanner;

import main.com.neo.fox.logic.Data;
import main.com.neo.fox.logic.Enter;
import main.com.neo.fox.logic.Handler;

public class Main {

	public static void main(String[] args) {
		System.out.println("Приложение позволяет совершить копирование файлов из одного католога в другой");
		Data folders = Enter.enterDirectories();
		int action = Enter.chooseAction();
		Handler.doAction(folders, action);
		new Scanner(System.in).close();
	}

}
