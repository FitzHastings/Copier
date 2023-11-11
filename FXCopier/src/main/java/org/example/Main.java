package org.example;

import java.util.Scanner;

import org.example.logic.Data;
import org.example.logic.Enter;
import org.example.logic.Handler;

public class Main {

	public static void main(String[] args) {
		System.out.println("Приложение позволяет совершить копирование файлов из одного католога в другой");
		Data folders = Enter.enterDirectories();
		int action = Enter.chooseAction();
		Handler.doAction(folders, action);
		new Scanner(System.in).close();
	}
	
}
