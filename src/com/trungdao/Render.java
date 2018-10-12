package com.trungdao;

import javax.swing.*;
import java.awt.*;

public class Render extends JFrame {
    JFrame jframe;
    int width = 800;
    int height = 800;
    Dimension screenSize;
    public Render() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Clock clock = new Clock();
        jframe = new JFrame();
        jframe.setSize(width, height);
        jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);
        jframe.add(clock);
        Timer timer = new Timer(1000, clock);
        timer.start();
    }
}
