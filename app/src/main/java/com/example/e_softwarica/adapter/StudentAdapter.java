package com.example.e_softwarica.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_softwarica.R;
import com.example.e_softwarica.models.LocalUser;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{
   static List<LocalUser> localUserList=new ArrayList<>();
    public StudentAdapter(List<LocalUser> localUserList) {
        this.localUserList = localUserList;
    }

    String caseGender;

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_fragment, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StudentViewHolder holder, final int position) {
        LocalUser localUser=localUserList.get(position);
      //  holder.imageView.setImageResource(localUser.getImageId());
        holder.name.setText("Name: "+localUser.getName());
        holder.age.setText("Age: "+localUser.getAge());
        holder.address.setText("Address: "+localUser.getAddress());
        holder.gender.setText("Gender: "+localUser.getGender());
        if(localUser.getGender()=="Male"){
            holder.imageView.setImageResource(R.drawable.male);
        }else if(localUser.getGender()=="Female"){
            holder.imageView.setImageResource(R.drawable.female);
        }else {
            holder.imageView.setImageResource(R.drawable.others);
        }

        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localUserList.remove(position);
               notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return localUserList.size();
    }


    public class StudentViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView name, age, address, gender;
        ImageButton btndelete;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id.name);
            age=itemView.findViewById(R.id.age);
            address=itemView.findViewById(R.id.address);
            gender=itemView.findViewById(R.id.gender);
            btndelete=itemView.findViewById(R.id.btndelete);

        }
    }
}
