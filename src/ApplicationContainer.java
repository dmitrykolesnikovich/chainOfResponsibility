import app.Application;
import app.Loader;
import audioService.Audio;
import graphicsService.Graphics;

public class ApplicationContainer {

  public static void main(String[] args) throws Exception {
    new ApplicationContainer().launch();
  }

  private void launch() throws Exception {
    String[] resources = {"sound.mp3", "texture.png"};
    Application app = new Application();
    injectServices(app);
    app.loadResources(resources);
    app.simulation();
    app.releaseResources(resources);
  }

  // the reason to have chain of responsibility pattern in our app is to inject services outside of Application object
  // in real world architecture Application, ApplicationContainer, Audio and Graphics classes would be in separate projects

  // So our final design is like this:
  // ApplicationContainer depends on Application
  // Audio depends on Application
  // Graphics depends on Application
  // Application has no external Application
  // Profit is about having only one dependency for every module
  // that called modular code
  // and this is great!
  private void injectServices(Application app) throws Exception {
    // example:
    // new Graphics(app.loader); // in real world application code of this guy may be loaded from internet and loading it in runtime
    // real world:
    loadClassFromInternet("graphics").getConstructor(Loader.class).newInstance(app.loader);
    new Audio(app.loader);
  }

  private Class loadClassFromInternet(String serviceId) {
    switch (serviceId) {
      case "graphics":
        return Graphics.class; // fake for simplicity
      default: {
        throw new IllegalArgumentException("serviceId: " + serviceId);
      }
    }
  }

}
