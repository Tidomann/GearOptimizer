import java.util.Random;

public class Neck extends Equipment{
    int max = 11;

    public Neck(int randomNeck){
        if (randomNeck < 0 || randomNeck >= max){
            Random rand = new Random();
            randomNeck = rand.nextInt(max);
        }
        switch (randomNeck){
            case 0:
                name = "Class A Necklace";
                id = 0;
                classAll = true;
                bonusAC = 5;
                bonusHP = 20;
                bonusMana = 10;
                bonusEnd = 10;
                strength = 1;
                stamina = 3;
                agility = 3;
                dexterity = 1;
                magicRes = 5;
                fireRes = 5;
                coldRes = 5;
                diseaseRes = 5;
                poisonRes = 5;
                hasAugment = true;
                break;
            case 1:
                name = "Class B Necklace";
                id = 1;
                classAll = true;
                bonusAC = 1;
                bonusHP = 10;
                bonusMana = 10;
                bonusEnd = 20;
                strength = 3;
                stamina = 1;
                intelligence = 1;
                wisdom = 1;
                agility = 1;
                dexterity = 3;
                charisma = 1;
                magicRes = 15;
                fireRes = 15;
                attack = 5;
                hasAugment = true;
                break;
            case 2:
                name = "Class C Necklace";
                id = 2;
                classAll = true;
                bonusHP = 5;
                bonusMana = 20;
                bonusEnd = 5;
                intelligence = 3;
                wisdom = 3;
                charisma = 3;
                hasAugment = true;
                break;
            case 3:
                name = "Dog collar";
                id = 3;
                classAll = true;
                bonusAC = 9;
                bonusHP = 10;
                bonusMana = 35;
                bonusEnd = 35;
                strength = 12;
                stamina = 8;
                intelligence = 12;
                wisdom = 12;
                dexterity = 9;
                charisma = 9;
                attack = 2;
                healAmount = 2;
                spellDamage = 2;
                hasAugment = true;
                break;
            case 4:
                name = "Lightsilver Necklace";
                id = 4;
                classAll = true;
                wisdom = 14;
                manaRegen = 2;
                healAmount = 2;
                hasAugment = true;
                break;
            case 5:
                name = "Necklace of the Softpaw";
                id = 5;
                classAll = true;
                bonusAC = 8;
                bonusHP = 30;
                bonusMana = 30;
                bonusEnd = 30;
                strength = 10;
                stamina = 10;
                intelligence = 10;
                wisdom = 10;
                agility = 10;
                dexterity = 10;
                charisma = 10;
                magicRes = 10;
                fireRes = 10;
                coldRes = 10;
                diseaseRes = 10;
                poisonRes = 10;
                attack = 2;
                hpRegen = 1;
                manaRegen = 1;
                endRegen = 1;
                strikeThrough = 2;
                healAmount = 2;
                spellDamage = 2;
                hasAugment = true;
                break;
            case 6:
                name = "Pearl Necklace";
                id = 6;
                classAll = true;
                bonusMana = 25;
                intelligence = 5;
                wisdom = 5;
                charisma = 6;
                manaRegen = 1;
                hasAugment = true;
                break;
            case 7:
                name = "Sludge Choker";
                id = 7;
                classAll = true;
                bonusAC = 14;
                bonusHP = 35;
                bonusEnd = 35;
                strength = 8;
                stamina = 13;
                agility = 11;
                dexterity = 13;
                diseaseRes = 10;
                attack = 2;
                spellShield = 1;
                avoidance = 1;
                spellDamage = 2;
                hasAugment = true;
                break;
            case 8:
                name = "Sparkly Seasilver Necklace";
                id = 8;
                classAll = true;
                bonusHP = 30;
                bonusMana = 30;
                bonusEnd = 30;
                strength = 11;
                stamina = 11;
                intelligence = 11;
                wisdom = 11;
                agility = 11;
                dexterity = 11;
                charisma = 11;
                attack = 2;
                hpRegen = 1;
                manaRegen = 1;
                endRegen = 1;
                spellDamage = 2;
                hasAugment = true;
                break;
            case 9:
                name = "Sunken Necklace";
                id = 9;
                classAll = true;
                bonusAC = 8;
                bonusHP = 25;
                bonusEnd = 10;
                strength = 6;
                stamina = 6;
                agility = 7;
                dexterity = 5;
                hpRegen = 1;
                shielding = 1;
                avoidance = 1;
                hasAugment = true;
                break;
            case 10:
                name = "Tri-Gemmed Necklace";
                id = 10;
                classAll = true;
                bonusAC = 10;
                bonusHP = 25;
                bonusMana = 25;
                bonusEnd = 25;
                strength = 5;
                stamina = 5;
                intelligence = 5;
                wisdom = 5;
                agility = 5;
                dexterity = 5;
                charisma = 5;
                magicRes = 5;
                fireRes = 5;
                coldRes = 5;
                diseaseRes = 5;
                poisonRes = 5;
                attack = 1;
                hpRegen = 1;
                manaRegen = 1;
                endRegen = 1;
                healAmount = 1;
                spellDamage = 1;
                hasAugment = true;
                break;
        }
    }

