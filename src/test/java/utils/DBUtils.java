package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    public static List<Map<String,String>> fetch(String query){

        String dburl = ConfigReader.read("dburl");
        String dbUsername = ConfigReader.read("dbUsername");
        String dbPassword = ConfigReader.read("dbPassword");

        List<Map<String,String>> mapList = new ArrayList<>();

        try{
            Connection connection = DriverManager.getConnection(dburl,dbUsername,dbPassword);
            Statement statement = connection.createStatement();

            //when we execute the query, it gives us the result
            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData rsdm = rs.getMetaData();
            while (rs.next()){
              //retrive the keys and values from the map one by one
                Map<String,String> rowMap = new LinkedHashMap<>();
                //using linked hashmaps because we need values to be stored in order
              for (int i =1; i<=rsdm.getColumnCount();i++){
                  String key = rsdm.getColumnLabel(i);
                  String value = rs.getString(i);
                  rowMap.put(key,value);
              }

               mapList.add(rowMap);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return mapList;

    }
}
