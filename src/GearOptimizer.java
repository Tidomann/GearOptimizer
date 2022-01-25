import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * Gear Optimizer is an attempt at creating a genetic algorithm that will generate a set of equipment
 * for a character. Each generation will attempt to find a better set of equipment. Parents are selected to breed
 * randomly using a boxing method. Each slot will randomly be passed down as there is no linear progression to be
 * assumed. Mutation has a chance to randomly selected a new piece of equipment to occupy that slot.
 *
 * Constraints: Certain equipment that has multiple slots (Wrists, earrings, rings) have a lore attribute, meaning
 * the outfit cannot contain two copies of that equipment. Each equipment has a "slot" for an augment that can be
 * inserted into that slot. There are currently two different types of augment slots with specific augments that
 * can be used in each. Some augments are also "lore" meaning only one can be used in the entire outfit.
 *
 * Additional constraints (such as some equipment being specific to a character's class) has not been implemented at
 * this time.
 * @author Tidomann
 */
public class GearOptimizer {
    public static void main(String[] args) {
        //Algorithm Settings
        double mutationFactor = 1.0;
        int populationSize = 500;
        int generations = 100;

        //Testing algorithm runtime
        long start = System.nanoTime();

        ArrayList<Character> population = new ArrayList<Character>();
        population = generate_population(population, populationSize);
        double max = 0.0;
        for(int i = 0; i < population.size(); ++i){
            if(max < population.get(i).fitness){
                max = population.get(i).fitness;
            }
        }
        System.out.println("Starting Max - " + max);

        for(int i = 0; i < generations; ++i){
            Collections.shuffle(population);
            population = next_generation(population, mutationFactor);
            if(max < population.get(0).fitness){
                max = population.get(0).fitness;
                System.out.println("New Max Found - " + max);
            }
            //Periodically update console of progress every 100 generations
            if(i%100 == 0){
                System.out.println("Currently testing Generation: "+ i);
            }
        }
        //Display best outfit
        System.out.println(population.get(0).outfit);

        //Ensure no outfit is better than our max
        for(int i = 0; i < population.size(); ++i){
            if(max < population.get(i).fitness){
                System.out.println("debug time");
            }
        }
        printStats(population.get(0));
        long end= System.nanoTime();
        //Concert nanoseconds to seconds and display to console
        System.out.print("Program took:" + (end - start)/1000000000 + "seconds");

    }

    /**
     * Function to generate an initial population and set their fitness values
     * @param inPopulation the array to populate
     * @param populationSize the size of the population to generate
     * @return the population array with generated solutions
     */
    public static ArrayList<Character> generate_population(ArrayList<Character> inPopulation, int populationSize){
        inPopulation.ensureCapacity(populationSize);
        for(int i = 0; i < populationSize; ++i){
            Character temp = new Character();
            temp.fitness = fitness(temp);
            inPopulation.add(temp);
        }
        return inPopulation;
    }

    /**
     * next_generation takes in a population and generates a new generation of that population.
     * It does this by using an unbiased boxing method. By dividing the population into 10 boxes.
     * For each parent in box 1, we randomly select a parent from box 2, 3, 4... 10 until box once is exhausted.
     * This results in inPopulation.size / 2 offspring.
     * We repeat the process until 9 times the original population is generated. The original population is added
     * to this new generation and we sort for fitness, returning the top inPopulation.size solutions.
     * @param inPopulation the input population to be breeded
     * @param mutationFactor the rate of mutation for the breeding
     * @return the top solutions of same size
     */
    public static ArrayList<Character> next_generation(ArrayList<Character> inPopulation, double mutationFactor){
        Random rand = new Random();
        int sectionSize = inPopulation.size() / 10; //Create 10 sections that are 1/10 the incoming population size
        ArrayList<Character> breededPopulation = new ArrayList<Character>();
        breededPopulation.ensureCapacity(inPopulation.size()*10);
        /*
        We want to end with offspring of size that is 10 times the original population size, and each iteration of
        breeding generates offspring of size n/2 (2 parents generate 1 offspring).
        After 18 generations we will end with offspring of size n * 18/2 = n * 9. Adding the original population
        as we don't want to lose the original parents results in n * 9 + n = n * 10 which is our target breeding.
        We must iterate 18 times to generate enough offspring for diversity.
         */
        for(int i = 0; i < 18; ++i){
            LinkedList<Character> section1 = new LinkedList<Character>();
            LinkedList<Character> section2 = new LinkedList<Character>();
            LinkedList<Character> section3 = new LinkedList<Character>();
            LinkedList<Character> section4 = new LinkedList<Character>();
            LinkedList<Character> section5 = new LinkedList<Character>();
            LinkedList<Character> section6 = new LinkedList<Character>();
            LinkedList<Character> section7 = new LinkedList<Character>();
            LinkedList<Character> section8 = new LinkedList<Character>();
            LinkedList<Character> section9 = new LinkedList<Character>();
            LinkedList<Character> section10 = new LinkedList<Character>();
            for(int j = 0; j < sectionSize/10; ++j){
                for(int k = 0; k < 10; ++k){
                    section1.add(inPopulation.get(k+(j*10)));
                    section2.add(inPopulation.get(k+(j*10)+sectionSize));
                    section3.add(inPopulation.get(k+(j*10)+(sectionSize*2)));
                    section4.add(inPopulation.get(k+(j*10)+(sectionSize*3)));
                    section5.add(inPopulation.get(k+(j*10)+(sectionSize*4)));
                    section6.add(inPopulation.get(k+(j*10)+(sectionSize*5)));
                    section7.add(inPopulation.get(k+(j*10)+(sectionSize*6)));
                    section8.add(inPopulation.get(k+(j*10)+(sectionSize*7)));
                    section9.add(inPopulation.get(k+(j*10)+(sectionSize*8)));
                    section10.add(inPopulation.get(k+(j*10)+(sectionSize*9)));
                }
            }
            //declare function variables
            int temp;
            Character offspring;
            //Breed section 1 with every section until it is empty
            //Remove the chosen parents from each linked list upon breading
            //TODO: Revamp this to be array based with a boolean array for selected parents, instead of needing to
            // linkedlist removal (was previously arraylist removal which is even greater time complexity
            while(!section1.isEmpty()){
                //TODO: break this into a separate function to remove reused code
                temp = rand.nextInt(section2.size());
                offspring = crossover_breed(section1.get(section1.size()-1), section2.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section1.remove(section1.get(section1.size()-1));
                section2.remove(temp);
                if(section1.isEmpty()) // End Loop if section becomes empty after breeding
                    break;
                temp = rand.nextInt(section3.size());
                offspring = crossover_breed(section1.get(section1.size()-1), section3.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section1.remove(section1.get(section1.size()-1));
                section3.remove(temp);
                if(section1.isEmpty()) // End Loop if section becomes empty after breeding
                    break;
                temp = rand.nextInt(section4.size());
                offspring = crossover_breed(section1.get(section1.size()-1), section4.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section1.remove(section1.get(section1.size()-1));
                section4.remove(temp);
                if(section1.isEmpty()) // End Loop if section becomes empty after breeding
                    break;
                temp = rand.nextInt(section5.size());
                offspring = crossover_breed(section1.get(section1.size()-1), section5.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section1.remove(section1.get(section1.size()-1));
                section5.remove(temp);
                if(section1.isEmpty()) // End Loop if section becomes empty after breeding
                    break;
                temp = rand.nextInt(section6.size());
                offspring = crossover_breed(section1.get(section1.size()-1), section6.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section1.remove(section1.get(section1.size()-1));
                section6.remove(temp);
                if(section1.isEmpty()) // End Loop if section becomes empty after breeding
                    break;
                temp = rand.nextInt(section7.size());
                offspring = crossover_breed(section1.get(section1.size()-1), section7.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section1.remove(section1.get(section1.size()-1));
                section7.remove(temp);
                if(section1.isEmpty()) // End Loop if section becomes empty after breeding
                    break;
                temp = rand.nextInt(section8.size());
                offspring = crossover_breed(section1.get(section1.size()-1), section8.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section1.remove(section1.get(section1.size()-1));
                section8.remove(temp);
                if(section1.isEmpty()) // End Loop if section becomes empty after breeding
                    break;
                temp = rand.nextInt(section9.size());
                offspring = crossover_breed(section1.get(section1.size()-1), section9.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section1.remove(section1.get(section1.size()-1));
                section9.remove(temp);
                if(section1.isEmpty()) // End Loop if section becomes empty after breeding
                    break;
                temp = rand.nextInt(section10.size());
                offspring = crossover_breed(section1.get(section1.size()-1), section10.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section1.remove(section1.get(section1.size()-1));
                section10.remove(temp);
            }
            while(!section2.isEmpty()){
                temp = rand.nextInt(section3.size());
                offspring = crossover_breed(section2.get(section2.size()-1), section3.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section2.remove(section2.get(section2.size()-1));
                section3.remove(temp);
                if(section2.isEmpty())
                    break;
                temp = rand.nextInt(section4.size());
                offspring = crossover_breed(section2.get(section2.size()-1), section4.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section2.remove(section2.get(section2.size()-1));
                section4.remove(temp);
                if(section2.isEmpty())
                    break;
                temp = rand.nextInt(section5.size());
                offspring = crossover_breed(section2.get(section2.size()-1), section5.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section2.remove(section2.get(section2.size()-1));
                section5.remove(temp);
                if(section2.isEmpty())
                    break;
                temp = rand.nextInt(section6.size());
                offspring = crossover_breed(section2.get(section2.size()-1), section6.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section2.remove(section2.get(section2.size()-1));
                section6.remove(temp);
                if(section2.isEmpty())
                    break;
                temp = rand.nextInt(section7.size());
                offspring = crossover_breed(section2.get(section2.size()-1), section7.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section2.remove(section2.get(section2.size()-1));
                section7.remove(temp);
                if(section2.isEmpty())
                    break;
                temp = rand.nextInt(section8.size());
                offspring = crossover_breed(section2.get(section2.size()-1), section8.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section2.remove(section2.get(section2.size()-1));
                section8.remove(temp);
                if(section2.isEmpty())
                    break;
                temp = rand.nextInt(section9.size());
                offspring = crossover_breed(section2.get(section2.size()-1), section9.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section2.remove(section2.get(section2.size()-1));
                section9.remove(temp);
                if(section2.isEmpty())
                    break;
                temp = rand.nextInt(section10.size());
                offspring = crossover_breed(section2.get(section2.size()-1), section10.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section2.remove(section2.get(section2.size()-1));
                section10.remove(temp);
            }
            while(!section3.isEmpty()){
                temp = rand.nextInt(section4.size());
                offspring = crossover_breed(section3.get(section3.size()-1), section4.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section3.remove(section3.get(section3.size()-1));
                section4.remove(temp);
                if(section3.isEmpty())
                    break;
                temp = rand.nextInt(section5.size());
                offspring = crossover_breed(section3.get(section3.size()-1), section5.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section3.remove(section3.get(section3.size()-1));
                section5.remove(temp);
                if(section3.isEmpty())
                    break;
                temp = rand.nextInt(section6.size());
                offspring = crossover_breed(section3.get(section3.size()-1), section6.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section3.remove(section3.get(section3.size()-1));
                section6.remove(temp);
                if(section3.isEmpty())
                    break;
                temp = rand.nextInt(section7.size());
                offspring = crossover_breed(section3.get(section3.size()-1), section7.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section3.remove(section3.get(section3.size()-1));
                section7.remove(temp);
                if(section3.isEmpty())
                    break;
                temp = rand.nextInt(section8.size());
                offspring = crossover_breed(section3.get(section3.size()-1), section8.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section3.remove(section3.get(section3.size()-1));
                section8.remove(temp);
                if(section3.isEmpty())
                    break;
                temp = rand.nextInt(section9.size());
                offspring = crossover_breed(section3.get(section3.size()-1), section9.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section3.remove(section3.get(section3.size()-1));
                section9.remove(temp);
                if(section3.isEmpty())
                    break;
                temp = rand.nextInt(section10.size());
                offspring = crossover_breed(section3.get(section3.size()-1), section10.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section3.remove(section3.get(section3.size()-1));
                section10.remove(temp);
            }
            while(!section4.isEmpty()){
                temp = rand.nextInt(section5.size());
                offspring = crossover_breed(section4.get(section4.size()-1), section5.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section4.remove(section4.get(section4.size()-1));
                section5.remove(temp);
                if(section4.isEmpty())
                    break;
                temp = rand.nextInt(section6.size());
                offspring = crossover_breed(section4.get(section4.size()-1), section6.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section4.remove(section4.get(section4.size()-1));
                section6.remove(temp);
                if(section4.isEmpty())
                    break;
                temp = rand.nextInt(section7.size());
                offspring = crossover_breed(section4.get(section4.size()-1), section7.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section4.remove(section4.get(section4.size()-1));
                section7.remove(temp);
                if(section4.isEmpty())
                    break;
                temp = rand.nextInt(section8.size());
                offspring = crossover_breed(section4.get(section4.size()-1), section8.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section4.remove(section4.get(section4.size()-1));
                section8.remove(temp);
                if(section4.isEmpty())
                    break;
                temp = rand.nextInt(section9.size());
                offspring = crossover_breed(section4.get(section4.size()-1), section9.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section4.remove(section4.get(section4.size()-1));
                section9.remove(temp);
                if(section4.isEmpty())
                    break;
                temp = rand.nextInt(section10.size());
                offspring = crossover_breed(section4.get(section4.size()-1), section10.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section4.remove(section4.get(section4.size()-1));
                section10.remove(temp);
            }
            while(!section5.isEmpty()){
                temp = rand.nextInt(section6.size());
                offspring = crossover_breed(section5.get(section5.size()-1), section6.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section5.remove(section5.get(section5.size()-1));
                section6.remove(temp);
                if(section5.isEmpty())
                    break;
                temp = rand.nextInt(section7.size());
                offspring = crossover_breed(section5.get(section5.size()-1), section7.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section5.remove(section5.get(section5.size()-1));
                section7.remove(temp);
                if(section5.isEmpty())
                    break;
                temp = rand.nextInt(section8.size());
                offspring = crossover_breed(section5.get(section5.size()-1), section8.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section5.remove(section5.get(section5.size()-1));
                section8.remove(temp);
                if(section5.isEmpty())
                    break;
                temp = rand.nextInt(section9.size());
                offspring = crossover_breed(section5.get(section5.size()-1), section9.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section5.remove(section5.get(section5.size()-1));
                section9.remove(temp);
                if(section5.isEmpty())
                    break;
                temp = rand.nextInt(section10.size());
                offspring = crossover_breed(section5.get(section5.size()-1), section10.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section5.remove(section5.get(section5.size()-1));
                section10.remove(temp);
            }
            while(!section6.isEmpty()){
                temp = rand.nextInt(section7.size());
                offspring = crossover_breed(section6.get(section6.size()-1), section7.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section6.remove(section6.get(section6.size()-1));
                section7.remove(temp);
                if(section6.isEmpty())
                    break;
                temp = rand.nextInt(section8.size());
                offspring = crossover_breed(section6.get(section6.size()-1), section8.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section6.remove(section6.get(section6.size()-1));
                section8.remove(temp);
                if(section6.isEmpty())
                    break;
                temp = rand.nextInt(section9.size());
                offspring = crossover_breed(section6.get(section6.size()-1), section9.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section6.remove(section6.get(section6.size()-1));
                section9.remove(temp);
                if(section6.isEmpty())
                    break;
                temp = rand.nextInt(section10.size());
                offspring = crossover_breed(section6.get(section6.size()-1), section10.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section6.remove(section6.get(section6.size()-1));
                section10.remove(temp);
            }
            while(!section7.isEmpty()){
                temp = rand.nextInt(section8.size());
                offspring = crossover_breed(section7.get(section7.size()-1), section8.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section7.remove(section7.get(section7.size()-1));
                section8.remove(temp);
                if(section7.isEmpty())
                    break;
                temp = rand.nextInt(section9.size());
                offspring = crossover_breed(section7.get(section7.size()-1), section9.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section7.remove(section7.get(section7.size()-1));
                section9.remove(temp);
                if(section7.isEmpty())
                    break;
                temp = rand.nextInt(section10.size());
                offspring = crossover_breed(section7.get(section7.size()-1), section10.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section7.remove(section7.get(section7.size()-1));
                section10.remove(temp);
            }
            while(!section8.isEmpty()){
                temp = rand.nextInt(section9.size());
                offspring = crossover_breed(section8.get(section8.size()-1), section9.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section8.remove(section8.get(section8.size()-1));
                section9.remove(temp);
                if(section8.isEmpty())
                    break;
                temp = rand.nextInt(section10.size());
                offspring = crossover_breed(section8.get(section8.size()-1), section10.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section8.remove(section8.get(section8.size()-1));
                section10.remove(temp);
            }
            while(!section9.isEmpty()){
                temp = rand.nextInt(section10.size());
                offspring = crossover_breed(section9.get(section9.size()-1), section10.get(temp));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section9.remove(section9.get(section9.size()-1));
                section10.remove(temp);
            }
            while(section10.size() > 1){
                offspring = crossover_breed(section10.get(0), section10.get(1));
                mutator(offspring, mutationFactor);
                breededPopulation.add(offspring);
                section10.remove(1);
                section10.remove(0);

            }
        }
        // Assign fitness value for each offspring
        for(int m = 0; m < breededPopulation.size(); ++m){
            breededPopulation.get(m).fitness = fitness(breededPopulation.get(m));
        }
        breededPopulation.addAll(inPopulation); //readd original population
        //sort the population, highest fitness closer to beginning of list
        Collections.sort(breededPopulation, Collections.reverseOrder());
        for(int i = 0; i < inPopulation.size(); ++i){
            inPopulation.set(i, breededPopulation.get(i));
        }
        return inPopulation;
    }

    /**
     * This functions takes two characters and generates a new outfit solution adhering to the constraints
     * of the solution by randomly selecting a piece of equipment from the parent and assigning it to the offspring.
     * If the selected piece of equipment fails to adhere to the constraints- randomly generate a new piece of
     * equipment that adheres to the constraints.
     * @param a the first parent
     * @param b the second parent
     * @return the offspring solution that is a random selection of equipment of parent a and parent b
     */
    public static Character crossover_breed(Character a, Character b){
        Character offspring = new Character();
        offspring.outfit.resetLore();
        Random rand = new Random();
        //Ear 1
        double temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.ear1 = new Ear((Ear) a.outfit.ear1);
        }else{ // b case
            offspring.outfit.ear1 = new Ear((Ear) b.outfit.ear1);
        }
        offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.ear1);
        if(offspring.outfit.ear1.hasAugmentWOS()){
            offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.ear1);
        }
        //Ear2
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.ear2 = new Ear((Ear) a.outfit.ear2);
            if(offspring.outfit.ear1.isLore()){
                if(offspring.outfit.ear1.id == a.outfit.ear2.id){ //if they are the same lore earring
                    //need a new ear
                    do{
                        offspring.outfit.ear2 = new Ear(-1);
                    }while(offspring.outfit.ear2.id == offspring.outfit.ear1.id);
                    if(offspring.outfit.ear2.hasAugment()){
                        offspring.outfit.generateAugment(offspring.outfit, offspring.outfit.ear2);
                    }
                    if(offspring.outfit.ear2.hasAugmentWOS()){
                        offspring.outfit.generateAugmentWOS(offspring.outfit, offspring.outfit.ear2);
                    }
                }
            }else{
                offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.ear2);
                if(offspring.outfit.ear2.hasAugmentWOS()){
                    offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.ear2);
                }
            }
        }else { // b case
            offspring.outfit.ear2 = new Ear((Ear) b.outfit.ear2);
            if (offspring.outfit.ear1.isLore()) {
                if (offspring.outfit.ear1.id == b.outfit.ear2.id) { //make sure the earrings are not the same
                    //need a new ear
                    do{
                        offspring.outfit.ear2 = new Ear(-1);
                    }while(offspring.outfit.ear2.id == offspring.outfit.ear1.id);
                    if (offspring.outfit.ear2.hasAugment()) {
                        offspring.outfit.generateAugment(offspring.outfit, offspring.outfit.ear2);
                    }
                    if (offspring.outfit.ear2.hasAugmentWOS()) {
                        offspring.outfit.generateAugmentWOS(offspring.outfit, offspring.outfit.ear2);
                    }
                }
            }else{
                offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.ear2);
                if(offspring.outfit.ear2.hasAugmentWOS()){
                    offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.ear2);
                }
            }
        }
        //Head
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.head = new Head((Head) a.outfit.head);
        }else{ // b case
            offspring.outfit.head = new Head((Head) b.outfit.head);
        }
        offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.head);
        if(offspring.outfit.head.hasAugmentWOS()){
            offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.head);
        }
        //Face
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.face = new Face((Face) a.outfit.face);
        }else{ // b case
            offspring.outfit.face = new Face((Face) b.outfit.face);
        }
        offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.face);
        if(offspring.outfit.face.hasAugmentWOS()){
            offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.face);
        }
        //Neck
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.neck = new Neck((Neck) a.outfit.neck);
        }else{ // b case
            offspring.outfit.neck = new Neck((Neck) b.outfit.neck);
        }
        offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.neck);
        if(offspring.outfit.neck.hasAugmentWOS()){
            offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.neck);
        }
        //Chest
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.chest = new Chest((Chest) a.outfit.chest);
        }else{ // b case
            offspring.outfit.chest = new Chest((Chest) b.outfit.chest);
        }
        offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.chest);
        if(offspring.outfit.chest.hasAugmentWOS()){
            offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.chest);
        }
        //Arms
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.arms = new Arms((Arms) a.outfit.arms);
        }else{ // b case
            offspring.outfit.arms = new Arms((Arms) b.outfit.arms);
        }
        offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.arms);
        if(offspring.outfit.arms.hasAugmentWOS()){
            offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.arms);
        }
        //Back
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.back = new Back((Back) a.outfit.back);
        }else{ // b case
            offspring.outfit.back = new Back((Back) b.outfit.back);
        }
        offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.back);
        if(offspring.outfit.back.hasAugmentWOS()){
            offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.back);
        }
        //Waist
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.waist = new Waist((Waist) a.outfit.waist);
        }else{ // b case
            offspring.outfit.waist = new Waist((Waist) b.outfit.waist);
        }
        offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.waist);
        if(offspring.outfit.waist.hasAugmentWOS()){
            offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.waist);
        }
        //Shoulders
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.shoulders = new Shoulders((Shoulders) a.outfit.shoulders);
        }else{ // b case
            offspring.outfit.shoulders = new Shoulders((Shoulders) b.outfit.shoulders);
        }
        offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.shoulders);
        if(offspring.outfit.shoulders.hasAugmentWOS()){
            offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.shoulders);
        }
        //Bracer1
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.bracer1 = new Wrist((Wrist) a.outfit.bracer1);
        }else{ // b case
            offspring.outfit.bracer1 = new Wrist((Wrist) b.outfit.bracer1);
        }
        offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.bracer1);
        if(offspring.outfit.bracer1.hasAugmentWOS()){
            offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.bracer1);
        }
        //Bracer2
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.bracer2 = new Wrist((Wrist) a.outfit.bracer2);
            if(offspring.outfit.bracer1.isLore()){
                if(offspring.outfit.bracer1.id == a.outfit.bracer2.id){ //if they are the same lore earring
                    //need a new bracer
                    do{
                        offspring.outfit.bracer2 = new Wrist(-1);
                    }while(offspring.outfit.bracer2.id == offspring.outfit.bracer1.id);
                    if(offspring.outfit.bracer2.hasAugment()){
                        offspring.outfit.generateAugment(offspring.outfit, offspring.outfit.bracer2);
                    }
                    if(offspring.outfit.bracer2.hasAugmentWOS()){
                        offspring.outfit.generateAugmentWOS(offspring.outfit, offspring.outfit.bracer2);
                    }
                }
            }else{
                offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.bracer2);
                if(offspring.outfit.bracer2.hasAugmentWOS()){
                    offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.bracer2);
                }
            }
        }else { // b case
            offspring.outfit.bracer2 = new Wrist((Wrist) b.outfit.bracer2);
            if (offspring.outfit.bracer1.isLore()) {
                if (offspring.outfit.bracer1.id == b.outfit.bracer2.id) { //make sure the earrings are not the same
                    //need a new bracer
                    do{
                        offspring.outfit.bracer2 = new Wrist(-1);
                    }while(offspring.outfit.bracer2.id == offspring.outfit.bracer1.id);
                    if (offspring.outfit.bracer2.hasAugment()) {
                        offspring.outfit.generateAugment(offspring.outfit, offspring.outfit.bracer2);
                    }
                    if (offspring.outfit.bracer2.hasAugmentWOS()) {
                        offspring.outfit.generateAugmentWOS(offspring.outfit, offspring.outfit.bracer2);
                    }
                }
            }else{
                offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.bracer2);
                if(offspring.outfit.bracer2.hasAugmentWOS()){
                    offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.bracer2);
                }
            }
        }
        //Legs
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.legs = new Legs((Legs) a.outfit.legs);
        }else{ // b case
            offspring.outfit.legs = new Legs((Legs) b.outfit.legs);
        }
        offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.legs);
        if(offspring.outfit.legs.hasAugmentWOS()){
            offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.legs);
        }
        //Hands
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.hands = new Hands((Hands) a.outfit.hands);
        }else{ // b case
            offspring.outfit.hands = new Hands((Hands) b.outfit.hands);
        }
        offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.hands);
        if(offspring.outfit.hands.hasAugmentWOS()){
            offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.hands);
        }
        //Boots
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.boots = new Boots((Boots) a.outfit.boots);
        }else{ // b case
            offspring.outfit.boots = new Boots((Boots) b.outfit.boots);
        }
        offspring.outfit.checkAugment(offspring.outfit, offspring.outfit.boots);
        if(offspring.outfit.boots.hasAugmentWOS()){
            offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.boots);
        }
        //Ring1
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.ring1 = new Ring((Ring) a.outfit.ring1);
        }else{ // b case
            offspring.outfit.ring1 = new Ring((Ring) b.outfit.ring1);
        }
        offspring.outfit.checkAugmentRing(offspring.outfit, (Ring) offspring.outfit.ring1);
        if(offspring.outfit.ring1.hasAugmentWOS()){
            offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.ring1);
        }
        //Ring2
        temp = rand.nextDouble();
        if(temp < 0.5){ // a case
            offspring.outfit.ring2 = new Ring((Ring) a.outfit.ring2);
            if(offspring.outfit.ring1.isLore()){
                if(offspring.outfit.ring1.id == a.outfit.ring2.id){ //if they are the same lore ring
                    //need a new ring
                    do{
                        offspring.outfit.ring2 = new Ring(-1);
                    }while(offspring.outfit.ring2.id == offspring.outfit.ring1.id);
                    if(offspring.outfit.ring2.hasAugment()){
                        offspring.outfit.generateAugment(offspring.outfit, offspring.outfit.ring2);
                    }
                    if(((Ring)offspring.outfit.ring2).hasAugment2()){
                        offspring.outfit.generateAugment2(offspring.outfit, (Ring) offspring.outfit.ring2);
                    }
                    if(offspring.outfit.ring2.hasAugmentWOS()){
                        offspring.outfit.generateAugmentWOS(offspring.outfit, offspring.outfit.ring2);
                    }
                }
            }else{
                offspring.outfit.checkAugmentRing(offspring.outfit, (Ring) offspring.outfit.ring2);
                if(offspring.outfit.ring2.hasAugmentWOS()){
                    offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.ring2);
                }
            }
        }else { // b case
            offspring.outfit.ring2 = new Ring((Ring) b.outfit.ring2);
            if (offspring.outfit.ring1.isLore()) {
                if (offspring.outfit.ring1.id == b.outfit.ring2.id) { //make sure the earrings are not the same
                    //need a new ring
                    do{
                        offspring.outfit.ring2 = new Ring(-1);
                    }while(offspring.outfit.ring2.id == offspring.outfit.ring1.id);
                    if(offspring.outfit.ring2.hasAugment()){
                        offspring.outfit.generateAugment(offspring.outfit, offspring.outfit.ring2);
                    }
                    if(((Ring)offspring.outfit.ring2).hasAugment2()){
                        offspring.outfit.generateAugment2(offspring.outfit, (Ring) offspring.outfit.ring2);
                    }
                    if(offspring.outfit.ring2.hasAugmentWOS()){
                        offspring.outfit.generateAugmentWOS(offspring.outfit, offspring.outfit.ring2);
                    }
                }
            }else{
                offspring.outfit.checkAugmentRing(offspring.outfit, (Ring) offspring.outfit.ring2);
                if(offspring.outfit.ring2.hasAugmentWOS()){
                    offspring.outfit.checkAugmentWOS(offspring.outfit, offspring.outfit.ring2);
                }
            }
        }
        //Assumes charm, primary, and secondary cannot change
        //TODO: may change this functionality
        return offspring;
    }

    /**
     * The mutator function randomly mutates a piece of equipment by generating a random piece of equipment
     * for that slot that would adhere to the problem constaints in the event it's probability
     * falls under the mutationFactor
     * @param inCharacter the character solution to test mutation
     * @param mutationFactor the % rate at which each slot could mutate
     */
    public static void mutator(Character inCharacter, double mutationFactor){
        Random rand = new Random();
        //Ear1
        double temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.ear1);
            do{
                inCharacter.outfit.ear1 = new Ear(-1);
            }while(inCharacter.outfit.ear1.isLore() && inCharacter.outfit.ear1.id == inCharacter.outfit.ear2.id);

            if(inCharacter.outfit.ear1.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.ear1);
            }
            if(inCharacter.outfit.ear1.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.ear1);
            }
        }
        //Ear2
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.ear2);
            do{
                inCharacter.outfit.ear2 = new Ear(-1);
            }while(inCharacter.outfit.ear2.isLore() && inCharacter.outfit.ear1.id == inCharacter.outfit.ear2.id);
            if(inCharacter.outfit.ear2.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.ear2);
            }
            if(inCharacter.outfit.ear2.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.ear2);
            }
        }
        //Head
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.head);
            inCharacter.outfit.head = new Head(-1);
            if(inCharacter.outfit.head.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.head);
            }
            if(inCharacter.outfit.head.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.head);
            }
        }
        //Face
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.face);
            inCharacter.outfit.face = new Face(-1);
            if(inCharacter.outfit.face.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.face);
            }
            if(inCharacter.outfit.face.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.face);
            }
        }
        //Neck
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.neck);
            inCharacter.outfit.neck = new Neck(-1);
            if(inCharacter.outfit.neck.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.neck);
            }
            if(inCharacter.outfit.neck.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.neck);
            }
        }
        //Chest
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.chest);
            inCharacter.outfit.chest = new Chest(-1);
            if(inCharacter.outfit.chest.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.chest);
            }
            if(inCharacter.outfit.chest.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.chest);
            }
        }
        //Arms
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.arms);
            inCharacter.outfit.arms = new Arms(-1);
            if(inCharacter.outfit.arms.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.arms);
            }
            if(inCharacter.outfit.arms.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.arms);
            }
        }
        //Back
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.back);
            inCharacter.outfit.back = new Back(-1);
            if(inCharacter.outfit.back.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.back);
            }
            if(inCharacter.outfit.back.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.back);
            }
        }
        //Waist
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.waist);
            inCharacter.outfit.waist = new Waist(-1);
            if(inCharacter.outfit.waist.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.waist);
            }
            if(inCharacter.outfit.waist.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.waist);
            }
        }
        //Shoulders
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.shoulders);
            inCharacter.outfit.shoulders = new Shoulders(-1);
            if(inCharacter.outfit.shoulders.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.shoulders);
            }
            if(inCharacter.outfit.shoulders.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.shoulders);
            }
        }
        //Bracer1
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.bracer1);
            do{
                inCharacter.outfit.bracer1 = new Wrist(-1);
            }while(inCharacter.outfit.bracer1.isLore() && inCharacter.outfit.bracer1.id == inCharacter.outfit.bracer2.id);
            if(inCharacter.outfit.bracer1.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.bracer1);
            }
            if(inCharacter.outfit.bracer1.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.bracer1);
            }
        }
        //Bracer2
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.bracer2);
            do{
                inCharacter.outfit.bracer2 = new Wrist(-1);
            }while(inCharacter.outfit.bracer2.isLore() && inCharacter.outfit.bracer1.id == inCharacter.outfit.bracer2.id);
            if(inCharacter.outfit.bracer2.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.bracer2);
            }
            if(inCharacter.outfit.bracer2.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.bracer2);
            }
        }
        //Legs
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.legs);
            inCharacter.outfit.legs = new Legs(-1);
            if(inCharacter.outfit.legs.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.legs);
            }
            if(inCharacter.outfit.legs.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.legs);
            }
        }
        //Hands
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.hands);
            inCharacter.outfit.hands = new Hands(-1);
            if(inCharacter.outfit.hands.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.hands);
            }
            if(inCharacter.outfit.hands.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.hands);
            }
        }
        //Boots
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.boots);
            inCharacter.outfit.boots = new Boots(-1);
            if(inCharacter.outfit.boots.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.boots);
            }
            if(inCharacter.outfit.boots.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.boots);
            }
        }
        //Skip Charm
        //Ring1
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.ring1);
            do{
                inCharacter.outfit.ring1 = new Ring(-1);
            }while(inCharacter.outfit.ring1.isLore() && inCharacter.outfit.ring1.id == inCharacter.outfit.ring2.id);
            if(inCharacter.outfit.ring1.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.ring1);
            }
            if(((Ring)inCharacter.outfit.ring1).hasAugment2()){
                inCharacter.outfit.generateAugment2(inCharacter.outfit, (Ring)inCharacter.outfit.ring1);
            }
            if(inCharacter.outfit.ring1.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.ring1);
            }
        }
        //Ring2
        temp = rand.nextDouble();
        if(temp < (mutationFactor/100.0)) {// mutation occurs
            resetLoreAugment(inCharacter, inCharacter.outfit.ring2);
            do{
                inCharacter.outfit.ring2 = new Ring(-1);
            }while(inCharacter.outfit.ring2.isLore() && inCharacter.outfit.ring1.id == inCharacter.outfit.ring2.id);
            if(inCharacter.outfit.ring2.hasAugment()){
                inCharacter.outfit.generateAugment(inCharacter.outfit, inCharacter.outfit.ring2);
            }
            if(((Ring)inCharacter.outfit.ring2).hasAugment2()){
                inCharacter.outfit.generateAugment2(inCharacter.outfit, (Ring)inCharacter.outfit.ring2);
            }
            if(inCharacter.outfit.ring2.hasAugmentWOS()){
                inCharacter.outfit.generateAugmentWOS(inCharacter.outfit, inCharacter.outfit.ring2);
            }
        }
        //Skip Primary
        //Skip Secondary
        //Skip Ranged
    }

    /**
     * Helper function that will reset all the appropriate lore flags for a piece of equipment.
     * Useful when mutating a piece of equipment to allow further changes to adhere to problem parameters
     * @param inCharacter the character solution to modify
     * @param item the specific item that requires the flags to be reset
     */
    public static void resetLoreAugment(Character inCharacter, Equipment item){
        if(item.hasAugment()){
            if(item.augment != null){
                if(item.augment.isLore()){
                    if(item.augment.id == 1) {
                        inCharacter.outfit.blackDragonEye = false;
                    }
                    if(item.augment.id == 2) {
                        inCharacter.outfit.blueDragonEye= false;
                    }
                    if(item.augment.id == 3) {
                        inCharacter.outfit.candycorn = false;
                    }
                    if(item.augment.id == 8) {
                        inCharacter.outfit.greenDragonEye = false;
                    }
                    if(item.augment.id == 9) {
                        inCharacter.outfit.gummybear = false;
                    }
                    if(item.augment.id == 10) {
                        inCharacter.outfit.redDragonEye = false;
                    }
                    if(item.augment.id == 11) {
                        inCharacter.outfit.seedsofpower = false;
                    }
                    if(item.augment.id == 12) {
                        inCharacter.outfit.smarties = false;
                    }
                    if(item.augment.id == 13) {
                        inCharacter.outfit.whiteDragonEye = false;
                    }
                    if(item.augment.id == 28){
                        inCharacter.outfit.shardofenergy = false;
                    }
                }
            }
        }
        if(item.hasAugmentWOS()){
            if(item.augmentWOS != null){
                if(item.augmentWOS.isLore()){
                    if(item.augmentWOS.id == 18) {
                        inCharacter.outfit.bulwarkDiamond = false;
                    }
                    if(item.augmentWOS.id == 19) {
                        inCharacter.outfit.burningOpal = false;
                    }
                    if(item.augmentWOS.id == 20) {
                        inCharacter.outfit.criticalPearl = false;
                    }
                    if(item.augmentWOS.id == 21) {
                        inCharacter.outfit.enduringPeridot = false;
                    }
                    if(item.augmentWOS.id == 22) {
                        inCharacter.outfit.evasiveBloodstone = false;
                    }
                    if(item.augmentWOS.id == 23) {
                        inCharacter.outfit.flowingShappire = false;
                    }
                    if(item.augmentWOS.id == 24) {
                        inCharacter.outfit.focusedJasper = false;
                    }
                    if(item.augmentWOS.id == 25) {
                        inCharacter.outfit.furiousOnyx = false;
                    }
                    if(item.augmentWOS.id == 26) {
                        inCharacter.outfit.ragingFirestone = false;
                    }
                    if(item.augmentWOS.id == 27) {
                        inCharacter.outfit.reachingCatsEye = false;
                    }
                }
            }
        }
        if(item instanceof Ring){
            if(((Ring) item).hasAugment2()){
                if(((Ring) item).augment2 != null){
                    if(((Ring) item).augment2.isLore()){
                        if(((Ring) item).augment2.id == 1) {
                            inCharacter.outfit.blackDragonEye = false;
                        }
                        if(((Ring) item).augment2.id == 2) {
                            inCharacter.outfit.blueDragonEye= false;
                        }
                        if(((Ring) item).augment2.id == 3) {
                            inCharacter.outfit.candycorn = false;
                        }
                        if(((Ring) item).augment2.id == 8) {
                            inCharacter.outfit.greenDragonEye = false;
                        }
                        if(((Ring) item).augment2.id == 9) {
                            inCharacter.outfit.gummybear = false;
                        }
                        if(((Ring) item).augment2.id == 10) {
                            inCharacter.outfit.redDragonEye = false;
                        }
                        if(((Ring) item).augment2.id == 11) {
                            inCharacter.outfit.seedsofpower = false;
                        }
                        if(((Ring) item).augment2.id == 12) {
                            inCharacter.outfit.smarties = false;
                        }
                        if(((Ring) item).augment2.id == 13) {
                            inCharacter.outfit.whiteDragonEye = false;
                        }
                        if(((Ring) item).augment2.id == 28){
                            inCharacter.outfit.shardofenergy = false;
                        }
                    }
                }
            }
        }
    }

    /**
     * Function to determine the fitness of an item.
     * Based on weights assigned to each game statistic based on what is desired by the user.
     * TODO: These values should be modified by user input based on what user determines is valuable
     * @param inCharacter the character solution to test
     * @return the fitness value
     */
    public static double fitness(Character inCharacter){
        double fitnessScore = 0;
        // Stat Weights
        double bonusACWeight = 1.1;
        double strengthWeight = 0.25;
        double staminaWeight = 1.0;
        double agilityWeight = 0.35;
        double dexterityWeight = 5;
        double intelligenceWeight = 0;
        double wisdomWeight = 0;
        double charismaWeight = 2;
        double bonusHPWeight = staminaWeight * 2/3;
        double bonusManaWeight = 0;
        double bonusEndWeight = 0;
        double heroicStrengthWeight = 0.25;
        double heroicStaminaWeight = 1.0;
        double heroicAgilityWeight = 0.35;
        double heroicDexterityWeight = 5;
        double heroicIntelligenceWeight = 0;
        double heroicWisdomWeight = 0;
        double heroicCharismaWeight = 2;
        //Weight Resist Data
        double magicResWeight = 0;
        double fireResWeight = 0;
        double coldResWeight = 0;
        double diseaseResWeight = 0;
        double poisonResWeight = 0;
        double corruptionResWeight = 0;
        //Weight Special Data
        double attackWeight = (dexterityWeight / 0.9) * 1.342;
        double hpRegenWeight = 0;
        double manaRegenWeight = 0;
        double endRegenWeight = 0;
        double spellShieldWeight = 0;
        double shieldingWeight = 0;
        double dotShieldWeight = 0;
        double damageShieldWeight = 0;
        double dsMitigationWeight = 0;
        double avoidanceWeight = 2.0;
        double accuracyWeight = 15.0;
        double stunResistWeight = 0;
        double strikeThroughWeight = 0;
        double healAmountWeight = 0;
        double spellDamageWeight = 0;
        double clairvoyanceWeight = 0;
        double combateffectsWeight = 0;
        double hasteWeight = 55;
        double hastev3Weight = 20;
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
        double focusJasperWeight = 300.0;

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
            if(evaluated_haste < inCharacter.outfit.outfitArray[i].haste){
                evaluated_haste = inCharacter.outfit.outfitArray[i].haste;
            }
            if(evaluated_hastev3 < inCharacter.outfit.outfitArray[i].hastev3){
                evaluated_hastev3 = inCharacter.outfit.outfitArray[i].hastev3;
            }
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
        if(inCharacter.outfit.focusedJasper || inCharacter.outfit.head.id == 9){
            fitnessScore += focusJasperWeight;
        }

        inCharacter.fitness = fitnessScore;
        return fitnessScore;
    }

    /**
     * will print the calculated statistics of a character solution to console
     * @param inCharacter the character solution to print
     */
    public static void printStats(Character inCharacter){
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
            if(evaluated_haste < inCharacter.outfit.outfitArray[i].haste){
                evaluated_haste = inCharacter.outfit.outfitArray[i].haste;
            }
            if(evaluated_hastev3 < inCharacter.outfit.outfitArray[i].hastev3){
                evaluated_hastev3 = inCharacter.outfit.outfitArray[i].hastev3;
            }
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
        System.out.println("Evaluated AC - " + evaluated_bonusAC);
        System.out.println("Evaluated Bonus HP - " + evaluated_bonusHP);
        System.out.println("Evaluated Bonus Mana - " + evaluated_bonusMana);
        System.out.println("Evaluated Bonus End - " + evaluated_bonusEnd);
        System.out.println("Strength - " + evaluated_strength + "(" + evaluated_heroicStrength + ")");
        System.out.println("Stamina - " + evaluated_stamina + "(" + evaluated_heroicStamina + ")");
        System.out.println("Agility - " + evaluated_agility + "(" + evaluated_heroicAgility + ")");
        System.out.println("Dexterity - " + evaluated_dexterity + "(" + evaluated_heroicDexterity + ")");
        System.out.println("Intelligence - " + evaluated_intelligence + "(" + evaluated_heroicIntelligence + ")");
        System.out.println("Wisdom - " + evaluated_wisdom + "(" + evaluated_heroicWisdom + ")");
        System.out.println("Charisma - " + evaluated_charisma + "(" + evaluated_heroicCharisma + ")");
        System.out.println("Attack - " + evaluated_attack);
        System.out.println("Accuracy - " + evaluated_accuracy);
        System.out.println("Haste - " + evaluated_haste);
        System.out.println("Hastev4 - " + evaluated_hastev3);
        if(inCharacter.outfit.focusedJasper || inCharacter.outfit.head.id == 9){
            System.out.println("Has Trueshot");
        }
    }
}
