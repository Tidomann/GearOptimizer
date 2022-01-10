import java.util.Random;

public class Hands extends Equipment{
    int max = 3;

    public Hands(int randomHands){
        if (randomHands < 0 || randomHands >= max){
            Random rand = new Random();
            randomHands = rand.nextInt(max);
        }
        switch (randomHands){
            case 0:
                name = "Fungloves";
                id = 0;
                classAll = true;
                bonusAC = 18;
                bonusHP = 38;
                bonusEnd = 38;
                strength = 13;
                stamina = 11;
                agility = 11;
                dexterity = 13;
                diseaseRes = 10;
                attack = 4;
                endRegen = 2;
                strikeThrough = 2;
                hasAugment = true;
                break;
            case 1:
                name = "Infinity Gauntlet";
                id = 1;
                classAll = true;
                bonusAC = 12;
                bonusHP = 50;
                bonusMana = 50;
                bonusEnd = 50;
                strength = 10;
                heroicStrength = 1;
                stamina = 10;
                heroicStamina = 1;
                intelligence = 15;
                heroicIntelligence = 1;
                wisdom = 15;
                heroicWisdom = 1;
                agility = 5;
                heroicAgility = 1;
                dexterity = 5;
                heroicDexterity = 1;
                charisma = 15;
                heroicCharisma = 1;
                poisonRes = 15;
                attack = 3;
                manaRegen = 1;
                spellShield = 3;
                healAmount = 3;
                spellDamage = 3;
                hasAugment = true;
                break;
            case 2:
                name = "Poxxed Gloves";
                id = 2;
                classAll = true;
                bonusAC = 13;
                bonusHP = 10;
                bonusEnd = 20;
                haste = 10;
                strength = 10;
                stamina = 8;
                agility = 4;
                dexterity = 10;
                poisonRes = 10;
                accuracy = 1;
                hasAugment = true;
                break;
            case 3:
                name = "Firekeeper's Gloves";
                id = 3;
                classAll = true;
                bonusAC = 10;
                bonusHP = 20;
                bonusMana = 70;
                bonusEnd = 15;
                strength = 5;
                stamina = 5;
                intelligence = 17;
                heroicIntelligence = 1;
                wisdom = 17;
                charisma = 14;
                heroicCharisma = 1;
                magicRes = 10;
                manaRegen = 1;
                spellDamage = 4;
                healAmount = 3;
                hasAugment = true;
                break;
        }
    }

    public Hands(Hands inHands){
        name = inHands.name;
        id = inHands.id;
        hasAugment = inHands.hasAugment;
        if(hasAugment && inHands.augment != null){
            augment = new Augment((Augment) inHands.augment);
        }
        hasAugmentWOS = inHands.hasAugmentWOS;
        if(hasAugmentWOS && inHands.augmentWOS != null){
            augmentWOS = new Augment((Augment) inHands.augmentWOS);
        }
        bonusAC = inHands.bonusAC;
        bonusHP = inHands.bonusHP;
        bonusMana = inHands.bonusMana;
        bonusEnd = inHands.bonusEnd;
        strength = inHands.strength;
        stamina = inHands.stamina;
        agility = inHands.agility;
        dexterity = inHands.dexterity;
        intelligence = inHands.intelligence;
        wisdom = inHands.wisdom;
        charisma = inHands.charisma;
        heroicStrength = inHands.strength;
        heroicStamina = inHands.stamina;
        heroicAgility = inHands.agility;
        heroicDexterity = inHands.heroicDexterity;
        heroicIntelligence = inHands.heroicIntelligence;
        heroicWisdom = inHands.heroicWisdom;
        heroicCharisma = inHands.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inHands.magicRes;
        fireRes = inHands.fireRes;
        coldRes = inHands.coldRes;
        diseaseRes = inHands.diseaseRes;
        poisonRes = inHands.poisonRes;
        corruptionRes = inHands.corruptionRes;

        //Equipment Special Data Fields
        attack = inHands.attack;
        hpRegen = inHands.hpRegen;
        manaRegen = inHands.manaRegen;
        endRegen = inHands.endRegen;
        spellShield = inHands.spellShield;
        shielding = inHands.shielding;
        dotShield = inHands.dotShield;
        damageShield = inHands.damageShield;
        dsMitigation = inHands.dsMitigation;
        avoidance = inHands.avoidance;
        accuracy = inHands.accuracy;
        stunResist = inHands.stunResist;
        strikeThrough = inHands.strikeThrough;
        healAmount = inHands.healAmount;
        spellDamage = inHands.spellDamage;
        clairvoyance = inHands.clairvoyance;

        //Class Equipable Logic
        classAll = inHands.classAll;
        classMagician = inHands.classMagician;
        classCleric = inHands.classCleric;
        classBard = inHands.classBard;
        classShaman = inHands.classShaman;
        classDruid = inHands.classDruid;
        classRanger = inHands.classRanger;
        classMonk = inHands.classMonk;
        classEnchanter = inHands.classEnchanter;
        classNecromancer = inHands.classNecromancer;
        classRogue = inHands.classRogue;
        classWarrior = inHands.classWarrior;
        classBerserker = inHands.classBerserker;
        classShadowknight = inHands.classShadowknight;
        classWizard = inHands.classWizard;
        classPaladin = inHands.classPaladin;
        classBeastlord = inHands.classBeastlord;
    }
}
