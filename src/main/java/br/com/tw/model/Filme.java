package br.com.tw.model;

public class Filme implements Modelo {

    private String id;
    private String rank;
    private String title;
    private String fullTitle;
    private String year;
    private String image;
    private String crew;
    private String imDbRating;
    private String imDbRatingCount;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }

    public String getImDbRatingCount() {
        return imDbRatingCount;
    }

    public void setImDbRatingCount(String imDbRatingCount) {
        this.imDbRatingCount = imDbRatingCount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Filme{");
        sb.append("id='").append(id).append('\'');
        sb.append(", rank='").append(rank).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", fullTitle='").append(fullTitle).append('\'');
        sb.append(", year='").append(year).append('\'');
        sb.append(", image='").append(image).append('\'');
        sb.append(", crew='").append(crew).append('\'');
        sb.append(", imDbRating='").append(imDbRating).append('\'');
        sb.append(", imDbRatingCount='").append(imDbRatingCount).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
