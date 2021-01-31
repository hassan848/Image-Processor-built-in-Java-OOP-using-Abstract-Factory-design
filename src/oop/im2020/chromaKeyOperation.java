/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.im2020;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 *
 * @author hassan
 */
public class chromaKeyOperation implements operationInterface{
    
    private final JFileChooser chooser = new JFileChooser();
    private final ChromaKeyUI chromaKeyUI = new ChromaKeyUI( chooser);
    
    private ImageProcessor processorUI;
    
    public chromaKeyOperation(ImageProcessor frame){
        this.processorUI = frame;
    }

    @Override
    public BufferedImage operation(BufferedImage inputImage) {
        final OperationDialog dialog = new OperationDialog( this.processorUI, chromaKeyUI);
		dialog.setVisible( true);    	
		if (!dialog.wasCancelled()) {
			try {
				double sensitivity = chromaKeyUI.getSensitivity();
				BufferedImage otherImage = ImageIO.read(chromaKeyUI.getOtherImagePath());

				int targetRGB = chromaKeyUI.getTargetColor().getRGB();

				BufferedImage output = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), inputImage.getType());
				for (int x = 0; x < output.getWidth(); x++) {
					for (int y = 0; y < output.getHeight(); y++) {
						int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
						int otherRGB = OperationUtilities.getRGB(x, y, otherImage);
						int outputRGB = OperationUtilities.chromaKey(inputRGB, otherRGB, targetRGB, sensitivity);
						OperationUtilities.setRGB(x, y, outputRGB, output);
					}
				}
				return output;
			} catch (IOException ex) {
				ex.printStackTrace();
				return inputImage;
			}
		} else {
			return inputImage;
		}
	}
}
