package vn.edu.usth.usthweather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Debug;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForecastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForecastFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForecastFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForecastFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForecastFragment newInstance(String param1, String param2) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        ScrollView scrollview=new ScrollView(getContext());
        Random random=new Random();

        LinearLayout output=new LinearLayout(getContext());
        output.setOrientation(LinearLayout.VERTICAL);
        output.setBackgroundColor(0xFFDFDFFF);

        LinearLayout[] box=new LinearLayout[7];

        String[] arr={"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        int[] weath={R.drawable.sun,R.drawable.showers,R.drawable.rain,R.drawable.scattered_thunderstorms,R.drawable.cloud,R.drawable.thunderstorm};
        String[] arr_detail={"Partly Cloudy\n24C - 31C","Rain\n22C - 23C","Showers\n24C - 30C","Scattered Thunderstorms\n24C - 27C","Mostly Cloudy\n22C - 30C","Thunderstorms\n25C - 28C"};

        TextView[] day=new TextView[7];
        LinearLayout.LayoutParams[] day_position=new LinearLayout.LayoutParams[7];

        ImageView[] icon=new ImageView[7];
        LinearLayout.LayoutParams[] icon_position=new LinearLayout.LayoutParams[7];

        TextView[] detail=new TextView[7];
        LinearLayout.LayoutParams[] detail_position=new LinearLayout.LayoutParams[7];
        for(int i=0;i<7;i++){
            int rand=random.nextInt(4);
            box[i]=new LinearLayout(getContext());
            box[i].setOrientation(LinearLayout.HORIZONTAL);

            day[i]=new TextView(getContext());
            day[i].setText(arr[i]);
            day[i].setTextSize(20);

            day_position[i]=new LinearLayout.LayoutParams(200, 300);
            day_position[i].setMargins(30,35,0,0);
            day[i].setLayoutParams(day_position[i]);

            icon[i]=new ImageView(getContext());
            icon[i].setImageResource(weath[rand]);

            icon_position[i]=new LinearLayout.LayoutParams(200,200);
            icon[i].setLayoutParams(icon_position[i]);

            detail[i]=new TextView(getContext());
            detail[i].setText(arr_detail[rand]);

            detail_position[i]=new LinearLayout.LayoutParams(
                    300,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            detail_position[i].setMargins(70,18,0,0);
            detail[i].setLayoutParams(detail_position[i]);

            box[i].addView(day[i]);
            box[i].addView(icon[i]);
            box[i].addView(detail[i]);
            output.addView(box[i]);
        }
        scrollview.addView(output);
        return scrollview;
    }


}