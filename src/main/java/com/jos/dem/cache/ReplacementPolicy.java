package com.jos.dem.cache;

import java.util.Map;

public interface ReplacementPolicy {
  void garbageCollect(Map<String, String> cache);
}
