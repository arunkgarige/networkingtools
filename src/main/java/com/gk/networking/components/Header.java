package com.gk.networking.components;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {
    private Dimension dimension;
    JMenuBar jMenuBar = new JMenuBar();
    public Header(Dimension dimension) {
        this.dimension = dimension;
        setSize(dimension.width, dimension.height /20);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);


        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");
        JMenu aboutMenu = new JMenu("About");

        jMenuBar.add(fileMenu);
        jMenuBar.add(toolsMenu);
        jMenuBar.add(aboutMenu);
        jMenuBar.setBorderPainted(true);
        //jMenuBar.setHelpMenu(aboutMenu);
        add(jMenuBar);
    }

}
