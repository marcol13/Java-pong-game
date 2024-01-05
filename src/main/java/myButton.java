import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

public class myButton extends JButton{

    public myButton(Rectangle rect, String text, JPanel panel){
        JButton button = new JButton(text.toUpperCase(Locale.ROOT));
        button.setBounds(rect);

        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setFont(Window.fontSecond);
        button.setFocusPainted(false);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(Color.WHITE);
            }
        });

        button.setVisible(true);
        button.addActionListener(new ButtonActionListener());
        panel.add(button);
        button.repaint();

    }
}
