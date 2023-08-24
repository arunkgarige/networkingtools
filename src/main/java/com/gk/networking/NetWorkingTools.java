package com.gk.networking;

import com.gk.networking.components.ClockComponent;
import com.gk.networking.components.Content;
import com.gk.networking.components.Footer;
import com.gk.networking.components.Header;
import com.gk.networking.utils.AppConstants;

import javax.swing.*;
import java.awt.*;

public final class NetWorkingTools extends JFrame{

    private Dimension dimension;

    NetWorkingTools(String title, Dimension dimension){
        super(title);
        this.dimension = dimension;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(dimension.width/2,dimension.height/2);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    void createAndShowGUI() {
        JPanel headerPane = new Header(dimension);
        JPanel contentPane = new Content(dimension);
        JPanel footerPane = new Footer(dimension);
        setLayout(new BorderLayout());

        getContentPane().add(headerPane, BorderLayout.PAGE_START);
        getContentPane().add(contentPane, BorderLayout.CENTER);
        getContentPane().add(footerPane, BorderLayout.PAGE_END);
        //Display the window.
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        javax.swing.SwingUtilities.invokeLater(() -> {
            NetWorkingTools netWorkingTools = new NetWorkingTools(AppConstants.APP_TITLE, dimension);
            netWorkingTools.createAndShowGUI();
        });
    }


}
