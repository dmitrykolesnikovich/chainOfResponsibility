package graphicsService;

import app.Loader;
import app.LoaderListener;

public class Graphics extends LoaderListener {

  public Graphics(Loader loader) {
    super(loader);
  }

  @Override
  public boolean load(String file) {
    if (file.endsWith(".png")) {
      // load texture
      return true;
    }
    return false;
  }

  @Override
  public boolean release(String file) {
    if (file.endsWith(".png")) {
      // release texture
      return true;
    }
    return false;
  }

}
