import org.w3c.dom.ranges.Range;

public class Outfit {
    int slots = 21;
    //Outfit Data Fields
    Equipment ear1;
    Equipment ear2;
    Equipment head;
    Equipment face;
    Equipment neck;
    Equipment chest;
    Equipment arms;
    Equipment back;
    Equipment waist;
    Equipment shoulders;
    Equipment bracer1;
    Equipment bracer2;
    Equipment legs;
    Equipment hands;
    Equipment boots;
    Equipment charm; //slot 0
    Equipment ring1;
    Equipment ring2;
    Equipment primary;
    Equipment secondary;
    Equipment ranged;
    //Equipment ammo;
    Equipment[] outfitArray;

    //lore augmentation boolean
    boolean blackDragonEye = false;
    boolean blueDragonEye = false;
    boolean greenDragonEye = false;
    boolean redDragonEye = false;
    boolean whiteDragonEye = false;
    boolean candycorn = false;
    boolean gummybear = false;
    boolean smarties = false;
    boolean seedsofpower = false;
    boolean shardofenergy = false;
    boolean bulwarkDiamond = false;
    boolean burningOpal = false;
    boolean criticalPearl = false;
    boolean enduringPeridot = false;
    boolean evasiveBloodstone = false;
    boolean flowingShappire = false;
    boolean focusedJasper = false;
    boolean furiousOnyx = false;
    boolean ragingFirestone = false;
    boolean reachingCatsEye = false;

    public Outfit(){
        outfitArray = new Equipment[21];
        // Generate Random Equipment
        ear1 = new Ear(-1);
        if(ear1.isLore()){
            do{
                ear2 = new Ear(-1);
            }while(ear2.id == ear1.id);
        }else{
            ear2 = new Ear(-1);
        }
        head = new Head(-1);
        face = new Face(-1);
        neck = new Neck(-1);
        chest = new Chest(-1);
        arms = new Arms(-1);
        back = new Back(-1);
        waist = new Waist(-1);
        shoulders = new Shoulders(-1);
        bracer1 = new Wrist(-1);
        if(bracer1.isLore()){
            do{
                bracer2 = new Wrist(-1);
            }while(bracer2.id == bracer1.id);
        }else{
            bracer2 = new Wrist(-1);
        }
        legs = new Legs(-1);
        hands = new Hands(-1);
        //boots;
        ring1 = new Ring(0);
        if(ring1.isLore()){
            do{
                ring2 = new Ring(-1);
            }while(ring2.id == ring1.id);
        }else{
            ring2 = new Ring(-1);
        }
        primary = new Primary(-1);
        secondary = new Secondary(-1);
        ranged = new Ranged(-1);
        charm = new Charm(-1);
        boots = new Boots(-1);
        outfitArray[0] = ear1;
        outfitArray[1] = ear2;
        outfitArray[2] = head;
        outfitArray[3] = face;
        outfitArray[4] = neck;
        outfitArray[5] = chest;
        outfitArray[6] = arms;
        outfitArray[7] = back;
        outfitArray[8] = waist;
        outfitArray[9] = shoulders;
        outfitArray[10] = bracer1;
        outfitArray[11] = bracer2;
        outfitArray[12] = legs;
        outfitArray[13] = hands;
        outfitArray[14] = boots;
        outfitArray[15] = ring1;
        outfitArray[16] = ring2;
        outfitArray[17] = charm;
        outfitArray[18] = primary;
        outfitArray[19] = secondary;
        outfitArray[20] = ranged;

        //outfit[21] = ammo;
        // Generate augments
        // change the range to slots if we are generating all
        for(int i = 0; i < 17; ++i){
            if(outfitArray[i].hasAugment()){
                generateAugment(this, outfitArray[i]);
            }
            if(outfitArray[i].hasAugmentWOS()){
                generateAugmentWOS(this, outfitArray[i]);
            }
        }
    }

