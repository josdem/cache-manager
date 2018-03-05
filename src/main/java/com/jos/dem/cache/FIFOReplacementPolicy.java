package com.jos.dem.cache;

import java.util.Map;
import java.util.TreeMap;

public class FIFOReplacementPolicy implements ReplacementPolicy {

  public void garbageCollect(Map<String, String> cache){
    Map.Entry<String,String> entry = ((TreeMap)cache).lastEntry();
    cache.remove(entry.getKey());
  }

}
