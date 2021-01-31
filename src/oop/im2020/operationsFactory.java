/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.im2020;

import newImplementations.blackWhiteOperation;
import newImplementations.blendOperation;
import newImplementations.negativeOperation;

/**
 *
 * @author hassan
 */
public class operationsFactory {
    
    public enum operationType {
      GREYSCALE, TINT, CHROMA_KEY, NEGATIVE, BLACK_WHITE, BLEND
    };
    
    public operationInterface createOperation(operationType type, ImageProcessor processorUI){
        switch(type){
            case GREYSCALE:                
                return new grayscaleOperation(processorUI);
            case TINT:
                return new tintOperation(processorUI);
            case CHROMA_KEY:
                return new chromaKeyOperation(processorUI);
            case NEGATIVE:
                return new negativeOperation(processorUI);
            case BLACK_WHITE:
                return new blackWhiteOperation(processorUI);
            case BLEND:
                return new blendOperation(processorUI);
            default:
                throw new IllegalArgumentException("Unknown operation type: " + type);
        }
    }
}
