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
public class tintOperation implements operationInterface{
    
    private final TintUI tintUI = new TintUI();
    private ImageProcessor processorUI;
    
    public tintOperation(ImageProcessor frame){
        this.processorUI = frame;
    }

    @Override
    public BufferedImage operation(BufferedImage inputImage) {
        final OperationDialog dialog = new OperationDialog( this.processorUI, tintUI);
		dialog.setVisible( true);
		if (!dialog.wasCancelled()) {
			final ColourComponent band = tintUI.getChosenColor();
			final double alpha = tintUI.getAlpha() / 100.0;
			for (int x = 0; x < inputImage.getWidth(); x++) {
				for (int y = 0; y < inputImage.getHeight(); y++) {
					final int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
					final int outputRGB = OperationUtilities.tint(inputRGB, alpha, band);
					OperationUtilities.setRGB(x, y, outputRGB, inputImage);
				}
			}
		}
		return inputImage;
	}
    
}
