package org.patas.shapes.parallelogram;

import javafx.scene.control.Label;
import org.patas.graphics.RightBox;

import java.util.ArrayList;

public class Rectangle extends Parallelogram {
    public Rectangle(double sideA, double sideB) {
        super("Rectangle", sideA, sideB, Math.toRadians(90.0));
    }

    static void setRightPane(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side A"));
        labels.add(new Label("Side B"));
        right.replaceTopPanel(labels);
        right.setShapeConstructor(Rectangle.class.getDeclaredConstructors()[0]);
    }
}
