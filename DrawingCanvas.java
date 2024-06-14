import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawingCanvas extends JPanel {
    private List<Shape> shapes;
    private ShapeFactory shapeFactory;

    public DrawingCanvas(ShapeFactory shapeFactory) {
        this.shapes = new ArrayList<>();
        this.shapeFactory = shapeFactory;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int width = Integer.parseInt(JOptionPane.showInputDialog("Enter width:"));
                int height = Integer.parseInt(JOptionPane.showInputDialog("Enter height:"));
                Shape shape = shapeFactory.createShape(e.getX(), e.getY(), width, height);
                shapes.add(shape);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}
