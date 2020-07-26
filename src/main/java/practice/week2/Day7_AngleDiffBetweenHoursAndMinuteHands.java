package practice.week2;

public class Day7_AngleDiffBetweenHoursAndMinuteHands {
    public double angleClock(int hour, int minutes) {
        double hourMovement = ((hour % 12) * 30) + (minutes * 0.5);
        double minMovement = (minutes * 6);
        double diff = Math.abs(hourMovement - minMovement);
        return Math.min(diff, 360 - diff);
    }
}
