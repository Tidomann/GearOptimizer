import java.util.Random;

public class Waist extends Equipment{
    int max = 10;

    public Waist(int randomWaist){
        if (randomWaist < 0 || randomWaist >= max){
            Random rand = new Random();
            randomWaist = rand.nextInt(max);
        }
        switch (randomWaist){
            case 0:
                name = "Black Belt";
                id = 0;
                classAll = true;
                bonusAC = 10;
                bonusHP = 30;
                bonusEnd = 55;
                haste = 20;
                strength = 15;
                heroicStrength = 1;
                stamina = 5;
                wisdom = 5;
                agility = 10;
                dexterity = 10;
                poisonRes = 15;
                attack = 1;
                endRegen = 1;
                accuracy = 1;
                hasAugment = true;
                break;
            case 1:
                name = "Decaying Waistguard";
                id = 1;
                classAll = true;
                bonusAC = 19;
                bonusHP = 70;
                bonusMana = 15;
                bonusEnd = 15;
                strength = 10;
                stamina = 15;
                agility = 15;
                heroicAgility = 1;
                dexterity = 15;
                heroicDexterity = 1;
                diseaseRes = 5;
                hasAugment = true;
                break;
            case 2:
                name = "Pit-Fighter's Belt";
                id = 2;
                classAll = true;
                bonusAC = 7;
                bonusHP = 40;
                bonusEnd = 50;
                strength = 17;
                heroicStrength = 2;
                stamina = 7;
                agility = 16;
                dexterity = 15;
                heroicDexterity = 2;
                attack = 3;
                endRegen = 3;
                accuracy = 2;
                strikeThrough = 1;
                healAmount = 1;
                spellDamage = 1;
                hasAugment = true;
                break;
            case 3:
                name = "Scaled Girdle";
                id = 3;
                classAll = true;
                bonusAC = 16;
                bonusHP = 50;
                bonusMana = 15;
                bonusEnd = 15;
                strength = 8;
                stamina = 13;
                agility = 13;
                dexterity = 9;
                magicRes = 10;
                diseaseRes = 10;
                spellShield = 2;
                dotShield = 2;
                damageShield = 1;
                hasAugment = true;
                break;
            case 4:
                name = "Silk Fur Sash";
                id = 4;
                classAll = true;
                bonusMana = 75;
                intelligence = 15;
                heroicIntelligence = 1;
                wisdom = 15;
                heroicWisdom = 1;
                charisma = 15;
                heroicCharisma = 1;
                manaRegen = 1;
                healAmount = 4;
                spellDamage = 4;
                clairvoyance = 2;
                skillEvocation = 5;
                hasAugment = true;
                hasAugmentWOS = true;
                break;
            case 5:
                name = "Tentacle Sash";
                id = 5;
                classAll = true;
                bonusAC = 14;
                bonusHP = 35;
                bonusEnd = 25;
                strength = 11;
                stamina = 11;
                agility = 11;
                dexterity = 11;
                attack = 1;
                manaRegen = 1;
                endRegen = 1;
                hasAugment = true;
                break;
            case 6:
                name = "Venom Soaked Sash";
                id = 6;
                classAll = true;
                bonusAC = 11;
                bonusHP = 14;
                bonusMana = 28;
                bonusEnd = 9;
                strength = 3;
                intelligence = 11;
                wisdom = 11;
                agility = 3;
                charisma = 5;
                poisonRes = 8;
                healAmount = 2;
                spellDamage = 2;
                hasAugment = true;
                break;
            case 7:
                name = "War-Torn Sash";
                id = 7;
                classAll = true;
                bonusAC = 9;
                bonusHP = 25;
                bonusMana = 60;
                strength = 10;
                stamina = 10;
                intelligence = 16;
                heroicIntelligence = 1;
                wisdom = 16;
                heroicWisdom = 1;
                charisma = 20;
                heroicCharisma = 1;
                diseaseRes = 5;
                healAmount = 4;
                spellDamage = 4;
                hasAugment = true;
                break;
            case 8:
                name = "Warrior Belt";
                id = 8;
                classAll = true;
                bonusAC = 8;
                bonusHP = 15;
                bonusEnd = 10;
                strength = 5;
                agility = 6;
                dexterity = 6;
                charisma = 3;
                attack = 1;
                damageShield = 1;
                hasAugment = true;
                break;
            case 9:
                name = "Metal Fur Girdle";
                id = 9;
                classAll = true;
                bonusAC = 19;
                bonusHP = 60;
                bonusMana = 15;
                bonusEnd = 35;
                stamina = 15;
                agility = 15;
                dexterity = 8;
                charisma = 12;
                damageShield = 2;
                avoidance = 1;
                hasAugment = true;
                hasAugmentWOS = true;
                break;

        }
    }

