package com.jos.dem.cache;

import java.util.Map;
import java.util.TreeMap;

public class CacheManager {

  private static final Integer MAX_CAPACITY = 5;
  private ValidationStrategy strategy;
  private ReplacementPolicy policy;
  private Map<String, String> cache = new TreeMap<String, String>();

  public void setStrategy(ValidationStrategy strategy){
    this.strategy = strategy;
  }

  public void setPolicy(ReplacementPolicy policy){
    this.policy = policy;
  }

  public void put(String key, String value){
    System.out.println("------");
    if(isFull()){
      policy.garbageCollect(cache);
    }
    cache.put(key, value);
    cache.forEach((k,v) -> System.out.println(k + ":" + v));
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
