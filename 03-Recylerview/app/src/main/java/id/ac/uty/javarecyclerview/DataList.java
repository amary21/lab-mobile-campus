package id.ac.uty.javarecyclerview;

/**penggunaan not parcelabel **/
//public class DataList {
//    private int imageId;
//    private String title;
//    private String price;
//
//    public DataList(int imageId, String title, String price) {
//        this.imageId = imageId;
//        this.title = title;
//        this.price = price;
//    }
//
//    public int getImageId() {
//        return imageId;
//    }
//
//    public void setImageId(int imageId) {
//        this.imageId = imageId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//}

import android.os.Parcel;
import android.os.Parcelable;

/**penggunaan parcelable**/
public class DataList implements Parcelable {
    private int imageId;
    private String title;
    private String price;

    public DataList(int imageId, String title, String price) {
        this.imageId = imageId;
        this.title = title;
        this.price = price;
    }


    protected DataList(Parcel in) {
        imageId = in.readInt();
        title = in.readString();
        price = in.readString();
    }

    public static final Creator<DataList> CREATOR = new Creator<DataList>() {
        @Override
        public DataList createFromParcel(Parcel in) {
            return new DataList(in);
        }

        @Override
        public DataList[] newArray(int size) {
            return new DataList[size];
        }
    };

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageId);
        dest.writeString(title);
        dest.writeString(price);
    }
}
