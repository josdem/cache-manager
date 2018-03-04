package com.jos.dem.cache

import spock.lang.Specification

class ReplacementPolicySpec extends Specification {

  CacheManager cacheManager = new CacheManager()

  ValidationStrategy strategy = Mock(ValidationStrategy)

  def setup(){
    strategy.isValid(_ as String) >> true
    cacheManager.setStrategy(strategy)
  }

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

  void "should add a new entity using FIFO policy"(){
    given:'We 5 entries'
      cacheManager.put('josdem','developer')
      cacheManager.put('tgrip','developer')
      cacheManager.put('skuarch','developer')
      cacheManager.put('emoranchel','developer')
      cacheManager.put('jeduan','developer')
    when:'We add an extra entity'
      cacheManager.put('josdem','developer')
    then:'We expect 5 elements and new entity added'
      cacheManager.isFull() == true
      cacheManager.get('josdem') == null
      cacheManager.get('siedrix') == 'developer'
  }

}
