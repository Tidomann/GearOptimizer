import java.util.Random;

public class Wrist extends Equipment{
    int max = 10;
    boolean lore = false;

    public Wrist(int randomWrist){
        if (randomWrist < 0 || randomWrist >= max){
            Random rand = new Random();
            randomWrist = rand.nextInt(max);
        }
        switch (randomWrist){
            case 0:
                name = "Anti-Hero Bracers";
                id = 0;
                classAll = true;
                bonusAC = 14;
                bonusHP = 60;
                bonusMana = 60;
                bonusEnd = 60;
                strength = 15;
                heroicStrength = 2;
                stamina = 15;
                intelligence = 15;
                wisdom = 15;
                agility = 15;
                dexterity = 15;
                charisma = 15;
                magicRes = 5;
                fireRes = 5;
                coldRes = 5;
                diseaseRes = 5;
                poisonRes = 5;
                corruptionRes = 5;
                stunResist = 5;
                healAmount = 3;
                spellDamage = 3;
                lore = true;
                hasAugment = true;
                break;
            case 1:
                name = "Beetle-borne Bracer";
                id = 1;
                classAll = true;
                bonusAC = 12;
                bonusHP = 20;
                bonusEnd = 10;
                strength = 6;
                stamina = 8;
                agility = 8;
                charisma = 6;
                diseaseRes = 7;
                poisonRes = 7;
                spellDamage = 1;
                lore = true;
                hasAugment = true;
                break;
            case 2:
                name = "Canine Cuffs";
                id = 2;
                classAll = true;
                bonusAC = 11;
                bonusHP = 10;
                bonusMana = 40;
                bonusEnd = 40;
                strength = 14;
                stamina = 6;
                intelligence = 14;
                wisdom = 14;
                charisma = 8;
                attack = 2;
                endRegen = 1;
                spellDamage = 2;
                hasAugment = true;
                hasAugmentWOS = true;
                break;
            case 3:
                name = "Fabled Beetle-borne Bracer";
                id = 3;
                classAll = true;
                bonusAC = 24;
                bonusHP = 60;
                bonusEnd = 20;
                strength = 16;
                stamina = 18;
                agility = 8;
                charisma = 16;
                diseaseRes = 18;
                poisonRes = 17;
                shielding = 1;
                damageShield = 7;
                dotShield = 7;
                spellDamage = 3;
                lore = true;
                hasAugment = true;
                break;
            case 4:
                name = "Fabled Gator Bracer";
                id = 4;
                classAll = true;
                bonusHP = 20;
                bonusMana = 60;
                strength = 15;
                intelligence = 15;
                heroicIntelligence = 1;
                wisdom = 15;
                heroicWisdom = 1;
                agility = 15;
                manaRegen = 1;
                healAmount = 3;
                spellDamage = 3;
                lore = true;
                hasAugment = true;
                break;
            case 5:
                name = "Fabled Gator Cuffs";
                id = 5;
                classAll = true;
                bonusAC = 15;
                bonusHP = 30;
                bonusEnd = 60;
                strength = 14;
                heroicStrength = 1;
                agility = 14;
                heroicAgility = 1;
                dexterity = 1;
                heroicDexterity = 1;
                attack = 3;
                endRegen = 2;
                accuracy = 3;
                strikeThrough = 3;
                lore = true;
                hasAugment = true;
                break;
            case 6:
                name = "Fabled Gator Wristplate";
                id = 6;
                classAll = true;
                bonusAC = 24;
                bonusHP = 60;
                bonusMana = 10;
                bonusEnd = 10;
                stamina = 2;
                heroicStamina = 2;
                charisma = 15;
                heroicCharisma = 2;
                magicRes = 15;
                fireRes = 15;
                coldRes = 15;
                diseaseRes = 15;
                poisonRes = 15;
                hpRegen = 1;
                spellShield = 2;
                shielding = 1;
                lore = true;
                hasAugment = true;
                break;
            case 7:
                name = "Fur Lined Bracers";
                id = 7;
                bonusAC = 13;
                bonusHP = 37;
                bonusMana = 29;
                bonusEnd = 18;
                strength = 11;
                stamina = 4;
                agility = 6;
                dexterity = 11;
                attack = 2;
                hpRegen = 1;
                accuracy = 1;
                lore = true;
                classAll = true;
                hasAugment = true;
                break;
            case 8:
                name = "Poison Seeped Wristwraps";
                id = 8;
                classAll = true;
                bonusAC = 9;
                bonusMana = 35;
                bonusEnd = 35;
                strength = 12;
                heroicStrength = 1;
                intelligence = 12;
                wisdom = 12;
                dexterity = 12;
                poisonRes = 12;
                attack = 3;
                hpRegen = -5;
                damageShield = 2;
                spellDamage = 4;
                hasAugment = true;
                break;
            case 9:
                name = "Telkalar Silk Cuff";
                id = 9;
                classAll = true;
                bonusAC = 7;
                bonusHP = 30;
                bonusMana = 50;
                strength = 6;
                stamina = 6;
                intelligence = 14;
                heroicIntelligence = 1;
                wisdom = 14;
                heroicWisdom = 1;
                charisma = 10;
                poisonRes = 15;
                manaRegen = 1;
                healAmount = 3;
                spellDamage = 3;
                hasAugment = true;
                break;
        }
    }

