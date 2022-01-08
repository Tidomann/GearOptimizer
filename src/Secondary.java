public class Secondary extends Equipment{
    int max = 1;

    public Secondary(int randomSecondary){
        /*
        if (randomSecondary < 0 || randomSecondary >= max){
            Random rand = new Random();
            randomSecondary = rand.nextInt(max);
        }
        switch (randomSecondary){
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
        name = "Amplifier of the Deep";
        id = 0;
        classBerserker = true;
        classBeastlord = true;
        classRogue = true;
        classBard = true;
        classMonk = true;
        classShadowknight = true;
        classRanger = true;
        classPaladin = true;
        classWarrior = true;
        bonusHP = 40;
        bonusMana = 40;
        bonusEnd = 40;
        strength = 10;
        stamina = 10;
        intelligence = 10;
        agility = 10;
        dexterity = 10;
        charisma = 10;
        magicRes = 10;
        fireRes =10;
        coldRes = 10;
        diseaseRes = 10;
        poisonRes = 10;
        attack = 10;
        accuracy = 5;
        strikeThrough  = 5;
        damageShield = 5;
        spellDamage = 5;
        healAmount = 5;
        hasAugment = true;
        augment = new Augment(false, false);
        augment.id = 14;
        augment.name = "Strong Phosphite";
        augment.bonusEnd = 15;
        augment.strength = 3;
        augment.heroicStrength = 2;
        augment.dexterity = 3;
        augment.heroicDexterity = 2;
    }

    public Secondary(Secondary inSecondary){
        name = inSecondary.name;
        id = inSecondary.id;
        hasAugment = inSecondary.hasAugment;
        augment = inSecondary.augment;
        hasAugmentWOS = inSecondary.hasAugmentWOS;
        augmentWOS = inSecondary.augmentWOS;
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
