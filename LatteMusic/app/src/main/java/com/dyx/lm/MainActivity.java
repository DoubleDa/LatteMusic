package com.dyx.lm;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_play)
    Button btnPlay;
    private Unbinder mUnbinder;
    private static final String URL_MUSIC = "http://m10.music.126.net/20171013023556/23106b2aa7861b3a1afe4ed4974a4f6d/ymusic/637e/0512/d387/631dd13b9e4d67434b435d615c4cb43b.mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
    }

    private void initView() {
        final MediaPlayer mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                return false;
            }
        });

        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mMediaPlayer.start();
            }
        });
        try {
            mMediaPlayer.setDataSource(URL_MUSIC);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mMediaPlayer.prepareAsync();
        //开始播放
        mMediaPlayer.start();
        //暂停
        mMediaPlayer.pause();
        //重置
        mMediaPlayer.reset();
        //释放
        mMediaPlayer.release();
        //异步
        mMediaPlayer.prepareAsync();
        //同步
        try {
            mMediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //是否正在播放
        mMediaPlayer.isPlaying();
        //跳转到1000ms处
        mMediaPlayer.seekTo(1000);
        //获取当前位置
        mMediaPlayer.getCurrentPosition();
        //获取文件时间
        mMediaPlayer.getDuration();
    }

    @OnClick(R.id.btn_play)
    public void onViewClicked() {
        initView();
//        Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
