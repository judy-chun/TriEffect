/* Filename: TestPictures.java
* Created by: CSE 8A Staff
* Date: Fall 2017
*/
public class TestPictures
{
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args)
    { 
      FileChooser file1 = new FileChooser(); 
      Picture originalPic = new Picture(file1.pickAFile());
      Picture copyPic = new Picture(originalPic);
      originalPic.explore(); //original picture 
      copyPic.scaleColor(1.2,1.5,1.8);
      copyPic.explore(); //modified picture 
      
      //Choosing pictures for alpha blending

      
      
     
      

      
      
      
      
 
    }
}
