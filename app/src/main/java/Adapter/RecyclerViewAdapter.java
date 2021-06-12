package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amna.assignment2_lab.R;

import java.util.List;

import Model.ContactInfo;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    List<ContactInfo> userList;

    public RecyclerViewAdapter() {
    }

    public RecyclerViewAdapter(Context context, List<ContactInfo> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int resource=userList.get(position).getImageView1();
        String name= userList.get(position).getTv1();
        String msg= userList.get(position).getTv2();
        String time= userList.get(position).getTv3();
        holder.setData(resource,name,msg,time);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{
        ImageView img;
        TextView tv1, tv2, tv3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.iv_rv);
            tv1=itemView.findViewById(R.id.tv_rv_names);
            tv2=itemView.findViewById(R.id.tv_rv_msg);
            tv3=itemView.findViewById(R.id.tv_time);

            itemView.setOnLongClickListener(this);
        }
        public void setData(int resource, String name, String msg, String time) {
            img.setImageResource(resource);
            tv1.setText(name);
            tv2.setText(msg);
            tv3.setText(time);
        }

        @Override
        public boolean onLongClick(View v) {
            int position=getAdapterPosition();
            Toast.makeText(itemView.getContext(),"Deleted "+userList.get(position).getTv1(),Toast.LENGTH_LONG).show();
            userList.remove(position);
            notifyItemRemoved(position);
            return true;
        }
    }
}
