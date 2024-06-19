public class TemperatureControlledWagon implements Wagon {
    private String id;
    private int capacity;
    private int maxWeight;
    private int currentWeight;

    public TemperatureControlledWagon(String id, int capacity, int maxWeight) {
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
            throw new Exception("TemperatureControlledWagon can only load solid, non-dangerous cargo that requires specific temperature.");
        }
        if (currentWeight + weight > maxWeight) {
            throw new Exception("Exceeds maximum weight capacity.");
        }
        currentWeight += weight;
        return true;
    }
}
