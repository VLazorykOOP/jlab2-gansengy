public class Time {
    private short hour;
    private short minute;
    private short second;

    public Time(short hour, short minute, short second) {
        try {
            if (hour < 0 || hour > 23) {
                throw new IllegalArgumentException("Invalid hour value: " + hour);
            }
            if (minute < 0 || minute > 59) {
                throw new IllegalArgumentException("Invalid minute value: " + minute);
            }
            if (second < 0 || second > 59) {
                throw new IllegalArgumentException("Invalid second value: " + second);
            }
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating Time object: " + e.getMessage());
        }
    }

    public Time(String timeString) {
        try {
            String[] timeParts = timeString.split(":");
            short hour = Short.parseShort(timeParts[0]);
            short minute = Short.parseShort(timeParts[1]);
            short second = Short.parseShort(timeParts[2]);
            if (hour < 0 || hour > 23) {
                throw new IllegalArgumentException("Invalid hour value: " + hour);
            }
            if (minute < 0 || minute > 59) {
                throw new IllegalArgumentException("Invalid minute value: " + minute);
            }
            if (second < 0 || second > 59) {
                throw new IllegalArgumentException("Invalid second value: " + second);
            }
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating Time object: " + e.getMessage());
        }
    }

    public Time(int seconds) {
        try {
            if (seconds < 0) {
                throw new IllegalArgumentException("Invalid seconds value: " + seconds);
            }
            this.hour = (short) (seconds / 3600);
            this.minute = (short) ((seconds % 3600) / 60);
            this.second = (short) (seconds % 60);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating Time object: " + e.getMessage());
        }
    }

    public Time(Time otherTime) {
        try {
            if (otherTime == null) {
                throw new IllegalArgumentException("Other Time object is null");
            }
            this.hour = otherTime.hour;
            this.minute = otherTime.minute;
            this.second = otherTime.second;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating Time object: " + e.getMessage());
        }
    }

    public int differenceInSeconds(Time otherTime) {
        int thisSeconds = this.toSeconds();
        int otherSeconds = otherTime.toSeconds();
        return Math.abs(thisSeconds - otherSeconds);
    }

    public void addSeconds(int seconds) {
        int thisSeconds = this.toSeconds();
        thisSeconds += seconds;
        Time newTime = new Time(thisSeconds);
        this.hour = newTime.hour;
        this.minute = newTime.minute;
        this.second = newTime.second;
    }

    public void subtractSeconds(int seconds) {
        int thisSeconds = this.toSeconds();
        thisSeconds -= seconds;
        if (thisSeconds < 0) {
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
        } else {
            Time newTime = new Time(thisSeconds);
            this.hour = newTime.hour;
            this.minute = newTime.minute;
            this.second = newTime.second;
        }
    }

    public int compareTo(Time otherTime) {
        if (otherTime == null || otherTime.hour < 0 || otherTime.hour > 23 ||
                otherTime.minute < 0 || otherTime.minute > 59 || otherTime.second < 0 ||
                otherTime.second > 59) {
            throw new IllegalArgumentException("Invalid Time object");
        }
        int thisSeconds = this.toSeconds();
        int otherSeconds = otherTime.toSeconds();
        return Integer.compare(thisSeconds, otherSeconds);
    }

    public int toSeconds() {
        return this.hour * 3600 + this.minute * 60 + this.second;
    }

    public int toMinutes() {
        return (int) Math.round((double) this.toSeconds() / 60);
    }
    public String toString() {
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }
}