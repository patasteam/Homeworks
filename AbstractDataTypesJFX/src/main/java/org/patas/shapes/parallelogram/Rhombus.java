package org.patas.shapes.parallelogram;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.patas.graphics.LeftBox;
import org.patas.graphics.RightBox;
import org.patas.shapes.InvalidShapeException;

import java.util.ArrayList;

class Rhombus extends Parallelogram {
    private Rhombus(double side, double angleRad) throws InvalidShapeException {
        super("Rhombus", side, side, angleRad);
    }

    public static ArrayList<RadioButton> getOptions(LeftBox left, RightBox right) {
        ToggleGroup triangleGroup = new ToggleGroup();
        ArrayList<RadioButton> result = new ArrayList<>();
        RadioButton angleRadRB = new RadioButton("Side length and\nangle in radians");
        angleRadRB.setToggleGroup(triangleGroup);
        angleRadRB.setOnAction(event -> Rhombus.setRightPaneWithRadians(right));
        result.add(angleRadRB);
        RadioButton angleDegRB = new RadioButton("Side length and\nangle in degrees");
        angleDegRB.setToggleGroup(triangleGroup);
        angleDegRB.setOnAction(event -> Rhombus.setRightPaneWithDegrees(right));
        result.add(angleDegRB);
        RadioButton diagonalsRB = new RadioButton("Length of diagonals");
        diagonalsRB.setToggleGroup(triangleGroup);
        diagonalsRB.setOnAction(event -> Rhombus.setRightPaneWithDiagonals(right));
        result.add(diagonalsRB);
        return result;
    }

    private static void setRightPaneWithRadians(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side length"));
        labels.add(new Label("Angle in radians"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new Rhombus(args[0], args[1]));
    }

    private static void setRightPaneWithDegrees(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Side length"));
        labels.add(new Label("Angle in degrees"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> new Rhombus(args[0], Math.toRadians(args[1])));
    }

    private static void setRightPaneWithDiagonals(RightBox right) {
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Diagonal 1"));
        labels.add(new Label("Diagonal 2"));
        right.replaceTopPanel(labels);
        right.setShapeFactory(args -> {
            double side = Math.sqrt((args[0] * args[0] / 4) + (args[1] * args[1] / 4));
            double angleRad = 2 * Math.atan2(args[0], args[1]);
            return new Rhombus(side, angleRad);
        });
    }
}
