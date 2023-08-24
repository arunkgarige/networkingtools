package com.gk.networking.components;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {
    private Dimension dimension;
    public Content(Dimension dimension) {
        this.dimension = dimension;
        setSize(dimension.width, dimension.height/60);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }
}
