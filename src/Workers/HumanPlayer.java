package Workers;

import proglib.SimpleIO;

public class HumanPlayer implements Player{
    protected int ref;
    protected String name;

    public HumanPlayer(int ref, String name) {
        this.ref = ref;
        this.name = name;
    }

    public int[] play() throws Exception {
        int[] result = {0, 0, ref};
        result[0] = SimpleIO.readInt("Player"+ref+" "+name+": x");
        result[1] = SimpleIO.readInt("Player"+ref+" "+name+": y");
        return result;
    }

    @Override
    public int getRef() {
        return ref;
    }

    @Override
    public String getName() {
        return name;
    }
}
