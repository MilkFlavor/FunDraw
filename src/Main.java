import java.awt.*;

import fundraw.MainFrame;

// entry point class
public class Main {
	
	public static void main(String[] args) {
		
	    EventQueue.invokeLater(new Runnable() {
	    	public void run() {
				Frame frame = new MainFrame();
	            frame.setVisible(true);
	            frame.setExtendedState(Frame.MAXIMIZED_BOTH);
	    	}
	    });
	}
}

