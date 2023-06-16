import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;

public class PNGWatermark {
   public static void main(String args[]) throws Exception {
      BufferedImage bImage = ImageIO.read(new File("Img_File.bmp"));

      // 添加圖片浮水印
      BufferedImage watermarkImage = ImageIO.read(new File("favicon.png"));
      Graphics2D graphics2D = bImage.createGraphics();
      
      // 設定浮水印位置為右下角
      int watermarkX = bImage.getWidth() - watermarkImage.getWidth() - 10;
      int watermarkY = bImage.getHeight() - watermarkImage.getHeight() - 10;
      graphics2D.drawImage(watermarkImage, watermarkX, watermarkY, null);
      graphics2D.dispose();

      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ImageIO.write(bImage, "bmp", bos);
      byte[] data = bos.toByteArray();

      ByteArrayInputStream bis = new ByteArrayInputStream(data);
      BufferedImage bImage2 = ImageIO.read(bis);
      ImageIO.write(bImage2, "bmp", new File("output.bmp"));
      System.out.println("Image created");
   }
}
