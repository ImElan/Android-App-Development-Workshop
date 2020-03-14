package app.android.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapater extends RecyclerView.Adapter<RecyclerViewAdapater.ViewHolder>
{
    private ArrayList<String> mImageUrls;
    private ArrayList<String> mNames;
    private Context mContext;

    public RecyclerViewAdapater(ArrayList<String> mImageUrls, ArrayList<String> mNames, Context mContext) {
        this.mImageUrls = mImageUrls;
        this.mNames = mNames;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.individual_item_layout,parent,false);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        Picasso.get()
                .load(mImageUrls.get(position))
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ProfileImage);

        holder.NameText.setText(mNames.get(position));

        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = holder.NameText.getText().toString();
                Toast.makeText(mContext,name,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        CircleImageView ProfileImage;
        TextView NameText;
        LinearLayout mLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ProfileImage = itemView.findViewById(R.id.profile_image_id);
            NameText = itemView.findViewById(R.id.name);
            mLayout = itemView.findViewById(R.id.individual_layout_id);

        }
    }
}
