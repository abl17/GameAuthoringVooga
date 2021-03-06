package view.map;

import javafx.scene.layout.GridPane;
import view.element.AbstractDockElement;
import view.level.LevelMap;
import view.level.LevelType;
import view.level.Workspace;
import view.screen.AbstractScreenInterface;

public class CreatorMapSliders extends MapSliders {

	public CreatorMapSliders(GridPane home, String title, AbstractScreenInterface screen, Workspace workspace) {
		super(home, title, screen);
		workspace.addListener((ov, oldTab, newTab) -> {
//			System.out.println("switching level workspaces");
			load(workspace.getCurrentLevel());
//			System.out.println(workspace.getCurrentLevel().getType());
		});
	}

	private void checkMap() {
		if (map == null) {
			showing.setValue(false);
		}
	}

	private void load(LevelMap currentLevel) {
		pane.getChildren().clear();
		if (currentLevel != null && currentLevel.getType() == LevelType.LEVEL) {
			this.map = (LevelMap) currentLevel;
			makePane();
			showing.setValue(true);
		} else {
			map = null;
			showing.setValue(false);
		}
	}

}
