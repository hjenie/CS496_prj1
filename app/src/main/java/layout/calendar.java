package layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.q.myapplication.R;
import com.example.q.myapplication.window;

import java.util.ArrayList;

public class calendar extends Fragment {

    ArrayList<String> mList = new ArrayList();
    ArrayList<String> mList1 = new ArrayList();
    String str;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        CalendarView calendarView = (CalendarView) view.findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getContext(), "Selected Date is \n\n" + dayOfMonth + " : " + month + " : " + year, Toast.LENGTH_LONG).show();
                str = String.valueOf(dayOfMonth)+String.valueOf(month)+String.valueOf(year);
            }
        });

        Button button = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), window.class);
                startActivityForResult(intent, 1);
            }
        });

        Button button1 = (Button) view.findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mList1.contains(str)) {
                    int idx = mList1.indexOf(str);
                    Toast.makeText(getContext(), mList.get(idx), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            if (requestCode == 1) {
                String str1 = str;
                String str2 = data.getStringExtra("data");
                mList.add(str2);
                mList1.add(str1);
            }
        }
    }
}
