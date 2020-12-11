package dao.proxyCore;

import dao.Video;
import java.util.HashMap;

public interface ThirdParty {
    HashMap<String, Video> popularVideos();
    Video getVideo(String videoId);
}
