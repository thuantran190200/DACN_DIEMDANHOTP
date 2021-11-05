package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SessionGV_Adaper extends RecyclerView.Adapter<SessionGV_Adaper.SesionGvViewHolder>{
    private List<Session_gv> mListSessionGV;

    public SessionGV_Adaper(List<Session_gv> mListSessionGV) {
        this.mListSessionGV = mListSessionGV;
    }

    @NonNull
    @Override
    public SesionGvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_khung_listview_session,parent , false);
        return new SesionGvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SesionGvViewHolder holder, int position) {
        Session_gv session_gv = mListSessionGV.get(position);
        if(session_gv == null){
            return;
        }
        holder.subject.setText(session_gv.getSubject());
        holder.classroom.setText(session_gv.getClassroom());
        holder.group.setText(session_gv.getGroup());
    }

    @Override
    public int getItemCount() {
        if(mListSessionGV != null){
            return mListSessionGV.size();
        }
        return 0;
    }

    public class SesionGvViewHolder extends RecyclerView.ViewHolder{

        private TextView subject;
        private TextView classroom;
        private TextView group;
        public SesionGvViewHolder(@NonNull View itemView) {
            super(itemView);
            subject= itemView.findViewById(R.id.tv_mamh);
            classroom = itemView.findViewById(R.id.tv_lop);
            group = itemView.findViewById(R.id.tv_nhommh);
        }
    }

}
