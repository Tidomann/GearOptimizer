import java.util.Random;

public class Face extends Equipment{
    int max = 11;

    public Face(int randomFace){
        if (randomFace < 0 || randomFace >= max){
            Random rand = new Random();
            randomFace = rand.nextInt(max);
        }
        switch (randomFace){
            case 0:
                name = "Balanced Mask";
                id = 0;
                classAll = true;
                bonusAC = 1;
                bonusHP = 15;
                intelligence = 6;
                wisdom = 6;
                dexterity = -2;
                charisma = 6;
                hpRegen = -1;
                manaRegen = 1;
                hasAugment = true;
                break;
            case 1:
                name = "Clay Mask";
                id = 1;
                classAll = true;
                bonusAC = 15;
                bonusHP = 60;
                strength = 5;
                stamina = 10;
                heroicStamina = 1;
                intelligence = 3;
                wisdom = 10;
                agility = 12;
                dexterity = 6;
                charisma = 8;
                poisonRes = 15;
                hpRegen = 1;
                accuracy = 1;
                healAmount = 2;
                skillDefense = 5;
                hasAugment = true;
                break;
            case 2:
                name = "Geared Monocle";
                id = 2;
                classAll = true;
                bonusAC = 4;
                strength = 7;
                wisdom = 7;
                poisonRes = 5;
                accuracy = 7;
                hasAugment = true;
                break;
            case 3:
                name = "Mask of Flowing Mana";
                id = 3;
                classAll = true;
                bonusHP = 40;
                bonusMana = 40;
                strength = 3;
                stamina = 7;
                intelligence = 16;
                heroicIntelligence = 1;
                wisdom = 16;
                heroicWisdom = 1;
                charisma = 14;
                heroicCharisma = 1;
                magicRes = 10;
                manaRegen = 4;
                healAmount = 3;
                spellDamage = 3;
                hasAugment = true;
                break;
            case 4:
                name = "Oaken Mask";
                id = 4;
                classAll = true;
                bonusAC = 13;
                bonusHP = 20;
                bonusEnd = 10;
                strength = 3;
                stamina = 9;
                agility = 9;
                fireRes = -5;
                diseaseRes = 5;
                poisonRes = 5;
                hpRegen = 1;
                hasAugment = true;
                break;
            case 5:
                name = "Oxygen Mask";
                id = 5;
                classAll = true;
                bonusMana = 65;
                bonusEnd = 65;
                strength = 9;
                intelligence = 9;
                wisdom = 9;
                dexterity = 9;
                attack = 4;
                healAmount = 3;
                spellDamage = 3;
                hasAugment = true;
                break;
            case 6:
                name = "Pristine Bastet Whiskers";
                id = 6;
                classAll = true;
                bonusAC = 5;
                bonusMana = 50;
                bonusEnd = 50;
                haste = 10;
                strength = 15;
                intelligence = 14;
                wisdom = 14;
                agility = 15;
                dexterity = 12;
                attack = 2;
                accuracy = 2;
                strikeThrough = 2;
                healAmount = 2;
                spellDamage = 3;
                skillSafeFall = 5;
                hasAugment = true;
                hasAugmentWOS = true;
                break;
            case 7:
                name = "Shiliskin Face Mask";
                id = 7;
                classAll = true;
                bonusAC = 8;
                bonusHP = 12;
                bonusMana = 4;
                bonusEnd = 5;
                strength = 2;
                stamina = 6;
                wisdom = 2;
                agility = 6;
                dexterity = 6;
                fireRes = 4;
                coldRes = 4;
                poisonRes = 4;
                hpRegen = 1;
                hasAugment = true;
                break;
            case 8:
                name = "Slatemetal Faceguard";
                id = 8;
                classAll = true;
                bonusAC = 20;
                bonusHP = 75;
                stamina = 15;
                heroicStamina = 1;
                magicRes = 15;
                fireRes = 15;
                coldRes = 15;
                diseaseRes = 15;
                poisonRes = 15;
                spellShield = 2;
                shielding = 2;
                dotShield = 2;
                skillDefense = 3;
                hasAugment = true;
                hasAugmentWOS = true;
                break;
            case 9:
                name = "Tunneler's Faceguard";
                id = 9;
                classAll = true;
                bonusAC = 15;
                bonusHP = 35;
                bonusEnd = 20;
                strength = 10;
                stamina = 9;
                agility = 1;
                dexterity = 9;
                charisma = 2;
                attack = 1;
                strikeThrough = 2;
                hasAugment = true;
                break;
            case 10:
                name = "Water Python Gills";
                id = 10;
                classAll = true;
                bonusAC = 3;
                bonusHP = 10;
                bonusMana = 10;
                bonusEnd = 10;
                strength = 4;
                stamina = 2;
                intelligence = 2;
                agility = 5;
                dexterity = 6;
                coldRes = 5;
                poisonRes = 8;
                attack = 5;
                endRegen = 1;
                hasAugment = true;
        }
    }

