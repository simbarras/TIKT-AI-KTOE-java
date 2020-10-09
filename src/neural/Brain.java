package neural;

import java.util.ArrayList;

public class Brain {
    private Network network;

    public boolean createNetwork() {
        boolean result = false;

        network = new Network();
        network.createNew();
        return result;
    }

    public void train() {
        double[] result = network.play(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        for (double nOut : result) {
            System.out.println("Outpout node " + nOut);
        }
    }

    public static void main(String[] args) {
        Brain b = new Brain();
        for (int i = 0; i < 10; i++) {
            System.out.println("Essaie " + i);
            b.createNetwork();
            b.train();
        }
    }
}
