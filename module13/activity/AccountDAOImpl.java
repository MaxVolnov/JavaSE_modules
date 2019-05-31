package sef.module13.activity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    @SuppressWarnings("unused")
    private Connection conn;

    public AccountDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public List<Account> findAccount(String firstName, String lastName) throws AccountDAOException {
        List accounts = new ArrayList();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ACCOUNT WHERE FIRST_NAME LIKE '" + String.valueOf(firstName) + "%'" +  "AND LAST_NAME LIKE '" + String.valueOf(lastName) + "%'");
            while (rs.next()) {
                Account account = new AccountImpl(rs.getInt("ID"),
                        rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"),
                        rs.getString("E_MAIL"));
                accounts.add(account);
            }
            return accounts;

        } catch (SQLException e) {
            throw new AccountDAOException(e.getMessage(), e.getCause());
        }
    }

    public Account findAccount(int id) throws AccountDAOException {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ACCOUNT WHERE ID = " + String.valueOf(id));

            while (rs.next()) {
                Account account = new AccountImpl(rs.getInt("ID"),
                        rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"),
                        rs.getString("E_MAIL"));
                return account;
            }

        } catch (SQLException e) {
            throw new AccountDAOException(e.getMessage(), e.getCause());
        }
        return null;
    }


    public boolean insertAccount(String firstName, String lastName, String email) throws AccountDAOException {
        /*long myId = 0;
        try {
            Statement stc = conn.createStatement();
            ResultSet rs = stc.executeQuery("select ACCOUNT_SEQ.NEXTVAL");
            myId = rs.getLong(1);
        } catch (SQLException ce) {
            throw new AccountDAOException(ce.getMessage(), ce.getCause());
        }*/
        try {
            PreparedStatement sti = conn.prepareStatement("INSERT INTO ACCOUNT (ID, FIRST_NAME, LAST_NAME, E_MAIL) values (999, ?, ?, ?)" );
           sti.setString(1, firstName);
           sti.setString(2, lastName);
           sti.setString(3, email);
           int raws = sti.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new AccountDAOException(e.getMessage(), e.getCause());
        }
    }
}
