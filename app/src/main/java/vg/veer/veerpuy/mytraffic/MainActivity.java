package vg.veer.veerpuy.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Explicit ประการตัวแปร
    private ListView trafficListView;
    private Button aboutMeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        trafficListView = (ListView) findViewById(R.id.listView);
        aboutMeButton = (Button) findViewById(R.id.button);

        //Controller for Button
        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ทำให้เกิดเสียง
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),R.raw.lamp);
                mediaPlayer.start();

                //Web View เปิดเว็บ
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtu.be/9EuFMZX6h4E"));
                startActivity(intent);


            }       // onClick
        });


    }       // Main Method
}       // Main Class นี่คือ คลาสหลัก
