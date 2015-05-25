package com.dreamlock.core.menu;

import android.content.Context;
import com.dreamlock.core.GameUtils;
import com.dreamlock.core.HistoryController;
import com.dreamlock.core.game.GameContext;
import com.dreamlock.core.game.IGameContext;
import com.dreamlock.core.game.models.Player;
import com.dreamlock.core.game.models.Room;
import com.dreamlock.core.handlers.CommandHandler;
import com.dreamlock.core.handlers.ErrorHandler;
import com.dreamlock.core.handlers.IHandler;
import com.dreamlock.core.messageSystem.CommandMessages;
import com.dreamlock.core.messageSystem.GameMessages;
import com.dreamlock.core.messageSystem.MessageHandler;
import com.dreamlock.core.parser.Lexer;
import com.dreamlock.core.parser.Parser;
import com.dreamlock.core.parser.models.Lexeme;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StartNewGameChoice implements IMenuChoice {
    @Override
    public void run(Context context) throws IOException {
        GameUtils gameUtils = new GameUtils();
        Map<Integer,Room> rooms  = gameUtils.createNewStory(context);
        // Setup player
        Player player = gameUtils.createNewPlayer(context);
        final IGameContext gameContext = new GameContext(rooms, player);

        System.out.println(gameContext.getCurrentRoom().getDescription() + "\n");

        // Setup message handler
        GameMessages gameMessages = new GameMessages(player, rooms);
        CommandMessages commandMessages = CommandMessages.INSTANCE;
        MessageHandler messageHandler = new MessageHandler();
        messageHandler.register(gameMessages.getGameMessages());
        messageHandler.register(commandMessages.getCommandMessages());
        gameContext.setMessageHandler(messageHandler);

        Lexer lexer = new Lexer();
        Parser parser = new Parser();
        HistoryController historyController = new HistoryController(gameContext);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        while (gameContext.gameIsRunning()) {
            try {
                String line = buffer.readLine();

                ArrayList<Lexeme> lexemes = lexer.tokenize(line);
                JsonObject output =  parser.parse(lexemes);

                List<Integer> messageIds = null;
                IHandler handler;
                if (!output.get("error").getAsBoolean()) {
                    historyController.register(line);
                    if (historyController.handle() != null) {
                        messageIds = historyController.handle();
                        messageHandler.print(messageIds);
                        continue;
                    }
                    handler = new CommandHandler(output, gameContext);
                }
                else {
                    handler = new ErrorHandler(output, gameContext);
                }

                messageIds = handler.handle();
                messageHandler.print(messageIds);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
