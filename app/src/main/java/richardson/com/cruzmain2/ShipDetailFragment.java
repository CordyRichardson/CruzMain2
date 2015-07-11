package richardson.com.cruzmain2;


import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShipDetailFragment extends Fragment {


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

        View view = inflater.inflate(R.layout.fragment_ship_detail, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.scroll_view_linear_layout);
        TextView textView = (TextView)view.findViewById(R.id.ship_name_text_view);


        for(int id = 0; id < ship.getImageListSize(); ++id){
            ImageView imgvw = new ImageView(view.getContext());
            imgvw.setImageResource(ship.getimageID(id));

            linearLayout.addView(imgvw);
        }

        textView.setText(ship.getShipName());


        //set up ship attribute checkbox table

        return view;
    }
}
