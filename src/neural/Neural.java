package neural;

import java.util.ArrayList;

public class Neural {

    private double weight;
    private String type;
    private ArrayList<Double> lWeight;

    public Neural(String type) {
        weight = (Math.random() * 2 - 1);
        this.type = type;
        if (type != "outpout") {
            lWeight = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                lWeight.add(Math.random() * 2 - 1);
            }
        }
    }

    public double forwardOutpout(double input) {
        return Math.tanh(input * weight);
    }

    public double[] forward(double input) {
        double[] result = new double[9];
        if (lWeight != null) {
            for (int i = 0; i < lWeight.size(); i++) {
                result[i] = lWeight.get(i) * Math.tanh(input + weight);
            }
        }
        return result;
    }
}
