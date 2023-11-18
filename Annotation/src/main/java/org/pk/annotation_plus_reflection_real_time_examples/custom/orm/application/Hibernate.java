package org.pk.annotation_plus_reflection_real_time_examples.custom.orm.application;

import org.pk.annotation_plus_reflection_real_time_examples.custom.orm.annotation.Column;
import org.pk.annotation_plus_reflection_real_time_examples.custom.orm.annotation.PrimaryKey;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidParameterException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hibernate<T> {

    Connection connection;

    private AtomicLong id = new AtomicLong(4L);

    private Hibernate() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:/Users/praveenkumar/Documents/Learning/Java/Annotation/src/main/java/org/pk/h2/database/project1/test", "sa", "");
    }

    public static <T> Hibernate<T> getConnection() throws SQLException {
        return new Hibernate<T>();
    }

    public void write(T t) throws IllegalAccessException, SQLException {
        Class<?> aClass = t.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        Field pkey = null;
        List<Field> columns = new ArrayList<>();

        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(PrimaryKey.class)) {
//                System.out.println("Primary key "+field.getName()+" & the value is "+field.get(t));
                pkey = field;
            } else if (field.isAnnotationPresent(Column.class)) {
                columns.add(field);
//                System.out.println("Column " + field.getName() + " & the value is " + field.get(t));
            }
        }

        String columnName = pkey.getName() + "," + columns.stream().map(x -> x.getName()).collect(Collectors.joining(","));
        String value = "?," + IntStream.range(0, columns.size()).mapToObj(x -> "?").collect(Collectors.joining(","));
        String sqlQuery = "insert into " + aClass.getSimpleName() + " (" + columnName + ") values (" + value + ")";
        PreparedStatement stmt = connection.prepareStatement(sqlQuery);
        if (pkey.getType() == long.class) {
            stmt.setInt(1, (int) id.incrementAndGet());
        }
        int index = 2;
        for (Field field : columns) {
            field.setAccessible(true);
            if (field.getType().equals(int.class)) {
                stmt.setInt(index++, (int) field.get(t));
            } else if (field.getType().equals(double.class)) {
                stmt.setDouble(index++, (double) field.get(t));
            } else {
                stmt.setString(index++, (String) field.get(t));
            }
        }

        System.out.println(sqlQuery);
        stmt.execute();


    }

    public List<T> findAll(Class<T> clss) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Field[] column = clss.getDeclaredFields();

        StringJoiner columnName = new StringJoiner(",");
        for (Field field : column) {
            columnName.add(field.getName());
        }

        String query = "select " + columnName.toString() + " from " + clss.getSimpleName();


        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<T> list = new ArrayList<>();

        while (resultSet.next()) {

            Constructor<T> constructor = clss.getDeclaredConstructor();
            constructor.setAccessible(true);
            T t = constructor.newInstance();
            for (Field field : column) {
                field.setAccessible(true);
                if (field.getType().equals(int.class)) {
                    field.set(t, resultSet.getInt(field.getName()));
                } else if (field.getType().equals(double.class)) {
                    field.set(t, resultSet.getDouble(field.getName()));
                } else if (field.getType().equals(long.class)) {
                    field.set(t, resultSet.getLong(field.getName()));
                } else {
                    field.set(t, resultSet.getString(field.getName()));
                }
            }
            list.add(t);
        }

        return list;
    }

    public T fiindById(Class<T> clss, int id) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Field[] column = clss.getDeclaredFields();

        Field pk = null;

        StringJoiner columnName = new StringJoiner(",");
        for (Field field : column) {
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                pk = field;
            }
            columnName.add(field.getName());
        }

        String query = "select " + columnName.toString() + " from " + clss.getSimpleName() + " where " + pk.getName() + "=" + id;


        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Constructor<T> constructor = clss.getDeclaredConstructor();
            constructor.setAccessible(true);
            T t = constructor.newInstance();
            for (Field field : column) {
                field.setAccessible(true);
                if (field.getType().equals(int.class)) {
                    field.set(t, resultSet.getInt(field.getName()));
                } else if (field.getType().equals(double.class)) {
                    field.set(t, resultSet.getDouble(field.getName()));
                } else if (field.getType().equals(long.class)) {
                    field.set(t, resultSet.getLong(field.getName()));
                } else {
                    field.set(t, resultSet.getString(field.getName()));
                }
            }
            return t;
        } else {
            throw new InvalidParameterException(" Primary key not found");
        }
    }

    public T update(T t) throws IllegalAccessException, SQLException {

        Class<?> aClass = t.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        Field pkey = null;
        List<Field> columns = new ArrayList<>();

        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                pkey = field;
            } else if (field.isAnnotationPresent(Column.class)) {
                columns.add(field);
            }
        }

        if (pkey == null || (long) pkey.get(t) <= 0)
            throw new InvalidParameterException("Invalid primary key");

        String columnName = columns.stream().map(Field::getName).collect(Collectors.joining("=?,"));
        String sqlQuery = "update " + aClass.getSimpleName() + " set " + columnName + " =? where " + pkey.getName() + "=?";
        System.out.println(sqlQuery);
        PreparedStatement stmt = connection.prepareStatement(sqlQuery);
        int index = 1;
        for (Field field : columns) {
            field.setAccessible(true);
            if (field.getType().equals(int.class)) {
                stmt.setInt(index++, (int) field.get(t));
            } else if (field.getType().equals(double.class)) {
                stmt.setDouble(index++, (double) field.get(t));
            } else {
                stmt.setString(index++, (String) field.get(t));
            }
        }
        if (pkey.getType() == long.class) {
            stmt.setLong(index++, (long) pkey.get(t));
        }

        int updatedColumn = stmt.executeUpdate();
        if(updatedColumn <= 0){
            throw new InvalidParameterException("Error in updating the tables");
        }

        return  t;
    }
}
