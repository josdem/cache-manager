package com.jos.dem.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CacheManagerTest {

  private CacheManager cacheManager = new CacheManager();

  @Test
  @DisplayName("should know cache manager is empty")
  void shouldKnowIfCacheIsEmpty() {
    assertTrue(cacheManager.isEmpty(), "should be empty");
  }

  @Test
  @DisplayName("should add a new entity to the cache")
  void shouldAddNewEntityToCache() {
    cacheManager.put("josdem", "developer");
    assertFalse(cacheManager.isEmpty(), "should not be empty");
  }

  @Test
  @DisplayName("should get an entity from cache")
  void shouldGetEntityFromCache(){
    cacheManager.put("josdem", "developer");
    assertEquals("developer", cacheManager.get("josdem"));
  }

}
