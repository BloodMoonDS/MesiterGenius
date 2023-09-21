package bx.generic.render;

import java.awt.image.DataBufferInt;
import com.furside.ovinEngine.GameLoop;

public class GenericRender {
  private int pW;
  
  private int pH;
  
  private int[] p;
  
  public GenericRender(GameLoop gc) {
    this.pH = gc.getHeight();
    this.pW = gc.getWidth();
    this.p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
  }
  
  public void clear() {
    for (int i = 0; i < this.p.length; i++) {
      //this.p[i] = 0x000000;
      //this.p[i] = this.p[i] +i; 
    }
  }
}


