package course;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Course {
    private int SECONDS_PER_HOUR = 3600;
    private String college;
    private long durationSeconds;
    private final String name;
    private Date startTime;

    public Course(String name) {
        this.name = name;
        this.college = System.getenv("ENV_COLLEGE");
    }

    public void start() {
        startTime = new Date();
    }

    public void end() {
        durationSeconds = computeDurationInSeconds(startTime, new Date());
    }

    public boolean isShort()
    {
        return durationSeconds < 2 * SECONDS_PER_HOUR;
    }

    public boolean isLong()
    {
        return !isShort();
    }

    public String getCollege() {
        return college;
    }

    private long computeDurationInSeconds(Date date1, Date date2) {
        long durationMilliSeconds = date2.getTime() - date1.getTime();
        return TimeUnit.SECONDS.convert(durationMilliSeconds, TimeUnit.MILLISECONDS);
    }
}


