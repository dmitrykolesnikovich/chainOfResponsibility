package app;

public abstract class LoaderListener {

  private final Loader loader;

  public LoaderListener(Loader loader) {
    this.loader = loader;
    init();
  }

  public abstract boolean load(String file);

  public abstract boolean release(String file);

  public void init() {
    loader.addListener(this);
  }

  public void destroy() {
    loader.removeListener(this);
  }

}