    public Neck(Neck inNeck){
        name = inNeck.name;
        id = inNeck.id;
        hasAugment = inNeck.hasAugment;
        if(hasAugment && inNeck.augment != null){
            augment = new Augment((Augment) inNeck.augment);
        }
        hasAugmentWOS = inNeck.hasAugmentWOS;
        if(hasAugmentWOS && inNeck.augmentWOS != null){
            augmentWOS = new Augment((Augment) inNeck.augmentWOS);
        }
        bonusAC = inNeck.bonusAC;
        bonusHP = inNeck.bonusHP;
        bonusMana = inNeck.bonusMana;
        bonusEnd = inNeck.bonusEnd;
        strength = inNeck.strength;
        stamina = inNeck.stamina;
        agility = inNeck.agility;
        dexterity = inNeck.dexterity;
        intelligence = inNeck.intelligence;
        wisdom = inNeck.wisdom;
        charisma = inNeck.charisma;
        heroicStrength = inNeck.strength;
        heroicStamina = inNeck.stamina;
        heroicAgility = inNeck.agility;
        heroicDexterity = inNeck.heroicDexterity;
        heroicIntelligence = inNeck.heroicIntelligence;
        heroicWisdom = inNeck.heroicWisdom;
        heroicCharisma = inNeck.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inNeck.magicRes;
        fireRes = inNeck.fireRes;
        coldRes = inNeck.coldRes;
        diseaseRes = inNeck.diseaseRes;
        poisonRes = inNeck.poisonRes;
        corruptionRes = inNeck.corruptionRes;

        //Equipment Special Data Fields
        attack = inNeck.attack;
        hpRegen = inNeck.hpRegen;
        manaRegen = inNeck.manaRegen;
        endRegen = inNeck.endRegen;
        spellShield = inNeck.spellShield;
        shielding = inNeck.shielding;
        dotShield = inNeck.dotShield;
        damageShield = inNeck.damageShield;
        dsMitigation = inNeck.dsMitigation;
        avoidance = inNeck.avoidance;
        accuracy = inNeck.accuracy;
        stunResist = inNeck.stunResist;
        strikeThrough = inNeck.strikeThrough;
        healAmount = inNeck.healAmount;
        spellDamage = inNeck.spellDamage;
        clairvoyance = inNeck.clairvoyance;

        //Class Equipable Logic
        classAll = inNeck.classAll;
        classMagician = inNeck.classMagician;
        classCleric = inNeck.classCleric;
        classBard = inNeck.classBard;
        classShaman = inNeck.classShaman;
        classDruid = inNeck.classDruid;
        classRanger = inNeck.classRanger;
        classMonk = inNeck.classMonk;
        classEnchanter = inNeck.classEnchanter;
        classNecromancer = inNeck.classNecromancer;
        classRogue = inNeck.classRogue;
        classWarrior = inNeck.classWarrior;
        classBerserker = inNeck.classBerserker;
        classShadowknight = inNeck.classShadowknight;
        classWizard = inNeck.classWizard;
        classPaladin = inNeck.classPaladin;
        classBeastlord = inNeck.classBeastlord;
    }
}
