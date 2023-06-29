package com.toddydev.database.repository;

import com.toddydev.DataAPI;
import com.toddydev.database.repository.column.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

@Getter @Setter
public abstract class Repository {

    private String tableName;
    private List<Column> columns;

    private String primaryColumn;

    public Repository(String tableName, Column... columns) {
        this.tableName = tableName;
        this.columns = Arrays.asList(columns);
    }

    public void createRepository() {
        try {
            Connection connection = DataAPI.getDatabase().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CREATE TABLE IF NOT EXISTS " + tableName + "(");
            for (Column column : columns) {
                stringBuilder.append(column.toString());
                int i = columns.indexOf(column);
                if (!contains(i+1))continue;
                stringBuilder.append(", ");
            }
            stringBuilder.append((primaryColumn != null ? ", PRIMARY KEY(" + primaryColumn + ")" : "") + ")");
            statement.execute(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean contains(int i) {
        try {
            columns.get(i);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
