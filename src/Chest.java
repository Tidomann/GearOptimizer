import java.util.Random;

public class Chest extends Equipment{
    int max = 10;

    public Chest(int randomChest){
        if (randomChest < 0 || randomChest >= max){
            Random rand = new Random();
            randomChest = rand.nextInt(max);
        }
        switch (randomChest){
            case 0:
                name = "Alligator Scaled Coat";
                id = 0;
                classAll = true;
                bonusAC = 18;
                bonusHP = 10;
                bonusMana = 10;
                bonusEnd = 15;
                strength = 5;
                intelligence = 6;
                agility = 5;
                attack = 5;
                spellShield = 1;
                shielding = 1;
                spellDamage = 2;
                hasAugment = true;
                break;
            case 1:
                name = "Animal Hide Jerkin";
                id = 1;
                classAll = true;
                bonusAC = 5;
                bonusHP = 15;
                bonusMana = 5;
                bonusEnd = 5;
                strength = 4;
                stamina = 5;
                agility = 6;
                spellDamage = 2;
                hasAugment = true;
                break;
            case 2:
                name = "Crystalline Chitin Chestgaurd";
                id = 2;
                classAll = true;
                bonusAC = 25;
                bonusHP = 20;
                bonusMana = 20;
                bonusEnd = 20;
                stamina = 10;
                wisdom = 10;
                agility = 7;
                charisma = 7;
                hasAugment = true;
                break;
            case 3:
                name = "Green Scaled Jerkin";
                id = 3;
                classAll = true;
                bonusAC = 23;
                bonusHP = 25;
                bonusMana = 10;
                bonusEnd = 15;
                strength = 6;
                stamina = 7;
                agility = 7;
                dexterity = 5;
                poisonRes = 10;
                shielding = 1;
                damageShield = 3;
                hasAugment = true;
                break;
            case 4:
                name = "The Fabled Green Scaled Jerkin";
                id = 4;
                classAll = true;
                bonusAC = 35;
                bonusHP = 55;
                bonusMana = 25;
                bonusEnd = 25;
                strength = 16;
                stamina = 18;
                agility = 16;
                dexterity = 15;
                poisonRes = 25;
                shielding = 2;
                damageShield = 6;
                hasAugment = true;
                break;
            case 5:
                name = "Grub Protector";
                id = 5;
                classAll = true;
                bonusAC = 28;
                bonusHP = 25;
                bonusMana = 25;
                bonusEnd = 55;
                strength = 13;
                stamina = 7;
                intelligence = 9;
                wisdom = 9;
                dexterity = 13;
                diseaseRes = 10;
                endRegen = 2;
                accuracy = 5;
                hasAugment = true;
                break;
            case 6:
                name = "Mythical Chestplate";
                id = 6;
                classAll = true;
                bonusAC = 30;
                bonusHP = 35;
                bonusMana = 20;
                bonusEnd = 20;
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
                hpRegen = 2;
                hasAugment = true;
                break;
            case 7:
                name = "Mythical Jerkin";
                id = 7;
                classAll = true;
                bonusAC = 20;
                bonusHP = 20;
                bonusMana = 20;
                bonusEnd = 35;
                haste = 14;
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
                attack = 3;
                endRegen = 2;
                accuracy = 3;
                hasAugment = true;
                break;
            case 8:
                name = "Mythical Robe";
                id = 8;
                classAll = true;
                bonusAC = 15;
                bonusHP = 20;
                bonusMana = 35;
                bonusEnd = 20;
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
                manaRegen = 2;
                healAmount = 3;
                spellDamage = 3;
                hasAugment = true;
                break;
            case 9:
                name = "Red Scaled Jerkin";
                id = 9;
                classAll = true;
                bonusAC = 19;
                bonusHP = 15;
                bonusMana = 20;
                bonusEnd = 5;
                strength = 4;
                stamina = 5;
                intelligence = 5;
                wisdom = 5;
                agility = 6;
                charisma = 2;
                fireRes = 10;
                spellDamage = 4;
                hasAugment = true;
                break;
        }
    }

    public Chest(Chest inChest){
        name = inChest.name;
        id = inChest.id;
        hasAugment = inChest.hasAugment;
        if(hasAugment && inChest.augment != null){
            augment = new Augment((Augment) inChest.augment);
        }
        hasAugmentWOS = inChest.hasAugmentWOS;
        if(hasAugmentWOS && inChest.augmentWOS != null){
            augmentWOS = new Augment((Augment) inChest.augmentWOS);
        }
        bonusAC = inChest.bonusAC;
        bonusHP = inChest.bonusHP;
        bonusMana = inChest.bonusMana;
        bonusEnd = inChest.bonusEnd;
        strength = inChest.strength;
        stamina = inChest.stamina;
        agility = inChest.agility;
        dexterity = inChest.dexterity;
        intelligence = inChest.intelligence;
        wisdom = inChest.wisdom;
        charisma = inChest.charisma;
        heroicStrength = inChest.strength;
        heroicStamina = inChest.stamina;
        heroicAgility = inChest.agility;
        heroicDexterity = inChest.heroicDexterity;
        heroicIntelligence = inChest.heroicIntelligence;
        heroicWisdom = inChest.heroicWisdom;
        heroicCharisma = inChest.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inChest.magicRes;
        fireRes = inChest.fireRes;
        coldRes = inChest.coldRes;
        diseaseRes = inChest.diseaseRes;
        poisonRes = inChest.poisonRes;
        corruptionRes = inChest.corruptionRes;

        //Equipment Special Data Fields
        attack = inChest.attack;
        hpRegen = inChest.hpRegen;
        manaRegen = inChest.manaRegen;
        endRegen = inChest.endRegen;
        spellShield = inChest.spellShield;
        shielding = inChest.shielding;
        dotShield = inChest.dotShield;
        damageShield = inChest.damageShield;
        dsMitigation = inChest.dsMitigation;
        avoidance = inChest.avoidance;
        accuracy = inChest.accuracy;
        stunResist = inChest.stunResist;
        strikeThrough = inChest.strikeThrough;
        healAmount = inChest.healAmount;
        spellDamage = inChest.spellDamage;
        clairvoyance = inChest.clairvoyance;

        //Class Equipable Logic
        classAll = inChest.classAll;
        classMagician = inChest.classMagician;
        classCleric = inChest.classCleric;
        classBard = inChest.classBard;
        classShaman = inChest.classShaman;
        classDruid = inChest.classDruid;
        classRanger = inChest.classRanger;
        classMonk = inChest.classMonk;
        classEnchanter = inChest.classEnchanter;
        classNecromancer = inChest.classNecromancer;
        classRogue = inChest.classRogue;
        classWarrior = inChest.classWarrior;
        classBerserker = inChest.classBerserker;
        classShadowknight = inChest.classShadowknight;
        classWizard = inChest.classWizard;
        classPaladin = inChest.classPaladin;
        classBeastlord = inChest.classBeastlord;
    }
}
