public static String vigenere_cipher(String plaintext, String key, boolean encrypt) 
{

    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ,.-"; 
    final int alphabetSize = alphabet.length();
    final int textSize = plaintext.length();
    final int keySize = key.length();
    final StringBuilder encryptedText = new StringBuilder(textSize);
    for (int i = 0; i < textSize; i++) 
    {
        final char plainChar = plaintext.charAt(i); 
        final char keyChar = key.charAt(i % keySize); 
        final int plainPos = alphabet.indexOf(plainChar); 
        if (plainPos == -1) 
        { 
            encryptedText.append(plainChar);
        }
        else 
        { 
            final int keyPos = alphabet.indexOf(keyChar); 
            if (encrypt) 
            { 
                encryptedText.append(alphabet.charAt((plainPos+keyPos) % alphabetSize));
            }
            else 
            { 
                int shiftedPos = plainPos-keyPos;
                if (shiftedPos < 0) 
                {
                    shiftedPos += alphabetSize;
                }
                encryptedText.append(alphabet.charAt(shiftedPos));
            }
        }
    }

    return encryptedText.toString();
