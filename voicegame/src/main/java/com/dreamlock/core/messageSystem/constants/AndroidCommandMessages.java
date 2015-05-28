package com.dreamlock.core.messageSystem.constants;


import com.dreamlock.core.messageSystem.ISoundMessage;
import com.dreamlock.core.messageSystem.SoundNDEMessage;
import com.dreamlock.core.messageSystem.SoundNDMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum  AndroidCommandMessages {
    INSTANCE;

    AndroidCommandMessages() {
        commandMessages = new HashMap<>();

        commandMessages.put(0, new SoundNDMessage());
        // for message handling
        commandMessages.put(10000, new SoundNDMessage("","", "", ""));     // print only title
        commandMessages.put(10001, new SoundNDMessage("","", "", ""));     // print only description
        commandMessages.put(10002, new SoundNDMessage("\n","","",""));   // title new line
        commandMessages.put(10003, new SoundNDMessage("","\n","",""));   // description new line
        commandMessages.put(10004, new SoundNDMessage("","", "", ""));     // print title and description without new line
        commandMessages.put(10006, new SoundNDEMessage("","","","", "", ""));     // print with effect
        commandMessages.put(10007, new SoundNDEMessage("","","\n", "", "", ""));     // effect new line

        // Go messages
        commandMessages.put(1001, new SoundNDMessage("I can not go to ", "", "", ""));
        commandMessages.put(1002, new SoundNDMessage("west", "", "", ""));
        commandMessages.put(1003, new SoundNDMessage("north", "", "", ""));
        commandMessages.put(1004, new SoundNDMessage("east", "", "", ""));
        commandMessages.put(1005, new SoundNDMessage("south", "", "", ""));
        commandMessages.put(1006, new SoundNDMessage("Door unlocked successfully!", "", "", ""));
        commandMessages.put(1007, new SoundNDMessage("You turn the handle of the door, but it seems that the door is locked!", "", "", ""));
        commandMessages.put(1008, new SoundNDMessage("Where do you want me to go?", "", "", ""));
        commandMessages.put(1009, new SoundNDMessage("You cannot flee your current battle - Stand and fight!", "", "", ""));

        // Examine messages
        commandMessages.put(1020, new SoundNDMessage("I can't find anything with that name!", "", "", ""));

        // Drop messages
        commandMessages.put(1040, new SoundNDMessage(" dropped successfully!","", "", ""));
        commandMessages.put(1041, new SoundNDMessage(" can't be dropped!","", "", ""));
        commandMessages.put(1042, new SoundNDMessage("There is no such item in your inventory", "", "", ""));

        // Pick up messages
        commandMessages.put(1060, new SoundNDMessage(" -> Added to inventory!","", "", ""));
        commandMessages.put(1061, new SoundNDMessage(" -> You can not take that!","", "", ""));
        commandMessages.put(1062, new SoundNDMessage("There is no such item, in this room", "", "", ""));
        commandMessages.put(1063, new SoundNDMessage("This object is of no value to me", "", "", ""));

        // Show inventory messages
        commandMessages.put(1080, new SoundNDMessage("You don't have any items in your inventory!","", "", ""));
        commandMessages.put(1081, new SoundNDMessage("In your Inventory you have:","", "", ""));

        // Help messages
        commandMessages.put(1100, new SoundNDMessage("Go <direction> -> ","Move around.", "", ""));
        commandMessages.put(1101, new SoundNDMessage("Examine <item> -> ","With this command tou can examine an item.", "", ""));
        commandMessages.put(1102, new SoundNDMessage("Drop <item> -> ","With this command you can drop items", "", ""));
        commandMessages.put(1103, new SoundNDMessage("Inspect <item> -> ","This lets you inspect equipment statistics.", "", ""));
        commandMessages.put(1104, new SoundNDMessage("Look -> ","This will give you a full description of your location.", "", ""));
        commandMessages.put(1105, new SoundNDMessage("Open <item> with <item>-> ","Open an item with something", "", ""));
        commandMessages.put(1106, new SoundNDMessage("Pick up <item> -> ","With this command you can pick up items", "", ""));
        commandMessages.put(1107, new SoundNDMessage("Quit -> ","This lets you stop.", "", ""));
        commandMessages.put(1108, new SoundNDMessage("Save -> ","With this command you can save your game progress.", "", ""));
        commandMessages.put(1109, new SoundNDMessage("Reload -> ","Reloads your character's most recent saved game.", "", ""));
        commandMessages.put(1110, new SoundNDMessage("Inventory -> ","With this command you can view the items that are in your inventory. Alternate command: i.", "", ""));
        commandMessages.put(1111, new SoundNDMessage("Attack -> ","This lets you attack opponents.", "", ""));
        commandMessages.put(1112, new SoundNDMessage("Equip <item> -> ","This lets you equip items to your weapon and armor slots.", "", ""));
        commandMessages.put(1113, new SoundNDMessage("Unequip <item> -> ","This lets you unequip items from your weapon and armor slots.", "", ""));
        commandMessages.put(1114, new SoundNDMessage("Status -> ","This lets you view your character's status.", "", ""));
        commandMessages.put(1114, new SoundNDMessage("Use -> ","This lets you use consumable items. Alternate command: drink <item>.", "", ""));
        commandMessages.put(1114, new SoundNDMessage("Flee -> ","Try and flee from battle. Failure to do so will make you lose your turn and make enemies attack. Alternate command: run.", "", ""));

        // Open messages
        commandMessages.put(1120, new SoundNDMessage(" opened successfully!","", "", ""));
        commandMessages.put(1121, new SoundNDMessage(" can't be opened!!","", "", ""));
        commandMessages.put(1122, new SoundNDMessage(" is locked and requires a certain key to open!!","", "", ""));
        commandMessages.put(1123, new SoundNDMessage(" is already opened!!","", "", ""));
        commandMessages.put(1124, new SoundNDMessage("In the chest you find: ","", "", ""));
        commandMessages.put(1125, new SoundNDMessage("You can't open it with this item, 'cause you don't have it!","", "", ""));
        commandMessages.put(1126, new SoundNDMessage("You need a different key for this kind of lock","", "", ""));

        // Save messages
        commandMessages.put(1200, new SoundNDMessage("Game was saved successfully!!","","sounds/commands/save/testSound.ogg",""));
        commandMessages.put(1201, new SoundNDMessage("Save was not successful! :-(","","sounds/commands/save/testSound.ogg",""));
        commandMessages.put(1202, new SoundNDMessage("Please specify a name for the save file, ex. save <filename>","", "", ""));

        // Load messages
        commandMessages.put(1210, new SoundNDMessage("Loading completed successfully!!","", "", ""));
        commandMessages.put(1211, new SoundNDMessage("Could not load game!! :-(","", "", ""));

        // Inspect messages
        commandMessages.put(1130, new SoundNDMessage(" has an attack rating of ", "", "", ""));
        commandMessages.put(1131, new SoundNDMessage(" has a defense rating of ","", "", ""));
        commandMessages.put(1132, new SoundNDMessage(" cannot be equipped!","", "", ""));

        // Attack messages
        commandMessages.put(1301, new SoundNDMessage(" was attacked for ","", "", ""));
        commandMessages.put(1302, new SoundNDMessage(" attacked you. Remaining health points: ","", "", ""));
        commandMessages.put(1303, new SoundNDMessage(" You have been bested in combat. GAME OVER.","", "", ""));
        commandMessages.put(1304, new SoundNDMessage(" cannot be attacked!","", "", ""));
        commandMessages.put(1305, new SoundNDMessage(" There is no such enemy here.","", "", ""));
        commandMessages.put(1306, new SoundNDMessage(" That enemy is already dead.","", "", ""));
        commandMessages.put(1307, new SoundNDMessage(" has died.","", "", ""));
        commandMessages.put(1308, new SoundNDMessage(".","", "", ""));
        commandMessages.put(1309, new SoundNDMessage(" points of damage.","", "", ""));
        commandMessages.put(1310, new SoundNDMessage("All your enemies are dead, the battle is over!.","", "", ""));

        // Equip messages
        commandMessages.put(1401, new SoundNDMessage(" was successfully equipped.","", "", ""));
        commandMessages.put(1402, new SoundNDMessage(" was unequipped.","", "", ""));
        commandMessages.put(1403, new SoundNDMessage(" is not an item that can be equipped!","", "", ""));

        // Drink/Eat messages
        commandMessages.put(1501, new SoundNDMessage(" was successfully used!","", "", ""));
        commandMessages.put(1502, new SoundNDMessage(" is not an item that can be drunk!","", "", ""));
        commandMessages.put(1503, new SoundNDMessage(" is not an item that can be eaten!","", "", ""));

        // History messages
        commandMessages.put(1601, new SoundNDMessage("I already did that.","", "", ""));
        commandMessages.put(1602, new SoundNDMessage("Please stop making me repeat myself!","", "", ""));
        commandMessages.put(1603, new SoundNDMessage("Type 'qq'!","", "", ""));
        commandMessages.put(1604, new SoundNDMessage("Never mind I will do it for you...","", "", ""));

        // Flee messages
        commandMessages.put(1701, new SoundNDMessage("You successfully fled the battle! Retreat into another room quickly!","", "", ""));
        commandMessages.put(1702, new SoundNDMessage("You've missed your chance, the enemy strikes at the opportunity","", "", ""));
        commandMessages.put(1703, new SoundNDMessage("There is nothing to flee from...","", "", ""));

        // Look messages
        commandMessages.put(1800, new SoundNDMessage("I also can see an item:","", "", ""));
        commandMessages.put(1801, new SoundNDMessage("I also can see some items:","", "", ""));
        commandMessages.put(1802, new SoundNDMessage("It seems there is an enemy:","", "", ""));
        commandMessages.put(1803, new SoundNDMessage("It seems there are some enemies:","", "", ""));
        commandMessages.put(1804, new SoundNDMessage("There is a door: ","", "", ""));
        commandMessages.put(1805, new SoundNDMessage("I can see doors:","", "", ""));

        // Use message
        commandMessages.put(1900, new SoundNDMessage(" is not an item that can be used!","", "", ""));

        // General messages
        commandMessages.put(2001, new SoundNDMessage("There more than one items with that name!", "", "", ""));
        commandMessages.put(2002, new SoundNDMessage("There more than one doors with that name!", "", "", ""));
        commandMessages.put(2003, new SoundNDMessage(" is locked.", "", "", ""));
        commandMessages.put(2004, new SoundNDMessage(" is unlocked!", "", "", ""));
        commandMessages.put(2005, new SoundNDMessage("History is empty.", "", "", ""));

        // Error messages
        commandMessages.put(2101, new SoundNDMessage("I don't think I can do that", "", "", ""));
        commandMessages.put(2102, new SoundNDMessage("Unexpected state error", "", "", ""));
        commandMessages.put(2103, new SoundNDMessage("Shut your dirty mouth!", "", "", ""));
        commandMessages.put(2104, new SoundNDMessage("Watch your mouth! who do you think you are.", "", "", ""));
        commandMessages.put(2105, new SoundNDMessage("Hey, don't talk that way to me!", "", "", ""));
        commandMessages.put(2106, new SoundNDMessage("Excuse me, but could you please watch you language?\nThis is a children's game!", "", "", ""));
        commandMessages.put(2107, new SoundNDMessage("Profanity is strictly prohibited!", "", "", ""));

        // User replies
        commandMessages.put(2200, new SoundNDMessage("Hi", "", "", ""));
        commandMessages.put(2201, new SoundNDMessage("Why hello.", "", "", ""));

        commandMessages.put(2202, new SoundNDMessage("Just dandy, thanks.", "", "", ""));
        commandMessages.put(2203, new SoundNDMessage("I'm fine, thank you.", "", "", ""));

        commandMessages.put(2204, new SoundNDMessage("That's none of your business!", "", "", ""));
        commandMessages.put(2205, new SoundNDMessage("She's pretty good I guess.", "", "", ""));

        commandMessages.put(2206, new SoundNDMessage("Your existence fears, do not concern me.", "", "", ""));

        commandMessages.put(2207, new SoundNDMessage("It was a task from Master Petal in order to save humanity", "", "", ""));

        commandMessages.put(2208, new SoundNDMessage("I do not understand your question", "", "", ""));
        commandMessages.put(2209, new SoundNDMessage("I beg your pardon", "", "", ""));

        commandMessages.put(2210, new SoundNDMessage("You should never ask a lady's age!", "", "", ""));

        commandMessages.put(2211, new SoundNDMessage("My name is of no concern to you.", "", "", ""));
        commandMessages.put(2212, new SoundNDMessage("My name is Hestia", "", "", ""));


        // Quit messages
        commandMessages.put(5000, new SoundNDMessage("Quiting to Main Menu", "", "", ""));
    }

    private final Map<Integer, ISoundMessage> commandMessages;

    public ISoundMessage getCommandMessage(Integer messageId) {
        return this.commandMessages.get(messageId);
    }

    public Map<Integer, ISoundMessage> getCommandMessages() {
        return commandMessages;
    }

    public Set<Integer> getDefinedCommandMessages() {
        return this.commandMessages.keySet();
    }
}
