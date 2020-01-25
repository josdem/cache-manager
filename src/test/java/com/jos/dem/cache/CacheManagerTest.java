package com.jos.dem.cache;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CacheManagerTest {

  private CacheManager cacheManager = new CacheManager();

  @Test
  @DisplayName("should know cache manager is empty")
  void shouldKnowIfCacheIsEmpty(){
    assertTrue(cacheManager.isEmpty(), "should be empty");
  }

}
