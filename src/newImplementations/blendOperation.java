/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newImplementations;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import oop.im2020.ImageProcessor;
import oop.im2020.OperationDialog;
import oop.im2020.OperationUtilities;
import oop.im2020.operationInterface;

/**
 *
 * @author hassan
 */
public class blendOperation implements operationInterface {

    private final JFileChooser chooser = new JFileChooser();
    private final blendUI BlendUI = new blendUI( chooser);
    
    private ImageProcessor processorUI;
    
    public blendOperation(ImageProcessor frame){
        this.processorUI = frame;
    }
    
    @Override
    public BufferedImage operation(BufferedImage inputImage) {
        final OperationDialog dialog = new OperationDialog( this.processorUI, BlendUI);
		dialog.setVisible( true);    	
		if (!dialog.wasCancelled()) {
			try {
				double alphaOpacity = BlendUI.getAlphaOpacity();
				BufferedImage otherImage = ImageIO.read(BlendUI.getOtherImagePath());

				//int targetRGB = chromaKeyUI.getTargetColor().getRGB();

				BufferedImage output = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), inputImage.getType());
				for (int x = 0; x < output.getWidth(); x++) {
					for (int y = 0; y < output.getHeight(); y++) {
						int inputRGB = OperationUtilities.getRGB(x, y, inputImage);
						int otherRGB = OperationUtilities.getRGB(x, y, otherImage);
						int outputRGB = OperationUtilities.blend(inputRGB, otherRGB, alphaOpacity);
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
