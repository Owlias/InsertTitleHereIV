import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
import greenfoot.GreenfootImage;
import java.lang.Object;
import java.util.concurrent.TimeUnit;
import java.awt.Desktop;
import java.net.URI;

public class UIButton extends Actor {
    //private Player player = ((MyWorld)this.getWorld()).getPlayer();
    private String text;
    private Color defaultColor;
    private Color clickedColor;
    private boolean isClicked;
    private final int atkx = 70;
    private final int magx = 195;
    private final int actx = 320;
    private final int itemx = 445;
    private final int actiony = 575;
    public static UIButton uiButtonROCK1 = new UIButton("ROCK");
    public static UIButton uiButtonROCK2 = new UIButton("ROCK");
    public static UIButton uiButtonROCK3 = new UIButton("ROCK");
    public static UIButton peteButton1 = new UIButton("ENTER");
    public static UIButton peteButton2 = new UIButton("ENTER");
    public static UIButton backButton1 = new UIButton ("NOT YET");
    public static UIButton backButton2 = new UIButton ("NOT YET");
    public static UIButton uiButtonBATHTUB1 = new UIButton("BATHTUB");
    public static UIButton uiButtonBATHTUB2 = new UIButton("BATHTUB");
    public static UIButton uiButtonBATHTUB3 = new UIButton("BATHTUB");
    public static UIButton buttonWHAT = new UIButton("WHAT?");
    public static UIButton buttonKISS = new UIButton("KISS");
    public static UIButton buttonSTEAL = new UIButton("STEAL");
    public static UIButton buttonBACK = new UIButton("GO BACK");
    WorldObject bathtub1 = new WorldObject("EmptyBathtub.png");
    WorldObject bathtub2 = new WorldObject("Bathtub.png");
    WorldObject poliowolf = new WorldObject("PolioWolf.png");
    WorldObject slotmachine = new WorldObject("Slot.png");
    
    private ShopGUI temp = null;
    
