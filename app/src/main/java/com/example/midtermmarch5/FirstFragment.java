package com.example.midtermmarch5;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FirstFragment extends Fragment {
    ImageView img1, img2, img3, img4, img5, img6;
    TextView txt_Weather, txt_Clear, txt_mintemp, txt_temp, txt_maxtemp, txt_Humidity, txt_perdictability,


    private NavController navController;


    ArrayList<ConsolidatedWeather> parray;
    RecycleAdapater adapter;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Dataservice service = RetrofitClientInstance.getRetrofitInstance().create(Dataservice.class);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        ConsolidatedWeather c = getArguments().getParcelable("data");

        img1 = view.findViewById(R.id.pkd_img1);
        img2 = view.findViewById(R.id.pkd_img);
        img3 = view.findViewById(R.id.pkd_img3);
        img4 = view.findViewById(R.id.pkd_img4);
        img5 = view.findViewById(R.id.pkd_img5);
        img6 = view.findViewById(R.id.pkd_img6);
        txt_Weather = view.findViewById(R.id.pkd_txtWeather);
        txt_Clear = view.findViewById(R.id.pkd_txtClear);
        txt_mintemp = view.findViewById(R.id.pkd_txtmintemp);
        txt_maxtemp = view.findViewById(R.id.pkd_txtmaxtemp);
        txt_temp = view.findViewById(R.id.pkd_txttemp);

        txt_Humidity = view.findViewById(R.id.pkd_txtHumidity);

        txt_perdictability = view.findViewById(R.id.pkd_txtPerdictability);

        genView(c);


        Call<Weather> call = service.getConsolidatedWeather();

        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Weather weather = response.body();
                try {

                    parray = new ArrayList<>(weather.getConsolidatedWeather());
                    //  parray = new ArrayList<>(pokemon.getPokemon());
                    generateView(parray, view);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

            }
        });
    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();


        }
    };


    public void generateView(ArrayList<ConsolidatedWeather> pary, View view) {
        adapter = new RecycleAdapater(pary, getActivity().getApplicationContext());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);


        adapter.setClickListener(onClickListener);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_first, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public void genView( ConsolidatedWeather c) {
        Picasso.get().load(c.getImage()).into(img1);
        Picasso.get().load(c.getImage()).into(img2);
        Picasso.get().load(c.getImage()).into(img3);
        Picasso.get().load(c.getImage()).into(img4);
        Picasso.get().load(c.getImage()).into(img5);
        Picasso.get().load(c.getImage()).into(img6);
        txt_Weather.setText(c.getWeatherStateAbbr());


    }

}
