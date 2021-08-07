package mukesh.leftrigthtswipe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
/**
 * Created by Mukesh on 7-08-2021
 * @see https://github.com/MukeshGreenDeveloper/Slider-Left-Right-Animation
 * */
public class MainActivity extends AppCompatActivity
        implements SeekBar.OnSeekBarChangeListener {
    private OnlySeekableSeekBar slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slider = findViewById(R.id.slider);
        slider.setOnSeekBarChangeListener(this);
        findViewById(R.id.profileID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL(getString(R.string.developerName));
            }
        });
    }

    private void openURL(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar != null && seekBar.getProgress() > 50 && seekBar.getProgress() < 90)
            seekBar.setProgress(50);
        else if (seekBar != null && seekBar.getProgress() < 50 && seekBar.getProgress() > 10)
            seekBar.setProgress(50);
    }
}