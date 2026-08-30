package DB;

import utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Example {


    public static void main(String[] args) throws SQLException {

       List<Map<String,String>> data = new ArrayList<>();
       data = DBUtils.fetch("select * from person");
        System.out.println(data);
        System.out.println(data.get(1).get("city"));
        System.out.println(data.get(4));
    }

}
