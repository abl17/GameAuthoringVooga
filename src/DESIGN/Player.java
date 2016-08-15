package DESIGN;

import javafx.scene.Scene;

public interface Player {

	// Resumes gameplay
	public void play();
	
	// Pauses gameplay
	public void pause();
	
	// Draws the player's gui elements
	public void renderGui(Scene s);
}
