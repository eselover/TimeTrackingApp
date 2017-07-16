package test.erics.timetracking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by erics on 6/8/2017.
 */

class CustomAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<Client> clientList = new ArrayList<Client>();
    private Context context;

    public CustomAdapter(ArrayList<Client> clientList, Context context) {
        this.clientList = clientList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return clientList.size();
    }

    @Override
    public Object getItem(int position) {
        return clientList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return clientList.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.client_list_layout, null);
        }

        Switch list_item_switch = (Switch) view.findViewById(R.id.clientSwitchId);
        list_item_switch.setText(clientList.get(position).getName());

        final Button add_note = (Button) view.findViewById(R.id.addNoteBtn);
        add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clientList.get(position).attachNote();
            }
        });

        list_item_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    add_note.setClickable(true);
                    clientList.get(position).startTracking();
                } else {
                    add_note.setClickable(false);
                    clientList.get(position).stopTracking();
                }
            }
        });

        return view;
    }
}
