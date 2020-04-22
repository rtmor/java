import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

class Cubes extends StackPane {
    /**
     * Building block for individual cubes
     */
    private final MemoryMatch memoryMatch;
    private String id;
    private Rectangle border;

    // initialize cube with color, id, size, and alignment
    public Cubes(MemoryMatch memoryMatch, Color value) {

        this.memoryMatch = memoryMatch;
        // size defined by number of cubes set by difficulty
        int size = 600 / MemoryMatch.NUM_PER_ROW;

        Rectangle fill = new Rectangle(size, size);
        fill.setFill(null);
        fill.setStroke(Color.BLACK);

        border = new Rectangle(size, size);
        border.setFill(value);

        id = value.toString();

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, fill);

        // mouse click event action
        setOnMouseClicked(i -> handleMouseClick(i));
        close();
    }

    public void handleMouseClick(MouseEvent event) {
        // if opacity == 1 or two selections made
        if (isOpen() || this.memoryMatch.clickCount == 0)
            return;

        this.memoryMatch.clickCount--;

        // if not already selected
        if (this.memoryMatch.selected == null) {
            this.memoryMatch.selected = this;
            // set opacity to 1
            open(() -> {
            });
        } else {
            open(() -> {
                // close on non-match
                if (!equalValue(this.memoryMatch.selected)) {
                    this.memoryMatch.selected.close();
                    this.close();
                // decrement pair count on match & check for winner
                } else {
                    MemoryMatch.PAIR_COUNT--;

                    if (MemoryMatch.PAIR_COUNT == 0) {
                        this.memoryMatch.stopclock.stop();
                        try {
                            this.memoryMatch.winner();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }

                this.memoryMatch.selected = null;
                this.memoryMatch.clickCount = 2;
            });
        }
    }

    // return cube opacity
    public boolean isOpen() {
        return border.getOpacity() == 1;
    }

    // open fade transition for selected
    public void open(Runnable action) {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5), border);
        ft.setToValue(1);
        ft.setOnFinished(e -> action.run());
        ft.play();
    }

    // close fade transition for selected
    public void close() {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5), border);
        ft.setToValue(0);
        ft.play();
    }

    // check ids
    public boolean equalValue(Cubes other) {
        return id.equals(other.id);
    }
}