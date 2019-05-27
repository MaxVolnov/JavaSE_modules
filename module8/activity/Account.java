package sef.module8.activity;


import sef.module5.sample.SingletonRecommended;

/**
 * Thsi class represents a simple representation of an account encapsulating
 * a name
 *
 * @author John Doe
 */
public class Account {
    String accountName = null;

    /**
     * Creates an Account object with the specified name.  If the accout name
     * given violates the minimum requirements, then an AccountException is thrown
     *
     * @param accountName
     * @throws AccountException
     */
    public Account(String accountName) throws AccountException {
        if (accountName.length() < 4) {
            throw new AccountException(AccountException.NAME_TOO_SHORT, accountName);
        }
        /*
        int num = 0;
        int chr = 0;
        boolean chr.isDigit();
        for (int i = 0; i <= name.length(); i++) {
            if (name.charAt(i) > '0' && name.charAt(i) < '9') {
                num++;
            }
            if (name.charAt(i) < 'A' || name.charAt(i) > 'z') {
                chr++;
            }
        }
        if (num == 0 || chr == 0) {
            message = NAME_TOO_SIMPLE;
        }*/
        boolean digitFound = false;
        boolean letterFound = false;
        for (char ch : accountName.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitFound = true;
            }
            if (Character.isLetter(ch)) {
                letterFound = true;
            }
        }
        if (!digitFound || !letterFound) {
            throw new AccountException(AccountException.NAME_TOO_SIMPLE, accountName);
        }
        this.accountName = accountName;

    }


    /**
     * Returns the account name
     *
     * @return the account name
     */
    public String getName() {
        return accountName;
    }
}
