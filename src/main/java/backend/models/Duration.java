package backend.models;

public enum Duration {

    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    YEAR("year");

    private String duration;

    Duration(String duration) {
        this.duration = duration;
    }

    public String getDuration(){
        return duration;
    }
}
