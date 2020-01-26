package com.jos.dem.cache;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ValidationStrategyTest {

  @InjectMocks
  private CacheManager cacheManager = new CacheManager();
  @Mock
  private ValidationStrategy validationStrategy;

  @BeforeEach
  void setup(){
    MockitoAnnotations.initMocks(this);
    cacheManager.setStrategy(validationStrategy);
  }

  @Test
  @DisplayName("should not get a value since key is not valid")
  void shouldNotGetValueSinceIsNotValidKey(){
    String key = "josdem";
    when(validationStrategy.isValid(key)).thenReturn(false);
    cacheManager.put("josdem", "developer");
    assertTrue(cacheManager.isEmpty(), "should be empty");
  }

}
