package com.trojans.iwannabe.messenger;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.trojans.iwannabe.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class UsersFragment extends Fragment {
    ListView usersList;
    TextView noUsersText;
    ArrayList<String> al = new ArrayList<>();
    int totalUsers = 0;
    ProgressDialog pd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_users, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        usersList = (ListView) view.findViewById(R.id.usersList);
        noUsersText = (TextView) view.findViewById(R.id.noUsersText);

        pd = new ProgressDialog(this.getContext());
        pd.setMessage("Loading...");
        pd.show();

        doOnSuccess("{\"Stefan\":{\"password\":\"1234\"},\"Monica\":{\"password\":\"1234\"},\"Nic\":{\"password\":\"1234\"},\"Andrei\":{\"password\":\"1234\"},\"UPB\":{\"password\":\"1234\"},\"FMI\":{\"password\":\"1234\"},\"Mate-info-intensiv\":{\"password\":\"1234\"}}");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        usersList.setOnItemClickListener((parent, view, position, id) -> {
            UserDetails.chatWith = al.get(position);

            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            ft.replace(R.id.container, new MessengerFragment(), "user")
                    .addToBackStack(null)
                    .commit();
        });
    }

    public void doOnSuccess(String s) {
        try {
            JSONObject obj = new JSONObject(s);

            Iterator i = obj.keys();
            String key = "";

            while (i.hasNext()) {
                key = i.next().toString();

                if (!key.equals(UserDetails.username)) {
                    al.add(key);
                }

                totalUsers++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (totalUsers <= 1) {
            noUsersText.setVisibility(View.VISIBLE);
            usersList.setVisibility(View.GONE);
        } else {
            noUsersText.setVisibility(View.GONE);
            usersList.setVisibility(View.VISIBLE);
            usersList.setAdapter(new ArrayAdapter<String>(UsersFragment.this.getContext(), android.R.layout.simple_list_item_1, al));
        }

        pd.dismiss();
    }
}