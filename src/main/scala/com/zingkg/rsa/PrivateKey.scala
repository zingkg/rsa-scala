package com.zingkg.rsa

/**
 * The private key component of the rsa.Key in the RSA algorithm. The private key is used to decrypt a
 * cipher into its original message.
 */
class PrivateKey(private val modulus: Int, private val multiplicativeInverse: Int) {
  /**
   * Decrypts a cipher into a message.
   *
   * @param cipher The cipher to decrypt
   * @return The decrypted message.
   */
  def decrypt(cipher: Int): BigInt = {
    val decrypted: BigInt = cipher
    decrypted.pow(multiplicativeInverse).mod(modulus)
  }
}
