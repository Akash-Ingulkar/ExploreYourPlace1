package akshay.saurav.chandan.exploreyourplace.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import akshay.saurav.chandan.exploreyourplace.R;

public class MyAdaptor extends BaseAdapter {

    private Context context;
    private LayoutInflater inflator;
    private String[] homeWord;
    private int[] homeImage;





    public MyAdaptor(Context c, int[] homeImage, String[] homeWord) {
        this.context=c;
        this.homeImage=homeImage;
        this.homeWord=homeWord;

    }

    @Override
    public int getCount() {
        return homeWord.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflator==null)
        {
            inflator=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView==null)
        {
            convertView=inflator.inflate(R.layout.content,null);
        }
        ImageView imageView=convertView.findViewById(R.id.imageView3);
        TextView textView=convertView.findViewById(R.id.tv1);



        imageView.setImageResource(homeImage[position]);
        textView.setText(homeWord[position]);

        return convertView;
    }
}
