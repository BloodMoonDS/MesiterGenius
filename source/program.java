package source;
import com.furside.ovinEngine.FormClass;
import com.furside.ovinEngine.GameLoop;
public class program {
	GameLoop gc = new GameLoop();
	
    //GLCapabilities capabilities = new GLCapabilities();
    public void start() throws Exception{
    	FormClass fc = gc.getWindow();
        gc.start();
        gc.setTitle("Example Project");
       
    }
}
