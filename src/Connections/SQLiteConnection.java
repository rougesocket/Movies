package Connections;

import java.io.File;
import java.sql.*;

public class SQLiteConnection {

    public static Connection con = null;

    public static String sqliteServer="jdbc:sqlite:";
    public static String resetPath = "";

    /*
    * Checks whether database exits or not
    * */
    public static boolean isDataBaseExists(String dbFilePath){
        File dbFile = new File(dbFilePath);
        return dbFile.exists();
    }

    /*
    * Creates a connection with the database if it doesn't exits it tries to create a new and get connection with it in con variable
    * */
    public static Connection connect(){
        sqliteServer="jdbc:sqlite:";
        String getFilePath = new File("").getAbsolutePath();
        String fileAbsolutePath = getFilePath.concat("\\src\\Main\\mymovie.db");

        if(isDataBaseExists(fileAbsolutePath)){
            try{
                con = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
                System.out.println("Connected!!!");
            }
            catch (SQLException e){
                System.out.println(e.toString());
            }
        }
        else{
            System.out.println("Creating New Database!!");
            createNewDataBase("Main","mymovie");
            System.out.println("New DataBase Created Successfully!!");
        }
        return con;
    }

    /*
    * Creates a new database with name as mymovie and gets connection to it
    * */
    public static void createNewDataBase(String fileSubFolder,String fileName){

        String getFilePath= new File("").getAbsolutePath();
        String fileAbsolutePath="";

        if(fileSubFolder.isEmpty()){
            fileAbsolutePath= getFilePath.concat(fileName+".db");
            resetPath=fileAbsolutePath;
        }
        else{
            fileAbsolutePath= getFilePath.concat("\\src\\"+fileSubFolder+"\\"+fileName+".db");
            resetPath=fileAbsolutePath;
        }

        Connection con;
        try{
            con = DriverManager.getConnection(sqliteServer+fileAbsolutePath);
            if(con!=null){
                DatabaseMetaData meta = con.getMetaData();
                try{
                    Statement statement = con.createStatement();
                    statement.executeQuery("CREATE TABLE movies(name TEXT PRIMARY KEY NOT NULL,"+"actorName TEXT NOT NULL,"+"actressName TEXT NOT NULL,"+"directorName TEXT NOT NULL,"+"yearOfRelease INT NOT NULL)");
                }
                catch (SQLException e){
                }
            }
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
    }
}
