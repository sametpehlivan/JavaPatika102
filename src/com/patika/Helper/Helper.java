package com.patika.Helper;


import com.patika.dao.UserDao;
import com.patika.model.Role;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Helper
{

    public static void setLocationCenter (Component panel)
    {
        int x = ((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - panel.getSize().width)/2;
        int y = ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - panel.getSize().height)/2;
        panel.setLocation(new Point(x,y));
    }
    public static void setLayout()
    {
        try(Stream<UIManager.LookAndFeelInfo> s = Arrays.stream(UIManager.getInstalledLookAndFeels()))
        {

            var theme = s.filter(t->t.getName().equals("Nimbus"))
                    .reduce((first,second)->first)
                    .orElse(null);
            System.out.println(theme.getClassName());
            if( theme != null ) UIManager.setLookAndFeel(theme.getClassName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static String passwordHash(String pass)
    {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hashedPassword = md.digest(pass.getBytes(StandardCharsets.UTF_8));
            return new String(hashedPassword, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e)
        {
            System.out.println(e.getMessage());
        }
        return "null";
    }


}