    public Waist(Waist inWaist){
        name = inWaist.name;
        id = inWaist.id;
        hasAugment = inWaist.hasAugment;
        if(hasAugment && inWaist.augment != null){
            augment = new Augment((Augment) inWaist.augment);
        }
        hasAugmentWOS = inWaist.hasAugmentWOS;
        if(hasAugmentWOS && inWaist.augmentWOS != null){
            augmentWOS = new Augment((Augment) inWaist.augmentWOS);
        }
        bonusAC = inWaist.bonusAC;
        bonusHP = inWaist.bonusHP;
        bonusMana = inWaist.bonusMana;
        bonusEnd = inWaist.bonusEnd;
        strength = inWaist.strength;
        stamina = inWaist.stamina;
        agility = inWaist.agility;
        dexterity = inWaist.dexterity;
        intelligence = inWaist.intelligence;
        wisdom = inWaist.wisdom;
        charisma = inWaist.charisma;
        heroicStrength = inWaist.strength;
        heroicStamina = inWaist.stamina;
        heroicAgility = inWaist.agility;
        heroicDexterity = inWaist.heroicDexterity;
        heroicIntelligence = inWaist.heroicIntelligence;
        heroicWisdom = inWaist.heroicWisdom;
        heroicCharisma = inWaist.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inWaist.magicRes;
        fireRes = inWaist.fireRes;
        coldRes = inWaist.coldRes;
        diseaseRes = inWaist.diseaseRes;
        poisonRes = inWaist.poisonRes;
        corruptionRes = inWaist.corruptionRes;

        //Equipment Special Data Fields
        attack = inWaist.attack;
        hpRegen = inWaist.hpRegen;
        manaRegen = inWaist.manaRegen;
        endRegen = inWaist.endRegen;
        spellShield = inWaist.spellShield;
        shielding = inWaist.shielding;
        dotShield = inWaist.dotShield;
        damageShield = inWaist.damageShield;
        dsMitigation = inWaist.dsMitigation;
        avoidance = inWaist.avoidance;
        accuracy = inWaist.accuracy;
        stunResist = inWaist.stunResist;
        strikeThrough = inWaist.strikeThrough;
        healAmount = inWaist.healAmount;
        spellDamage = inWaist.spellDamage;
        clairvoyance = inWaist.clairvoyance;

        //Class Equipable Logic
        classAll = inWaist.classAll;
        classMagician = inWaist.classMagician;
        classCleric = inWaist.classCleric;
        classBard = inWaist.classBard;
        classShaman = inWaist.classShaman;
        classDruid = inWaist.classDruid;
        classRanger = inWaist.classRanger;
        classMonk = inWaist.classMonk;
        classEnchanter = inWaist.classEnchanter;
        classNecromancer = inWaist.classNecromancer;
        classRogue = inWaist.classRogue;
        classWarrior = inWaist.classWarrior;
        classBerserker = inWaist.classBerserker;
        classShadowknight = inWaist.classShadowknight;
        classWizard = inWaist.classWizard;
        classPaladin = inWaist.classPaladin;
        classBeastlord = inWaist.classBeastlord;
    }
}
