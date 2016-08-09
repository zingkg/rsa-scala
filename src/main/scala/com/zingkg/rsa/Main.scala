package com.zingkg.rsa

/**
 * Simple main class to test the RSA algorithm and see if it fails.
 */
object Main {
  /**
   * The main for the program that holds tests.
   *
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    testRsa(255, 61, 53)
    testRsa(65, 61, 53)
    testRsa(800)
  }

  /**
   * Tests the RSA algorithm with a message and random primes.
   *
   * @param message The message to test.
   */
  def testRsa(message: Int): Unit = {
    val key = RSA.generateKey

    if (encryptAndDecrypt(key, message))
      println("Success with message " + message + " and random primes")
    else
      println("Failure with message " + message + " and random primes")
  }

  /**
   * Tests the RSA algorithm with a message and inputted primes.
   *
   * @param message The message to test.
   * @param publicPrime The public's prime.
   * @param privatePrime The private's prime.
   */
   def testRsa(message: Int, publicPrime: Int, privatePrime: Int): Unit = {
    val key = RSA.generateKey(publicPrime, privatePrime)

    if (encryptAndDecrypt(key, message))
      println("Success with message " + message + " and primes " + publicPrime + ", " + privatePrime)
    else
      println("Failure with message " + message + " and primes " + publicPrime + ", " + privatePrime)
  }

  /**
   * Encrypts and decrypts a message using a key.
   *
   * @param key The key to use when encrypting and decrypting.
   * @param message The message to encrypt and to obtain.
   * @return True if the message was encrypted and decrypted successfully.
   */
  def encryptAndDecrypt(key: Key, message: Int): Boolean = {
    val cipher = key.encrypt(message)
    val decrypted = key.decrypt(cipher.intValue())
    message == decrypted.intValue()
  }
}
