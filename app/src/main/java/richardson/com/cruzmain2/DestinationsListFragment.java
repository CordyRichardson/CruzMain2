package richardson.com.cruzmain2;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DestinationsListFragment extends Fragment{
    List<Map<String, String>> parentList;
    List<List<Map<String, String>>> childLists;
    String[] parentNames;
    String[][]childrenNames;

    public DestinationsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_destinations_list_fragment,
                null);
        ExpandableListView expandableListView =
                (ExpandableListView)view.findViewById(R.id.destinations_list);

        parentNames = getResources().getStringArray(R.array.destination_parent_list);
        childrenNames= new String[][]{
                getResources().getStringArray(R.array.bahamas_islands),
                getResources().getStringArray(R.array.eastern_caribbean_islands),
                getResources().getStringArray(R.array.western_caribbean_islands),
                getResources().getStringArray(R.array.southern_caribbean_islands),
                getResources().getStringArray(R.array.ensenada_catalina_islands),
                getResources().getStringArray(R.array.mexican_riviera_islands),
                getResources().getStringArray(R.array.europe_ports),
                getResources().getStringArray(R.array.hawaii_ports),
                getResources().getStringArray(R.array.alaska_ports),
                getResources().getStringArray(R.array.canada_new_england_ports),
                getResources().getStringArray(R.array.bermuda_ports)

        };

        makeParentLists();
        makeChildLists();

        expandableListView.setAdapter(new SimpleExpandableListAdapter(
                getActivity(), parentList, android.R.layout.simple_expandable_list_item_1,
                new String[]{"PARENT"}, new int[] {android.R.id.text1},

                childLists, android.R.layout.simple_expandable_list_item_2,
                new String[]{"CHILD", "CHILD"}, new int[] {android.R.id.text2}
        ));

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    private void makeParentLists(){
        parentList = new ArrayList<>();
        for (int i = 0; i < parentNames.length; ++i){
            HashMap<String, String>hm = new HashMap<>();
            hm.put("PARENT", parentNames[i]);
            parentList.add(hm);
        }
    }

    private void makeChildLists(){
        childLists = new ArrayList<>();

        for (int i = 0; i < parentNames.length; ++i){
            List child_inner_list = new ArrayList<>();
            for (int x = 0; x < childrenNames[i].length; ++x){
                HashMap<String, String> map = new HashMap<>();
                map.put("CHILD", childrenNames[i][x]);
                child_inner_list.add(map);
            }
            childLists.add(child_inner_list);
        }
    }
}
