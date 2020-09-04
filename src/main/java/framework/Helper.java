package framework;

public class Helper {

    public static String getRandomText(){
        return "Igor-" + getRandomInteger();
    }

    private static int getRandomInteger() {
       return (int) (Math.random() * 1000);
    }
    
    public static String getRandomEmail(){
        return "igor" + getRandomInteger() + "@gmail.com";
    }
    
}


// Helper help = new Helper();
// help.getRandomText();

// Helper.getRandomText();
// Naziv klase . staticka metoda