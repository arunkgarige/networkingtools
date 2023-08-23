package com.gk.networking.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;

public class ClockComponent extends JPanel implements ActionListener {
    JLabel dateTime = new JLabel();
    JComboBox timeZoneList = new JComboBox(TimeZone.getAvailableIDs());


    public ClockComponent(ExecutorService executorService){
        super(new BorderLayout());
        //setPreferredSize(new Dimension(200,80));
        setOpaque(true);

        dateTime.setPreferredSize(new Dimension(200,80));

        timeZoneList.setSelectedItem(TimeZone.getDefault().getID());
        timeZoneList.addActionListener(this);

        add(dateTime, BorderLayout.PAGE_START);
        add(timeZoneList,BorderLayout.AFTER_LAST_LINE);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        executorService.execute(new Clock());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox jComboBox = (JComboBox) e.getSource();
        String timeZoneSelected = (String)jComboBox.getSelectedItem();
        System.out.println(timeZoneSelected);
    }

    private void updateDateTime(){
        dateTime.setText(LocalDateTime.now(TimeZone.getTimeZone((String)timeZoneList.getSelectedItem()).toZoneId()).toString());
        repaint();
    }

    class Clock implements Runnable{
        @Override
        public void run() {
            while(true){
                updateDateTime();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
