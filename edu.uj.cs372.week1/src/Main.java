public class Main
{
    public static void main(String[]args)
    {
        //object 1 - Brass Instrument
        Instrument instrument1 = new Brass("Trombone", "Brass", "Bb", false, true);

        // Object 2 - Woodwind Instrument
        Instrument instrument2 = new Woodwind("Flute", "Silver", "C", false, false);

        // Object 3 - String Instrument
        Instrument instrument3 = new Strings("Bass", "Wood", "E", false, 4);

                // Display instrument information
        System.out.println("===== INSTRUMENT TESTING =====");

        System.out.println("\nInstrument: " + instrument1.getName());
        System.out.println("Family: " + instrument1.getFamily());
        System.out.println("Material: " + instrument1.getMaterial());
        System.out.println("Pitch Standard: " + instrument1.getPitchStandard());

        System.out.println("\nInstrument: " + instrument2.getName());
        System.out.println("Family: " + instrument2.getFamily());
        System.out.println("Material: " + instrument2.getMaterial());
        System.out.println("Pitch Standard: " + instrument2.getPitchStandard());

        System.out.println("\nInstrument: " + instrument3.getName());
        System.out.println("Family: " + instrument3.getFamily());
        System.out.println("Material: " + instrument3.getMaterial());
        System.out.println("Pitch Standard: " + instrument3.getPitchStandard());


        // Test playing instruments
        System.out.println("\n===== PLAYING INSTRUMENTS =====");

        instrument1.play();
        instrument2.play();
        instrument3.play();


        // Test tuning instruments
        System.out.println("\n===== TUNING INSTRUMENTS =====");

        instrument1.tune();
        instrument2.tune();
        instrument3.tune();


        // Test playing again after tuning
        System.out.println("\n===== PLAYING AFTER TUNING =====");

        instrument1.play();
        instrument2.play();
        instrument3.play();
    }
}