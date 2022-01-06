abstract class Equipment {
    //Equipment Data Fields
    int id;
    String name;
    boolean hasAugment = false;
    Equipment augment;
    boolean hasAugmentWOS = false;
    Equipment augmentWOS;

    //Equipment  Stat Data Fields
    int bonusAC = 0;
    int bonusHP = 0;
    int bonusMana = 0;
    int bonusEnd = 0;
    int strength = 0;
    int stamina = 0;
    int agility = 0;
    int dexterity = 0;
    int intelligence = 0;
    int wisdom = 0;
    int charisma = 0;
    int heroicStrength = 0;
    int heroicStamina = 0;
    int heroicAgility = 0;
    int heroicDexterity = 0;
    int heroicIntelligence = 0;
    int heroicWisdom = 0;
    int heroicCharisma = 0;

    //Equipment Resist Data Fields
    int magicRes = 0;
    int fireRes = 0;
    int coldRes = 0;
    int diseaseRes = 0;
    int poisonRes = 0;
    int corruptionRes = 0;

    //Equipment Special Data Fields
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

    //skill mods
    int skillDodge = 0;
    int skillSafeFall = 0;
    int skillDefense = 0;
    int skill1HSlashing = 0;

    //Class Equipable Logic
    boolean classAll = false;
    boolean classMagician = false;
    boolean classCleric = false;
    boolean classBard = false;
    boolean classShaman = false;
    boolean classDruid = false;
    boolean classRanger = false;
    boolean classMonk = false;
    boolean classEnchanter = false;
    boolean classNecromancer = false;
    boolean classRogue = false;
    boolean classWarrior = false;
    boolean classBerserker = false;
    boolean classShadowknight = false;
    boolean classWizard = false;
    boolean classPaladin = false;
    boolean classBeastlord = false;

    public boolean classCanUse(String inClass){
        if(classAll){
            return true;
        }
        else{
            switch(inClass){
                case "Magician":
                    return classMagician;
                case "Cleric":
                    return classCleric;
                case "Bard":
                    return classBard;
                case "Shaman":
                    return classShaman;
                case "Druid":
                    return classDruid;
                case "Ranger":
                    return classRanger;
                case "Monk":
                    return classMonk;
                case "Enchanter":
                    return classEnchanter;
                case "Necromancer":
                    return classNecromancer;
                case "Rogue":
                    return classRogue;
                case "Warrior":
                    return classWarrior;
                case "Berserker":
                    return classBerserker;
                case "Shadowknight":
                    return classShadowknight;
                case "Wizard":
                    return classWizard;
                case "Paladin":
                    return classPaladin;
                case "Beastlord":
                    return classBeastlord;
            }
        }
        return false;
    }
}
