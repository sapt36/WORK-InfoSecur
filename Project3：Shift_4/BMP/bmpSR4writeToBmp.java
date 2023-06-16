import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class bmpSR4writeToBmp {
   public static void main(String args[]) throws Exception {
      BufferedImage bImage = ImageIO.read(new File("Img_File.bmp"));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ImageIO.write(bImage, "bmp", bos );
      byte [] data = bos.toByteArray();
      for (int i = 34; i < data.length; i++) {
	     // convert number to Binary
      	 data[i] = (byte) (data[i]>>4);
	  }
      ByteArrayInputStream bis = new ByteArrayInputStream(data);
      BufferedImage bImage2 = ImageIO.read(bis);
      ImageIO.write(bImage2, "bmp", new File("output.bmp") );
      System.out.println("image created");
   }
}