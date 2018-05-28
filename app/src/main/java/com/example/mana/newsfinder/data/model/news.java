package com.example.mana.newsfinder.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class news implements Parcelable {
  protected news(Parcel in) {
    listArticles = in.createTypedArrayList(articles.CREATOR);
  }

  public static final Creator<news> CREATOR = new Creator<news>() {
    @Override
    public news createFromParcel(Parcel in) {
      return new news(in);
    }

    @Override
    public news[] newArray(int size) {
      return new news[size];
    }
  };

  public List<articles> getListArticles() {
    return listArticles;
  }

  public void setListArticles(
      List<articles> listArticles) {
    this.listArticles = listArticles;
  }

  @Expose
  @SerializedName("articles")
  private List<articles> listArticles;

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeTypedList(listArticles);
  }

  public static class articles implements Parcelable {
    @Expose
    @SerializedName("author")
    private String author;

    @Expose
    @SerializedName("title")
    private String newsTitle;

    @Expose
    @SerializedName("url")
    private String newsUrl;

    @Expose
    @SerializedName("urlToImage")
    private String imgUrl;

    @Expose
    @SerializedName("publishedAt")
    private Date publishDate;

    protected articles(Parcel in) {
      author = in.readString();
      newsTitle = in.readString();
      newsUrl = in.readString();
      imgUrl = in.readString();
    }

    public static final Creator<articles> CREATOR = new Creator<articles>() {
      @Override
      public articles createFromParcel(Parcel in) {
        return new articles(in);
      }

      @Override
      public articles[] newArray(int size) {
        return new articles[size];
      }
    };

    public String getAuthor() {
      return author;
    }

    public void setAuthor(String author) {
      this.author = author;
    }

    public String getNewsTitle() {
      return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
      this.newsTitle = newsTitle;
    }

    public String getNewsUrl() {
      return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
      this.newsUrl = newsUrl;
    }

    public String getImgUrl() {
      return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
      this.imgUrl = imgUrl;
    }

    public Date getPublishDate() {
      return publishDate;
    }

    public void setPublishDate(Date publishDate) {
      this.publishDate = publishDate;
    }

    @Override public int describeContents() {
      return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(author);
      dest.writeString(newsTitle);
      dest.writeString(newsUrl);
      dest.writeString(imgUrl);
    }
  }
}
