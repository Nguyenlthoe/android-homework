package exercise.edu.gmailinterface;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVEmailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Email> emails;
    ItemClickInterface itemClickInterface;

    public RVEmailAdapter(List<Email> emails, ItemClickInterface itemClickInterface) {
        this.emails = emails;
        this.itemClickInterface = itemClickInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gmail_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.v("TAG", "ONBINDVIEWHOLDER");
        Email email = emails.get(position);
        ((MyViewHolder)holder).iconColor.setImageResource(email.getId());

        if(email.isImportant()){
            ((MyViewHolder)holder).favorite.setVisibility(View.GONE);
            ((MyViewHolder)holder).favoriteTrue.setVisibility(View.VISIBLE);
        } else {
            ((MyViewHolder)holder).favorite.setVisibility(View.VISIBLE);
            ((MyViewHolder)holder).favoriteTrue.setVisibility(View.GONE);
        }

        ((MyViewHolder)holder).fromTv.setText(email.getFrom());
        ((MyViewHolder)holder).timeTv.setText(email.getTimestamp());
        ((MyViewHolder)holder).subjectTv.setText(email.getSubject());
        ((MyViewHolder)holder).messageTv.setText(email.getMessage());

        ((MyViewHolder)holder).iconTv.setText(email.getFrom().charAt(0) + "");

        ((MyViewHolder)holder).favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MyViewHolder)holder).favorite.setVisibility(View.GONE);
                ((MyViewHolder)holder).favoriteTrue.setVisibility(View.VISIBLE);
            }
        });
        ((MyViewHolder)holder).favoriteTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MyViewHolder)holder).favorite.setVisibility(View.VISIBLE);
                ((MyViewHolder)holder).favoriteTrue.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return emails.size();
    }
    public interface ItemClickInterface {
        void OnItemClick(int position);
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iconColor, favorite, favoriteTrue;
        TextView fromTv,timeTv,subjectTv,messageTv, iconTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iconColor = itemView.findViewById(R.id.icon_color);
            favorite = itemView.findViewById(R.id.favorite);
            favoriteTrue = itemView.findViewById(R.id.favorite_true);
            fromTv = itemView.findViewById(R.id.from_tv);
            timeTv = itemView.findViewById(R.id.time_tv);
            subjectTv = itemView.findViewById(R.id.subject_tv);
            messageTv = itemView.findViewById(R.id.message_tv);
            iconTv = itemView.findViewById(R.id.icon_tv);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    Log.v("TAG", "position " + pos);
                    if (itemClickInterface != null)
                        itemClickInterface.OnItemClick(pos);
                }
            });
        }
    }
}
