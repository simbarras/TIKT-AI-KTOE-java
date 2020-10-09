package neural;

import java.util.ArrayList;

public class Network {

    private ArrayList<Neural> inputs;
    private ArrayList<Neural> hidden1;
    private ArrayList<Neural> hidden2;
    private ArrayList<Neural> outputs;

    public boolean createNew() {
        boolean result = false;

        inputs = new ArrayList<>();
        hidden1 = new ArrayList<>();
        hidden2 = new ArrayList<>();
        outputs = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            inputs.add(new Neural("input"));
            hidden1.add(new Neural("hidden"));
            hidden2.add(new Neural("hidden"));
            outputs.add(new Neural("outpout"));
        }

        return result;
    }

    public double[] play(int[] n) {

        double[] valInputs = new double[9];
        double[] valHidden1 = new double[9];
        double[] valHidden2 = new double[9];
        double[] valOutputs = new double[9];

        for (int i = 0; i < inputs.size(); i++) {
            double[] valNeural = hidden1.get(i).forward(n[i]);
            for (int j = 0; j < valNeural.length; j++) {
                valInputs[j] += valNeural[j];
            }
        }

        for (int i = 0; i < hidden1.size(); i++) {
            double[] valNeural = hidden1.get(i).forward(valInputs[i]);
            for (int j = 0; j < valNeural.length; j++) {
                valHidden1[j] += valNeural[j];
            }
        }

        for (int i = 0; i < hidden2.size(); i++) {
            double[] valNeural = hidden2.get(i).forward(valHidden1[i]);
            for (int j = 0; j < valNeural.length; j++) {
                valHidden2[j] += valNeural[j];
            }
        }

        for (int i = 0; i < outputs.size(); i++) {
            valOutputs[i] += outputs.get(i).forwardOutpout(valHidden2[i]);
        }

        return valOutputs;
    }
}
