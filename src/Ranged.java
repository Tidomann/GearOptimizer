public class Ranged extends Equipment{
    int max = 1;

    public Ranged(int randomRanged){
        /*
        if (randomRanged < 0 || randomRanged >= max){
            Random rand = new Random();
            randomRanged = rand.nextInt(max);
        }
        switch (randomRanged){
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
                hasAugment = true;
                break;
            case 3:
                name = "Kingly Legplates";
                id = 3;
                classAll = true;
                hasAugment = true;
                break;
            case 4:
                name = "Legplates 5000";
                id = 4;
                classAll = true;
                hasAugment = true;
                break;
            case 5:
                name = "Slimey Pantaloons";
                id = 5;
                classAll = true;
                hasAugment = true;
                break;
        }
         */
        name = "Rapidfire";
        id = 0;
        classRogue = true;
        classShadowknight = true;
        classRanger = true;
        classPaladin = true;
        classWarrior = true;
        bonusHP = 40;
        bonusEnd = 50;
        strength = 14;
        dexterity = 14;
        heroicDexterity = 1;
        diseaseRes = 10;
        attack = 3;
        hasAugment = true;
        augment = new Augment(false, false);
        augment.name = "Overlord's Aggression";
        augment.heroicStrength = 1;
        augment.heroicStamina = 1;
        augment.heroicIntelligence = 1;
        augment.heroicWisdom = 1;
        augment.heroicAgility = 1;
        augment.heroicDexterity = 1;
        augment.heroicCharisma = 1;
        augment.poisonRes = 5;
        augment.attack = 2;
        augment.avoidance = 2;
        augment.spellDamage = 2;
        augment.healAmount = 2;
    }

    public Ranged(Ranged inSecondary){
        name = inSecondary.name;
        id = inSecondary.id;
        hasAugment = inSecondary.hasAugment;
        if(hasAugment && inSecondary.augment != null){
            augment = new Augment((Augment) inSecondary.augment);
        }
        hasAugmentWOS = inSecondary.hasAugmentWOS;
        if(hasAugmentWOS && inSecondary.augmentWOS != null){
            augmentWOS = new Augment((Augment) inSecondary.augmentWOS);
        }
        bonusAC = inSecondary.bonusAC;
        bonusHP = inSecondary.bonusHP;
        bonusMana = inSecondary.bonusMana;
        bonusEnd = inSecondary.bonusEnd;
        strength = inSecondary.strength;
        stamina = inSecondary.stamina;
        agility = inSecondary.agility;
        dexterity = inSecondary.dexterity;
        intelligence = inSecondary.intelligence;
        wisdom = inSecondary.wisdom;
        charisma = inSecondary.charisma;
        heroicStrength = inSecondary.strength;
        heroicStamina = inSecondary.stamina;
        heroicAgility = inSecondary.agility;
        heroicDexterity = inSecondary.heroicDexterity;
        heroicIntelligence = inSecondary.heroicIntelligence;
        heroicWisdom = inSecondary.heroicWisdom;
        heroicCharisma = inSecondary.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inSecondary.magicRes;
        fireRes = inSecondary.fireRes;
        coldRes = inSecondary.coldRes;
        diseaseRes = inSecondary.diseaseRes;
        poisonRes = inSecondary.poisonRes;
        corruptionRes = inSecondary.corruptionRes;

        //Equipment Special Data Fields
        attack = inSecondary.attack;
        hpRegen = inSecondary.hpRegen;
        manaRegen = inSecondary.manaRegen;
        endRegen = inSecondary.endRegen;
        spellShield = inSecondary.spellShield;
        shielding = inSecondary.shielding;
        dotShield = inSecondary.dotShield;
        damageShield = inSecondary.damageShield;
        dsMitigation = inSecondary.dsMitigation;
        avoidance = inSecondary.avoidance;
        accuracy = inSecondary.accuracy;
        stunResist = inSecondary.stunResist;
        strikeThrough = inSecondary.strikeThrough;
        healAmount = inSecondary.healAmount;
        spellDamage = inSecondary.spellDamage;
        clairvoyance = inSecondary.clairvoyance;

        //Class Equipable Logic
        classAll = inSecondary.classAll;
        classMagician = inSecondary.classMagician;
        classCleric = inSecondary.classCleric;
        classBard = inSecondary.classBard;
        classShaman = inSecondary.classShaman;
        classDruid = inSecondary.classDruid;
        classRanger = inSecondary.classRanger;
        classMonk = inSecondary.classMonk;
        classEnchanter = inSecondary.classEnchanter;
        classNecromancer = inSecondary.classNecromancer;
        classRogue = inSecondary.classRogue;
        classWarrior = inSecondary.classWarrior;
        classBerserker = inSecondary.classBerserker;
        classShadowknight = inSecondary.classShadowknight;
        classWizard = inSecondary.classWizard;
        classPaladin = inSecondary.classPaladin;
        classBeastlord = inSecondary.classBeastlord;
    }
}
