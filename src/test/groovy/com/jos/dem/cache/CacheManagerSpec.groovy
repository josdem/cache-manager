package com.jos.dem.cache

import spock.lang.Specification

class CacheManagerSpec extends Specification {

  CacheManager cacheManager = new CacheManager()

  ValidationStrategy strategy = Mock(ValidationStrategy)

  def setup(){
    strategy.isValid(_ as String) >> true
    cacheManager.setStrategy(strategy)
  }

  void "should know cache manager is empty"(){
    expect:'Is empty'
      cacheManager.isEmpty() == true
  }

  void "should add a new entity to the cache"(){
    when:'We add a new entity'
      cacheManager.put("josdem","developer")
    then:'We expect is not empty'
      cacheManager.isEmpty() == false
  }

  void "should get an entity from cache"(){
    when:'We add a new entity'
      cacheManager.put("josdem","developer")
    then:'We expect to get that entity'
      cacheManager.get('josdem') == 'developer'
  }

  void "should remove an entity from cache"(){
    when:'We add a new entity'
      cacheManager.put("josdem","developer")
    and:'We remove that entity'
      cacheManager.remove('josdem')
    then:'We expect is empty'
      cacheManager.isEmpty() == true
  }

  void "should invalidate a cache"(){
    when:'We add a couple entities'
      cacheManager.put("josdem","developer")
      cacheManager.put("tgrip","developer")
    and:'We invalidate cache'
      cacheManager.invalidate()
    then:'We expect is empty'
      cacheManager.isEmpty() == true
  }

}
