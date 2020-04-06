# how-to-write-an-equality-method-in-java [![Build Status](https://travis-ci.org/sairaghavak/how-to-write-an-equality-method-in-java.svg?branch=master)](https://travis-ci.org/sairaghavak/how-to-write-an-equality-method-in-java) [![codecov](https://codecov.io/gh/sairaghavak/how-to-write-an-equality-method-in-java/branch/master/graph/badge.svg)](https://codecov.io/gh/sairaghavak/how-to-write-an-equality-method-in-java)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://github.com/sairaghavak/how-to-write-an-equality-method-in-java/blob/master/LICENSE)

- When two objects are equal, then it should abide to the [mathematical Equivalence relation](https://en.wikipedia.org/wiki/Equivalence_relation)
  - Reflexive -  a = a
  - Symmetry - if a = b then b = a
  - Transitive - if a = b and b = c then a = c
  - consistent -  a = b should always be true when none of a and b are changed
  - For any non-null object a, a.equals(null) = false

**References:**
1. [https://www.artima.com/lejava/articles/equality.html](https://www.artima.com/lejava/articles/equality.html)

