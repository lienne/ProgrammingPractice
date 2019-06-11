import java.awt.*;
public class Dogs_Main {
    public static void main(String[] args) {

        Dogs tj = new Dogs(11, Color.YELLOW, "TJ", "Chihuaha");
        int age = tj.age;

        System.out.println(tj.age);
        System.out.println(tj.name);
        // System.out.println(age);
        int new_age = tj.age_in_human();
        System.out.println(new_age);
        tj.rename_doggo("Frank");
        System.out.println(tj.age);
        System.out.println(tj.name);
        // System.out.println(age);
    }
}

class Dogs {

    int age;
    Color fur;
    String name, breed;

    // constructor
    public Dogs(int dog_age, Color fur_color, String dog_name, String dog_breed) {

        this.age = dog_age;
        this.fur = fur_color;
        this.name = dog_name;
        this.breed = dog_breed;

    }

    public void rename_doggo(String name) {
        this.name = name;
    }

    public int age_in_human() {
        // age *= 7;
        int age_human = age * 7;
        return age_human;
    }


}
