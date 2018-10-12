package com.trungdao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Clock extends JPanel implements ActionListener {
    int xcenter = 400, ycenter = 400, second, minute, hour, xsecond, ysecond, xminute, yminute, xhour, yhour, count = 0;
    int lastxs = 0, lastys = 0, lastxm = 0, lastym = 0, lastxh = 0, lastyh = 0;
    SimpleDateFormat formatter = new SimpleDateFormat("s", Locale.getDefault());
    Date currentDate;

    public Clock() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentDate = new Date();
        formatter.applyPattern("s");
        second = Integer.parseInt(formatter.format(currentDate));
        formatter.applyPattern("m");
        minute = Integer.parseInt(formatter.format(currentDate));
        formatter.applyPattern("h");
        hour = Integer.parseInt(formatter.format(currentDate));
        xsecond = (int) (Math.cos(second * 3.14f / 30 - 3.14f / 2) * 120 + xcenter);
        ysecond = (int) (Math.sin(second * 3.14f / 30 - 3.14f / 2) * 120 + ycenter);
        xminute = (int) (Math.cos(minute * 3.14f / 30 - 3.14f / 2) * 100 + xcenter);
        yminute = (int) (Math.sin(minute * 3.14f / 30 - 3.14f / 2) * 100 + ycenter);
        xhour = (int) (Math.cos((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f / 2) * 80 + xcenter);
        yhour = (int) (Math.sin((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f / 2) * 80 + ycenter);
        setBackground(Color.black);
        g.setFont(new Font("Sanserif", Font.BOLD, 20));
        g.setColor(Color.pink);
        g.fillOval(200, 200, 400, 400);
        g.setColor(Color.cyan);
        g.drawString("12", 400, 220);
        g.drawString("3", 580, 400);
        g.drawString("9", 210, 400);
        g.drawString("6", 400, 590);

        g.setColor(Color.ORANGE);
        g.drawLine(xcenter, ycenter, xsecond, ysecond);
        g.setColor(Color.red);
        g.drawLine(xcenter, ycenter, xminute, yminute);
        g.setColor(Color.green);
        g.drawLine(xcenter, ycenter, xhour, yhour);
        count++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(count);
        repaint();
    }
}
