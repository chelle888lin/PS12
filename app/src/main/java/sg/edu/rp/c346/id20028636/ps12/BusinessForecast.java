package sg.edu.rp.c346.id20028636.ps12;

public class BusinessForecast {

    private String Quarter;

    private int ID;

    private String Lvl1;

    private int value;

    public BusinessForecast(String Quarter, int ID, String Lvl1, int value) {
        this.Quarter = Quarter;
        this.ID = ID;
        this.Lvl1 = Lvl1;
        this.value = value;
    }

    public String getQuarter() {
        return Quarter;
    }

    public void setQuarter(String quarter) {
        Quarter = quarter;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLvl1() {
        return Lvl1;
    }

    public void setLvl1(String lvl1) {
        Lvl1 = lvl1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BusinessForecast{" +
                "Quarter:'" + Quarter + '\n' +
                ", ID:" + ID + '\n' +
                ", Lvl1:'" + Lvl1 + '\n' +
                ", value:" + value +
                '}';
    }
}
