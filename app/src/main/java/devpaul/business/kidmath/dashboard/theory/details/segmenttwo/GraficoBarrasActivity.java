package devpaul.business.kidmath.dashboard.theory.details.segmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import cn.pedant.SweetAlert.SweetAlertDialog;
import devpaul.business.kidmath.R;


public class GraficoBarrasActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_barras);

        TextView  textback = (TextView) findViewById(R.id.text_back);

        GraphView graph = (GraphView) findViewById(R.id.grafica);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(0, -1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);

        series.setValueDependentColor(data -> Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100));

        series.setSpacing(50);

        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.BLACK);
        series.setTitle("Ejemplo de Gráfico de Barras");
        series.setColor(Color.GREEN);


        textback.setOnClickListener(view ->{
            onBackPressed();
        });

    }
}