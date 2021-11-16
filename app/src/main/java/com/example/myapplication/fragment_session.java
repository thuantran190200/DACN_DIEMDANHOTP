package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.model.Session_gv;

import java.util.ArrayList;
import java.util.List;


public class fragment_session extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private RecyclerView rcv_sessiongv;
    private SessionGV_Adaper sessionGV_adaper;



    public fragment_session() {
        // Required empty public constructor
    }


    public static fragment_session newInstance(String param1, String param2) {
        fragment_session fragment = new fragment_session();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_session, container, false);

        rcv_sessiongv = (RecyclerView) view.findViewById(R.id.rcv_sessiongv);
        sessionGV_adaper = new SessionGV_Adaper(getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false);
        //LinearLayoutManager linearLayoutManager = new view.LinearLayoutManager(this);
        rcv_sessiongv.setLayoutManager(layoutManager);

        sessionGV_adaper.setData(getListSessionGV());
        rcv_sessiongv.setAdapter(sessionGV_adaper);
        return view;
    }
    private List<Session_gv> getListSessionGV(){
        List<Session_gv> list = new ArrayList<>();

        list.add(new Session_gv(1,"Môn học: "+("Công nghệ phần mềm"),"Lớp: "+("18DTHB4"),"Nhóm HP: "+("9")));
        list.add(new Session_gv(2,"Kiểm thử và đảm bảo chất lượng phần mềm","18DTHB3","6"));
        list.add(new Session_gv(3,"Lập trình mạng","18DTHB3","5"));
        list.add(new Session_gv(4,"Thực hành lập trình mạng","18DTHA3","2"));
        list.add(new Session_gv(5,"Kỹ năng thuyết trình và tìm việc","18DTHB9","6"));
        list.add(new Session_gv(6,"Công nghệ phần mềm","18DTHB3","10"));
        return  list;
    }

}