package com.gk.networking.components;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {

    private Dimension dimension;
    public Footer(Dimension dimension) {
        this.dimension = dimension;
        setSize(dimension.width, dimension.height /20);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(new ClockComponent());
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }
}
