package activeobject;

import java.math.BigInteger;

class Servant implements ActiveObject {

    @Override
    public Result<String> add(String x, String y) {
        String retvalue = null;

        try {
            BigInteger bigX = new BigInteger(x);
            BigInteger bigY = new BigInteger(y);
            BigInteger bigZ = bigX.add(bigY);
            retvalue = bigZ.toString();
        } catch (NumberFormatException e) {
            retvalue = null;
        }

        return new RealResult<String>(retvalue);
    }
}
