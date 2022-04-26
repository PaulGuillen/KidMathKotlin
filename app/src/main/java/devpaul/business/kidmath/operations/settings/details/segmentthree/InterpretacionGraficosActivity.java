package devpaul.business.kidmath.operations.settings.details.segmentthree;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import cn.pedant.SweetAlert.SweetAlertDialog;
import devpaul.business.kidmath.R;

public class InterpretacionGraficosActivity extends AppCompatActivity {

    PieChart pieChart;
    TextView uno;
    TextView dos;
    TextView tres;
    TextView cuatro;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpretacion_graficos);

        pieChart = findViewById(R.id.piechart);
        uno = findViewById(R.id.textuno);
        dos = findViewById(R.id.textdos);
        tres = findViewById(R.id.texttres);
        cuatro = findViewById(R.id.textcuatro);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);

        uno.setText(Integer.toString(40));
        dos.setText(Integer.toString(30));
        tres.setText(Integer.toString(5));
        cuatro.setText(Integer.toString(25));

        pieChart.addPieSlice(
                new PieModel(
                        "Golosinas",
                        Integer.parseInt(uno.getText().toString()),
                        Color.parseColor("#57b8f4")));
        pieChart.addPieSlice(
                new PieModel(
                        "Ropa",
                        Integer.parseInt(dos.getText().toString()),
                        Color.parseColor("#fcd710")));
        pieChart.addPieSlice(
                new PieModel(
                        "Frutas",
                        Integer.parseInt(tres.getText().toString()),
                        Color.parseColor("#fc7cc4")));
        pieChart.addPieSlice(
                new PieModel(
                        "Verduras",
                        Integer.parseInt(cuatro.getText().toString()),
                        Color.parseColor("#e3bd94")));

        pieChart.startAnimation();

        TextView textnext = (TextView) findViewById(R.id.next);
        TextView  textback = (TextView) findViewById(R.id.text_back);

        textnext.setOnClickListener(view -> {
            new SweetAlertDialog(this).setTitleText("Segimos trabajando en este tema, gracias por tu comprensión").show();
        });

        textback.setOnClickListener(view ->{
            onBackPressed();
        });

    }
}