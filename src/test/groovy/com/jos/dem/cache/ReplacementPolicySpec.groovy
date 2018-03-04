package com.jos.dem.cache

import spock.lang.Specification

class ReplacementPolicySpec extends Specification {

  CacheManager cacheManager = new CacheManager()

  void "should fill cache"(){
    when:'We add 5 entries'
      cacheManager.put('josdem','developer')
      cacheManager.put('tgrip','developer')
      cacheManager.put('skuarch','developer')
      cacheManager.put('emoranchel','developer')
      cacheManager.put('jeduan','developer')
    then:'We expect cache is full'
     cacheManager.isFull() == true
  }
}
