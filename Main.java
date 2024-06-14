import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;


public class Main {
    public static void main(String[] args) {
        DrawingApp app = new DrawingApp();
        app.setVisible(true);
    }
}
//Enum ShapeType
 enum ShapeType {
    RECTANGLE,
    CIRCLE
}
//Class ShapeFactory

    class ShapeFactory {
    private ShapeType shapeType;
    private Random random;

    public ShapeFactory() {
        this.shapeType = ShapeType.RECTANGLE;
        this.random = new Random();
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public Shape createShape(int x, int y, int width, int height) {
        Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

        switch (shapeType) {
            case RECTANGLE:
                return new RectangleShape(x, y, width, height, color);
            case CIRCLE:
                int diameter = Math.min(width, height);
                return new CircleShape(x, y, diameter, color);
            default:
                return null;
        }
    }
}
// Class DrawingCanvas

    class DrawingCanvas extends JPanel {
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
//Abstract class Shape
    abstract class Shape {
    protected int x, y;
    protected Color color;

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract void draw(Graphics g);
}
// Class RectangleShape
    class RectangleShape extends Shape {
    private int width, height;

    public RectangleShape(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
// Class CircleShape
    class CircleShape extends Shape {
    private int diameter;

    public CircleShape(int x, int y, int diameter, Color color) {
        super(x, y, color);
        this.diameter = diameter;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }
}
// Class DrawingApp
    class DrawingApp extends JFrame {
    private DrawingCanvas canvas;
    private ShapeFactory shapeFactory;

    public DrawingApp() {
        setTitle("Simple Drawing Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        shapeFactory = new ShapeFactory();
        canvas = new DrawingCanvas(shapeFactory);

        JMenuBar menuBar = new JMenuBar();
        JMenu shapeMenu = new JMenu("Shape");

        JMenuItem rectangleItem = new JMenuItem("Rectangle");
        rectangleItem.addActionListener(new ShapeMenuActionListener(ShapeType.RECTANGLE));

        JMenuItem circleItem = new JMenuItem("Circle");
        circleItem.addActionListener(new ShapeMenuActionListener(ShapeType.CIRCLE));

        shapeMenu.add(rectangleItem);
        shapeMenu.add(circleItem);
        menuBar.add(shapeMenu);

        setJMenuBar(menuBar);
        add(canvas, BorderLayout.CENTER);
    }

    private class ShapeMenuActionListener implements ActionListener {
        private ShapeType shapeType;

        public ShapeMenuActionListener(ShapeType shapeType) {
            this.shapeType = shapeType;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            shapeFactory.setShapeType(shapeType);
        }
    }


}