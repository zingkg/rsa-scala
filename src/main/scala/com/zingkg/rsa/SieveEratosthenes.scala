package com.zingkg.rsa

import scala.collection.mutable.ArrayBuffer

/**
 * This class finds the primes using the sieve of eratosthenes method.
 */
object SieveEratosthenes {
  /**
   * Gets a list of all of the primes from a range of 2 to the inputted number. The inputted
   * number must be 1 or higher.
   *
   * @param num
   *   The number of elements to check for primes.
   * @return A list full of numbers with primes.
   */
  def getPrimes(num: Int): Seq[Int] = {
    if (num <= 0)
      throw new Exception("Primes cannot be negative or zero")

    val isPrime = new Array[Boolean](num)
    for(i <- isPrime.indices)
      isPrime(i) = true

    // Calculate primes
    for (i <- 2 until isPrime.length) {
      var j = 2
      while ((i * j) < isPrime.length) {
        isPrime(i * j) = false
        j = j + 1
      }
    }

    // Find primes
    val primes = new ArrayBuffer[Int]()
    for (i <- 2 until isPrime.length) {
      if (isPrime(i))
        primes.append(i)
    }
    primes.toList
  }
}
