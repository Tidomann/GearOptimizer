public class GearOptimizer {
    public static void main(String[] args) {
        int populationSize = 500;
        Character[] population;
        population = new Character[populationSize];
        generate_population(population);
        for(int i = 0; i < population.length; ++i){
            fitness(population[i]);
        }
    }

    public static void generate_population(Character[] inPopulation){
        for(int i = 0; i < inPopulation.length; ++i){
            inPopulation[i] = new Character();
        }
    }

    public static double fitness(Character inCharacter){
        double fitnessScore = 0;
        // Stat Weights
        double bonusACWeight = 0;
        double strengthWeight = 3.0;
        double staminaWeight = 1.0;
        double agilityWeight = 2.0;
        double dexterityWeight = 10.0;
        double intelligenceWeight = 0;
        double wisdomWeight = 0;
        double charismaWeight = 5.0;
        double bonusHPWeight = staminaWeight * 2/3;
        double bonusManaWeight = 0;
        double bonusEndWeight = 0;
        double heroicStrengthWeight = 3.0;
        double heroicStaminaWeight = 1.0;
        double heroicAgilityWeight = 2.0;
        double heroicDexterityWeight = 10.0;
        double heroicIntelligenceWeight = 0;
        double heroicWisdomWeight = 0;
        double heroicCharismaWeight = 5.0;
        //Weight Resist Data
        double magicResWeight = 0;
        double fireResWeight = 0;
        double coldResWeight = 0;
        double diseaseResWeight = 0;
        double poisonResWeight = 0;
        double corruptionResWeight = 0;
        //Weight Special Data
        double attackWeight = 15.0;
        double hpRegenWeight = 0;
        double manaRegenWeight = 0;
        double endRegenWeight = 0;
        double spellShieldWeight = 0;
        double shieldingWeight = 0;
        double dotShieldWeight = 0;
        double damageShieldWeight = 0;
        double dsMitigationWeight = 0;
        double avoidanceWeight = 5.0;
        double accuracyWeight = 15.0;
        double stunResistWeight = 0;
        double strikeThroughWeight = 0;
        double healAmountWeight = 0;
        double spellDamageWeight = 0;
        double clairvoyanceWeight = 0;
        double combateffectsWeight = 0;
        double hasteWeight = 50.0;
        double hastev3Weight = 50.0;
        //skill Weights
        double skillDodgeWeight = 0;
        double skillSafeFallWeight = 0;
        double skillDefenseWeight = 0;
        double skill1HSlashingWeight = 0;
        double skillOffenseWeight = 0;
        double skillChannelingWeight = 0;
        double skillEvocationWeight = 0;
        double kickdamageWeight = 0;
        double skillParryWeight = 0;
        //Could adds Weights for specialized focuses (Ie if a certain aug has a focus you need add a weight for it)
        double focusJasperWeight = 40.0;

        //Evaluated Values
        double evaluated_bonusAC = inCharacter.bonusAC;
        double evaluated_bonusHP = inCharacter.bonusHP;
        double evaluated_bonusMana = inCharacter.bonusMana;
        double evaluated_bonusEnd = inCharacter.bonusEnd;
        double evaluated_strength = inCharacter.strength;
        double evaluated_stamina = inCharacter.stamina;
        double evaluated_agility = inCharacter.agility;
        double evaluated_dexterity = inCharacter.dexterity;
        double evaluated_intelligence = inCharacter.intelligence;
        double evaluated_wisdom = inCharacter.wisdom;
        double evaluated_charisma = inCharacter.charisma;
        double evaluated_heroicStrength = inCharacter.heroicStrength;
        double evaluated_heroicStamina = inCharacter.heroicStamina;
        double evaluated_heroicAgility = inCharacter.heroicAgility;
        double evaluated_heroicDexterity = inCharacter.heroicDexterity;
        double evaluated_heroicIntelligence = inCharacter.heroicIntelligence;
        double evaluated_heroicWisdom = inCharacter.heroicWisdom;
        double evaluated_heroicCharisma = inCharacter.heroicCharisma;
        //Evaluated Resist
        double evaluated_magicRes = inCharacter.magicRes;
        double evaluated_fireRes = inCharacter.fireRes;
        double evaluated_coldRes = inCharacter.coldRes;
        double evaluated_diseaseRes = inCharacter.diseaseRes;
        double evaluated_poisonRes = inCharacter.poisonRes;
        double evaluated_corruptionRes = inCharacter.corruptionRes;
        //Evaluated Special
        double evaluated_attack = inCharacter.attack;
        double evaluated_hpRegen = inCharacter.hpRegen;
        double evaluated_manaRegen = inCharacter.manaRegen;
        double evaluated_endRegen = inCharacter.endRegen;
        double evaluated_spellShield = inCharacter.spellShield;
        double evaluated_shielding = inCharacter.shielding;
        double evaluated_dotShield = inCharacter.dotShield;
        double evaluated_damageShield = inCharacter.damageShield;
        double evaluated_dsMitigation = inCharacter.dsMitigation;
        double evaluated_avoidance = inCharacter.avoidance;
        double evaluated_accuracy = inCharacter.accuracy;
        double evaluated_stunResist = inCharacter.stunResist;
        double evaluated_strikeThrough = inCharacter.strikeThrough;
        double evaluated_healAmount = inCharacter.healAmount;
        double evaluated_spellDamage = inCharacter.spellDamage;
        double evaluated_clairvoyance = inCharacter.clairvoyance;
        double evaluated_combateffects = inCharacter.combateffects;
        double evaluated_haste = inCharacter.haste;
        double evaluated_hastev3 = inCharacter.hastev3;
        //Evaluated skill mods
        double evaluated_skillDodge = inCharacter.skillDodge;
        double evaluated_skillSafeFall = inCharacter.skillSafeFall;
        double evaluated_skillDefense = inCharacter.skillDefense;
        double evaluated_skill1HSlashing = inCharacter.skill1HSlashing;
        double evaluated_skillOffense = inCharacter.skillOffense;
        double evaluated_skillChanneling = inCharacter.skillChanneling;
        double evaluated_skillEvocation = inCharacter.skillEvocation;
        double evaluated_skillParry = inCharacter.skillParry;
        double evaluated_kickdamage = inCharacter.kickdamage;

        for(int i = 0; i < inCharacter.outfit.slots; ++i){
            evaluated_bonusAC += inCharacter.outfit.outfitArray[i].strength;
            evaluated_bonusHP += inCharacter.outfit.outfitArray[i].bonusHP;
            evaluated_bonusMana += inCharacter.outfit.outfitArray[i].bonusMana;
            evaluated_bonusEnd += inCharacter.outfit.outfitArray[i].bonusEnd;
            evaluated_strength += inCharacter.outfit.outfitArray[i].strength;
            evaluated_stamina += inCharacter.outfit.outfitArray[i].stamina;
            evaluated_agility += inCharacter.outfit.outfitArray[i].agility;
            evaluated_dexterity += inCharacter.outfit.outfitArray[i].dexterity;
            evaluated_intelligence += inCharacter.outfit.outfitArray[i].intelligence;
            evaluated_wisdom += inCharacter.outfit.outfitArray[i].wisdom;
            evaluated_charisma += inCharacter.outfit.outfitArray[i].charisma;
            evaluated_heroicStrength += inCharacter.outfit.outfitArray[i].heroicStrength;
            evaluated_heroicStamina += inCharacter.outfit.outfitArray[i].heroicStamina;
            evaluated_heroicAgility += inCharacter.outfit.outfitArray[i].heroicAgility;
            evaluated_heroicDexterity += inCharacter.outfit.outfitArray[i].heroicDexterity;
            evaluated_heroicIntelligence += inCharacter.outfit.outfitArray[i].heroicIntelligence;
            evaluated_heroicWisdom += inCharacter.outfit.outfitArray[i].heroicWisdom;
            evaluated_heroicCharisma += inCharacter.outfit.outfitArray[i].heroicCharisma;
            evaluated_magicRes += inCharacter.outfit.outfitArray[i].magicRes;
            evaluated_fireRes += inCharacter.outfit.outfitArray[i].fireRes;
            evaluated_coldRes += inCharacter.outfit.outfitArray[i].coldRes;
            evaluated_diseaseRes += inCharacter.outfit.outfitArray[i].diseaseRes;
            evaluated_poisonRes += inCharacter.outfit.outfitArray[i].poisonRes;
            evaluated_corruptionRes += inCharacter.outfit.outfitArray[i].corruptionRes;
            evaluated_attack += inCharacter.outfit.outfitArray[i].attack;
            evaluated_hpRegen += inCharacter.outfit.outfitArray[i].hpRegen;
            evaluated_manaRegen += inCharacter.outfit.outfitArray[i].manaRegen;
            evaluated_endRegen += inCharacter.outfit.outfitArray[i].endRegen;
            evaluated_spellShield += inCharacter.outfit.outfitArray[i].spellShield;
            evaluated_shielding += inCharacter.outfit.outfitArray[i].shielding;
            evaluated_dotShield += inCharacter.outfit.outfitArray[i].dotShield;
            evaluated_damageShield += inCharacter.outfit.outfitArray[i].damageShield;
            evaluated_dsMitigation += inCharacter.outfit.outfitArray[i].dsMitigation;
            evaluated_avoidance += inCharacter.outfit.outfitArray[i].avoidance;
            evaluated_accuracy += inCharacter.outfit.outfitArray[i].accuracy;
            evaluated_stunResist += inCharacter.outfit.outfitArray[i].stunResist;
            evaluated_strikeThrough += inCharacter.outfit.outfitArray[i].strikeThrough;
            evaluated_healAmount += inCharacter.outfit.outfitArray[i].healAmount;
            evaluated_spellDamage += inCharacter.outfit.outfitArray[i].spellDamage;
            evaluated_clairvoyance += inCharacter.outfit.outfitArray[i].clairvoyance;
            evaluated_combateffects += inCharacter.outfit.outfitArray[i].combateffects;
            evaluated_haste += inCharacter.outfit.outfitArray[i].haste;
            evaluated_hastev3 += inCharacter.outfit.outfitArray[i].hastev3;
            evaluated_skillDodge += inCharacter.outfit.outfitArray[i].skillDodge;
            evaluated_skillSafeFall += inCharacter.outfit.outfitArray[i].skillSafeFall;
            evaluated_skillDefense += inCharacter.outfit.outfitArray[i].skillDefense;
            evaluated_skill1HSlashing += inCharacter.outfit.outfitArray[i].skill1HSlashing;
            evaluated_skillOffense += inCharacter.outfit.outfitArray[i].skillOffense;
            evaluated_skillChanneling += inCharacter.outfit.outfitArray[i].skillChanneling;
            evaluated_skillEvocation += inCharacter.outfit.outfitArray[i].skillEvocation;
            evaluated_skillParry += inCharacter.outfit.outfitArray[i].skillParry;
            evaluated_kickdamage += inCharacter.outfit.outfitArray[i].kickdamage;

            if(inCharacter.outfit.outfitArray[i].hasAugment){
                evaluated_bonusAC += inCharacter.outfit.outfitArray[i].augment.strength;
                evaluated_bonusHP += inCharacter.outfit.outfitArray[i].augment.bonusHP;
                evaluated_bonusMana += inCharacter.outfit.outfitArray[i].augment.bonusMana;
                evaluated_bonusEnd += inCharacter.outfit.outfitArray[i].augment.bonusEnd;
                evaluated_strength += inCharacter.outfit.outfitArray[i].augment.strength;
                evaluated_stamina += inCharacter.outfit.outfitArray[i].augment.stamina;
                evaluated_agility += inCharacter.outfit.outfitArray[i].augment.agility;
                evaluated_dexterity += inCharacter.outfit.outfitArray[i].augment.dexterity;
                evaluated_intelligence += inCharacter.outfit.outfitArray[i].augment.intelligence;
                evaluated_wisdom += inCharacter.outfit.outfitArray[i].augment.wisdom;
                evaluated_charisma += inCharacter.outfit.outfitArray[i].augment.charisma;
                evaluated_heroicStrength += inCharacter.outfit.outfitArray[i].augment.heroicStrength;
                evaluated_heroicStamina += inCharacter.outfit.outfitArray[i].augment.heroicStamina;
                evaluated_heroicAgility += inCharacter.outfit.outfitArray[i].augment.heroicAgility;
                evaluated_heroicDexterity += inCharacter.outfit.outfitArray[i].augment.heroicDexterity;
                evaluated_heroicIntelligence += inCharacter.outfit.outfitArray[i].augment.heroicIntelligence;
                evaluated_heroicWisdom += inCharacter.outfit.outfitArray[i].augment.heroicWisdom;
                evaluated_heroicCharisma += inCharacter.outfit.outfitArray[i].augment.heroicCharisma;
                evaluated_magicRes += inCharacter.outfit.outfitArray[i].augment.magicRes;
                evaluated_fireRes += inCharacter.outfit.outfitArray[i].augment.fireRes;
                evaluated_coldRes += inCharacter.outfit.outfitArray[i].augment.coldRes;
                evaluated_diseaseRes += inCharacter.outfit.outfitArray[i].augment.diseaseRes;
                evaluated_poisonRes += inCharacter.outfit.outfitArray[i].augment.poisonRes;
                evaluated_corruptionRes += inCharacter.outfit.outfitArray[i].augment.corruptionRes;
                evaluated_attack += inCharacter.outfit.outfitArray[i].augment.attack;
                evaluated_hpRegen += inCharacter.outfit.outfitArray[i].augment.hpRegen;
                evaluated_manaRegen += inCharacter.outfit.outfitArray[i].augment.manaRegen;
                evaluated_endRegen += inCharacter.outfit.outfitArray[i].augment.endRegen;
                evaluated_spellShield += inCharacter.outfit.outfitArray[i].augment.spellShield;
                evaluated_shielding += inCharacter.outfit.outfitArray[i].augment.shielding;
                evaluated_dotShield += inCharacter.outfit.outfitArray[i].augment.dotShield;
                evaluated_damageShield += inCharacter.outfit.outfitArray[i].augment.damageShield;
                evaluated_dsMitigation += inCharacter.outfit.outfitArray[i].augment.dsMitigation;
                evaluated_avoidance += inCharacter.outfit.outfitArray[i].augment.avoidance;
                evaluated_accuracy += inCharacter.outfit.outfitArray[i].augment.accuracy;
                evaluated_stunResist += inCharacter.outfit.outfitArray[i].augment.stunResist;
                evaluated_strikeThrough += inCharacter.outfit.outfitArray[i].augment.strikeThrough;
                evaluated_healAmount += inCharacter.outfit.outfitArray[i].augment.healAmount;
                evaluated_spellDamage += inCharacter.outfit.outfitArray[i].augment.spellDamage;
                evaluated_clairvoyance += inCharacter.outfit.outfitArray[i].augment.clairvoyance;
                evaluated_combateffects += inCharacter.outfit.outfitArray[i].augment.combateffects;
                evaluated_haste += inCharacter.outfit.outfitArray[i].augment.haste;
                evaluated_hastev3 += inCharacter.outfit.outfitArray[i].augment.hastev3;
                evaluated_skillDodge += inCharacter.outfit.outfitArray[i].augment.skillDodge;
                evaluated_skillSafeFall += inCharacter.outfit.outfitArray[i].augment.skillSafeFall;
                evaluated_skillDefense += inCharacter.outfit.outfitArray[i].augment.skillDefense;
                evaluated_skill1HSlashing += inCharacter.outfit.outfitArray[i].augment.skill1HSlashing;
                evaluated_skillOffense += inCharacter.outfit.outfitArray[i].augment.skillOffense;
                evaluated_skillChanneling += inCharacter.outfit.outfitArray[i].augment.skillChanneling;
                evaluated_skillEvocation += inCharacter.outfit.outfitArray[i].augment.skillEvocation;
                evaluated_skillParry += inCharacter.outfit.outfitArray[i].augment.skillParry;
                evaluated_kickdamage += inCharacter.outfit.outfitArray[i].augment.kickdamage;
            }
            if(inCharacter.outfit.outfitArray[i].hasAugmentWOS){
                evaluated_bonusAC += inCharacter.outfit.outfitArray[i].augmentWOS.strength;
                evaluated_bonusHP += inCharacter.outfit.outfitArray[i].augmentWOS.bonusHP;
                evaluated_bonusMana += inCharacter.outfit.outfitArray[i].augmentWOS.bonusMana;
                evaluated_bonusEnd += inCharacter.outfit.outfitArray[i].augmentWOS.bonusEnd;
                evaluated_strength += inCharacter.outfit.outfitArray[i].augmentWOS.strength;
                evaluated_stamina += inCharacter.outfit.outfitArray[i].augmentWOS.stamina;
                evaluated_agility += inCharacter.outfit.outfitArray[i].augmentWOS.agility;
                evaluated_dexterity += inCharacter.outfit.outfitArray[i].augmentWOS.dexterity;
                evaluated_intelligence += inCharacter.outfit.outfitArray[i].augmentWOS.intelligence;
                evaluated_wisdom += inCharacter.outfit.outfitArray[i].augmentWOS.wisdom;
                evaluated_charisma += inCharacter.outfit.outfitArray[i].augmentWOS.charisma;
                evaluated_heroicStrength += inCharacter.outfit.outfitArray[i].augmentWOS.heroicStrength;
                evaluated_heroicStamina += inCharacter.outfit.outfitArray[i].augmentWOS.heroicStamina;
                evaluated_heroicAgility += inCharacter.outfit.outfitArray[i].augmentWOS.heroicAgility;
                evaluated_heroicDexterity += inCharacter.outfit.outfitArray[i].augmentWOS.heroicDexterity;
                evaluated_heroicIntelligence += inCharacter.outfit.outfitArray[i].augmentWOS.heroicIntelligence;
                evaluated_heroicWisdom += inCharacter.outfit.outfitArray[i].augmentWOS.heroicWisdom;
                evaluated_heroicCharisma += inCharacter.outfit.outfitArray[i].augmentWOS.heroicCharisma;
                evaluated_magicRes += inCharacter.outfit.outfitArray[i].augmentWOS.magicRes;
                evaluated_fireRes += inCharacter.outfit.outfitArray[i].augmentWOS.fireRes;
                evaluated_coldRes += inCharacter.outfit.outfitArray[i].augmentWOS.coldRes;
                evaluated_diseaseRes += inCharacter.outfit.outfitArray[i].augmentWOS.diseaseRes;
                evaluated_poisonRes += inCharacter.outfit.outfitArray[i].augmentWOS.poisonRes;
                evaluated_corruptionRes += inCharacter.outfit.outfitArray[i].augmentWOS.corruptionRes;
                evaluated_attack += inCharacter.outfit.outfitArray[i].augmentWOS.attack;
                evaluated_hpRegen += inCharacter.outfit.outfitArray[i].augmentWOS.hpRegen;
                evaluated_manaRegen += inCharacter.outfit.outfitArray[i].augmentWOS.manaRegen;
                evaluated_endRegen += inCharacter.outfit.outfitArray[i].augmentWOS.endRegen;
                evaluated_spellShield += inCharacter.outfit.outfitArray[i].augmentWOS.spellShield;
                evaluated_shielding += inCharacter.outfit.outfitArray[i].augmentWOS.shielding;
                evaluated_dotShield += inCharacter.outfit.outfitArray[i].augmentWOS.dotShield;
                evaluated_damageShield += inCharacter.outfit.outfitArray[i].augmentWOS.damageShield;
                evaluated_dsMitigation += inCharacter.outfit.outfitArray[i].augmentWOS.dsMitigation;
                evaluated_avoidance += inCharacter.outfit.outfitArray[i].augmentWOS.avoidance;
                evaluated_accuracy += inCharacter.outfit.outfitArray[i].augmentWOS.accuracy;
                evaluated_stunResist += inCharacter.outfit.outfitArray[i].augmentWOS.stunResist;
                evaluated_strikeThrough += inCharacter.outfit.outfitArray[i].augmentWOS.strikeThrough;
                evaluated_healAmount += inCharacter.outfit.outfitArray[i].augmentWOS.healAmount;
                evaluated_spellDamage += inCharacter.outfit.outfitArray[i].augmentWOS.spellDamage;
                evaluated_clairvoyance += inCharacter.outfit.outfitArray[i].augmentWOS.clairvoyance;
                evaluated_combateffects += inCharacter.outfit.outfitArray[i].augmentWOS.combateffects;
                evaluated_haste += inCharacter.outfit.outfitArray[i].augmentWOS.haste;
                evaluated_hastev3 += inCharacter.outfit.outfitArray[i].augmentWOS.hastev3;
                evaluated_skillDodge += inCharacter.outfit.outfitArray[i].augmentWOS.skillDodge;
                evaluated_skillSafeFall += inCharacter.outfit.outfitArray[i].augmentWOS.skillSafeFall;
                evaluated_skillDefense += inCharacter.outfit.outfitArray[i].augmentWOS.skillDefense;
                evaluated_skill1HSlashing += inCharacter.outfit.outfitArray[i].augmentWOS.skill1HSlashing;
                evaluated_skillOffense += inCharacter.outfit.outfitArray[i].augmentWOS.skillOffense;
                evaluated_skillChanneling += inCharacter.outfit.outfitArray[i].augmentWOS.skillChanneling;
                evaluated_skillEvocation += inCharacter.outfit.outfitArray[i].augmentWOS.skillEvocation;
                evaluated_skillParry += inCharacter.outfit.outfitArray[i].augmentWOS.skillParry;
                evaluated_kickdamage += inCharacter.outfit.outfitArray[i].augmentWOS.kickdamage;
            }
        }
        fitnessScore += evaluated_bonusAC + bonusACWeight;
        fitnessScore += evaluated_bonusHP * bonusHPWeight;
        fitnessScore += evaluated_bonusMana * bonusManaWeight;
        fitnessScore += evaluated_bonusEnd * bonusEndWeight;
        if(evaluated_strength > 275){
            fitnessScore += 275 * strengthWeight;
        }else{
            fitnessScore += evaluated_strength * strengthWeight;
        }
        if(evaluated_stamina > 275){
            fitnessScore += 275 * staminaWeight;
        }else{
            fitnessScore += evaluated_stamina * staminaWeight;
        }
        if(evaluated_agility > 275){
            fitnessScore += 275 * agilityWeight;
        }else{
            fitnessScore += evaluated_agility * agilityWeight;
        }
        if(evaluated_dexterity > 275){
            fitnessScore += 275 * dexterityWeight;
        }else{
            fitnessScore += evaluated_dexterity * dexterityWeight;
        }
        if(evaluated_intelligence > 275){
            fitnessScore += 275 * intelligenceWeight;
        }else{
            fitnessScore += evaluated_intelligence * intelligenceWeight;
        }
        if(evaluated_wisdom > 275){
            fitnessScore += 275 * wisdomWeight;
        }else{
            fitnessScore += evaluated_wisdom * wisdomWeight;
        }
        if(evaluated_charisma > 275){
            fitnessScore += 275 * charismaWeight;
        }else{
            fitnessScore += evaluated_charisma * charismaWeight;
        }
        fitnessScore += evaluated_heroicStrength * heroicStrengthWeight;
        fitnessScore += evaluated_heroicStamina * heroicStaminaWeight;
        fitnessScore += evaluated_heroicAgility * heroicAgilityWeight;
        fitnessScore += evaluated_heroicDexterity * heroicDexterityWeight;
        fitnessScore += evaluated_heroicIntelligence * heroicIntelligenceWeight;
        fitnessScore += evaluated_heroicWisdom * heroicWisdomWeight;
        fitnessScore += evaluated_heroicCharisma * heroicCharismaWeight;
        fitnessScore += evaluated_magicRes * magicResWeight;
        fitnessScore += evaluated_fireRes * fireResWeight;
        fitnessScore += evaluated_coldRes * coldResWeight;
        fitnessScore += evaluated_diseaseRes * diseaseResWeight;
        fitnessScore += evaluated_poisonRes * poisonResWeight;
        fitnessScore += evaluated_corruptionRes * corruptionResWeight;
        fitnessScore += evaluated_attack * attackWeight;
        fitnessScore += evaluated_hpRegen * hpRegenWeight;
        fitnessScore += evaluated_manaRegen * manaRegenWeight;
        fitnessScore += evaluated_endRegen * endRegenWeight;
        fitnessScore += evaluated_spellShield * spellShieldWeight;
        fitnessScore += evaluated_shielding * shieldingWeight;
        fitnessScore += evaluated_dotShield * dotShieldWeight;
        fitnessScore += evaluated_damageShield * damageShieldWeight;
        fitnessScore += evaluated_dsMitigation * dsMitigationWeight;
        fitnessScore += evaluated_avoidance * avoidanceWeight;
        fitnessScore += evaluated_accuracy * accuracyWeight;
        fitnessScore += evaluated_stunResist * stunResistWeight;
        fitnessScore += evaluated_strikeThrough * strikeThroughWeight;
        fitnessScore += evaluated_healAmount * healAmountWeight;
        fitnessScore += evaluated_spellDamage * spellDamageWeight;
        fitnessScore += evaluated_clairvoyance * clairvoyanceWeight;
        fitnessScore += evaluated_combateffects * combateffectsWeight;
        fitnessScore += evaluated_haste * hasteWeight;
        fitnessScore += evaluated_hastev3 * hastev3Weight;
        fitnessScore += evaluated_skillDodge * skillDodgeWeight;
        fitnessScore += evaluated_skillSafeFall * skillSafeFallWeight;
        fitnessScore += evaluated_skillDefense * skillDefenseWeight;
        fitnessScore += evaluated_skill1HSlashing * skill1HSlashingWeight;
        fitnessScore += evaluated_skillOffense * skillOffenseWeight;
        fitnessScore += evaluated_skillChanneling * skillChannelingWeight;
        fitnessScore += evaluated_skillEvocation * skillEvocationWeight;
        fitnessScore += evaluated_skillParry * skillParryWeight;
        fitnessScore += evaluated_kickdamage * kickdamageWeight;
        if(inCharacter.outfit.focusedJasper){
            fitnessScore += focusJasperWeight;
        }

        inCharacter.fitness = fitnessScore;
        return fitnessScore;
    }
}
