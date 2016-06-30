package layout;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;


import android.provider.ContactsContract;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.q.myapplication.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class numbers extends Fragment {
    public numbers() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ArrayList<String> items = new ArrayList();

        View view = inflater.inflate(R.layout.fragment_numbers, null);

        JSONArray jsonArray = new JSONArray();

        Dialog dialog = new Dialog(getContext());

        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        Cursor cursor = dialog.getContext().getContentResolver().query(uri, null, null, null, null);


        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String id = cursor.getString(
                        cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));

                if (cursor.getInt(cursor.getColumnIndex(
                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = dialog.getContext().getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));

                        try {
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("name", name);
                            jsonObject.put("number", phoneNo);
                            jsonArray.put(jsonObject);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    pCur.close();
                }
            }
        }

        int length = jsonArray.length();
        //Get the instance of JSONArray that contains JSONObjects
        try {
            for (int i = 0; i < length; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String num = jsonObject.getString("number");
                String item = name + "\n" + num;
                items.add(item);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        ListViewBtnAdapter adapter = new ListViewBtnAdapter(getActivity(), R.layout.items, items);

        ListView myListView = (ListView) view.findViewById(R.id.listview1);

        myListView.setAdapter(adapter);


        return view;
    }



}




