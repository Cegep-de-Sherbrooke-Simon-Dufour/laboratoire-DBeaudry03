package com.example.myapplication.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.data.User;

public class UserAdapter extends ListAdapter<User,UserAdapter.ViewHolder> {

    private OnItemClick<User> onUserClick = (u)->{};
    public  void setOnUserClick(OnItemClick<User> passed) {
        this.onUserClick=passed;
    }
    public UserAdapter() {
        super(new DiffUtil.ItemCallback<User>(){

            @Override
            public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
                return oldItem == newItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
                return oldItem.email.equals(newItem.email)&& oldItem.nom.equals(newItem.nom);
            }
        });

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView name;
        private final TextView email;
        User user;
        public ViewHolder(View itemview) {
            super(itemview);
            this.name = itemview.findViewById(R.id.user_name);
            this.email = itemview.findViewById(R.id.user_email);
            itemview.setOnClickListener(view-> {
                onUserClick.returnValue(user);
            });
        }

        public void bind(User user) {
            name.setText(user.nom);
            email.setText(user.email);
            this.user = user;
        }

    }
}
