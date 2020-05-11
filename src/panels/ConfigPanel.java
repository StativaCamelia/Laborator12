package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConfigPanel extends JPanel {

    final MainFrame frame;

    JComboBox shapeCombo;
    JTextField textField;
    JButton addButton;

    public ConfigPanel(MainFrame frame){
        this.frame = frame;
        init();
    }


    public void init(){
        this.removeAll();

        shapeCombo = new JComboBox(new String[]{"javax.swing.JButton","javax.swing.JLabel", "javax.swing.JMenu", "javax.swing.JCheckBox",  "javax.swing.JSpinner"});
        add(shapeCombo);
        textField = new JTextField(30);
        add(textField);
        addButton = new JButton("AddCompoennt");
        add(addButton);
        addButton.addActionListener(this::addComponent);
        this.validate();
        this.repaint();
    }

    public void addComponent(ActionEvent e){
        try {
            String selectedComponent = (String) shapeCombo.getSelectedItem();
            String elementText = (String) textField.getText();

            Class<?> clazz = Class.forName(selectedComponent);
            Constructor<?> constructor = clazz.getConstructor(String.class);
            Object instance = constructor.newInstance(elementText);

            this.frame.canvas.add((Component) instance);

            this.frame.validate();
            this.frame.repaint();

            } catch (InstantiationException exception) {
            exception.printStackTrace();
        } catch (InvocationTargetException exception) {
            exception.printStackTrace();
        } catch (NoSuchMethodException exception) {
            exception.printStackTrace();
        } catch (IllegalAccessException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }

    }


}
