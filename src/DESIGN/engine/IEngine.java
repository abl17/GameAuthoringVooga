package DESIGN.engine;

import java.util.List;

import DESIGN.authoring.ILevel;
import DESIGN.datafiles.GameData;

public interface IEngine {

	public boolean init(List<ILevel> levelList);
	public boolean reset();
	public GameData save();
	public boolean load(GameData state);
	public void runGame();
	
}
