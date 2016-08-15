package controller;

import javafx.stage.Stage;
import view.screen.AbstractScreen;
import view.screen.StartScreen;

/**
 * 
 * @author Sung-Hoon and Austin
 *
 */

public class MenuController extends AController {
	
	public MenuController (Stage stage) {
		this(stage, new StartScreen());
	}
	public MenuController (Stage stage, AbstractScreen screen) {
		super(stage, screen);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		currentScreen.run();
	}

}
