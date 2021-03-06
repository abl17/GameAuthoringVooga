package player;

import exceptions.data.GameFileException;

/**
 * @author Austin
 */
public interface IPlayer {

	/**
	 * Resumes gameplay of the main game loop
	 * @throws GameFileException
	 */
	public void resume() throws GameFileException;
	
	/**
	 * Pauses gameplay of the main game loop
	 * @throws GameFileException
	 */
	public void pause() throws GameFileException;
	
}
