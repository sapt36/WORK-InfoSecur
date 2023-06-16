import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class 5bit {
   public static void main(String args[]) throws Exception {
      BufferedImage bImage = ImageIO.read(new File("Img_File.bmp"));

      // 將圖片每個像素的最後5個bits修改為01110
      for (int i = 0; i < bImage.getHeight(); i++) {
         for (int j = 0; j < bImage.getWidth(); j++) {
            int rgb = bImage.getRGB(j, i);
            int modifiedRGB = (rgb & 0xFFFFFFC7) | 0x1C; // 將最後5個bits修改為01110
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