    public Wrist(Wrist inWrist){
        name = inWrist.name;
        id = inWrist.id;
        lore = inWrist.lore;
        hasAugment = inWrist.hasAugment;
        if(hasAugment && inWrist.augment != null){
            augment = new Augment((Augment) inWrist.augment);
        }
        hasAugmentWOS = inWrist.hasAugmentWOS;
        if(hasAugmentWOS && inWrist.augmentWOS != null){
            augmentWOS = new Augment((Augment) inWrist.augmentWOS);
        }
        bonusAC = inWrist.bonusAC;
        bonusHP = inWrist.bonusHP;
        bonusMana = inWrist.bonusMana;
        bonusEnd = inWrist.bonusEnd;
        strength = inWrist.strength;
        stamina = inWrist.stamina;
        agility = inWrist.agility;
        dexterity = inWrist.dexterity;
        intelligence = inWrist.intelligence;
        wisdom = inWrist.wisdom;
        charisma = inWrist.charisma;
        heroicStrength = inWrist.strength;
        heroicStamina = inWrist.stamina;
        heroicAgility = inWrist.agility;
        heroicDexterity = inWrist.heroicDexterity;
        heroicIntelligence = inWrist.heroicIntelligence;
        heroicWisdom = inWrist.heroicWisdom;
        heroicCharisma = inWrist.heroicCharisma;
        //Equipment Resist Data Fields
        magicRes = inWrist.magicRes;
        fireRes = inWrist.fireRes;
        coldRes = inWrist.coldRes;
        diseaseRes = inWrist.diseaseRes;
        poisonRes = inWrist.poisonRes;
        corruptionRes = inWrist.corruptionRes;

        //Equipment Special Data Fields
        attack = inWrist.attack;
        hpRegen = inWrist.hpRegen;
        manaRegen = inWrist.manaRegen;
        endRegen = inWrist.endRegen;
        spellShield = inWrist.spellShield;
        shielding = inWrist.shielding;
        dotShield = inWrist.dotShield;
        damageShield = inWrist.damageShield;
        dsMitigation = inWrist.dsMitigation;
        avoidance = inWrist.avoidance;
        accuracy = inWrist.accuracy;
        stunResist = inWrist.stunResist;
        strikeThrough = inWrist.strikeThrough;
        healAmount = inWrist.healAmount;
        spellDamage = inWrist.spellDamage;
        clairvoyance = inWrist.clairvoyance;

        //Class Equipable Logic
        classAll = inWrist.classAll;
        classMagician = inWrist.classMagician;
        classCleric = inWrist.classCleric;
        classBard = inWrist.classBard;
        classShaman = inWrist.classShaman;
        classDruid = inWrist.classDruid;
        classRanger = inWrist.classRanger;
        classMonk = inWrist.classMonk;
        classEnchanter = inWrist.classEnchanter;
        classNecromancer = inWrist.classNecromancer;
        classRogue = inWrist.classRogue;
        classWarrior = inWrist.classWarrior;
        classBerserker = inWrist.classBerserker;
        classShadowknight = inWrist.classShadowknight;
        classWizard = inWrist.classWizard;
        classPaladin = inWrist.classPaladin;
        classBeastlord = inWrist.classBeastlord;
    }

    public boolean isLore(){
        return this.lore;
    }
}
