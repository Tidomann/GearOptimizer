import java.util.Random;

public class Back extends Equipment{
    int max = 9;

    public Back(int randomBack){
        if (randomBack < 0 || randomBack >= max){
            Random rand = new Random();
            randomBack = rand.nextInt(max);
        }
        switch (randomBack){
            case 0:
                name = "Bat Cloak";
                id = 0;
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
            case 1:
                name = "Cloak of Extermination";
                id = 1;
                classAll = true;
                bonusAC = 15;
                bonusHP = 40;
                bonusEnd = 65;
                haste = 25;
                strength = 17;
                heroicStrength = 1;
                stamina = 9;
                intelligence = 7;
                wisdom = 7;
                agility = 8;
                dexterity = 15;
                heroicDexterity = 1;
                magicRes = 10;
                attack = 4;
                endRegen = 1;
                strikeThrough = 2;
                healAmount = 1;
                spellDamage = 2;
                hasAugment = true;
                break;
            case 2:
                name = "Mayor's Cloak";
                id = 2;
                classAll = true;
                bonusAC = 9;
                bonusHP = 25;
                bonusMana = 20;
                bonusEnd = 20;
                strength = 9;
                stamina = 9;
                intelligence = 7;
                wisdom = 7;
                poisonRes = 6;
                attack = 1;
                spellDamage = 1;
                hasAugment = true;
                break;
            case 3:
                name = "Pigskin Cloak";
                id = 3;
                classAll = true;
                bonusAC = 15;
                bonusHP = 55;
                bonusMana = 15;
                bonusEnd = 15;
                strength = 15;
                stamina = 14;
                wisdom = 8;
                agility = 13;
                dexterity = 6;
                spellDamage = 2;
                damageShield = 3;
                healAmount = 2;
                hasAugment = true;
                hasAugmentWOS = true;
                break;
            case 4:
                name = "Shiliskin Slick Cloak";
                id = 4;
                classAll = true;
                bonusAC = 2;
                bonusHP = 7;
                bonusMana = 15;
                bonusEnd = 5;
                intelligence = 5;
                wisdom = 5;
                charisma = 5;
                skillChanneling = 4;
                hasAugment = true;
                break;
            case 5:
                name = "Shrouded Cloak";
                id = 5;
                classAll = true;
                bonusAC = 5;
                bonusHP = 10;
                bonusMana = 5;
                bonusEnd = 15;
                strength = 6;
                agility = 3;
                attack = 2;
                endRegen = 1;
                hasAugment = true;
                break;
            case 6:
                name = "Snake Skin Cloak";
                id = 6;
                classAll = true;
                bonusAC = 1;
                strength = 9;
                stamina = 6;
                wisdom = 9;
                agility = 4;
                healAmount = 3;
                hasAugment = true;
                break;
            case 7:
                name = "Stinky Cloak";
                id = 7;
                classAll = true;
                bonusAC = 14;
                bonusHP = 35;
                bonusMana = 15;
                bonusEnd = 15;
                strength = 7;
                stamina = 9;
                intelligence = 5;
                wisdom = 5;
                agility = 11;
                dexterity = 7;
                hpRegen = 1;
                shielding = 1;
                hasAugment = true;
                break;
            case 8:
                name = "Soft Fur Cloak";
                id = 8;
                classAll = true;
                bonusAC = 11;
                bonusHP = 25;
                bonusMana = 55;
                bonusEnd = 25;
                strength = 12;
                intelligence = 14;
                wisdom = 14;
                agility = 11;
                charisma = 14;
                healAmount = 2;
                spellDamage = 2;
                clairvoyance = 1;
                hasAugment = true;
                hasAugmentWOS = true;
                break;
        }
    }

    public Back(Back inBack){
        name = inBack.name;
        id = inBack.id;
        hasAugment = inBack.hasAugment;
        if(hasAugment && inBack.augment != null){
            augment = new Augment((Augment) inBack.augment);
        }
        hasAugmentWOS = inBack.hasAugmentWOS;
        if(hasAugmentWOS && inBack.augmentWOS != null){
            augmentWOS = new Augment((Augment) inBack.augmentWOS);
        }
        bonusAC = inBack.bonusAC;
        bonusHP = inBack.bonusHP;
        bonusMana = inBack.bonusMana;
        bonusEnd = inBack.bonusEnd;
        strength = inBack.strength;
        stamina = inBack.stamina;
        agility = inBack.agility;
        dexterity = inBack.dexterity;
        intelligence = inBack.intelligence;
        wisdom = inBack.wisdom;
        charisma = inBack.charisma;
        heroicStrength = inBack.strength;
        heroicStamina = inBack.stamina;
        heroicAgility = inBack.agility;
        heroicDexterity = inBack.heroicDexterity;
        heroicIntelligence = inBack.heroicIntelligence;
        heroicWisdom = inBack.heroicWisdom;
        heroicCharisma = inBack.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inBack.magicRes;
        fireRes = inBack.fireRes;
        coldRes = inBack.coldRes;
        diseaseRes = inBack.diseaseRes;
        poisonRes = inBack.poisonRes;
        corruptionRes = inBack.corruptionRes;

        //Equipment Special Data Fields
        attack = inBack.attack;
        hpRegen = inBack.hpRegen;
        manaRegen = inBack.manaRegen;
        endRegen = inBack.endRegen;
        spellShield = inBack.spellShield;
        shielding = inBack.shielding;
        dotShield = inBack.dotShield;
        damageShield = inBack.damageShield;
        dsMitigation = inBack.dsMitigation;
        avoidance = inBack.avoidance;
        accuracy = inBack.accuracy;
        stunResist = inBack.stunResist;
        strikeThrough = inBack.strikeThrough;
        healAmount = inBack.healAmount;
        spellDamage = inBack.spellDamage;
        clairvoyance = inBack.clairvoyance;

        //Class Equipable Logic
        classAll = inBack.classAll;
        classMagician = inBack.classMagician;
        classCleric = inBack.classCleric;
        classBard = inBack.classBard;
        classShaman = inBack.classShaman;
        classDruid = inBack.classDruid;
        classRanger = inBack.classRanger;
        classMonk = inBack.classMonk;
        classEnchanter = inBack.classEnchanter;
        classNecromancer = inBack.classNecromancer;
        classRogue = inBack.classRogue;
        classWarrior = inBack.classWarrior;
        classBerserker = inBack.classBerserker;
        classShadowknight = inBack.classShadowknight;
        classWizard = inBack.classWizard;
        classPaladin = inBack.classPaladin;
        classBeastlord = inBack.classBeastlord;
    }
}
