package com.gk.networking;

import com.gk.networking.components.ClockComponent;
import com.gk.networking.utils.AppConstants;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetWorkingTools {

    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame(AppConstants.APP_TITLE);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        //frame.getContentPane().add(label);
        JComponent newContentPane = new ClockComponent(executorService);
        //frame.setContentPane(newContentPane);
        frame.setSize(new Dimension(400,600));
        frame.getContentPane().add(newContentPane);
        frame.setLocation(400/2,400/2);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
