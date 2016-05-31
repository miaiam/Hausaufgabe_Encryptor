/**
 * Created by Mia on 31.05.16.
 */
public class Encryptor {

    private EncryptorStrategy encryptorStrategy;

    public void setEncryptorStrategy(EncryptorStrategy encryptorStrategy){
        this.encryptorStrategy = encryptorStrategy;
    }

    public String encrypt(String string){
        return encryptorStrategy.encrypt(string);
    }

    public String decrypt(String string){
        return encryptorStrategy.decrypt(string);
    }
}
