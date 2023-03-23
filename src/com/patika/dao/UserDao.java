package com.patika.dao;


import com.patika.Helper.DBConnector;
import com.patika.model.Role;
import com.patika.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserDao
{
    private Connection db;
    public UserDao()
    {
        db = DBConnector.getInstance();
    }
    public List<User> getList(Predicate<? super User> filter)
    {
        List<User> users = new ArrayList<>();
        try(Stream<User> s = users.stream() )
        {
            String query = "select * from users";
            Statement statement = db.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                    String role = resultSet.getString("role");
                    users.add(new User(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            Role.findByValue(role)
                    ));
            }
            if(filter != null ) users = s.filter(filter).collect(Collectors.toList());
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return users;
    }
    public boolean add(User user)
    {
        String query  = "insert into `users` (`name`, `surname`, `username`, `password`, `role`) values (?,?,?,?,?)";
        int result = -1;
        try
        {
            PreparedStatement preparedStatement = db.prepareStatement(query);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getUsername());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setString(5,user.getRole().getRole());
            result = preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return result == 1;
    }


}
