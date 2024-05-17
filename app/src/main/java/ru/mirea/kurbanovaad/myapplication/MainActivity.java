package ru.mirea.kurbanovaad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ru.mirea.kurbanovaad.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private String group;
    private Integer number;
    private String film;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferences = getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        String group = preferences.getString("GROUP", "unknown");
        int number = preferences.getInt("NUMBER", 0);
        String film = preferences.getString("FILM", "unknown");

        editText1 = findViewById(R.id.editText1);
        editText1.setText(group);

        editText2 = findViewById(R.id.editText2);
        editText2.setText(String.valueOf(number));

        editText3 = findViewById(R.id.editText3);
        editText3.setText(film);
    }

    public void onClicked(View view){
        group = binding.editText1.getText().toString();
        number = Integer.parseInt(binding.editText2.getText().toString());
        film = binding.editText3.getText().toString();
        SharedPreferences sharedPref = getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);
        SharedPreferences.Editor editor	= sharedPref.edit();
        editor.putString("GROUP", group);
        editor.putInt("NUMBER", number);
        editor.putString("FILM", film);
        editor.apply();

        editText1.setText(group);
        editText2.setText(String.valueOf(number));
        editText3.setText(film);

        Toast.makeText(this, "Saved settings", Toast.LENGTH_SHORT).show();
    }
}