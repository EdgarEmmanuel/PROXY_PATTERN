package dao.Home;

import dao.proxyCore.Downloader;
import dao.proxyCore.ThirdYoutubeClass;
import dao.proxyCore.YouTubeCache;

public class Main {
    public static void main(String[] args){
        Downloader first = new Downloader(new ThirdYoutubeClass());
        Downloader second = new Downloader(new YouTubeCache());

        long youtubedirectly = test(first,"Youtube Service");
        long proxyServicebefore = test(second,"Service before Youtube service");

        System.out.println("Time saved by the proxy cache :"+(youtubedirectly-proxyServicebefore)+" ms\n");
    }

    public static long test(Downloader download,String value){
        long startTime = System.currentTimeMillis();

        //we search recurrent video
        download.renderVideo("catzzzzzzzzz");
        download.getPopularVideo();

        //now i search a new video
        download.renderVideo("devByJESUS");
        download.getPopularVideo();

        long finaleTime= System.currentTimeMillis() - startTime;
        System.out.println("For "+value+" --- Time passed : "+finaleTime+" ms\n");

        return finaleTime;
    }
}
