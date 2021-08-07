package mukesh.leftrigthtswipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/**
 * Created by Mukesh on 7-08-2021
 * @see https://github.com/MukeshGreenDeveloper/Slider-Left-Right-Animation
 * */
public class OnlySeekableSeekBar extends androidx.appcompat.widget.AppCompatSeekBar {
    public OnlySeekableSeekBar(@NonNull  Context context) {
        super(context);
    }

    public OnlySeekableSeekBar(@NonNull  Context context, @Nullable  AttributeSet attrs) {
        super(context, attrs);
    }

    public OnlySeekableSeekBar(@NonNull  Context context, @Nullable  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        if (motionEvent != null && motionEvent.getAction() == 0) {
            int width = getWidth();
            int paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
            int x = (int) motionEvent.getX();
            float f2 = 0.0f;
            if (x < getPaddingLeft()) {
                f = 0.0f;
            } else if (x > width - getPaddingRight()) {
                f = 1.0f;
            } else {
                f = ((float) (x - getPaddingLeft())) / ((float) paddingLeft);
            }
            float max = (float) getMax();
            float f3 = (f * max) + 0.0f;
            if (f3 >= ((float) 0)) {
                f2 = f3 > max ? max : f3;
            }
            if (Math.abs(f2 - ((float) getProgress())) < ((float) 10)) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        } else if (motionEvent != null) {
            return super.onTouchEvent(motionEvent);
        } else {
            return false;
        }
    }
}
