public class Brass extends Instrument
{
    //variables
    private boolean mouthpiece;

    //constructor
    public Brass(String name, String material, String pitchStandard, boolean isTuned, boolean mouthpiece)
    {
        //call parent
        super(name, material, pitchStandard, isTuned);
        this.mouthpiece = mouthpiece;
    }

    @Override
    public void play()
    {
        if (mouthpiece == false)
            System.out.println(getName() + " sound better with a mouthpiece!");
        if(getIsTuned() == false)
            System.out.println("You should probably tune your " + getName());
        if (mouthpiece == true && getIsTuned() == true)
            System.out.println(getName() + " sounds wonderful!");
    }

    public String getFamily()
    {
        return "Brass";
    }
}