package app;

public class Application {

  public final Loader loader = new Loader();

  public void loadResources(String... resources) {
    for (String resource : resources) {
      loader.load(resource);
    }
  }

  public void releaseResources(String... resources) {
    for (String resource : resources) {
      loader.release(resource);
    }
  }

  public void simulation() {
    for (int i = 0; i < 4; i++) {
      System.out.println("update frame");
      try {
        Thread.sleep(500);
      } catch (InterruptedException skip) {
        // no op
      }
    }
  }

}
