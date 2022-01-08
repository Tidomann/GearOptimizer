import java.util.Random;

public class Primary extends Equipment{
    int max = 1;

    public Primary(int randomPrimary){
        /*
        if (randomPrimary < 0 || randomPrimary >= max){
            Random rand = new Random();
            randomPrimary = rand.nextInt(max);
        }
        switch (randomPrimary){
            case 0:
                name = "Fabled Green Leggings";
                id = 0;
                classAll = true;
                hasAugment = true;
                break;
            case 2:
                name = "Green Leggins";
                id = 2;
                classAll = true;
                break;
            case 3:
                name = "Kingly Legplates";
                id = 3;
                classAll = true;
                bonusAC = 17;
                bonusHP = 10;
                bonusMana = 6;
                bonusEnd = 13;
                strength = 5;
                stamina = 4;
                wisdom = 4;
                dexterity = 3;
                accuracy = 1;
                spellDamage = 1;
                hasAugment = true;
                break;
            case 4:
                name = "Legplates 5000";
                id = 4;
                classAll = true;
                bonusAC = 14;
                bonusHP = 35;
                bonusEnd = 10;
                strength = 3;
                stamina = 13;
                dexterity = 3;
                shielding = 2;
                hasAugment = true;
                break;
            case 5:
                name = "Slimey Pantaloons";
                id = 5;
                classAll = true;
                bonusAC = 14;
                bonusMana = 30;
                bonusEnd = 40;
                strength = 13;
                stamina = 6;
                intelligence = 9;
                wisdom = 9;
                agility = 8;
                dexterity = 13;
                charisma = 9;
                diseaseRes = 10;
                attack = 3;
                manaRegen = 1;
                spellDamage = 2;
                hasAugment = true;
                break;
        }
         */
        name = "Sword of the Earth Warden";
        id = 0;
        classRanger = true;
        bonusHP = 25;
        bonusMana = 50;
        bonusEnd = 50;
        heroicDexterity = 10;
        magicRes = 5;
        fireRes = 5;
        coldRes = 5;
        diseaseRes = 5;
        poisonRes = 5;
        attack = 10;
        accuracy = 10;
        hasAugment = false; // will always be venom for spells
        hasAugmentWOS = true;
        augmentWOS = new Augment(false, false);
        augmentWOS.name = "Pigman's Shard of Aggression";
        augmentWOS.strength = 4;
        augmentWOS.heroicStrength = 1;
        augmentWOS.dexterity = 4;
        augmentWOS.heroicDexterity = 1;
        augmentWOS.attack = 1;
    }

    public Primary(Primary inPrimary){
        name = inPrimary.name;
        id = inPrimary.id;
        hasAugment = inPrimary.hasAugment;
        augment = inPrimary.augment;
        hasAugmentWOS = inPrimary.hasAugmentWOS;
        augmentWOS = inPrimary.augmentWOS;
        bonusAC = inPrimary.bonusAC;
        bonusHP = inPrimary.bonusHP;
        bonusMana = inPrimary.bonusMana;
        bonusEnd = inPrimary.bonusEnd;
        strength = inPrimary.strength;
        stamina = inPrimary.stamina;
        agility = inPrimary.agility;
        dexterity = inPrimary.dexterity;
        intelligence = inPrimary.intelligence;
        wisdom = inPrimary.wisdom;
        charisma = inPrimary.charisma;
        heroicStrength = inPrimary.strength;
        heroicStamina = inPrimary.stamina;
        heroicAgility = inPrimary.agility;
        heroicDexterity = inPrimary.heroicDexterity;
        heroicIntelligence = inPrimary.heroicIntelligence;
        heroicWisdom = inPrimary.heroicWisdom;
        heroicCharisma = inPrimary.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inPrimary.magicRes;
        fireRes = inPrimary.fireRes;
        coldRes = inPrimary.coldRes;
        diseaseRes = inPrimary.diseaseRes;
        poisonRes = inPrimary.poisonRes;
        corruptionRes = inPrimary.corruptionRes;

        //Equipment Special Data Fields
        attack = inPrimary.attack;
        hpRegen = inPrimary.hpRegen;
        manaRegen = inPrimary.manaRegen;
        endRegen = inPrimary.endRegen;
        spellShield = inPrimary.spellShield;
        shielding = inPrimary.shielding;
        dotShield = inPrimary.dotShield;
        damageShield = inPrimary.damageShield;
        dsMitigation = inPrimary.dsMitigation;
        avoidance = inPrimary.avoidance;
        accuracy = inPrimary.accuracy;
        stunResist = inPrimary.stunResist;
        strikeThrough = inPrimary.strikeThrough;
        healAmount = inPrimary.healAmount;
        spellDamage = inPrimary.spellDamage;
        clairvoyance = inPrimary.clairvoyance;

        //Class Equipable Logic
        classAll = inPrimary.classAll;
        classMagician = inPrimary.classMagician;
        classCleric = inPrimary.classCleric;
        classBard = inPrimary.classBard;
        classShaman = inPrimary.classShaman;
        classDruid = inPrimary.classDruid;
        classRanger = inPrimary.classRanger;
        classMonk = inPrimary.classMonk;
        classEnchanter = inPrimary.classEnchanter;
        classNecromancer = inPrimary.classNecromancer;
        classRogue = inPrimary.classRogue;
        classWarrior = inPrimary.classWarrior;
        classBerserker = inPrimary.classBerserker;
        classShadowknight = inPrimary.classShadowknight;
        classWizard = inPrimary.classWizard;
        classPaladin = inPrimary.classPaladin;
        classBeastlord = inPrimary.classBeastlord;
    }
}
