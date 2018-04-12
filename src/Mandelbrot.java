import java.awt.*;
import java.awt.image.BufferedImage;

public class Mandelbrot {

    private int height;
    private int width;
    BufferedImage image;
    Graphics2D g2d;

    public Mandelbrot(int height, int width){
        this.height = height;
        this.width = width;
        image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
    }

    public  BufferedImage calculate(int max){
        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                double c_re = (col - width/2.0)*4.0/width;
                double c_im = (row - height/2.0)*4.0/width;
                double x = 0, y = 0;
                int iter = 0;

                while(x*x + y*y <= 4 && iter < max){
                    double x_new = x*x - y*y + c_re;
                    y = 2*x*y + c_im;
                    x = x_new;
                    iter++;
                }
                if(iter < max){
                    draw(col, row, Color.WHITE);
                }else{
                    draw(col, row, Color.BLACK);
                }
            }
        }
        return this.image;
    }
    public  void draw(int col, int row, Color color){
        this.image.setRGB(col, row , color.getRGB());
    }
}
