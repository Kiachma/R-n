// -*- java -*-
//
// Ignore this file until you start working with the last part of the assigment
//
// This is an example Main java that uses Spring dependency injection to create
// a Game object and configure all its dependencies
// You may need to change this file based on your actual Game interface. You also need
// to edit the game.xml file.
//
package fi.abo.cs.fiveinline;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fi.abo.cs.fiveinline.*;

public class Main {
	public static void main(String[] args) {
		ApplicationContext appContext = new FileSystemXmlApplicationContext("file:/home/emppo/Src/fi.Kiachma.SysdesFK.RÖ4/Task4/game.xml"); 
		Game g = (Game) appContext.getBean("aGame");
		// You may need to change this
		g.playGame();
	}
}
