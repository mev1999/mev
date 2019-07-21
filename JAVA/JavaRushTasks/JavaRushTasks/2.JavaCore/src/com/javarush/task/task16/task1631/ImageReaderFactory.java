package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
/*     public static class IllegalArgumentException extends Exception {
        IllegalArgumentException(String s) { super(s);}
    }*/
    public static ImageReader getImageReader(ImageTypes type) throws IllegalArgumentException {
        ImageReader reader;
        if(type == ImageTypes.BMP) reader = new BmpReader();
        else
            if(type == ImageTypes.JPG) reader = new JpgReader();
            else
                if(type == ImageTypes.PNG) reader = new PngReader();
                else throw (new IllegalArgumentException("Неизвестный тип картинки"));
        return reader;
    }
}
