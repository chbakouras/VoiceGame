package com.dreamlock.voicegame;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.dreamlock.core.GameUtils;
import com.dreamlock.core.HistoryController;
import com.dreamlock.core.game.GameContext;
import com.dreamlock.core.game.IGameContext;
import com.dreamlock.core.game.jsonParser.JsonParser;
import com.dreamlock.core.game.models.Inventory;
import com.dreamlock.core.game.models.Player;
import com.dreamlock.core.game.models.Room;
import com.dreamlock.core.handlers.CommandHandler;
import com.dreamlock.core.handlers.ErrorHandler;
import com.dreamlock.core.handlers.IHandler;
import com.dreamlock.core.messageSystem.AndroidMessageHandler;
import com.dreamlock.core.messageSystem.GameMessages;
import com.dreamlock.core.messageSystem.IMessageHandler;
import com.dreamlock.core.messageSystem.SoundPlayer;
import com.dreamlock.core.messageSystem.constants.AndroidCommandMessages;
import com.dreamlock.core.messageSystem.constants.ICommandMessages;
import com.dreamlock.core.parser.Lexer;
import com.dreamlock.core.parser.Parser;
import com.dreamlock.core.parser.models.Lexeme;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1001;

    private EditText speechHintEditText;
    private EditText nameInputEditText;
    private TextView textMatchTextView;
    private TextView outputTextView;
    private Button speakButton;
    private Button startGameButton;
    private Button loadGameButton;
    private Button exitGameButton;

    JsonParser jsonParser;
    String[] opening;
    Lexer lexer;
    Parser parser;
    HistoryController historyController;
    IMessageHandler messageHandler;
    IGameContext gameContext;
    Player player;

    SoundPlayer soundPlayer;

    String openingFile = "openings/dreamlock_opening.json";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speechHintEditText = (EditText) findViewById(R.id.etTextHint);
        nameInputEditText = (EditText) findViewById(R.id.nameInputEditText);
        textMatchTextView = (TextView) findViewById(R.id.tvTextMatches);
        outputTextView = (TextView) findViewById(R.id.tvOutput);
        speakButton = (Button) findViewById(R.id.btSpeak);

        startGameButton = (Button) findViewById(R.id.btStartGame);
        loadGameButton = (Button) findViewById(R.id.btLoadGame);
        exitGameButton = (Button) findViewById(R.id.btExitGame);

        outputTextView.setVisibility(View.INVISIBLE);
        speechHintEditText.setVisibility(View.INVISIBLE);
        textMatchTextView.setVisibility(View.INVISIBLE);
        speakButton.setVisibility(View.INVISIBLE);

        soundPlayer = new SoundPlayer(getApplicationContext());

        checkVoiceRecognition();
    }

    public void start(View view) throws IOException {
        startGameButton.setVisibility(View.INVISIBLE);
        loadGameButton.setVisibility(View.INVISIBLE);
        exitGameButton.setVisibility(View.INVISIBLE);
        speakButton.setVisibility(View.VISIBLE);
        outputTextView.setVisibility(View.VISIBLE);
        nameInputEditText.setVisibility(View.VISIBLE);

        jsonParser = new JsonParser(getApplicationContext());

        opening = new String[0];
        try {
            opening = jsonParser.parseOpening(openingFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        outputTextView.setText(opening[0]);
        soundPlayer.playFile(opening[1]);

        nameInputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    try {
                        startGame();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    handled = true;
                }
                return handled;
            }
        });
    }

    private void startGame() throws IOException {
        String name = nameInputEditText.getText().toString();
        outputTextView.setText(name + opening[2]);
        soundPlayer.stop();
        soundPlayer = new SoundPlayer(getApplicationContext());
        soundPlayer.playFile(opening[3]);
        nameInputEditText.setVisibility(View.GONE);

        GameUtils gameUtils = new GameUtils();
        Map<Integer,Room> rooms  = gameUtils.createNewStory(getApplicationContext());

        // Setup player
        player = new Player(name, new Inventory(20));
        gameContext = new GameContext(rooms, player);

        // Setup message handler
        GameMessages gameMessages = new GameMessages(player, rooms);
        AndroidCommandMessages commandMessages = AndroidCommandMessages.INSTANCE;
        messageHandler = new AndroidMessageHandler(getApplicationContext());
        messageHandler.registerAndroid(gameMessages.getGameMessages());
        messageHandler.registerAndroid(commandMessages.getCommandMessages());
        gameContext.setMessageHandler(messageHandler);

        lexer = new Lexer();
        parser = new Parser();
        historyController = new HistoryController(gameContext);
    }

    public void load(View view) {

    }

    public void exit(View view) {

    }

    public void checkVoiceRecognition() {
        // Check if voice recognition is present
        PackageManager pm = getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if (activities.size() == 0) {
            speakButton.setEnabled(false);
            speakButton.setText("Voice recognizer not present");
            Toast.makeText(this, "Voice recognizer not present",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void speak(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        // Specify the calling package to identify your application
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass()
                .getPackage().getName());

        // Display an hint to the user about what he should say.
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, speechHintEditText.getText()
                .toString());

        // Given an hint to the recognizer about what the user is going to say
        //There are two form of language model available
        //1.LANGUAGE_MODEL_WEB_SEARCH : For short phrases
        //2.LANGUAGE_MODEL_FREE_FORM  : If not sure about the words or phrases and its domain.
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);


        int noOfMatches = 1;
        // Specify how many results you want to receive. The results will be
        // sorted where the first result is the one with higher confidence.
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, noOfMatches);
        //Start the Voice recognizer activity for the result.
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE)

            //If Voice recognition is successful then it returns RESULT_OK
            if(resultCode == RESULT_OK) {

                ArrayList<String> textMatchList = data
                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                if (!textMatchList.isEmpty()) {
                    // If first Match contains the 'search' word
                    // Then start web search.
                    if (textMatchList.get(0).contains("search")) {

                        String searchQuery = textMatchList.get(0);
                        searchQuery = searchQuery.replace("search","");
                        Intent search = new Intent(Intent.ACTION_WEB_SEARCH);
                        search.putExtra(SearchManager.QUERY, searchQuery);
                        startActivity(search);
                    } else {
                        // populate the Matches

                        String line = textMatchList.get(0);

                        ArrayList<Lexeme> lexemes = lexer.tokenize(line);
                        JsonObject output = parser.parse(lexemes);


                        List<Integer> messageIds = null;
                        IHandler handler;
                        if (!output.get("error").getAsBoolean()) {
                            historyController.register(line);
                            if (historyController.handle() != null) {
                                messageIds = historyController.handle();
                                textMatchTextView.setVisibility(View.VISIBLE);
                                textMatchTextView.setText(line);
                                outputTextView.setText(messageHandler.printAndroid(messageIds));
                                soundPlayer = new SoundPlayer(getApplicationContext(), messageHandler.getMessages());
                                try {
                                    soundPlayer.play(messageIds);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            handler = new CommandHandler(output, gameContext);
                        } else {
                            handler = new ErrorHandler(output, gameContext);
                        }

                        messageIds = handler.handle();
                        textMatchTextView.setVisibility(View.VISIBLE);
                        textMatchTextView.setText(line);
                        outputTextView.setText(messageHandler.printAndroid(messageIds));
                        soundPlayer = new SoundPlayer(getApplicationContext(), messageHandler.getMessages());
                        try {
                            soundPlayer.play(messageIds);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
                //Result code for various error.
            }else if(resultCode == RecognizerIntent.RESULT_AUDIO_ERROR){
                showToastMessage("Audio Error");
            }else if(resultCode == RecognizerIntent.RESULT_CLIENT_ERROR){
                showToastMessage("Client Error");
            }else if(resultCode == RecognizerIntent.RESULT_NETWORK_ERROR){
                showToastMessage("Network Error");
            }else if(resultCode == RecognizerIntent.RESULT_NO_MATCH){
                showToastMessage("No Match");
            }else if(resultCode == RecognizerIntent.RESULT_SERVER_ERROR){
                showToastMessage("Server Error");
            }
        super.onActivityResult(requestCode, resultCode, data);
    }
    /**
     * Helper method to show the toast message
     **/
    void showToastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}