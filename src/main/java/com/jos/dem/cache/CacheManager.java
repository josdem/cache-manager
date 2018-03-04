package com.jos.dem.cache;

import java.util.Map;
import java.util.HashMap;

public class CacheManager {

  private Map<String, String> cache = new HashMap<String, String>();

  public void put(String key, String value){
    cache.put(key, value);
  }

  public String get(String key){
    return "";
  }

  public void remove(String key){
    cache.remove(key);
  }

  public void invalidate(){
    cache.clear();
  }

  public Boolean isEmpty(){
    return cache.isEmpty();
  }

}
