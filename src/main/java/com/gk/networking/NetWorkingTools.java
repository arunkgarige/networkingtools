package com.gk.networking;

import com.gk.networking.components.Content;
import com.gk.networking.components.Footer;
import com.gk.networking.utils.AppConstants;
import com.gk.networking.utils.ExecutorsUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public final class NetWorkingTools extends JFrame implements ActionListener {
    private final Dimension dimension;
    private static final JProgressBar jProgressBar = new JProgressBar();

    NetWorkingTools(String title, Dimension dimension){
        super(title);
        this.dimension = dimension;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(dimension.width/2,dimension.height/2);
        setBackground(Color.WHITE);
        jProgressBar.setMinimum(0);
        jProgressBar.setMaximum(10);
        jProgressBar.setValue(0);
        jProgressBar.setStringPainted(true);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    void createAndShowGUI() {
        setLayout(new BorderLayout());
        setJMenuBar(createMenuBar());

        add(new Content(dimension), BorderLayout.CENTER);
        add(new Footer(dimension, jProgressBar), BorderLayout.PAGE_END);

        pack();
        setVisible(true);
    }

    private JMenuBar createMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.addNotify();
        jMenuBar.add(createOptionsJMenu());
        jMenuBar.add(createToolsJMenu());
        jMenuBar.add(createAboutJMenu());
        return jMenuBar;
    }


    private JMenu createOptionsJMenu() {
        JMenu fileMenu = new JMenu(AppConstants.MENU_FILE);
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem quit = new JMenuItem(AppConstants.MENU_QUIT, KeyEvent.VK_Q);
        quit.addActionListener(this);
        fileMenu.add(quit);
        return fileMenu;
    }

    private JMenu createToolsJMenu() {
        JMenu tools = new JMenu(AppConstants.MENU_TOOLS);
        tools.setMnemonic(KeyEvent.VK_T);
        return tools;
    }

    private JMenu createAboutJMenu() {
        JMenu about = new JMenu(AppConstants.MENU_ABOUT);
        JMenuItem systemInfo = new JMenuItem(AppConstants.MENU_SYSINFO);
        systemInfo.addActionListener(this);
        about.add(systemInfo);
        about.setMnemonic(KeyEvent.VK_A);
        return about;
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        //9452387895
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        javax.swing.SwingUtilities.invokeLater(() -> {
            NetWorkingTools netWorkingTools = new NetWorkingTools(AppConstants.APP_TITLE, dimension);
            netWorkingTools.createAndShowGUI();
        });
    }

    private void processMenuItem(JMenuItem menuItem) {
        switch (menuItem.getText()){
            case AppConstants.MENU_QUIT:
                ExecutorsUtil.getExecutorsUtil().shutDown();
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                break;
            case AppConstants.MENU_SYSINFO:

                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JMenuItem){
            processMenuItem((JMenuItem) e.getSource());
        }
    }
}
