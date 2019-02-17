package activeobject;

class Servant implements ActiveObject {

    @Override
    public Result<String> search(String word) {
        System.out.print("search(" + word + ")");

        for (int i = 0; i < 50; i++) {
            System.out.print(".");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }

        System.out.println("found.");
        String url = "http://somewhere/" + word + ".html";
        return new RealResult<String>(url);
    }
}
