import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class drawer {
    public static void main(String[] args) throws IOException {
        Mandelbrot mandelbrot = new Mandelbrot(1000, 1000);


        BufferedImage image = mandelbrot.calculate(1000);

        File destination = new File("test3.png");
        String format = "PNG";
        ImageIO.write(image, format, destination);


    }
}
