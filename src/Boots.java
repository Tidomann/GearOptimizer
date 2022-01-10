import java.util.Random;

public class Boots extends Equipment{
    int max = 6;

    public Boots(int randomBoots){
        if (randomBoots < 0 || randomBoots >= max){
            Random rand = new Random();
            randomBoots = rand.nextInt(max);
        }
        switch (randomBoots){
            case 0:
                name = "Alligator Scaled Boots";
                id = 0;
                classAll = true;
                bonusAC = 9;
                bonusMana = 7;
                bonusEnd = 7;
                strength = 3;
                intelligence = 5;
                wisdom = 5;
                attack = 5;
                kickdamage = 1;
                hasAugment = true;
                break;
            case 1:
                name = "Earthen Stompers";
                id = 1;
                classAll = true;
                bonusAC = 13;
                bonusHP = 25;
                bonusMana = 35;
                bonusEnd = 45;
                strength = 11;
                stamina = 8;
                intelligence = 11;
                wisdom = 8;
                heroicWisdom = 1;
                agility = 8;
                dexterity = 8;
                charisma = 6;
                poisonRes = 15;
                accuracy = 1;
                healAmount = 2;
                hasAugment = true;
                break;
            case 2:
                name = "Fabled Boots of Roots";
                id = 2;
                classAll = true;
                bonusAC = 22;
                bonusHP = 55;
                bonusMana = 35;
                strength = 16;
                stamina = 16;
                wisdom = 14;
                agility = 13;
                dexterity = 14;
                charisma = -15;
                magicRes = 25;
                fireRes = -15;
                coldRes = 15;
                hpRegen = 3;
                manaRegen = 1;
                shielding = 1;
                stunResist = 2;
                hasAugment = true;
                break;
            case 3:
                name = "Scoutsman's Shoes";
                id = 3;
                classAll = true;
                bonusAC = 12;
                bonusHP = 35;
                bonusMana = 35;
                bonusEnd = 35;
                strength = 14;
                stamina = 11;
                intelligence = 4;
                wisdom = 4;
                agility = 14;
                dexterity = 14;
                attack = 3;
                endRegen = 1;
                combateffects = 2;
                hasAugment = true;
                hasAugmentWOS = true;
                break;
            case 4:
                name = "Swift Boots";
                id = 4;
                classAll = true;
                bonusAC = 8;
                bonusHP = 12;
                bonusMana = 12;
                bonusEnd = 40;
                strength = 12;
                stamina = 8;
                agility = 8;
                dexterity = 12;
                attack = 2;
                hasAugment = true;
                break;
            case 5:
                name = "Fishy Kickers";
                id = 5;
                classAll = true;
                bonusAC = 7;
                bonusHP = 10;
                bonusEnd = 15;
                strength = 7;
                intelligence = 2;
                wisdom = 2;
                agility = 8;
                dexterity = 8;
                attack = 2;
                kickdamage = 2;
                hasAugment = true;
                break;
            case 6:
                name = "Fuzzy Slippers";
                id = 6;
                classAll = true;
                bonusAC = 10;
                bonusHP = 15;
                bonusMana = 30;
                stamina = 6;
                intelligence = 8;
                wisdom = 8;
                agility = 6;
                dexterity = 6;
                charisma = 12;
                fireRes = -10;
                coldRes = 15;
                diseaseRes = 1;
                spellDamage = 1;
                healAmount = 2;
                hasAugment = true;
                break;
            case 7:
                name = "Medicine Slippers";
                id = 6;
                classAll = true;
                bonusAC = 12;
                bonusHP = 20;
                bonusMana = 50;
                bonusEnd = 20;
                strength = 8;
                stamina = 6;
                intelligence = 11;
                wisdom = 13;
                agility = 6;
                charisma = 13;
                manaRegen = 2;
                spellDamage = 2;
                healAmount = 3;
                hasAugment = true;
                hasAugmentWOS = true;
                break;
        }
    }

    public Boots(Boots inBoots){
        name = inBoots.name;
        id = inBoots.id;
        hasAugment = inBoots.hasAugment;
        if(hasAugment && inBoots.augment != null){
            augment = new Augment((Augment) inBoots.augment);
        }
        hasAugmentWOS = inBoots.hasAugmentWOS;
        if(hasAugmentWOS && inBoots.augmentWOS != null){
            augmentWOS = new Augment((Augment) inBoots.augmentWOS);
        }
        bonusAC = inBoots.bonusAC;
        bonusHP = inBoots.bonusHP;
        bonusMana = inBoots.bonusMana;
        bonusEnd = inBoots.bonusEnd;
        strength = inBoots.strength;
        stamina = inBoots.stamina;
        agility = inBoots.agility;
        dexterity = inBoots.dexterity;
        intelligence = inBoots.intelligence;
        wisdom = inBoots.wisdom;
        charisma = inBoots.charisma;
        heroicStrength = inBoots.strength;
        heroicStamina = inBoots.stamina;
        heroicAgility = inBoots.agility;
        heroicDexterity = inBoots.heroicDexterity;
        heroicIntelligence = inBoots.heroicIntelligence;
        heroicWisdom = inBoots.heroicWisdom;
        heroicCharisma = inBoots.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inBoots.magicRes;
        fireRes = inBoots.fireRes;
        coldRes = inBoots.coldRes;
        diseaseRes = inBoots.diseaseRes;
        poisonRes = inBoots.poisonRes;
        corruptionRes = inBoots.corruptionRes;

        //Equipment Special Data Fields
        attack = inBoots.attack;
        hpRegen = inBoots.hpRegen;
        manaRegen = inBoots.manaRegen;
        endRegen = inBoots.endRegen;
        spellShield = inBoots.spellShield;
        shielding = inBoots.shielding;
        dotShield = inBoots.dotShield;
        damageShield = inBoots.damageShield;
        dsMitigation = inBoots.dsMitigation;
        avoidance = inBoots.avoidance;
        accuracy = inBoots.accuracy;
        stunResist = inBoots.stunResist;
        strikeThrough = inBoots.strikeThrough;
        healAmount = inBoots.healAmount;
        spellDamage = inBoots.spellDamage;
        clairvoyance = inBoots.clairvoyance;

        //Class Equipable Logic
        classAll = inBoots.classAll;
        classMagician = inBoots.classMagician;
        classCleric = inBoots.classCleric;
        classBard = inBoots.classBard;
        classShaman = inBoots.classShaman;
        classDruid = inBoots.classDruid;
        classRanger = inBoots.classRanger;
        classMonk = inBoots.classMonk;
        classEnchanter = inBoots.classEnchanter;
        classNecromancer = inBoots.classNecromancer;
        classRogue = inBoots.classRogue;
        classWarrior = inBoots.classWarrior;
        classBerserker = inBoots.classBerserker;
        classShadowknight = inBoots.classShadowknight;
        classWizard = inBoots.classWizard;
        classPaladin = inBoots.classPaladin;
        classBeastlord = inBoots.classBeastlord;
    }
}
