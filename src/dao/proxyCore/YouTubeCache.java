package dao.proxyCore;

import dao.Video;
import dao.proxyCore.ThirdParty;
import dao.proxyCore.ThirdYoutubeClass;

import java.util.HashMap;

public class YouTubeCache implements ThirdParty {
    private ThirdParty youtubeService;
    private HashMap<String, Video> cachePopular = new HashMap<String, Video>();
    private HashMap<String, Video> cacheAll = new HashMap<String, Video>();

    public YouTubeCache(){
        this.youtubeService = new ThirdYoutubeClass();
    }
    
    @Override
    public HashMap<String, Video> popularVideos() {
        //get all the popular video in the cache
        if(cachePopular.isEmpty()){
            //if the cache is empty get all the popular from the youtube server
            this.cachePopular = this.youtubeService.popularVideos();
        }else{
            System.out.println("data from cache retrieved with success");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        //verify if the video is in the cache
        Video video = this.cacheAll.get(videoId);
        if(video==null){
            //if not get the video from the youtube service
            video = this.youtubeService.getVideo(videoId);

            //put this in the cache
            this.cacheAll.put(videoId,video);
        }else{
            System.out.println("Video "+videoId+" retrieved with success");
        }
        return video;
    }

    public void Reset(){
        this.cacheAll.clear();
        this.cachePopular.clear();
    }

}
