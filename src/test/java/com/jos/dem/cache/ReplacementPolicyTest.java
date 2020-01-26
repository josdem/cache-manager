package com.jos.dem.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ReplacementPolicyTest {

  private CacheManager cacheManager = new CacheManager();

  @Mock
  private ValidationStrategy strategy;
  private ReplacementPolicy policy = new AlphabeticalReplacementPolicy();

  @BeforeEach
  void setup(){
    MockitoAnnotations.initMocks(this);
    when(strategy.isValid(anyString())).thenReturn(true);
    cacheManager.setStrategy(strategy);
    cacheManager.setPolicy(policy);
  }

  @Test
  @DisplayName("should add a new entity using FIFO policy")
  void shouldAddnNewEntityUsingFifoPolicy(){
    cacheManager.put("josdem","developer");
    cacheManager.put("tgrip","developer");
    cacheManager.put("skuarch","developer");
    cacheManager.put("emoranchel","developer");
    cacheManager.put("jeduan","developer");
    cacheManager.put("siedrix","developer");
    assertNull(cacheManager.get("tgrip"), "should be null");
    assertEquals("developer", cacheManager.get("siedrix"), "should get siedrix");
  }



}
