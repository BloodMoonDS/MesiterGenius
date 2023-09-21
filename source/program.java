package source;
import java.awt.image.BufferedImage;

import com.furside.ovinEngine.FormClass;
import com.furside.ovinEngine.GameLoop;
import com.furside.ovinEngine.SpriteService;
public class program {
	GameLoop gc = new GameLoop();
	
    //GLCapabilities capabilities = new GLCapabilities();
    public void start() throws Exception{
    	SpriteService sp = new SpriteService(); 
    	BufferedImage bf = gc.getWindow().getImage();
    	FormClass fc = gc.getWindow();
    	
        gc.start();
        gc.setTitle("Example Project");
        while(true){
        sp.Drawimage(bf, sp.Getimage("assets/sprites/fakeBag.png"));
        }
    }
}
