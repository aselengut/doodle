package selengut.alex.doodle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {


    private SeekBar _opac;
    private SeekBar _brush;
    private Switch _switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        _opac = (SeekBar)findViewById(R.id.set_opac);

        _opac.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                drawView d = (drawView)findViewById(R.id.Draw_view);
                d.setOpacity(progress);
            }
        });

        _brush = (SeekBar)findViewById(R.id.set_Brush);

        _brush.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                    drawView d = (drawView)findViewById(R.id.Draw_view);
                    d.setBrushSize((float)progress);
            }
        });

        _switch = (Switch)findViewById(R.id.switch1);

        _switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                drawView d = (drawView)findViewById(R.id.Draw_view);
                d.setline(b);
            }
        });
    }


    public void Red_click(View view) {

        drawView d = (drawView)findViewById(R.id.Draw_view);
        d.setColor("#CE3C28");

    }
    public void Blue_click(View view) {

        drawView d = (drawView)findViewById(R.id.Draw_view);
        d.setColor("#389ACC");

    }

    public void Yellow_click(View view) {

        drawView d = (drawView)findViewById(R.id.Draw_view);
        d.setColor("#F8BA32");

    }

    public void Green_click(View view) {

        drawView d = (drawView)findViewById(R.id.Draw_view);
        d.setColor("#66990F");

    }

    public void Orange_click(View view) {

        drawView d = (drawView)findViewById(R.id.Draw_view);
        d.setColor("#E38846");

    }

    public void purple_click(View view) {

        drawView d = (drawView)findViewById(R.id.Draw_view);
        d.setColor("#AA66CC");

    }

    public void clear_click(View view) {

        drawView d = (drawView)findViewById(R.id.Draw_view);
        d.clear();
    }
}
