package panels;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class DrawingPanel extends JPanel {
    final MainFrame frame;
    JPanel panel;

    public DrawingPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    private void init(){
        panel = new JPanel();
        add(panel);
    }


    @Override
    protected void paintComponent(Graphics g) {
    }




}
