package neural;

import java.io.*;
import java.util.ArrayList;

public class Brain {
    private final String FILEPATH = "ressource/neural.network";
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

    public boolean saveNetwork() {
        boolean result = false;

        if (FILEPATH != null) {
            ObjectOutputStream out = null;
            try {
                out = new ObjectOutputStream(new FileOutputStream(FILEPATH));
                out.writeObject(network);
                out.flush();
                out.close();
                out = null;
                result = true;
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (out != null) {
                    try {
                        out.close();
                        out = null;
                        if (!result) {
                            new File(FILEPATH).delete();
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return result;
    }

    private boolean loadNetwork() {
        boolean result = false;
        if (FILEPATH != null) {
            ObjectInputStream in = null;
            try {
                in = new ObjectInputStream(new FileInputStream(FILEPATH));
                network = (Network) in.readObject();
                in.close();
                in = null;
                result = true;
            } catch (Exception e) {
                network = null;
                result = false;
            } finally {
                if (in != null) {
                    try {
                        in.close();
                        in = null;
                    } catch (Exception e) {
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Brain b = new Brain();
        for (int i = 0; i < 10; i++) {
            System.out.println("Essaie " + i);
            if (!b.loadNetwork()) {
                b.createNetwork();
            }
            b.train();
            b.saveNetwork();
        }
    }

}
