package com.dreamlock.core.messageSystem.constants;


import com.dreamlock.core.messageSystem.messages.soundMessage.ISoundMessage;
import com.dreamlock.core.messageSystem.messages.soundMessage.SoundMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum  AndroidCommandMessages {
    INSTANCE;

    AndroidCommandMessages() {
        commandMessages = new HashMap<>();

        commandMessages.put(0, new SoundMessage());
        // for message handling
        commandMessages.put(10000, new SoundMessage("","", "", ""));     // print only title
        commandMessages.put(10001, new SoundMessage("","", "", ""));     // print only description
        commandMessages.put(10002, new SoundMessage("\n","","",""));   // title new line
        commandMessages.put(10003, new SoundMessage("","\n","",""));   // description new line
        commandMessages.put(10004, new SoundMessage("","", "", ""));     // print title and description without new line
        commandMessages.put(10006, new SoundMessage("","","","", "", ""));     // print with effect
        commandMessages.put(10007, new SoundMessage("","","\n", "", "", ""));     // effect new line

        // Go messages
        commandMessages.put(1001, new SoundMessage("I can not go to ", "", "", ""));
        commandMessages.put(1002, new SoundMessage("west", "", "", ""));
        commandMessages.put(1003, new SoundMessage("north", "", "", ""));
        commandMessages.put(1004, new SoundMessage("east", "", "", ""));
        commandMessages.put(1005, new SoundMessage("south", "", "", ""));
        commandMessages.put(1006, new SoundMessage("Door unlocked successfully!", "", "", ""));
        commandMessages.put(1007, new SoundMessage("You turn the handle of the door, but it seems that the door is locked!", "", "", ""));
        commandMessages.put(1008, new SoundMessage("Where do you want me to go?", "", "", ""));
        commandMessages.put(1009, new SoundMessage("You cannot flee your current battle - Stand and fight!", "", "", ""));

        // Examine messages
        commandMessages.put(1020, new SoundMessage("I can't find anything with that name!", "", "", ""));

        // Drop messages
        commandMessages.put(1040, new SoundMessage(" dropped successfully!","", "", ""));
        commandMessages.put(1041, new SoundMessage(" can't be dropped!","", "", ""));
        commandMessages.put(1042, new SoundMessage("There is no such item in your inventory", "", "", ""));

        // Pick up messages
        commandMessages.put(1060, new SoundMessage(" -> Added to inventory!","", "", ""));
        commandMessages.put(1061, new SoundMessage(" -> You can not take that!","", "", ""));
        commandMessages.put(1062, new SoundMessage("There is no such item, in this room", "", "", ""));
        commandMessages.put(1063, new SoundMessage("This object is of no value to me", "", "", ""));

        // Show inventory messages
        commandMessages.put(1080, new SoundMessage("You don't have any items in your inventory!","", "", ""));
        commandMessages.put(1081, new SoundMessage("In your Inventory you have:","", "", ""));

        // Help messages
        commandMessages.put(1100, new SoundMessage("Go <direction> -> ","Move around.", "", ""));
        commandMessages.put(1101, new SoundMessage("Examine <item> -> ","With this command tou can examine an item.", "", ""));
        commandMessages.put(1102, new SoundMessage("Drop <item> -> ","With this command you can drop items", "", ""));
        commandMessages.put(1103, new SoundMessage("Inspect <item> -> ","This lets you inspect equipment statistics.", "", ""));
        commandMessages.put(1104, new SoundMessage("Look -> ","This will give you a full description of your location.", "", ""));
        commandMessages.put(1105, new SoundMessage("Open <item> with <item>-> ","Open an item with something", "", ""));
        commandMessages.put(1106, new SoundMessage("Pick up <item> -> ","With this command you can pick up items", "", ""));
        commandMessages.put(1107, new SoundMessage("Quit -> ","This lets you stop.", "", ""));
        commandMessages.put(1108, new SoundMessage("Save -> ","With this command you can save your game progress.", "", ""));
        commandMessages.put(1109, new SoundMessage("Reload -> ","Reloads your character's most recent saved game.", "", ""));
        commandMessages.put(1110, new SoundMessage("Inventory -> ","With this command you can view the items that are in your inventory. Alternate command: i.", "", ""));
        commandMessages.put(1111, new SoundMessage("Attack -> ","This lets you attack opponents.", "", ""));
        commandMessages.put(1112, new SoundMessage("Equip <item> -> ","This lets you equip items to your weapon and armor slots.", "", ""));
        commandMessages.put(1113, new SoundMessage("Unequip <item> -> ","This lets you unequip items from your weapon and armor slots.", "", ""));
        commandMessages.put(1114, new SoundMessage("Status -> ","This lets you view your character's status.", "", ""));
        commandMessages.put(1114, new SoundMessage("Use -> ","This lets you use consumable items. Alternate command: drink <item>.", "", ""));
        commandMessages.put(1114, new SoundMessage("Flee -> ","Try and flee from battle. Failure to do so will make you lose your turn and make enemies attack. Alternate command: run.", "", ""));

        // Open messages
        commandMessages.put(1120, new SoundMessage(" opened successfully!","", "", ""));
        commandMessages.put(1121, new SoundMessage(" can't be opened!!","", "", ""));
        commandMessages.put(1122, new SoundMessage(" is locked and requires a certain key to open!!","", "", ""));
        commandMessages.put(1123, new SoundMessage(" is already opened!!","", "", ""));
        commandMessages.put(1124, new SoundMessage("In the chest you find: ","", "", ""));
        commandMessages.put(1125, new SoundMessage("You can't open it with this item, 'cause you don't have it!","", "", ""));
        commandMessages.put(1126, new SoundMessage("You need a different key for this kind of lock","", "", ""));

        // Save messages
        commandMessages.put(1200, new SoundMessage("Game was saved successfully!!","","sounds/commands/save/testSound.ogg",""));
        commandMessages.put(1201, new SoundMessage("Save was not successful! :-(","","sounds/commands/save/testSound.ogg",""));
        commandMessages.put(1202, new SoundMessage("Please specify a name for the save file, ex. save <filename>","", "", ""));

        // Load messages
        commandMessages.put(1210, new SoundMessage("Loading completed successfully!!","", "", ""));
        commandMessages.put(1211, new SoundMessage("Could not load game!! :-(","", "", ""));

        // Inspect messages
        commandMessages.put(1130, new SoundMessage(" has an attack rating of ", "", "", ""));
        commandMessages.put(1131, new SoundMessage(" has a defense rating of ","", "", ""));
        commandMessages.put(1132, new SoundMessage(" cannot be equipped!","", "", ""));

        // Attack messages
        commandMessages.put(1301, new SoundMessage(" was attacked for ","", "", ""));
        commandMessages.put(1302, new SoundMessage(" attacked you. Remaining health points: ","", "", ""));
        commandMessages.put(1303, new SoundMessage(" You have been bested in combat. GAME OVER.","", "", ""));
        commandMessages.put(1304, new SoundMessage(" cannot be attacked!","", "", ""));
        commandMessages.put(1305, new SoundMessage(" There is no such enemy here.","", "", ""));
        commandMessages.put(1306, new SoundMessage(" That enemy is already dead.","", "", ""));
        commandMessages.put(1307, new SoundMessage(" has died.","", "", ""));
        commandMessages.put(1308, new SoundMessage(".","", "", ""));
        commandMessages.put(1309, new SoundMessage(" points of damage.","", "", ""));
        commandMessages.put(1310, new SoundMessage("All your enemies are dead, the battle is over!.","", "", ""));

        // Equip messages
        commandMessages.put(1401, new SoundMessage(" was successfully equipped.","", "", ""));
        commandMessages.put(1402, new SoundMessage(" was unequipped.","", "", ""));
        commandMessages.put(1403, new SoundMessage(" is not an item that can be equipped!","", "", ""));

        // Drink/Eat messages
        commandMessages.put(1501, new SoundMessage(" was successfully used!","", "", ""));
        commandMessages.put(1502, new SoundMessage(" is not an item that can be drunk!","", "", ""));
        commandMessages.put(1503, new SoundMessage(" is not an item that can be eaten!","", "", ""));

        // History messages
        commandMessages.put(1601, new SoundMessage("I already did that.","", "", ""));
        commandMessages.put(1602, new SoundMessage("Please stop making me repeat myself!","", "", ""));
        commandMessages.put(1603, new SoundMessage("Type 'qq'!","", "", ""));
        commandMessages.put(1604, new SoundMessage("Never mind I will do it for you...","", "", ""));

        // Flee messages
        commandMessages.put(1701, new SoundMessage("You successfully fled the battle! Retreat into another room quickly!","", "", ""));
        commandMessages.put(1702, new SoundMessage("You've missed your chance, the enemy strikes at the opportunity","", "", ""));
        commandMessages.put(1703, new SoundMessage("There is nothing to flee from...","", "", ""));

        // Look messages
        commandMessages.put(1800, new SoundMessage("I also can see an item:","", "", ""));
        commandMessages.put(1801, new SoundMessage("I also can see some items:","", "", ""));
        commandMessages.put(1802, new SoundMessage("It seems there is an enemy:","", "", ""));
        commandMessages.put(1803, new SoundMessage("It seems there are some enemies:","", "", ""));
        commandMessages.put(1804, new SoundMessage("There is a door: ","", "", ""));
        commandMessages.put(1805, new SoundMessage("I can see doors:","", "", ""));

        // Use message
        commandMessages.put(1900, new SoundMessage(" is not an item that can be used!","", "", ""));

        // General messages
        commandMessages.put(2001, new SoundMessage("There more than one items with that name!", "", "", ""));
        commandMessages.put(2002, new SoundMessage("There more than one doors with that name!", "", "", ""));
        commandMessages.put(2003, new SoundMessage(" is locked.", "", "", ""));
        commandMessages.put(2004, new SoundMessage(" is unlocked!", "", "", ""));
        commandMessages.put(2005, new SoundMessage("History is empty.", "", "", ""));

        // Error messages
        commandMessages.put(2101, new SoundMessage("I don't think I can do that", "", "", ""));
        commandMessages.put(2102, new SoundMessage("Unexpected state error", "", "", ""));
        commandMessages.put(2103, new SoundMessage("Shut your dirty mouth!", "", "", ""));
        commandMessages.put(2104, new SoundMessage("Watch your mouth! who do you think you are.", "", "", ""));
        commandMessages.put(2105, new SoundMessage("Hey, don't talk that way to me!", "", "", ""));
        commandMessages.put(2106, new SoundMessage("Excuse me, but could you please watch you language?\nThis is a children's game!", "", "", ""));
        commandMessages.put(2107, new SoundMessage("Profanity is strictly prohibited!", "", "", ""));

        // User replies
        commandMessages.put(2200, new SoundMessage("Hi", "", "", ""));
        commandMessages.put(2201, new SoundMessage("Why hello.", "", "", ""));

        commandMessages.put(2202, new SoundMessage("Just dandy, thanks.", "", "", ""));
        commandMessages.put(2203, new SoundMessage("I'm fine, thank you.", "", "", ""));

        commandMessages.put(2204, new SoundMessage("That's none of your business!", "", "", ""));
        commandMessages.put(2205, new SoundMessage("She's pretty good I guess.", "", "", ""));

        commandMessages.put(2206, new SoundMessage("Your existence fears, do not concern me.", "", "", ""));

        commandMessages.put(2207, new SoundMessage("It was a task from Master Petal in order to save humanity", "", "", ""));

        commandMessages.put(2208, new SoundMessage("I do not understand your question", "", "", ""));
        commandMessages.put(2209, new SoundMessage("I beg your pardon", "", "", ""));

        commandMessages.put(2210, new SoundMessage("You should never ask a lady's age!", "", "", ""));

        commandMessages.put(2211, new SoundMessage("My name is of no concern to you.", "", "", ""));
        commandMessages.put(2212, new SoundMessage("My name is Hestia", "", "", ""));


        // Quit messages
        commandMessages.put(5000, new SoundMessage("Quiting to Main Menu", "", "", ""));
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
