package audioService;

import app.Loader;
import app.LoaderListener;

public class Audio extends LoaderListener {

  public Audio(Loader loader) {
    super(loader);
  }

  @Override
  public boolean load(String file) {
    if (file.endsWith(".mp3")) {
      // load mp3
      return true;
    }
    return false;
  }

  @Override
  public boolean release(String file) {
    if (file.endsWith(".mp3")) {
      // release mp3
      return true; // I am responsible! - that's why "chain of responsibility" pattern has "responsibility" word in its name
    }
    return false; // not my business
  }

}
