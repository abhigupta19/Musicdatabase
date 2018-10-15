package com.example.user.database;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;

public class Artistlist extends ArrayAdapter<Artist> {
    private Activity con;
    private List<Artist> artistlist;
    public Artistlist(Activity con,List<Artist>artistlist)
    {
        super(con,R.layout.list,artistlist);
        this.con=con;
        this.artistlist=artistlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater l1=con.getLayoutInflater();
        View l2=l1.inflate(R.layout.list,null,true);
        TextView t1=(TextView)l2.findViewById(R.id.textView);
        TextView t2=(TextView)l2.findViewById(R.id.textView2);
        Artist artist=artistlist.get(position);
        t1.setText(artist.getName());
        t2.setText(artist.getGener());

       return l2;



    }
}
