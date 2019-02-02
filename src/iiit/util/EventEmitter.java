package iiit.util;
import java.util.*;


public class EventEmitter {
  private final HashMap<String, ArrayList<EventHandler>> map;
  
  public EventEmitter() {
    map = new HashMap<>();
  }
  
  public EventEmitter on(String event, EventHandler handler) {
    ArrayList<EventHandler> handlers = map.getOrDefault(event, new ArrayList<>());
    if(!handlers.contains(handler)) handlers.add(handler);
    map.put(event, handlers);
    return this;
  }
  
  public EventEmitter off(String event, EventHandler handler) {
    ArrayList<EventHandler> handlers = map.get(event);
    if(handlers!=null) handlers.remove(handler);
    return this;
  }
  
  protected EventEmitter emit(String event, Object value) {
    for(EventHandler handler : map.getOrDefault(event, new ArrayList<>())) {
      handler.on(event, value);
    }
    return this;
  }
}