    //creates the button
    public UIButton(String text) {
        this.text = text;
        this.defaultColor = Color.WHITE;
        this.clickedColor = Color.GREEN;
        this.isClicked = false;
        updateImage();
    }
    //Checks if clicked.
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            isClicked = true;
            updateImage();
            onClick();
            //System.out.println("HI");
            isClicked = false;
            updateImage();
        }
    }
    //Method to draw the button.
     private void updateImage() {
        GreenfootImage image = new GreenfootImage(101, 41);
        image.setFont(new Font("Arial", 10));
        if (isClicked) {
            image.setColor(clickedColor);
        } else {
            image.setColor(defaultColor);
        }
        image.fillRect(0, 0, 100, 40);
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, 100, 40);
        image.setColor(Color.BLACK);
        image.drawString(text, 20, 25);
        setImage(image);
    } 
    //For mushroom when you fail to type. Opens link.
    private void typingFailure() {
        MyWorld world = (MyWorld) this.getWorld();
        TextBox box = world.getTextBox();
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("https://www.typing.com/student/lesson/359/j-f-and-space"));
            }
        }
        catch(Exception E) {
            box.setText("Unfortunately, something about your computer is lame and won't allow this to work.");
        }
    }
    //Controls exactly what happens when you click each button. Very self explanatory when you read it.
    public void onClick() {
        // Define what happens when the button is clicked
        //MyWorld world = (MyWorld) this.getWorld();
        
        if(text.equals("ATTACK")) {
            MyWorld world = (MyWorld) this.getWorld();
            Player p = world.getPlayer();
            Enemy target = world.getCurEnm();
            p.calcDamage(target);
            if(world.getEList().size() == 0) {
                world.noCombat();
            }
        }
        else if(text.equals("MAGIC")) {
            Greenfoot.playSound("sneeze.mp3"); // Play a sound as an example
            MyWorld world = (MyWorld) this.getWorld();
            world.removeComButtons();
            world.addMagButtons();
        }
        else if(text.equals("SCREAM")) {
            MyWorld world = (MyWorld) this.getWorld();
            world.screamcount++;
            TextBox t = world.getTextBox();
            Greenfoot.playSound("PlayerScream.mp3"); // Play a sound as an example
            if(world.screamcount==1) {
                t.setText("Did you really think this would do something useful?");
            }
            else if(world.screamcount>1 && world.screamcount <= 5) {
                t.setText("It still doesn't do anything.");
            }
            else if(world.screamcount>5 && world.screamcount <= 10) {
                t.setText("You really are committing to this scream thing");
            }
            else if(world.screamcount>10 && world.screamcount <= 20) {
                t.setText("Think about peaceful alternatives, like attacking!");
            }
            else if(world.screamcount>20 && world.screamcount <= 40) {
                t.setText("Other buttons do things too.");
            }
            else if(world.screamcount>40 && world.screamcount <= 100) {
                if(world.screamcount == 69) {
                    t.setText("ehehe... nice");
                }
                else {
                    t.setText("HOW ARE YOU STILL ALIVE");
                }
                
            }
            else {
                t.setText("You scream, wondering why you have done what you have done.");
            }
            world.getCurEnm().reduce(1);
            world.enemyAttack();
        }
        else if(text.equals("RUN")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox t = world.getTextBox();
            t.setText("Y O U  C A N  N E V E R  R U N.");
            world.getCurEnm().reduce(0);
            Greenfoot.playSound("uhoh.mp3"); // Play a sound as an example
        }
        else if(text.equals("START")){ 
            
            //Greenfoot.setWorld(new TestWorld());
            Greenfoot.setWorld(new Forest());
        }
        else if(text.equals("INSTRUCTION")){ 
            try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("https://docs.google.com/document/d/1q4-6k8b6Nawb9zvIx_h3fgVE0KAe5LAkPcwdGPLiiDc/edit"));
            }
            }
            catch(Exception E) {
                System.out.println("No.");
            }
        }
        else if(text.equals("HELP")){ 
            try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("https://www.wikihow.com/Treat-Diarrhea-in-Parakeets"));
            }
            }
            catch(Exception E) {
                System.out.println("No.");
            }
        }
        else if(text.equals("CAST")) {
            MyWorld world = (MyWorld) this.getWorld();
            Player p = world.getPlayer();
            Enemy target = world.getCurEnm();
            p.magicATTACK(target);
            if(world.getEList().size() == 0) {
                MyWorld.inCombat = false;
            }
        }
        else if(text.equals("HEAL")) {
            MyWorld world = (MyWorld) this.getWorld();
            Player p = world.getPlayer();
            Enemy target = world.getCurEnm();
            p.magicHEAL();
            target.attack();
        }
        else if(text.equals("PROTECT")) {
            MyWorld world = (MyWorld) this.getWorld();
            Player p = world.getPlayer();
            Enemy target = world.getCurEnm();
            p.magicDEFENSE();
            target.attack();
        }
        else if(text.equals("BACK")) {
            MyWorld world = (MyWorld) this.getWorld();
            Player p = world.getPlayer();
            world.removeMagButtons();
            world.addComButtons();
        }

        else if(text.equals("SUICIDE")) {
            MyWorld world = (MyWorld) this.getWorld();
            Player p = world.getPlayer();
            Enemy target = world.getCurEnm();
            p.reduce(9999);
        }
        else if(text.equals("GOTOWN")) {
            MyWorld world = (MyWorld) this.getWorld();
            Player p = world.getPlayer();
            Enemy target = world.getCurEnm();
            world.stage = 3;
            Greenfoot.setWorld(new Town());
        }

        else if (text.equals("TOWER"))  {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            int rand1 = (int) (Math.random() * 3) + 1;
            int rand2;
            int randx;
            int randy;
            if (world.towerfought == 0) {
                box.setText("There's a stone tower surrounded by trees. ");
                box.setText("Goblins are jumping in and out of the windows, climbing the walls");
                box.setText("and stairs, and then jumping off the roof. They let out a hearty");
                box.setText("goblin chuckle when they hit the ground.");
                Greenfoot.delay(world.delay1);
                box.setText("It looks like a lot of fun! Maybe you could join them.");
                world.towerfought++;
            }
            else if (world.towerfought > 0) {
                box.setText("Oh. Looks like this is a goblin-only event.");
                box.setText("They don't seem very happy with you being here!");
                Greenfoot.delay(world.delay1);
                for (int i = 0; i < rand1; i++)
                {
                    rand2 = (int) (Math.random() * 3) + 1;
                    randx = (int) (Math.random() * 50) + 750;
                    randy = (int) (Math.random() * 300) + 150;
                    if (rand2 == 1)
                    {
                        world.addEnemy(new GoblinGoon(), randx, randy);
                    }
                    else if (rand2 == 2)
                    {
                        world.addEnemy(new GoblinWarrior(), randx, randy);
                    }
                    else if (rand2 == 3)
                    {
                        world.addEnemy(new GoblinWizard(), randx, randy);
                    }
                }
            world.startCombat();
            world.towerfought++;
            }
        }
        else if (text.equals("TOILET"))  {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            if (world.toiletcount == 0) {
            box.setText("There's a porta-potty in the forest. It appears to be occupied.");
            WorldObject toilet = new WorldObject("Toilet.png");
            world.addObject(toilet, 800,300);
            box.setText("For some reason I can't explain, you go and bang on the door.");
            Greenfoot.delay(world.delay4);
            Goblin nakedgoblin = new NakedGoblin();
            world.removeObject(toilet);
            world.addEnemy(nakedgoblin, 800, 300);
            box.setText("NAKED GOBLIN: hnarg sharna graahh!!");
            box.setText("Ahhhh! Cover your eyes!!!");
            Greenfoot.delay(world.delay3);
            box.setText("Oh, thank goodness! There's automatic censoring in this game!");
            Greenfoot.delay(world.delay2);
            box.setText("Wait a minute... The goblin's just wearing a black censor bar.");
            box.setText("That's pretty weird, but not as weird as you bothering a toilet goblin.");
            box.setText("I'd be pretty angry too!");
            Greenfoot.delay(world.delay3);
            world.toiletcount++;
            world.startCombat();
            }
            else if(world.toiletcount==1){
                box.setText("The toilet is now vacant. ");
                box.setText("The only thing that remains is a goblin-shaped suit of leather armor.");
                box.setText("You struggle to fit into it, but somehow it works.");
                world.getPlayer().setArmor(MyWorld.leather);
                world.toiletcount++;
            }
            else {
                box.setText("There's nothing left of interest to look at here.");
            }

        }
        else if (text.equals("HOUSE"))  {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            if (world.housecount == 0 ) {
            world.addObject(world.pineapplehouse, 800, 300);
            box.setText("There's a building up ahead with a pineapple sign in the front.");
            Greenfoot.delay(world.delay2);
            box.setText("Actually, now that you can see it better, it's not a sign at all.");
            box.setText("It's actually a pineapple that someone glued to the wall.");
            Greenfoot.delay(world.delay3);
            box.setText("You'd have to be crazy or a massive pineapple lover to do that.");
            Greenfoot.delay(world.delay3);
            world.addObject(world.pineapplepete, 700, 300);
            box.setText("CRAZY PINEAPPLE PETE: I'm craaaaaaaaazy Pineapple Pete!");
            Greenfoot.delay(world.delay3);
            box.setText("Wow. Yeah, that's something a guy named Crazy Pineapple Pete would do.");
            Greenfoot.delay(world.delay3);
            box.setText("CRAZY PINEAPPLE PETE: Come on into craaaazy Pineapple Pete's house!");
            Greenfoot.delay(world.delay3);
            box.setText("I don't know, dude. I wouldn't trust a guy named Crazy");
            box.setText("It might not be a bad idea to come back when you're ready..");
            box.setText("seriously. Pete could be bad news.");
            world.addObject(peteButton1, atkx, actiony);
            world.addObject(peteButton2, magx, actiony);
            world.addObject(backButton1, actx, actiony);
            world.addObject(backButton2, itemx, actiony);
            }
            else if (world.housecount == 1) {
                box.setText("Crazy Pineapple Pete is no more. It appears that there is a town");
                box.setText("beyond his \"house\". Click HOUSE again to continue to the TOWN.");
                box.setText("You will NOT be able to come back here, so do what you want first.");
                box.setText("You got the WOOL ARMOR for defeating Ol' Pete!");
                world.getPlayer().setArmor(MyWorld.wool);
                world.housecount++;
                
            }
            else if (world.housecount == 2) {

                Greenfoot.setWorld(new Town());
            }
            
        }
        else if (text.equals("ENTER")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            CrazyPineapplePete petefight = new CrazyPineapplePete();
            world.removeObject(peteButton1);
            world.removeObject(peteButton2);
            world.removeObject(backButton1);
            world.removeObject(backButton2);
            box.setText("Okay. Don't say I didn't warn you.");
            Greenfoot.delay(world.delay5);
            world.removeObject(world.pineapplepete);
            world.removeObject(P.player);
            box.setText("You follow Crazy Pineapple Pete into his crazy pineapple home.");
            box.setText("Inside, you quickly realize that his walls, food, and");
            box.setText("furniture are pineapples, or some monstrosity constructed from");
            box.setText("them. There's pineapple juice EVERYWHERE. Gross.");
            Greenfoot.delay(world.delay5);
            box.setText("CRAZY PINEAPPLE PETE: Make yourself at home, my craaazy pineapple");
            box.setText("CRAZY PINEAPPLE PETE: friend! I think you'll make a fine addition");
            box.setText("CRAZY PINEAPPLE PETE: to my craaaaazy pineapple collection!");
            Greenfoot.delay(world.delay4);
            box.setText("The realization hits like a truck. Crazy Pineapple Pete invited");
            box.setText("you into his home for one reason.. to turn you into a pineapple!");
            Greenfoot.delay(world.delay4);
            box.setText("You've got to get out of here. You've got to get out of here.");
            box.setText("You've got to get out of here. You've got to get out of here.");
            box.setText("You've got to get out of here. You've got to get out of here.");
            box.setText("You've got to get out of here. You've got to get out of here.");
            box.setText("You've got to get out of here. You've got to get out of here.");
            Greenfoot.delay(world.delay2);
            box.setText("You turn and race for the door. Crazy Pineapple Pete follows close behind..");
            box.setText("CRAZY PINEAPPLE PETE: Where ya goin', my craaaaaazy pineapple friend?");
            Greenfoot.delay(world.delay3);
            world.addObject(P.player, 500, 300);
            box.setText("You make it outside, away from the pineapple den. For a moment you");
            box.setText("a wave of relief washes over you, but you're not in the clear yet.");
            box.setText("Wait... something's different about Crazy Pineapple Pete.");
            Greenfoot.delay(world.delay4); 
            box.setText("CRAZY PINEAPPLE PETE: pineapples...");
            Greenfoot.delay(world.delay1);
            box.setText("CRAZY PINEAPPLE PETE: more... pineapples...");
            Greenfoot.delay(world.delay1);
            world.addEnemy(petefight, 800, 300);
            box.setText("CRAZY PINEAPPLE PETE: MORE CRAZY PINEAPPLES!!!!");
            Greenfoot.delay(world.delay1);
            box.setText("CRAZY PINEAPPLE PETE: MORE CRAZY PINEAPPLES!!!!");
            Greenfoot.delay(world.delay1);
            box.setText("CRAZY PINEAPPLE PETE: MORE CRAZY PINEAPPLES!!!!");
            Greenfoot.delay(world.delay1);
            box.setText("CRAZY PINEAPPLE PETE: MORE CRAZY PINEAPPLES!!!!");
            Greenfoot.delay(world.delay3);
            box.setText("Crazy Pineapple Pete is going crazy!");
            world.removeObject(world.pineapplehouse);
            Greenfoot.delay(world.delay3);
            
            world.startCombat();
            world.housecount++;
            
        }
        else if (text.equals("NOT YET")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            world.removeObject(peteButton1);
            world.removeObject(peteButton2);
            world.removeObject(backButton1);
            world.removeObject(backButton2);
            world.removeObject(world.pineapplepete);
            world.removeObject(world.pineapplehouse);
        }
        else if (text.equals("ROCK"))  {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            WorldObject rock = new WorldObject("Rock.png");
            WorldObject angrywalkingrock = new WorldObject("AngryWalkingRock.png");
            
            if (world.rockcount == 0) {
                
                world.addObject(rock, 800, 300);    
                box.setText("There's a rock in the grass.");
                Greenfoot.delay(world.delay3);
                box.setText("What? It's a rock. Do you want me to say anything else?");
                box.setText("Maybe something stupid like how the rock is actually alive");
                box.setText("and only crudely speaks 3 words at a time??");
                Greenfoot.delay(world.delay3);
                box.setText("RICK THE ROCK: MY NAME RICK! I AM ROCK! RICK HAS EGG!");
                box.setText("RICK THE ROCK: RICK RAISE ROCK!");
                box.setText("Wow. That's actually kind of interesting.");
                box.setText("Maybe you could try getting some help from Ri-");
                Greenfoot.delay(world.delay4);
                box.setText("*thunk*");
                Greenfoot.playSound("thunk.mp3");
                Greenfoot.delay(world.delay3);
                world.removeObject(rock);
                world.addObject(world.angryrock, 800, 300);
                box.setText("I can't believe you would do that to poor Rick. Rick the Rock did nothing.");
                Greenfoot.delay(world.delay3);
                box.setText("RICK THE ROCK: WHY RICK KICKING? RICK HATCH EGG.");
                box.setText("RICK THE ROCK: NO RICK KICKING!");
                box.setText("Thankfully, Rick is a forgiving individual. Just apologize and move on.");
                world.addObject(uiButtonROCK1, atkx, actiony);
                world.addObject(uiButtonROCK2, magx, actiony);
                world.addObject(uiButtonROCK3, actx, actiony);
            }
            else if (world.rockcount == 1) {
                box.setText("*thunk*");
                Greenfoot.playSound("thunk.mp3");
                Greenfoot.delay(world.delay3);
                box.setText("Are you stupid? Rick gave you a chance and you blew it. ");
                box.setText("At least you only kicked him twice, and not something crazy");
                box.setText("like 100 times. Well, time to go- no.. you wouldn't...");
                Greenfoot.delay(world.delay3);
            }
            else if (world.rockcount > 1 && world.rockcount < 100) {
                box.setText("*thunk*");
                Greenfoot.playSound("thunk.mp3");
                world.rockStr += "!";
                box.setText(world.rockStr);
                
                
            }
            else if (world.rockcount == 100) {
                
                box.setText("RICK THE ROCK: MAKE RICK ANGRY! RICK RUN AWAY!");
                box.setText("RICK THE ROCK: RICK VERY SAD! YOU NO FRIEND!");
                Greenfoot.delay(world.delay2);
                world.removeObject(world.angryrock);
                world.addObject(angrywalkingrock, 800, 300);
                Greenfoot.delay(world.delay4);
                box.setText("Rick stands up and walks away, muttering to himself as he ");
                box.setText("disappears into the trees forever.");
                Greenfoot.delay(world.delay2);
                box.setText("RICK THE ROCK: WANT CARING EGG! WANTED HATCH EGG! ");
                box.setText("RICK THE ROCK: EGG NO HATCH!");
                
                for (int i = 0; i < 250; i++)
                {
                    angrywalkingrock.setLocation(800 + i, 300);
                    if (angrywalkingrock.isAtEdge()) {
                        world.removeObject(angrywalkingrock);
                        break;
                    }
                    Greenfoot.delay(1);
                }
            }
            else if (world.rockcount > 100) {
                if(world.rockcount == 101) {
                    world.getPlayer().addItem(new Item("Small Rock", 100));
                }
                box.setText("Wow, I feel bad for the guy. Congratulations- you're the worst");
                box.setText("human being on the planet. You made Rick leave behind his egg.");
                box.setText("You pick up the egg, which is really just a small rock.");
                
                world.removeObject(uiButtonROCK1); 
                world.removeObject(uiButtonROCK2);
                world.removeObject(uiButtonROCK3);
            }
            world.rockcount++;
        }
        else if (text.equals("SHOUT")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            box.setText("You yell in the cave, waking up angry orcs nearby.");
            int rand1 = (int) (Math.random() * 3) + 1;
            int rand2;
            int randx;
            int randy;
            Greenfoot.playSound("PlayerScream.mp3");
            for (int i = 0; i < rand1; i++)
            {
                rand2 = (int) (Math.random() * 3) + 1;
                randx = (int) (Math.random() * 50) + 750;
                randy = (int) (Math.random() * 300) + 150;
                if (rand2 == 1)
                {
                    world.addEnemy(new OrcCaptain(), randx, randy);
                }
                else if (rand2 == 2)
                {
                    world.addEnemy(new OrcKnight(), randx, randy);
                }
                else if (rand2 == 3)
                {
                    world.addEnemy(new OrcLegionary(), randx, randy);
                }
            }
            world.startCombat();
            world.shouted++;
        }
        else if (text.equals("MUSHROOM")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            String typestr;
            if (world.shroomcount == 0) {
                WorldObject mushrooms = new WorldObject("Mushroom.png");
                world.addObject(mushrooms, 800, 300);
                box.setText("There's a cluster of mushrooms with letters and symbols on them.");
                box.setText("It appears they can be pressed, much like a keyboard. But it's not.");
                Greenfoot.delay(world.delay5);
                box.setText("MUSHROOMS: Y0U 4RE AN EL1T3 TYP3R, YE5?");
                box.setText("MUSHROOMS: H3RE IS Y0UR CHAL1EN6E. USE TH3 MUSHR00MS. ");
                box.setText("MUSHROOMS: WE WILL G1VE Y0U TEXT TO WR1TE.");
                box.setText("MUSHROOMS: TYPE IT C0RRECT1Y OR F4CE THE C0NS3QUENC35.");
                Greenfoot.delay(world.delay1);
                box.setText("MUSHROOMS: THERE IS A T1ME LIM1T. USE Y0UR T1ME TO M3MORIZE.");
                Greenfoot.delay(world.delay5);
                box.setText("MUSHROOMS: PR0MPT 1:");
                box.setText("typing is easy. this challenge is trivial!");
                Greenfoot.delay(world.delay5);
                typestr = Greenfoot.ask("1. Enter your answer here:");
                if (typestr.equals("typing is easy. this challenge is trivial!")) {
                    box.setText("MUSHROOMS: C0NGRAT5, Y0U P4SS3D THE F1R5T TR14L.");
                    box.setText("MUSHROOMS: Y0UR R3W4RD 1S 10 C01N5.");
                    world.getPlayer().money(10);
                    box.setText("MUSHROOMS: THE N3XT CH4LL3NGE W1LL N0T BE 50 3A5Y.");
                    world.shroomcount++;
                    world.removeObject(mushrooms);
                }
                else {
                    typingFailure();
                    world.removeObject(mushrooms);
                }
            }
            else if (world.shroomcount == 1) {
                WorldObject mushrooms = new WorldObject("Mushroom.png");
                world.addObject(mushrooms, 800, 300);
                box.setText("MUSHROOMS: G00D. Y0U 4RE N0T AS 5TUP1D A5 THE LAST P3R50N.");
                box.setText("MUSHROOMS: PR0MPT 2:");
                Greenfoot.delay(world.delay5);
                box.setText("Y0U TH0UGHT TH1S W0ULD BE E4SY DjDN'T Y0U");
                Greenfoot.delay(world.delay5);
                Greenfoot.delay(world.delay5);
                typestr = Greenfoot.ask("2. Enter your answer here:");
                if (typestr.equals("Y0U TH0UGHT TH1S W0ULD BE E4SY DjDN'T Y0U")) {
                    box.setText("MUSHROOMS: C0NGRAT5, Y0U P4SS3D THE S3C0ND TR14L.");
                    box.setText("MUSHROOMS: Y0UR R3W4RD 1S 25 C0IN5.");
                    world.getPlayer().money(25);
                    box.setText("MUSHROOMS: 1T I5 T1M3 T0 UP THE D1FF1CULTY.");
                    world.shroomcount++;
                    world.removeObject(mushrooms);
                }
                else {
                    typingFailure();
                    world.removeObject(mushrooms);
                }
            }
            else if (world.shroomcount == 2) {
                WorldObject mushrooms = new WorldObject("Mushroom.png");
                world.addObject(mushrooms, 800, 300);
                box.setText("MUSHROOMS: F41LUR3 15 1MM1N3NT.");
                box.setText("MUSHROOMS: F1N4L PR0MPT:");
                Greenfoot.delay(world.delay5);
                box.setText("SERVICE MAGIC HAS A NETWORK OF LICENSED AND INSURED");
                box.setText("CONTRACTORS IN HUNDREDS OF HOME IMPROVEMENT CATEGORIES.");
                box.setText("IF YOU NEED A PAINTER, ELECTRICIAN, PLUMBER, OR ANY");
                box.setText("OTHER HOME SERVICE, VISIT FIXITFAST.SERVICEMAGIC.COM");
                Greenfoot.delay(world.delay5);
                Greenfoot.delay(world.delay5);
                Greenfoot.delay(world.delay5);
                typestr = Greenfoot.ask("3. Enter your answer here:");
                if (typestr.equals("SERVICE MAGIC HAS A NETWORK OF LICENSED AND INSURED CONTRACTORS IN HUNDREDS OF HOME IMPROVEMENT CATEGORIES. IF YOU NEED A PAINTER, ELECTRICIAN, PLUMBER, OR ANY OTHER HOME SERVICE, VISIT FIXITFAST.SERVICEMAGIC.COM")) {
                    box.setText("MUSHROOMS: WH4T THE H311. TH4T W45 5UPPO53D T0 BE 1MP0551BLE.");
                    
                    box.setText("The mushrooms crumble to dust, revealing 25 coins and some cool armor." );
                    world.getPlayer().money(25);
                    world.getPlayer().setArmor(MyWorld.chain);
                    world.shroomcount++;
                    world.removeObject(mushrooms);
                }
                else {
                    box.setText("You might just want to give up. Honestly. That's absurdly difficult.");
                    typingFailure();
                    world.removeObject(mushrooms);
                }
            }
            else {
                box.setText("The mushrooms have crumbled to dust. The only thing that remains is");
                box.setText("the faint scent of a CSA classroom somewhere in Michigan.");
            }
            
            //Greenfoot.delay(world.delay5);
            //box.setText("MUSHROOMS: ");
        }
        else if (text.equals("BATHTUB")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            if (world.tubcount == -1 ) {
                box.setText("Hey, that, right there, when you clicked on that button,");
                box.setText("was a bad sign. I just got major bad vibes from that button.");
                Greenfoot.delay(world.delay5);
                box.setText("That typically means it's not a good idea to interact");
                box.setText("with this again until you're ready to move forward.");
                box.setText("I'm warning you.");
                world.tubcount++;
            }
            else if (world.tubcount == 0) {
                
                world.addObject(uiButtonBATHTUB1, atkx, actiony);
                world.addObject(uiButtonBATHTUB2, magx, actiony);
                world.addObject(uiButtonBATHTUB3, itemx, actiony);
                world.addObject(bathtub1, 800, 300);
                box.setText("In the dim light of the cave, you make out the shape of a");
                box.setText("bathtub. It's an empty bathtub. That's it. That's all there is.");
                world.tubcount++;
            }
            else if (world.tubcount == 1 ) {
                box.setText("Dude, I'm telling you there's nothing in the tub.");
                box.setText("It's a white porcelain bathtub with those weird metal legs.");
                box.setText("There's also a drain that does nothing. That's ALL THERE IS.");
                world.tubcount++;
            }
            else if (world.tubcount == 2) {
                box.setText("No, you can't get in the bathtub.");
                world.tubcount++;
            }
            else if (world.tubcount == 3) {
                box.setText("No.");
                world.tubcount++;
            }
            else if (world.tubcount == 4) {
                box.setText("No, you can't. You're not a toddler.");
                world.tubcount++;
            }
            else if (world.tubcount == 5) {
                box.setText("No!");
                world.tubcount++;
            }
            else if (world.tubcount == 6) {
                box.setText("NO!");
                world.tubcount++;
            }
            else if (world.tubcount == 7) {
                box.setText("No, No, NO!");
                world.tubcount++;
            }
            else if (world.tubcount == 8) {
                box.setText("OH MY GOD! FINE! YOU GET INTO THE BATHTUB. HAPPY?");
                world.tubcount++;
            }
            else if (world.tubcount == 9) {
                box.setText("Now you're in the bathtub. Are you just going to sit there?");
                world.tubcount++;
            }
            else if (world.tubcount == 10) {
                box.setText("Fine. You can sit in the bathtub for as long as you want.");
                box.setText("I'm leaving. You can have me back when something interesting happens.");
                world.tubcount++;
            }
            else if (world.tubcount == 11) {
                box.setText("...");
                world.tubcount++;
            }
            else if (world.tubcount == 12) {
                box.setText("... ...");
                world.tubcount++;
            }
            else if (world.tubcount == 13) {
                box.setText("... ... ...");
                world.tubcount++;
            }
            else if (world.tubcount == 14) {
                box.setText("???: hI...");
                world.tubcount++;
            }
            else if (world.tubcount == 15) {
                box.setText("???: yOU liKe thE TUb, tOO?");
                world.tubcount++;
            }
            else if (world.tubcount == 16) {
                box.setText("???: i like the TUB....");
                world.tubcount++;
            }
            else if (world.tubcount == 17) {
                box.setText("???: i waNTed TO be a PART of the TUB forEVER...");
                world.tubcount++;
            }
            else if (world.tubcount == 18) {
                box.setText("???: so i sat IN THE tub... just like YOU..");
                box.setText("???: and it CHANGED me.. it HELPED me...");
                world.tubcount++;
            }
            else if (world.tubcount == 19) {
                box.setText("Hey, I'm back. What's going on? Who's doing the talking?");
                world.tubcount++;
            }
            else if (world.tubcount == 20) {
                box.setText("???: yOU and i wiLL BE BEST friends... forever...");
                world.tubcount++;
            }
            else if (world.tubcount == 21) {
                box.setText("Hey, I don't know who this is, but they're freaking me out.");
                box.setText("You need to get out of that tub. Now.");
                world.tubcount++;
            }
            else if (world.tubcount == 22) {
                box.setText("You stand up to leave just before a sticky black substance bubbles");
                box.setText("out of the tub's drain. It begins to eat away at the white paint, ");
                box.setText("leaving a black stain and emitting a putrid stench.");
                world.removeObject(bathtub1);
                world.addObject(bathtub2, 800, 300);
                Greenfoot.delay(world.delay4); 
                box.setText("As you get out of the tub, the black substance rises to the top");
                box.setText("It almost seems to flow out of the tub when it begins to");
                box.setText("rise even higher, forming a tall figure from the black goop.");
                Greenfoot.delay(world.delay4);
                world.addEnemy(new Abomination(), 800, 300); 
                box.setText("Oh my god, what IS that?");
                box.setText("???: WE COULD HAVE BEEN FRIENDS... THE GOO COULD HAVE SAVED YOU.");
                box.setText("???: THERE IS STILL TIME... COME... JOIN US.");
                Greenfoot.delay(world.delay4);
                box.setText("???: JOIN US! JOIN US! JOIN US! JOIN US! JOIN US! JOIN US! JOIN US! JOIN US! JOIN US! JOIN US! ");
                Greenfoot.delay(world.delay1);
                box.setText("???: JOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUS");
                Greenfoot.delay(world.delay1);
                box.setText("???: JOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUS");
                Greenfoot.delay(world.delay1);
                box.setText("???: JOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUS");
                Greenfoot.delay(world.delay1);
                box.setText("???: JOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUSJOINUS");
                Greenfoot.delay(world.delay1);
                box.setText("Ahh!!! Do something!!!!!");
                world.removeObject(bathtub2);
                world.removeObject(uiButtonBATHTUB1);
                world.removeObject(uiButtonBATHTUB2);
                world.removeObject(uiButtonBATHTUB3);
                world.startCombat();
                world.tubcount++;
            }
            else if (world.tubcount == 23) {
                box.setText("Oh my god. Oh my god. Oh my god. What was THAT???");
                box.setText("Okay! Next area! You're done here. We're done here. Never again.");
                box.setText("You got the STEEL PLATE for defeating the Abomination!");
                world.getPlayer().setArmor(MyWorld.plate);
                world.tubcount++;
            }
            else if (world.tubcount == 24) {
                Greenfoot.setWorld(new Town());
            }
            
        }                     
        else if (text.equals("ROCKS")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            if (world.rocksfought == 0) {
                box.setText("Hey, there are some pretty cool rocks in this cave.");
                Greenfoot.delay(world.delay2);
                box.setText("There's one sharp one sticking up from the ground.");
                Greenfoot.delay(world.delay3);
                box.setText("You know, I always liked rocks. Those stalactites");
                box.setText("are especially cool.");
                Greenfoot.delay(world.delay3);
                box.setText("What? Why are you looking at me like that?");
                Greenfoot.delay(world.delay2);
                box.setText("What do you mean? The ones that point upwards are the");
                box.setText("stalactites. The ones that come from the ceiling are");
                box.setText("stalagmites.");
                Greenfoot.delay(world.delay4);
                box.setText("No, you're wrong. The t in stalactite means tower,");
                box.setText("because they come up from the ground.");
                Greenfoot.delay(world.delay4);
                box.setText("\"You're wrong\"? What do you mean \"you're wrong\"? Fine!");
                box.setText("You can keep your stupid stalagmites");
                box.setText("I'm going to keep my stalactites. I hope you're happy.");
                Greenfoot.delay(world.delay4);
                world.addEnemy(new BlueTroll(), 800, 175);
                world.addEnemy(new GreenTroll(), 700, 275);
                world.addEnemy(new RedTroll(), 800, 375);
                box.setText("Great. A group of trolls has been standing there, confused,");
                box.setText("the ENTIRE TIME,");
                box.setText("watching you argue with a box of text. Now they're going");
                box.setText("to kill you because you were too stubborn to think about");
                Greenfoot.delay(world.delay2);
                box.setText("when to stop arguing with me.");
                Greenfoot.delay(world.delay2);
                world.rocksfought++;
                world.startCombat();
            }
            else {
                box.setText("No. We are not having this conversation again.");
            }
            

        } 

        else if (text.equals("HOWL")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            box.setText("You howl in the den filled with wolves. A brilliant choice!");
            int rand1 = (int) (Math.random() * 2) + 1;
            int rand2;
            int randx;
            int randy;
            Greenfoot.playSound("PlayerHowl.mp3");
            for (int i = 0; i < rand1; i++)
            {
                rand2 = (int) (Math.random() * 2) + 1;
                randx = (int) (Math.random() * 50) + 750;
                randy = (int) (Math.random() * 300) + 150;
                if (rand2 == 1)
                {
                    world.addEnemy(new Wolf(), randx, randy);
                    randx = (int) (Math.random() * 50) + 750;
                    randy = (int) (Math.random() * 300) + 150;
                    world.addEnemy(new Wolf(), randx, randy);
                }
                else if (rand2 == 2)
                {
                    world.addEnemy(new Direwolf(), randx, randy);
                }

            }
            world.startCombat();
        }
        else if (text.equals("SEARCH")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            if (!world.kissedwolf) {
                box.setText("You decide to sneak around groups of sleeping wolves.");
                box.setText("One wolf seems.. different? It isn't moving at all.");
                box.setText("Its eyes are wide open but it's barely breathing. It doesn't");
                box.setText("appear to be injured. Do you want to kiss it?");
                
                world.addObject(buttonWHAT, atkx, actiony);
                world.addObject(buttonKISS, magx, actiony);
                world.addObject(buttonSTEAL, actx, actiony);
                world.addObject(buttonBACK, itemx, actiony);
            }
            else {
                box.setText("You just got polio. Why would you want to come back to this?");
            }
            
        }
        else if (text.equals("WHAT?")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            box.setText("I don't know.. I figured based on your previous actions, you'd want");
            box.setText("to do something freaky like that. Finding strange ways to ruin normal");
            box.setText("things is kind of your style. So, just go for it! I won't stop you.");
        }
        else if (text.equals("KISS")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            if (world.kisscount == 0) {
                world.addObject(poliowolf, 800, 300);
                box.setText("You step closer to the wolf, your footsteps echoing softly");
                box.setText("off the stone walls. The flickering light from torches illuminates");
                box.setText("the wolf, lying upside-down, its legs unmoving, eyes fixed");
                box.setText("on you with a mixture of curiosity and sadness.");
                world.kisscount++;
            }
            else if (world.kisscount == 1) {
                box.setText("This wolf is not like the others. His paralyzed legs suggest a");
                box.setText("struggle against an illness, his fur matted and eyes dimmer than");
                box.setText("the rest. Despite his condition, he radiates a gentle aura, as if");
                box.setText("the universe had seen fit to bless him with a different kind of strength");
                //box.setText("strength.");
                world.kisscount++;
            }
            else if (world.kisscount == 2) {
                box.setText("You kneel beside the wolf, feeling a strange pull towards him, an");
                box.setText("empathy and connection you can't quite explain. His eyes meet");
                box.setText("yours, and you feel an overwhelming sense of intimacy and");
                box.setText("understanding. The wolf says something to you...");
                world.kisscount++;
            }
            else if (world.kisscount == 3) {
                box.setText("WOLF: shchrglepgbbfhth mmfffmfflrfprerpdr");
                world.kisscount++;
            }
            else if (world.kisscount == 4) {
                box.setText("WOLF: *gurgle* spfghrhuejuhuhuroobbbbllth scppglpdfpppthffgurp");
                world.kisscount++;
            }
            else if (world.kisscount == 5) {
                box.setText("Drawn by his romantic words, you lean in closer to the wolf. His");
                box.setText("eyes meet yours, a silent understanding passing between you.");
                Greenfoot.delay(world.delay1);
                box.setText("You feel the weight of his suffering, his strength, and his resilience.");
                Greenfoot.delay(world.delay1);
                box.setText("In this moment, you want to offer him something more, something");
                box.setText("that transcends words and gestures.");
                world.kisscount++;
            }
            else if (world.kisscount == 6) {
                box.setText("You close the distance, your heart pounding in your chest. As your");
                box.setText("lips meet the wolf's, the world around you seems to fade away.");
                Greenfoot.delay(world.delay1);
                box.setText("The kiss is gentle, a tender touch that conveys all the empathy and");
                box.setText("compassion you feel. It lasts a moment, but in that moment, a");
                box.setText("lifetime of unspoken words are shared.");
                world.kisscount++;
            }
            else if (world.kisscount == 7) {
                box.setText("His fur is soft against your skin, his breath warm. The kiss is not");
                box.setText("just an act of affection; it is a bridge between two beings who have");
                Greenfoot.delay(world.delay1);
                box.setText("found solace in each other's presence. As you pull away, his eyes");
                box.setText("reflect a profound gratitude, a silent thank you for acknowledging");
                box.setText("his existence and his struggle.");
                world.kisscount++;
            }
            else if (world.kisscount == 8) {
                box.setText("You sit back, your heart full, but a strange sensation begins to settle");
                box.setText("over you. You feel a tingling in your legs, a numbness that slowly");
                box.setText("spreads. It dawns on you that in your act of compassion, you have");
                box.setText("taken on part of his burden.");
                world.kisscount++;
            }
            else if (world.kisscount == 9) {
                box.setText("Congratulations, you got a new weapon, POLIO!");
                world.getPlayer().setWeapon(MyWorld.polio);
                world.removeObject(poliowolf);
                world.kissedwolf = true;
                world.kisscount++;
            }
            else if (world.kisscount == 10) {
                box.setText("Aww, that was so sweet! Except for the part where you got polio.");
            }
        }
        else if (text.equals("STEAL")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            if (!world.stolewolf) {
                box.setText("The wolf is laying on a set of armor, presumably from a fallen knight.");
                box.setText("The wolf helplessly mumbles as you steal its only possession.");
                box.setText("You got the KNIGHT ARMOR!");
                world.getPlayer().setArmor(MyWorld.knight);
                world.stolewolf = true;
            }
            else {
                box.setText("You've bothered the wolf enough.");
            }   
        }
        else if (text.equals("GO BACK")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            world.removeObject(buttonWHAT);
            world.removeObject(buttonKISS);
            world.removeObject(buttonSTEAL);
            world.removeObject(buttonBACK);
            
        }
        else if (text.equals("DOOR")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            if (world.doorcount == 0) {
                box.setText("You knock on the large door in the back of the den.");
                box.setText("You hear some shuffling behind the door, and a sheet of paper");
                box.setText("slides towards you from under the door.");
                Greenfoot.delay(world.delay2);
                box.setText("\"YOU ARE NOT YET WORTHY. WIN A GOLDEN TICKET AND\"");
                Greenfoot.delay(world.delay1);
                box.setText("\"INSERT IT INTO THE DOOR SLOT TO ENTER.\"");
                world.doorcount++;
            }
            else if (world.doorcount == 1) {
                box.setText("I'm sensing no good beyond this door. When you insert");
                box.setText("the golden ticket, you'd better be ready for anything.");
                box.setText("I'm warning you.");
                world.doorcount++;
            }
            else if (world.doorcount == 2 && !world.hasTicket) {
                box.setText("You don't have a golden ticket, silly. Maybe you could");
                box.setText("earn one from somewhere?");
            }
            else if (world.doorcount == 2 && world.hasTicket) { 
                box.setText("You slide the golden ticket into the door.");
                Greenfoot.delay(world.delay1);
                box.setText("The door disintegrates into a fine powder and you walk");
                box.setText("through the frame. Inside is an elegant office, littered with cash");
                box.setText("and other valuables and art. There are lots of \"motivational\" gambling");
                box.setText("posters on the walls. Sitting behind the wooden desk is a wolf.");
                Greenfoot.delay(world.delay5);
                box.setText("Not a regular wolf, no, not at all- he's wearing a tuxedo.");
                box.setText("He's got a black tophat, a monacle, and a stare that means business.");
                box.setText("The name plaque on his desk reads \"ILUV G. GERALD\"");
                Greenfoot.delay(world.delay4); 
                box.setText("I.G.GERALD: Well well well! What brings this delectable rabbit into"); 
                box.setText("I.G.GERALD: my quarters today? Little one, this fine establishment");
                box.setText("I.G.GERALD: has been passed down in the Gerald family for generations.");
                Greenfoot.delay(world.delay1);
                box.setText("I.G.GERALD: One day, my parents decided it was time");
                box.setText("I.G.GERALD: to hand this treasure down to me:");
                Greenfoot.delay(world.delay5);
                box.setText("I.G.GERALD: The great Iluv Gambling Gerald!");
                Greenfoot.delay(world.delay3);
                box.setText("I.G.GERALD: I'm sure you have noticed that our establishment is");
                box.setText("I.G.GERALD: of the highest quality and we strive to provide the");
                box.setText("I.G.GERALD: greatest experience for our prized guests. HOWEVER!");
                box.setText("I.G.GERALD: Casino machines are expensive!");
                Greenfoot.delay(world.delay1);
                box.setText("I.G.GERALD: it would be a shame to have to replace one...");
                Greenfoot.delay(world.delay4);
                box.setText("I.G.GERALD: If someone were to tamper with my things, I would get very");
                box.setText("I.G.GERALD: ANGRY.. and you, little rabbit, have done something...");
                Greenfoot.delay(world.delay3);
                box.setText("I.G.GERALD: unforgiveable. You have disgraced my family,");
                box.setText("I.G.GERALD: and I will cleanse the blood of the Gerald line");
                box.setText("I.G.GERALD: with your own! Come here, little rabbit!");
                box.setText("I.G.GERALD: Fortune will not save you now!");
                Greenfoot.delay(world.delay4);         
                world.addEnemy(new WolfBoss(), 800, 300);
                world.startCombat();
                world.doorcount++;
            }
            else if (world.doorcount == 3) {
                box.setText("You took down the wolf Iluv Gambling Gerald before you could become");
                box.setText("his prey! Press this button again to return to the town for the last time.");
                world.doorcount++;
            }
            else {
                Greenfoot.setWorld(new Town());
            }
        }
        else if (text.equals("SLOTS")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            if (!world.hasTicket) {
                if (world.slots == 0) {
                    box.setText("Amongst the dirt, rocks, and sleeping wolves, there's a flashy slot machine.");
                    box.setText("You recall that gambling is bad and you should always stay away from it.");
                    box.setText("buuuuuuuuuut... one little spin can't hurt, can it? You might win big!");
                    world.slots++;
                    
                    world.addObject(slotmachine, 300, 300);
                }
                else {
                    
                    
                    if (world.getPlayer().getMoney() > 0) {
                        box.setText("You take out a coin from your inventory and insert it into the machine.");
                        world.getPlayer().money(-1);
                    }
                    else {
                        box.setText("You take out a 1 coin loan from the wolf bank.");
                        world.getPlayer().money(-1);
                    }
                    int gamble = (int) (Math.random() * 40) + 1;
                    if (gamble == 1) {
                        box.setText("YOU WON!!!");
                        Greenfoot.delay(world.delay3);
                        box.setText("See? You should never quit, no matter what!");
                        Greenfoot.delay(world.delay3);
                        box.setText("A bajillion coins and a golden ticket fall out of the machine. You're rich!");
                        box.setText("Unfortunately, during your celebration, you slam into the slot machine");
                        box.setText("so hard that it begins to smoke and shake.");
                        box.setText("Suddenly, the machine explodes!");
                        world.removeObject(slotmachine);
                        Greenfoot.delay(world.delay3);
                        box.setText("Lucky for you, some of the coins and the ticket survived the blast.");
                        world.getPlayer().money(400);
                        world.hasTicket = true;
                    }
                    else {
                        box.setText("Aww, you didn't win.");
                        box.setText("Remember, 98% of gamblers walk away before they hit it big. Keep going!");
                    }
                    
                    
                }
            }
            else {
                box.setText("Looking at your reflection in the shards of what used to be a slot machine,");
                box.setText("you are reminded of your triumph over videogame RNG!");
                box.setText("Whoever owned this machine might not be so happy, though...");
            }
        }

        else if (text.equals("SHOP")) {

            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            box.setText("You can spend your money here. Buy something?");
            if(temp == null) {
                ShopGUI shop = new ShopGUI(3);
                temp = shop;
                world.addObject(temp, 500, 300);
                shop.createButtons(world);
                world.shopOpen = true;
            }
            else {
                temp.removeButtons(world);
                world.removeObject(temp);
                world.shopOpen = false;
                temp = null;
            }
        }
        else if (text.equals("CRAFT")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            box.setText("Unfortunately, this feature is unavailable.");
            box.setText("Please support us on Patreon if you want this to work!");
            world.getPlayer().addItem(new Item("Advertisement", 100));
        }

        else if (text.equals("EAT")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            if(world.hasEaten == false) {
                box.setText("There's a nice restaurant at the corner of the street. Your nose is filled");
                box.setText("with the scrumdiddlydumptious scent of pan-seared steak and other");
                box.setText("delightful meals.");
                Greenfoot.delay(world.delay5);
                box.setText("The scent is so captivating that your body lifts off the ground, and you");
                box.setText("float down the street towards the restaurant, in through the window, and");
                box.setText("into the kitchen, following the scent lines like a cartoon character.");
                Greenfoot.delay(world.delay5);
                box.setText("You vaccuum up a steak in the process of being cooked. One of the chefs");
                box.setText("says something to you, angrily, in French or something.");
                box.setText("You quickly run out of the kitchen before they catch and cook you.");
                box.setText("You healed 40 health!");
                world.getPlayer().heal(40);
                //box.setText("There are also health potions available at the shop.");
                world.hasEaten = true;
            }
            else {
                box.setText("You break back into the restaurant's kitchen and notice that the pan");
                box.setText("you stole from is, of course, empty. How could this have happened?");
                Greenfoot.delay(world.delay5);
                box.setText("The chefs promptly kick you out.");
            }
            
        }
        else if (text.equals("CONTINUE")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            if(P.areacount==1) {
                box.setText("To the CAVE!");
                Greenfoot.setWorld(new Cave());
            }
            if(P.areacount==2) {
                box.setText("To the WOLF DEN!");
                Greenfoot.setWorld(new WolfDen());
            }
            if(P.areacount==3) {
                box.setText("To the MOUNTAIN!");
                Greenfoot.setWorld(new Mountain());
            }
        }

        else if (text.equals("HEAL(100)")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            if (!world.healed) {
                box.setText("You healed 100 health.");
                world.getPlayer().money(-100);
                world.getPlayer().heal(100);
                world.healed = true;
            }
            else {
                box.setText("I can't heal you any more than that.");
            }
            
        }
        else if (text.equals("ADVANCE")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            Greenfoot.setWorld(new Edge());
        }
        else if (text.equals("KERMIT")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            world.addObject(new WorldObject("KermitTheFrog.png"),world.getWidth() / 2, world.getHeight() / 2);
        }
        else if (text.equals("")) {
            MyWorld world = (MyWorld) this.getWorld();
            TextBox box = world.getTextBox();
            box.setText("");
        }


        else {
            Greenfoot.playSound("PlayerScream.mp3"); // Play a sound as an example
        }

    }
    
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}