package profileUI;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class profileFragment extends Fragment {

    ImageView img;
    EditText txt_fullname, txt_birthday, txt_phone, txt_address;
    TextView btn_update;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        txt_fullname = view.findViewById(R.id.profile_txtname);
        txt_birthday = view.findViewById(R.id.profile_txtbirthday);
        txt_phone = view.findViewById(R.id.profile_txtmunber);
        txt_address = view.findViewById(R.id.profile_txtaddress);
        btn_update = view.findViewById(R.id.btn_updateprofile);

        return view;
    }
}
