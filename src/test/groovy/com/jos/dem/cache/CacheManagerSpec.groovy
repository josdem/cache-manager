package com.jos.dem.cache

import spock.lang.Specification

class CacheManagerSpec extends Specification {

  CacheManager cacheManager = new CacheManager()

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

}
