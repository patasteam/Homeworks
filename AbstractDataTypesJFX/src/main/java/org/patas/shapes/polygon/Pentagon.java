package org.patas.shapes.polygon;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;
import org.patas.shapes.InvalidShapeException;

import java.util.ArrayList;

class Pentagon extends Polygon {
    private Pentagon(double side) throws InvalidShapeException {
        super("Pentagon", 5, side);
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side length"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new Pentagon(args[0]));
    }
}
