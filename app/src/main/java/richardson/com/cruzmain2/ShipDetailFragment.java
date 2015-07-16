package richardson.com.cruzmain2;


import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;




/**
 * A simple {@link Fragment} subclass.
 */
public class ShipDetailFragment extends Fragment {
    ViewHolder vw = new ViewHolder();
    View view;

    public ShipDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        Ship ship = (Ship)bundle.getSerializable("ship");

        view = inflater.inflate(R.layout.fragment_ship_detail, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.scroll_view_linear_layout);
        TextView textView = (TextView)view.findViewById(R.id.ship_name_text_view);


        for(int id = 0; id < ship.getImageListSize(); ++id){
            ImageView imgvw = new ImageView(view.getContext());
            imgvw.setImageResource(ship.getimageID(id));

            linearLayout.addView(imgvw);
        }

        textView.setText(ship.getShipName());

       tieCheckBoxes();

        setCheckBoxes(ship.getCheckBoxesToSet());


        //set up ship attribute checkbox table

        return view;
    }

    public void setCheckBoxes(int[] checkBoxNums ){

        }

    public void tieCheckBoxes(){
        vw.checkBox1 = (CheckBox)view.findViewById(R.id.mini_golf_checkBox);
            vw.checkBox1.setClickable(false);
        vw.checkBox2 = (CheckBox)view.findViewById(R.id.fitness_center_checkBox);
            vw.checkBox2.setClickable(false);
        vw.checkBox3 = (CheckBox)view.findViewById(R.id.fitness_classes_checkBox);
            vw.checkBox3.setClickable(false);
        vw.checkBox4 = (CheckBox)view.findViewById(R.id.twister_slide_checkBox);
            vw.checkBox4.setClickable(false);
        vw.checkBox5 = (CheckBox)view.findViewById(R.id.jogging_track_checkBox);
            vw.checkBox5.setClickable(false);
        vw.checkBox6 = (CheckBox)view.findViewById(R.id.punchLiners_checkBox);
            vw.checkBox6.setClickable(false);
        vw.checkBox7 = (CheckBox)view.findViewById(R.id.arcade_checkBox);
        vw.checkBox8 = (CheckBox)view.findViewById(R.id.playlist_checkBox);
            vw.checkBox8.setClickable(false);
        vw.checkBox9 = (CheckBox)view.findViewById(R.id.serenity_checkBox);
            vw.checkBox9.setClickable(false);
        vw.checkBox10 = (CheckBox)view.findViewById(R.id.hasbro_checkBox);
            vw.checkBox10.setClickable(false);
        vw.checkBox11 = (CheckBox)view.findViewById(R.id.waterworks_checkBox);
            vw.checkBox11.setClickable(false);
        vw.checkBox12 = (CheckBox)view.findViewById(R.id.sea_side_theater_checkBox);
            vw.checkBox12.setClickable(false);
    }

    public static class ViewHolder{
        CheckBox checkBox1;
        CheckBox checkBox2;
        CheckBox checkBox3;
        CheckBox checkBox4;
        CheckBox checkBox5;
        CheckBox checkBox6;
        CheckBox checkBox7;
        CheckBox checkBox8;
        CheckBox checkBox9;
        CheckBox checkBox10;
        CheckBox checkBox11;
        CheckBox checkBox12;
        CheckBox checkBox13;
        CheckBox checkBox14;
        CheckBox checkBox15;
        CheckBox checkBox16;
        CheckBox checkBox17;
        CheckBox checkBox18;
        CheckBox checkBox19;
        CheckBox checkBox20;
        CheckBox checkBox21;
        CheckBox checkBox22;
        CheckBox checkBox23;

        CheckBox[] checkBoxes = new CheckBox[]{
                checkBox1, checkBox2, checkBox3, checkBox4,
                checkBox5, checkBox5, checkBox6, checkBox7,
                checkBox8, checkBox9, checkBox10, checkBox11, checkBox12,
                checkBox13, checkBox14, checkBox15, checkBox16, checkBox17,
                checkBox18, checkBox19, checkBox20, checkBox21, checkBox22,
                checkBox23};
    }

    public class CheckBoxListener implements OnClickListener {
        @Override
        public void onClick(View view){
            view.setActivated(false);

        }


    }

}
