import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PSNRcalculator {
    public static void main(String[] args) {
        // 指定原始图像和压缩后的图像文件路径
        String originalImagePath = "Img_File.bmp";
        String compressedImagePath = "output5bits.bmp";

        try {
            // 读取原始图像和压缩后的图像
            BufferedImage originalImage = ImageIO.read(new File(originalImagePath));
            BufferedImage compressedImage = ImageIO.read(new File(compressedImagePath));

            // 计算图像的 MSE（Mean Squared Error）
            double mse = calculateMSE(originalImage, compressedImage);

            // 计算图像的最大像素值
            double maxPixelValue = getMaxPixelValue(originalImage);

            // 计算 PSNR
            double psnr = calculatePSNR(mse, maxPixelValue);

            System.out.println("PSNR: " + psnr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 计算 MSE
    private static double calculateMSE(BufferedImage image1, BufferedImage image2) {
        int width = image1.getWidth();
        int height = image1.getHeight();

        double sum = 0.0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel1 = image1.getRGB(x, y);
                int pixel2 = image2.getRGB(x, y);

                // 计算像素的差值
                int diff = getPixelDifference(pixel1, pixel2);

                // 将差值的平方累加
                sum += Math.pow(diff, 2);
            }
        }

        // 计算均方误差
        double mse = sum / (width * height);

        return mse;
    }

    // 获取图像的最大像素值
    private static double getMaxPixelValue(BufferedImage image) {
        int numComponents = image.getColorModel().getNumComponents();
        int maxPixelValue = (int) Math.pow(2, image.getColorModel().getComponentSize(0)) - 1;
        double maxPixelValueSquared = Math.pow(maxPixelValue, 2);

        return numComponents * maxPixelValueSquared;
    }

    // 计算 PSNR
    private static double calculatePSNR(double mse, double maxPixelValue) {
        double psnr = 10 * Math.log10(maxPixelValue / mse);
        return psnr;
    }

    // 获取两个像素的差值
    private static int getPixelDifference(int pixel1, int pixel2) {
        int red1 = (pixel1 >> 16) & 0xFF;
        int green1 = (pixel1 >> 8) & 0xFF;
        int blue1 = pixel1 & 0xFF;

        int red2 = (pixel2 >> 16) & 0xFF;
        int green2 = (pixel2 >> 8) & 0xFF;
        int blue2 = pixel2 & 0xFF;

        int diffRed = red1 - red2;
        int diffGreen = green1 - green2;
        int diffBlue = blue1 - blue2;

        // 计算差值的平方和
        int diffSquared = diffRed * diffRed + diffGreen * diffGreen + diffBlue * diffBlue;

        return diffSquared;
    }
}

