package com.nicolis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nicolis.proj0.Client;
import com.nicolis.util.JDBCCon;

public class ClientDAODBImpl implements ClientDAO {

	public static Connection conn = JDBCCon.getConnection();

	@Override
	public Client createClient(Client c) {
		String sql = "INSERT INTO clients VALUES (default,?,?,?,?,?) RETURNING *";

		try {
			// Set up prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			// values for placeholder
			createPlaceholders(c, ps);
			// execute query, store the result
			ResultSet rs = ps.executeQuery();
			// extract results
			if (rs.next()) {
				return buildClient(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client getClient(int id) {
		String sql = "SELECT * FROM clients WHERE ID = ?";

		try {
			// Set up prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			// values for placeholder
			ps.setInt(1, id);
			// execute query, store the result
			ResultSet rs = ps.executeQuery();
			// extract results
			if (rs.next()) {
				return buildClient(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Client> getAllClients() {
		String sql = "SELECT * FROM clients";

		try {
			// Set up prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			// execute query, store the result
			ResultSet rs = ps.executeQuery();
			// extract results
			List<Client> clients = new ArrayList<Client>();
			while (rs.next()) {
				// add each client to the list
				clients.add(buildClient(rs));
			}
			return clients;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Client updateClient(Client change) {
		String sql = "UPDATE clients SET username=?, pass=?, email=?, phone=?, available=? WHERE id=? RETURNING *";

		try {
			// Set up prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			// values for placeholder
			createChangePlaceholders(change, ps);
			// execute query, store the result
			ResultSet rs = ps.executeQuery();
			// extract results
			if (rs.next()) {
				return buildClient(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Client deleteClient(int id) {
		String sql = "DELETE FROM clients WHERE id = ? RETURNING *";

		try {
			// Set up prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			// values for placeholder
			ps.setInt(1, id);
			// execute query, store the result
			ResultSet rs = ps.executeQuery();
			// extract results
			if (rs.next()) {
				return buildClient(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Client isAvailable(boolean available) {
		return null;
	}

	// helper method
	private Client buildClient(ResultSet rs) throws SQLException {
		Client c = new Client();
		c.setId(rs.getInt("id"));
		c.setUser(rs.getString("username"));
		c.setPhone(rs.getString("phone"));
		c.setPass(rs.getString("pass"));
		c.setEmail(rs.getString("email"));
		c.setAvailable(rs.getBoolean("available"));
		return c;
	}

	private void createPlaceholders(Client c, PreparedStatement ps) throws SQLException {
		ps.setString(1, c.getUser());
		ps.setString(2, c.getPass());
		ps.setString(3, c.getEmail());
		ps.setString(4, c.getPhone());
		ps.setBoolean(5, c.isAvailable());
	}

	private void createChangePlaceholders(Client change, PreparedStatement ps) throws SQLException {
		ps.setString(1, change.getUser());
		ps.setString(2, change.getPass());
		ps.setString(3, change.getEmail());
		ps.setString(4, change.getPhone());
		ps.setBoolean(5, change.isAvailable());
		ps.setInt(6, change.getId());
	}
}
