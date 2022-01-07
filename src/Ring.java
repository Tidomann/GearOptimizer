import java.util.Random;

public class Ring extends Equipment{
    int max = 4;

    public Ring(int randomRing){
        if (randomRing < 0 || randomRing >= max){
            Random rand = new Random();
            randomRing = rand.nextInt(max);
        }
        switch (randomRing){
            case 0:
                name = "Band of Fire";
                id = 0;
                classAll = true;
                bonusAC = 8;
                bonusHP = 20;
                bonusMana = 20;
                bonusEnd = 60;
                strength = 16;
                heroicStrength = 1;
                stamina = 8;
                intelligence = 4;
                wisdom = 4;
                agility = 8;
                dexterity = 16;
                heroicDexterity = 2;
                coldRes = 10;
                attack = 4;
                damageShield = 8;
                spellDamage = 2;
                lore = true;
                hasAugment = true;
                break;
            case 1:
                name = "The Grand Ring";
                id = 1;
                classAll = true;
                bonusAC = 20;
                bonusHP = 100;
                bonusMana = 100;
                bonusEnd = 100;
                strength = 20;
                heroicStrength = 2;
                stamina = 20;
                heroicStamina = 2;
                intelligence = 20;
                heroicIntelligence = 2;
                wisdom = 20;
                heroicWisdom = 2;
                agility = 20;
                heroicAgility = 2;
                dexterity = 20;
                heroicDexterity = 2;
                charisma = 20;
                heroicCharisma = 2;
                diseaseRes = 40;
                poisonRes = 40;
                attack = 4;
                hpRegen = 4;
                manaRegen = 4;
                endRegen = 4;
                avoidance = 4;
                accuracy = 4;
                healAmount = 4;
                spellDamage = 4;
                lore = true;
                hasAugment = true;
                break;
            case 2:
                name = "Pilot's Ring";
                id = 2;
                classAll = true;
                bonusAC = 3;
                bonusHP = 40;
                bonusMana = 50;
                stamina = 15;
                intelligence = 15;
                wisdom = 15;
                agility = 15;
                charisma = 10;
                diseaseRes = 10;
                hpRegen = 1;
                manaRegen = 1;
                healAmount = 3;
                spellDamage = 3;
                lore = true;
                hasAugment = true;
                break;
            case 3:
                name = "Ruined Ring";
                id = 3;
                classAll = true;
                bonusHP = 25;
                bonusMana = 15;
                bonusEnd = 55;
                strength = 15;
                heroicStrength = 1;
                stamina = 8;
                intelligence = 4;
                wisdom = 4;
                dexterity = 15;
                attack = 2;
                endRegen = 1;
                accuracy = 2;
                strikeThrough = 2;
                hasAugment = true;
                hasAugmentWOS = true;
        }
    }

    public Ring(Ring inRing){
        name = inRing.name;
        id = inRing.id;
        lore = inRing.lore;
        hasAugment = inRing.hasAugment;
        augment = inRing.augment;
        hasAugmentWOS = inRing.hasAugmentWOS;
        augmentWOS = inRing.augmentWOS;
        bonusAC = inRing.bonusAC;
        bonusHP = inRing.bonusHP;
        bonusMana = inRing.bonusMana;
        bonusEnd = inRing.bonusEnd;
        strength = inRing.strength;
        stamina = inRing.stamina;
        agility = inRing.agility;
        dexterity = inRing.dexterity;
        intelligence = inRing.intelligence;
        wisdom = inRing.wisdom;
        charisma = inRing.charisma;
        heroicStrength = inRing.strength;
        heroicStamina = inRing.stamina;
        heroicAgility = inRing.agility;
        heroicDexterity = inRing.heroicDexterity;
        heroicIntelligence = inRing.heroicIntelligence;
        heroicWisdom = inRing.heroicWisdom;
        heroicCharisma = inRing.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inRing.magicRes;
        fireRes = inRing.fireRes;
        coldRes = inRing.coldRes;
        diseaseRes = inRing.diseaseRes;
        poisonRes = inRing.poisonRes;
        corruptionRes = inRing.corruptionRes;

        //Equipment Special Data Fields
        attack = inRing.attack;
        hpRegen = inRing.hpRegen;
        manaRegen = inRing.manaRegen;
        endRegen = inRing.endRegen;
        spellShield = inRing.spellShield;
        shielding = inRing.shielding;
        dotShield = inRing.dotShield;
        damageShield = inRing.damageShield;
        dsMitigation = inRing.dsMitigation;
        avoidance = inRing.avoidance;
        accuracy = inRing.accuracy;
        stunResist = inRing.stunResist;
        strikeThrough = inRing.strikeThrough;
        healAmount = inRing.healAmount;
        spellDamage = inRing.spellDamage;
        clairvoyance = inRing.clairvoyance;

        //Class Equipable Logic
        classAll = inRing.classAll;
        classMagician = inRing.classMagician;
        classCleric = inRing.classCleric;
        classBard = inRing.classBard;
        classShaman = inRing.classShaman;
        classDruid = inRing.classDruid;
        classRanger = inRing.classRanger;
        classMonk = inRing.classMonk;
        classEnchanter = inRing.classEnchanter;
        classNecromancer = inRing.classNecromancer;
        classRogue = inRing.classRogue;
        classWarrior = inRing.classWarrior;
        classBerserker = inRing.classBerserker;
        classShadowknight = inRing.classShadowknight;
        classWizard = inRing.classWizard;
        classPaladin = inRing.classPaladin;
        classBeastlord = inRing.classBeastlord;
    }

    public boolean isLore(){
        return this.lore;
    }
}
