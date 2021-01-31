/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.im2020;

import java.awt.image.BufferedImage;

/**
 *
 * @author hassan
 */
public class grayscaleOperation implements operationInterface{

    private final GrayscaleUI grayscaleUI = new GrayscaleUI();
    private final ImageProcessor processorUI;
    
    public grayscaleOperation(ImageProcessor frame){
        this.processorUI = frame;
    }
    
    @Override
    public BufferedImage operation(final BufferedImage inputImage) {
        final OperationDialog dialog = new OperationDialog( this.processorUI, grayscaleUI);
		dialog.setVisible( true);
		if (!dialog.wasCancelled()) {
			for (int x = 0; x < inputImage.getWidth(); x++) {
				for (int y = 0; y < inputImage.getHeight(); y++) {
					final int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
					final int outputRGB = OperationUtilities.grayscale(inputRGB);
					OperationUtilities.setRGB(x, y, outputRGB, inputImage);
				}
			}
		}
		return inputImage;
    }
   
}
