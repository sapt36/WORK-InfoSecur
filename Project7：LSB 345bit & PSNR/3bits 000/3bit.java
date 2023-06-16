import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class 3bit {
   public static void main(String args[]) throws Exception {
      BufferedImage bImage = ImageIO.read(new File("Img_File.bmp"));

      // 將圖片每個byte的最後3個bits修改為000
      for (int i = 0; i < bImage.getHeight(); i++) {
         for (int j = 0; j < bImage.getWidth(); j++) {
            int rgb = bImage.getRGB(j, i);
            int modifiedRGB = (rgb & 0xFFFFFFF8); // 將最後3個bits修改為000
            bImage.setRGB(j, i, modifiedRGB);
         }
      }

      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ImageIO.write(bImage, "bmp", bos);
      byte[] data = bos.toByteArray();

      ByteArrayInputStream bis = new ByteArrayInputStream(data);
      BufferedImage bImage2 = ImageIO.read(bis);
      ImageIO.write(bImage2, "bmp", new File("output.bmp"));
      System.out.println("Image created");
   }
}
