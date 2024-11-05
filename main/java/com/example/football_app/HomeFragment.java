package com.example.football_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home2,container,false);
    }

    ImageView imageView,image_view1;
    LinearLayout linearLayout,linearLayout1,linearLayout2;

    public void onViewCreated(View view,@Nullable Bundle savedInstanceState){

        imageView = (ImageView) getView().findViewById(R.id.imageView3);
        linearLayout = (LinearLayout) getView().findViewById(R.id.linear1);
        linearLayout1 = (LinearLayout) getView().findViewById(R.id.linear2);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),WebViewDemo.class);
                intent.putExtra("url","https://www.outlookindia.com/website/story/sports-news-rumour-has-it-tottenham-place-monster-price-tag-on-reported-manchester-city-target-harry-kane/379108");
                startActivity(intent);
            }
        });

        image_view1 = (ImageView) getView().findViewById(R.id.imageView2);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(),WebViewDemo.class);
                intent1.putExtra("url","https://theshortfuse.sbnation.com/2021/2/15/22284060/premier-league-table-season-arsenal-manchester-united-city-liverpool-chelsea-tottenham");
                startActivity(intent1);
            }
        });

        linearLayout2 = (LinearLayout) getView().findViewById(R.id.linear3);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(),WebViewDemo.class);
                intent2.putExtra("url","https://timesofindia.indiatimes.com/sports/football/top-stories/barcelona-capable-of-winning-every-game-left-says-koeman/articleshow/81924741.cms");
                startActivity(intent2);
            }
        });


    }



}
