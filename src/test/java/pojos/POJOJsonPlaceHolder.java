package pojos;

public class POJOJsonPlaceHolder {
    /*
     {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    //1.adim : objemizi icinde var olan tum key degerlerini private variable olarak tanimlayalim

    private String title;
    private String body;
    private  int userId;
    private int id;

    //2.adim:getter ve setter hazirla


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //3.adim:Tum parametreleri iceren constructor create et

    public POJOJsonPlaceHolder(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }
  //4.adim:parametresiz constructor create edelim
    public POJOJsonPlaceHolder() {
    }

    //5.adim:toString() methodu create edelim


    @Override
    public String toString() {
        return "POJOJsonPlaceHolder{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }


}
