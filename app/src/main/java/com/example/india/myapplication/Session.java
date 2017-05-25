package com.example.india.myapplication;

import android.service.textservice.SpellCheckerService;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;

import java.util.Properties;

/**
 * Created by india on 3/4/2017.
 */
public class Session extends SpellCheckerService.Session {
    @Override
    public void onCreate() {

    }

    @Override
    public SuggestionsInfo onGetSuggestions(TextInfo textInfo, int suggestionsLimit) {
        return null;
    }

    public static Session getDefaultInstance(Properties props, Authenticator authenticator) {
        return null;
    }
}
