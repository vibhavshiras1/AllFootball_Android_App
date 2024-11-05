package com.example.football_app;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HighlightsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_highlights,container,false);
    }

    public void onViewCreated(View view,@Nullable Bundle savedInstanceState){
        VideoView videoView = (VideoView) getView().findViewById(R.id.video_View1);
        VideoView videoView1 = (VideoView) getView().findViewById(R.id.video_View2);
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.football1;
        String videoPath1 = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.football3;
        Uri uri = Uri.parse(videoPath);
        Uri uri1 = Uri.parse(videoPath1);
        videoView.setVideoURI(uri);
        videoView.seekTo(100);
        videoView1.setVideoURI(uri1);
        videoView1.seekTo(100);

        MediaController mediaController = new MediaController(getActivity());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        MediaController mediaController1 = new MediaController(getActivity());
        videoView1.setMediaController(mediaController1);
        mediaController1.setAnchorView(videoView1);

    }
}
