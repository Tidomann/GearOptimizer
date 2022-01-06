public class Head extends Equipment{
    int max = 11;

    public Head(int randomHead){
        switch (randomHead){
            case 0:
                name = "Bat Fur Headress";
                id = 0;
                classAll = true;
                bonusAC = 11;
                strength = 2;
                stamina = 2;
                intelligence = 7;
                wisdom = 7;
                charisma = 5;
                fireRes = 5;
                poisonRes = 5;
                healAmount = 2;
                spellDamage = 2;
                hasAugment = true;
                break;
            case 1:
                name = "Burrowing Helm";
                id = 1;
                classAll = true;
                bonusAC = 15;
                bonusMana = 15;
                bonusEnd = 20;
                strength = 9;
                wisdom = 9;
                dexterity = 9;
                accuracy = 2;
                healAmount = 2;
                hasAugment = true;
                break;
            case 2:
                name = "Crystalline Chitin Circlet";
                id = 2;
                classAll = true;
                bonusAC = 12;
                strength = 3;
                intelligence = 3;
                wisdom = 3;
                hasAugment = true;
                break;
            case 3:
                name = "Feathered Skull Helm";
                id = 3;
                classAll = true;
                bonusAC = 8;
                bonusHP = 6;
                bonusMana = 12;
                bonusEnd = 6;
                strength = 3;
                intelligence = 5;
                wisdom = 5;
                charisma = 5;
                hasAugment = true;
                break;
            case 4:
                name = "Grubby Cap";
                id = 4;
                classAll = true;
                bonusAC = 11;
                bonusHP = 25;
                bonusMana = 40;
                strength = 6;
                stamina = 6;
                intelligence = 13;
                wisdom = 13;
                charisma = 13;
                diseaseRes = 10;
                manaRegen = 1;
                spellDamage = 3;
                hasAugment = true;
                break;
            case 5:
                name = "Horned Skull Helm";
                id = 5;
                classAll = true;
                bonusAC = 15;
                bonusHP = 12;
                bonusMana = 6;
                bonusEnd = 6;
                strength = 3;
                stamina = 5;
                wisdom = 2;
                agility = 5;
                dexterity = 3;
                hasAugment = true;
                break;
            case 6:
                name = "Shell Cap";
                id = 6;
                classAll = true;
                bonusAC = 6;
                bonusMana = 15;
                strength = 2;
                stamina = 2;
                intelligence = 5;
                wisdom = 5;
                charisma = 3;
                magicRes = 5;
                hasAugment = true;
                break;
            case 7:
                name = "Skull Helm";
                id = 7;
                classAll = true;
                bonusAC = 12;
                bonusHP = 10;
                bonusMana = 6;
                bonusEnd = 6;
                strength = 4;
                stamina = 4;
                wisdom = 2;
                hasAugment = true;
                break;
            case 8:
                name = "Straw Hat";
                id = 8;
                classAll = true;
                bonusAC = 8;
                bonusHP = 10;
                bonusMana = 20;
                strength = 6;
                intelligence = 9;
                wisdom = 9;
                dexterity = 3;
                charisma = -8;
                diseaseRes = 5;
                poisonRes = 5;
                endRegen = 2;
                healAmount = 1;
                spellDamage = 1;
                hasAugment = true;
                break;
            case 9:
                name = "Trueshot Cap";
                id = 9;
                classAll = true;
                bonusAC = 14;
                bonusHP = 30;
                bonusMana = 30;
                bonusEnd = 70;
                strength = 17;
                heroicStrength = 1;
                stamina = 9;
                intelligence = 7;
                wisdom = 7;
                agility = 8;
                dexterity = 15;
                heroicDexterity = 1;
                magicRes = 10;
                accuracy = 3;
                healAmount = 2;
                spellDamage = 2;
                hasAugment = true;
                break;
            case 10:
                name = "Wildfur Skullcap";
                id = 10;
                classAll = true;
                bonusAC = 9;
                bonusHP = 35;
                bonusMana = 10;
                bonusEnd = 50;
                strength = 14;
                stamina = 7;
                intelligence = 5;
                wisdom = 5;
                agility = 10;
                dexterity = 14;
                charisma = 8;
                attack = 2;
                hpRegen = 1;
                endRegen = 1;
                accuracy = 2;
                strikeThrough = 1;
                hasAugment = true;
                hasAugmentWOS = true;
                break;
        }
    }

    public Head(Head inHead){
        name = inHead.name;
        id = inHead.id;
        hasAugment = inHead.hasAugment;
        augment = inHead.augment;
        hasAugmentWOS = inHead.hasAugmentWOS;
        augmentWOS = inHead.augmentWOS;
        bonusAC = inHead.bonusAC;
        bonusHP = inHead.bonusHP;
        bonusMana = inHead.bonusMana;
        bonusEnd = inHead.bonusEnd;
        strength = inHead.strength;
        stamina = inHead.stamina;
        agility = inHead.agility;
        dexterity = inHead.dexterity;
        intelligence = inHead.intelligence;
        wisdom = inHead.wisdom;
        charisma = inHead.charisma;
        heroicStrength = inHead.strength;
        heroicStamina = inHead.stamina;
        heroicAgility = inHead.agility;
        heroicDexterity = inHead.heroicDexterity;
        heroicIntelligence = inHead.heroicIntelligence;
        heroicWisdom = inHead.heroicWisdom;
        heroicCharisma = inHead.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inHead.magicRes;
        fireRes = inHead.fireRes;
        coldRes = inHead.coldRes;
        diseaseRes = inHead.diseaseRes;
        poisonRes = inHead.poisonRes;
        corruptionRes = inHead.corruptionRes;

        //Equipment Special Data Fields
        attack = inHead.attack;
        hpRegen = inHead.hpRegen;
        manaRegen = inHead.manaRegen;
        endRegen = inHead.endRegen;
        spellShield = inHead.spellShield;
        shielding = inHead.shielding;
        dotShield = inHead.dotShield;
        damageShield = inHead.damageShield;
        dsMitigation = inHead.dsMitigation;
        avoidance = inHead.avoidance;
        accuracy = inHead.accuracy;
        stunResist = inHead.stunResist;
        strikeThrough = inHead.strikeThrough;
        healAmount = inHead.healAmount;
        spellDamage = inHead.spellDamage;
        clairvoyance = inHead.clairvoyance;

        //Class Equipable Logic
        classAll = false;
        classMagician = false;
        classCleric = false;
        classBard = false;
        classShaman = false;
        classDruid = false;
        classRanger = false;
        classMonk = false;
        classEnchanter = false;
        classNecromancer = false;
        classRogue = false;
        classWarrior = false;
        classBerserker = false;
        classShadowknight = false;
        classWizard = false;
        classPaladin = false;
        classBeastlord = false;
    }
}
