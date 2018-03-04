package com.jos.dem.cache;

import java.util.Map;
import java.util.HashMap;

public class CacheManager {

  private static final Integer MAX_CAPACITY = 5;
  private ValidationStrategy strategy;
  private Map<String, String> cache = new HashMap<String, String>();

  public void setStrategy(ValidationStrategy strategy){
    this.strategy = strategy;
  }

  public void put(String key, String value){
    cache.put(key, value);
  }

  public String get(String key){
    return strategy.isValid(key) ? cache.get(key) : null;
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

  public Boolean isFull(){
    return cache.size() >= MAX_CAPACITY;
  }

}
