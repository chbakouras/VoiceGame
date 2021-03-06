package com.dreamlock.core.messageSystem.constants;

import com.dreamlock.core.messageSystem.messages.IMessage;
import com.dreamlock.core.messageSystem.messages.stringMessage.NDEMessage;
import com.dreamlock.core.messageSystem.messages.stringMessage.NDMessage;
import com.dreamlock.core.messageSystem.messages.stringMessage.NDSMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum CommandMessages implements ICommandMessages{

    INSTANCE;

    CommandMessages() {
        commandMessages = new HashMap<>();

        commandMessages.put(0, new NDMessage());
        // for message handling
        commandMessages.put(10000, new NDMessage("",""));     // print only title
        commandMessages.put(10001, new NDMessage("",""));     // print only description
        commandMessages.put(10002, new NDMessage("\n",""));   // title new line
        commandMessages.put(10003, new NDMessage("","\n"));   // description new line
        commandMessages.put(10004, new NDMessage("",""));     // print title and description without new line
        commandMessages.put(10005, new NDSMessage("","",""));     //print stats
        commandMessages.put(10006, new NDEMessage("","",""));     // print with effect
        commandMessages.put(10007, new NDEMessage("","","\n"));     // effect new line

        // Go messages
        commandMessages.put(1001, new NDMessage("I can not go to ", ""));
        commandMessages.put(1002, new NDMessage("west", ""));
        commandMessages.put(1003, new NDMessage("north", ""));
        commandMessages.put(1004, new NDMessage("east", ""));
        commandMessages.put(1005, new NDMessage("south", ""));
        commandMessages.put(1006, new NDMessage("Door unlocked successfully!", ""));
        commandMessages.put(1007, new NDMessage("You turn the handle of the door, but it seems that the door is locked!", ""));
        commandMessages.put(1008, new NDMessage("Where do you want me to go?", ""));
        commandMessages.put(1009, new NDMessage("You cannot flee your current battle - Stand and fight!", ""));

        // Examine messages
        commandMessages.put(1020, new NDMessage("I can't find anything with that name!", ""));

        // Drop messages
        commandMessages.put(1040, new NDMessage(" dropped successfully!",""));
        commandMessages.put(1041, new NDMessage(" can't be dropped!",""));
        commandMessages.put(1042, new NDMessage("There is no such item in your inventory", ""));

        // Pick up messages
        commandMessages.put(1060, new NDMessage(" -> Added to inventory!",""));
        commandMessages.put(1061, new NDMessage(" -> You can not take that!",""));
        commandMessages.put(1062, new NDMessage("There is no such item, in this room", ""));
        commandMessages.put(1063, new NDMessage("This object is of no value to me", ""));

        // Show inventory messages
        commandMessages.put(1080, new NDMessage("You don't have any items in your inventory!",""));
        commandMessages.put(1081, new NDMessage("In your Inventory you have:",""));

        // Help messages
        commandMessages.put(1100, new NDMessage("Go <direction> -> ","Move around."));
        commandMessages.put(1101, new NDMessage("Examine <item> -> ","With this command tou can examine an item."));
        commandMessages.put(1102, new NDMessage("Drop <item> -> ","With this command you can drop items"));
        commandMessages.put(1103, new NDMessage("Inspect <item> -> ","This lets you inspect equipment statistics."));
        commandMessages.put(1104, new NDMessage("Look -> ","This will give you a full description of your location."));
        commandMessages.put(1105, new NDMessage("Open <item> with <item>-> ","Open an item with something"));
        commandMessages.put(1106, new NDMessage("Pick up <item> -> ","With this command you can pick up items"));
        commandMessages.put(1107, new NDMessage("Quit -> ","This lets you stop."));
        commandMessages.put(1108, new NDMessage("Save -> ","With this command you can save your game progress."));
        commandMessages.put(1109, new NDMessage("Reload -> ","Reloads your character's most recent saved game."));
        commandMessages.put(1110, new NDMessage("Inventory -> ","With this command you can view the items that are in your inventory. Alternate command: i."));
        commandMessages.put(1111, new NDMessage("Attack -> ","This lets you attack opponents."));
        commandMessages.put(1112, new NDMessage("Equip <item> -> ","This lets you equip items to your weapon and armor slots."));
        commandMessages.put(1113, new NDMessage("Unequip <item> -> ","This lets you unequip items from your weapon and armor slots."));
        commandMessages.put(1114, new NDMessage("Status -> ","This lets you view your character's status."));
        commandMessages.put(1114, new NDMessage("Use -> ","This lets you use consumable items. Alternate command: drink <item>."));
        commandMessages.put(1114, new NDMessage("Flee -> ","Try and flee from battle. Failure to do so will make you lose your turn and make enemies attack. Alternate command: run."));

        // Open messages
        commandMessages.put(1120, new NDMessage(" opened successfully!",""));
        commandMessages.put(1121, new NDMessage(" can't be opened!!",""));
        commandMessages.put(1122, new NDMessage(" is locked and requires a certain key to open!!",""));
        commandMessages.put(1123, new NDMessage(" is already opened!!",""));
        commandMessages.put(1124, new NDMessage("In the chest you find: ",""));
        commandMessages.put(1125, new NDMessage("You can't open it with this item, 'cause you don't have it!",""));
        commandMessages.put(1126, new NDMessage("You need a different key for this kind of lock",""));

        // Save messages
        commandMessages.put(1200, new NDMessage("Game was saved successfully!!",""));
        commandMessages.put(1201, new NDMessage("Save was not successful! :-(",""));
        commandMessages.put(1202, new NDMessage("Please specify a name for the save file, ex. save <filename>",""));

        // Load messages
        commandMessages.put(1210, new NDMessage("Loading completed successfully!!",""));
        commandMessages.put(1211, new NDMessage("Could not load game!! :-(",""));

        // Inspect messages
        commandMessages.put(1130, new NDMessage(" has an attack rating of ", ""));
        commandMessages.put(1131, new NDMessage(" has a defense rating of ",""));
        commandMessages.put(1132, new NDMessage(" cannot be equipped!",""));

        // Attack messages
        commandMessages.put(1301, new NDMessage(" was attacked for ",""));
        commandMessages.put(1302, new NDMessage(" attacked you. Remaining health points: ",""));
        commandMessages.put(1303, new NDMessage(" You have been bested in combat. GAME OVER.",""));
        commandMessages.put(1304, new NDMessage(" cannot be attacked!",""));
        commandMessages.put(1305, new NDMessage(" There is no such enemy here.",""));
        commandMessages.put(1306, new NDMessage(" That enemy is already dead.",""));
        commandMessages.put(1307, new NDMessage(" has died.",""));
        commandMessages.put(1308, new NDMessage(".",""));
        commandMessages.put(1309, new NDMessage(" points of damage.",""));
        commandMessages.put(1310, new NDMessage("All your enemies are dead, the battle is over!.",""));

        // Equip messages
        commandMessages.put(1401, new NDMessage(" was successfully equipped.",""));
        commandMessages.put(1402, new NDMessage(" was unequipped.",""));
        commandMessages.put(1403, new NDMessage(" is not an item that can be equipped!",""));

        // Drink/Eat messages
        commandMessages.put(1501, new NDMessage(" was successfully used!",""));
        commandMessages.put(1502, new NDMessage(" is not an item that can be drunk!",""));
        commandMessages.put(1503, new NDMessage(" is not an item that can be eaten!",""));

        // History messages
        commandMessages.put(1601, new NDMessage("I already did that.",""));
        commandMessages.put(1602, new NDMessage("Please stop making me repeat myself!",""));
        commandMessages.put(1603, new NDMessage("Type 'qq'!",""));
        commandMessages.put(1604, new NDMessage("Never mind I will do it for you...",""));

        // Flee messages
        commandMessages.put(1701, new NDMessage("You successfully fled the battle! Retreat into another room quickly!",""));
        commandMessages.put(1702, new NDMessage("You've missed your chance, the enemy strikes at the opportunity",""));
        commandMessages.put(1703, new NDMessage("There is nothing to flee from...",""));

        // Look messages
        commandMessages.put(1800, new NDMessage("I also can see an item:",""));
        commandMessages.put(1801, new NDMessage("I also can see some items:",""));
        commandMessages.put(1802, new NDMessage("It seems there is an enemy:",""));
        commandMessages.put(1803, new NDMessage("It seems there are some enemies:",""));
        commandMessages.put(1804, new NDMessage("There is a door: ",""));
        commandMessages.put(1805, new NDMessage("I can see doors:",""));

        // Use message
        commandMessages.put(1900, new NDMessage(" is not an item that can be used!",""));

        // General messages
        commandMessages.put(2001, new NDMessage("There more than one items with that name!", ""));
        commandMessages.put(2002, new NDMessage("There more than one doors with that name!", ""));
        commandMessages.put(2003, new NDMessage(" is locked.", ""));
        commandMessages.put(2004, new NDMessage(" is unlocked!", ""));
        commandMessages.put(2005, new NDMessage("History is empty.", ""));

        // Error messages
        commandMessages.put(2101, new NDMessage("I don't think I can do that", ""));
        commandMessages.put(2102, new NDMessage("Unexpected state error", ""));
        commandMessages.put(2103, new NDMessage("Shut your dirty mouth!", ""));
        commandMessages.put(2104, new NDMessage("Watch your mouth! who do you think you are.", ""));
        commandMessages.put(2105, new NDMessage("Hey, don't talk that way to me!", ""));
        commandMessages.put(2106, new NDMessage("Excuse me, but could you please watch you language?\nThis is a children's game!", ""));
        commandMessages.put(2107, new NDMessage("Profanity is strictly prohibited!", ""));

        // User replies
        commandMessages.put(2200, new NDMessage("Hi", ""));
        commandMessages.put(2201, new NDMessage("Why hello.", ""));

        commandMessages.put(2202, new NDMessage("Just dandy, thanks.", ""));
        commandMessages.put(2203, new NDMessage("I'm fine, thank you.", ""));

        commandMessages.put(2204, new NDMessage("That's none of your business!", ""));
        commandMessages.put(2205, new NDMessage("She's pretty good I guess.", ""));

        commandMessages.put(2206, new NDMessage("Your existence fears, do not concern me.", ""));

        commandMessages.put(2207, new NDMessage("It was a task from Master Petal in order to save humanity", ""));

        commandMessages.put(2208, new NDMessage("I do not understand your question", ""));
        commandMessages.put(2209, new NDMessage("I beg your pardon", ""));

        commandMessages.put(2210, new NDMessage("You should never ask a lady's age!", ""));

        commandMessages.put(2211, new NDMessage("My name is of no concern to you.", ""));
        commandMessages.put(2212, new NDMessage("My name is Hestia", ""));


        // Quit messages
        commandMessages.put(5000, new NDMessage("Quiting to Main Menu", ""));
    }

    private final Map<Integer, IMessage> commandMessages;

    @Override
    public IMessage getCommandMessage(Integer messageId) {
        return this.commandMessages.get(messageId);
    }

    @Override
    public Map<Integer, IMessage> getCommandMessages() {
        return commandMessages;
    }

    @Override
    public Set<Integer> getDefinedCommandMessages() {
        return this.commandMessages.keySet();
    }
}
