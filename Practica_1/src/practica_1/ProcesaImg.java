
package practica_1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Rebeca Janete
 */
public class ProcesaImg {
    
    private BufferedImage imgAct;
    public BufferedImage cargarImagen(){
        BufferedImage bmp=null;
        JFileChooser selector=new JFileChooser();
        selector.setDialogTitle("Seleccione una imagen");
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp");
        selector.setFileFilter(filtroImagen);
        int flag=selector.showOpenDialog(null);
        if(flag==JFileChooser.APPROVE_OPTION){
            try {
                
                File imagenSeleccionada=selector.getSelectedFile();
              
                bmp = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
            }
                 
        }
        imgAct=bmp;
        return bmp;
    }
    
    public BufferedImage cambiarColor(){
        int mediaPixel,colorSRGB;
        Color colorAux;
        for( int i = 0; i < imgAct.getWidth(); i++ ){
            for( int j = 0; j < imgAct.getHeight(); j++ ){
                colorAux=new Color(this.imgAct.getRGB(i, j));
                mediaPixel=(int)((colorAux.getRed()+colorAux.getGreen()+colorAux.getBlue())/3);
                colorSRGB=(mediaPixel << 30) | (mediaPixel << 80) | mediaPixel;       
                imgAct.setRGB(i, j,colorSRGB);
            }
        }
        return imgAct;
    }
}
