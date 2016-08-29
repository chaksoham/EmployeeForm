package com.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by schakra on 11/8/16.
 */
@Controller
public class GreetingController {

    static int id =0;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/employee", method= RequestMethod.POST)
    public String employee(@RequestParam(value="name", required=false) String name,
                           @RequestParam(value="emailId", required=false) String emailId,@RequestParam(value="dob", required=false) String dob,@RequestParam(value="country", required=false) String country) {
        System.out.println("POST request recvd " + name + " " + emailId + " " + dob + " " + country);
        //add to database

        if (id == 0) {

            jdbcTemplate.execute("DROP TABLE employees IF EXISTS");
            jdbcTemplate.execute("CREATE TABLE employees(" +
                    "id SERIAL, name VARCHAR(255), email VARCHAR(255))");

             //String  insertquery = "INSERT INTO EMPLOYEES ( id ,name,email ) VALUES ("+toString(id) +"," +name+","+emailId;


            List<String> Customer = jdbcTemplate.query("SELECT * FROM employees", new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet resultSet, int i) throws SQLException {

                    return null;
                }
            });
        }

        id++;
        return "employee";
    }
}