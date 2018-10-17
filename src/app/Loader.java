package app;

import java.util.ArrayList;
import java.util.List;

public class Loader {

  public final List<LoaderListener> listeners = new ArrayList<>();

  public void addListener(LoaderListener listener) {
    listeners.add(listener);
  }

  public void removeListener(LoaderListener listener) {
    listeners.remove(listener);
  }

  public boolean load(String file) {
    boolean isLoad = false;
    // >> chain of responsibility pattern example
    for (LoaderListener listener : listeners) { // that's why "chain of responsibility" pattern has "chain" word in its name
      isLoad = listener.load(file);
      if (isLoad) {
        System.out.println(file + " is load by " + listener.getClass().getSimpleName());
        break;
      }
    }
    // <<
    return isLoad;
  }

  public boolean release(String file) {
    boolean isRelease = false;
    // >> chain of responsibility pattern example
    for (LoaderListener listener : listeners) {
      isRelease = listener.release(file);
      if (isRelease) {
        System.out.println(file + " is released by " + listener.getClass().getSimpleName());
        break;
      }
    }
    // <<
    return isRelease;
  }

}
