/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newImplementations;

import java.awt.BorderLayout;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author hassan
 */
public class blackWhiteUI extends JPanel {
    
    private final JSlider alphaSlider = new JSlider(0, 255);
    private JTextField sliderValue = new JTextField();
    private final JLabel label = new JLabel("Change image to Black & White");
    
    public blackWhiteUI(){
        super(new BorderLayout());
        
        add(label, BorderLayout.NORTH);
        
        setTextField();
        
        this.sliderValue.addActionListener((ev) -> setSliderValue());
        
        this.alphaSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                JSlider source = (JSlider) ce.getSource();
                sliderValue.setText(String.valueOf(source.getValue()));
            }
        });
               
        add(this.alphaSlider, BorderLayout.CENTER);
        add(this.sliderValue, BorderLayout.SOUTH);
        
    }
    
    public void setSliderValue(){
        int i = Integer.parseInt(this.sliderValue.getText());
        this.alphaSlider.setValue(i);
    }
    
    public void setTextField(){
        this.sliderValue.setText(String.valueOf(this.alphaSlider.getValue()));
    }
    
    public int getThreshold(){
        return this.alphaSlider.getValue();
    }
}
