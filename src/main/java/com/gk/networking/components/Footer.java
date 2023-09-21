package com.gk.networking.components;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {

    public Footer(Dimension dimension, JProgressBar jProgressBar) {
        setSize(dimension.width, dimension.height /20);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(jProgressBar);
        add(new ClockComponent());
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    }
}
