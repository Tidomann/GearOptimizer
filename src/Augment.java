import java.util.Random;

public class Augment extends Equipment{
    int max = 18;
    int maxWOS = 12;

    public Augment(boolean augment, boolean augmentWOS){
        Random rand = new Random();
        if(augment){
            int randomint = rand.nextInt(max);
            switch (randomint){
                case 0:
                    name = "A Rejuvenating Spore";
                    hpRegen = 3;
                    break;
                case 1:
                    name = "Black Inlaid Dragon Eye";
                    bonusAC = 2;
                    stamina = 5;
                    healAmount = 1;
                    break;
                case 2:
                    name = "Blue Inlaid Dragon Eye";
                    wisdom = 5;
                    healAmount =1;
                    break;
                case 3:
                    name = "Candy Corn";
                    strength = 5;
                    dexterity = 5;
                    break;
                case 4:
                    name = "Ghostly Essence";
                    bonusAC = 7;
                    break;
                case 5:
                    name = "Greater shard of Fighting";
                    bonusHP = 25;
                    bonusEnd = 25;
                    break;
                case 6:
                    name = "Greater Shard of Hybrid";
                    bonusHP = 25;
                    bonusMana = 25;
                    break;
                case 7:
                    name = "Greater Shard of Resources";
                    bonusMana = 25;
                    bonusEnd = 25;
                    break;
                case 8:
                    name = "Green Inlaid Dragon Eye";
                    agility = 5;
                    dexterity = 5;
                    attack = 1;
                    break;
                case 9:
                    name = "Gummy Bear";
                    stamina = 5;
                    agility = 5;
                    break;
                case 10:
                    name = "Red Inlaid Dragon Eye";
                    strength = 5;
                    attack = 2;
                    break;
                case 11:
                    name = "Seeds of Power";
                    heroicStrength = 2;
                    heroicDexterity = 2;
                    break;
                case 12:
                    name = "Smarties";
                    intelligence = 5;
                    wisdom = 5;
                    charisma = 5;
                    break;
                case 13:
                    name = "White Inlaid Dragon Eye";
                    intelligence =5;
                    spellDamage = 1;
                    break;
                case 14:
                    name = "Strong Phosphite";
                    bonusEnd = 15;
                    strength = 3;
                    heroicStrength = 2;
                    dexterity = 3;
                    heroicDexterity = 2;
                    break;
                case 15:
                    name = "Enduring Phosphite";
                    bonusHP = 15;
                    stamina = 3;
                    heroicStamina = 2;
                    agility = 3;
                    heroicAgility = 2;
                    break;
                case 16:
                    name = "Bright Phosphite";
                    bonusMana = 15;
                    intelligence = 3;
                    heroicIntelligence = 2;
                    wisdom = 3;
                    heroicWisdom = 2;
                    charisma = 2;
                    heroicCharisma = 2;
                    break;
                case 17:
                    name = "Elemental Phosphite";
                    magicRes = 9;
                    fireRes = 9;
                    coldRes = 9;
                    diseaseRes = 9;
                    poisonRes = 9;
                    spellShield = 2;
            }
        }
        if(augmentWOS){
            int randomint = rand.nextInt(maxWOS);
            switch (randomint){
                case 0:
                    name = "A Rejuvenating Spore";
                    hpRegen = 3;
                    break;
                case 1:
                    name = "Bulwark Diamond";
                    bonusHP = 15;
                    stamina = 1;
                    break;
                case 2:
                    name = "Burning Opal";
                    bonusMana = 15;
                    intelligence = 2;
                    break;
                case 3:
                    name = "Critical Pearl";
                    bonusEnd = 15;
                    strength = 2;
                    break;
                case 4:
                    name = "Enduring Peridot";
                    bonusHP = 25;
                    bonusMana = 25;
                    bonusEnd = 25;
                    charisma = 2;
                    healAmount = 3;
                    spellDamage = 3;
                    clairvoyance = 1;
                    break;
                case 5:
                    name = "Evasive Bloodstone";
                    bonusHP = 25;
                    bonusMana = 25;
                    bonusEnd = 25;
                    strength = 2;
                    heroicStrength = 2;
                    agility = 2;
                    heroicAgility = 2;
                    break;
                case 6:
                    name = "Flowing Sapphire";
                    bonusMana = 15;
                    wisdom = 2;
                    break;
                case 7:
                    name = "Focused Jasper";
                    bonusHP = 25;
                    bonusMana = 25;
                    bonusEnd = 25;
                    strength = 2;
                    agility = 2;
                    dexterity = 2;
                    attack = 3;
                    strikeThrough = 3;
                    skillOffense = 1;
                    break;
                case 8:
                    name = "Furious Onyx";
                    bonusEnd = 15;
                    strength = 2;
                    break;
                case 9:
                    name = "Ghostly Essence";
                    bonusAC = 7;
                    break;
                case 10:
                    name = "Raging Firestone";
                    bonusMana = 15;
                    intelligence = 2;
                    break;
                case 11:
                    name = "Reaching Cat's Eye";
                    bonusHP = 25;
                    bonusMana = 25;
                    bonusEnd = 25;
                    intelligence = 2;
                    heroicIntelligence = 2;
                    wisdom = 2;
                    heroicWisdom = 2;
                    charisma = 2;
                    heroicCharisma = 2;
                    break;
            }
        }
    }



