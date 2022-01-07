public class Outfit {
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
    boolean keystoneGarnet = false;
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
        ear1 = new Ear(-1);
        if(ear1.lore){
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
        if(bracer1.lore){
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
    }
    @Override
    public String toString() {
        return (ear1.name + "\n" + ear2.name + "\n" + head.name + "\n" + face.name + "\n" + neck.name + "\n" +
                chest.name + "\n" +  arms.name + "\n" + back.name + "\n" + waist.name + "\n" + shoulders.name + "\n" +
                bracer1.name + "\n" + bracer2.name + "\n" + legs.name + "\n" + hands.name + "\n" + ring1.name + "\n" +
                ring2.name);
    }

}
