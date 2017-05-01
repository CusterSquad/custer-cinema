package hu.elte.cinema.enums;


public enum AgeLimit {
    G_RATING("Everyone"),
    PG_RATING("Child"),
    PG_13_RATING("Teenager"),
    R_RATING("Young Adult"),
    NC_17_RATING("Adult");

    private final String name;

    AgeLimit(String name) {
        this.name = name;
    }


    @Override
    public String toString(){
        return this.name;
    }
    public static AgeLimit getLimit(String limit) {
        switch (limit) {
            case "Everyone":
                return G_RATING;
            case "Child":
                return PG_RATING;
            case "Teenager":
                return PG_13_RATING;
            case "Young Adult":
                return R_RATING;
            case "Adult":
                return NC_17_RATING;
            default:
                return null;
        }
    }
    public static AgeLimit getLimit(int age) {
        if (age > 17) {
            return NC_17_RATING;
        } else if (age > 13) {
            return R_RATING;
        } else if(age > 10) {
            return PG_13_RATING;
        } else if(age > 7) {
            return PG_RATING;
        } else {
            return G_RATING;
        }
    }


}
