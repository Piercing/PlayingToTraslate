package com.example.android.miwok.activities;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.Models.Word;
import com.example.android.miwok.adapters.WordAdapter;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();// Lo hacemos final para que el método 'onItemClick' pueda acceder a ella.
        words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        // Creo un Adapter, le paso el contexo, que es esta activity, el recurso, por defecto le pongo
        // uno que trae Android  y la lista de objetos que  será el origen de datos del "ArrayAdapter".
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        // Busco la listView para pasarle el Adapter la funte de datos.
        ListView listView = (ListView) findViewById(R.id.list);

        // Le paso la fuente de datos al listView para que los muestre.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Also release the MediaPlayer resources before the MediaPlayer is initialized to play a different song.
                Word.releaseMediaPlayer();
                // Get the {@link Word} object at the given position the user clicked on.
                Word word = words.get(position);

                Log.v("PhraseActivity", "Current phrase: " + word);

                // Create and setup the {@link MediaPlayer} for teh audio resource associated with the current word.
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(Word.mCompletionListener);
            }
        });
    }
}
