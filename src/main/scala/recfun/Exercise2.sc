/**************************************
   Exercise 2: Parentheses Balancing
***************************************
  Write a recursive function which verifies the balancing of parentheses in a string, which we represent as a List[Char] not a String. For example, the function should return true for the following strings:

  (if (zero? x) max (/ 1 x))
I told him (that it’s not (yet) done). (But he wasn’t listening)
The function should return false for the following strings:

  :-)
())(
  The last example shows that it’s not enough to verify that a string contains the same number of opening and closing parentheses.

  Do this exercise by implementing the balance function in Main.scala. Its signature is as follows:



1
def balance(chars: List[Char]): Boolean
There are three methods on List[Char] that are useful for this exercise:

  chars.isEmpty: Boolean returns whether a list is empty
chars.head: Char returns the first element of the list
  chars.tail: List[Char] returns the list without the first element
  Hint: you can define an inner function if you need to pass extra parameters to your function.

  Testing: You can use the toList method to convert from a String to aList[Char]: e.g. "(just an) example".toList.
  */

// iterate through the list of chars
// increment a counter for (
// decrement the counter for )
// check to see if the counter is 0 at the end

// counting is not enough, we need open then close pairs
// in addition to counting we should do the check
// if ) appears when count is 0, then fail

def balance(chars: List[Char]): Boolean = {
  def loop(counter: Int, chars: List[Char]): Boolean =
    if (chars.isEmpty) counter == 0
    else {
      val char = chars.head
      if (char == ')' && counter == 0) return false
      val newCounter: Int =
        if (char == '(') counter + 1
        else if (char == ')') counter - 1
        else counter
      loop(newCounter, chars.tail)
    }
  loop(0, chars)
}

balance("".toList)
balance("test".toList)
balance("test(".toList)
balance("test()".toList)
balance("test())".toList)
balance("test())(".toList)