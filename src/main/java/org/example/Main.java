package org.example;

import javafx.application.Application;
import org.example.ui.FXCopierApplication;

public class Main {

	public static void main(String[] args) {
//		System.out.println("Приложение позволяет совершить копирование файлов из одного католога в другой");
//		Data folders = Enter.enterDirectories();
//		int action = Enter.chooseAction();
//		Handler.doAction(folders, action);
//		new Scanner(System.in).close();
		Application.launch(FXCopierApplication.class, args);
	}
	
}