    public Face(Face inFace){
        name = inFace.name;
        id = inFace.id;
        hasAugment = inFace.hasAugment;
        augment = inFace.augment;
        hasAugmentWOS = inFace.hasAugmentWOS;
        augmentWOS = inFace.augmentWOS;
        bonusAC = inFace.bonusAC;
        bonusHP = inFace.bonusHP;
        bonusMana = inFace.bonusMana;
        bonusEnd = inFace.bonusEnd;
        strength = inFace.strength;
        stamina = inFace.stamina;
        agility = inFace.agility;
        dexterity = inFace.dexterity;
        intelligence = inFace.intelligence;
        wisdom = inFace.wisdom;
        charisma = inFace.charisma;
        heroicStrength = inFace.strength;
        heroicStamina = inFace.stamina;
        heroicAgility = inFace.agility;
        heroicDexterity = inFace.heroicDexterity;
        heroicIntelligence = inFace.heroicIntelligence;
        heroicWisdom = inFace.heroicWisdom;
        heroicCharisma = inFace.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inFace.magicRes;
        fireRes = inFace.fireRes;
        coldRes = inFace.coldRes;
        diseaseRes = inFace.diseaseRes;
        poisonRes = inFace.poisonRes;
        corruptionRes = inFace.corruptionRes;

        //Equipment Special Data Fields
        attack = inFace.attack;
        hpRegen = inFace.hpRegen;
        manaRegen = inFace.manaRegen;
        endRegen = inFace.endRegen;
        spellShield = inFace.spellShield;
        shielding = inFace.shielding;
        dotShield = inFace.dotShield;
        damageShield = inFace.damageShield;
        dsMitigation = inFace.dsMitigation;
        avoidance = inFace.avoidance;
        accuracy = inFace.accuracy;
        stunResist = inFace.stunResist;
        strikeThrough = inFace.strikeThrough;
        healAmount = inFace.healAmount;
        spellDamage = inFace.spellDamage;
        clairvoyance = inFace.clairvoyance;

        //Class Equipable Logic
        classAll = inFace.classAll;
        classMagician = inFace.classMagician;
        classCleric = inFace.classCleric;
        classBard = inFace.classBard;
        classShaman = inFace.classShaman;
        classDruid = inFace.classDruid;
        classRanger = inFace.classRanger;
        classMonk = inFace.classMonk;
        classEnchanter = inFace.classEnchanter;
        classNecromancer = inFace.classNecromancer;
        classRogue = inFace.classRogue;
        classWarrior = inFace.classWarrior;
        classBerserker = inFace.classBerserker;
        classShadowknight = inFace.classShadowknight;
        classWizard = inFace.classWizard;
        classPaladin = inFace.classPaladin;
        classBeastlord = inFace.classBeastlord;
    }
}