    public void generateAugment(Outfit inOutfit, Equipment inEquipment){
        do{
            inEquipment.augment = new Augment(true, false);
        }while((inEquipment.augment.id == 1 && inOutfit.blackDragonEye) || (inEquipment.augment.id == 2 && inOutfit.blueDragonEye) ||
                (inEquipment.augment.id == 3 && inOutfit.candycorn) || (inEquipment.augment.id == 8 && inOutfit.greenDragonEye) ||
                (inEquipment.augment.id == 9 && inOutfit.gummybear) || (inEquipment.augment.id == 10 && inOutfit.redDragonEye) ||
                (inEquipment.augment.id == 11 && inOutfit.seedsofpower) || (inEquipment.augment.id == 12 && inOutfit.smarties) ||
                (inEquipment.augment.id == 13 && inOutfit.whiteDragonEye) || (inEquipment.augment.id == 28 && inOutfit.shardofenergy));
        if(inEquipment.augment.isLore()){
            //flip boolean flag
            if(inEquipment.augment.id == 1) {
                inOutfit.blackDragonEye = true;
            }
            if(inEquipment.augment.id == 2) {
                inOutfit.blueDragonEye= true;
            }
            if(inEquipment.augment.id == 3) {
                inOutfit.candycorn = true;
            }
            if(inEquipment.augment.id == 8) {
                inOutfit.greenDragonEye = true;
            }
            if(inEquipment.augment.id == 9) {
                inOutfit.gummybear = true;
            }
            if(inEquipment.augment.id == 10) {
                inOutfit.redDragonEye = true;
            }
            if(inEquipment.augment.id == 11) {
                inOutfit.seedsofpower = true;
            }
            if(inEquipment.augment.id == 12) {
                inOutfit.smarties = true;
            }
            if(inEquipment.augment.id == 13) {
                inOutfit.whiteDragonEye = true;
            }
            if(inEquipment.augment.id == 28){
                inOutfit.shardofenergy = true;
            }
        }
    }

    public void generateAugmentWOS(Outfit inOutfit, Equipment inEquipment){
        do{
            inEquipment.augmentWOS = new Augment(false, true);
        }while((inEquipment.augmentWOS.id == 18 && inOutfit.bulwarkDiamond) || (inEquipment.augmentWOS.id == 19 && inOutfit.burningOpal) ||
                (inEquipment.augmentWOS.id == 20 && inOutfit.criticalPearl) || (inEquipment.augmentWOS.id == 21 && inOutfit.enduringPeridot) ||
                (inEquipment.augmentWOS.id == 22 && inOutfit.evasiveBloodstone) || (inEquipment.augmentWOS.id == 23 && inOutfit.flowingShappire) ||
                (inEquipment.augmentWOS.id == 24 && inOutfit.focusedJasper) || (inEquipment.augmentWOS.id == 25 && inOutfit.furiousOnyx) ||
                (inEquipment.augmentWOS.id == 26 && inOutfit.ragingFirestone) || (inEquipment.augmentWOS.id == 27 && inOutfit.reachingCatsEye));
        if(inEquipment.augmentWOS.isLore()){
            //flip boolean flag
            if(inEquipment.augmentWOS.id == 18) {
                inOutfit.bulwarkDiamond = true;
            }
            if(inEquipment.augmentWOS.id == 19) {
                inOutfit.burningOpal = true;
            }
            if(inEquipment.augmentWOS.id == 20) {
                inOutfit.criticalPearl = true;
            }
            if(inEquipment.augmentWOS.id == 21) {
                inOutfit.enduringPeridot = true;
            }
            if(inEquipment.augmentWOS.id == 22) {
                inOutfit.evasiveBloodstone = true;
            }
            if(inEquipment.augmentWOS.id == 23) {
                inOutfit.flowingShappire = true;
            }
            if(inEquipment.augmentWOS.id == 24) {
                inOutfit.focusedJasper = true;
            }
            if(inEquipment.augmentWOS.id == 25) {
                inOutfit.furiousOnyx = true;
            }
            if(inEquipment.augmentWOS.id == 26) {
                inOutfit.ragingFirestone = true;
            }
            if(inEquipment.augmentWOS.id == 27) {
                inOutfit.reachingCatsEye = true;
            }
        }
    }

    public void resetLore(){
        this.blackDragonEye = false;
        this.blueDragonEye = false;
        this.greenDragonEye = false;
        this.redDragonEye = false;
        this.whiteDragonEye = false;
        this.candycorn = false;
        this.gummybear = false;
        this.smarties = false;
        this.seedsofpower = false;
        this.shardofenergy = false;
        this.bulwarkDiamond = false;
        this.burningOpal = false;
        this.criticalPearl = false;
        this.enduringPeridot = false;
        this.evasiveBloodstone = false;
        this.flowingShappire = false;
        this.focusedJasper = false;
        this.furiousOnyx = false;
        this.ragingFirestone = false;
        this. reachingCatsEye = false;
    }

