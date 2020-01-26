package com.jos.dem.cache

import spock.lang.Specification

class ReplacementPolicySpec extends Specification {

  CacheManager cacheManager = new CacheManager()

  ValidationStrategy strategy = Mock(ValidationStrategy)
  ReplacementPolicy policy = new AlphabeticalReplacementPolicy();

  def setup(){
    strategy.isValid(_ as String) >> true
    cacheManager.setStrategy(strategy)
    cacheManager.setPolicy(policy)
  }

  void "should add a new entity using FIFO policy"(){
    given:'We 5 entries'
      cacheManager.put('josdem','developer')
      cacheManager.put('tgrip','developer')
      cacheManager.put('skuarch','developer')
      cacheManager.put('emoranchel','developer')
      cacheManager.put('jeduan','developer')
    when:'We add an extra entity'
      cacheManager.put('siedrix','developer')
    then:'We expect 5 elements and new entity added'
      cacheManager.isFull() == true
      cacheManager.get('tgrip') == null
      cacheManager.get('siedrix') == 'developer'
  }

}