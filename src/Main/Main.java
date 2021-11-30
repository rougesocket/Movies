package Main;

import Connections.SQLiteConnection;
import Movie.Mymovie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        /*
        *Checks if database is already created or not
        * if not created it creates a database in folder database with the name mymovie
        * and also gets connection with the created database
        * if the database already exists it just creates connection
        * */
        SQLiteConnection.connect();
        //creating a movie
        Mymovie movie = new Mymovie("Tanhaji: The Unsung Warrior",
                "Ajay Devgn","Kajol","Om Raut",2021);
        //inserting the movie
        insertIntoDatabase(movie);
        //printing all data
        getData();
        //printing specific data
        getData("Sidharth Malhotra");
    }

    private static void insertIntoDatabase(Mymovie movie){
        /*
         * It inserts the data into the database under table name movies
         */
        SQLiteConnection.connect();
        Connection con = SQLiteConnection.con;
        PreparedStatement ps = null;

        try{
            String query = "INSERT INTO movies(name,actorName,actressName,directorName,yearOfRelease) VALUES(?,?,?,?,?) ";
            ps = con.prepareStatement(query);

            ps.setString(1,movie.getMovie_name());
            ps.setString(2,movie.getActor_name());
            ps.setString(3,movie.getActress_name());
            ps.setString(4, movie.getDirector_name());
            ps.setInt(5,movie.getYearOfRelease());
            ps.execute();
            System.out.println("Your Favorite movie has been Inserted!");
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }

    }

    private static void getData(){
        /*
        * it find the all the movies present in the database and prints it
        * */
        SQLiteConnection.connect();
        Connection con = SQLiteConnection.con;
        PreparedStatement ps = null;
        ResultSet rs = null;


        try{
            String query = "SELECT * FROM movies";
            ps=con.prepareStatement(query);
            rs= ps.executeQuery();
            System.out.println("\n");
            while(rs.next()){
                String movieName = rs.getString("name");
                String actorName = rs.getString("actorName");
                String actressName = rs.getString("actressName");
                String directorName = rs.getString("directorName");
                int year = rs.getInt("yearOfRelease");

                System.out.println("Movie Name : "+movieName);
                System.out.println("Actor : "+actorName);
                System.out.println("Actress : "+actressName);
                System.out.println("Director : "+directorName);
                System.out.println("Year of Release : "+year+"\n");

            }

        }
        catch (SQLException e){
            System.out.println(e.toString());
        }

    }
    private static void getData(String param){

        /*
        * it prints all movies with respect to the data specified in the param like actor name
        * */
        Connection con = SQLiteConnection.con;
        PreparedStatement ps = null;
        ResultSet rs = null;


        try{
            String query = "SELECT * FROM movies where actorName=?";
            ps=con.prepareStatement(query);
            ps.setString(1,param);
            rs= ps.executeQuery();
            System.out.println("\n");
            while(rs.next()){
                String movieName = rs.getString("name");
                String actorName = rs.getString("actorName");
                String actressName = rs.getString("actressName");
                String directorName = rs.getString("directorName");
                int year = rs.getInt("yearOfRelease");

                System.out.println("Movie Name : "+movieName);
                System.out.println("Actor : "+actorName);
                System.out.println("Actress : "+actressName);
                System.out.println("Director : "+directorName);
                System.out.println("Year of Release : "+year+"\n");

            }

        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
    }

}

