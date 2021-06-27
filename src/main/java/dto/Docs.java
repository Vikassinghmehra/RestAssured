package dto;

/**
 * @author Vikas Mehra
 * @date 26/06/21 11:42 PM
 */
public class Docs
{
    private String _id;

    private String name;

    private int runtimeInMinutes;

    private int budgetInMillions;

    private int boxOfficeRevenueInMillions;

    private int academyAwardNominations;

    private int academyAwardWins;

    private double rottenTomatoesScore;

    public void set_id(String _id){
        this._id = _id;
    }
    public String get_id(){
        return this._id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setRuntimeInMinutes(int runtimeInMinutes){
        this.runtimeInMinutes = runtimeInMinutes;
    }
    public int getRuntimeInMinutes(){
        return this.runtimeInMinutes;
    }
    public void setBudgetInMillions(int budgetInMillions){
        this.budgetInMillions = budgetInMillions;
    }
    public int getBudgetInMillions(){
        return this.budgetInMillions;
    }
    public void setBoxOfficeRevenueInMillions(int boxOfficeRevenueInMillions){
        this.boxOfficeRevenueInMillions = boxOfficeRevenueInMillions;
    }
    public int getBoxOfficeRevenueInMillions(){
        return this.boxOfficeRevenueInMillions;
    }
    public void setAcademyAwardNominations(int academyAwardNominations){
        this.academyAwardNominations = academyAwardNominations;
    }
    public int getAcademyAwardNominations(){
        return this.academyAwardNominations;
    }
    public void setAcademyAwardWins(int academyAwardWins){
        this.academyAwardWins = academyAwardWins;
    }
    public int getAcademyAwardWins(){
        return this.academyAwardWins;
    }
    public void setRottenTomatoesScore(int rottenTomatoesScore){
        this.rottenTomatoesScore = rottenTomatoesScore;
    }
    public double getRottenTomatoesScore(){
        return this.rottenTomatoesScore;
    }
}