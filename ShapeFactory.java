import java.awt.Color;
import java.util.Random;

public class ShapeFactory {
    private ShapeType shapeType;
    private Random random;

    public ShapeFactory() {
        this.shapeType = ShapeType.RECTANGLE; // Default shape type
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
