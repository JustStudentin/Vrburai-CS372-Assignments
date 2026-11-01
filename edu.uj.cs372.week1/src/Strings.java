public class Strings extends Instrument
{
    //variables
    private int numberOfStrings;

    //constructor
    public Strings(String name, String material, String pitchStandard, boolean isTuned, int numberOfStrings)
    {
        //call parent
        super(name, material, pitchStandard, isTuned);
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public void play()
    {
        if(getIsTuned() == false)
            System.out.println("You should probably tune your " + getName());
        if(getIsTuned() == true)
            System.out.println("Strumming the " + numberOfStrings + "-string " + getName() + " sounds wonderful!");
    }

        public String getFamily()
    {
        return "Strings";
    }
}