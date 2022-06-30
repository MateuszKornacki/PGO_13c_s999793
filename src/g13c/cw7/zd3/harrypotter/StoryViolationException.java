package g13c.cw7.zd3.harrypotter;

public class StoryViolationException extends RuntimeException{

    public StoryViolationException(String message){
        super(message);
    }

    public void printMessage(){
        System.out.println(getMessage());
    }
}
