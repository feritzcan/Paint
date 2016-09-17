import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import javax.xml.crypto.KeySelector.Purpose;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.File;

import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class ComponentPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	DrawArea drawArea;
	
	public ComponentPanel(DrawArea da) {
		setBounds(6, 34, 72, 440);
		setLayout(null);
		this.drawArea=da;

		JButton btnNewButton = new JButton("R");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawArea.setColor(Color.RED);
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(6, 396, 26, 29);
		add(btnNewButton);
		
		JButton button = new JButton("B");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawArea.setColor(Color.BLUE);
			}
		});
		button.setForeground(Color.BLUE);
		button.setBackground(Color.RED);
		button.setBounds(44, 396, 26, 29);
		add(button);
		
		JButton button_1 = new JButton("BL");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawArea.setColor(Color.BLACK);
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(Color.RED);
		button_1.setBounds(6, 355, 26, 29);
		add(button_1);
		
		JButton button_2 = new JButton("P");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawArea.setColor(Color.PINK);
			}
		});
		button_2.setForeground(Color.PINK);
		button_2.setBackground(Color.RED);
		button_2.setBounds(44, 355, 26, 29);
		add(button_2);
		
		JButton button_3 = new JButton("G");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawArea.setColor(Color.green);
			}
		});
		button_3.setForeground(Color.GREEN);
		button_3.setBackground(Color.RED);
		button_3.setBounds(6, 314, 26, 29);
		add(button_3);
		
		JButton button_4 = new JButton("Y");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawArea.setColor(Color.YELLOW);
			}
		});
		button_4.setForeground(Color.YELLOW);
		button_4.setBackground(Color.RED);
		button_4.setBounds(44, 314, 26, 29);
		add(button_4);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawArea.clear();
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton_1.setBounds(6, 273, 60, 29);
		add(btnNewButton_1);
		
		JButton button_5 = new JButton("PEN");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawArea.setCursor(Cursor.getDefaultCursor());

				drawArea.setPen(1);
			}
		});
		button_5.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		button_5.setBounds(6, 6, 60, 29);
		add(button_5);
		
		JButton button_6 = new JButton("Brush");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawArea.setCursor(Cursor.getDefaultCursor());

				drawArea.setPen(2);
			}
		});
		button_6.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		button_6.setBounds(6, 33, 60, 29);
		add(button_6);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				drawArea.setPenSize((int)spinner.getValue());
				
			}
		});
		spinner.setBounds(6, 248, 64, 28);
		add(spinner);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(16, 230, 26, 16);
		add(lblSize);
		
		JButton button_7 = new JButton(new ImageIcon("img/silgi.png"));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				drawArea.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("img/silgi.png").getImage(),
						new Point(0,0),"custom cursor"));	
				drawArea.setPen(3);
				
			}
		});
		button_7.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		button_7.setBounds(6, 74, 60, 29);
		add(button_7);
		

		JButton button_8 = new JButton(new ImageIcon("img/circ.png"));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				drawArea.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("img/circ.png").getImage(),
						new Point(0,0),"custom cursor"));	
				drawArea.setPen(4);
			}
		});
		button_8.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		button_8.setBounds(40, 136,30, 30);
		add(button_8);
		
		JButton button_9 = new JButton(new ImageIcon("img/fill.png"));
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				drawArea.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("img/fill.png").getImage(),
						new Point(25,25),"custom cursor"));	
				drawArea.setPen(10);
			}
		});
		button_9.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		button_9.setBounds(6, 178, 50, 50);
		add(button_9);
		
	

		JButton button_10 = new JButton(new ImageIcon("img/rect.png"));
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				drawArea.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("img/rect.png").getImage(),
						new Point(0,0),"custom cursor"));		
				drawArea.setPen(5);
			}
		});
		button_10.setBounds(6, 136, 30, 30);
		add(button_10);
	}
}