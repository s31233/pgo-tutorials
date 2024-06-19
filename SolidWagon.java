public class SolidWagon implements Wagon {
    private String id;
    private int capacity;
    private int maxWeight;
    private int currentWeight;

    public SolidWagon(String id, int capacity, int maxWeight) {
        this.id = id;
        this.capacity = capacity;
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getMaxWeight() {
        return maxWeight;
    }

    @Override
    public boolean loadCargo(int weight, boolean isLiquid, boolean isDangerous) throws Exception {
        if (isLiquid || isDangerous) {
            throw new Exception("SolidWagon can only load solid, non-dangerous cargo.");
        }
        if (currentWeight + weight > maxWeight) {
            throw new Exception("Exceeds maximum weight capacity.");
        }
        currentWeight += weight;
        return true;
    }
}