    @Override
    public String toString() {
        String returnString;
        returnString = ear1.name;
        if(ear1.hasAugment()){
            returnString = returnString + "\n" + "---" + ear1.augment.name;
        }
        if(ear1.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + ear1.augmentWOS.name;
        }
        returnString = returnString + "\n" + ear2.name;
        if(ear2.hasAugment()){
            returnString = returnString + "\n" + "---" + ear2.augment.name;
        }
        if(ear2.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + ear2.augmentWOS.name;
        }
        returnString = returnString + "\n" + head.name;
        if(head.hasAugment()){
            returnString = returnString + "\n" + "---" + head.augment.name;
        }
        if(head.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + head.augmentWOS.name;
        }
        returnString = returnString + "\n" + face.name;
        if(face.hasAugment()){
            returnString = returnString + "\n" + "---" + face.augment.name;
        }
        if(face.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + face.augmentWOS.name;
        }
        returnString = returnString + "\n" + neck.name;
        if(neck.hasAugment()){
            returnString = returnString + "\n" + "---" + neck.augment.name;
        }
        if(neck.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + neck.augmentWOS.name;
        }
        returnString = returnString + "\n" + chest.name;
        if(chest.hasAugment()){
            returnString = returnString + "\n" + "---" + chest.augment.name;
        }
        if(chest.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + chest.augmentWOS.name;
        }
        returnString = returnString + "\n" + arms.name;
        if(arms.hasAugment()){
            returnString = returnString + "\n" + "---" + arms.augment.name;
        }
        if(arms.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + arms.augmentWOS.name;
        }
        returnString = returnString + "\n" + back.name;
        if(back.hasAugment()){
            returnString = returnString + "\n" + "---" + back.augment.name;
        }
        if(back.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + back.augmentWOS.name;
        }
        returnString = returnString + "\n" + waist.name;
        if(waist.hasAugment()){
            returnString = returnString + "\n" + "---" + waist.augment.name;
        }
        if(waist.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + waist.augmentWOS.name;
        }
        returnString = returnString + "\n" + shoulders.name;
        if(shoulders.hasAugment()){
            returnString = returnString + "\n" + "---" + shoulders.augment.name;
        }
        if(shoulders.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + shoulders.augmentWOS.name;
        }
        returnString = returnString + "\n" + bracer1.name;
        if(bracer1.hasAugment()){
            returnString = returnString + "\n" + "---" + bracer1.augment.name;
        }
        if(bracer1.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + bracer1.augmentWOS.name;
        }
        returnString = returnString + "\n" + bracer2.name;
        if(bracer2.hasAugment()){
            returnString = returnString + "\n" + "---" + bracer2.augment.name;
        }
        if(bracer2.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + bracer2.augmentWOS.name;
        }
        returnString = returnString + "\n" + legs.name;
        if(legs.hasAugment()){
            returnString = returnString + "\n" + "---" + legs.augment.name;
        }
        if(legs.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + legs.augmentWOS.name;
        }
        returnString = returnString + "\n" + hands.name;
        if(hands.hasAugment()){
            returnString = returnString + "\n" + "---" + hands.augment.name;
        }
        if(hands.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + hands.augmentWOS.name;
        }
        returnString = returnString + "\n" + boots.name;
        if(boots.hasAugment()){
            returnString = returnString + "\n" + "---" + boots.augment.name;
        }
        if(boots.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + boots.augmentWOS.name;
        }
        returnString = returnString + "\n" + ring1.name;
        if(ring1.hasAugment()){
            returnString = returnString + "\n" + "---" + ring1.augment.name;
        }
        if(ring1.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + ring1.augmentWOS.name;
        }
        returnString = returnString + "\n" + ring2.name;
        if(ring2.hasAugment()){
            returnString = returnString + "\n" + "---" + ring2.augment.name;
        }
        if(ring2.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + ring2.augmentWOS.name;
        }
        returnString = returnString + "\n" + primary.name;
        if(primary.hasAugment()){
            returnString = returnString + "\n" + "---" + primary.augment.name;
        }
        if(primary.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + primary.augmentWOS.name;
        }
        returnString = returnString + "\n" + secondary.name;
        if(secondary.hasAugment()){
            returnString = returnString + "\n" + "---" + secondary.augment.name;
        }
        if(secondary.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + secondary.augmentWOS.name;
        }
        returnString = returnString + "\n" + ranged.name;
        if(ranged.hasAugment()){
            returnString = returnString + "\n" + "---" + ranged.augment.name;
        }
        if(ranged.hasAugmentWOS()){
            returnString = returnString + "\n" + "---" + ranged.augmentWOS.name;
        }
        return returnString;
    }

}
