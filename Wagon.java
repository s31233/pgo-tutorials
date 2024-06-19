public interface Wagon {
    String getId();
    int getCapacity();
    int getMaxWeight();
    boolean loadCargo(int weight, boolean isLiquid, boolean isDangerous) throws Exception;
}

