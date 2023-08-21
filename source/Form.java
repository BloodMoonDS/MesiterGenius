package source;
import javax.swing.JFrame;
public class Form {
    public int sizeX = 320;
    public int sizeY = 240;
    JFrame formwindows = new JFrame("New Form");
    public void Show(){
        formwindows.setVisible(true);

    }
    public void Load(){
        formwindows.setSize(sizeX,sizeY);

    }
}
