import java.awt.Container;

import javax.swing.JFrame;


public class MainFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame=new JFrame();
		Container content=frame.getContentPane();
		
		content.add(new TopPanel());
		frame.setSize(480, 480);
		frame.setVisible(true);
	}

}
