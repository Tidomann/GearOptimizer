abstract class Equipment {
    //Equipment Data Fields
    int slot;

    //Equipment  Stat Data Fields
    int bonusAC = 0;
    int strength = 0;
    int stam = 0;
    int agility = 0;
    int dex = 0;
    int intelligence = 0;
    int wisdom = 0;
    int charisma = 0;
    int heroicStrength = 0;
    int heroicStam = 0;
    int heroicInt = 0;
    int heroicWis = 0;
    int heroicDex = 0;
    int heroicCha = 0;

    //Equipment Resist Data Fields
    int magicRes = 0;
    int fireRes = 0;
    int coldRes = 0;
    int diseaseRes = 0;
    int poisonRes = 0;
    int corruptionRes = 0;

    //Equipment Special Data Fields
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

    public abstract boolean classCanUse(String inClass);
}
