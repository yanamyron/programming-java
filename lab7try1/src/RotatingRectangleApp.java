import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
public class RotatingRectangleApp extends JFrame {
    private DrawPanel drawPanel;
    private Timer timer;
    public RotatingRectangleApp() {
        super("Обертання чотирикутника");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);
        setupMenu();
        timer = new Timer(30, e -> {
            drawPanel.incrementAngle();
            drawPanel.repaint();
        });
        timer.start();
    }
    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenuItem restartItem = new JMenuItem("Перезапустити програму");
        JMenuItem exitItem = new JMenuItem("Вихід");
        restartItem.addActionListener(e -> {
            drawPanel.resetAngle();
        });
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(restartItem);
        fileMenu.add(exitItem);
        JMenu helpMenu = new JMenu("Довідка");
        JMenuItem helpItem = new JMenuItem("Довідка по програмі");
        JMenuItem aboutItem = new JMenuItem("Про програму");
        helpItem.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Ця програма демонструє обертання чотирикутника навколо центру.",
                "Довідка", JOptionPane.INFORMATION_MESSAGE));
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Автор: Мирон Яна\nВерсія: 1.0\nJava GUI демонстрація",
                "Про програму", JOptionPane.INFORMATION_MESSAGE));
        helpMenu.add(helpItem);
        helpMenu.add(aboutItem);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RotatingRectangleApp().setVisible(true));
    }

    class DrawPanel extends JPanel {
        private double angle = 0;

        public void incrementAngle() {
            angle += Math.toRadians(2);
        }

        public void resetAngle() {
            angle = 0;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            int rectWidth = 100;
            int rectHeight = 60;

            AffineTransform old = g2d.getTransform();
            g2d.translate(centerX, centerY);
            g2d.rotate(angle);

            g2d.setColor(Color.BLUE);
            g2d.fillRect(-rectWidth / 2, -rectHeight / 2, rectWidth, rectHeight);

            g2d.setTransform(old);
        }
    }
}
