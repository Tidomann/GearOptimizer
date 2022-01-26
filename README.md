# GearOptimizer
Playing with genetic algorithm for gear optimization

Gear Optimizer is an attempt at creating a genetic algorithm that will generate a set of equipmentfor a character. Each generation will attempt to find a better set of equipment. Parents are selected to breedrandomly using a boxing method. Each slot will randomly be passed down as there is no linear progression to be assumed. Mutation has a chance to randomly selected a new piece of equipment to occupy that slot.

Constraints: Certain equipment that has multiple slots (Wrists, earrings, rings) have a lore attribute, meaning the outfit cannot contain two copies of that equipment. Each equipment has a "slot" for an augment that can be inserted into that slot. There are currently two different types of augment slots with specific augments that can be used in each. Some augments are also "lore" meaning only one can be used in the entire outfit.
 * Additional constraints (such as some equipment being specific to a character's class) has not been implemented at this time.
