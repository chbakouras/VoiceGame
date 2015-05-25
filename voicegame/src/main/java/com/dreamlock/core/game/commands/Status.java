package com.dreamlock.core.game.commands;


import com.dreamlock.core.game.IGameContext;
import com.dreamlock.core.game.models.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Status implements ICommand{
    @Override
    public List<Integer> execute(IGameContext gameContext) {
        List<Integer> output = new ArrayList<>();

        output.add(10005);
        output.add(9999);
        return output;
    }

    @Override
    public List<Integer> execute(IGameContext gameContext, Map<Integer, Word> words) {

        return null;
    }
}
