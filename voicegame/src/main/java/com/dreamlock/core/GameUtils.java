package com.dreamlock.core;

import android.content.Context;
import android.os.Environment;
import com.dreamlock.core.game.GameContext;
import com.dreamlock.core.game.IGameContext;
import com.dreamlock.core.game.jsonParser.JsonParser;
import com.dreamlock.core.game.models.Inventory;
import com.dreamlock.core.game.models.Player;
import com.dreamlock.core.game.models.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameUtils {

    public Player createNewPlayer(Context context) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        JsonParser jsonParser = new JsonParser(context);
        String[] opening = jsonParser.parseOpening("openings/dreamlock_opening.json");

        do try {
            name = buffer.readLine();
            if (name.equals("")) {
                System.out.println("Hint: Type your name.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (name.equals(""));

        System.out.println("Ah, " + name + opening[1] + "\n");
        return new Player(name,new Inventory(20));
    }

    public Map<Integer, Room> createNewStory(Context context) throws IOException {
        JsonParser jsonParser = new JsonParser(context);
        jsonParser.parseWorld("story.json");
        return jsonParser.getRooms();
    }

    public IGameContext LoadStory() {
        File folder = new File(Environment.getExternalStorageDirectory()+"/VoiceGame/saves/");
        File[] listOfFiles = folder.listFiles();
        if (!folder.exists() || listOfFiles.length == 0) {
            System.out.println("There are no saved games to load from!!");
            try {
                System.out.println("Press Enter to continue...");
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        else {
            System.out.println("Saved Characters Profiles:");
            System.out.println("---------------------------");
            List<String> listFileNames = new ArrayList<>();
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    System.out.println(listOfFile.getName().replace(".dat", "") + "\t");
                    listFileNames.add(listOfFile.getName());
                }
            }

            GameContext LoadedGameContext = null;

            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            try {
                boolean found = false;

                do {
                    System.out.print("Which character's game would you like to load? : ");
                    String input = buffer.readLine();
                    for (String filename : listFileNames) {
                        if (filename.replace(".dat", "").toLowerCase().equals(input.toLowerCase())) {
                            found = true;
                            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("saves/" + filename));
                            try {
                                LoadedGameContext = (GameContext) inputStream.readObject();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                            inputStream.close();
                        }
                    }
                } while (!found);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return LoadedGameContext;
        }
    }
}
