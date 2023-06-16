import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;

//修改自project 4
public class TXTWatermark {
   public static void main(String args[]) throws Exception {
      BufferedImage bImage = ImageIO.read(new File("Img_File.bmp"));

      // 創建一個副本圖像以保留原始圖像
      BufferedImage watermarked = new BufferedImage(bImage.getWidth(), bImage.getHeight(), BufferedImage.TYPE_INT_RGB);
      Graphics2D graphics2D = watermarked.createGraphics();
      graphics2D.drawImage(bImage, 0, 0, null);

      // 添加浮水印文本
      String watermarkText = "U10916040 陳冠廷";
      int fontSize = 20;
      graphics2D.setFont(graphics2D.getFont().deriveFont((float)fontSize));

      FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
      TextLayout textLayout = new TextLayout(watermarkText, graphics2D.getFont(), fontRenderContext);
      int textX = (bImage.getWidth() - (int)textLayout.getBounds().getWidth()) / 2;
      int textY = bImage.getHeight() - (int)textLayout.getBounds().getHeight();

      graphics2D.drawString(watermarkText, textX, textY);
      graphics2D.dispose();

      //保存包含浮水印的圖片
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ImageIO.write(watermarked, "bmp", bos);
      byte[] data = bos.toByteArray();

      ByteArrayInputStream bis = new ByteArrayInputStream(data);
      BufferedImage bImage2 = ImageIO.read(bis);
      ImageIO.write(bImage2, "bmp", new File("output.bmp"));
      System.out.println("Image created");
   }
}
