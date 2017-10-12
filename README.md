# LatteMusic
A Latte Music App.

## 1、MediaPlayer

```java
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
```