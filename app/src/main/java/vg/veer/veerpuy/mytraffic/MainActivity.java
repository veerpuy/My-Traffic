package vg.veer.veerpuy.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    // Explicit ประการตัวแปร
    private ListView trafficListView;
    private Button aboutMeButton;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.lamp);
                mediaPlayer.start();

                //Web View เปิดเว็บ
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtu.be/9EuFMZX6h4E"));
                startActivity(intent);


            }       // onClick
        });

        //การสร้าง ListView
        // 1. การเซ็ต อาเรย์แบบ Simple
        final int[] iconIns = new int[20];
        iconIns[0] = R.drawable.traffic_01;
        iconIns[1] = R.drawable.traffic_02;
        iconIns[2] = R.drawable.traffic_03;
        iconIns[3] = R.drawable.traffic_04;
        iconIns[4] = R.drawable.traffic_05;
        iconIns[5] = R.drawable.traffic_06;
        iconIns[6] = R.drawable.traffic_07;
        iconIns[7] = R.drawable.traffic_08;
        iconIns[8] = R.drawable.traffic_09;
        iconIns[9] = R.drawable.traffic_10;
        iconIns[10] = R.drawable.traffic_11;
        iconIns[11] = R.drawable.traffic_12;
        iconIns[12] = R.drawable.traffic_13;
        iconIns[13] = R.drawable.traffic_14;
        iconIns[14] = R.drawable.traffic_15;
        iconIns[15] = R.drawable.traffic_16;
        iconIns[16] = R.drawable.traffic_17;
        iconIns[17] = R.drawable.traffic_18;
        iconIns[18] = R.drawable.traffic_19;
        iconIns[19] = R.drawable.traffic_20;


        // 2. call From xel
        final String[] nameStrings = getResources().getStringArray(R.array.name);

        // 3. Call From Java
        my_data myData = new my_data();
        String[] detailStrings = myData.getDetStrings();


        MyAdapter myAdapter = new MyAdapter(this, iconIns, nameStrings, detailStrings);
        trafficListView.setAdapter(myAdapter);

        //intent to Detail when Click
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Name", nameStrings[position]);
                intent.putExtra("Icon", iconIns[position]);
                intent.putExtra("Index", position);
                startActivity(intent);

            }   //onItemClick
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }       // Main Method

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://vg.veer.veerpuy.mytraffic/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://vg.veer.veerpuy.mytraffic/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}       // Main Class นี่คือ คลาสหลัก
