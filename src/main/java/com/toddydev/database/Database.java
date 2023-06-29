package com.toddydev.database;

import com.toddydev.database.credentials.DatabaseCredential;
import com.toddydev.database.repository.Repository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {

    private DatabaseCredential credential;

    private HikariDataSource dataSource;
    private final HikariConfig config = new HikariConfig();

    public void start(DatabaseCredential credential) {
        this.credential = credential;
        config.setJdbcUrl("jdbc:mysql://" + credential.getHost() + ":" + credential.getPort() + "/" + credential.getDatabase());
        config.setUsername(credential.getUsername());
        config.setPassword(credential.getPassword());
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setMaximumPoolSize(10);
        config.setConnectionTimeout(5000);
        dataSource = new HikariDataSource(config);
    }

    public void createRepository(Repository repository) {
        repository.createRepository();
    }

    public void stop() {
        dataSource.close();
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            start(credential);
        }
        return getConnection();
    }

}
