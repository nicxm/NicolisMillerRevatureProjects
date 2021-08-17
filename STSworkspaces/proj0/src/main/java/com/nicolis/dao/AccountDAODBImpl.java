package com.nicolis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nicolis.proj0.Account;
import com.nicolis.util.JDBCCon;

public class AccountDAODBImpl implements AccountDAO {

	public static Connection conn = JDBCCon.getConnection();

	@Override
	public Account createAccount(Account a) {
		String sql = "INSERT INTO accounts VALUES (default,?,?,?) RETURNING *";

		try {
			// Set up prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			// values for placeholder
			createPlaceholders(a, ps);

			// execute query, store the result
			ResultSet rs = ps.executeQuery();
			// extract results
			if (rs.next()) {
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account getAccount(int id, int client_id) {
		String sql = "SELECT * FROM accounts WHERE a_id = ? AND client_id = ?";

		try {
			// Set up prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			// values for placeholder
			ps.setInt(1, id);
			ps.setInt(2, client_id);
			// execute query, store the result
			ResultSet rs = ps.executeQuery();
			// extract results
			if (rs.next()) {
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Account> getAllAccounts(int client_id) {
		String sql = "SELECT * FROM accounts WHERE client_id = ?";

		try {
			// Set up prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			// values for placeholder
			ps.setInt(1, client_id);
			// execute query, store the result
			ResultSet rs = ps.executeQuery();
			// extract results
			List<Account> accounts = new ArrayList<Account>();
			while (rs.next()) {
				// add each client to the list
				accounts.add(buildAccount(rs));
			}
			return accounts;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Account> getAllAccounts(int client_id, int funds, int funds1) {
		String sql = "SELECT * FROM accounts WHERE client_id = ? AND funds < ? AND funds > ?";

		try {
			// Set up prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			// values for placeholder
			ps.setInt(1, client_id);
			ps.setInt(2, funds);
			ps.setInt(3, funds1);
			// execute query, store the result
			ResultSet rs = ps.executeQuery();
			// extract results
			List<Account> accounts = new ArrayList<Account>();
			while (rs.next()) {
				// add each client to the list
				accounts.add(buildAccount(rs));
			}
			return accounts;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account updateAccount(Account change) {
		String sql = "UPDATE accounts SET funds=?, accountType=? WHERE a_id=? AND client_id=? RETURNING *";

		try {
			// Set up prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			// values for placeholder
			createChangePlaceholders(change, ps);
			// execute query, store the result
			ResultSet rs = ps.executeQuery();
			// extract results
			if (rs.next()) {
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account deleteAccount(int id) {
		String sql = "DELETE FROM accounts WHERE a_id = ? RETURNING *";

		try {
			// Set up prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			// values for placeholder
			ps.setInt(1, id);
			// execute query, store the result
			ResultSet rs = ps.executeQuery();
			// extract results
			if (rs.next()) {
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account transferFunds(int funds) {
		return null;
	}

	@Override
	public Account withdrawFunds(Account withdraw, int x, int id, int client_id) {
		String sql = "UPDATE accounts SET funds = funds - ? WHERE a_id=? AND client_id=? RETURNING *";

		try {
			// Set up prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			// values for placeholder
			ps.setInt(1, x);
			ps.setInt(2, id);
			ps.setInt(3, client_id);
			// execute query, store the result
			ResultSet rs = ps.executeQuery();
			// extract results
			if (rs.next()) {
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account depositFunds(Account deposit, int x, int id, int client_id) {
		String sql = "UPDATE accounts SET funds = funds + ? WHERE a_id=? AND client_id=? RETURNING *";

		try {
			// Set up prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			// values for placeholder
			ps.setInt(1, x);
			ps.setInt(2, id);
			ps.setInt(3, client_id);
			// execute query, store the result
			ResultSet rs = ps.executeQuery();
			// extract results
			if (rs.next()) {
				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		return null;
	}

	@Override
	public List<Account> getAllAccounts(int client_id, int funds) {
		return null;
	}

	@Override
	public Account getAccount(int id) {
		return null;
	}

	// helper method
	private Account buildAccount(ResultSet rs) throws SQLException {
		Account a = new Account();
		a.setId(rs.getInt("a_id"));
		a.setFunds(rs.getInt("funds"));
		a.setAccountType(rs.getString("accountType"));
		a.setClient_id(rs.getInt("client_id"));
		return a;
	}

	private void createPlaceholders(Account a, PreparedStatement ps) throws SQLException {
		ps.setInt(1, a.getFunds());
		ps.setString(2, a.getAccountType());
		ps.setInt(3, a.getClient_id());
	}

	private void createChangePlaceholders(Account change, PreparedStatement ps) throws SQLException {
		ps.setInt(1, change.getFunds());
		ps.setString(2, change.getAccountType());
		ps.setInt(3, change.getId());
		ps.setInt(4, change.getClient_id());
	}

	@Override
	public Account createAccount(Account a, int client_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account depositFunds(Account deposit, int x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account withdrawFunds(Account withdraw, int x) {
		// TODO Auto-generated method stub
		return null;
	}

}
