package richardson.com.cruzmain2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShipListFragment extends ListFragment{
   Spinner spinner;
    OnShipSelectedListener mCallback;

    List<Ship> arrayList;

    Ship Fantasy, Ecstasy, Sensation, Fascination, Imagination, Inspiration,
        Elation, Paradise, Triumph, Victory, Spirit, Pride, Legend, Miracle,
        Conquest, Glory, Valor, Liberty, Freedom, Splendor, Dream, Magic,
        Breeze, Sunshine, Vista;

    public ShipListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            mCallback = (OnShipSelectedListener)activity;
        } catch(ClassCastException e){
            throw new ClassCastException(activity.toString()
                    + " must implement OnShipSelectedListener");
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ship_list, container, false);

        createShipArrayList();

        final ShipAdapter adapter = new ShipAdapter(getActivity(),
               R.layout.ship_list_item, R.id.ship_name_view,
                arrayList);

        setListAdapter(adapter);


        spinner = (Spinner)view.findViewById(R.id.ship_fragment_spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            public void onItemSelected(AdapterView<?>parent, View view, int pos,
                                       long id){
                adapter.notifyDataSetChanged();
                switch(pos){
                    case 0:
                        Collections.sort(arrayList, new Comparator<Ship>(){
                            public int compare(Ship s1, Ship s2){
                                return s1.getShipName().compareTo(s2.getShipName());
                            }
                        });
                        break;
                    case 1:
                        Collections.sort(arrayList, new Comparator<Ship>(){
                           public int compare(Ship s1, Ship s2){
                               return s2.getBuildYear() - s1.getBuildYear();
                           }
                        });
                        break;
                    case 2:
                        Collections.sort(arrayList, new Comparator<Ship>(){
                            public int compare(Ship s1, Ship s2){
                                return s2.getCapacity() - s1.getCapacity();
                            }
                        });
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?>parent){

            }
        });


        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        //i created the mCallback item.
        //its defined as an interface below

       mCallback.onShipSelected(arrayList.get(position));

    }


    public void createShipArrayList(){
        arrayList = new ArrayList<>();

        Fantasy = new Ship("FA", "Fantasy", 1990, 2056); arrayList.add(Fantasy);
        Ecstasy = new Ship("EC", "Ecstasy", 1991, 2056); arrayList.add(Ecstasy);
        Sensation = new Ship("SE", "Sensation", 1993, 2056); arrayList.add(Sensation);
        Fascination = new Ship("FS", "Fascination", 1994, 2056); arrayList.add(Fascination);
        Imagination = new Ship("IM", "Imagination", 1995, 2056); arrayList.add(Imagination);
        Inspiration = new Ship("IS", "Inspiration", 1996, 2054); arrayList.add(Inspiration);
        Elation = new Ship ("EL", "Elation", 1998, 2052); arrayList.add(Elation);
        Paradise = new Ship("PA", "Paradise", 1998, 2052); arrayList.add(Paradise);
        Triumph = new Ship("TI", "Triumph", 1999, 2754); arrayList.add(Triumph);
        Victory = new Ship("VI", "Victory", 2000, 2754); arrayList.add(Victory);
        Spirit = new Ship("SP", "Spirit", 2001, 2124); arrayList.add(Spirit);
        Pride = new Ship("PR", "Pride", 2002, 2124); arrayList.add(Pride);
        Legend = new Ship("LE",	"Legend", 2002, 2124); arrayList.add(Legend);
        Miracle = new Ship("MI", "Miracle" , 2004, 2124); arrayList.add(Miracle);
        Conquest = new Ship("CQ", "Conquest", 2002, 2980); arrayList.add(Conquest);
        Glory = new Ship("GL", "Glory", 2003, 2980); arrayList.add(Glory);
        Valor = new Ship("VA", "Valor", 2004, 2980); arrayList.add(Valor);
        Liberty = new Ship("LI", "Liberty", 2005, 2974); arrayList.add(Liberty);
        Freedom = new Ship("FD", "Freedom", 2007, 2970); arrayList.add(Freedom);
        Splendor = new Ship("SL", "Splendor", 2008, 3002); arrayList.add(Splendor);
        Dream = new Ship("DR", "Dream", 2009, 3646); arrayList.add(Dream);
        Magic = new Ship("MC", "Magic", 2011, 3690); arrayList.add(Magic);
        Breeze = new Ship("BR", "Breeze", 2012, 3690, R.drawable.breeze1,
                R.drawable.breeze2, R.drawable.breeze3, R.drawable.breeze4); arrayList.add(Breeze);
            Breeze.setCheckBoxArray(new int[]{9, 10, 11, 12, 13, 14, 15, 17, 19, 20, 21, 22, 24,
                                        25, 26, 27});
        Sunshine = new Ship("SH", "Sunshine", 2013, 3002); arrayList.add(Sunshine);
        Vista = new Ship("VS", "Vista", 2016, 4000); arrayList.add(Vista);
    }

    public interface OnShipSelectedListener{
        //interface used to pass info to parent activity and then to other fragment
        //per http://developer.android.com/training/basics/fragments/communicating.html


        void onShipSelected(Ship ship);
    }

    public static class ViewHolder{
        TextView shipTextView;
        TextView shipAttributeTextView;
    }

    public class ShipAdapter extends ArrayAdapter<Ship>{
        public ShipAdapter(Context context, int resource, int layoutResourceId, List<Ship> ships){
            super(context, resource, layoutResourceId, ships);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            convertView = View.inflate(getContext(), R.layout.ship_list_item,null);
            ViewHolder holder = new ViewHolder();
            holder.shipTextView = (TextView)convertView.findViewById(R.id.ship_name_view);
            holder.shipAttributeTextView = (TextView)convertView.findViewById(R.id.ship_attr_view);

            convertView.setTag(holder);

            Ship ship = arrayList.get(position);
            String shipName = "Carnival " + ship.getShipName();
            String shipAttribute ="";
            String shipAgeString = "Built in: ";
            String shipSizeString = "Guest Capacity: ";
            int spinnerPosition = spinner.getSelectedItemPosition();

            switch(spinnerPosition){
                case 0:
                    shipAttribute = "";
                    break;
                case 1:
                    shipAttribute = shipAgeString + ship.getBuildYear();
                    break;
                case 2:
                    shipAttribute = shipSizeString + ship.getCapacity();
                    break;
            }


            holder.shipTextView.setText(shipName);
            holder.shipAttributeTextView.setText(shipAttribute);

            return convertView;
        }
    }


}
