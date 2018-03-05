Cache Manager
------------------------------------

This project implements a custom cache manager

### Acceptance criteria

**First Milestone**

1. You can add with `put(key, value)` to your cache manager
2. You can get an entity from cache manager with `get(key)`
3. You can remove with `remove(key)` to your cache manager
4. You can call `invalidate()` to remove all elements from cache

**Second Milestone**

1. Cache has a validation rule, this validation could be expiration time, key or value format, priority, etc.
2. Implement validation support to the cache manager

**Third Milestone**

1. Cache has 5 max elements it can store
2. Cache is using key alphabetical replacement policy, therefore cache manager removes the last aphabetical key element in cache without any regard to how often or how many times it was accessed before.

### To run the project

```bash
gradle test
```
