package com.gk.networking.components;

import javax.swing.*;
import java.awt.*;

//Menu
public class Header extends JPanel {
    private Dimension dimension;
    JMenuBar jMenuBar = new JMenuBar();
    public Header(Dimension dimension) {
        this.dimension = dimension;
        setSize(dimension.width, dimension.height /20);

        setLayout(new FlowLayout());
        jMenuBar.add(new JMenu("File"));
        add(jMenuBar,FlowLayout.LEFT);
    }

}
