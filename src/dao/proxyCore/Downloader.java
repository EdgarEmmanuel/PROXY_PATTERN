package dao.proxyCore;

import dao.Video;

import java.util.HashMap;

public class Downloader {
    private ThirdParty api;

    public Downloader(ThirdParty api){
        this.api = api;
    }

    public void renderVideo(String idVideo){
        Video video=this.api.getVideo(idVideo);
        System.out.println("----- INFORMATION ---------");
        System.out.println("ID : "+video.getId());
        System.out.println("TITLE: "+video.getTitle());
        System.out.println("----------------------\n");
    }


    public void getPopularVideo(){
        HashMap<String , Video> list = this.api.popularVideos();
        list.values().forEach(
                c->{
            System.out.println("-----ID: " + c.getId() + "  ---- Title: " + c.getTitle() +"\n");
            }
        );
    }




}
