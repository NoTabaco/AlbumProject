package version1;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {

	public TabbedPane() {
		// 나중에 순서 바꿔 줄 것 
		// TabbedPane 순서 
		addTab("Album", new AlbumPanel());
		addTab("Image", new ImagePanel());

	}

}
