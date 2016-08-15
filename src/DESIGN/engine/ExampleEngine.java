package DESIGN.engine;

import java.util.List;

import DESIGN.authoring.ILevel;
import DESIGN.datafiles.GameData;

public class ExampleEngine implements IEngine{

	@Override
	public boolean init(List<ILevel> levelList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reset() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GameData save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean load(GameData state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void runGame() {
		// TODO Auto-generated method stub
		
	}

}
