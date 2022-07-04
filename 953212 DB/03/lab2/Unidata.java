// 642115003 Kan Katpark

class University implements Comparable<University> {

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
        // Round all the university scores
        this.score = Math.round(Double.parseDouble(score));
        this.link = link;
        this.country = country;
        this.city = city;
        this.region = region;
        this.logo = logo;
    }

    // Apply comparable to the data model
    @Override
    public int compareTo(University u2) {
        if (this.name.compareTo(u2.name) > 0) {
            return 1;
        } else if (this.name.compareTo(u2.name) == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    public String toString() {
        return String.format(" #%s  %s score: %.0f  %s %s %s", this.rank, this.name, this.score, this.country,
                this.city, this.region);
    }
}