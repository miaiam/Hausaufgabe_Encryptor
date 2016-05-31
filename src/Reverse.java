/**
 * Created by Mia on 31.05.16.
 */
public class Reverse implements EncryptorStrategy{

    public String encrypt(String string){
        return new StringBuilder(string).reverse().toString();
    }

    public String decrypt(String string){
        return new StringBuilder(string).reverse().toString();
    }
}
