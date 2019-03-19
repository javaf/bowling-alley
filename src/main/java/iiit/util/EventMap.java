package iiit.util;
import java.util.*;


public class EventMap {
  private final Map<String, List<Subscriber>> map;
  private static final List<Subscriber> NONE = new ArrayList<>();
  
  public EventMap() {
    map = new HashMap<>();
  }
  
  public EventMap on(String event, Subscriber handler) {
    List<Subscriber> handlers = map.getOrDefault(event, new ArrayList<>());
    if(!handlers.contains(handler)) handlers.add(handler);
    map.put(event, handlers);
    return this;
  }
  
  public EventMap off(String event, Subscriber handler) {
    List<Subscriber> handlers = map.get(event);
    if(handlers!=null) handlers.remove(handler);
    return this;
  }
  
  public EventMap emit(String event, Object data) {
    for (Subscriber handler : map.getOrDefault(event, map.getOrDefault("*", NONE)))
      handler.on(event, data);
    return this;
  }
}
