package fundraw;

import java.awt.Color;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class ColorPicker extends JColorChooser{

	
	public ColorPicker(Color initialColor){
		super(initialColor);
		this.setPreviewPanel(new JPanel());
		
		// removing Panel except swatches and RGB
        for(AbstractColorChooserPanel p: this.getChooserPanels())
        {
            String displayName = p.getDisplayName();
            
            switch (displayName) {
                case "HSV":
                case "HSL":
                case "CMYK":
                    this.removeChooserPanel(p);
                    break;
            }
        }
        
	    this.setBorder(BorderFactory.createTitledBorder(
            "Color Picker")); 
	}
	
}
