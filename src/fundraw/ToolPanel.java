package fundraw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import tools.*;

public class ToolPanel extends JToolBar {
	private MainController controller;
	
	private BrushTool brush;
	private BucketTool bucket;
	private EyeDropperTool eyeDropper;
	private EraserTool eraser;

	
	
	
	public ToolPanel() {
		super("Tools", JToolBar.VERTICAL);
		
		ButtonListener listener = new ButtonListener();
		
		this.brush = new BrushTool();
		this.bucket = new BucketTool();
		this.eyeDropper = new EyeDropperTool();
		this.eraser = new EraserTool();
		
		
		String[] buttonLabels = {"Brush", "Eraser", "EyeDropper", "Bucket"};
		ImageIcon[] buttonIcons = {
				new ImageIcon("resources/paintbrush.png"),
				new ImageIcon("resources/eraser.png"),
				new ImageIcon("resources/eyedropper.png"),
				new ImageIcon("resources/bucket.png")
				};
		
		JButton[] buttons = new JButton[buttonLabels.length];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonIcons[i]);
			buttons[i].setSize(20, 20);
			buttons[i].setActionCommand(buttonLabels[i]);
			buttons[i].setToolTipText(buttonLabels[i]);
			buttons[i].addActionListener(listener);
			this.add(buttons[i]);
			this.addSeparator();
		}
		
		setFloatable(false);
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "Bucket":
				controller.setCanvasTool(bucket);
				break;
				
			case "Brush":
				controller.setCanvasTool(brush);
				break;
				
			case "EyeDropper":
				controller.setCanvasTool(eyeDropper);
				break;
				
			case "Eraser":
				controller.setCanvasTool(eraser);
				break;
			}
		}
	}
	

	public void setController(MainController controller)
	{
		this.controller = controller;
	}
	
}
