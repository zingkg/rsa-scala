package com.zingkg.rsa

import org.scalatest.FlatSpec

class RSASpec extends FlatSpec {
  "RSA" should "equal decrypted value" in {
    /**
     * Encrypts and decrypts a message using a key.
     *
     * @param key
     *   The key to use when encrypting and decrypting.
     * @param message
     *   The message to encrypt and to obtain.
     * @return True if the message was encrypted and decrypted successfully.
     */
    def encryptAndDecrypt(key: Key, message: Int): Int = {
      key.decrypt(key.encrypt(message).intValue()).intValue()
    }

    val key = RSA.generateKey(661, 547)
    assert(encryptAndDecrypt(key, 255) == 255)
    assert(encryptAndDecrypt(key, 634) == 634)

    assert(encryptAndDecrypt(RSA.generateKey, 255) == 255)
  }

  "GCD" should "get GCD" in {
    assert(RSA.gcd(54, 24) == 6)
  }
}
