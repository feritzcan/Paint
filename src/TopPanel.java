import javax.swing.JPanel;


public class TopPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TopPanel() {
		setSize(480,480);
		setLayout(null);
		
		DrawArea drawArea = new DrawArea();
		drawArea.setBounds(79, 34, 401, 446);
		add(drawArea);
		
		ComponentPanel componentPanel_ = new ComponentPanel(drawArea);
		componentPanel_.setBounds(6, 34, 72, 440);
		add(componentPanel_);
		
		FileMenu fileMenu = new FileMenu(drawArea);
		fileMenu.setBounds(6, 6, 438, 27);
		add(fileMenu);

	}
}
