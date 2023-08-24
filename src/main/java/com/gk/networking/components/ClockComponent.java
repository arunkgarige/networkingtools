package com.gk.networking.components;

import com.gk.networking.utils.AppConstants;
import com.gk.networking.utils.ExecutorsUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.TimeZone;

public final class ClockComponent extends JPanel implements ActionListener {
    JLabel dateTime = new JLabel();
    JComboBox timeZoneList = new JComboBox(TimeZone.getAvailableIDs());

    public ClockComponent(){
        setLayout(new FlowLayout());
        dateTime.setPreferredSize(new Dimension(250,30));
        timeZoneList.setSelectedItem(TimeZone.getDefault().getID());
        timeZoneList.addActionListener(this);
        dateTime.setFont(new Font(Font.DIALOG,Font.ROMAN_BASELINE,15));
        JButton reset = new JButton(AppConstants.RESET_BUTTON);
        reset.addActionListener(this);
        add(reset);
        add(timeZoneList);
        add(dateTime);
        setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        ExecutorsUtil.getExecutorsUtil().fireAndForget(new Clock());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
            resetToDefault();
        }
    }

    private void resetToDefault(){
        timeZoneList.setSelectedItem(TimeZone.getDefault().getID());
        dateTime.setText(LocalDateTime.now(TimeZone.getDefault().toZoneId()).toString());
        repaint();
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
