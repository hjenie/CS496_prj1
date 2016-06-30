package layout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.q.myapplication.R;

public class photos extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_photos, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.gridView1);
        gridView.setAdapter(new gridAdapter(getActivity()));
        return view;

    }


    public class gridAdapter extends BaseAdapter {

        private Context context;

        public gridAdapter(Context c) {
            context = c;
        }

        /* returns the number of images */
        public int getCount() {
            return imageIDs.length;
        }

        /* returns the ID of an item */
        public Object getItem(int position) {
            return imageIDs[position];
        }

        public long getItemId(int position) {
            return position;
        }

        /* returns an ImageView view */
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(imageIDs[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new GridView.LayoutParams(700,700));




            return imageView;
        }

        Integer[] imageIDs = {
                R.drawable.a1,
                R.drawable.a2,
                R.drawable.a3,
                R.drawable.a4,
                R.drawable.a5,
                R.drawable.a6,
                R.drawable.a7,
                R.drawable.a8,
                R.drawable.a9,
                R.drawable.a10,
                R.drawable.a11,
                R.drawable.a12,
                R.drawable.a13,
                R.drawable.a14,
                R.drawable.a15,
                R.drawable.a16,
                R.drawable.a17,
                R.drawable.a18,
                R.drawable.a19,
                R.drawable.a20
        };

    }

}