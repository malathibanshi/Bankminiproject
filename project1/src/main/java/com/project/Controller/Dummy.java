package com.project.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/come")
public class Dummy {

    @PostMapping("/wel")
    public Serv dbConnection(@RequestBody Serv s) throws SQLException, ClassNotFoundException  {
        
            Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rev", "root", "malathi");
           String query="insert into malathi(cust_name, country,c_id)values ('"+s.getUname()+"','"+s.getUcountry()+"','"+s.getC_id()+"')";
                PreparedStatement ps = con.prepareStatement(query);
                 int c = ps.executeUpdate();
                if (c > 0) {
                    System.out.println("Data stored successfully");
                } else {
                    System.out.println("Data not stored");
                }
           
		return s;
    }
}
