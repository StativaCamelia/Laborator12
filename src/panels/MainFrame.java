package panels;


import javax.swing.*;

import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    DrawingPanel canvas;

    public MainFrame(){
        super("My Drawing Application");
        init();
    }

    private void init(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        add(canvas, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        pack();
    }

        public static void main(String[] args){
            MainFrame frame = new MainFrame();
            frame.setPreferredSize(new Dimension(784, 700));
            frame.setVisible(true);

    }
}
