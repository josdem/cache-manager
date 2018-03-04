package com.jos.dem.cache

import spock.lang.Specification

class ValidationStrategySpec extends Specification {

  CacheManager cacheManager = new CacheManager()
  ValidationStrategy strategy = Mock(ValidationStrategy)

  def setup(){
    cacheManager.setStrategy(strategy)
  }

  void "should not get a value since key is not valid"(){
    given:'A key'
      String key = 'josdem'
    when:'We store a value'
      cacheManager.put(key, 'developer')
    then:'We expect to get value'
      strategy.isValid(key) >> false
      cacheManager.get(key) == null
  }
}

