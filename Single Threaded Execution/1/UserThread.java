public class UserThread extends Thread {
    private final Gate gate;
    private final String myname;
    private final String myaddress;

    public UserThread(Gate gate, String name, String address) {
        this.gate = gate;
        this.myname = name;
        this.myaddress = address;
    }

    public void run() {
        System.out.println(myname + " BEGIN");
        
        while (true) {
            gate.pass(myname, myaddress);
        }
    }
}