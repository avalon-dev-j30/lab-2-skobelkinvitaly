package ru.avalon.java.j30.labs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.Collection;
import java.util.Properties;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "DEV-OCPJP. Подготовка к сдаче сертификационных экзаменов серии Oracle
 * Certified Professional Java Programmer"
 * <p>
 * Тема: "JDBC - Java Database Connectivity"
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Main {

    /**
     * Точка входа в приложение
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM PRODUCT_CODE";
            try (ResultSet resultset = statement.executeQuery(query)) {
                while (resultset.next()) {

                }
                /*
         * TODO #14 Средствами отладчика проверьте корректность работы программы
                 */
            }
            /**
             * Выводит в кодсоль все коды товаров
             *
             * @param connection действительное соединение с базой данных
             * @throws SQLException
             */
    private static void printAllCodes(Connection connection) throws SQLException {
        Collection<ProductCode> codes = ProductCode.all(connection);
        for (ProductCode code : codes) {
            System.out.println(code);
        }
    }

    /**
     * Возвращает URL, описывающий месторасположение базы данных
     *
     * @return URL в виде объекта класса {@link String}
     */
    private static String getUrl() {
        String url = "jdbc:derby://localhost:1527/sample";
        return url;
//        throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * Возвращает параметры соединения
     *
     * @return Объект класса {@link Properties}, содержащий параметры user и
     * password
     */
    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("user", "app");
        properties.put("password", "app");
        return properties;
//        throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * Возвращает соединение с базой данных Sample
     *
     * @return объект типа {@link Connection}
     * @throws SQLException
     */
    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(getUrl(), getProperties());
        return connection;
    }

}
