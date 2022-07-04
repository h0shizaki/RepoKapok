// 642115003 Kan Katpark


class University {
    public String year;
    public String rank;
    public String name;
    public double score;
    public String link;
    public String country;
    public String city;
    public String region;
    public String logo;

    public University(String year, String rank, String name, String score, String link, String country, String city,
            String region, String logo) {
        this.year = year;
        this.rank = rank;
        this.name = name;
        this.score = Double.parseDouble(score);
        this.link = link;
        this.country = country;
        this.city = city;
        this.region = region;
        this.logo = logo;
    }

    public String toString() {
        return String.format(" #%s  %s score: %.2f  %s %s %s", this.rank, this.name, this.score , this.country , this.city , this.region);
    }
}