import java.util.Random;

public class Shoulders extends Equipment{
    int max = 10;

    public Shoulders(int randomShoulders){
        if (randomShoulders < 0 || randomShoulders >= max){
            Random rand = new Random();
            randomShoulders = rand.nextInt(max);
        }
        switch (randomShoulders){
            case 0:
                name = "Alligator Scaled Mantle";
                id = 0;
                classAll = true;
                bonusAC = 9;
                bonusHP = 8;
                strength = 4;
                stamina = 2;
                agility = 3;
                charisma = 4;
                attack = 5;
                hpRegen = 1;
                hasAugment = true;
                break;
            case 1:
                name = "Bat Cloak";
                id = 1;
                classAll = true;
                magicRes = 5;
                fireRes = 5;
                coldRes = 5;
                diseaseRes = 5;
                poisonRes = 5;
                attack = 2;
                hpRegen = 2;
                manaRegen = 2;
                endRegen = 2;
                healAmount = 2;
                spellDamage = 2;
                hasAugment = true;
                break;
            case 2:
                name = "Burlap Shawl";
                id = 2;
                classAll = true;
                bonusAC = 8;
                bonusHP = 5;
                bonusMana = 15;
                strength = 9;
                stamina = 2;
                intelligence = 5;
                wisdom = 5;
                dexterity = 2;
                charisma = 5;
                diseaseRes = 5;
                poisonRes = 5;
                healAmount = 1;
                spellDamage = 1;
                hasAugment = true;
                break;
            case 3:
                name = "Fungus Covered Mantle";
                id = 3;
                classAll = true;
                bonusAC = 16;
                bonusHP = 35;
                bonusEnd = 40;
                strength = 13;
                stamina = 9;
                agility = 9;
                dexterity = 13;
                charisma = -8;
                diseaseRes = 10;
                attack = 2;
                hpRegen = 8;
                hasAugment = true;
                break;
            case 4:
                name = "Leather Telkalar Pauldrons";
                id = 4;
                classAll = true;
                bonusAC = 18;
                bonusHP = 35;
                bonusMana = 25;
                bonusEnd = 50;
                strength = 14;
                heroicStrength = 1;
                stamina = 4;
                intelligence = 8;
                wisdom = 8;
                agility = 4;
                dexterity = 13;
                poisonRes = 15;
                attack = 3;
                combateffects = 1;
                hasAugment = true;
                break;
            case 5:
                name = "Old Shawl";
                id = 5;
                classAll = true;
                bonusAC = 13;
                bonusHP = 35;
                bonusMana = 55;
                bonusEnd = 25;
                strength = 8;
                stamina = 7;
                intelligence = 15;
                wisdom = 15;
                dexterity = 8;
                charisma = 13;
                diseaseRes = 10;
                manaRegen = 1;
                healAmount = 4;
                spellDamage = 4;
                hasAugment = true;
                break;
            case 6:
                name = "Plate Telkalar Pauldrons";
                id = 6;
                classAll = true;
                bonusAC = 19;
                bonusHP = 50;
                bonusMana = 25;
                bonusEnd = 25;
                strength = 6;
                stamina = 13;
                intelligence = 2;
                wisdom = 4;
                agility = 13;
                dexterity = 7;
                poisonRes = 15;
                spellShield = 1;
                shielding = 2;
                avoidance = 2;
                hasAugment = true;
                break;
            case 7:
                name = "Silken Telkalar Pauldrons";
                id = 7;
                classAll = true;
                bonusAC = 11;
                bonusHP = 35;
                bonusMana = 50;
                strength = 6;
                stamina = 4;
                intelligence = 13;
                heroicIntelligence = 1;
                wisdom = 13;
                heroicWisdom = 1;
                charisma = 8;
                poisonRes = 15;
                healAmount = 5;
                spellDamage = 5;
                hasAugment = true;
                break;
            case 8:
                name = "Soft Scaled Mantle";
                id = 8;
                classAll = true;
                bonusAC = 8;
                bonusHP = 5;
                bonusMana = 15;
                intelligence = 4;
                wisdom = 4;
                charisma = 6;
                hasAugment = true;
                break;
            case 9:
                name = "Wraps of the Patient";
                id = 9;
                classAll = true;
                bonusAC = 4;
                bonusHP = 10;
                bonusEnd = 20;
                strength = 9;
                stamina = 2;
                intelligence = 2;
                wisdom = 2;
                agility = 4;
                dexterity = 6;
                attack = 2;
                hasAugment = true;
                break;
        }
    }

    public Shoulders(Shoulders inShoulders){
        name = inShoulders.name;
        id = inShoulders.id;
        hasAugment = inShoulders.hasAugment;
        augment = inShoulders.augment;
        hasAugmentWOS = inShoulders.hasAugmentWOS;
        augmentWOS = inShoulders.augmentWOS;
        bonusAC = inShoulders.bonusAC;
        bonusHP = inShoulders.bonusHP;
        bonusMana = inShoulders.bonusMana;
        bonusEnd = inShoulders.bonusEnd;
        strength = inShoulders.strength;
        stamina = inShoulders.stamina;
        agility = inShoulders.agility;
        dexterity = inShoulders.dexterity;
        intelligence = inShoulders.intelligence;
        wisdom = inShoulders.wisdom;
        charisma = inShoulders.charisma;
        heroicStrength = inShoulders.strength;
        heroicStamina = inShoulders.stamina;
        heroicAgility = inShoulders.agility;
        heroicDexterity = inShoulders.heroicDexterity;
        heroicIntelligence = inShoulders.heroicIntelligence;
        heroicWisdom = inShoulders.heroicWisdom;
        heroicCharisma = inShoulders.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inShoulders.magicRes;
        fireRes = inShoulders.fireRes;
        coldRes = inShoulders.coldRes;
        diseaseRes = inShoulders.diseaseRes;
        poisonRes = inShoulders.poisonRes;
        corruptionRes = inShoulders.corruptionRes;

        //Equipment Special Data Fields
        attack = inShoulders.attack;
        hpRegen = inShoulders.hpRegen;
        manaRegen = inShoulders.manaRegen;
        endRegen = inShoulders.endRegen;
        spellShield = inShoulders.spellShield;
        shielding = inShoulders.shielding;
        dotShield = inShoulders.dotShield;
        damageShield = inShoulders.damageShield;
        dsMitigation = inShoulders.dsMitigation;
        avoidance = inShoulders.avoidance;
        accuracy = inShoulders.accuracy;
        stunResist = inShoulders.stunResist;
        strikeThrough = inShoulders.strikeThrough;
        healAmount = inShoulders.healAmount;
        spellDamage = inShoulders.spellDamage;
        clairvoyance = inShoulders.clairvoyance;

        //Class Equipable Logic
        classAll = inShoulders.classAll;
        classMagician = inShoulders.classMagician;
        classCleric = inShoulders.classCleric;
        classBard = inShoulders.classBard;
        classShaman = inShoulders.classShaman;
        classDruid = inShoulders.classDruid;
        classRanger = inShoulders.classRanger;
        classMonk = inShoulders.classMonk;
        classEnchanter = inShoulders.classEnchanter;
        classNecromancer = inShoulders.classNecromancer;
        classRogue = inShoulders.classRogue;
        classWarrior = inShoulders.classWarrior;
        classBerserker = inShoulders.classBerserker;
        classShadowknight = inShoulders.classShadowknight;
        classWizard = inShoulders.classWizard;
        classPaladin = inShoulders.classPaladin;
        classBeastlord = inShoulders.classBeastlord;
    }
}
