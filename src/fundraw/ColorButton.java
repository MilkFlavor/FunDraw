package fundraw;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * Name: Shibashish Das
 * Date: 5/29/2024
 * Last Updated:
 * Project Name: FunDraw
 * 
 * Discription:
 * This class is used to create a color chooser button. This button is used to select a color from the color chooser dialog.
 */

public class ColorButton extends JButton {
	/**
	 * Button with a color as its background
	*/
    private Color current;

    public ColorButton(Color c) {
        setSelectedColor(c);
    }

    public Color getSelectedColor() {
        return current;
    }

    /*
     * Set the selected color
     * 
     * @param newColor The new color to be set
     */
    public void setSelectedColor(Color newColor) {

        if (newColor == null) return;

        this.current = newColor;
        setIcon(createIcon(current, 24, 24));
        repaint();
    }

    /*
     * Create an icon with the specified color
     * 
     * @param main The color of the icon
     * @param width The width of the icon
     * @param height The height of the icon
     * 
     * @return ImageIcon The icon with the specified color
     */
    public static ImageIcon createIcon(Color main, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(main);
        graphics.setComposite(AlphaComposite.Src);
        graphics.fillRect(0, 0, width, height);
        graphics.setXORMode(Color.DARK_GRAY);
        graphics.drawRect(0, 0, width-1, height-1);
        image.flush();
        ImageIcon icon = new ImageIcon(image);
        return icon;
    }
}