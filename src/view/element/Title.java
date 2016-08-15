package view.element;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Title extends AbstractElement {

	private String title;

	public Title(GridPane pane, String title) {
		super(pane);
		this.title = title;
		makePane();
	}

	@Override
	protected void makePane() {
		Text t = new Text(title);
		t.setFont(titleFont);
		pane.add(t, 0, 0);
	}

}
