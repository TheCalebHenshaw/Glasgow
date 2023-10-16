package ioop.lab4;

public class Adventurer extends WorldEntity{

    private Damage[] attacks = new Damage[3];


    // Task 3.1
    public Adventurer(String name, Coordinates location, int maxHealth, World world, Damage attack) {
        super(name, location, maxHealth, world, attack);

    }

    // Task 3.1
    public void addAttack(Damage attack)
    {

    }

    // Task 3.1
    public void attack(WorldEntity target)
    {

    }

    public Damage[] getAttacks()
    {
        return attacks;
    }
    


}