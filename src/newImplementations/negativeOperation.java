/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newImplementations;

import java.awt.image.BufferedImage;
import oop.im2020.ImageProcessor;
import oop.im2020.OperationDialog;
import oop.im2020.OperationUtilities;
import oop.im2020.operationInterface;

/**
 *
 * @author hassan
 */
public class negativeOperation implements operationInterface{
    
    private final negativeUI negativeUI = new negativeUI();
    private final ImageProcessor processorUI;
    
    public negativeOperation(ImageProcessor frame){
        this.processorUI = frame;
    }

    @Override
    public BufferedImage operation(BufferedImage inputImage) {
        final OperationDialog dialog = new OperationDialog( this.processorUI, negativeUI);
		dialog.setVisible( true);
		if (!dialog.wasCancelled()) {
			for (int x = 0; x < inputImage.getWidth(); x++) {
				for (int y = 0; y < inputImage.getHeight(); y++) {
					final int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
					final int outputRGB = OperationUtilities.negative(inputRGB);
					OperationUtilities.setRGB(x, y, outputRGB, inputImage);
				}
			}
		}
		return inputImage;
	
    
    }
    
}
