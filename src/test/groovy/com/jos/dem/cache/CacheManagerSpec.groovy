package com.jos.dem.cache

import spock.lang.Specification

class CacheManagerSpec extends Specification {

  CacheManager cacheManager = new CacheManager()

  void "should know cache manager is empty"(){
    expect:'Is empty'
      cacheManager.isEmpty() == true
  }

}
