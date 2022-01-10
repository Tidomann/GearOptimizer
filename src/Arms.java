import java.util.Random;

public class Arms extends Equipment{
    int max = 10;

    public Arms(int randomArms){
        if (randomArms < 0 || randomArms >= max){
            Random rand = new Random();
            randomArms = rand.nextInt(max);
        }
        switch (randomArms){
            case 0:
                name = "Ant Armguards";
                id = 0;
                classAll = true;
                bonusAC = 11;
                bonusHP = 5;
                bonusMana = 5;
                bonusEnd = 17;
                haste = 12;
                strength = 7;
                stamina = 2;
                intelligence = 3;
                wisdom = 3;
                agility = 3;
                dexterity = 6;
                attack = 1;
                accuracy = 1;
                hasAugment = true;
                break;
            case 1:
                name = "Armguards of Protection";
                id = 1;
                classAll = true;
                bonusAC = 19;
                bonusHP = 70;
                bonusEnd = 30;
                strength = 10;
                stamina = 17;
                heroicStamina = 1;
                agility = 17;
                heroicAgility = 1;
                dexterity = 10;
                coldRes = 15;
                hpRegen = 3;
                dotShield = 2;
                avoidance = 2;
                hasAugment = true;
                break;
            case 2:
                name = "Crystalline Chitin Vambraces";
                id = 2;
                classAll = true;
                bonusAC = 18;
                bonusHP = 20;
                bonusMana = 20;
                bonusEnd = 15;
                strength = 5;
                stamina = 5;
                hasAugment = true;
                break;
            case 3:
                name = "Feathered Sleeves";
                id = 3;
                classAll = true;
                bonusAC = 4;
                bonusHP = 20;
                intelligence = 7;
                wisdom = 7;
                hasAugment = true;
                break;
            case 4:
                name = "Ironwraught Armguards";
                id = 4;
                classAll = true;
                bonusAC = 16;
                bonusHP = 55;
                bonusMana = 15;
                bonusEnd = 20;
                strength = 7;
                stamina = 13;
                intelligence = 5;
                wisdom = 5;
                agility = 13;
                charisma = 13;
                hpRegen = 1;
                shielding = 1;
                hasAugment = true;
                hasAugmentWOS = true;
                break;
            case 5:
                name = "Mechanical Armguards";
                id = 5;
                classAll = true;
                bonusAC = 13;
                bonusHP = 35;
                bonusEnd = 50;
                strength = 14;
                stamina = 7;
                intelligence = 4;
                wisdom = 4;
                dexterity = 14;
                diseaseRes = 10;
                accuracy = 2;
                spellDamage = 2;
                skill1HSlashing = 5;
                hasAugment = true;
                break;
            case 6:
                name = "Myrmidon Armguards";
                id = 6;
                classAll = true;
                bonusAC = 14;
                bonusHP = 20;
                bonusMana = 10;
                bonusEnd = 10;
                strength = 5;
                stamina = 5;
                magicRes = 5;
                coldRes = 5;
                hasAugment = true;
                break;
            case 7:
                name = "Sleeves of Avoidance";
                id = 7;
                classAll = true;
                bonusAC = 11;
                bonusHP = 45;
                bonusMana = 45;
                stamina = 13;
                intelligence = 13;
                wisdom = 13;
                agility = 13;
                heroicAgility = 1;
                charisma = 13;
                avoidance = 4;
                healAmount = 2;
                spellDamage = 2;
                hasAugment = true;
                hasAugmentWOS = true;
                break;
            case 8:
                name = "Sleeves of Destruction";
                id = 8;
                classAll = true;
                bonusAC = 9;
                bonusHP = 25;
                bonusMana = 35;
                strength = 5;
                stamina = 8;
                intelligence = 12;
                wisdom = 12;
                charisma = 9;
                spellDamage = 3;
                hasAugment = true;
                break;
            case 9:
                name = "Worker's Arms";
                id = 9;
                classAll = true;
                bonusAC = 8;
                bonusHP = 5;
                bonusMana = 10;
                bonusEnd = 25;
                strength = 8;
                stamina = 3;
                intelligence = 5;
                wisdom = 5;
                agility = 6;
                poisonRes = 5;
                attack = 1;
                clairvoyance = 2;
                hasAugment = true;
                break;
        }
    }

    public Arms(Arms inArms){
        name = inArms.name;
        id = inArms.id;
        hasAugment = inArms.hasAugment;
        if(hasAugment && inArms.augment != null){
            augment = new Augment((Augment) inArms.augment);
        }
        hasAugmentWOS = inArms.hasAugmentWOS;
        if(hasAugmentWOS && inArms.augmentWOS != null){
            augmentWOS = new Augment((Augment) inArms.augmentWOS);
        }
        bonusAC = inArms.bonusAC;
        bonusHP = inArms.bonusHP;
        bonusMana = inArms.bonusMana;
        bonusEnd = inArms.bonusEnd;
        strength = inArms.strength;
        stamina = inArms.stamina;
        agility = inArms.agility;
        dexterity = inArms.dexterity;
        intelligence = inArms.intelligence;
        wisdom = inArms.wisdom;
        charisma = inArms.charisma;
        heroicStrength = inArms.strength;
        heroicStamina = inArms.stamina;
        heroicAgility = inArms.agility;
        heroicDexterity = inArms.heroicDexterity;
        heroicIntelligence = inArms.heroicIntelligence;
        heroicWisdom = inArms.heroicWisdom;
        heroicCharisma = inArms.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inArms.magicRes;
        fireRes = inArms.fireRes;
        coldRes = inArms.coldRes;
        diseaseRes = inArms.diseaseRes;
        poisonRes = inArms.poisonRes;
        corruptionRes = inArms.corruptionRes;

        //Equipment Special Data Fields
        attack = inArms.attack;
        hpRegen = inArms.hpRegen;
        manaRegen = inArms.manaRegen;
        endRegen = inArms.endRegen;
        spellShield = inArms.spellShield;
        shielding = inArms.shielding;
        dotShield = inArms.dotShield;
        damageShield = inArms.damageShield;
        dsMitigation = inArms.dsMitigation;
        avoidance = inArms.avoidance;
        accuracy = inArms.accuracy;
        stunResist = inArms.stunResist;
        strikeThrough = inArms.strikeThrough;
        healAmount = inArms.healAmount;
        spellDamage = inArms.spellDamage;
        clairvoyance = inArms.clairvoyance;

        //Class Equipable Logic
        classAll = inArms.classAll;
        classMagician = inArms.classMagician;
        classCleric = inArms.classCleric;
        classBard = inArms.classBard;
        classShaman = inArms.classShaman;
        classDruid = inArms.classDruid;
        classRanger = inArms.classRanger;
        classMonk = inArms.classMonk;
        classEnchanter = inArms.classEnchanter;
        classNecromancer = inArms.classNecromancer;
        classRogue = inArms.classRogue;
        classWarrior = inArms.classWarrior;
        classBerserker = inArms.classBerserker;
        classShadowknight = inArms.classShadowknight;
        classWizard = inArms.classWizard;
        classPaladin = inArms.classPaladin;
        classBeastlord = inArms.classBeastlord;
    }
}