    public Augment(Augment inAugment){
        name = inAugment.name;
        id = inAugment.id;
        hasAugment = inAugment.hasAugment;
        augment = inAugment.augment;
        hasAugmentWOS = inAugment.hasAugmentWOS;
        augmentWOS = inAugment.augmentWOS;
        bonusAC = inAugment.bonusAC;
        bonusHP = inAugment.bonusHP;
        bonusMana = inAugment.bonusMana;
        bonusEnd = inAugment.bonusEnd;
        strength = inAugment.strength;
        stamina = inAugment.stamina;
        agility = inAugment.agility;
        dexterity = inAugment.dexterity;
        intelligence = inAugment.intelligence;
        wisdom = inAugment.wisdom;
        charisma = inAugment.charisma;
        heroicStrength = inAugment.strength;
        heroicStamina = inAugment.stamina;
        heroicAgility = inAugment.agility;
        heroicDexterity = inAugment.heroicDexterity;
        heroicIntelligence = inAugment.heroicIntelligence;
        heroicWisdom = inAugment.heroicWisdom;
        heroicCharisma = inAugment.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inAugment.magicRes;
        fireRes = inAugment.fireRes;
        coldRes = inAugment.coldRes;
        diseaseRes = inAugment.diseaseRes;
        poisonRes = inAugment.poisonRes;
        corruptionRes = inAugment.corruptionRes;

        //Equipment Special Data Fields
        attack = inAugment.attack;
        hpRegen = inAugment.hpRegen;
        manaRegen = inAugment.manaRegen;
        endRegen = inAugment.endRegen;
        spellShield = inAugment.spellShield;
        shielding = inAugment.shielding;
        dotShield = inAugment.dotShield;
        damageShield = inAugment.damageShield;
        dsMitigation = inAugment.dsMitigation;
        avoidance = inAugment.avoidance;
        accuracy = inAugment.accuracy;
        stunResist = inAugment.stunResist;
        strikeThrough = inAugment.strikeThrough;
        healAmount = inAugment.healAmount;
        spellDamage = inAugment.spellDamage;
        clairvoyance = inAugment.clairvoyance;

        //Class Equipable Logic
        classAll = inAugment.classAll;
        classMagician = inAugment.classMagician;
        classCleric = inAugment.classCleric;
        classBard = inAugment.classBard;
        classShaman = inAugment.classShaman;
        classDruid = inAugment.classDruid;
        classRanger = inAugment.classRanger;
        classMonk = inAugment.classMonk;
        classEnchanter = inAugment.classEnchanter;
        classNecromancer = inAugment.classNecromancer;
        classRogue = inAugment.classRogue;
        classWarrior = inAugment.classWarrior;
        classBerserker = inAugment.classBerserker;
        classShadowknight = inAugment.classShadowknight;
        classWizard = inAugment.classWizard;
        classPaladin = inAugment.classPaladin;
        classBeastlord = inAugment.classBeastlord;
    }
}
