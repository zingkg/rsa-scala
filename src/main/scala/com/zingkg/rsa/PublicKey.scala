package com.zingkg.rsa

/**
 * The public key portion of the RSA algorithm. The public key is used to encrypt a message to be
 * passed along as a cipher.
 * @author zingkg
 */
class PublicKey(private val modulus: Int, private val coprime: Int) {
  /**
   * Encrypts the message using the modulus and coprime.
   *
   * @param message
   *   The message to encrypt.
   * @return The cipher.
   */
  def encrypt(message: Int): BigInt = {
    val encrypted: BigInt = message
    encrypted.pow(coprime).mod(modulus)
  }
}
