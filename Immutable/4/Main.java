public class Main {

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("Alice", "Alaska");
        System.out.println("userinfo = " + userInfo);   
        
        StringBuffer info = userInfo.getInfo();
        info.replace(14, 19, "Bobby");
        System.out.println("userinfo = " + userInfo);  
    }
}