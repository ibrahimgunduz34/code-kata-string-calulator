# Code Kata
## String Calculator
The repository was created with inspired the following site.
[http://osherove.com/tdd-kata-1/](http://osherove.com/tdd-kata-1/)

### Rules:

DONE:

* Empty string input must returns 0
* Single value input must return itself.
* Comma separated values input must return sum of them.
* New line char separated values input must return sum of them.
* An input like the following which consist of comma separated multiple values, single value and delimited by new lines must return sum.
   
```$xslt
1
2,3
4,5,6
7
8
9,10,11
```   
 
 * Any line can not finalize with comma. 
 * Each values must be integer. Otherwise it must throw **IllegalArgumentException**
 
 TODO:
 * Negative values must throw **IllegalArgumentException**
 * The values greater than 1000 must be ignored
 * A single char custom delimiter can be defined in the first line like the following:
 ```$xslt
//#
1#2
3
4#5#6
```
