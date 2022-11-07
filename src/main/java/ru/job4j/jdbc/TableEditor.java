package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        Class.forName(properties.getProperty("hibernate.connection.driver_class"));
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createStatement(String request) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(request);
        }
    }

    public void createTable(String tableName) throws SQLException {
        String sql = String.format(
                "create table %s (%s);", tableName,
                "id serial primary key"
        );
        createStatement(sql);
    }

    public void dropTable(String tableName) throws SQLException {
        String sql = String.format(
                "drop table %s;", tableName
        );
        createStatement(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        String sql = String.format(
                "alter table %s add column %s %s;", tableName, columnName, type
        );
        createStatement(sql);
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        String sql = String.format(
                "alter table %s drop %s;", tableName, columnName
        );
        createStatement(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName)
            throws SQLException {
        String sql = String.format(
                "alter table %s rename column %s to %s;", tableName, columnName, newColumnName
        );
        createStatement(sql);
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args)  throws Exception {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader()
                .getResourceAsStream("psql.properties")) {
            config.load(in);
        }

        try (TableEditor tableEditor = new TableEditor(config)) {
            tableEditor.createTable("people");
            System.out.println(getTableScheme(tableEditor.connection, "people"));
            tableEditor.addColumn("people", "name", "text");
            tableEditor.addColumn("people", "surname", "varchar(20)");
            tableEditor.addColumn("people", "age", "int");
            System.out.println(getTableScheme(tableEditor.connection, "people"));
            tableEditor.renameColumn("people", "age", "how_old");
            System.out.println(getTableScheme(tableEditor.connection, "people"));
            tableEditor.dropColumn("people", "how_old");
            System.out.println(getTableScheme(tableEditor.connection, "people"));
            tableEditor.dropTable("people");
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
