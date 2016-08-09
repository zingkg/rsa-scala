package com.zingkg.rsa

/**
 * The Key class contains the keys that are used in the RSA cryptographic algorithm.
 */
class Key private(private val publicKey: PublicKey, private val privateKey: PrivateKey) {
  /**
   * Default constructor.
   *
   * @param modulus
   *   The modulus that the public and private keys will utilize.
   * @param coprime
   *   The coprime that the public key will utilize.
   * @param multiplicativeInverse
   *   The multiplicative inverse that the private key will utilize.
   */
  def this(modulus: Int, coprime: Int, multiplicativeInverse: Int) = {
    this(new PublicKey(modulus, coprime), new PrivateKey(modulus, multiplicativeInverse))
  }

  /**
   * Encrypts a message according to this key's public key.
   *
   * @param message
   *   The message to encrypt.
   * @return The encrypted cipher.
   */
  def encrypt(message: Int): BigInt = {
    publicKey.encrypt(message)
  }

  /**
   * Decrypts a cipher according to this key's private key.
   * @param cipher
   *   The cipher to decrypt.
   * @return The decrypted message.
   */
  def decrypt(cipher: Int): BigInt = {
    privateKey.decrypt(cipher)
  }
}
