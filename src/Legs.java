import java.util.Random;

public class Legs extends Equipment{
    int max = 6;

    public Legs(int randomLegs){
        if (randomLegs < 0 || randomLegs >= max){
            Random rand = new Random();
            randomLegs = rand.nextInt(max);
        }
        switch (randomLegs){
            case 0:
                name = "Fabled Green Leggings";
                id = 0;
                classAll = true;
                bonusAC = 19;
                bonusHP = 25;
                bonusMana = 60;
                strength = 16;
                stamina = 16;
                wisdom = 18;
                charisma = 9;
                healAmount = 3;
                skillChanneling = 15;
                hasAugment = true;
                break;
            case 1:
                name = "Feathered Leggings";
                id = 1;
                classAll = true;
                bonusAC = 4;
                stamina = 7;
                intelligence = 3;
                charisma = 3;
                spellDamage = 1;
                hasAugment = true;
                break;
            case 2:
                name = "Green Leggins";
                id = 2;
                classAll = true;
                bonusAC = 13;
                bonusHP = 10;
                bonusMana = 25;
                strength = 10;
                stamina = 10;
                wisdom = 12;
                charisma = 3;
                healAmount = 1;
                skillChanneling = 10;
                hasAugment = true;
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
    }

    public Legs(Legs inLegs){
        name = inLegs.name;
        id = inLegs.id;
        hasAugment = inLegs.hasAugment;
        if(hasAugment && inLegs.augment != null){
            augment = new Augment((Augment) inLegs.augment);
        }
        hasAugmentWOS = inLegs.hasAugmentWOS;
        if(hasAugmentWOS && inLegs.augmentWOS != null){
            augmentWOS = new Augment((Augment) inLegs.augmentWOS);
        }
        bonusAC = inLegs.bonusAC;
        bonusHP = inLegs.bonusHP;
        bonusMana = inLegs.bonusMana;
        bonusEnd = inLegs.bonusEnd;
        strength = inLegs.strength;
        stamina = inLegs.stamina;
        agility = inLegs.agility;
        dexterity = inLegs.dexterity;
        intelligence = inLegs.intelligence;
        wisdom = inLegs.wisdom;
        charisma = inLegs.charisma;
        heroicStrength = inLegs.strength;
        heroicStamina = inLegs.stamina;
        heroicAgility = inLegs.agility;
        heroicDexterity = inLegs.heroicDexterity;
        heroicIntelligence = inLegs.heroicIntelligence;
        heroicWisdom = inLegs.heroicWisdom;
        heroicCharisma = inLegs.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inLegs.magicRes;
        fireRes = inLegs.fireRes;
        coldRes = inLegs.coldRes;
        diseaseRes = inLegs.diseaseRes;
        poisonRes = inLegs.poisonRes;
        corruptionRes = inLegs.corruptionRes;

        //Equipment Special Data Fields
        attack = inLegs.attack;
        hpRegen = inLegs.hpRegen;
        manaRegen = inLegs.manaRegen;
        endRegen = inLegs.endRegen;
        spellShield = inLegs.spellShield;
        shielding = inLegs.shielding;
        dotShield = inLegs.dotShield;
        damageShield = inLegs.damageShield;
        dsMitigation = inLegs.dsMitigation;
        avoidance = inLegs.avoidance;
        accuracy = inLegs.accuracy;
        stunResist = inLegs.stunResist;
        strikeThrough = inLegs.strikeThrough;
        healAmount = inLegs.healAmount;
        spellDamage = inLegs.spellDamage;
        clairvoyance = inLegs.clairvoyance;

        //Class Equipable Logic
        classAll = inLegs.classAll;
        classMagician = inLegs.classMagician;
        classCleric = inLegs.classCleric;
        classBard = inLegs.classBard;
        classShaman = inLegs.classShaman;
        classDruid = inLegs.classDruid;
        classRanger = inLegs.classRanger;
        classMonk = inLegs.classMonk;
        classEnchanter = inLegs.classEnchanter;
        classNecromancer = inLegs.classNecromancer;
        classRogue = inLegs.classRogue;
        classWarrior = inLegs.classWarrior;
        classBerserker = inLegs.classBerserker;
        classShadowknight = inLegs.classShadowknight;
        classWizard = inLegs.classWizard;
        classPaladin = inLegs.classPaladin;
        classBeastlord = inLegs.classBeastlord;
    }
}
