package iiit.util;


public interface Subscriber {
  public void on(String event, Object data);
}
