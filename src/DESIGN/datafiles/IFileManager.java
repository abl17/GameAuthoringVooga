package DESIGN.datafiles;

/*
 *  Interface for the file manager.
 *  Used by the authoring environment to save/load entire games/levels.
 *  Used by the game player to save/load progress midgame.
 */

public interface IFileManager {
	public void saveGame(GameData game, String fileName) throws GameFileException;
	public GameData loadGame(String fileName) throws GameFileException;

	public void saveLevel(LevelData level, String fileName) throws GameFileException;
	public LevelData loadLevel(String fileName) throws GameFileException;
	
	public void saveState(StateData state, String fileName) throws GameFileException;
	public StateData loadState(String fileName) throws GameFileException;
	
	
	
}
