package DESIGN.datafiles;

import java.util.Arrays;
import java.util.List;

import DESIGN.authoring.ILevel;

public class LevelData {
	private List<ILevel> levels;
	private int numberOfLevels;
	
	public LevelData(List<ILevel> arrayList) {
		this.levels = arrayList;
		updateNumberOfLevels();
	}

	private void updateNumberOfLevels () {
		numberOfLevels = levels.size();
	}
	
	public void add (ILevel... levelList) {
		levels.addAll(Arrays.asList(levelList));
	}
	
	public void remove (ILevel... levelList) {
		levels.removeAll(Arrays.asList(levelList));
	}
	
	public List<ILevel> getLevels () {
		return levels;
	}
}
