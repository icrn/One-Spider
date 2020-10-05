package cn.icrn.spider.bilibili;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yan
 * Date: 2020-10-05
 * Time: 21:03
 */
public class Video {
    private String id;//av号
    private String title;//标题
    private String author;//作者
    private String category;//类别
    private int coin;//硬币
    private int favorite;//收藏
    private int play;//播放量
    private int barrage;//弹幕
    private int comment;//评论
    //影响力：硬币+收藏+播放量+弹幕+评论
    private double fluency;

    public Video() {
    }

    public Video(String id, String title, String author, String category, int coin,
                 int favorite, int play, int barrage, int comment) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.coin = coin;
        this.favorite = favorite;
        this.play = play;
        this.barrage = barrage;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public int getPlay() {
        return play;
    }

    public void setPlay(int play) {
        this.play = play;
    }

    public int getBarrage() {
        return barrage;
    }

    public void setBarrage(int barrage) {
        this.barrage = barrage;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public double getFluency() {
        return fluency;
    }

    public void setFluency(double fluency) {
        this.fluency = fluency;
    }
}
