package layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.q.myapplication.MainActivity;
import com.example.q.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivity;


public class ListViewBtnAdapter extends ArrayAdapter  {
    private ArrayList<String> items;

    public  ListViewBtnAdapter(Context context, int resourceid, ArrayList<String> objects) {
        super(context, resourceid, objects);
        this.items = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.items, null);
        }

        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(items.get(position));

        final String text = items.get(position);
        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
                String[] tokens = text.split("\n");
                String num = "tel:" + tokens[1];
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(num));
                getContext().startActivity(intent);
            }
        });

        return v;
    }
}
