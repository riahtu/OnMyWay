package com.CMPUT301W20T24.OnMyWay;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Utilities {
    private static final String TAG = "OMW/Utilities";   // Use this tag for call Log.d()

    /**
     * Generates and returns the MD5 hash of a given string
     * @param string The string we want to get a hash of
     * @return An MD5 hash as a string
     * @author John
     */
    /// StackOverflow post by Den Delimarsky
    /// Author: https://stackoverflow.com/users/303696/den-delimarsky
    /// Answer: https://stackoverflow.com/questions/4846484/md5-hashing-in-android
    public static String md5(String string) {
        if (string == "" || string == null) {
            throw new IllegalArgumentException("Getting the hash of an empty string makes no sense");
        }
        else {
            try {
                // Create MD5 Hash
                MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
                digest.update(string.getBytes());
                byte[] messageDigest = digest.digest();

                // Create Hex String
                StringBuilder hexString = new StringBuilder();
                for (byte aMessageDigest : messageDigest) {
                    String hexDigit = Integer.toHexString(0xFF & aMessageDigest);
                    while (hexDigit.length() < 2)
                        hexDigit = "0" + hexDigit;
                    hexString.append(hexDigit);
                }
                return hexString.toString();

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return "";
        }
    }


    /**
     * Takes a string and capitalizes the first letter of it
     * @param string The string we want to capitalize
     * @return The capitalized string
     * @author John
     */
    // Capitalize the first letter of a string
    static public String capitalize(String string) {
        if (string == "" || string == null) {
            throw new IllegalArgumentException("The string passed to capitalize is empty");
        }
        else {
            return string.substring(0, 1).toUpperCase() + string.substring(1);
        }
    }


    /**
     * Check if a string is null, returning it if not. Otherwise a NullPointerException is thrown
     * @param stringToCheck The string we want to check
     * @return The string that was originally passed to the method
     * @author John
     */
    // Check if a string is null and throw an error if so
    static public String checkStringNotNull(String stringToCheck) {
        if (stringToCheck == null) {
            throw new NullPointerException("The string fetched from FireStore is null. Make sure data is added for this user");
        }
        else {
            return stringToCheck;
        }
    }


    /**
     * Check if a Boolean object is null, returning it's primitive value if not.
     * Otherwise a NullPointerException is thrown
     * @param booleanToCheck The Boolean object we want to check
     * @return The primitive boolean from the input object
     * @author John
     */
    // Check if a Boolean object is null and return the value if not
    static public boolean checkBooleanNotNull(Boolean booleanToCheck) {
        if (booleanToCheck == null) {
            throw new NullPointerException("The string fetched from FireStore is null. Make sure data is added for this user");
        }
        else {
            return booleanToCheck;    // No unboxing needed. This is cast to a boolean automatically
        }
    }


    /**
     * Check if a Long object is null or negative, returning it's primitive value as an int if not.
     * Otherwise a NullPointerException is thrown
     * @param longToCheck The Long object we want to check
     * @return The primitive int extracted from the input object
     * @author John
     */
    // Check if a Long object is null and return the value as an int if not
    static public int checkLongNotNull(Long longToCheck) {
        if (longToCheck == null || longToCheck < 0) {
            throw new NullPointerException("The string fetched from FireStore is null. Make sure data is added for this user");
        }
        else {
            return longToCheck.intValue();
        }
    }
}
