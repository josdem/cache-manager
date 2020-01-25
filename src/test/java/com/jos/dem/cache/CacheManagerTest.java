package com.jos.dem.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CacheManagerTest {

  @InjectMocks
  private CacheManager cacheManager = new CacheManager();
  @Mock
  private ValidationStrategy validationStrategy;

  @BeforeEach
  void setup(){
    MockitoAnnotations.initMocks(this);
    when(validationStrategy.isValid(anyString())).thenReturn(true);
    cacheManager.setStrategy(validationStrategy);
  }

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
    assertEquals("developer", cacheManager.get("josdem"), "should be developer");
  }

  @Test
  @DisplayName("should remove an entity from cache")
  void shouldRemoveEntityFromCache() {
    cacheManager.put("josdem", "developer");
    cacheManager.remove("josdem");
    assertTrue(cacheManager.isEmpty(), "should be empty");
  }

  @Test
  @DisplayName("should invalidate a cache")
  void shouldInvalidateCache() {
    cacheManager.put("josdem", "developer");
    cacheManager.put("tgrip", "developer");
    cacheManager.invalidate();
    assertTrue(cacheManager.isEmpty(), "should be empty");
  }

}
