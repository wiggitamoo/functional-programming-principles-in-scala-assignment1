package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if(c == 0 || c == r) 1
      else pascal(c, r-1) + pascal(c-1, r-1)
    }
  
  /**
   * Exercise 2
   */
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
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def loop(money: Int, coins: List[Int]): Int = {
        if (money == 0) 1
        else if (money < 0 || coins.length == 0) 0
        else loop(money, coins.tail) + loop(money - coins.head, coins)
      }
      loop(money, coins.distinct)
    }
  }
