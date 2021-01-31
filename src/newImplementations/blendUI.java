/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newImplementations;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 *
 * @author hassan
 */
public class blendUI extends JPanel{
    
    private final JTextField otherImagePath = new JTextField(60);
    private final JButton fileChooserButton = new JButton("Open");
    private final JSlider alphaSlider = new JSlider(0, 100);
    
    private final JFileChooser chooser;
    private File file;
    
    public blendUI(JFileChooser chooser){
        super(new BorderLayout());

        this.chooser = chooser;
        
        final JPanel pathPanel = new JPanel();
        pathPanel.add(this.otherImagePath);
        pathPanel.add(this.fileChooserButton);
        pathPanel.setBorder(BorderFactory.createTitledBorder("Image to blend"));
        alphaSlider.setBorder(BorderFactory.createTitledBorder("The amount of alpha opacity to blend the two images together"));
        
        add(pathPanel, BorderLayout.NORTH);
        add(this.alphaSlider, BorderLayout.SOUTH);
        
        this.otherImagePath.setEditable(false);
        
        this.fileChooserButton.addActionListener(ev -> showChooser());
    }
    
    private void showChooser() {
        if (this.chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.file = this.chooser.getSelectedFile();
            this.otherImagePath.setText(this.file.getPath());
        }
    }

    public File getOtherImagePath() {
        return this.file;
    }
    
    public double getAlphaOpacity() {
        return this.alphaSlider.getValue() / 100.0;
    }
}
