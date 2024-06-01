package fundraw;

import java.awt.AWTEvent;
import java.awt.event.*;
import javax.swing.*;

public class GlobalKeyBinder {
	private MainController controller;
	

	public GlobalKeyBinder(JRootPane root) {
		KeyStroke undoKey = KeyStroke.getKeyStroke(KeyEvent.VK_Z, AWTEvent.RESERVED_ID_MAX);
		KeyStroke redoKey = KeyStroke.getKeyStroke(KeyEvent.VK_Y, AWTEvent.RESERVED_ID_MAX);
		KeyStroke saveKey = KeyStroke.getKeyStroke(KeyEvent.VK_S, AWTEvent.RESERVED_ID_MAX);
		KeyStroke newKey = KeyStroke.getKeyStroke(KeyEvent.VK_N, AWTEvent.RESERVED_ID_MAX);
		KeyStroke openKey = KeyStroke.getKeyStroke(KeyEvent.VK_O, AWTEvent.RESERVED_ID_MAX);
		KeyStroke swapColorsKey = KeyStroke.getKeyStroke('x');
		
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(undoKey, "undo");
		root.getActionMap().put("undo", new AbstractAction() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				GlobalKeyBinder.this.controller.getCanvas().undo();
			}
		});
		
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(redoKey, "redo");
		root.getActionMap().put("redo", new AbstractAction() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				GlobalKeyBinder.this.controller.getCanvas().redo();
			}
		});
		
		
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(saveKey, "save");
		root.getActionMap().put("save", new AbstractAction() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				GlobalKeyBinder.this.controller.saveCanvas();
			}
		});
		
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(openKey, "open");
		root.getActionMap().put("open", new AbstractAction() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				GlobalKeyBinder.this.controller.openCanvasFromFileSystem();
			}
		});
		
		
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(newKey, "new");
		root.getActionMap().put("new", new AbstractAction() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				GlobalKeyBinder.this.controller.createNewCanvas();
			}
		});
		
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(swapColorsKey, "swapColors");
		root.getActionMap().put("swapColors", new AbstractAction() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				GlobalKeyBinder.this.controller.getColorToggler().swapColors();
			}
		});
		
		
	}
	
	public void setController(MainController controller)
	{
		this.controller = controller;
	}
	
}
