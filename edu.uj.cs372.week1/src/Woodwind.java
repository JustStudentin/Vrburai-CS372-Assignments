public class Woodwind extends Instrument
{
    //variables
    private boolean reed;

    //constructor
    public Woodwind(String name, String material, String pitchStandard, boolean isTuned, boolean reed)
    {
        //call parent
        super(name, material, pitchStandard, isTuned);
        this.reed = reed;
    }

    @Override
    public void play()
    {
        if (reed == false)
            System.out.println(getName() + " sound better with a reed!");
        if(getIsTuned() == false)
            System.out.println("You should probably tune your " + getName());
        if (reed == true && getIsTuned() == true)
            System.out.println(getName() + " sounds wonderful!");
    }

        public String getFamily()
    {
        return "Woodwind";
    }
}