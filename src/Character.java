public class Character implements Comparable<Character> {
    double fitness = 0;
    //Character Data Fields
    String characterClass = "Ranger";
    //Character Stat Data Fields
    int bonusAC = 0;
    int bonusHP = 0;
    int bonusMana = 0;
    int bonusEnd = 0;
    int strength = 75;
    int stamina = 85;
    int agility = 105;
    int dexterity = 110;
    int intelligence = 67;
    int wisdom = 85;
    int charisma = 50;
    int heroicStrength = 0;
    int heroicStamina = 0;
    int heroicAgility = 0;
    int heroicDexterity = 0;
    int heroicIntelligence = 0;
    int heroicWisdom = 0;
    int heroicCharisma = 0;

    //Character Resist Data Fields
    int magicRes = 25;
    int fireRes = 29;
    int coldRes = 29;
    int diseaseRes = 20;
    int poisonRes = 20;
    int corruptionRes = 15;

    //Character Special Data Fields
    int attack = 0;
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
    int combateffects = 0;
    int haste;
    int hastev3;

    //skill mods
    int skillDodge = 0;
    int skillSafeFall = 0;
    int skillDefense = 0;
    int skill1HSlashing = 0;
    int skillOffense = 0;
    int skillChanneling = 0;
    int skillEvocation = 0;
    int kickdamage = 0;
    int skillParry = 0;

    Outfit outfit;

    public Character() {
        outfit = new Outfit();
    }

    @Override
    public int compareTo(Character c) {
        if(fitness == c.fitness)
            return 0;
        else if(fitness > c.fitness)
            return 1;
        else
            return -1;
    }
}