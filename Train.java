import java.util.ArrayList;
import java.util.List;

public class Train {
    private String id;
    private String model;
    private float maxSpeed;
    private int weight;
    private int productionYear;
    private List<Wagon> wagons;

    public Train(String id, String model) {
        this(id, model, 0, 0, 0);
    }

    public Train(String id, String model, float maxSpeed, int weight, int productionYear) {
        this.id = id;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.productionYear = productionYear;
        this.wagons = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public int getWeight() {
        return weight;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void addWagon(Wagon wagon) throws Exception {
        if (wagons.size() >= 200) {
            throw new Exception("Cannot add more than 200 wagons.");
        }
        if (wagon instanceof DangerousWagon) {
            wagons.add(wagon);
        } else {
            int insertIndex = 0;
            for (int i = wagons.size() - 1; i >= 0; i--) {
                if (!(wagons.get(i) instanceof DangerousWagon)) {
                    insertIndex = i + 1;
                    break;
                }
            }
            wagons.add(insertIndex, wagon);
        }
    }

    public Wagon removeWagon(String wagonId) {
        for (int i = 0; i < wagons.size(); i++) {
            if (wagons.get(i).getId().equals(wagonId)) {
                return wagons.remove(i);
            }
        }
        return null;
    }

    public void loadCargo(String wagonId, int weight, boolean isLiquid, boolean isDangerous) throws Exception {
        for (Wagon wagon : wagons) {
            if (wagon.getId().equals(wagonId)) {
                wagon.loadCargo(weight, isLiquid, isDangerous);
                return;
            }
        }
        throw new Exception("Wagon not found.");
    }
}

