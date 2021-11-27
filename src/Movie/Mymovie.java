package Movie;

public class Mymovie {
/*
* A simple object to hold movie data
* */
    String movie_name;
    String actor_name;
    String actress_name;
    String director_name;
    int yearOfRelease;

    public Mymovie(String name,String actorName,String actressName,String directorName,int year) {
        this.movie_name=name;
        this.actor_name=actorName;
        this.actress_name=actressName;
        this.director_name=directorName;
        this.yearOfRelease=year;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getActor_name() {
        return actor_name;
    }

    public void setActor_name(String actor_name) {
        this.actor_name = actor_name;
    }

    public String getActress_name() {
        return actress_name;
    }

    public void setActress_name(String actress_name) {
        this.actress_name = actress_name;
    }

    public String getDirector_name() {
        return director_name;
    }

    public void setDirector_name(String director_name) {
        this.director_name = director_name;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }
}
