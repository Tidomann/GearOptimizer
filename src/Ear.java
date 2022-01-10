import java.util.Random;

public class Ear extends Equipment{
    int max = 6;
    boolean lore = false;

    public Ear(int randomEar){
        if (randomEar < 0 || randomEar >= max){
            Random rand = new Random();
            randomEar = rand.nextInt(max);
        }
        switch (randomEar){
            case 0:
                name = "Blessed Earring of the Guardian";
                id = 0;
                classAll = true;
                bonusAC = 8;
                bonusHP = 60;
                strength = 15;
                stamina = 15;
                agility = 15;
                dexterity = 15;
                intelligence = 15;
                wisdom = 15;
                charisma = 15;
                hastev3 = 5;
                lore = true;
                hasAugment = true;
                break;
            case 1:
                name = "Emeraldsilver Hoop";
                id = 1;
                classAll = true;
                bonusEnd = 30;
                strength = 11;
                dexterity = 11;
                attack = 2;
                endRegen = 1;
                hasAugment = true;
                break;
            case 2:
                name = "Heavy Metal Stud";
                id = 2;
                classAll = true;
                bonusAC = 15;
                bonusHP = 65;
                bonusMana = 15;
                bonusEnd = 15;
                strength = 15;
                heroicStrength = 1;
                stamina = 17;
                heroicStamina = 2;
                intelligence = 4;
                wisdom = 4;
                dexterity = 7;
                attack = 1;
                shielding = 2;
                dotShield = 2;
                healAmount = 1;
                spellDamage = 1;
                lore = true;
                hasAugment = true;
                break;
            case 3:
                name = "Magical Earring";
                id = 3;
                classAll = true;
                bonusMana = 40;
                bonusEnd = 25;
                strength = 13;
                intelligence = 13;
                wisdom = 13;
                charisma = 13;
                diseaseRes = 10;
                healAmount = 3;
                spellDamage = 2;
                clairvoyance = 1;
                lore = true;
                hasAugment = true;
                break;
            case 4:
                name = "Obsidiansilver Hoop";
                id = 4;
                classAll = true;
                bonusMana = 30;
                intelligence = 11;
                charisma = 11;
                manaRegen = 1;
                spellDamage = 2;
                hasAugment = true;
                break;
            case 5:
                name = "Spore Mushroom Earring";
                id = 5;
                classAll = true;
                bonusHP = 15;
                bonusMana = 15;
                strength = 13;
                stamina = 9;
                intelligence = 4;
                wisdom = 4;
                agility = 9;
                dexterity = 13;
                diseaseRes = 10;
                attack = 3;
                lore = true;
                hasAugment = true;
                break;
        }
    }

    public Ear(Ear inEar){
        name = inEar.name;
        id = inEar.id;
        lore = inEar.lore;
        hasAugment = inEar.hasAugment;
        if(hasAugment && inEar.augment != null){
            augment = new Augment((Augment) inEar.augment);
        }
        hasAugmentWOS = inEar.hasAugmentWOS;
        if(hasAugmentWOS && inEar.augmentWOS != null){
            augmentWOS = new Augment((Augment) inEar.augmentWOS);
        }
        bonusAC = inEar.bonusAC;
        bonusHP = inEar.bonusHP;
        bonusMana = inEar.bonusMana;
        bonusEnd = inEar.bonusEnd;
        strength = inEar.strength;
        stamina = inEar.stamina;
        agility = inEar.agility;
        dexterity = inEar.dexterity;
        intelligence = inEar.intelligence;
        wisdom = inEar.wisdom;
        charisma = inEar.charisma;
        heroicStrength = inEar.strength;
        heroicStamina = inEar.stamina;
        heroicAgility = inEar.agility;
        heroicDexterity = inEar.heroicDexterity;
        heroicIntelligence = inEar.heroicIntelligence;
        heroicWisdom = inEar.heroicWisdom;
        heroicCharisma = inEar.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inEar.magicRes;
        fireRes = inEar.fireRes;
        coldRes = inEar.coldRes;
        diseaseRes = inEar.diseaseRes;
        poisonRes = inEar.poisonRes;
        corruptionRes = inEar.corruptionRes;

        //Equipment Special Data Fields
        attack = inEar.attack;
        hpRegen = inEar.hpRegen;
        manaRegen = inEar.manaRegen;
        endRegen = inEar.endRegen;
        spellShield = inEar.spellShield;
        shielding = inEar.shielding;
        dotShield = inEar.dotShield;
        damageShield = inEar.damageShield;
        dsMitigation = inEar.dsMitigation;
        avoidance = inEar.avoidance;
        accuracy = inEar.accuracy;
        stunResist = inEar.stunResist;
        strikeThrough = inEar.strikeThrough;
        healAmount = inEar.healAmount;
        spellDamage = inEar.spellDamage;
        clairvoyance = inEar.clairvoyance;

        //Class Equipable Logic
        classAll = inEar.classAll;
        classMagician = inEar.classMagician;
        classCleric = inEar.classCleric;
        classBard = inEar.classBard;
        classShaman = inEar.classShaman;
        classDruid = inEar.classDruid;
        classRanger = inEar.classRanger;
        classMonk = inEar.classMonk;
        classEnchanter = inEar.classEnchanter;
        classNecromancer = inEar.classNecromancer;
        classRogue = inEar.classRogue;
        classWarrior = inEar.classWarrior;
        classBerserker = inEar.classBerserker;
        classShadowknight = inEar.classShadowknight;
        classWizard = inEar.classWizard;
        classPaladin = inEar.classPaladin;
        classBeastlord = inEar.classBeastlord;
    }
    public boolean isLore(){
        return this.lore;
    }
}
