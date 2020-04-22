import java.util.Calendar;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * AnalogClock
 */
public class AnalogClock extends Group {

    
    /** 
     * @param clockRadius
     * @return 
     */
    AnalogClock(double clockRadius) {

        getStylesheets().add("AnalogClock.css");

        final Circle face = getClockFace(clockRadius);
        final Line hourHand = getHand("hourHand", clockRadius, 0, percentOf(50, clockRadius));
        final Line minuteHand = getHand("minuteHand", clockRadius, 0, percentOf(75, clockRadius));
        final Line secondHand = getHand("secondHand", clockRadius, percentOf(15, clockRadius),
                percentOf(88, clockRadius));

        bindClockHandsToTime(hourHand, minuteHand, secondHand);

        getChildren().addAll(face, createTicks(clockRadius), createSpindle(clockRadius), hourHand, minuteHand,
                secondHand);
    }

    
    /** 
     * @param clockRadius
     * @return Group
     */
    private Group createTicks(double clockRadius) {
        final double tickStart = percentOf(83, clockRadius);
        final double tickEnd = percentOf(93, clockRadius);

        final Group ticks = new Group();
        for (int i = 0; i < 12; i++) {
            Line tick = new Line(0, -tickStart, 0, -tickEnd);
            tick.getStyleClass().add("tick");
            tick.setLayoutX(clockRadius);
            tick.setLayoutY(clockRadius);
            tick.getTransforms().add(new Rotate(i * (360 / 12)));
            ticks.getChildren().add(tick);
        }
        return ticks;
    }

    
    /** 
     * @param clockRadius
     * @return Circle - clock center spindle
     */
    private Circle createSpindle(double clockRadius) {
        final Circle spindle = new Circle(clockRadius, clockRadius, 5);
        spindle.setId("spindle");
        return spindle;
    }

    
    /** 
     * @param clockRadius
     * @return Circle - clock face
     */
    private Circle getClockFace(double clockRadius) {
        final Circle face = new Circle(clockRadius, clockRadius, clockRadius);
        face.setId("face");
        return face;
    }

    
    /** 
     * @param handId - name of clock part ID {eg. minhand, hourhand}
     * @param clockRadius - desired clock radius
     * @param handOffsetLength - rotate line at spindle
     * @param handLength - desired hand length
     * @return Line - clock hand
     */
    private Line getHand(String handId, double clockRadius, double handOffsetLength, double handLength) {
        final Line secondHand = new Line(0, handOffsetLength, 0, -handLength);
        secondHand.setLayoutX(clockRadius);
        secondHand.setLayoutY(clockRadius);
        secondHand.setId(handId);
        return secondHand;
    }

    
    /** 
     * @param hourHand
     * @param minuteHand
     * @param secondHand
     */
    private void bindClockHandsToTime(final Line hourHand, final Line minuteHand, final Line secondHand) {
        // determine initial rotation for the clock hands.
        Calendar time = Calendar.getInstance();
        final double initialHourhandDegrees = calculateHourHandDegrees(time);
        final double initialMinuteHandDegrees = calculateMinuteHandDegrees(time);
        final double initialSecondHandDegrees = calculateSecondHandDegrees(time);

        createRotationTimeline(createRotate(hourHand, initialHourhandDegrees).angleProperty(), Duration.hours(12),
                initialHourhandDegrees);
        createRotationTimeline(createRotate(minuteHand, initialMinuteHandDegrees).angleProperty(), Duration.minutes(60),
                initialMinuteHandDegrees);
        createRotationTimeline(createRotate(secondHand, initialSecondHandDegrees).angleProperty(), Duration.seconds(60),
                initialSecondHandDegrees);
    }

    
    /** 
     * @param angleProperty
     * @param duration
     * @param initialRotation
     */
    private void createRotationTimeline(DoubleProperty angleProperty, Duration duration, double initialRotation) {
        Timeline timeline = new Timeline(
                new KeyFrame(duration, new KeyValue(angleProperty, 360 + initialRotation, Interpolator.LINEAR)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    
    /** 
     * @param time
     * @return int
     */
    private int calculateSecondHandDegrees(Calendar time) {
        return time.get(Calendar.SECOND) * (360 / 60);
    }

    
    /** 
     * @param time
     * @return double
     */
    private double calculateMinuteHandDegrees(Calendar time) {
        return (time.get(Calendar.MINUTE) + calculateSecondHandDegrees(time) / 360.0) * (360 / 60);
    }

    
    /** 
     * @param time
     * @return double
     */
    private double calculateHourHandDegrees(Calendar time) {
        return (time.get(Calendar.HOUR) + calculateMinuteHandDegrees(time) / 360.0) * (360 / 12);
    }

    
    /** 
     * @param hand
     * @param initialHandDegrees
     * @return Rotate
     */
    private Rotate createRotate(Line hand, double initialHandDegrees) {
        final Rotate hourRotate = new Rotate(initialHandDegrees);
        hand.getTransforms().add(hourRotate);
        return hourRotate;
    }

    
    /** 
     * @param percent
     * @param clockRadius
     * @return double
     */
    private double percentOf(double percent, double clockRadius) {
        return percent / 100 * clockRadius;
    }

}