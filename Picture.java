/*
 name and IDs go here (see prev homeworks and the other files for template)
 */

/*--------PROGRAM DESCRIPTION----------
 goes here
 
 */

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
   /*
       * Scale the given values from the appropriate colors.
       * Input: rScale - the amount of red value that should be scaled 
       *    gScale - the amount of blue value that should be scaled 
       *    bScale - the amount of green value that should be scaled 
       * Returns: nothing
       */

    public void scaleColor(double rScale, double gScale, double bScale)
    {
        Pixel [] pixArray = getPixels();
        for(int index=0; index < pixArray.length; index++)
        {
          double valueRed = pixArray[index].getRed();
          valueRed = valueRed * rScale; 
          pixArray[index].setRed((int)valueRed);
          
          if(valueRed > 255) {
            valueRed = 255;
          }
          if(valueRed < 0) {
            valueRed = 0; 
          }
          
          
          double valueBlue = pixArray[index].getBlue();
          valueBlue = valueBlue * gScale;
          pixArray[index].setBlue((int)valueBlue);
          
          if(valueBlue > 255) {
            valueBlue = 255;
          }
          if(valueBlue < 0) {
            valueBlue = 0;
          }
          
          double valueGreen = pixArray[index].getGreen();
          valueGreen = valueGreen * bScale;
          pixArray[index].setGreen((int)valueGreen);
          
          if(valueGreen > 255) {
            valueGreen = 255;
          }
          if(valueGreen < 0) {
            valueGreen = 0;
          }
        }
          
    }
  

   /*
    * Create the complement of each pixel between the provided indices
    * Input: start - the index of the first pixel to be modified 
    * (inclusive)
    * end - the index of the last pixel to be modified (inclusive)
    * Returns: nothing
    */
    public void complement(int start, int end)
    {
       Pixel [] pixArray = getPixels();
       for (int index = start; index <= end; index++)
       {
         int valueRed = pixArray[index].getRed();
         
         
         int valueGreen = pixArray[index].getGreen();
         
        
         
         int valueBlue = pixArray[index].getBlue();
         
         
         int complementRed = 255 - valueRed;
         int complementGreen = 255 - valueGreen;
         int complementBlue = 255 - valueBlue;
         
         pixArray[index].setRed(complementRed);
         pixArray[index].setGreen(complementGreen);
         pixArray[index].setBlue(complementBlue);
       
    }
    }

   /*
    * Create the gray equivalent of each pixel between the provided indices
    * Input: start - the index of the first pixel to be modified (inclusive)
    * end - the index of the last pixel to be modified (inclusive)
    * Returns: nothing
    */

    public void grayscale(int start, int end)
    {
      Pixel [] pixelArray = getPixels();
      for (int index = start; index <= end ; index++)
      {
        int value = (pixelArray[index].getRed() + pixelArray[index].getGreen() + pixelArray[index].getBlue())/3;
        
        pixelArray[index].setRed(value);
        pixelArray[index].setGreen(value);
        pixelArray[index].setBlue(value);
    }
    }
    

    /*
      * Apply myFilter to each pixel between and including the provided indices
      * SHORT DESCRIPTION OF FILTER: 
       * Using random generator to generate random value for the red value of Pixel from 0-255 inclusive and brigetning all the red, green, blue values 
       * by adding 50 to all pixel values. If the pixel value is greater than 255, the value will be set as 255. After these changes, the picture
       * will be set with new values of red, green, and blue. 
      * Input: start - the index of the first pixel to be modified (inclusive)
      * end - the index of the last pixel to be modified (inclusive)
      * Returns: nothing
      */
    
     public void myFilter(int start, int end)
     {
       Pixel [] pixelArray = getPixels();
       for (int index = start; index <= end ; index++)
       {
         Random generator = new Random(); 
         int valueRed = generator.nextInt(256);// generating random value between 0 and 255 inclusive
         int valueGreen = pixelArray[index].getGreen();
         int valueBlue = pixelArray[index].getBlue();
         
         int brightenRed = valueRed + 50; 
         if(brightenRed > 255) {
           brightenRed = 255;
         }
         
         int brightenGreen = valueGreen + 50; 
         if(brightenGreen > 255) {
           brightenGreen = 255;
         }
         
         int brightenBlue = valueBlue + 50; 
         if(brightenBlue > 255) {
           brightenBlue = 255;
         }
         
         pixelArray[index].setRed(brightenRed);
         pixelArray[index].setGreen(brightenGreen);
         pixelArray[index].setBlue(brightenBlue);
         
     }
     }

    /*
        * Blend the calling object pic into the parameter Picture
        * object with the upper left corner at (x, y)
        * Input: x - The background’s top left corner x coordinate
        *        y - The background’s top left corner y coordinate
        *        background - The background picture to blend into
        * Returns: nothing
    */

      public void alphaBlending(int x, int y, Picture background)
      {
          Pixel [] pixelArray = getPixels();
          for(int start1 = 0; start1 < getWidth(); start1++)
          {
            
            for(int start2 = 0; start2 < getHeight(); start2++)
            {
              Pixel source = this.getPixel(start1,start2);
              Pixel target = background.getPixel(start1,start2);
              
              int redValue1 = source.getRed();
              int redValue2 = target.getRed();
              double alphaSource = source.getAlpha(); 
              int red = (int)(alphaSource/255 * redValue1 + (1 - alphaSource/255) * redValue2);
              
              int greenValue1 = source.getGreen();
              int greenValue2 = target.getGreen();
              int green = (int)(alphaSource/255 * greenValue1 + (1 - alphaSource/255) * greenValue2);
                                  
              int blueValue1 = source.getBlue();
              int blueValue2 = target.getBlue();
              int blue = (int)(alphaSource/255 * blueValue1 + (1 - alphaSource/255) * blueValue2);
              
              target.setRed(red);
              target.setGreen(green);
              target.setBlue(blue);
              
             
      }
          }
      }

    /*
     * Test the alphaBlending method by comparing two pictures
     * Input: result - The picture to compare to
     * Returns: true if the pictures match
     *          false if they do not
     */      
     public boolean testAlphaBlending(Picture result)
     {
          return false;
     }
  
}   
} // this } is the end of class Picture, put all new methods before this
 
