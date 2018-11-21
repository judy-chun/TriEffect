/* Filename: TriEffect.java
* Created by: CSE 8A Staff
* Date: Fall 2017
*/
public class TriEffect
{
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args)
    {
      FileChooser file1 = new FileChooser(); 
      Picture originalPic = new Picture(file1.pickAFile());
      Picture copyPic = new Picture(originalPic);
      originalPic.explore();

      
      //tri- effect
      copyPic.complement(0,originalPic.getPixels().length/3); //complement method

      copyPic.grayscale(1+originalPic.getPixels().length/3, originalPic.getPixels().length*2/3); //grayscale method
      
      copyPic.myFilter(1+originalPic.getPixels().length*2/3, originalPic.getPixels().length-1); //myFilter method 
      copyPic.explore();
      //display new image 
    }
}
