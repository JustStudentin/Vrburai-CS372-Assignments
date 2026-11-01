public abstract class Instrument
{
    //fields or variables
    private String name;
    private String material;
    private String pitchStandard;
    private boolean isTuned;

    //constructor
    public Instrument(String name, String material, String pitchStandard, boolean isTuned)
    {
        this.name = name;
        this.material = material;
        this.pitchStandard = pitchStandard;
        this.isTuned = isTuned;
    }

    //behaviors
    public void tune()
    {
        this.isTuned = true;
        System.out.println(name + " is now tuned!");
    }

    public abstract void play();

    //methods
    public String getName()
    {
        return name;
    }

    public String getMaterial()
    {
        return material;
    }

    public String getPitchStandard()
    {
        return pitchStandard;
    }

    public boolean getIsTuned()
    {
        return isTuned;
    }

    public String getFamily()
    {
        return "Generic Instrument";
    }

}