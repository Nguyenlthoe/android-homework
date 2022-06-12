package exercise.edu.gmailinterface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EmailAdapter extends BaseAdapter {
    Context context;
    List<Email> items;

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder viewHolder;

        if (view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.gmail_item, null);
            viewHolder = new MyViewHolder();
            viewHolder.iconColor = view.findViewById(R.id.icon_color);
            viewHolder.favorite = view.findViewById(R.id.favorite);
            viewHolder.favoriteTrue = view.findViewById(R.id.favorite_true);
            viewHolder.fromTv = view.findViewById(R.id.from_tv);
            viewHolder.timeTv = view.findViewById(R.id.time_tv);
            viewHolder.subjectTv = view.findViewById(R.id.subject_tv);
            viewHolder.messageTv = view.findViewById(R.id.message_tv);
            viewHolder.iconTv = view.findViewById(R.id.icon_tv);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) view.getTag();
        }
        Email email = items.get(i);

        viewHolder.iconColor.setImageResource(email.getId());
        if(email.isImportant()){
            viewHolder.favorite.setVisibility(View.GONE);
            viewHolder.favoriteTrue.setVisibility(View.VISIBLE);
        } else {
            viewHolder.favorite.setVisibility(View.VISIBLE);
            viewHolder.favoriteTrue.setVisibility(View.GONE);
        }
        viewHolder.fromTv.setText(email.getFrom());
        viewHolder.timeTv.setText(email.getTimestamp());
        viewHolder.subjectTv.setText(email.getSubject());
        viewHolder.messageTv.setText(email.getMessage());
        viewHolder.iconTv.setText(email.getFrom().charAt(0));
        viewHolder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewHolder.favorite.setVisibility(View.GONE);
                viewHolder.favoriteTrue.setVisibility(View.VISIBLE);
            }
        });
        viewHolder.favoriteTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewHolder.favorite.setVisibility(View.VISIBLE);
                viewHolder.favoriteTrue.setVisibility(View.GONE);
            }
        });
        return view;
    }

    class MyViewHolder {
        ImageView iconColor, favorite, favoriteTrue;
        TextView fromTv,timeTv,subjectTv,messageTv, iconTv;
    }
}
