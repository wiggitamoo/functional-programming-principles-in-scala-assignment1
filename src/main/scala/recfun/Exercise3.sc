/********************************
   Exercise 3: Counting Change
*********************************
  * @param money
  * @param coins
  * @return
  *

Write a recursive function that counts how many different ways you can make change for an amount, given a list of coin denominations. For example, there are 3 ways to give change for 4 if you have coins with denomination 1 and 2: 1+1+1+1, 1+1+2, 2+2.

Do this exercise by implementing the countChange function inMain.scala. This function takes an amount to change, and a list of unique denominations for the coins. Its signature is as follows:



1
def countChange(money: Int, coins: List[Int]): Int
Once again, you can make use of functions isEmpty, head and tail on the list of integers coins.

Hint: Think of the degenerate cases. How many ways can you give change for 0 CHF(swiss money)? How many ways can you give change for >0 CHF, if you have no coins?

  */

// first need to remove duplicates

/*
Extract from https://mitpress.mit.edu/sicp/full-text/book/book-Z-H-11.html#%_sec_1.2.2

The number of ways to change amount a using n kinds of coins equals
    --  the number of ways to change amount a using all but the first kind of coin, plus
    --  the number of ways to change amount a - d using all n kinds of coins, where d is the denomination of the first kind of coin.


We can easily translate this description into a recursive procedure:

(define (count-change amount)
  (cc amount 5))
(define (cc amount kinds-of-coins)
  (cond ((= amount 0) 1)
        ((or (< amount 0) (= kinds-of-coins 0)) 0)
        (else (+ (cc amount
                     (- kinds-of-coins 1))
                 (cc (- amount
                        (first-denomination kinds-of-coins))
                     kinds-of-coins)))))
(define (first-denomination kinds-of-coins)
  (cond ((= kinds-of-coins 1) 1)
        ((= kinds-of-coins 2) 5)
        ((= kinds-of-coins 3) 10)
        ((= kinds-of-coins 4) 25)
        ((= kinds-of-coins 5) 50)))
 */


def countChange(money: Int, coins: List[Int]): Int = {
  def loop(amount: Int, coins: List[Int]): Int = {
    if (amount == 0) 1
    else if (amount < 0 || coins.length == 0) 0
    else loop(amount, coins.tail) + loop(amount - coins.head, coins)
  }
  loop(money, coins.distinct)
}

countChange(20, List(1, 10))

def x = List(1)
x.length
x.tail.length