package iiit.util;
import java.util.*;


public class EventEmitter {
  private final HashMap<String, ArrayList<EventHandler>> map;
  private static final ArrayList<EventHandler> NONE = new ArrayList<>();
  
  public EventEmitter() {
    map = new HashMap<>();
  }
  
  public EventEmitter on(String event, EventHandler handler) {
    ArrayList<EventHandler> handlers = map.getOrDefault(event, NONE);
    if(!handlers.contains(handler)) handlers.add(handler);
    map.put(event, handlers);
    return this;
  }
  
  public EventEmitter off(String event, EventHandler handler) {
    ArrayList<EventHandler> handlers = map.get(event);
    if(handlers!=null) handlers.remove(handler);
    return this;
  }
  
  public EventEmitter emit(String event, Object value) {
    for(EventHandler handler : map.getOrDefault(event, map.getOrDefault("*", NONE)))
      handler.on(event, value);
    return this;
  }
}
