import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FileMenu extends JPanel implements ActionListener{

	/**
	 * Crea
	 * te the panel.
	 */
	
	
	
	JMenuItem newFile,save;
	JMenuItem openMenuItem;
	DrawArea area;
	final JFileChooser fc = new JFileChooser();

	public FileMenu(DrawArea area) {
		setBounds(6, 6, 438, 27);
		setLayout(null);
		this.area=area;
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 6, 132, 22);
		add(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		openMenuItem = new JMenuItem("Exit");
		openMenuItem.addActionListener(this);
	    
	    newFile=new JMenuItem("New");
	    newFile.addActionListener(this);
	    
	    save=new JMenuItem("save");
	    save.addActionListener(this);
	    
		
	    fileMenu.add(newFile);
	    fileMenu.add(save);
	    fileMenu.add(openMenuItem);

	   

	    menuBar.add(fileMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==newFile)
		{
			area.newFile();
		}
		if(e.getSource()==openMenuItem)
		{System.exit(0);
			
		}
		if(e.getSource()==save)
		{
			fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

			int returnVal = fc.showOpenDialog(this);

			if(returnVal==JFileChooser.APPROVE_OPTION)
			{
				File file	=fc.getSelectedFile();
				String path=file.getPath();
				area.takeSnapShot(path);

			}
		}
		
	}
}
