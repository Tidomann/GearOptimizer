public class Character {
    //Character Data Fields
    String characterClass = "Ranger";
    //Character Stat Data Fields
    int bonusAC = 0;
    int strength = 75;
    int stam = 85;
    int agility = 105;
    int dex = 110;
    int intelligence = 67;
    int wisdom = 85;
    int charisma = 50;
    int heroicStrength = 0;
    int heroicStam = 0;
    int heroicInt = 0;
    int heroicWis = 0;
    int heroicDex = 0;
    int heroicCha = 0;

    //Character Resist Data Fields
    int magicRes = 25;
    int fireRes = 29;
    int coldRes = 29;
    int diseaseRes = 20;
    int poisonRes = 20;
    int corruptionRes = 15;

    //Character Special Data Fields
    int hpRegen = 0;
    int manaRegen = 0;
    int endRegen = 0;
    int spellShield = 0;
    int shielding = 0;
    int dotShield = 0;
    int damageShield = 0;
    int dsMitigation = 0;
    int avoidance = 0;
    int accuracy = 0;
    int stunResist = 0;
    int strikeThrough = 0;
    int healAmount = 0;
    int spellDamage = 0;
    int clairvoyance = 0;

    Outfit outfit;

    public Character(boolean Randomize) {
        if (Randomize) {
            //Generate Outfit
        }
        //do something else
    }
}